package defpackage;

import com.google.android.gms.internal.vision.zzkk;
import com.google.android.gms.internal.vision.zzkz;

/* JADX INFO: renamed from: hg0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2380hg0 implements Sf0 {
    public final zzkk a;
    public final String b;
    public final Object[] c;
    public final int d;

    public C2380hg0(zzkk zzkkVar, String str, Object[] objArr) {
        this.a = zzkkVar;
        this.b = str;
        this.c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.d = i | (cCharAt2 << i2);
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

    @Override // defpackage.Sf0
    public final int zza() {
        return (this.d & 1) == 1 ? zzkz.zza : zzkz.zzb;
    }

    @Override // defpackage.Sf0
    public final boolean zzb() {
        return (this.d & 2) == 2;
    }

    @Override // defpackage.Sf0
    public final zzkk zzc() {
        return this.a;
    }
}
