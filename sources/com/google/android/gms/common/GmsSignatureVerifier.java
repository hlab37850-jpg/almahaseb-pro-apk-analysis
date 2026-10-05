package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.RestrictedInheritance;
import defpackage.Oi0;
import defpackage.U30;
import defpackage.Xg0;
import defpackage.Zf0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*javatests/com/google/android/gmscore/integ/client/common/robolectric/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class GmsSignatureVerifier {
    private static final U30 zza;
    private static final U30 zzb;
    private static final HashMap zzc;

    static {
        Oi0 oi0 = new Oi0();
        oi0.d("com.google.android.gms");
        oi0.a(204200000L);
        Zf0 zf0 = Xg0.d;
        oi0.c(zzag.zzn(zf0.t(), Xg0.b.t()));
        Zf0 zf1 = Xg0.c;
        oi0.b(zzag.zzn(zf1.t(), Xg0.a.t()));
        zza = oi0.e();
        Oi0 oi1 = new Oi0();
        oi1.d("com.android.vending");
        oi1.a(82240000L);
        oi1.c(zzag.zzm(zf0.t()));
        oi1.b(zzag.zzm(zf1.t()));
        zzb = oi1.e();
        zzc = new HashMap();
    }
}
