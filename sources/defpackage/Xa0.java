package defpackage;

import com.google.android.gms.internal.auth.zzef;
import com.google.android.gms.internal.auth.zzei;

/* JADX INFO: loaded from: classes2.dex */
public final class Xa0 extends zzei {
    public final byte[] a;
    public int b;
    public int c;
    public int d;

    public /* synthetic */ Xa0(byte[] bArr, int i, int i2, boolean z, zzef zzefVar) {
        super(null);
        this.d = Integer.MAX_VALUE;
        this.a = bArr;
        this.b = 0;
    }

    public final int a(int i) {
        int i2 = this.d;
        this.d = 0;
        int i3 = this.b + this.c;
        this.b = i3;
        if (i3 > 0) {
            this.c = i3;
            this.b = 0;
        } else {
            this.c = 0;
        }
        return i2;
    }
}
