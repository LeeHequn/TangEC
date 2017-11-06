package com.tepth.latte.net;

import android.content.Context;

import com.tepth.latte.net.callback.IError;
import com.tepth.latte.net.callback.IFailure;
import com.tepth.latte.net.callback.IRequest;
import com.tepth.latte.net.callback.ISuccess;
import com.tepth.latte.net.callback.RequestCallbacks;
import com.tepth.latte.net.download.DownloadHandler;
import com.tepth.latte.ui.LatteLoader;
import com.tepth.latte.ui.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * 网络请求方法
 *
 * @author Hequn.Lee
 * @date 2017/11/06
 */

@SuppressWarnings({"WeakerAccess", "UnusedAssignment", "unused"})
public class RestClient {

    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    private final File FILE;
    private final LoaderStyle LOADERSYTLE;
    private final Context CONTEXT;


    public RestClient(String url,
                      Map<String, Object> params,
                      IRequest request,
                      ISuccess success,
                      IFailure failure,
                      IError error,
                      RequestBody body,
                      File file,
                      String dir,
                      String extension,
                      String name,
                      Context context,
                      LoaderStyle loaderStyle) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
        this.FILE = file;
        this.DOWNLOAD_DIR = dir;
        this.EXTENSION = extension;
        this.NAME = name;
        this.CONTEXT = context;
        this.LOADERSYTLE = loaderStyle;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    /**
     * 写一个Request请求
     *
     * @param method 请求的枚举类型
     */
    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if (REQUEST != null) {
            REQUEST.onRequestStart();//请求开始的回调
        }

        //显示菊花
        if (LOADERSYTLE != null) {
            LatteLoader.showLoading(CONTEXT, LOADERSYTLE);
        }

        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
            case POST_RAW:
                call = service.post_raw(URL, BODY);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case PUT_RAW:
                call = service.put_raw(URL, BODY);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody =
                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body =
                        MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                call = RestCreator.getRestService().upload(URL, body);
                break;
            default:
                break;
        }
        if (call != null) {
            //call.execute在主线程中执行，需要新起一个线程，并try一个IO异常
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback() {
        return new RequestCallbacks(
                REQUEST,
                SUCCESS,
                FAILURE,
                ERROR,
                LOADERSYTLE
        );
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        //采用的是传参的POST请求
        if (BODY == null) {
            request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null");
            }
            request(HttpMethod.POST_RAW);
        }

    }

    public final void put() {
        //采用的是传参的POST请求
        if (BODY == null) {
            request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null");
            }
            request(HttpMethod.PUT_RAW);
        }
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }

    public final void download() {
        new DownloadHandler(URL, REQUEST, DOWNLOAD_DIR, EXTENSION, NAME, SUCCESS, FAILURE, ERROR).handlerDownload();
    }
}
