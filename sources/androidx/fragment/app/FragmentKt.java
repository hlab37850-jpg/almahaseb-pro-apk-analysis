package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentKt {
    public static final void clearFragmentResult(Fragment fragment, String str) {
        AbstractC4492zt.h(fragment, "$this$clearFragmentResult");
        AbstractC4492zt.h(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResult(str);
    }

    public static final void clearFragmentResultListener(Fragment fragment, String str) {
        AbstractC4492zt.h(fragment, "$this$clearFragmentResultListener");
        AbstractC4492zt.h(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResultListener(str);
    }

    public static final void setFragmentResult(Fragment fragment, String str, Bundle bundle) {
        AbstractC4492zt.h(fragment, "$this$setFragmentResult");
        AbstractC4492zt.h(str, "requestKey");
        AbstractC4492zt.h(bundle, "result");
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    public static final void setFragmentResultListener(Fragment fragment, String str, final InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(fragment, "$this$setFragmentResultListener");
        AbstractC4492zt.h(str, "requestKey");
        AbstractC4492zt.h(interfaceC0526Fp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new FragmentResultListener() { // from class: androidx.fragment.app.FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0
            @Override // androidx.fragment.app.FragmentResultListener
            public final /* synthetic */ void onFragmentResult(@NonNull String str2, @NonNull Bundle bundle) {
                AbstractC4492zt.h(str2, "p0");
                AbstractC4492zt.h(bundle, "p1");
                AbstractC4492zt.g(interfaceC0526Fp.mo13invoke(str2, bundle), "invoke(...)");
            }
        });
    }
}
