package com.google.android.gms.phenotype;

import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.phenotype.zzd;
import com.google.android.gms.internal.phenotype.zze;
import defpackage.C1895cg0;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class Phenotype {

    @Deprecated
    private static final Api<Api.ApiOptions.NoOptions> API;
    private static final Api.AbstractClientBuilder<zze, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
    private static final Api.ClientKey<zze> CLIENT_KEY;

    @Deprecated
    private static final zzm zzaj;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.phenotype.zzd, com.google.android.gms.phenotype.zzm] */
    static {
        Api.ClientKey<zze> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        C1895cg0 c1895cg0 = new C1895cg0();
        CLIENT_BUILDER = c1895cg0;
        API = new Api<>("Phenotype.API", c1895cg0, clientKey);
        zzaj = new zzd();
    }

    private Phenotype() {
    }

    @KeepForSdk
    public static Uri getContentProviderUri(String str) {
        String strValueOf = String.valueOf(Uri.encode(str));
        return Uri.parse(strValueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(strValueOf) : new String("content://com.google.android.gms.phenotype/"));
    }
}
