package defpackage;

import com.google.zxing.datamatrix.encoder.HighLevelEncoder;

/* JADX INFO: renamed from: Mk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0746Mk implements InterfaceC3174jl {
    public static void b(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c < '@' || c > '^') {
            HighLevelEncoder.illegalCharacter(c);
        } else {
            sb.append((char) (c - '@'));
        }
    }

    private static String c(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int iCharAt = (charSequence.charAt(i) << 18) + ((length >= 2 ? charSequence.charAt(i + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i + 3) : (char) 0);
        char c = (char) ((iCharAt >> 16) & 255);
        char c2 = (char) ((iCharAt >> 8) & 255);
        char c3 = (char) (iCharAt & 255);
        StringBuilder sb = new StringBuilder(3);
        sb.append(c);
        if (length >= 2) {
            sb.append(c2);
        }
        if (length >= 3) {
            sb.append(c3);
        }
        return sb.toString();
    }

    public static void e(C3256kl c3256kl, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                c3256kl.o(0);
                return;
            }
            boolean z = true;
            if (length == 1) {
                c3256kl.p();
                int dataCapacity = c3256kl.g().getDataCapacity() - c3256kl.a();
                int iF = c3256kl.f();
                if (iF > dataCapacity) {
                    c3256kl.q(c3256kl.a() + 1);
                    dataCapacity = c3256kl.g().getDataCapacity() - c3256kl.a();
                }
                if (iF <= dataCapacity && dataCapacity <= 2) {
                    c3256kl.o(0);
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i = length - 1;
            String strC = c(charSequence, 0);
            if (c3256kl.i() || i > 2) {
                z = false;
            }
            if (i <= 2) {
                c3256kl.q(c3256kl.a() + i);
                if (c3256kl.g().getDataCapacity() - c3256kl.a() >= 3) {
                    c3256kl.q(c3256kl.a() + strC.length());
                    z = false;
                }
            }
            if (z) {
                c3256kl.k();
                c3256kl.f -= i;
            } else {
                c3256kl.s(strC);
            }
            c3256kl.o(0);
        } catch (Throwable th) {
            c3256kl.o(0);
            throw th;
        }
    }

    @Override // defpackage.InterfaceC3174jl
    public void a(C3256kl c3256kl) {
        StringBuilder sb = new StringBuilder();
        while (c3256kl.i()) {
            b(c3256kl.c(), sb);
            c3256kl.f++;
            if (sb.length() >= 4) {
                c3256kl.s(c(sb, 0));
                sb.delete(0, 4);
                if (HighLevelEncoder.lookAheadTest(c3256kl.d(), c3256kl.f, d()) != d()) {
                    c3256kl.o(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        e(c3256kl, sb);
    }

    public int d() {
        return 4;
    }
}
