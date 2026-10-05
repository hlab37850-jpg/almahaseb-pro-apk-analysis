package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes2.dex */
public final class SharedSQLiteStatement$stmt$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ SharedSQLiteStatement this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedSQLiteStatement$stmt$2(SharedSQLiteStatement sharedSQLiteStatement) {
        super(0);
        this.this$0 = sharedSQLiteStatement;
    }

    @Override // defpackage.InterfaceC3588op
    public final SupportSQLiteStatement invoke() {
        return this.this$0.createNewStatement();
    }
}
