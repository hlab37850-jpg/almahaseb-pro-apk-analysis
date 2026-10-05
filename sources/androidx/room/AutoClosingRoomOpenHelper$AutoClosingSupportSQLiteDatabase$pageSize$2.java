package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ long $numBytes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$2(long j) {
        super(1);
        this.$numBytes = j;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
        AbstractC4492zt.h(supportSQLiteDatabase, "db");
        supportSQLiteDatabase.setPageSize(this.$numBytes);
        return null;
    }
}
