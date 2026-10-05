package defpackage;

import com.google.android.gms.internal.play_billing.zzek;
import com.google.android.gms.internal.play_billing.zzel;

/* JADX INFO: renamed from: ab0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1238ab0 extends zzel {
    public int a;
    public int b;
    public int c;

    public /* synthetic */ C1238ab0(byte[] bArr, int i, int i2, boolean z, zzek zzekVar) {
        super(null);
        this.c = Integer.MAX_VALUE;
        this.a = 0;
    }

    public final int a(int i) {
        int i2 = this.c;
        this.c = 0;
        int i3 = this.a + this.b;
        this.a = i3;
        if (i3 > 0) {
            this.b = i3;
            this.a = 0;
        } else {
            this.b = 0;
        }
        return i2;
    }
}
