package androidx.compose.foundation;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollState$canScrollBackward$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ ScrollState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollState$canScrollBackward$2(ScrollState scrollState) {
        super(0);
        this.this$0 = scrollState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Boolean invoke() {
        return Boolean.valueOf(this.this$0.getValue() > 0);
    }
}
