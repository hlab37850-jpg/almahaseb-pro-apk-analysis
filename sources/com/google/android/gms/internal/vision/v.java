package com.google.android.gms.internal.vision;

import com.itextpdf.tool.xml.html.HTML;
import defpackage.InterfaceC3167jg0;
import defpackage.Pf0;
import defpackage.Wg0;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements Wg0 {
    public final zzii a;

    public v(zzii zziiVar) {
        zzii zziiVar2 = (zzii) zzjf.zza(zziiVar, HTML.Tag.OUTPUT);
        this.a = zziiVar2;
        zziiVar2.zza = this;
    }

    public static v L(zzii zziiVar) {
        v vVar = zziiVar.zza;
        return vVar != null ? vVar : new v(zziiVar);
    }

    @Override // defpackage.Wg0
    public final void A(int i, int i2) {
        this.a.zzc(i, i2);
    }

    @Override // defpackage.Wg0
    public final void B(int i, List list) {
        int i2 = 0;
        if (!(list instanceof zzjv)) {
            while (i2 < list.size()) {
                this.a.zza(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzjv zzjvVar = (zzjv) list;
        while (i2 < list.size()) {
            Object objZzb = zzjvVar.zzb(i2);
            if (objZzb instanceof String) {
                this.a.zza(i, (String) objZzb);
            } else {
                this.a.zza(i, (zzht) objZzb);
            }
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void C(int i, zzht zzhtVar) {
        this.a.zza(i, zzhtVar);
    }

    @Override // defpackage.Wg0
    public final void D(int i, int i2) {
        this.a.zzb(i, i2);
    }

    @Override // defpackage.Wg0
    public final void E(int i, List list, InterfaceC3167jg0 interfaceC3167jg0) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            G(i, list.get(i2), interfaceC3167jg0);
        }
    }

    @Override // defpackage.Wg0
    public final void F(int i, Object obj, InterfaceC3167jg0 interfaceC3167jg0) {
        zzii zziiVar = this.a;
        zziiVar.zza(i, 3);
        interfaceC3167jg0.g((zzkk) obj, zziiVar.zza);
        zziiVar.zza(i, 4);
    }

    @Override // defpackage.Wg0
    public final void G(int i, Object obj, InterfaceC3167jg0 interfaceC3167jg0) {
        this.a.zza(i, (zzkk) obj, interfaceC3167jg0);
    }

    @Override // defpackage.Wg0
    public final void H(int i, Pf0 pf0, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.a.zza(i, 2);
            this.a.zzb(zzkc.zza(pf0, entry.getKey(), entry.getValue()));
            zzkc.zza(this.a, pf0, entry.getKey(), entry.getValue());
        }
    }

    @Override // defpackage.Wg0
    public final void I(int i, List list, InterfaceC3167jg0 interfaceC3167jg0) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            F(i, list.get(i2), interfaceC3167jg0);
        }
    }

    @Override // defpackage.Wg0
    public final void J(int i, long j) {
        this.a.zzc(i, j);
    }

    @Override // defpackage.Wg0
    public final void K(int i, long j) {
        this.a.zzb(i, j);
    }

    @Override // defpackage.Wg0
    public final void a(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zza(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZzd = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzd += zzii.zzd(((Long) list.get(i3)).longValue());
        }
        this.a.zzb(iZzd);
        while (i2 < list.size()) {
            this.a.zza(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void b(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzc(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZzh = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzh += zzii.zzh(((Long) list.get(i3)).longValue());
        }
        this.a.zzb(iZzh);
        while (i2 < list.size()) {
            this.a.zzc(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void c(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzc(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZzg = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzg += zzii.zzg(((Integer) list.get(i3)).intValue());
        }
        this.a.zzb(iZzg);
        while (i2 < list.size()) {
            this.a.zzb(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void d(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzb(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZzf = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzf += zzii.zzf(((Long) list.get(i3)).longValue());
        }
        this.a.zzb(iZzf);
        while (i2 < list.size()) {
            this.a.zzb(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void e(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zza(i, ((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZzb = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzb += zzii.zzb(((Double) list.get(i3)).doubleValue());
        }
        this.a.zzb(iZzb);
        while (i2 < list.size()) {
            this.a.zza(((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void f(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zza(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZzb = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzb += zzii.zzb(((Boolean) list.get(i3)).booleanValue());
        }
        this.a.zzb(iZzb);
        while (i2 < list.size()) {
            this.a.zza(((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void g(int i, long j) {
        this.a.zzc(i, j);
    }

    @Override // defpackage.Wg0
    public final void h(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzb(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZzf = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzf += zzii.zzf(((Integer) list.get(i3)).intValue());
        }
        this.a.zzb(iZzf);
        while (i2 < list.size()) {
            this.a.zza(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void i(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzb(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZzk = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzk += zzii.zzk(((Integer) list.get(i3)).intValue());
        }
        this.a.zzb(iZzk);
        while (i2 < list.size()) {
            this.a.zza(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void j(int i, boolean z) {
        this.a.zza(i, z);
    }

    @Override // defpackage.Wg0
    public final void k(int i, int i2) {
        this.a.zzb(i, i2);
    }

    @Override // defpackage.Wg0
    public final void l(int i, long j) {
        this.a.zza(i, j);
    }

    @Override // defpackage.Wg0
    public final void m(int i, Object obj) {
        if (obj instanceof zzht) {
            this.a.zzb(i, (zzht) obj);
        } else {
            this.a.zza(i, (zzkk) obj);
        }
    }

    @Override // defpackage.Wg0
    public final void n(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zze(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZzi = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzi += zzii.zzi(((Integer) list.get(i3)).intValue());
        }
        this.a.zzb(iZzi);
        while (i2 < list.size()) {
            this.a.zzd(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void o(int i, String str) {
        this.a.zza(i, str);
    }

    @Override // defpackage.Wg0
    public final void p(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zze(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZzj = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzj += zzii.zzj(((Integer) list.get(i3)).intValue());
        }
        this.a.zzb(iZzj);
        while (i2 < list.size()) {
            this.a.zzd(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void q(int i, long j) {
        this.a.zza(i, j);
    }

    @Override // defpackage.Wg0
    public final void r(int i, double d) {
        this.a.zza(i, d);
    }

    @Override // defpackage.Wg0
    public final void s(int i, float f) {
        this.a.zza(i, f);
    }

    @Override // defpackage.Wg0
    public final void t(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzc(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZzg = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzg += zzii.zzg(((Long) list.get(i3)).longValue());
        }
        this.a.zzb(iZzg);
        while (i2 < list.size()) {
            this.a.zzc(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void u(int i, int i2) {
        this.a.zzd(i, i2);
    }

    @Override // defpackage.Wg0
    public final void v(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zza(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZze = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZze += zzii.zze(((Long) list.get(i3)).longValue());
        }
        this.a.zzb(iZze);
        while (i2 < list.size()) {
            this.a.zza(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void w(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzd(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZzh = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzh += zzii.zzh(((Integer) list.get(i3)).intValue());
        }
        this.a.zzb(iZzh);
        while (i2 < list.size()) {
            this.a.zzc(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final void x(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.zza(i, (zzht) list.get(i2));
        }
    }

    @Override // defpackage.Wg0
    public final void y(int i, int i2) {
        this.a.zze(i, i2);
    }

    @Override // defpackage.Wg0
    public final void z(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zza(i, ((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        this.a.zza(i, 2);
        int iZzb = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzb += zzii.zzb(((Float) list.get(i3)).floatValue());
        }
        this.a.zzb(iZzb);
        while (i2 < list.size()) {
            this.a.zza(((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    @Override // defpackage.Wg0
    public final int zza() {
        return zzmq.zza;
    }

    @Override // defpackage.Wg0
    public final void zzb(int i) {
        this.a.zza(i, 4);
    }

    @Override // defpackage.Wg0
    public final void zza(int i, int i2) {
        this.a.zze(i, i2);
    }

    @Override // defpackage.Wg0
    public final void zza(int i) {
        this.a.zza(i, 3);
    }
}
