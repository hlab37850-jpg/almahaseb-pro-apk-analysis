package defpackage;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbn;

/* JADX INFO: loaded from: classes2.dex */
public final class E60 {
    public final zzbn a;
    public final byte[] b;

    public E60(int i) {
        byte[] bArr = new byte[i];
        this.b = bArr;
        this.a = zzbn.zzc(bArr);
    }

    public final zzbb a() {
        if (this.a.zzag() == 0) {
            return new K60(this.b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzbn b() {
        return this.a;
    }

    public /* synthetic */ E60(int i, C3449n60 c3449n60) {
        this(i);
    }
}
