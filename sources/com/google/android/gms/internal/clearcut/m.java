package com.google.android.gms.internal.clearcut;

import defpackage.AbstractC4343y70;
import defpackage.Bb0;
import defpackage.H80;
import defpackage.InterfaceC3812rc0;
import defpackage.S50;
import defpackage.Ta0;
import defpackage.Ya0;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements Ta0 {
    public final zzdo a;
    public final Bb0 b;
    public final boolean c;
    public final AbstractC4343y70 d;

    public m(Bb0 bb0, AbstractC4343y70 abstractC4343y70, zzdo zzdoVar) {
        this.b = bb0;
        this.c = abstractC4343y70.g(zzdoVar);
        this.d = abstractC4343y70;
        this.a = zzdoVar;
    }

    public static m j(Bb0 bb0, AbstractC4343y70 abstractC4343y70, zzdo zzdoVar) {
        return new m(bb0, abstractC4343y70, zzdoVar);
    }

    @Override // defpackage.Ta0
    public final void a(Object obj) {
        this.b.d(obj);
        this.d.f(obj);
    }

    @Override // defpackage.Ta0
    public final void b(Object obj, Object obj2) {
        Ya0.i(this.b, obj, obj2);
        if (this.c) {
            Ya0.g(this.d, obj, obj2);
        }
    }

    @Override // defpackage.Ta0
    public final int c(Object obj) {
        Bb0 bb0 = this.b;
        int iL = bb0.l(bb0.k(obj));
        return this.c ? iL + this.d.b(obj).m() : iL;
    }

    @Override // defpackage.Ta0
    public final void d(Object obj, InterfaceC3812rc0 interfaceC3812rc0) {
        Iterator itE = this.d.b(obj).e();
        while (itE.hasNext()) {
            Map.Entry entry = (Map.Entry) itE.next();
            zzca zzcaVar = (zzca) entry.getKey();
            if (zzcaVar.zzav() != zzfq.MESSAGE || zzcaVar.zzaw() || zzcaVar.zzax()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            interfaceC3812rc0.m(zzcaVar.zzc(), entry instanceof H80 ? ((H80) entry).a().zzr() : entry.getValue());
        }
        Bb0 bb0 = this.b;
        bb0.e(bb0.k(obj), interfaceC3812rc0);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0061 A[EDGE_INSN: B:49:0x0061->B:27:0x0061 BREAK  A[LOOP:1: B:14:0x0032->B:52:0x0032], SYNTHETIC] */
    @Override // defpackage.Ta0
    public final void e(Object obj, byte[] bArr, int i, int i2, S50 s50) throws zzco {
        zzcg zzcgVar = (zzcg) obj;
        zzey zzeyVarZzeb = zzcgVar.zzjp;
        if (zzeyVarZzeb == zzey.zzea()) {
            zzeyVarZzeb = zzey.zzeb();
            zzcgVar.zzjp = zzeyVarZzeb;
        }
        zzey zzeyVar = zzeyVarZzeb;
        while (i < i2) {
            int iF = AbstractC1912g.f(bArr, i, s50);
            int i3 = s50.a;
            if (i3 != 11) {
                i = (i3 & 7) == 2 ? AbstractC1912g.b(i3, bArr, iF, i2, zzeyVar, s50) : AbstractC1912g.c(i3, bArr, iF, i2, s50);
            } else {
                int i4 = 0;
                zzbb zzbbVar = null;
                while (iF < i2) {
                    iF = AbstractC1912g.f(bArr, iF, s50);
                    int i5 = s50.a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 == 2) {
                        if (i7 != 0) {
                            if (i5 != 12) {
                                break;
                                break;
                            }
                            iF = AbstractC1912g.c(i5, bArr, iF, i2, s50);
                        } else {
                            iF = AbstractC1912g.f(bArr, iF, s50);
                            i4 = s50.a;
                        }
                    } else if (i6 != 3 || i7 != 2) {
                        if (i5 != 12) {
                            break;
                        } else {
                            iF = AbstractC1912g.c(i5, bArr, iF, i2, s50);
                        }
                    } else {
                        iF = AbstractC1912g.m(bArr, iF, s50);
                        zzbbVar = (zzbb) s50.c;
                    }
                }
                if (zzbbVar != null) {
                    zzeyVar.zzb((i4 << 3) | 2, zzbbVar);
                }
                i = iF;
            }
        }
        if (i != i2) {
            throw zzco.zzbo();
        }
    }

    @Override // defpackage.Ta0
    public final boolean f(Object obj, Object obj2) {
        if (!this.b.k(obj).equals(this.b.k(obj2))) {
            return false;
        }
        if (this.c) {
            return this.d.b(obj).equals(this.d.b(obj2));
        }
        return true;
    }

    @Override // defpackage.Ta0
    public final Object g() {
        return this.a.zzbd().zzbi();
    }

    @Override // defpackage.Ta0
    public final boolean h(Object obj) {
        return this.d.b(obj).d();
    }

    @Override // defpackage.Ta0
    public final int i(Object obj) {
        int iHashCode = this.b.k(obj).hashCode();
        return this.c ? (iHashCode * 53) + this.d.b(obj).hashCode() : iHashCode;
    }
}
