package defpackage;

import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3599p implements InterfaceC3174jl {
    public static char b(char c, char c2) {
        if (HighLevelEncoder.isDigit(c) && HighLevelEncoder.isDigit(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + ShapeTypes.DOUBLE_WAVE);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }

    @Override // defpackage.InterfaceC3174jl
    public void a(C3256kl c3256kl) {
        if (HighLevelEncoder.determineConsecutiveDigitCount(c3256kl.d(), c3256kl.f) >= 2) {
            c3256kl.r(b(c3256kl.d().charAt(c3256kl.f), c3256kl.d().charAt(c3256kl.f + 1)));
            c3256kl.f += 2;
            return;
        }
        char c = c3256kl.c();
        int iLookAheadTest = HighLevelEncoder.lookAheadTest(c3256kl.d(), c3256kl.f, c());
        if (iLookAheadTest == c()) {
            if (!HighLevelEncoder.isExtendedASCII(c)) {
                c3256kl.r((char) (c + 1));
                c3256kl.f++;
                return;
            } else {
                c3256kl.r((char) 235);
                c3256kl.r((char) (c - 127));
                c3256kl.f++;
                return;
            }
        }
        if (iLookAheadTest == 1) {
            c3256kl.r((char) 230);
            c3256kl.o(1);
            return;
        }
        if (iLookAheadTest == 2) {
            c3256kl.r((char) 239);
            c3256kl.o(2);
            return;
        }
        if (iLookAheadTest == 3) {
            c3256kl.r((char) 238);
            c3256kl.o(3);
        } else if (iLookAheadTest == 4) {
            c3256kl.r((char) 240);
            c3256kl.o(4);
        } else {
            if (iLookAheadTest != 5) {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(iLookAheadTest)));
            }
            c3256kl.r((char) 231);
            c3256kl.o(5);
        }
    }

    public int c() {
        return 0;
    }
}
