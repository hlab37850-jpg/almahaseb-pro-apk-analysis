package com.google.android.gms.internal.vision;

import defpackage.AbstractC3331lg0;
import defpackage.Ag0;
import defpackage.C1812bf0;
import defpackage.C3327le0;
import defpackage.C4476zf0;
import defpackage.InterfaceC3167jg0;
import defpackage.InterfaceC3249kg0;
import defpackage.Wg0;
import defpackage.Xe0;
import defpackage.Yf0;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements InterfaceC3167jg0 {
    public final zzkk a;
    public final Ag0 b;
    public final boolean c;
    public final Xe0 d;

    public z(Ag0 ag0, Xe0 xe0, zzkk zzkkVar) {
        this.b = ag0;
        this.c = xe0.h(zzkkVar);
        this.d = xe0;
        this.a = zzkkVar;
    }

    public static z h(Ag0 ag0, Xe0 xe0, zzkk zzkkVar) {
        return new z(ag0, xe0, zzkkVar);
    }

    @Override // defpackage.InterfaceC3167jg0
    public final void a(Object obj) {
        this.b.q(obj);
        this.d.j(obj);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00be A[EDGE_INSN: B:57:0x00be->B:33:0x00be BREAK  A[LOOP:1: B:18:0x0067->B:60:0x0067], SYNTHETIC] */
    @Override // defpackage.InterfaceC3167jg0
    public final void b(Object obj, byte[] bArr, int i, int i2, C3327le0 c3327le0) throws zzjk {
        zzjb zzjbVar = (zzjb) obj;
        zzlx zzlxVarZzb = zzjbVar.zzb;
        if (zzlxVarZzb == zzlx.zza()) {
            zzlxVarZzb = zzlx.zzb();
            zzjbVar.zzb = zzlxVarZzb;
        }
        C1812bf0 c1812bf0Zza = ((zzjb.zzc) obj).zza();
        zzjb.zze zzeVar = null;
        while (i < i2) {
            int iJ = r.j(bArr, i, c3327le0);
            int i3 = c3327le0.a;
            if (i3 == 11) {
                int i4 = 0;
                zzht zzhtVar = null;
                while (iJ < i2) {
                    iJ = r.j(bArr, iJ, c3327le0);
                    int i5 = c3327le0.a;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 == 2) {
                        if (i7 != 0) {
                            if (i5 != 12) {
                                break;
                                break;
                            }
                            iJ = r.c(i5, bArr, iJ, i2, c3327le0);
                        } else {
                            iJ = r.j(bArr, iJ, c3327le0);
                            i4 = c3327le0.a;
                            zzeVar = (zzjb.zze) this.d.b(c3327le0.d, this.a, i4);
                        }
                    } else {
                        if (i6 == 3) {
                            if (zzeVar != null) {
                                iJ = r.g(Yf0.a().b(zzeVar.zzc.getClass()), bArr, iJ, i2, c3327le0);
                                c1812bf0Zza.f(zzeVar.zzd, c3327le0.c);
                            } else if (i7 == 2) {
                                iJ = r.q(bArr, iJ, c3327le0);
                                zzhtVar = (zzht) c3327le0.c;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        } else {
                            iJ = r.c(i5, bArr, iJ, i2, c3327le0);
                        }
                    }
                }
                if (zzhtVar != null) {
                    zzlxVarZzb.zza((i4 << 3) | 2, zzhtVar);
                }
                i = iJ;
            } else if ((i3 & 7) == 2) {
                zzjb.zze zzeVar2 = (zzjb.zze) this.d.b(c3327le0.d, this.a, i3 >>> 3);
                if (zzeVar2 != null) {
                    i = r.g(Yf0.a().b(zzeVar2.zzc.getClass()), bArr, iJ, i2, c3327le0);
                    c1812bf0Zza.f(zzeVar2.zzd, c3327le0.c);
                } else {
                    i = r.b(i3, bArr, iJ, i2, zzlxVarZzb, c3327le0);
                }
                zzeVar = zzeVar2;
            } else {
                i = r.c(i3, bArr, iJ, i2, c3327le0);
            }
        }
        if (i != i2) {
            throw zzjk.zzg();
        }
    }

    @Override // defpackage.InterfaceC3167jg0
    public final void c(Object obj, Object obj2) {
        AbstractC3331lg0.p(this.b, obj, obj2);
        if (this.c) {
            AbstractC3331lg0.n(this.d, obj, obj2);
        }
    }

    @Override // defpackage.InterfaceC3167jg0
    public final boolean d(Object obj) {
        return this.d.d(obj).r();
    }

    @Override // defpackage.InterfaceC3167jg0
    public final boolean e(Object obj, Object obj2) {
        if (!this.b.k(obj).equals(this.b.k(obj2))) {
            return false;
        }
        if (this.c) {
            return this.d.d(obj).equals(this.d.d(obj2));
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:? A[LOOP:0: B:46:0x000c->B:54:?, LOOP_END, SYNTHETIC] */
    @Override // defpackage.InterfaceC3167jg0
    public final void f(Object obj, InterfaceC3249kg0 interfaceC3249kg0, zzio zzioVar) {
        boolean zZzc;
        Ag0 ag0 = this.b;
        Xe0 xe0 = this.d;
        Object objO = ag0.o(obj);
        C1812bf0 c1812bf0I = xe0.i(obj);
        while (interfaceC3249kg0.zza() != Integer.MAX_VALUE) {
            try {
                int iZzb = interfaceC3249kg0.zzb();
                if (iZzb != 11) {
                    if ((iZzb & 7) == 2) {
                        Object objB = xe0.b(zzioVar, this.a, iZzb >>> 3);
                        if (objB != null) {
                            xe0.f(interfaceC3249kg0, objB, zzioVar, c1812bf0I);
                        } else {
                            zZzc = ag0.i(objO, interfaceC3249kg0);
                        }
                    } else {
                        zZzc = interfaceC3249kg0.zzc();
                    }
                    if (!zZzc) {
                        ag0.m(obj, objO);
                        return;
                    }
                } else {
                    Object objB2 = null;
                    zzht zzhtVarF = null;
                    int i = 0;
                    while (interfaceC3249kg0.zza() != Integer.MAX_VALUE) {
                        int iZzb2 = interfaceC3249kg0.zzb();
                        if (iZzb2 == 16) {
                            i = interfaceC3249kg0.i();
                            objB2 = xe0.b(zzioVar, this.a, i);
                        } else if (iZzb2 == 26) {
                            if (objB2 != null) {
                                xe0.f(interfaceC3249kg0, objB2, zzioVar, c1812bf0I);
                            } else {
                                zzhtVarF = interfaceC3249kg0.f();
                            }
                        } else if (!interfaceC3249kg0.zzc()) {
                            break;
                        }
                    }
                    if (interfaceC3249kg0.zzb() != 12) {
                        throw zzjk.zze();
                    }
                    if (zzhtVarF != null) {
                        if (objB2 != null) {
                            xe0.e(zzhtVarF, objB2, zzioVar, c1812bf0I);
                        } else {
                            ag0.e(objO, i, zzhtVarF);
                        }
                    }
                }
                zZzc = true;
                if (!zZzc) {
                    ag0.m(obj, objO);
                    return;
                }
            } catch (Throwable th) {
                ag0.m(obj, objO);
                throw th;
            }
        }
        ag0.m(obj, objO);
    }

    @Override // defpackage.InterfaceC3167jg0
    public final void g(Object obj, Wg0 wg0) {
        Iterator itO = this.d.d(obj).o();
        while (itO.hasNext()) {
            Map.Entry entry = (Map.Entry) itO.next();
            zziw zziwVar = (zziw) entry.getKey();
            if (zziwVar.zzc() != zzmo.MESSAGE || zziwVar.zzd() || zziwVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof C4476zf0) {
                wg0.m(zziwVar.zza(), ((C4476zf0) entry).a().zzc());
            } else {
                wg0.m(zziwVar.zza(), entry.getValue());
            }
        }
        Ag0 ag0 = this.b;
        ag0.n(ag0.k(obj), wg0);
    }

    @Override // defpackage.InterfaceC3167jg0
    public final Object zza() {
        return this.a.zzq().zze();
    }

    @Override // defpackage.InterfaceC3167jg0
    public final int zzb(Object obj) {
        Ag0 ag0 = this.b;
        int iR = ag0.r(ag0.k(obj));
        return this.c ? iR + this.d.d(obj).s() : iR;
    }

    @Override // defpackage.InterfaceC3167jg0
    public final int zza(Object obj) {
        int iHashCode = this.b.k(obj).hashCode();
        return this.c ? (iHashCode * 53) + this.d.d(obj).hashCode() : iHashCode;
    }
}
