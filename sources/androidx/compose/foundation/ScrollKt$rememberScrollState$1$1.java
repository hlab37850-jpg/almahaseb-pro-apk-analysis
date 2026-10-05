package androidx.compose.foundation;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollKt$rememberScrollState$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ int $initial;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollKt$rememberScrollState$1$1(int i) {
        super(0);
        this.$initial = i;
    }

    @Override // defpackage.InterfaceC3588op
    public final ScrollState invoke() {
        return new ScrollState(this.$initial);
    }
}
