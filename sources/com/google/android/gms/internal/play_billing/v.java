package com.google.android.gms.internal.play_billing;

import defpackage.AbstractC4215wb0;
import defpackage.C3237ka0;
import defpackage.C3974tc0;
import defpackage.InterfaceC3814rd0;
import defpackage.InterfaceC4221we0;
import defpackage.Xd0;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements InterfaceC3814rd0 {
    public final zzgl a;
    public final Xd0 b;
    public final boolean c;
    public final AbstractC4215wb0 d;

    public v(Xd0 xd0, AbstractC4215wb0 abstractC4215wb0, zzgl zzglVar) {
        this.b = xd0;
        this.c = zzglVar instanceof zzff;
        this.d = abstractC4215wb0;
        this.a = zzglVar;
    }

    public static v g(Xd0 xd0, AbstractC4215wb0 abstractC4215wb0, zzgl zzglVar) {
        return new v(xd0, abstractC4215wb0, zzglVar);
    }

    @Override // defpackage.InterfaceC3814rd0
    public final boolean a(Object obj) {
        return ((zzff) obj).zzb.i();
    }

    @Override // defpackage.InterfaceC3814rd0
    public final void b(Object obj) {
        this.b.b(obj);
        this.d.a(obj);
    }

    @Override // defpackage.InterfaceC3814rd0
    public final void c(Object obj, InterfaceC4221we0 interfaceC4221we0) {
        Iterator itF = ((zzff) obj).zzb.f();
        while (itF.hasNext()) {
            Map.Entry entry = (Map.Entry) itF.next();
            zzey zzeyVar = (zzey) entry.getKey();
            if (zzeyVar.zzc() != zzht.MESSAGE || zzeyVar.zze() || zzeyVar.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof C3974tc0) {
                interfaceC4221we0.A(zzeyVar.zza(), ((C3974tc0) entry).a().zzb());
            } else {
                interfaceC4221we0.A(zzeyVar.zza(), entry.getValue());
            }
        }
        ((zzfi) obj).zzc.zzk(interfaceC4221we0);
    }

    @Override // defpackage.InterfaceC3814rd0
    public final void d(Object obj, Object obj2) {
        w.u(this.b, obj, obj2);
        if (this.c) {
            w.t(this.d, obj, obj2);
        }
    }

    @Override // defpackage.InterfaceC3814rd0
    public final boolean e(Object obj, Object obj2) {
        if (!((zzfi) obj).zzc.equals(((zzfi) obj2).zzc)) {
            return false;
        }
        if (this.c) {
            return ((zzff) obj).zzb.equals(((zzff) obj2).zzb);
        }
        return true;
    }

    @Override // defpackage.InterfaceC3814rd0
    public final void f(Object obj, byte[] bArr, int i, int i2, C3237ka0 c3237ka0) {
        zzfi zzfiVar = (zzfi) obj;
        if (zzfiVar.zzc == zzhi.zzc()) {
            zzfiVar.zzc = zzhi.zzf();
        }
        throw null;
    }

    @Override // defpackage.InterfaceC3814rd0
    public final int zza(Object obj) {
        int iZzb = ((zzfi) obj).zzc.zzb();
        return this.c ? iZzb + ((zzff) obj).zzb.d() : iZzb;
    }

    @Override // defpackage.InterfaceC3814rd0
    public final int zzb(Object obj) {
        int iHashCode = ((zzfi) obj).zzc.hashCode();
        return this.c ? (iHashCode * 53) + ((zzff) obj).zzb.a.hashCode() : iHashCode;
    }

    @Override // defpackage.InterfaceC3814rd0
    public final Object zze() {
        zzgl zzglVar = this.a;
        return zzglVar instanceof zzfi ? ((zzfi) zzglVar).zzo() : zzglVar.zzK().zzg();
    }
}
