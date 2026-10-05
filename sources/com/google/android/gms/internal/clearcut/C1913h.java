package com.google.android.gms.internal.clearcut;

import com.itextpdf.tool.xml.html.HTML;
import defpackage.F90;
import defpackage.InterfaceC3812rc0;
import defpackage.Ta0;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.gms.internal.clearcut.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1913h implements InterfaceC3812rc0 {
    public final zzbn a;

    public C1913h(zzbn zzbnVar) {
        zzbn zzbnVar2 = (zzbn) zzci.zza(zzbnVar, HTML.Tag.OUTPUT);
        this.a = zzbnVar2;
        zzbnVar2.zzfz = this;
    }

    public static C1913h P(zzbn zzbnVar) {
        C1913h c1913h = zzbnVar.zzfz;
        return c1913h != null ? c1913h : new C1913h(zzbnVar);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void A(int i, int i2) {
        this.a.zze(i, i2);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void B(int i, List list) {
        int i2 = 0;
        if (!(list instanceof zzcx)) {
            while (i2 < list.size()) {
                this.a.zza(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzcx zzcxVar = (zzcx) list;
        while (i2 < list.size()) {
            Object raw = zzcxVar.getRaw(i2);
            if (raw instanceof String) {
                this.a.zza(i, (String) raw);
            } else {
                this.a.zza(i, (zzbb) raw);
            }
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void C(int i, long j) {
        this.a.zzc(i, j);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void D(int i, List list, Ta0 ta0) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            J(i, list.get(i2), ta0);
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void E(int i, F90 f90, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.a.zzb(i, 2);
            this.a.zzo(zzdg.zza(f90, entry.getKey(), entry.getValue()));
            zzdg.zza(this.a, f90, entry.getKey(), entry.getValue());
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void F(int i, List list, Ta0 ta0) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            H(i, list.get(i2), ta0);
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void G(int i) {
        this.a.zzb(i, 4);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void H(int i, Object obj, Ta0 ta0) {
        zzbn zzbnVar = this.a;
        zzbnVar.zzb(i, 3);
        ta0.d((zzdo) obj, zzbnVar.zzfz);
        zzbnVar.zzb(i, 4);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void I(int i, long j) {
        this.a.zza(i, j);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void J(int i, Object obj, Ta0 ta0) {
        this.a.zza(i, (zzdo) obj, ta0);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void K(int i, int i2) {
        this.a.zzc(i, i2);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void L(int i, zzbb zzbbVar) {
        this.a.zza(i, zzbbVar);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void M(int i) {
        this.a.zzb(i, 3);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final int N() {
        return zzcg.zzg.zzko;
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void O(int i, int i2) {
        this.a.zzf(i, i2);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void a(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zza(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZze = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZze += zzbn.zze(((Long) list.get(i3)).longValue());
        }
        this.a.zzo(iZze);
        while (i2 < list.size()) {
            this.a.zzb(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void b(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzc(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZzi = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzi += zzbn.zzi(((Long) list.get(i3)).longValue());
        }
        this.a.zzo(iZzi);
        while (i2 < list.size()) {
            this.a.zzd(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void c(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzd(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZzt = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzt += zzbn.zzt(((Integer) list.get(i3)).intValue());
        }
        this.a.zzo(iZzt);
        while (i2 < list.size()) {
            this.a.zzo(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void d(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzb(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZzg = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzg += zzbn.zzg(((Long) list.get(i3)).longValue());
        }
        this.a.zzo(iZzg);
        while (i2 < list.size()) {
            this.a.zzc(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void e(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zza(i, ((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZzb = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzb += zzbn.zzb(((Double) list.get(i3)).doubleValue());
        }
        this.a.zzo(iZzb);
        while (i2 < list.size()) {
            this.a.zza(((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void f(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzb(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZzb = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzb += zzbn.zzb(((Boolean) list.get(i3)).booleanValue());
        }
        this.a.zzo(iZzb);
        while (i2 < list.size()) {
            this.a.zza(((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void g(int i, long j) {
        this.a.zzb(i, j);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void h(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzc(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZzs = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzs += zzbn.zzs(((Integer) list.get(i3)).intValue());
        }
        this.a.zzo(iZzs);
        while (i2 < list.size()) {
            this.a.zzn(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void i(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzc(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZzx = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzx += zzbn.zzx(((Integer) list.get(i3)).intValue());
        }
        this.a.zzo(iZzx);
        while (i2 < list.size()) {
            this.a.zzn(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void j(int i, boolean z) {
        this.a.zzb(i, z);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void k(int i, int i2) {
        this.a.zzc(i, i2);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void l(int i, long j) {
        this.a.zzc(i, j);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void m(int i, Object obj) {
        if (obj instanceof zzbb) {
            this.a.zzb(i, (zzbb) obj);
        } else {
            this.a.zzb(i, (zzdo) obj);
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void n(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzf(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZzv = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzv += zzbn.zzv(((Integer) list.get(i3)).intValue());
        }
        this.a.zzo(iZzv);
        while (i2 < list.size()) {
            this.a.zzq(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void o(int i, String str) {
        this.a.zza(i, str);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void p(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzf(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZzw = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzw += zzbn.zzw(((Integer) list.get(i3)).intValue());
        }
        this.a.zzo(iZzw);
        while (i2 < list.size()) {
            this.a.zzq(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void q(int i, long j) {
        this.a.zza(i, j);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void r(int i, double d) {
        this.a.zza(i, d);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void s(int i, float f) {
        this.a.zza(i, f);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void t(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzc(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZzh = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzh += zzbn.zzh(((Long) list.get(i3)).longValue());
        }
        this.a.zzo(iZzh);
        while (i2 < list.size()) {
            this.a.zzd(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void u(int i, int i2) {
        this.a.zzf(i, i2);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void v(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zza(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZzf = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzf += zzbn.zzf(((Long) list.get(i3)).longValue());
        }
        this.a.zzo(iZzf);
        while (i2 < list.size()) {
            this.a.zzb(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void w(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zze(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZzu = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzu += zzbn.zzu(((Integer) list.get(i3)).intValue());
        }
        this.a.zzo(iZzu);
        while (i2 < list.size()) {
            this.a.zzp(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void x(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.zza(i, (zzbb) list.get(i2));
        }
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void y(int i, int i2) {
        this.a.zzd(i, i2);
    }

    @Override // defpackage.InterfaceC3812rc0
    public final void z(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zza(i, ((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        this.a.zzb(i, 2);
        int iZzb = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzb += zzbn.zzb(((Float) list.get(i3)).floatValue());
        }
        this.a.zzo(iZzb);
        while (i2 < list.size()) {
            this.a.zza(((Float) list.get(i2)).floatValue());
            i2++;
        }
    }
}
