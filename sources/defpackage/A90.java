package defpackage;

import com.google.android.gms.internal.clearcut.C1917l;
import com.google.android.gms.internal.clearcut.m;
import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzci;

/* JADX INFO: loaded from: classes2.dex */
public final class A90 implements Ua0 {
    public static final T90 b = new B90();
    public final T90 a;

    public A90() {
        this(new C90(C3617p80.c(), c()));
    }

    public static boolean b(P90 p90) {
        return p90.a() == zzcg.zzg.zzkl;
    }

    public static T90 c() {
        try {
            return (T90) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return b;
        }
    }

    @Override // defpackage.Ua0
    public final Ta0 a(Class cls) {
        Ya0.I(cls);
        P90 p90B = this.a.b(cls);
        if (p90B.b()) {
            return zzcg.class.isAssignableFrom(cls) ? m.j(Ya0.B(), E70.b(), p90B.c()) : m.j(Ya0.z(), E70.c(), p90B.c());
        }
        if (!zzcg.class.isAssignableFrom(cls)) {
            boolean zB = b(p90B);
            InterfaceC3155ja0 interfaceC3155ja0A = AbstractC3728qa0.a();
            X80 x80C = X80.c();
            return zB ? C1917l.s(cls, p90B, interfaceC3155ja0A, x80C, Ya0.z(), E70.c(), M90.a()) : C1917l.s(cls, p90B, interfaceC3155ja0A, x80C, Ya0.A(), null, M90.a());
        }
        boolean zB2 = b(p90B);
        InterfaceC3155ja0 interfaceC3155ja0B = AbstractC3728qa0.b();
        X80 x80D = X80.d();
        Bb0 bb0B = Ya0.B();
        return zB2 ? C1917l.s(cls, p90B, interfaceC3155ja0B, x80D, bb0B, E70.b(), M90.b()) : C1917l.s(cls, p90B, interfaceC3155ja0B, x80D, bb0B, null, M90.b());
    }

    public A90(T90 t90) {
        this.a = (T90) zzci.zza(t90, "messageInfoFactory");
    }
}
