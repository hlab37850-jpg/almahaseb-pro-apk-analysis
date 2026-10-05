package defpackage;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzij;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zzis;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzjg;
import com.google.android.gms.internal.play_billing.zzji;
import com.google.android.gms.internal.play_billing.zzjo;
import com.google.android.gms.internal.play_billing.zzjs;

/* JADX INFO: renamed from: w80, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4183w80 implements InterfaceC3940t80 {
    public zzis b;
    public final A80 c;

    public C4183w80(Context context, zzis zzisVar) {
        this.c = new A80(context);
        this.b = zzisVar;
    }

    @Override // defpackage.InterfaceC3940t80
    public final void a(zzhx zzhxVar, int i, long j, boolean z) {
        zzis zzisVar;
        try {
            zziq zziqVar = (zziq) this.b.zzm();
            zziqVar.zzm(i);
            this.b = (zzis) zziqVar.zze();
            zzhv zzhvVar = (zzhv) zzhxVar.zzm();
            zzja zzjaVar = (zzja) zzhxVar.zzB().zzm();
            zzjaVar.zza(z);
            zzhvVar.zzn(zzjaVar);
            zzhx zzhxVar2 = (zzhx) zzhvVar.zze();
            if (j == 0) {
                zzisVar = this.b;
            } else {
                zziq zziqVar2 = (zziq) this.b.zzm();
                zziqVar2.zzo(j);
                zzisVar = (zzis) zziqVar2.zze();
            }
            l(zzhxVar2, zzisVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // defpackage.InterfaceC3940t80
    public final void b(zzhx zzhxVar) {
        try {
            l(zzhxVar, this.b);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // defpackage.InterfaceC3940t80
    public final void c(zzij zzijVar) {
        try {
            zzjg zzjgVarZzc = zzji.zzc();
            zzjgVarZzc.zzn(this.b);
            zzjgVarZzc.zzm(zzijVar);
            this.c.a((zzji) zzjgVarZzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // defpackage.InterfaceC3940t80
    public final void d(zzib zzibVar, int i) {
        try {
            zziq zziqVar = (zziq) this.b.zzm();
            zziqVar.zzm(i);
            this.b = (zzis) zziqVar.zze();
            h(zzibVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // defpackage.InterfaceC3940t80
    public final void e(zzjo zzjoVar) {
        try {
            A80 a80 = this.c;
            zzjg zzjgVarZzc = zzji.zzc();
            zzjgVarZzc.zzn(this.b);
            zzjgVarZzc.zzo(zzjoVar);
            a80.a((zzji) zzjgVarZzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // defpackage.InterfaceC3940t80
    public final void f(zzib zzibVar, long j, boolean z) {
        zzis zzisVar;
        try {
            zzhz zzhzVar = (zzhz) zzibVar.zzm();
            zzja zzjaVar = (zzja) zzibVar.zzA().zzm();
            zzjaVar.zza(z);
            zzhzVar.zzm(zzjaVar);
            zzib zzibVar2 = (zzib) zzhzVar.zze();
            if (j == 0) {
                zzisVar = this.b;
            } else {
                zziq zziqVar = (zziq) this.b.zzm();
                zziqVar.zzo(j);
                zzisVar = (zzis) zziqVar.zze();
            }
            m(zzibVar2, zzisVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // defpackage.InterfaceC3940t80
    public final void g(zzhx zzhxVar, long j, boolean z) {
        zzis zzisVar;
        try {
            zzhv zzhvVar = (zzhv) zzhxVar.zzm();
            zzja zzjaVar = (zzja) zzhxVar.zzB().zzm();
            zzjaVar.zza(z);
            zzhvVar.zzn(zzjaVar);
            zzhx zzhxVar2 = (zzhx) zzhvVar.zze();
            if (j == 0) {
                zzisVar = this.b;
            } else {
                zziq zziqVar = (zziq) this.b.zzm();
                zziqVar.zzo(j);
                zzisVar = (zzis) zziqVar.zze();
            }
            l(zzhxVar2, zzisVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // defpackage.InterfaceC3940t80
    public final void h(zzib zzibVar) {
        try {
            m(zzibVar, this.b);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // defpackage.InterfaceC3940t80
    public final void i(zzjs zzjsVar) {
        if (zzjsVar == null) {
            return;
        }
        try {
            zzjg zzjgVarZzc = zzji.zzc();
            zzjgVarZzc.zzn(this.b);
            zzjgVarZzc.zzp(zzjsVar);
            this.c.a((zzji) zzjgVarZzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // defpackage.InterfaceC3940t80
    public final void j(zzhx zzhxVar, int i, long j) {
        try {
            zziq zziqVar = (zziq) this.b.zzm();
            zziqVar.zzm(i);
            zzis zzisVar = (zzis) zziqVar.zze();
            this.b = zzisVar;
            if (j != 0) {
                zziq zziqVar2 = (zziq) zzisVar.zzm();
                zziqVar2.zzo(j);
                zzisVar = (zzis) zziqVar2.zze();
            }
            l(zzhxVar, zzisVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // defpackage.InterfaceC3940t80
    public final void k(zzhx zzhxVar, int i) {
        try {
            zziq zziqVar = (zziq) this.b.zzm();
            zziqVar.zzm(i);
            this.b = (zzis) zziqVar.zze();
            b(zzhxVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public final void l(zzhx zzhxVar, zzis zzisVar) {
        if (zzhxVar == null) {
            return;
        }
        try {
            zzjg zzjgVarZzc = zzji.zzc();
            zzjgVarZzc.zzn(zzisVar);
            zzjgVarZzc.zza(zzhxVar);
            this.c.a((zzji) zzjgVarZzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public final void m(zzib zzibVar, zzis zzisVar) {
        if (zzibVar == null) {
            return;
        }
        try {
            zzjg zzjgVarZzc = zzji.zzc();
            zzjgVarZzc.zzn(zzisVar);
            zzjgVarZzc.zzl(zzibVar);
            this.c.a((zzji) zzjgVarZzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }
}
