package defpackage;

import com.google.android.gms.internal.vision.x;
import com.google.android.gms.internal.vision.z;
import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.internal.vision.zzjf;
import com.google.android.gms.internal.vision.zzkz;

/* JADX INFO: loaded from: classes2.dex */
public final class Nf0 implements InterfaceC3413mg0 {
    public static final Uf0 b = new Mf0();
    public final Uf0 a;

    public Nf0() {
        this(new Of0(C3980tf0.c(), b()));
    }

    public static Uf0 b() {
        try {
            return (Uf0) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return b;
        }
    }

    public static boolean c(Sf0 sf0) {
        return sf0.zza() == zzkz.zza;
    }

    @Override // defpackage.InterfaceC3413mg0
    public final InterfaceC3167jg0 a(Class cls) {
        AbstractC3331lg0.m(cls);
        Sf0 sf0B = this.a.b(cls);
        if (sf0B.zzb()) {
            return zzjb.class.isAssignableFrom(cls) ? z.h(AbstractC3331lg0.B(), Ye0.a(), sf0B.zzc()) : z.h(AbstractC3331lg0.h(), Ye0.b(), sf0B.zzc());
        }
        if (zzjb.class.isAssignableFrom(cls)) {
            return c(sf0B) ? x.n(cls, sf0B, Wf0.b(), Af0.d(), AbstractC3331lg0.B(), Ye0.a(), Tf0.b()) : x.n(cls, sf0B, Wf0.b(), Af0.d(), AbstractC3331lg0.B(), null, Tf0.b());
        }
        return c(sf0B) ? x.n(cls, sf0B, Wf0.a(), Af0.b(), AbstractC3331lg0.h(), Ye0.b(), Tf0.a()) : x.n(cls, sf0B, Wf0.a(), Af0.b(), AbstractC3331lg0.v(), null, Tf0.a());
    }

    public Nf0(Uf0 uf0) {
        this.a = (Uf0) zzjf.zza(uf0, "messageInfoFactory");
    }
}
