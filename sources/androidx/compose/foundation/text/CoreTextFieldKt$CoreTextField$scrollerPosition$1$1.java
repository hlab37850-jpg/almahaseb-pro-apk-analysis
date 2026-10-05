package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class CoreTextFieldKt$CoreTextField$scrollerPosition$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ Orientation $orientation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(Orientation orientation) {
        super(0);
        this.$orientation = orientation;
    }

    @Override // defpackage.InterfaceC3588op
    public final TextFieldScrollerPosition invoke() {
        return new TextFieldScrollerPosition(this.$orientation, 0.0f, 2, null);
    }
}
