package androidx.core.view;

import android.view.ViewParent;
import defpackage.C0916Sp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class ViewKt$ancestors$1 extends C0916Sp implements InterfaceC3750qp {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    public ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    @Override // defpackage.InterfaceC3750qp
    public final ViewParent invoke(ViewParent viewParent) {
        return viewParent.getParent();
    }
}
