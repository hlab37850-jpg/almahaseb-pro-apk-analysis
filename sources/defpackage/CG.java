package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CG {
    public static final ThreadLocal a = new a();

    public class a extends ThreadLocal {
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
