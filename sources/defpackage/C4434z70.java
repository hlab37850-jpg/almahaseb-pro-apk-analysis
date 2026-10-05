package defpackage;

/* JADX INFO: renamed from: z70, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4434z70 {
    public final Object a;
    public final Object b;
    public final Object c;

    public C4434z70(Object obj, Object obj2, Object obj3) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.c;
        Object obj2 = this.b;
        Object obj3 = this.a;
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(obj3) + "=" + String.valueOf(obj2) + " and " + String.valueOf(obj3) + "=" + String.valueOf(obj));
    }
}
