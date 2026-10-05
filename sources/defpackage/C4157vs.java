package defpackage;

/* JADX INFO: renamed from: vs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4157vs extends AbstractC2101eG {
    public static final C4157vs c = f(null, null);
    public final Object a;
    public final Object b;

    public C4157vs(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public static C4157vs f(Object obj, Object obj2) {
        return new C4157vs(obj, obj2);
    }

    @Override // defpackage.AbstractC2101eG
    public Object b() {
        return this.a;
    }

    @Override // defpackage.AbstractC2101eG
    public Object c() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
