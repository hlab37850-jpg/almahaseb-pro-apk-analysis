package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;
import defpackage.AbstractC4492zt;
import defpackage.DO;
import defpackage.FO;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewTreeLifecycleOwner {
    public static final LifecycleOwner get(View view) {
        AbstractC4492zt.h(view, "<this>");
        return (LifecycleOwner) FO.n(FO.s(DO.g(view, ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1.INSTANCE), ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2.INSTANCE));
    }

    public static final void set(View view, LifecycleOwner lifecycleOwner) {
        AbstractC4492zt.h(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
