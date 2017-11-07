package com.tepth.latte.ec.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

/**
 * Description:数据库的SqLitOpenHelper
 *
 * @author Hequn.Lee
 * @date 2017/11/7
 */

@SuppressWarnings("ALL")
public class ReleaseOpenHelper extends DaoMaster.OpenHelper {

    public ReleaseOpenHelper(Context context, String name) {
        super(context, name);
    }

    public ReleaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }
}
