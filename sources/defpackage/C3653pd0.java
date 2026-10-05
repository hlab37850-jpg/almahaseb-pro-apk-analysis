package defpackage;

import com.google.android.gms.internal.play_billing.zzgl;

/* JADX INFO: renamed from: pd0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3653pd0 implements InterfaceC1242ad0 {
    public final zzgl a;
    public final String b;
    public final Object[] c;
    public final int d;

    public C3653pd0(zzgl zzglVar, String str, Object[] objArr) {
        this.a = zzglVar;
        this.b = str;
        this.c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 1;
        int i3 = 13;
        while (true) {
            int i4 = i2 + 1;
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 55296) {
                this.d = i | (cCharAt2 << i3);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i2 = i4;
            }
        }
    }

    public final String a() {
        return this.b;
    }

    public final Object[] b() {
        return this.c;
    }

    @Override // defpackage.InterfaceC1242ad0
    public final zzgl zza() {
        return this.a;
    }

    @Override // defpackage.InterfaceC1242ad0
    public final boolean zzb() {
        return (this.d & 2) == 2;
    }

    @Override // defpackage.InterfaceC1242ad0
    public final int zzc() {
        int i = this.d;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }
}
