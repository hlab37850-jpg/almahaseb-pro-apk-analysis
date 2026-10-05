package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollableKt;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class AbstractClickablePointerInputNode$delayPressInteraction$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ AbstractClickablePointerInputNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClickablePointerInputNode$delayPressInteraction$1(AbstractClickablePointerInputNode abstractClickablePointerInputNode) {
        super(0);
        this.this$0 = abstractClickablePointerInputNode;
    }

    @Override // defpackage.InterfaceC3588op
    public final Boolean invoke() {
        return Boolean.valueOf(((Boolean) this.this$0.getCurrent(ScrollableKt.getModifierLocalScrollableContainer())).booleanValue() || Clickable_androidKt.isComposeRootInScrollableContainer(this.this$0));
    }
}
