package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public class DL {
    public final Object a;
    public final InterfaceC2339h9.a b;
    public final C2119eY c;
    public boolean d;

    public interface a {
        void a(C2119eY c2119eY);
    }

    public interface b {
        void a(Object obj);
    }

    public DL(Object obj, InterfaceC2339h9.a aVar) {
        this.d = false;
        this.a = obj;
        this.b = aVar;
        this.c = null;
    }

    public static DL a(C2119eY c2119eY) {
        return new DL(c2119eY);
    }

    public static DL c(Object obj, InterfaceC2339h9.a aVar) {
        return new DL(obj, aVar);
    }

    public boolean b() {
        return this.c == null;
    }

    public DL(C2119eY c2119eY) {
        this.d = false;
        this.a = null;
        this.b = null;
        this.c = c2119eY;
    }
}
