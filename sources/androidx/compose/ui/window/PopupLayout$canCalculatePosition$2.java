package androidx.compose.ui.window;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class PopupLayout$canCalculatePosition$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ PopupLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupLayout$canCalculatePosition$2(PopupLayout popupLayout) {
        super(0);
        this.this$0 = popupLayout;
    }

    @Override // defpackage.InterfaceC3588op
    public final Boolean invoke() {
        return Boolean.valueOf((this.this$0.getParentLayoutCoordinates() == null || this.this$0.m5412getPopupContentSizebOM6tXw() == null) ? false : true);
    }
}
