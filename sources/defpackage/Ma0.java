package defpackage;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzdo;

/* JADX INFO: loaded from: classes2.dex */
public final class Ma0 implements P90 {
    public final zzdo a;
    public final String b;
    public final Na0 c;

    public Ma0(zzdo zzdoVar, String str, Object[] objArr) {
        this.a = zzdoVar;
        this.b = str;
        this.c = new Na0(zzdoVar.getClass(), str, objArr);
    }

    @Override // defpackage.P90
    public final int a() {
        return (this.c.d & 1) == 1 ? zzcg.zzg.zzkl : zzcg.zzg.zzkm;
    }

    @Override // defpackage.P90
    public final boolean b() {
        return (this.c.d & 2) == 2;
    }

    @Override // defpackage.P90
    public final zzdo c() {
        return this.a;
    }

    public final int d() {
        return this.c.e;
    }

    public final Na0 e() {
        return this.c;
    }

    public final int f() {
        return this.c.h;
    }

    public final int g() {
        return this.c.i;
    }

    public final int h() {
        return this.c.j;
    }

    public final int i() {
        return this.c.m;
    }

    public final int[] j() {
        return this.c.n;
    }

    public final int k() {
        return this.c.l;
    }

    public final int l() {
        return this.c.k;
    }
}
