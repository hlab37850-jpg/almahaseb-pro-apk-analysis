package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;

/* JADX INFO: renamed from: l20, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3277l20 implements InterfaceC4252x20 {
    public final /* synthetic */ FrameLayout a;
    public final /* synthetic */ LayoutInflater b;
    public final /* synthetic */ ViewGroup c;
    public final /* synthetic */ Bundle d;
    public final /* synthetic */ DeferredLifecycleHelper e;

    public C3277l20(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = deferredLifecycleHelper;
        this.a = frameLayout;
        this.b = layoutInflater;
        this.c = viewGroup;
        this.d = bundle;
    }

    @Override // defpackage.InterfaceC4252x20
    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.a.removeAllViews();
        this.a.addView(this.e.zaa.onCreateView(this.b, this.c, this.d));
    }

    @Override // defpackage.InterfaceC4252x20
    public final int zaa() {
        return 2;
    }
}
