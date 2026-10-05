package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import defpackage.AbstractC0703Ks;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase sQLiteDatabase, boolean z, InterfaceC3750qp interfaceC3750qp) {
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T t = (T) interfaceC3750qp.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return t;
        } finally {
            AbstractC0703Ks.b(1);
            sQLiteDatabase.endTransaction();
            AbstractC0703Ks.a(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object objInvoke = interfaceC3750qp.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return objInvoke;
        } finally {
            AbstractC0703Ks.b(1);
            sQLiteDatabase.endTransaction();
            AbstractC0703Ks.a(1);
        }
    }
}
