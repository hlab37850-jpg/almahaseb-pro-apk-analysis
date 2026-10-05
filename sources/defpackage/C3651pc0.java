package defpackage;

import com.google.android.gms.internal.auth.d;
import com.google.android.gms.internal.auth.e;
import com.google.android.gms.internal.auth.zzeu;
import com.google.android.gms.internal.auth.zzez;

/* JADX INFO: renamed from: pc0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3651pc0 implements InterfaceC1808bd0 {
    public static final InterfaceC4298xc0 b = new C3323lc0();
    public final InterfaceC4298xc0 a;

    public C3651pc0() {
        InterfaceC4298xc0 interfaceC4298xc0;
        C3730qb0 c3730qb0C = C3730qb0.c();
        try {
            interfaceC4298xc0 = (InterfaceC4298xc0) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            interfaceC4298xc0 = b;
        }
        C3487nc0 c3487nc0 = new C3487nc0(c3730qb0C, interfaceC4298xc0);
        zzez.zzf(c3487nc0, "messageInfoFactory");
        this.a = c3487nc0;
    }

    public static boolean b(InterfaceC4217wc0 interfaceC4217wc0) {
        return interfaceC4217wc0.zzc() == 1;
    }

    @Override // defpackage.InterfaceC1808bd0
    public final Zc0 a(Class cls) {
        AbstractC2047dd0.g(cls);
        InterfaceC4217wc0 interfaceC4217wc0B = this.a.b(cls);
        if (interfaceC4217wc0B.zzb()) {
            return zzeu.class.isAssignableFrom(cls) ? e.a(AbstractC2047dd0.c(), AbstractC2370hb0.b(), interfaceC4217wc0B.zza()) : e.a(AbstractC2047dd0.a(), AbstractC2370hb0.a(), interfaceC4217wc0B.zza());
        }
        if (zzeu.class.isAssignableFrom(cls)) {
            return b(interfaceC4217wc0B) ? d.r(cls, interfaceC4217wc0B, Rc0.b(), AbstractC3159jc0.d(), AbstractC2047dd0.c(), AbstractC2370hb0.b(), AbstractC4055uc0.b()) : d.r(cls, interfaceC4217wc0B, Rc0.b(), AbstractC3159jc0.d(), AbstractC2047dd0.c(), null, AbstractC4055uc0.b());
        }
        return b(interfaceC4217wc0B) ? d.r(cls, interfaceC4217wc0B, Rc0.a(), AbstractC3159jc0.c(), AbstractC2047dd0.a(), AbstractC2370hb0.a(), AbstractC4055uc0.a()) : d.r(cls, interfaceC4217wc0B, Rc0.a(), AbstractC3159jc0.c(), AbstractC2047dd0.b(), null, AbstractC4055uc0.a());
    }
}
