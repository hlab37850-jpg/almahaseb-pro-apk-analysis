package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2 INSTANCE = new ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2();

    public ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final LifecycleOwner invoke(View view) {
        AbstractC4492zt.h(view, "viewParent");
        Object tag = view.getTag(R.id.view_tree_lifecycle_owner);
        if (tag instanceof LifecycleOwner) {
            return (LifecycleOwner) tag;
        }
        return null;
    }
}
