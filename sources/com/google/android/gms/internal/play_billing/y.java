package com.google.android.gms.internal.play_billing;

import defpackage.AbstractC3209k90;
import defpackage.Hd0;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends AbstractC3209k90 {
    public y() {
        super(null);
    }

    @Override // defpackage.AbstractC3209k90
    public final void a(z zVar, z zVar2) {
        zVar.b = zVar2;
    }

    @Override // defpackage.AbstractC3209k90
    public final void b(z zVar, Thread thread) {
        zVar.a = thread;
    }

    @Override // defpackage.AbstractC3209k90
    public final boolean c(zzo zzoVar, Hd0 hd0, Hd0 hd1) {
        synchronized (zzoVar) {
            try {
                if (zzoVar.zzd != hd0) {
                    return false;
                }
                zzoVar.zzd = hd1;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.AbstractC3209k90
    public final boolean d(zzo zzoVar, Object obj, Object obj2) {
        synchronized (zzoVar) {
            try {
                if (zzoVar.zzc != obj) {
                    return false;
                }
                zzoVar.zzc = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.AbstractC3209k90
    public final boolean e(zzo zzoVar, z zVar, z zVar2) {
        synchronized (zzoVar) {
            try {
                if (zzoVar.zze != zVar) {
                    return false;
                }
                zzoVar.zze = zVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
