package androidx.lifecycle;

import android.view.View;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1 INSTANCE = new ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1();

    public ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final View invoke(View view) {
        AbstractC4492zt.h(view, "currentView");
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
