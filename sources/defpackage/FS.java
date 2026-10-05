package defpackage;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class FS {
    public b a;
    public boolean b;
    public d c;
    public c d;
    public c e;
    public EnumC4231wl f;
    public boolean g;
    public int h;
    public a i;

    public enum a {
        BlackOnWhite_Default(0),
        WhiteOnBlack(1);

        public int a;

        a(int i) {
            this.a = i;
        }
    }

    public enum b {
        Font_A_Default(48),
        Font_B(49),
        Font_C(50);

        public int a;

        b(int i) {
            this.a = i;
        }
    }

    public enum c {
        _1(0),
        _2(1),
        _3(2),
        _4(3),
        _5(4),
        _6(5),
        _7(6),
        _8(7);

        public int a;

        c(int i) {
            this.a = i;
        }
    }

    public enum d {
        None_Default(48),
        OneDotThick(49),
        TwoDotThick(50);

        public int a;

        d(int i) {
            this.a = i;
        }
    }

    public FS() {
        b();
    }

    public byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(27);
        byteArrayOutputStream.write(77);
        byteArrayOutputStream.write(this.a.a);
        byteArrayOutputStream.write(27);
        byteArrayOutputStream.write(69);
        byteArrayOutputStream.write(this.b ? 1 : 0);
        int i = (this.d.a << 4) | this.e.a;
        byteArrayOutputStream.write(29);
        byteArrayOutputStream.write(33);
        byteArrayOutputStream.write(i);
        byteArrayOutputStream.write(27);
        byteArrayOutputStream.write(45);
        byteArrayOutputStream.write(this.c.a);
        byteArrayOutputStream.write(27);
        byteArrayOutputStream.write(97);
        byteArrayOutputStream.write(this.f.a);
        if (this.g) {
            byteArrayOutputStream.write(27);
            byteArrayOutputStream.write(50);
        } else {
            byteArrayOutputStream.write(27);
            byteArrayOutputStream.write(51);
            byteArrayOutputStream.write(this.h);
        }
        byteArrayOutputStream.write(29);
        byteArrayOutputStream.write(66);
        byteArrayOutputStream.write(this.i.a);
        return byteArrayOutputStream.toByteArray();
    }

    public final void b() {
        this.a = b.Font_A_Default;
        c cVar = c._1;
        this.d = cVar;
        this.e = cVar;
        this.b = false;
        this.c = d.None_Default;
        this.f = EnumC4231wl.Left_Default;
        c();
        this.i = a.BlackOnWhite_Default;
    }

    public final FS c() {
        this.g = true;
        this.h = 0;
        return this;
    }

    public final FS d(boolean z) {
        this.b = z;
        return this;
    }

    public final FS e(c cVar, c cVar2) {
        this.d = cVar;
        this.e = cVar2;
        return this;
    }

    public final FS f(int i) {
        if (i < 0 || i > 255) {
            throw new IllegalArgumentException("lineSpacing must be between 0 and 255");
        }
        this.g = false;
        this.h = i;
        return this;
    }
}
