package defpackage;

import com.google.android.gms.internal.common.zzo;
import com.google.android.gms.internal.common.zzx;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ri0 extends AbstractC3411mf0 {
    public final CharSequence c;
    public final zzo d;
    public final boolean e;
    public int f = 0;
    public int g = Integer.MAX_VALUE;

    public ri0(zzx zzxVar, CharSequence charSequence) {
        this.d = zzxVar.zza;
        this.e = zzxVar.zzb;
        this.c = charSequence;
    }

    @Override // defpackage.AbstractC3411mf0
    public final /* bridge */ /* synthetic */ Object a() {
        int iC;
        int i = this.f;
        while (true) {
            int i2 = this.f;
            if (i2 == -1) {
                b();
                return null;
            }
            int iD = d(i2);
            if (iD == -1) {
                iD = this.c.length();
                this.f = -1;
                iC = -1;
            } else {
                iC = c(iD);
                this.f = iC;
            }
            if (iC == i) {
                int i3 = iC + 1;
                this.f = i3;
                if (i3 > this.c.length()) {
                    this.f = -1;
                }
            } else {
                if (i < iD) {
                    this.c.charAt(i);
                }
                if (i < iD) {
                    this.c.charAt(iD - 1);
                }
                if (!this.e || i != iD) {
                    int i4 = this.g;
                    if (i4 == 1) {
                        iD = this.c.length();
                        this.f = -1;
                        if (iD > i) {
                            this.c.charAt(iD - 1);
                        }
                    } else {
                        this.g = i4 - 1;
                    }
                    return this.c.subSequence(i, iD).toString();
                }
                i = this.f;
            }
        }
    }

    public abstract int c(int i);

    public abstract int d(int i);
}
