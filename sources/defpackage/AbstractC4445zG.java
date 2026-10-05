package defpackage;

/* JADX INFO: renamed from: zG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC4445zG {
    public static final ThreadLocal a = new a();

    /* JADX INFO: renamed from: zG$a */
    public static class a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    public static char[] a() {
        return (char[]) a.get();
    }
}
