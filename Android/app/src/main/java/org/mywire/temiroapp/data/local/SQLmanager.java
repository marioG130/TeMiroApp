package org.mywire.temiroapp.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SQLmanager {

    private SQLconexion conex;
    private SQLiteDatabase dblite;

    public SQLmanager(Context ctx) {
        conex = new SQLconexion(ctx);
    }

}
