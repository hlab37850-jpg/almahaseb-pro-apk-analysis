package com.google.android.gms.internal.vision;

import defpackage.AbstractC3331lg0;
import defpackage.Ag0;
import defpackage.C1812bf0;
import defpackage.InterfaceC3249kg0;
import defpackage.Wg0;
import defpackage.Xe0;
import defpackage.Yf0;
import defpackage.Ze0;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends Xe0 {
    @Override // defpackage.Xe0
    public final int a(Map.Entry entry) {
        return ((zzjb.a) entry.getKey()).b;
    }

    @Override // defpackage.Xe0
    public final Object b(zzio zzioVar, zzkk zzkkVar, int i) {
        return zzioVar.zza(zzkkVar, i);
    }

    @Override // defpackage.Xe0
    public final Object c(InterfaceC3249kg0 interfaceC3249kg0, Object obj, zzio zzioVar, C1812bf0 c1812bf0, Object obj2, Ag0 ag0) {
        Object objC;
        zzjb.zze zzeVar = (zzjb.zze) obj;
        zzjb.a aVar = zzeVar.zzd;
        int i = aVar.b;
        boolean z = aVar.d;
        zzml zzmlVar = aVar.c;
        Object objZza = null;
        if (zzmlVar == zzml.zzn) {
            interfaceC3249kg0.zzh();
            throw null;
        }
        int[] iArr = Ze0.a;
        switch (iArr[zzmlVar.ordinal()]) {
            case 1:
                objZza = Double.valueOf(interfaceC3249kg0.zzd());
                break;
            case 2:
                objZza = Float.valueOf(interfaceC3249kg0.zze());
                break;
            case 3:
                objZza = Long.valueOf(interfaceC3249kg0.zzg());
                break;
            case 4:
                objZza = Long.valueOf(interfaceC3249kg0.zzf());
                break;
            case 5:
                objZza = Integer.valueOf(interfaceC3249kg0.zzh());
                break;
            case 6:
                objZza = Long.valueOf(interfaceC3249kg0.zzi());
                break;
            case 7:
                objZza = Integer.valueOf(interfaceC3249kg0.zzj());
                break;
            case 8:
                objZza = Boolean.valueOf(interfaceC3249kg0.zzk());
                break;
            case 9:
                objZza = Integer.valueOf(interfaceC3249kg0.i());
                break;
            case 10:
                objZza = Integer.valueOf(interfaceC3249kg0.zzq());
                break;
            case 11:
                objZza = Long.valueOf(interfaceC3249kg0.zzr());
                break;
            case 12:
                objZza = Integer.valueOf(interfaceC3249kg0.zzs());
                break;
            case 13:
                objZza = Long.valueOf(interfaceC3249kg0.zzt());
                break;
            case 14:
                throw new IllegalStateException("Shouldn't reach here.");
            case 15:
                objZza = interfaceC3249kg0.f();
                break;
            case 16:
                objZza = interfaceC3249kg0.o();
                break;
            case 17:
                objZza = interfaceC3249kg0.u(zzeVar.zzc.getClass(), zzioVar);
                break;
            case 18:
                objZza = interfaceC3249kg0.x(zzeVar.zzc.getClass(), zzioVar);
                break;
        }
        zzjb.a aVar2 = zzeVar.zzd;
        if (aVar2.d) {
            c1812bf0.j(aVar2, objZza);
        } else {
            int i2 = iArr[aVar2.c.ordinal()];
            if ((i2 == 17 || i2 == 18) && (objC = c1812bf0.c(zzeVar.zzd)) != null) {
                objZza = zzjf.zza(objC, objZza);
            }
            c1812bf0.f(zzeVar.zzd, objZza);
        }
        return obj2;
    }

    @Override // defpackage.Xe0
    public final C1812bf0 d(Object obj) {
        return ((zzjb.zzc) obj).zzc;
    }

    @Override // defpackage.Xe0
    public final void e(zzht zzhtVar, Object obj, zzio zzioVar, C1812bf0 c1812bf0) throws zzjk {
        byte[] bArr;
        zzjb.zze zzeVar = (zzjb.zze) obj;
        zzkk zzkkVarZze = zzeVar.zzc.zzq().zze();
        int iZza = zzhtVar.zza();
        if (iZza == 0) {
            bArr = zzjf.zzb;
        } else {
            byte[] bArr2 = new byte[iZza];
            zzhtVar.zza(bArr2, 0, 0, iZza);
            bArr = bArr2;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (!byteBufferWrap.hasArray()) {
            throw new IllegalArgumentException("Direct buffers not yet supported");
        }
        s sVar = new s(byteBufferWrap, true);
        Yf0.a().c(zzkkVarZze).f(zzkkVarZze, sVar, zzioVar);
        c1812bf0.f(zzeVar.zzd, zzkkVarZze);
        if (sVar.zza() != Integer.MAX_VALUE) {
            throw zzjk.zze();
        }
    }

    @Override // defpackage.Xe0
    public final void f(InterfaceC3249kg0 interfaceC3249kg0, Object obj, zzio zzioVar, C1812bf0 c1812bf0) {
        zzjb.zze zzeVar = (zzjb.zze) obj;
        c1812bf0.f(zzeVar.zzd, interfaceC3249kg0.x(zzeVar.zzc.getClass(), zzioVar));
    }

    @Override // defpackage.Xe0
    public final void g(Wg0 wg0, Map.Entry entry) {
        zzjb.a aVar = (zzjb.a) entry.getKey();
        if (!aVar.d) {
            switch (Ze0.a[aVar.c.ordinal()]) {
                case 1:
                    wg0.r(aVar.b, ((Double) entry.getValue()).doubleValue());
                    break;
                case 2:
                    wg0.s(aVar.b, ((Float) entry.getValue()).floatValue());
                    break;
                case 3:
                    wg0.q(aVar.b, ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    wg0.l(aVar.b, ((Long) entry.getValue()).longValue());
                    break;
                case 5:
                    wg0.k(aVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case 6:
                    wg0.J(aVar.b, ((Long) entry.getValue()).longValue());
                    break;
                case 7:
                    wg0.y(aVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case 8:
                    wg0.j(aVar.b, ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 9:
                    wg0.A(aVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case 10:
                    wg0.zza(aVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case 11:
                    wg0.g(aVar.b, ((Long) entry.getValue()).longValue());
                    break;
                case 12:
                    wg0.u(aVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    wg0.K(aVar.b, ((Long) entry.getValue()).longValue());
                    break;
                case 14:
                    wg0.k(aVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    wg0.C(aVar.b, (zzht) entry.getValue());
                    break;
                case 16:
                    wg0.o(aVar.b, (String) entry.getValue());
                    break;
                case 17:
                    wg0.F(aVar.b, entry.getValue(), Yf0.a().b(entry.getValue().getClass()));
                    break;
                case 18:
                    wg0.G(aVar.b, entry.getValue(), Yf0.a().b(entry.getValue().getClass()));
                    break;
            }
        }
        switch (Ze0.a[aVar.c.ordinal()]) {
            case 1:
                AbstractC3331lg0.l(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 2:
                AbstractC3331lg0.y(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 3:
                AbstractC3331lg0.C(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 4:
                AbstractC3331lg0.G(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 5:
                AbstractC3331lg0.T(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 6:
                AbstractC3331lg0.N(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 7:
                AbstractC3331lg0.a0(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 8:
                AbstractC3331lg0.d0(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 9:
                AbstractC3331lg0.W(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 10:
                AbstractC3331lg0.b0(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 11:
                AbstractC3331lg0.Q(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 12:
                AbstractC3331lg0.Z(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 13:
                AbstractC3331lg0.K(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 14:
                AbstractC3331lg0.T(aVar.b, (List) entry.getValue(), wg0, false);
                break;
            case 15:
                AbstractC3331lg0.w(aVar.b, (List) entry.getValue(), wg0);
                break;
            case 16:
                AbstractC3331lg0.j(aVar.b, (List) entry.getValue(), wg0);
                break;
            case 17:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    AbstractC3331lg0.x(aVar.b, (List) entry.getValue(), wg0, Yf0.a().b(list.get(0).getClass()));
                    break;
                }
                break;
            case 18:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    AbstractC3331lg0.k(aVar.b, (List) entry.getValue(), wg0, Yf0.a().b(list2.get(0).getClass()));
                    break;
                }
                break;
        }
    }

    @Override // defpackage.Xe0
    public final boolean h(zzkk zzkkVar) {
        return zzkkVar instanceof zzjb.zzc;
    }

    @Override // defpackage.Xe0
    public final C1812bf0 i(Object obj) {
        return ((zzjb.zzc) obj).zza();
    }

    @Override // defpackage.Xe0
    public final void j(Object obj) {
        d(obj).i();
    }
}
