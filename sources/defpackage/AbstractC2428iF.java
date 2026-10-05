package defpackage;

import com.itextpdf.text.pdf.BaseFont;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: renamed from: iF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2428iF {
    public static HashMap a;

    public static AbstractC2428iF a(BF bf) throws IOException {
        if (bf.t() == 4) {
            return b(bf.s());
        }
        if (bf.t() == 7) {
            return e(bf);
        }
        throw new IOException("CMap type not Name or Stream!");
    }

    public static AbstractC2428iF b(String str) throws IOException {
        if (a == null) {
            f();
        }
        if (a.containsKey(str)) {
            return (AbstractC2428iF) a.get(str);
        }
        throw new IOException("Unknown CMap: " + str);
    }

    public static AbstractC2428iF e(BF bf) throws IOException {
        throw new IOException("Parsing CMap Files Unsupported!");
    }

    public static void f() {
        HashMap map = new HashMap();
        a = map;
        map.put(BaseFont.IDENTITY_H, new a());
    }

    public int c(char c) {
        return 0;
    }

    public abstract char d(char c);

    /* JADX INFO: renamed from: iF$a */
    public class a extends AbstractC2428iF {
        @Override // defpackage.AbstractC2428iF
        public char d(char c) {
            return c;
        }
    }
}
