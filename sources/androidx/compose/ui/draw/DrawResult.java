package androidx.compose.ui.draw;

import androidx.compose.runtime.internal.StabilityInferred;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class DrawResult {
    public static final int $stable = 8;
    private InterfaceC3750qp block;

    public DrawResult(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        this.block = interfaceC3750qp;
    }

    public final InterfaceC3750qp getBlock$ui_release() {
        return this.block;
    }

    public final void setBlock$ui_release(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "<set-?>");
        this.block = interfaceC3750qp;
    }
}
