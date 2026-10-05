package androidx.savedstate;

import android.view.View;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewKt {
    public static final /* synthetic */ SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(View view) {
        AbstractC4492zt.h(view, "<this>");
        return ViewTreeSavedStateRegistryOwner.get(view);
    }
}
