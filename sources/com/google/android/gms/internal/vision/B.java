package com.google.android.gms.internal.vision;

import defpackage.Ag0;
import defpackage.InterfaceC3249kg0;
import defpackage.Wg0;

/* JADX INFO: loaded from: classes2.dex */
public final class B extends Ag0 {
    public static void t(Object obj, zzlx zzlxVar) {
        ((zzjb) obj).zzb = zzlxVar;
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ Object a() {
        return zzlx.zzb();
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ Object b(Object obj) {
        zzlx zzlxVar = (zzlx) obj;
        zzlxVar.zzc();
        return zzlxVar;
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ void c(Object obj, int i, int i2) {
        ((zzlx) obj).zza((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ void d(Object obj, int i, long j) {
        ((zzlx) obj).zza(i << 3, Long.valueOf(j));
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ void e(Object obj, int i, zzht zzhtVar) {
        ((zzlx) obj).zza((i << 3) | 2, zzhtVar);
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ void f(Object obj, int i, Object obj2) {
        ((zzlx) obj).zza((i << 3) | 3, (zzlx) obj2);
    }

    @Override // defpackage.Ag0
    public final /* bridge */ /* synthetic */ void g(Object obj, Object obj2) {
        t(obj, (zzlx) obj2);
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ void h(Object obj, Wg0 wg0) {
        ((zzlx) obj).zzb(wg0);
    }

    @Override // defpackage.Ag0
    public final boolean j(InterfaceC3249kg0 interfaceC3249kg0) {
        return false;
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ Object k(Object obj) {
        return ((zzjb) obj).zzb;
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ void l(Object obj, int i, long j) {
        ((zzlx) obj).zza((i << 3) | 1, Long.valueOf(j));
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ void m(Object obj, Object obj2) {
        t(obj, (zzlx) obj2);
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ void n(Object obj, Wg0 wg0) {
        ((zzlx) obj).zza(wg0);
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ Object o(Object obj) {
        zzlx zzlxVar = ((zzjb) obj).zzb;
        if (zzlxVar != zzlx.zza()) {
            return zzlxVar;
        }
        zzlx zzlxVarZzb = zzlx.zzb();
        t(obj, zzlxVarZzb);
        return zzlxVarZzb;
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ Object p(Object obj, Object obj2) {
        zzlx zzlxVar = (zzlx) obj;
        zzlx zzlxVar2 = (zzlx) obj2;
        return zzlxVar2.equals(zzlx.zza()) ? zzlxVar : zzlx.zza(zzlxVar, zzlxVar2);
    }

    @Override // defpackage.Ag0
    public final void q(Object obj) {
        ((zzjb) obj).zzb.zzc();
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ int r(Object obj) {
        return ((zzlx) obj).zzd();
    }

    @Override // defpackage.Ag0
    public final /* synthetic */ int s(Object obj) {
        return ((zzlx) obj).zze();
    }
}
