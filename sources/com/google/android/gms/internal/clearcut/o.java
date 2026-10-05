package com.google.android.gms.internal.clearcut;

import defpackage.Bb0;
import defpackage.InterfaceC3812rc0;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends Bb0 {
    public static void m(Object obj, zzey zzeyVar) {
        ((zzcg) obj).zzjp = zzeyVar;
    }

    @Override // defpackage.Bb0
    public final /* synthetic */ void a(Object obj, int i, long j) {
        ((zzey) obj).zzb(i << 3, Long.valueOf(j));
    }

    @Override // defpackage.Bb0
    public final /* synthetic */ void b(Object obj, int i, zzbb zzbbVar) {
        ((zzey) obj).zzb((i << 3) | 2, zzbbVar);
    }

    @Override // defpackage.Bb0
    public final /* synthetic */ void c(Object obj, InterfaceC3812rc0 interfaceC3812rc0) {
        ((zzey) obj).zzb(interfaceC3812rc0);
    }

    @Override // defpackage.Bb0
    public final void d(Object obj) {
        ((zzcg) obj).zzjp.zzv();
    }

    @Override // defpackage.Bb0
    public final /* synthetic */ void e(Object obj, InterfaceC3812rc0 interfaceC3812rc0) {
        ((zzey) obj).zza(interfaceC3812rc0);
    }

    @Override // defpackage.Bb0
    public final /* synthetic */ Object f() {
        return zzey.zzeb();
    }

    @Override // defpackage.Bb0
    public final /* synthetic */ void g(Object obj, Object obj2) {
        m(obj, (zzey) obj2);
    }

    @Override // defpackage.Bb0
    public final /* synthetic */ void h(Object obj, Object obj2) {
        m(obj, (zzey) obj2);
    }

    @Override // defpackage.Bb0
    public final /* synthetic */ Object i(Object obj, Object obj2) {
        zzey zzeyVar = (zzey) obj;
        zzey zzeyVar2 = (zzey) obj2;
        return zzeyVar2.equals(zzey.zzea()) ? zzeyVar : zzey.zza(zzeyVar, zzeyVar2);
    }

    @Override // defpackage.Bb0
    public final /* synthetic */ int j(Object obj) {
        return ((zzey) obj).zzas();
    }

    @Override // defpackage.Bb0
    public final /* synthetic */ Object k(Object obj) {
        return ((zzcg) obj).zzjp;
    }

    @Override // defpackage.Bb0
    public final /* synthetic */ int l(Object obj) {
        return ((zzey) obj).zzec();
    }
}
