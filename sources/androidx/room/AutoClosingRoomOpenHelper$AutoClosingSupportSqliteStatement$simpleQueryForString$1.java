package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1();

    public AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final String invoke(SupportSQLiteStatement supportSQLiteStatement) {
        AbstractC4492zt.h(supportSQLiteStatement, "obj");
        return supportSQLiteStatement.simpleQueryForString();
    }
}
