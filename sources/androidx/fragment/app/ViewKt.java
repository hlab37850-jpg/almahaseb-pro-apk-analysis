package androidx.fragment.app;

import android.view.View;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View view) {
        AbstractC4492zt.h(view, "$this$findFragment");
        F f = (F) FragmentManager.findFragment(view);
        AbstractC4492zt.g(f, "FragmentManager.findFragment(this)");
        return f;
    }
}
