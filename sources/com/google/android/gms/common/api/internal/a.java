package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import defpackage.R20;
import defpackage.U20;
import defpackage.V20;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements zaca {
    public final Context a;
    public final zabe b;
    public final Looper c;
    public final zabi d;
    public final zabi e;
    public final Map f;
    public final Api.Client h;
    public Bundle i;
    public final Lock m;
    public final Set g = Collections.newSetFromMap(new WeakHashMap());
    public ConnectionResult j = null;
    public ConnectionResult k = null;
    public boolean l = false;
    public int n = 0;

    public a(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, Map map2, ClientSettings clientSettings, Api.AbstractClientBuilder abstractClientBuilder, Api.Client client, ArrayList arrayList, ArrayList arrayList2, Map map3, Map map4) {
        this.a = context;
        this.b = zabeVar;
        this.m = lock;
        this.c = looper;
        this.h = client;
        this.d = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, new U20(this, null));
        this.e = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, new V20(this, null));
        ArrayMap arrayMap = new ArrayMap();
        Iterator it = map2.keySet().iterator();
        while (it.hasNext()) {
            arrayMap.put((Api.AnyClientKey) it.next(), this.d);
        }
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            arrayMap.put((Api.AnyClientKey) it2.next(), this.e);
        }
        this.f = Collections.unmodifiableMap(arrayMap);
    }

    public static boolean e(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    public static a g(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, ClientSettings clientSettings, Map map2, Api.AbstractClientBuilder abstractClientBuilder, ArrayList arrayList) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry entry : map.entrySet()) {
            Api.Client client2 = (Api.Client) entry.getValue();
            if (true == client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                arrayMap.put((Api.AnyClientKey) entry.getKey(), client2);
            } else {
                arrayMap2.put((Api.AnyClientKey) entry.getKey(), client2);
            }
        }
        Preconditions.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            Api.AnyClientKey anyClientKeyZab = api.zab();
            if (arrayMap.containsKey(anyClientKeyZab)) {
                arrayMap3.put(api, (Boolean) map2.get(api));
            } else {
                if (!arrayMap2.containsKey(anyClientKeyZab)) {
                    throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                }
                arrayMap4.put(api, (Boolean) map2.get(api));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zat zatVar = (zat) arrayList.get(i);
            if (arrayMap3.containsKey(zatVar.zaa)) {
                arrayList2.add(zatVar);
            } else {
                if (!arrayMap4.containsKey(zatVar.zaa)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                }
                arrayList3.add(zatVar);
            }
        }
        return new a(context, zabeVar, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    public static /* bridge */ /* synthetic */ void n(a aVar, int i, boolean z) {
        aVar.b.zac(i, z);
        aVar.k = null;
        aVar.j = null;
    }

    public static /* bridge */ /* synthetic */ void o(a aVar, Bundle bundle) {
        Bundle bundle2 = aVar.i;
        if (bundle2 == null) {
            aVar.i = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    public static /* bridge */ /* synthetic */ void p(a aVar) {
        ConnectionResult connectionResult;
        if (!e(aVar.j)) {
            if (aVar.j != null && e(aVar.k)) {
                aVar.e.zar();
                aVar.a((ConnectionResult) Preconditions.checkNotNull(aVar.j));
                return;
            }
            ConnectionResult connectionResult2 = aVar.j;
            if (connectionResult2 == null || (connectionResult = aVar.k) == null) {
                return;
            }
            if (aVar.e.zaf < aVar.d.zaf) {
                connectionResult2 = connectionResult;
            }
            aVar.a(connectionResult2);
            return;
        }
        if (e(aVar.k) || aVar.c()) {
            int i = aVar.n;
            if (i == 1) {
                aVar.b();
            } else if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
            } else {
                ((zabe) Preconditions.checkNotNull(aVar.b)).zab(aVar.i);
                aVar.b();
            }
            aVar.n = 0;
            return;
        }
        ConnectionResult connectionResult3 = aVar.k;
        if (connectionResult3 != null) {
            if (aVar.n == 1) {
                aVar.b();
            } else {
                aVar.a(connectionResult3);
                aVar.d.zar();
            }
        }
    }

    public final void a(ConnectionResult connectionResult) {
        int i = this.n;
        if (i == 1) {
            b();
        } else if (i != 2) {
            Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
        } else {
            this.b.zaa(connectionResult);
            b();
        }
        this.n = 0;
    }

    public final void b() {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((SignInConnectionListener) it.next()).onComplete();
        }
        this.g.clear();
    }

    public final boolean c() {
        ConnectionResult connectionResult = this.k;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    public final boolean d(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zabi zabiVar = (zabi) this.f.get(apiMethodImpl.getClientKey());
        Preconditions.checkNotNull(zabiVar, "GoogleApiClient is not configured to use the API required for this call.");
        return zabiVar.equals(this.e);
    }

    public final PendingIntent r() {
        Api.Client client = this.h;
        if (client == null) {
            return null;
        }
        return PendingIntent.getActivity(this.a, System.identityHashCode(this.b), client.getSignInIntent(), com.google.android.gms.internal.base.zap.zaa | 134217728);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zab() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zac(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final ConnectionResult zad(Api api) {
        if (Objects.equal(this.f.get(api.zab()), this.e)) {
            return c() ? new ConnectionResult(4, r()) : this.e.zad(api);
        }
        return this.d.zad(api);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final BaseImplementation.ApiMethodImpl zae(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (!d(apiMethodImpl)) {
            this.d.zae(apiMethodImpl);
            return apiMethodImpl;
        }
        if (c()) {
            apiMethodImpl.setFailedResult(new Status(4, (String) null, r()));
            return apiMethodImpl;
        }
        this.e.zae(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final BaseImplementation.ApiMethodImpl zaf(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (!d(apiMethodImpl)) {
            return this.d.zaf(apiMethodImpl);
        }
        if (!c()) {
            return this.e.zaf(apiMethodImpl);
        }
        apiMethodImpl.setFailedResult(new Status(4, (String) null, r()));
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zaq() {
        this.n = 2;
        this.l = false;
        this.k = null;
        this.j = null;
        this.d.zaq();
        this.e.zaq();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zar() {
        this.k = null;
        this.j = null;
        this.n = 0;
        this.d.zar();
        this.e.zar();
        b();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zas(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.e.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.d.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zat() {
        this.d.zat();
        this.e.zat();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void zau() {
        this.m.lock();
        try {
            boolean zZax = zax();
            this.e.zar();
            this.k = new ConnectionResult(4);
            if (zZax) {
                new com.google.android.gms.internal.base.zau(this.c).post(new R20(this));
            } else {
                b();
            }
        } finally {
            this.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zaw() {
        this.m.lock();
        try {
            boolean z = false;
            if (this.d.zaw() && (this.e.zaw() || c() || this.n == 1)) {
                z = true;
            }
            return z;
        } finally {
            this.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zax() {
        this.m.lock();
        try {
            return this.n == 2;
        } finally {
            this.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean zay(SignInConnectionListener signInConnectionListener) {
        this.m.lock();
        try {
            boolean z = false;
            if (zax() || zaw()) {
                if (!this.e.zaw()) {
                    this.g.add(signInConnectionListener);
                    z = true;
                    if (this.n == 0) {
                        this.n = 1;
                    }
                    this.k = null;
                    this.e.zaq();
                }
            }
            return z;
        } finally {
            this.m.unlock();
        }
    }
}
