package androidx.room;

import android.content.ContentValues;
import androidx.sqlite.db.SupportSQLiteDatabase;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$insert$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ int $conflictAlgorithm;
    final /* synthetic */ String $table;
    final /* synthetic */ ContentValues $values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$insert$1(String str, int i, ContentValues contentValues) {
        super(1);
        this.$table = str;
        this.$conflictAlgorithm = i;
        this.$values = contentValues;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Long invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
        AbstractC4492zt.h(supportSQLiteDatabase, "db");
        return Long.valueOf(supportSQLiteDatabase.insert(this.$table, this.$conflictAlgorithm, this.$values));
    }
}
