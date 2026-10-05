package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfu;

/* JADX INFO: loaded from: classes2.dex */
public class zzfu<M extends zzfu<M>> extends zzfz {
    protected zzfw zzrj;

    @Override // com.google.android.gms.internal.clearcut.zzfz
    public void zza(zzfs zzfsVar) {
        if (this.zzrj == null) {
            return;
        }
        for (int i = 0; i < this.zzrj.size(); i++) {
            this.zzrj.zzaq(i).b(zzfsVar);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzfz
    public int zzen() {
        if (this.zzrj != null) {
            for (int i = 0; i < this.zzrj.size(); i++) {
                this.zzrj.zzaq(i).d();
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.clearcut.zzfz
    /* JADX INFO: renamed from: zzeo, reason: merged with bridge method [inline-methods] */
    public M clone() {
        M m = (M) super.clone();
        zzfy.zza(this, m);
        return m;
    }

    @Override // com.google.android.gms.internal.clearcut.zzfz
    /* JADX INFO: renamed from: zzep */
    public /* synthetic */ zzfz clone() {
        return (zzfu) clone();
    }
}
