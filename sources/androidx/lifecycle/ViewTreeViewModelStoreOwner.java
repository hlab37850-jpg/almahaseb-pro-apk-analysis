package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R;
import defpackage.AbstractC4492zt;
import defpackage.DO;
import defpackage.FO;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewTreeViewModelStoreOwner {
    public static final ViewModelStoreOwner get(View view) {
        AbstractC4492zt.h(view, "<this>");
        return (ViewModelStoreOwner) FO.n(FO.s(DO.g(view, ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1.INSTANCE), ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2.INSTANCE));
    }

    public static final void set(View view, ViewModelStoreOwner viewModelStoreOwner) {
        AbstractC4492zt.h(view, "<this>");
        view.setTag(R.id.view_tree_view_model_store_owner, viewModelStoreOwner);
    }
}
