package com.tepth.latte.net;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/** 网络请求框架工具方法
 * Created by LHQ on 2017/9/29.
 */

public interface RestService{

        @GET
        Call<String> get(@Url String url, @QueryMap Map<String, Object> params);

        @FormUrlEncoded
        @POST
        Call<String> post(@Url String url, @FieldMap Map<String, Object> params);

        @FormUrlEncoded
        @PUT
        Call<String> put(@Url String url, @FieldMap Map<String, Object> params);

        @DELETE
        Call<String> delete(@Url String url, @QueryMap Map<String, Object> params);

        @Streaming//加上这个就不会出现写入过长的数据造成的内存溢出
        @GET
        Call<ResponseBody> download(@Url String url, @QueryMap Map<String, Object> params);

        @Multipart
        @POST
        Call<String> upload(@Url String url, @Part MultipartBody.Part file);
}