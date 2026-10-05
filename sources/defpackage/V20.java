package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.common.api.internal.zabz;
import com.google.android.gms.common.api.internal.zay;

/* JADX INFO: loaded from: classes2.dex */
public final class V20 implements zabz {
    public final /* synthetic */ a a;

    public /* synthetic */ V20(a aVar, zay zayVar) {
        this.a = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zaa(ConnectionResult connectionResult) {
        this.a.m.lock();
        try {
            this.a.k = connectionResult;
            a.p(this.a);
        } finally {
            this.a.m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zab(Bundle bundle) {
        this.a.m.lock();
        try {
            this.a.k = ConnectionResult.RESULT_SUCCESS;
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
            if (aVar.l) {
                aVar.l = false;
                a.n(this.a, i, z);
            } else {
                aVar.l = true;
                this.a.d.onConnectionSuspended(i);
            }
        } finally {
            this.a.m.unlock();
        }
    }
}
