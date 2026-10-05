package androidx.compose.ui.viewinterop;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidViewHolder$runUpdate$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$runUpdate$1(AndroidViewHolder androidViewHolder) {
        super(0);
        this.this$0 = androidViewHolder;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m5399invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m5399invoke() {
        if (this.this$0.hasUpdateBlock) {
            SnapshotStateObserver snapshotStateObserver = this.this$0.snapshotObserver;
            AndroidViewHolder androidViewHolder = this.this$0;
            snapshotStateObserver.observeReads(androidViewHolder, androidViewHolder.onCommitAffectingUpdate, this.this$0.getUpdate());
        }
    }
}
