package defpackage;

import com.google.android.gms.internal.common.zzs;
import com.google.android.gms.internal.common.zzx;

/* JADX INFO: loaded from: classes2.dex */
public final class Wh0 extends ri0 {
    public final /* synthetic */ C2057di0 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Wh0(C2057di0 c2057di0, zzx zzxVar, CharSequence charSequence) {
        super(zzxVar, charSequence);
        this.h = c2057di0;
    }

    @Override // defpackage.ri0
    public final int c(int i) {
        return i + 1;
    }

    @Override // defpackage.ri0
    public final int d(int i) {
        CharSequence charSequence = this.c;
        int length = charSequence.length();
        zzs.zzb(i, length, "index");
        while (i < length) {
            C2057di0 c2057di0 = this.h;
            if (c2057di0.a.zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
