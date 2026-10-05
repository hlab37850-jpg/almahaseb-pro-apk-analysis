package defpackage;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Zf0 extends AbstractBinderC3165jf0 {
    public static final WeakReference c = new WeakReference(null);
    public WeakReference b;

    public Zf0(byte[] bArr) {
        super(bArr);
        this.b = c;
    }

    @Override // defpackage.AbstractBinderC3165jf0
    public final byte[] t() {
        byte[] bArrU;
        synchronized (this) {
            try {
                bArrU = (byte[]) this.b.get();
                if (bArrU == null) {
                    bArrU = u();
                    this.b = new WeakReference(bArrU);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrU;
    }

    public abstract byte[] u();
}
