package androidx.lifecycle;

import android.view.View;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewTreeViewModelKt {
    public static final /* synthetic */ ViewModelStoreOwner findViewTreeViewModelStoreOwner(View view) {
        AbstractC4492zt.h(view, "view");
        return ViewTreeViewModelStoreOwner.get(view);
    }
}
