package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import defpackage.AbstractC0419Di;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class VNode {
    public static final int $stable = 8;
    private InterfaceC3588op invalidateListener;

    public /* synthetic */ VNode(AbstractC0419Di abstractC0419Di) {
        this();
    }

    public abstract void draw(DrawScope drawScope);

    public InterfaceC3588op getInvalidateListener$ui_release() {
        return this.invalidateListener;
    }

    public final void invalidate() {
        InterfaceC3588op invalidateListener$ui_release = getInvalidateListener$ui_release();
        if (invalidateListener$ui_release != null) {
            invalidateListener$ui_release.invoke();
        }
    }

    public void setInvalidateListener$ui_release(InterfaceC3588op interfaceC3588op) {
        this.invalidateListener = interfaceC3588op;
    }

    private VNode() {
    }
}
