package com.google.android.gms.internal.clearcut;

import defpackage.AbstractC4343y70;
import defpackage.C70;
import defpackage.Da0;
import defpackage.H70;
import defpackage.InterfaceC3812rc0;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.gms.internal.clearcut.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1915j extends AbstractC4343y70 {
    @Override // defpackage.AbstractC4343y70
    public final int a(Map.Entry entry) {
        return ((zzcg.a) entry.getKey()).b;
    }

    @Override // defpackage.AbstractC4343y70
    public final H70 b(Object obj) {
        return ((zzcg.zzd) obj).zzjv;
    }

    @Override // defpackage.AbstractC4343y70
    public final void c(Object obj, H70 h70) {
        ((zzcg.zzd) obj).zzjv = h70;
    }

    @Override // defpackage.AbstractC4343y70
    public final void d(InterfaceC3812rc0 interfaceC3812rc0, Map.Entry entry) {
        zzcg.a aVar = (zzcg.a) entry.getKey();
        switch (C70.a[aVar.c.ordinal()]) {
            case 1:
                interfaceC3812rc0.r(aVar.b, ((Double) entry.getValue()).doubleValue());
                break;
            case 2:
                interfaceC3812rc0.s(aVar.b, ((Float) entry.getValue()).floatValue());
                break;
            case 3:
                interfaceC3812rc0.I(aVar.b, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                interfaceC3812rc0.q(aVar.b, ((Long) entry.getValue()).longValue());
                break;
            case 5:
                interfaceC3812rc0.k(aVar.b, ((Integer) entry.getValue()).intValue());
                break;
            case 6:
                interfaceC3812rc0.l(aVar.b, ((Long) entry.getValue()).longValue());
                break;
            case 7:
                interfaceC3812rc0.u(aVar.b, ((Integer) entry.getValue()).intValue());
                break;
            case 8:
                interfaceC3812rc0.j(aVar.b, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 9:
                interfaceC3812rc0.y(aVar.b, ((Integer) entry.getValue()).intValue());
                break;
            case 10:
                interfaceC3812rc0.O(aVar.b, ((Integer) entry.getValue()).intValue());
                break;
            case 11:
                interfaceC3812rc0.C(aVar.b, ((Long) entry.getValue()).longValue());
                break;
            case 12:
                interfaceC3812rc0.A(aVar.b, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                interfaceC3812rc0.g(aVar.b, ((Long) entry.getValue()).longValue());
                break;
            case 14:
                interfaceC3812rc0.k(aVar.b, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                interfaceC3812rc0.L(aVar.b, (zzbb) entry.getValue());
                break;
            case 16:
                interfaceC3812rc0.o(aVar.b, (String) entry.getValue());
                break;
            case 17:
                interfaceC3812rc0.H(aVar.b, entry.getValue(), Da0.a().b(entry.getValue().getClass()));
                break;
            case 18:
                interfaceC3812rc0.J(aVar.b, entry.getValue(), Da0.a().b(entry.getValue().getClass()));
                break;
        }
    }

    @Override // defpackage.AbstractC4343y70
    public final H70 e(Object obj) {
        H70 h70B = b(obj);
        if (!h70B.c()) {
            return h70B;
        }
        H70 h70 = (H70) h70B.clone();
        c(obj, h70);
        return h70;
    }

    @Override // defpackage.AbstractC4343y70
    public final void f(Object obj) {
        b(obj).t();
    }

    @Override // defpackage.AbstractC4343y70
    public final boolean g(zzdo zzdoVar) {
        return zzdoVar instanceof zzcg.zzd;
    }
}
