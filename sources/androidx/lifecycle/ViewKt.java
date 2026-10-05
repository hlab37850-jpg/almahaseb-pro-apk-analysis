package androidx.lifecycle;

import android.view.View;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewKt {
    public static final /* synthetic */ LifecycleOwner findViewTreeLifecycleOwner(View view) {
        AbstractC4492zt.h(view, "<this>");
        return ViewTreeLifecycleOwner.get(view);
    }
}
