package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForLong$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForLong$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForLong$1();

    public AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForLong$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Long invoke(SupportSQLiteStatement supportSQLiteStatement) {
        AbstractC4492zt.h(supportSQLiteStatement, "obj");
        return Long.valueOf(supportSQLiteStatement.simpleQueryForLong());
    }
}
