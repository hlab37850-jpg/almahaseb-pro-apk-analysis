package defpackage;

import com.google.zxing.datamatrix.encoder.HighLevelEncoder;

/* JADX INFO: loaded from: classes3.dex */
public class Y8 implements InterfaceC3174jl {
    public static String d(CharSequence charSequence, int i) {
        int iCharAt = (charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * '(') + charSequence.charAt(i + 2) + 1;
        return new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }

    public static void g(C3256kl c3256kl, StringBuilder sb) {
        c3256kl.s(d(sb, 0));
        sb.delete(0, 3);
    }

    @Override // defpackage.InterfaceC3174jl
    public void a(C3256kl c3256kl) {
        StringBuilder sb = new StringBuilder();
        while (c3256kl.i()) {
            char c = c3256kl.c();
            c3256kl.f++;
            int iC = c(c, sb);
            int iA = c3256kl.a() + ((sb.length() / 3) << 1);
            c3256kl.q(iA);
            int dataCapacity = c3256kl.g().getDataCapacity() - iA;
            if (!c3256kl.i()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && dataCapacity != 2) {
                    iC = b(c3256kl, sb, sb2, iC);
                }
                while (sb.length() % 3 == 1 && (iC > 3 || dataCapacity != 1)) {
                    iC = b(c3256kl, sb, sb2, iC);
                }
                break;
            }
            if (sb.length() % 3 == 0 && HighLevelEncoder.lookAheadTest(c3256kl.d(), c3256kl.f, e()) != e()) {
                c3256kl.o(0);
                break;
            }
        }
        f(c3256kl, sb);
    }

    public final int b(C3256kl c3256kl, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        c3256kl.f--;
        int iC = c(c3256kl.c(), sb2);
        c3256kl.k();
        return iC;
    }

    public int c(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
            return 1;
        }
        if (c >= 'A' && c <= 'Z') {
            sb.append((char) (c - '3'));
            return 1;
        }
        if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        }
        if (c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        }
        if (c <= '@') {
            sb.append((char) 1);
            sb.append((char) (c - '+'));
            return 2;
        }
        if (c <= '_') {
            sb.append((char) 1);
            sb.append((char) (c - 'E'));
            return 2;
        }
        if (c > 127) {
            sb.append("\u0001\u001e");
            return c((char) (c - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) (c - '`'));
        return 2;
    }

    public int e() {
        return 1;
    }

    public void f(C3256kl c3256kl, StringBuilder sb) {
        int length = (sb.length() / 3) << 1;
        int length2 = sb.length() % 3;
        int iA = c3256kl.a() + length;
        c3256kl.q(iA);
        int dataCapacity = c3256kl.g().getDataCapacity() - iA;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                g(c3256kl, sb);
            }
            if (c3256kl.i()) {
                c3256kl.r((char) 254);
            }
        } else if (dataCapacity == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                g(c3256kl, sb);
            }
            if (c3256kl.i()) {
                c3256kl.r((char) 254);
            }
            c3256kl.f--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb.length() >= 3) {
                g(c3256kl, sb);
            }
            if (dataCapacity > 0 || c3256kl.i()) {
                c3256kl.r((char) 254);
            }
        }
        c3256kl.o(0);
    }
}
