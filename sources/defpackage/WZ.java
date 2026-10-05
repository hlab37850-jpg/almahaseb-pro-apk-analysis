package defpackage;

import com.google.zxing.datamatrix.encoder.HighLevelEncoder;

/* JADX INFO: loaded from: classes3.dex */
public final class WZ extends Y8 {
    @Override // defpackage.Y8, defpackage.InterfaceC3174jl
    public void a(C3256kl c3256kl) {
        StringBuilder sb = new StringBuilder();
        while (c3256kl.i()) {
            char c = c3256kl.c();
            c3256kl.f++;
            c(c, sb);
            if (sb.length() % 3 == 0) {
                Y8.g(c3256kl, sb);
                if (HighLevelEncoder.lookAheadTest(c3256kl.d(), c3256kl.f, e()) != e()) {
                    c3256kl.o(0);
                    break;
                }
            }
        }
        f(c3256kl, sb);
    }

    @Override // defpackage.Y8
    public int c(char c, StringBuilder sb) {
        if (c == '\r') {
            sb.append((char) 0);
        } else if (c == ' ') {
            sb.append((char) 3);
        } else if (c == '*') {
            sb.append((char) 1);
        } else if (c == '>') {
            sb.append((char) 2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
        } else if (c < 'A' || c > 'Z') {
            HighLevelEncoder.illegalCharacter(c);
        } else {
            sb.append((char) (c - '3'));
        }
        return 1;
    }

    @Override // defpackage.Y8
    public int e() {
        return 3;
    }

    @Override // defpackage.Y8
    public void f(C3256kl c3256kl, StringBuilder sb) {
        c3256kl.p();
        int dataCapacity = c3256kl.g().getDataCapacity() - c3256kl.a();
        c3256kl.f -= sb.length();
        if (c3256kl.f() > 1 || dataCapacity > 1 || c3256kl.f() != dataCapacity) {
            c3256kl.r((char) 254);
        }
        if (c3256kl.e() < 0) {
            c3256kl.o(0);
        }
    }
}
