package defpackage;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes3.dex */
public class ZQ {
    public SoftReference a;
    public C3099ir b;

    public ZQ(Object obj) {
        if (C3099ir.b) {
            this.b = new C3099ir(obj);
        } else {
            this.a = new SoftReference(obj);
        }
    }

    public Object a() {
        return C3099ir.b ? this.b.c() : this.a.get();
    }
}
