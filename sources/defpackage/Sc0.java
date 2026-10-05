package defpackage;

import com.google.android.gms.internal.play_billing.u;
import com.google.android.gms.internal.play_billing.v;
import com.google.android.gms.internal.play_billing.w;
import com.google.android.gms.internal.play_billing.zzfi;
import com.google.android.gms.internal.play_billing.zzfo;

/* JADX INFO: loaded from: classes2.dex */
public final class Sc0 implements InterfaceC3895sd0 {
    public static final InterfaceC1889cd0 b = new Oc0();
    public final InterfaceC1889cd0 a;

    public Sc0() {
        Tb0 tb0C = Tb0.c();
        C3407md0 c3407md0 = C3407md0.c;
        Qc0 qc0 = new Qc0(tb0C, b);
        byte[] bArr = zzfo.zzb;
        this.a = qc0;
    }

    @Override // defpackage.InterfaceC3895sd0
    public final InterfaceC3814rd0 a(Class cls) {
        Xd0 xd0 = w.a;
        if (!zzfi.class.isAssignableFrom(cls)) {
            C3407md0 c3407md0 = C3407md0.c;
        }
        InterfaceC1242ad0 interfaceC1242ad0B = this.a.b(cls);
        if (interfaceC1242ad0B.zzb()) {
            C3407md0 c3407md1 = C3407md0.c;
            return v.g(w.r(), AbstractC4468zb0.a(), interfaceC1242ad0B.zza());
        }
        C3407md0 c3407md2 = C3407md0.c;
        return u.x(cls, interfaceC1242ad0B, AbstractC3325ld0.a(), AbstractC4470zc0.a(), w.r(), interfaceC1242ad0B.zzc() + (-1) != 1 ? AbstractC4468zb0.a() : null, Yc0.a());
    }
}
