package defpackage;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import org.apache.poi.hssf.record.UnknownRecord;

/* JADX INFO: renamed from: dq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2064dq {
    public final BitArray a;
    public final C3739qg b = new C3739qg();
    public final StringBuilder c = new StringBuilder();

    public C2064dq(BitArray bitArray) {
        this.a = bitArray;
    }

    public static int g(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (bitArray.get(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public String a(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            C4147vi c4147viC = c(i, str);
            String strA = AbstractC3421mm.a(c4147viC.b());
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = c4147viC.d() ? String.valueOf(c4147viC.c()) : null;
            if (i == c4147viC.a()) {
                return sb.toString();
            }
            i = c4147viC.a();
            str = strValueOf;
        }
    }

    public final C4066ui b(int i) {
        char c;
        int iF = f(i, 5);
        if (iF == 15) {
            return new C4066ui(i + 5, '$');
        }
        if (iF >= 5 && iF < 15) {
            return new C4066ui(i + 5, (char) (iF + 43));
        }
        int iF2 = f(i, 6);
        if (iF2 >= 32 && iF2 < 58) {
            return new C4066ui(i + 6, (char) (iF2 + 33));
        }
        switch (iF2) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(iF2)));
        }
        return new C4066ui(i + 6, c);
    }

    public C4147vi c(int i, String str) throws FormatException {
        this.c.setLength(0);
        if (str != null) {
            this.c.append(str);
        }
        this.b.h(i);
        C4147vi c4147viO = o();
        return (c4147viO == null || !c4147viO.d()) ? new C4147vi(this.b.a(), this.c.toString()) : new C4147vi(this.b.a(), this.c.toString(), c4147viO.c());
    }

    public final C4066ui d(int i) throws FormatException {
        int iF = f(i, 5);
        if (iF == 15) {
            return new C4066ui(i + 5, '$');
        }
        char c = '+';
        if (iF >= 5 && iF < 15) {
            return new C4066ui(i + 5, (char) (iF + 43));
        }
        int iF2 = f(i, 7);
        if (iF2 >= 64 && iF2 < 90) {
            return new C4066ui(i + 7, (char) (iF2 + 1));
        }
        if (iF2 >= 90 && iF2 < 116) {
            return new C4066ui(i + 7, (char) (iF2 + 7));
        }
        switch (f(i, 8)) {
            case 232:
                c = '!';
                break;
            case UnknownRecord.BITMAP_00E9 /* 233 */:
                c = '\"';
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = '&';
                break;
            case 236:
                c = '\'';
                break;
            case Jpeg.M_APPD /* 237 */:
                c = '(';
                break;
            case Jpeg.M_APPE /* 238 */:
                c = ')';
                break;
            case UnknownRecord.PHONETICPR_00EF /* 239 */:
                c = '*';
                break;
            case 240:
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = '/';
                break;
            case 245:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case MetaDo.META_CREATEPALETTE /* 247 */:
                c = '<';
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new C4066ui(i + 8, c);
    }

    public final C4228wi e(int i) {
        int i2 = i + 7;
        if (i2 > this.a.getSize()) {
            int iF = f(i, 4);
            return iF == 0 ? new C4228wi(this.a.getSize(), 10, 10) : new C4228wi(this.a.getSize(), iF - 1, 10);
        }
        int iF2 = f(i, 7) - 8;
        return new C4228wi(i2, iF2 / 11, iF2 % 11);
    }

    public int f(int i, int i2) {
        return g(this.a, i, i2);
    }

    public final boolean h(int i) {
        int i2 = i + 3;
        if (i2 > this.a.getSize()) {
            return false;
        }
        while (i < i2) {
            if (this.a.get(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final boolean i(int i) {
        int i2;
        if (i + 1 > this.a.getSize()) {
            return false;
        }
        for (int i3 = 0; i3 < 5 && (i2 = i3 + i) < this.a.getSize(); i3++) {
            if (i3 == 2) {
                if (!this.a.get(i + 2)) {
                    return false;
                }
            } else if (this.a.get(i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(int i) {
        int i2;
        if (i + 1 > this.a.getSize()) {
            return false;
        }
        for (int i3 = 0; i3 < 4 && (i2 = i3 + i) < this.a.getSize(); i3++) {
            if (this.a.get(i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(int i) {
        int iF;
        if (i + 5 > this.a.getSize()) {
            return false;
        }
        int iF2 = f(i, 5);
        if (iF2 < 5 || iF2 >= 16) {
            return i + 6 <= this.a.getSize() && (iF = f(i, 6)) >= 16 && iF < 63;
        }
        return true;
    }

    public final boolean l(int i) {
        int iF;
        if (i + 5 > this.a.getSize()) {
            return false;
        }
        int iF2 = f(i, 5);
        if (iF2 >= 5 && iF2 < 16) {
            return true;
        }
        if (i + 7 > this.a.getSize()) {
            return false;
        }
        int iF3 = f(i, 7);
        if (iF3 < 64 || iF3 >= 116) {
            return i + 8 <= this.a.getSize() && (iF = f(i, 8)) >= 232 && iF < 253;
        }
        return true;
    }

    public final boolean m(int i) {
        if (i + 7 > this.a.getSize()) {
            return i + 4 <= this.a.getSize();
        }
        int i2 = i;
        while (true) {
            int i3 = i + 3;
            if (i2 >= i3) {
                return this.a.get(i3);
            }
            if (this.a.get(i2)) {
                return true;
            }
            i2++;
        }
    }

    public final C3370m8 n() {
        while (k(this.b.a())) {
            C4066ui c4066uiB = b(this.b.a());
            this.b.h(c4066uiB.a());
            if (c4066uiB.c()) {
                return new C3370m8(new C4147vi(this.b.a(), this.c.toString()), true);
            }
            this.c.append(c4066uiB.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.g();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.a.getSize()) {
                this.b.b(5);
            } else {
                this.b.h(this.a.getSize());
            }
            this.b.f();
        }
        return new C3370m8(false);
    }

    public final C4147vi o() throws FormatException {
        C3370m8 c3370m8Q;
        boolean zB;
        do {
            int iA = this.b.a();
            if (this.b.c()) {
                c3370m8Q = n();
                zB = c3370m8Q.b();
            } else if (this.b.d()) {
                c3370m8Q = p();
                zB = c3370m8Q.b();
            } else {
                c3370m8Q = q();
                zB = c3370m8Q.b();
            }
            if (iA == this.b.a() && !zB) {
                break;
            }
        } while (!zB);
        return c3370m8Q.a();
    }

    public final C3370m8 p() throws FormatException {
        while (l(this.b.a())) {
            C4066ui c4066uiD = d(this.b.a());
            this.b.h(c4066uiD.a());
            if (c4066uiD.c()) {
                return new C3370m8(new C4147vi(this.b.a(), this.c.toString()), true);
            }
            this.c.append(c4066uiD.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.g();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.a.getSize()) {
                this.b.b(5);
            } else {
                this.b.h(this.a.getSize());
            }
            this.b.e();
        }
        return new C3370m8(false);
    }

    public final C3370m8 q() {
        while (m(this.b.a())) {
            C4228wi c4228wiE = e(this.b.a());
            this.b.h(c4228wiE.a());
            if (c4228wiE.d()) {
                return new C3370m8(c4228wiE.e() ? new C4147vi(this.b.a(), this.c.toString()) : new C4147vi(this.b.a(), this.c.toString(), c4228wiE.c()), true);
            }
            this.c.append(c4228wiE.b());
            if (c4228wiE.e()) {
                return new C3370m8(new C4147vi(this.b.a(), this.c.toString()), true);
            }
            this.c.append(c4228wiE.c());
        }
        if (j(this.b.a())) {
            this.b.e();
            this.b.b(4);
        }
        return new C3370m8(false);
    }
}
