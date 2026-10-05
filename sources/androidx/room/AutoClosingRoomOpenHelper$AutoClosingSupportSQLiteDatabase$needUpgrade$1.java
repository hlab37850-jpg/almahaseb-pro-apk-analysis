package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ int $newVersion;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1(int i) {
        super(1);
        this.$newVersion = i;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
        AbstractC4492zt.h(supportSQLiteDatabase, "db");
        return Boolean.valueOf(supportSQLiteDatabase.needUpgrade(this.$newVersion));
    }
}
