package com.google.android.gms.internal.vision;

import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC3574of;
import defpackage.AbstractC3897se0;
import defpackage.AbstractC3899sf0;
import defpackage.C4142vf0;
import defpackage.Df0;
import defpackage.InterfaceC3167jg0;
import defpackage.InterfaceC3249kg0;
import defpackage.Pf0;
import defpackage.Ve0;
import defpackage.Yf0;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements InterfaceC3249kg0 {
    public final zzif a;
    public int b;
    public int c;
    public int d = 0;

    public t(zzif zzifVar) {
        zzif zzifVar2 = (zzif) zzjf.zza(zzifVar, HTML.Tag.INPUT);
        this.a = zzifVar2;
        zzifVar2.zzc = this;
    }

    public static t A(zzif zzifVar) {
        t tVar = zzifVar.zzc;
        return tVar != null ? tVar : new t(zzifVar);
    }

    private final void B(int i) throws zzjn {
        if ((this.b & 7) != i) {
            throw zzjk.zzf();
        }
    }

    private final void C(List list, boolean z) throws zzjn {
        int iZza;
        int iZza2;
        if ((this.b & 7) != 2) {
            throw zzjk.zzf();
        }
        if (!(list instanceof zzjv) || z) {
            do {
                list.add(z ? zzm() : o());
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza = this.a.zza();
                }
            } while (iZza == this.b);
            this.d = iZza;
            return;
        }
        zzjv zzjvVar = (zzjv) list;
        do {
            zzjvVar.zza(f());
            if (this.a.zzt()) {
                return;
            } else {
                iZza2 = this.a.zza();
            }
        } while (iZza2 == this.b);
        this.d = iZza2;
    }

    private static void D(int i) throws zzjk {
        if ((i & 7) != 0) {
            throw zzjk.zzg();
        }
    }

    private final Object E(InterfaceC3167jg0 interfaceC3167jg0, zzio zzioVar) throws zzjk {
        int iZzm = this.a.zzm();
        zzif zzifVar = this.a;
        if (zzifVar.zza >= zzifVar.zzb) {
            throw new zzjk("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZzc = zzifVar.zzc(iZzm);
        Object objZza = interfaceC3167jg0.zza();
        this.a.zza++;
        interfaceC3167jg0.f(objZza, this, zzioVar);
        interfaceC3167jg0.a(objZza);
        this.a.zza(0);
        zzif zzifVar2 = this.a;
        zzifVar2.zza--;
        zzifVar2.zzd(iZzc);
        return objZza;
    }

    private static void F(int i) throws zzjk {
        if ((i & 3) != 0) {
            throw zzjk.zzg();
        }
    }

    private final Object G(InterfaceC3167jg0 interfaceC3167jg0, zzio zzioVar) {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            Object objZza = interfaceC3167jg0.zza();
            interfaceC3167jg0.f(objZza, this, zzioVar);
            interfaceC3167jg0.a(objZza);
            if (this.b != this.c) {
                throw zzjk.zzg();
            }
            this.c = i;
            return objZza;
        } catch (Throwable th) {
            this.c = i;
            throw th;
        }
    }

    private final void H(int i) throws zzjk {
        if (this.a.zzu() != i) {
            throw zzjk.zza();
        }
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void a(List list) throws zzjk {
        int iZza;
        if (list instanceof AbstractC3897se0) {
            AbstractC3574of.a(list);
            int i = this.b & 7;
            if (i == 0) {
                this.a.zzi();
                throw null;
            }
            if (i != 2) {
                throw zzjk.zzf();
            }
            this.a.zzm();
            this.a.zzu();
            this.a.zzi();
            throw null;
        }
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                list.add(Boolean.valueOf(this.a.zzi()));
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza = this.a.zza();
                }
            } while (iZza == this.b);
            this.d = iZza;
            return;
        }
        if (i2 != 2) {
            throw zzjk.zzf();
        }
        int iZzu = this.a.zzu() + this.a.zzm();
        do {
            list.add(Boolean.valueOf(this.a.zzi()));
        } while (this.a.zzu() < iZzu);
        H(iZzu);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void b(List list) throws zzjk {
        int iZza;
        int iZza2;
        if (!(list instanceof C4142vf0)) {
            int i = this.b & 7;
            if (i == 2) {
                int iZzm = this.a.zzm();
                F(iZzm);
                int iZzu = this.a.zzu() + iZzm;
                do {
                    list.add(Integer.valueOf(this.a.zzh()));
                } while (this.a.zzu() < iZzu);
                return;
            }
            if (i != 5) {
                throw zzjk.zzf();
            }
            do {
                list.add(Integer.valueOf(this.a.zzh()));
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza = this.a.zza();
                }
            } while (iZza == this.b);
            this.d = iZza;
            return;
        }
        C4142vf0 c4142vf0 = (C4142vf0) list;
        int i2 = this.b & 7;
        if (i2 == 2) {
            int iZzm2 = this.a.zzm();
            F(iZzm2);
            int iZzu2 = this.a.zzu() + iZzm2;
            do {
                c4142vf0.b(this.a.zzh());
            } while (this.a.zzu() < iZzu2);
            return;
        }
        if (i2 != 5) {
            throw zzjk.zzf();
        }
        do {
            c4142vf0.b(this.a.zzh());
            if (this.a.zzt()) {
                return;
            } else {
                iZza2 = this.a.zza();
            }
        } while (iZza2 == this.b);
        this.d = iZza2;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void c(List list) throws zzjk {
        int iZza;
        int iZza2;
        if (!(list instanceof C4142vf0)) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.a.zzq()));
                    if (this.a.zzt()) {
                        return;
                    } else {
                        iZza = this.a.zza();
                    }
                } while (iZza == this.b);
                this.d = iZza;
                return;
            }
            if (i != 2) {
                throw zzjk.zzf();
            }
            int iZzu = this.a.zzu() + this.a.zzm();
            do {
                list.add(Integer.valueOf(this.a.zzq()));
            } while (this.a.zzu() < iZzu);
            H(iZzu);
            return;
        }
        C4142vf0 c4142vf0 = (C4142vf0) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                c4142vf0.b(this.a.zzq());
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza2 = this.a.zza();
                }
            } while (iZza2 == this.b);
            this.d = iZza2;
            return;
        }
        if (i2 != 2) {
            throw zzjk.zzf();
        }
        int iZzu2 = this.a.zzu() + this.a.zzm();
        do {
            c4142vf0.b(this.a.zzq());
        } while (this.a.zzu() < iZzu2);
        H(iZzu2);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void d(List list) throws zzjk {
        int iZza;
        if (list instanceof Df0) {
            AbstractC3574of.a(list);
            int i = this.b & 7;
            if (i == 1) {
                this.a.zzp();
                throw null;
            }
            if (i != 2) {
                throw zzjk.zzf();
            }
            D(this.a.zzm());
            this.a.zzu();
            this.a.zzp();
            throw null;
        }
        int i2 = this.b & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.a.zzp()));
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza = this.a.zza();
                }
            } while (iZza == this.b);
            this.d = iZza;
            return;
        }
        if (i2 != 2) {
            throw zzjk.zzf();
        }
        int iZzm = this.a.zzm();
        D(iZzm);
        int iZzu = this.a.zzu() + iZzm;
        do {
            list.add(Long.valueOf(this.a.zzp()));
        } while (this.a.zzu() < iZzu);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void e(List list) throws zzjk {
        int iZza;
        if (list instanceof Df0) {
            AbstractC3574of.a(list);
            int i = this.b & 7;
            if (i == 1) {
                this.a.zzg();
                throw null;
            }
            if (i != 2) {
                throw zzjk.zzf();
            }
            D(this.a.zzm());
            this.a.zzu();
            this.a.zzg();
            throw null;
        }
        int i2 = this.b & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.a.zzg()));
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza = this.a.zza();
                }
            } while (iZza == this.b);
            this.d = iZza;
            return;
        }
        if (i2 != 2) {
            throw zzjk.zzf();
        }
        int iZzm = this.a.zzm();
        D(iZzm);
        int iZzu = this.a.zzu() + iZzm;
        do {
            list.add(Long.valueOf(this.a.zzg()));
        } while (this.a.zzu() < iZzu);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final zzht f() throws zzjn {
        B(2);
        return this.a.zzl();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void g(List list) throws zzjn {
        C(list, true);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void h(List list) throws zzjk {
        int iZza;
        if (list instanceof Ve0) {
            AbstractC3574of.a(list);
            int i = this.b & 7;
            if (i == 1) {
                this.a.zzb();
                throw null;
            }
            if (i != 2) {
                throw zzjk.zzf();
            }
            D(this.a.zzm());
            this.a.zzu();
            this.a.zzb();
            throw null;
        }
        int i2 = this.b & 7;
        if (i2 == 1) {
            do {
                list.add(Double.valueOf(this.a.zzb()));
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza = this.a.zza();
                }
            } while (iZza == this.b);
            this.d = iZza;
            return;
        }
        if (i2 != 2) {
            throw zzjk.zzf();
        }
        int iZzm = this.a.zzm();
        D(iZzm);
        int iZzu = this.a.zzu() + iZzm;
        do {
            list.add(Double.valueOf(this.a.zzb()));
        } while (this.a.zzu() < iZzu);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int i() throws zzjn {
        B(0);
        return this.a.zzm();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final Object j(InterfaceC3167jg0 interfaceC3167jg0, zzio zzioVar) throws zzjn {
        B(2);
        return E(interfaceC3167jg0, zzioVar);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void k(List list) throws zzjn {
        C(list, false);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void l(List list) throws zzjk {
        int iZza;
        if (list instanceof Df0) {
            AbstractC3574of.a(list);
            int i = this.b & 7;
            if (i == 0) {
                this.a.zzr();
                throw null;
            }
            if (i != 2) {
                throw zzjk.zzf();
            }
            this.a.zzm();
            this.a.zzu();
            this.a.zzr();
            throw null;
        }
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.a.zzr()));
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza = this.a.zza();
                }
            } while (iZza == this.b);
            this.d = iZza;
            return;
        }
        if (i2 != 2) {
            throw zzjk.zzf();
        }
        int iZzu = this.a.zzu() + this.a.zzm();
        do {
            list.add(Long.valueOf(this.a.zzr()));
        } while (this.a.zzu() < iZzu);
        H(iZzu);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final Object m(InterfaceC3167jg0 interfaceC3167jg0, zzio zzioVar) throws zzjn {
        B(3);
        return G(interfaceC3167jg0, zzioVar);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void n(List list) throws zzjk {
        int iZza;
        int iZza2;
        if (!(list instanceof C4142vf0)) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.a.zzm()));
                    if (this.a.zzt()) {
                        return;
                    } else {
                        iZza = this.a.zza();
                    }
                } while (iZza == this.b);
                this.d = iZza;
                return;
            }
            if (i != 2) {
                throw zzjk.zzf();
            }
            int iZzu = this.a.zzu() + this.a.zzm();
            do {
                list.add(Integer.valueOf(this.a.zzm()));
            } while (this.a.zzu() < iZzu);
            H(iZzu);
            return;
        }
        C4142vf0 c4142vf0 = (C4142vf0) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                c4142vf0.b(this.a.zzm());
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza2 = this.a.zza();
                }
            } while (iZza2 == this.b);
            this.d = iZza2;
            return;
        }
        if (i2 != 2) {
            throw zzjk.zzf();
        }
        int iZzu2 = this.a.zzu() + this.a.zzm();
        do {
            c4142vf0.b(this.a.zzm());
        } while (this.a.zzu() < iZzu2);
        H(iZzu2);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final String o() throws zzjn {
        B(2);
        return this.a.zzj();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void p(List list, InterfaceC3167jg0 interfaceC3167jg0, zzio zzioVar) throws zzjn {
        int iZza;
        int i = this.b;
        if ((i & 7) != 3) {
            throw zzjk.zzf();
        }
        do {
            list.add(G(interfaceC3167jg0, zzioVar));
            if (this.a.zzt() || this.d != 0) {
                return;
            } else {
                iZza = this.a.zza();
            }
        } while (iZza == i);
        this.d = iZza;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void q(List list) throws zzjk {
        int iZza;
        if (list instanceof Df0) {
            AbstractC3574of.a(list);
            int i = this.b & 7;
            if (i == 0) {
                this.a.zzd();
                throw null;
            }
            if (i != 2) {
                throw zzjk.zzf();
            }
            this.a.zzm();
            this.a.zzu();
            this.a.zzd();
            throw null;
        }
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.a.zzd()));
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza = this.a.zza();
                }
            } while (iZza == this.b);
            this.d = iZza;
            return;
        }
        if (i2 != 2) {
            throw zzjk.zzf();
        }
        int iZzu = this.a.zzu() + this.a.zzm();
        do {
            list.add(Long.valueOf(this.a.zzd()));
        } while (this.a.zzu() < iZzu);
        H(iZzu);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void r(List list) throws zzjn {
        int iZza;
        if ((this.b & 7) != 2) {
            throw zzjk.zzf();
        }
        do {
            list.add(f());
            if (this.a.zzt()) {
                return;
            } else {
                iZza = this.a.zza();
            }
        } while (iZza == this.b);
        this.d = iZza;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void s(List list, InterfaceC3167jg0 interfaceC3167jg0, zzio zzioVar) throws zzjn {
        int iZza;
        int i = this.b;
        if ((i & 7) != 2) {
            throw zzjk.zzf();
        }
        do {
            list.add(E(interfaceC3167jg0, zzioVar));
            if (this.a.zzt() || this.d != 0) {
                return;
            } else {
                iZza = this.a.zza();
            }
        } while (iZza == i);
        this.d = iZza;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void t(List list) throws zzjk {
        int iZza;
        int iZza2;
        if (!(list instanceof C4142vf0)) {
            int i = this.b & 7;
            if (i == 2) {
                int iZzm = this.a.zzm();
                F(iZzm);
                int iZzu = this.a.zzu() + iZzm;
                do {
                    list.add(Integer.valueOf(this.a.zzo()));
                } while (this.a.zzu() < iZzu);
                return;
            }
            if (i != 5) {
                throw zzjk.zzf();
            }
            do {
                list.add(Integer.valueOf(this.a.zzo()));
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza = this.a.zza();
                }
            } while (iZza == this.b);
            this.d = iZza;
            return;
        }
        C4142vf0 c4142vf0 = (C4142vf0) list;
        int i2 = this.b & 7;
        if (i2 == 2) {
            int iZzm2 = this.a.zzm();
            F(iZzm2);
            int iZzu2 = this.a.zzu() + iZzm2;
            do {
                c4142vf0.b(this.a.zzo());
            } while (this.a.zzu() < iZzu2);
            return;
        }
        if (i2 != 5) {
            throw zzjk.zzf();
        }
        do {
            c4142vf0.b(this.a.zzo());
            if (this.a.zzt()) {
                return;
            } else {
                iZza2 = this.a.zza();
            }
        } while (iZza2 == this.b);
        this.d = iZza2;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final Object u(Class cls, zzio zzioVar) throws zzjn {
        B(3);
        return G(Yf0.a().b(cls), zzioVar);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void v(List list) throws zzjk {
        int iZza;
        int iZza2;
        if (!(list instanceof C4142vf0)) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.a.zzf()));
                    if (this.a.zzt()) {
                        return;
                    } else {
                        iZza = this.a.zza();
                    }
                } while (iZza == this.b);
                this.d = iZza;
                return;
            }
            if (i != 2) {
                throw zzjk.zzf();
            }
            int iZzu = this.a.zzu() + this.a.zzm();
            do {
                list.add(Integer.valueOf(this.a.zzf()));
            } while (this.a.zzu() < iZzu);
            H(iZzu);
            return;
        }
        C4142vf0 c4142vf0 = (C4142vf0) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                c4142vf0.b(this.a.zzf());
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza2 = this.a.zza();
                }
            } while (iZza2 == this.b);
            this.d = iZza2;
            return;
        }
        if (i2 != 2) {
            throw zzjk.zzf();
        }
        int iZzu2 = this.a.zzu() + this.a.zzm();
        do {
            c4142vf0.b(this.a.zzf());
        } while (this.a.zzu() < iZzu2);
        H(iZzu2);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void w(List list) throws zzjk {
        int iZza;
        int iZza2;
        if (!(list instanceof C4142vf0)) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(this.a.zzn()));
                    if (this.a.zzt()) {
                        return;
                    } else {
                        iZza = this.a.zza();
                    }
                } while (iZza == this.b);
                this.d = iZza;
                return;
            }
            if (i != 2) {
                throw zzjk.zzf();
            }
            int iZzu = this.a.zzu() + this.a.zzm();
            do {
                list.add(Integer.valueOf(this.a.zzn()));
            } while (this.a.zzu() < iZzu);
            H(iZzu);
            return;
        }
        C4142vf0 c4142vf0 = (C4142vf0) list;
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                c4142vf0.b(this.a.zzn());
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza2 = this.a.zza();
                }
            } while (iZza2 == this.b);
            this.d = iZza2;
            return;
        }
        if (i2 != 2) {
            throw zzjk.zzf();
        }
        int iZzu2 = this.a.zzu() + this.a.zzm();
        do {
            c4142vf0.b(this.a.zzn());
        } while (this.a.zzu() < iZzu2);
        H(iZzu2);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final Object x(Class cls, zzio zzioVar) throws zzjn {
        B(2);
        return E(Yf0.a().b(cls), zzioVar);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void y(List list) throws zzjk {
        int iZza;
        if (list instanceof Df0) {
            AbstractC3574of.a(list);
            int i = this.b & 7;
            if (i == 0) {
                this.a.zze();
                throw null;
            }
            if (i != 2) {
                throw zzjk.zzf();
            }
            this.a.zzm();
            this.a.zzu();
            this.a.zze();
            throw null;
        }
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.a.zze()));
                if (this.a.zzt()) {
                    return;
                } else {
                    iZza = this.a.zza();
                }
            } while (iZza == this.b);
            this.d = iZza;
            return;
        }
        if (i2 != 2) {
            throw zzjk.zzf();
        }
        int iZzu = this.a.zzu() + this.a.zzm();
        do {
            list.add(Long.valueOf(this.a.zze()));
        } while (this.a.zzu() < iZzu);
        H(iZzu);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void z(Map map, Pf0 pf0, zzio zzioVar) throws zzjn {
        B(2);
        this.a.zzc(this.a.zzm());
        throw null;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zza() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.a.zza();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zzb() {
        return this.b;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final boolean zzc() {
        int i;
        if (this.a.zzt() || (i = this.b) == this.c) {
            return false;
        }
        return this.a.zzb(i);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final double zzd() throws zzjn {
        B(1);
        return this.a.zzb();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final float zze() throws zzjn {
        B(5);
        return this.a.zzc();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final long zzf() throws zzjn {
        B(0);
        return this.a.zzd();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final long zzg() throws zzjn {
        B(0);
        return this.a.zze();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zzh() throws zzjn {
        B(0);
        return this.a.zzf();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final long zzi() throws zzjn {
        B(1);
        return this.a.zzg();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zzj() throws zzjn {
        B(5);
        return this.a.zzh();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final boolean zzk() throws zzjn {
        B(0);
        return this.a.zzi();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final String zzm() throws zzjn {
        B(2);
        return this.a.zzk();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zzp() throws zzjn {
        B(0);
        return this.a.zzn();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zzq() throws zzjn {
        B(5);
        return this.a.zzo();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final long zzr() throws zzjn {
        B(1);
        return this.a.zzp();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zzs() throws zzjn {
        B(0);
        return this.a.zzq();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final long zzt() throws zzjn {
        B(0);
        return this.a.zzr();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void zzb(List list) throws zzjk {
        int iZza;
        if (list instanceof AbstractC3899sf0) {
            AbstractC3574of.a(list);
            int i = this.b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzjk.zzf();
                }
                this.a.zzc();
                throw null;
            }
            F(this.a.zzm());
            this.a.zzu();
            this.a.zzc();
            throw null;
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int iZzm = this.a.zzm();
            F(iZzm);
            int iZzu = this.a.zzu() + iZzm;
            do {
                list.add(Float.valueOf(this.a.zzc()));
            } while (this.a.zzu() < iZzu);
            return;
        }
        if (i2 != 5) {
            throw zzjk.zzf();
        }
        do {
            list.add(Float.valueOf(this.a.zzc()));
            if (this.a.zzt()) {
                return;
            } else {
                iZza = this.a.zza();
            }
        } while (iZza == this.b);
        this.d = iZza;
    }
}
