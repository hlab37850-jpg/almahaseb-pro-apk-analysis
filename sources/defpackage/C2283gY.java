package defpackage;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: gY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2283gY {
    public WeakReference a;
    public C3099ir b;

    public C2283gY(Object obj) {
        if (C3099ir.b) {
            this.b = new C3099ir(obj);
        } else {
            this.a = new WeakReference(obj);
        }
    }

    public Object a() {
        return C3099ir.b ? this.b.c() : this.a.get();
    }
}
