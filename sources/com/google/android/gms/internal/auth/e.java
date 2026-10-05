package com.google.android.gms.internal.auth;

import defpackage.AbstractC2047dd0;
import defpackage.AbstractC2124eb0;
import defpackage.AbstractC4219wd0;
import defpackage.C1883ca0;
import defpackage.Zc0;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Zc0 {
    public final zzfw a;
    public final AbstractC4219wd0 b;
    public final AbstractC2124eb0 c;

    public e(AbstractC4219wd0 abstractC4219wd0, AbstractC2124eb0 abstractC2124eb0, zzfw zzfwVar) {
        this.b = abstractC4219wd0;
        this.c = abstractC2124eb0;
        this.a = zzfwVar;
    }

    public static e a(AbstractC4219wd0 abstractC4219wd0, AbstractC2124eb0 abstractC2124eb0, zzfw zzfwVar) {
        return new e(abstractC4219wd0, abstractC2124eb0, zzfwVar);
    }

    @Override // defpackage.Zc0
    public final boolean b(Object obj) {
        this.c.a(obj);
        throw null;
    }

    @Override // defpackage.Zc0
    public final void c(Object obj) {
        this.b.e(obj);
        this.c.b(obj);
    }

    @Override // defpackage.Zc0
    public final void d(Object obj, Object obj2) {
        AbstractC2047dd0.f(this.b, obj, obj2);
    }

    @Override // defpackage.Zc0
    public final void e(Object obj, byte[] bArr, int i, int i2, C1883ca0 c1883ca0) {
        zzeu zzeuVar = (zzeu) obj;
        if (zzeuVar.zzc == zzgz.zza()) {
            zzeuVar.zzc = zzgz.zzc();
        }
        throw null;
    }

    @Override // defpackage.Zc0
    public final boolean f(Object obj, Object obj2) {
        return this.b.a(obj).equals(this.b.a(obj2));
    }

    @Override // defpackage.Zc0
    public final int zza(Object obj) {
        return this.b.a(obj).hashCode();
    }

    @Override // defpackage.Zc0
    public final Object zzd() {
        return ((zzes) ((zzeu) this.a).zzi(5, null, null)).zzg();
    }
}
