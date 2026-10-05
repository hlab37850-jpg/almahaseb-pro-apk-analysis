package defpackage;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: vl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C4150vl implements Closeable, Flushable {
    public OutputStream a;
    public String b;
    public FS c;

    /* JADX INFO: renamed from: vl$b */
    public enum b {
        FULL(48),
        PART(49);

        public int a;

        b(int i) {
            this.a = i;
        }
    }

    public C4150vl(OutputStream outputStream) {
        this.a = outputStream;
        i(a.CP437_USA_Standard_Europe.b);
        this.c = new FS();
    }

    public C4150vl c(b bVar) throws IOException {
        t(29);
        t(86);
        t(bVar.a);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    public C4150vl d(int i) {
        return g(this.c, i);
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.a.flush();
    }

    public C4150vl g(FS fs, int i) throws IOException {
        if (i < 1 || i > 255) {
            throw new IllegalArgumentException("nLines must be between 1 and 255");
        }
        byte[] bArrA = fs.a();
        v(bArrA, 0, bArrA.length);
        for (int i2 = 0; i2 < i; i2++) {
            t(10);
        }
        return this;
    }

    public final C4150vl i(String str) {
        this.b = str;
        return this;
    }

    public C4150vl r(int i) throws IOException {
        if (i < 0 || i > 255) {
            throw new IllegalArgumentException("characterCodeTable must be between 0 and 255");
        }
        t(27);
        t(116);
        t(i);
        return this;
    }

    public C4150vl t(int i) throws IOException {
        this.a.write(i);
        return this;
    }

    public C4150vl u(FS fs, String str) throws IOException {
        byte[] bArrA = fs.a();
        v(bArrA, 0, bArrA.length);
        this.a.write(str.getBytes(this.b));
        return this;
    }

    public C4150vl v(byte[] bArr, int i, int i2) throws IOException {
        this.a.write(bArr, i, i2);
        return this;
    }

    /* JADX INFO: renamed from: vl$a */
    public enum a {
        CP437_USA_Standard_Europe(0, "cp437"),
        Katakana(1),
        CP850_Multilingual(2, "cp850"),
        CP860_Portuguese(3, "cp860"),
        CP863_Canadian_French(4, "cp863"),
        CP865_Nordic(5, "cp865"),
        CP851_Greek(11),
        CP853_Turkish(12),
        CP857_Turkish(13, "cp857"),
        CP737_Greek(14, "cp737"),
        ISO8859_7_Greek(15, "iso8859_7"),
        WPC1252(16, "cp1252"),
        CP866_Cyrillic_2(17, "cp866"),
        CP852_Latin2(18, "cp852"),
        CP858_Euro(19, "cp858"),
        KU42_Thai(20),
        TIS11_Thai(21),
        TIS18_Thai(26),
        TCVN_3_1_Vietnamese(30),
        TCVN_3_2_Vietnamese(31),
        PC720_Arabic(32),
        WPC775_BalticRim(33),
        CP855_Cyrillic(34, "cp855"),
        CP861_Icelandic(35, "cp861"),
        CP862_Hebrew(36, "cp862"),
        CP864_Arabic(37, "cp864"),
        CP869_Greek(38, "cp869"),
        ISO8859_2_Latin2(39, "iso8859_2"),
        ISO8859_15_Latin9(40, "iso8859_15"),
        CP1098_Farsi(41, "cp1098"),
        CP1118_Lithuanian(42),
        CP1119_Lithuanian(43),
        CP1125_Ukrainian(44),
        WCP1250_Latin2(45, "cp1250"),
        WCP1251_Cyrillic(46, "cp1251"),
        WCP1253_Greek(47, "cp1253"),
        WCP1254_Turkish(48, "cp1254"),
        WCP1255_Hebrew(49, "cp1255"),
        WCP1256_Arabic(50, "cp1256"),
        WCP1257_BalticRim(51, "cp1257"),
        WCP1258_Vietnamese(52, "cp1258"),
        KZ_1048_Kazakhstan(53),
        User_defined_page(255);

        public int a;
        public String b;

        a(int i) {
            this.a = i;
            this.b = "cp437";
        }

        a(int i, String str) {
            this.a = i;
            this.b = str;
        }
    }
}
