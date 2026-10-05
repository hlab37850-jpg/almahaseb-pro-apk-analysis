package defpackage;

import com.google.android.gms.internal.auth.zzfw;

/* JADX INFO: loaded from: classes2.dex */
public final class Xc0 implements InterfaceC4217wc0 {
    public final zzfw a;
    public final String b = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a";
    public final Object[] c;
    public final int d;

    public Xc0(zzfw zzfwVar, String str, Object[] objArr) {
        this.a = zzfwVar;
        this.c = objArr;
        char cCharAt = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a".charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a".charAt(i3);
            if (cCharAt2 < 55296) {
                this.d = (cCharAt2 << i2) | i;
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    public final String a() {
        return this.b;
    }

    public final Object[] b() {
        return this.c;
    }

    @Override // defpackage.InterfaceC4217wc0
    public final zzfw zza() {
        return this.a;
    }

    @Override // defpackage.InterfaceC4217wc0
    public final boolean zzb() {
        return (this.d & 2) == 2;
    }

    @Override // defpackage.InterfaceC4217wc0
    public final int zzc() {
        return (this.d & 1) == 1 ? 1 : 2;
    }
}
