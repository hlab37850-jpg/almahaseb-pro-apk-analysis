package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.common.api.internal.zabz;
import com.google.android.gms.common.api.internal.zaw;

/* JADX INFO: loaded from: classes2.dex */
public final class U20 implements zabz {
    public final /* synthetic */ a a;

    public /* synthetic */ U20(a aVar, zaw zawVar) {
        this.a = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zaa(ConnectionResult connectionResult) {
        this.a.m.lock();
        try {
            this.a.j = connectionResult;
            a.p(this.a);
        } finally {
            this.a.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zab(Bundle bundle) {
        this.a.m.lock();
        try {
            a.o(this.a, bundle);
            this.a.j = ConnectionResult.RESULT_SUCCESS;
            a.p(this.a);
        } finally {
            this.a.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zac(int i, boolean z) {
        this.a.m.lock();
        try {
            a aVar = this.a;
            if (aVar.l || aVar.k == null || !aVar.k.isSuccess()) {
                this.a.l = false;
                a.n(this.a, i, z);
            } else {
                this.a.l = true;
                this.a.e.onConnectionSuspended(i);
            }
        } finally {
            this.a.m.unlock();
        }
    }
}
