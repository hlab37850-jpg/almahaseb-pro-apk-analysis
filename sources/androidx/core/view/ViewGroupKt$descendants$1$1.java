package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4362yO;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewGroupKt$descendants$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final ViewGroupKt$descendants$1$1 INSTANCE = new ViewGroupKt$descendants$1$1();

    public ViewGroupKt$descendants$1$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Iterator<View> invoke(View view) {
        InterfaceC4362yO children;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null || (children = ViewGroupKt.getChildren(viewGroup)) == null) {
            return null;
        }
        return children.iterator();
    }
}
