package defpackage;

import com.zebra.sdk.util.internal.StringUtilities;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: renamed from: Ki, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0693Ki implements KH, Serializable {
    public static final KO f = new KO(" ");
    public b a;
    public b b;
    public final IO c;
    public boolean d;
    public transient int e;

    /* JADX INFO: renamed from: Ki$a */
    public static class a implements b, Serializable {
        public static a a = new a();

        @Override // defpackage.C0693Ki.b
        public void a(com.fasterxml.jackson.core.a aVar, int i) {
            aVar.I(' ');
        }

        @Override // defpackage.C0693Ki.b
        public boolean isInline() {
            return true;
        }
    }

    /* JADX INFO: renamed from: Ki$b */
    public interface b {
        void a(com.fasterxml.jackson.core.a aVar, int i);

        boolean isInline();
    }

    /* JADX INFO: renamed from: Ki$c */
    public static class c implements b, Serializable {
        public static c a = new c();
        public static final String b;
        public static final char[] c;

        static {
            String property;
            try {
                property = System.getProperty("line.separator");
            } catch (Throwable unused) {
                property = null;
            }
            if (property == null) {
                property = StringUtilities.LF;
            }
            b = property;
            char[] cArr = new char[64];
            c = cArr;
            Arrays.fill(cArr, ' ');
        }

        @Override // defpackage.C0693Ki.b
        public void a(com.fasterxml.jackson.core.a aVar, int i) {
            aVar.K(b);
            if (i > 0) {
                int length = i + i;
                while (length > 64) {
                    char[] cArr = c;
                    aVar.L(cArr, 0, 64);
                    length -= cArr.length;
                }
                aVar.L(c, 0, length);
            }
        }

        @Override // defpackage.C0693Ki.b
        public boolean isInline() {
            return false;
        }
    }

    public C0693Ki() {
        this(f);
    }

    @Override // defpackage.KH
    public void a(com.fasterxml.jackson.core.a aVar) {
        aVar.I('{');
        if (this.b.isInline()) {
            return;
        }
        this.e++;
    }

    @Override // defpackage.KH
    public void b(com.fasterxml.jackson.core.a aVar) {
        IO io = this.c;
        if (io != null) {
            aVar.J(io);
        }
    }

    @Override // defpackage.KH
    public void c(com.fasterxml.jackson.core.a aVar) {
        aVar.I(',');
        this.a.a(aVar, this.e);
    }

    @Override // defpackage.KH
    public void e(com.fasterxml.jackson.core.a aVar) {
        this.b.a(aVar, this.e);
    }

    @Override // defpackage.KH
    public void f(com.fasterxml.jackson.core.a aVar, int i) {
        if (!this.b.isInline()) {
            this.e--;
        }
        if (i > 0) {
            this.b.a(aVar, this.e);
        } else {
            aVar.I(' ');
        }
        aVar.I('}');
    }

    @Override // defpackage.KH
    public void h(com.fasterxml.jackson.core.a aVar) {
        if (!this.a.isInline()) {
            this.e++;
        }
        aVar.I('[');
    }

    @Override // defpackage.KH
    public void i(com.fasterxml.jackson.core.a aVar) {
        this.a.a(aVar, this.e);
    }

    @Override // defpackage.KH
    public void j(com.fasterxml.jackson.core.a aVar) {
        aVar.I(',');
        this.b.a(aVar, this.e);
    }

    @Override // defpackage.KH
    public void k(com.fasterxml.jackson.core.a aVar, int i) {
        if (!this.a.isInline()) {
            this.e--;
        }
        if (i > 0) {
            this.a.a(aVar, this.e);
        } else {
            aVar.I(' ');
        }
        aVar.I(']');
    }

    @Override // defpackage.KH
    public void l(com.fasterxml.jackson.core.a aVar) {
        if (this.d) {
            aVar.K(" : ");
        } else {
            aVar.I(':');
        }
    }

    public C0693Ki(IO io) {
        this.a = a.a;
        this.b = c.a;
        this.d = true;
        this.e = 0;
        this.c = io;
    }
}
