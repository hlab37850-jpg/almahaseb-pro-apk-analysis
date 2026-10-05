package com.google.android.gms.internal.play_billing;

import defpackage.AbstractC3567ob0;
import defpackage.AbstractC3574of;
import defpackage.AbstractC3808ra0;
import defpackage.C2208fc0;
import defpackage.InterfaceC3814rd0;
import defpackage.InterfaceC4221we0;
import defpackage.Nc0;
import defpackage.Ob0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements InterfaceC4221we0 {
    public final zzep a;

    public r(zzep zzepVar) {
        byte[] bArr = zzfo.zzb;
        this.a = zzepVar;
        zzepVar.zza = this;
    }

    public static r L(zzep zzepVar) {
        r rVar = zzepVar.zza;
        return rVar != null ? rVar : new r(zzepVar);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void A(int i, Object obj) {
        if (obj instanceof zzei) {
            this.a.zzq(i, (zzei) obj);
        } else {
            this.a.zzp(i, (zzgl) obj);
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void B(int i, int i2) {
        this.a.zzg(i, i2);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void C(int i, List list, boolean z) {
        if (list instanceof Nc0) {
            AbstractC3574of.a(list);
            if (!z) {
                throw null;
            }
            this.a.zzt(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzep zzepVar = this.a;
                long jLongValue = ((Long) list.get(i2)).longValue();
                zzepVar.zzw(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        zzep zzepVar2 = this.a;
        zzepVar2.zzt(i, 2);
        int iZzD = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iZzD += zzep.zzD((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        zzepVar2.zzv(iZzD);
        while (i2 < list.size()) {
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            zzepVar2.zzx((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void D(int i, Object obj, InterfaceC3814rd0 interfaceC3814rd0) {
        this.a.zzn(i, (zzgl) obj, interfaceC3814rd0);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void E(int i, List list, boolean z) {
        if (list instanceof Ob0) {
            AbstractC3574of.a(list);
            if (!z) {
                throw null;
            }
            this.a.zzt(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzg(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzep zzepVar = this.a;
        zzepVar.zzt(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).floatValue();
            i3 += 4;
        }
        zzepVar.zzv(i3);
        while (i2 < list.size()) {
            zzepVar.zzh(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void F(int i, int i2) {
        this.a.zzu(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // defpackage.InterfaceC4221we0
    public final void G(int i, long j) {
        this.a.zzi(i, j);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void H(int i, List list) {
        int i2 = 0;
        if (!(list instanceof zzfx)) {
            while (i2 < list.size()) {
                this.a.zzr(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzfx zzfxVar = (zzfx) list;
        while (i2 < list.size()) {
            Object objZza = zzfxVar.zza();
            if (objZza instanceof String) {
                this.a.zzr(i, (String) objZza);
            } else {
                this.a.zze(i, (zzei) objZza);
            }
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void I(int i, long j) {
        this.a.zzw(i, j);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void J(int i) {
        this.a.zzt(i, 4);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void K(int i) {
        this.a.zzt(i, 3);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.InterfaceC4221we0
    public final void a(int i, List list, boolean z) {
        if (list instanceof AbstractC3808ra0) {
            AbstractC3574of.a(list);
            if (!z) {
                throw null;
            }
            this.a.zzt(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzd(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        zzep zzepVar = this.a;
        zzepVar.zzt(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).booleanValue();
            i3++;
        }
        zzepVar.zzv(i3);
        while (i2 < list.size()) {
            zzepVar.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void b(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C2208fc0)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.a.zzg(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzep zzepVar = this.a;
            zzepVar.zzt(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzepVar.zzv(i3);
            while (i2 < list.size()) {
                zzepVar.zzh(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C2208fc0 c2208fc0 = (C2208fc0) list;
        if (!z) {
            while (i2 < c2208fc0.size()) {
                this.a.zzg(i, c2208fc0.b(i2));
                i2++;
            }
            return;
        }
        zzep zzepVar2 = this.a;
        zzepVar2.zzt(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < c2208fc0.size(); i6++) {
            c2208fc0.b(i6);
            i5 += 4;
        }
        zzepVar2.zzv(i5);
        while (i2 < c2208fc0.size()) {
            zzepVar2.zzh(c2208fc0.b(i2));
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void c(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C2208fc0)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.a.zzk(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzep zzepVar = this.a;
            zzepVar.zzt(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzD += zzep.zzD(((Integer) list.get(i3)).intValue());
            }
            zzepVar.zzv(iZzD);
            while (i2 < list.size()) {
                zzepVar.zzl(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C2208fc0 c2208fc0 = (C2208fc0) list;
        if (!z) {
            while (i2 < c2208fc0.size()) {
                this.a.zzk(i, c2208fc0.b(i2));
                i2++;
            }
            return;
        }
        zzep zzepVar2 = this.a;
        zzepVar2.zzt(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < c2208fc0.size(); i4++) {
            iZzD2 += zzep.zzD(c2208fc0.b(i4));
        }
        zzepVar2.zzv(iZzD2);
        while (i2 < c2208fc0.size()) {
            zzepVar2.zzl(c2208fc0.b(i2));
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void d(int i, List list, boolean z) {
        if (list instanceof Nc0) {
            AbstractC3574of.a(list);
            if (!z) {
                throw null;
            }
            this.a.zzt(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzi(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzep zzepVar = this.a;
        zzepVar.zzt(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        zzepVar.zzv(i3);
        while (i2 < list.size()) {
            zzepVar.zzj(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void e(int i, List list, boolean z) {
        if (list instanceof AbstractC3567ob0) {
            AbstractC3574of.a(list);
            if (!z) {
                throw null;
            }
            this.a.zzt(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzi(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzep zzepVar = this.a;
        zzepVar.zzt(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).doubleValue();
            i3 += 8;
        }
        zzepVar.zzv(i3);
        while (i2 < list.size()) {
            zzepVar.zzj(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void f(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.zze(i, (zzei) list.get(i2));
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void g(int i, String str) {
        this.a.zzr(i, str);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void h(int i, int i2) {
        this.a.zzu(i, i2);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void i(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C2208fc0)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.a.zzg(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzep zzepVar = this.a;
            zzepVar.zzt(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzepVar.zzv(i3);
            while (i2 < list.size()) {
                zzepVar.zzh(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C2208fc0 c2208fc0 = (C2208fc0) list;
        if (!z) {
            while (i2 < c2208fc0.size()) {
                this.a.zzg(i, c2208fc0.b(i2));
                i2++;
            }
            return;
        }
        zzep zzepVar2 = this.a;
        zzepVar2.zzt(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < c2208fc0.size(); i6++) {
            c2208fc0.b(i6);
            i5 += 4;
        }
        zzepVar2.zzv(i5);
        while (i2 < c2208fc0.size()) {
            zzepVar2.zzh(c2208fc0.b(i2));
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void j(int i, boolean z) {
        this.a.zzd(i, z);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void k(int i, int i2) {
        this.a.zzg(i, i2);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void l(int i, zzei zzeiVar) {
        this.a.zze(i, zzeiVar);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void m(int i, long j) {
        this.a.zzw(i, j);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void n(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C2208fc0)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.a.zzu(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzep zzepVar = this.a;
            zzepVar.zzt(i, 2);
            int iZzC = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzC += zzep.zzC(((Integer) list.get(i3)).intValue());
            }
            zzepVar.zzv(iZzC);
            while (i2 < list.size()) {
                zzepVar.zzv(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C2208fc0 c2208fc0 = (C2208fc0) list;
        if (!z) {
            while (i2 < c2208fc0.size()) {
                this.a.zzu(i, c2208fc0.b(i2));
                i2++;
            }
            return;
        }
        zzep zzepVar2 = this.a;
        zzepVar2.zzt(i, 2);
        int iZzC2 = 0;
        for (int i4 = 0; i4 < c2208fc0.size(); i4++) {
            iZzC2 += zzep.zzC(c2208fc0.b(i4));
        }
        zzepVar2.zzv(iZzC2);
        while (i2 < c2208fc0.size()) {
            zzepVar2.zzv(c2208fc0.b(i2));
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void o(int i, Object obj, InterfaceC3814rd0 interfaceC3814rd0) {
        zzep zzepVar = this.a;
        zzepVar.zzt(i, 3);
        interfaceC3814rd0.c((zzgl) obj, zzepVar.zza);
        zzepVar.zzt(i, 4);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void p(int i, List list, boolean z) {
        if (list instanceof Nc0) {
            AbstractC3574of.a(list);
            if (!z) {
                throw null;
            }
            this.a.zzt(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzi(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzep zzepVar = this.a;
        zzepVar.zzt(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        zzepVar.zzv(i3);
        while (i2 < list.size()) {
            zzepVar.zzj(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void q(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C2208fc0)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.a.zzk(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzep zzepVar = this.a;
            zzepVar.zzt(i, 2);
            int iZzD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzD += zzep.zzD(((Integer) list.get(i3)).intValue());
            }
            zzepVar.zzv(iZzD);
            while (i2 < list.size()) {
                zzepVar.zzl(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C2208fc0 c2208fc0 = (C2208fc0) list;
        if (!z) {
            while (i2 < c2208fc0.size()) {
                this.a.zzk(i, c2208fc0.b(i2));
                i2++;
            }
            return;
        }
        zzep zzepVar2 = this.a;
        zzepVar2.zzt(i, 2);
        int iZzD2 = 0;
        for (int i4 = 0; i4 < c2208fc0.size(); i4++) {
            iZzD2 += zzep.zzD(c2208fc0.b(i4));
        }
        zzepVar2.zzv(iZzD2);
        while (i2 < c2208fc0.size()) {
            zzepVar2.zzl(c2208fc0.b(i2));
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void r(int i, long j) {
        this.a.zzi(i, j);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void s(int i, int i2) {
        this.a.zzk(i, i2);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void t(int i, int i2) {
        this.a.zzk(i, i2);
    }

    @Override // defpackage.InterfaceC4221we0
    public final void u(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C2208fc0)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzep zzepVar = this.a;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzepVar.zzu(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            zzep zzepVar2 = this.a;
            zzepVar2.zzt(i, 2);
            int iZzC = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzC += zzep.zzC((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzepVar2.zzv(iZzC);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzepVar2.zzv((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        C2208fc0 c2208fc0 = (C2208fc0) list;
        if (!z) {
            while (i2 < c2208fc0.size()) {
                zzep zzepVar3 = this.a;
                int iB = c2208fc0.b(i2);
                zzepVar3.zzu(i, (iB >> 31) ^ (iB + iB));
                i2++;
            }
            return;
        }
        zzep zzepVar4 = this.a;
        zzepVar4.zzt(i, 2);
        int iZzC2 = 0;
        for (int i4 = 0; i4 < c2208fc0.size(); i4++) {
            int iB2 = c2208fc0.b(i4);
            iZzC2 += zzep.zzC((iB2 >> 31) ^ (iB2 + iB2));
        }
        zzepVar4.zzv(iZzC2);
        while (i2 < c2208fc0.size()) {
            int iB3 = c2208fc0.b(i2);
            zzepVar4.zzv((iB3 >> 31) ^ (iB3 + iB3));
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void v(int i, double d) {
        this.a.zzi(i, Double.doubleToRawLongBits(d));
    }

    @Override // defpackage.InterfaceC4221we0
    public final void w(int i, long j) {
        this.a.zzw(i, (j >> 63) ^ (j + j));
    }

    @Override // defpackage.InterfaceC4221we0
    public final void x(int i, List list, boolean z) {
        if (list instanceof Nc0) {
            AbstractC3574of.a(list);
            if (!z) {
                throw null;
            }
            this.a.zzt(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzw(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzep zzepVar = this.a;
        zzepVar.zzt(i, 2);
        int iZzD = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzD += zzep.zzD(((Long) list.get(i3)).longValue());
        }
        zzepVar.zzv(iZzD);
        while (i2 < list.size()) {
            zzepVar.zzx(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // defpackage.InterfaceC4221we0
    public final void y(int i, float f) {
        this.a.zzg(i, Float.floatToRawIntBits(f));
    }

    @Override // defpackage.InterfaceC4221we0
    public final void z(int i, List list, boolean z) {
        if (list instanceof Nc0) {
            AbstractC3574of.a(list);
            if (!z) {
                throw null;
            }
            this.a.zzt(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzw(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzep zzepVar = this.a;
        zzepVar.zzt(i, 2);
        int iZzD = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzD += zzep.zzD(((Long) list.get(i3)).longValue());
        }
        zzepVar.zzv(iZzD);
        while (i2 < list.size()) {
            zzepVar.zzx(((Long) list.get(i2)).longValue());
            i2++;
        }
    }
}
