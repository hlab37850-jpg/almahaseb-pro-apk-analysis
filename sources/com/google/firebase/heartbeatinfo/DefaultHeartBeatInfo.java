package com.google.firebase.heartbeatinfo;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import defpackage.C0571Hi;
import defpackage.C4156vr;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultHeartBeatInfo implements HeartBeatInfo {
    private C4156vr storage;

    private DefaultHeartBeatInfo(Context context) {
        this.storage = C4156vr.a(context);
    }

    @NonNull
    public static Component<HeartBeatInfo> component() {
        return Component.builder(HeartBeatInfo.class).add(Dependency.required(Context.class)).factory(C0571Hi.a()).build();
    }

    public static /* synthetic */ HeartBeatInfo lambda$component$0(ComponentContainer componentContainer) {
        return new DefaultHeartBeatInfo((Context) componentContainer.get(Context.class));
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    @NonNull
    public HeartBeatInfo.HeartBeat getHeartBeatCode(@NonNull String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zC = this.storage.c(str, jCurrentTimeMillis);
        boolean zB = this.storage.b(jCurrentTimeMillis);
        if (zC && zB) {
            return HeartBeatInfo.HeartBeat.COMBINED;
        }
        if (zB) {
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        return zC ? HeartBeatInfo.HeartBeat.SDK : HeartBeatInfo.HeartBeat.NONE;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @VisibleForTesting
    public DefaultHeartBeatInfo(C4156vr c4156vr) {
        this.storage = c4156vr;
    }
}
