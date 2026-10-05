package defpackage;

import com.google.common.primitives.UnsignedBytes;
import org.apache.poi.ddf.EscherProperties;

/* JADX INFO: renamed from: e9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2093e9 extends AbstractC2012d9 {
    public byte[] c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2093e9(short s) {
        super((short) 0, s);
        byte[] bArr = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr[i] = (byte) i;
        }
        k(bArr);
    }

    @Override // defpackage.AbstractC2012d9
    public T8 b() {
        T8 t8B = T8.b(262);
        t8B.E(c());
        t8B.E(e());
        t8B.E(d());
        t8B.z(i());
        t8B.f();
        return t8B;
    }

    @Override // defpackage.AbstractC2012d9
    public short e() {
        return EscherProperties.BLIP__BLIPFLAGS;
    }

    @Override // defpackage.AbstractC2012d9
    public char g(char c) {
        if (c < 0 || c > 255) {
            return (char) 0;
        }
        return (char) (j((byte) c) & UnsignedBytes.MAX_VALUE);
    }

    @Override // defpackage.AbstractC2012d9
    public void h(int i, T8 t8) {
        if (i != 262) {
            throw new IllegalArgumentException("Bad length for CMap format 0");
        }
        if (t8.F() != 256) {
            throw new IllegalArgumentException("Wrong amount of data for CMap format 0");
        }
        byte[] bArr = new byte[256];
        t8.j(bArr);
        k(bArr);
    }

    public byte[] i() {
        return this.c;
    }

    public byte j(byte b) {
        return this.c[b & UnsignedBytes.MAX_VALUE];
    }

    public void k(byte[] bArr) {
        if (bArr.length != 256) {
            throw new IllegalArgumentException("Glyph map must be size 256!");
        }
        this.c = bArr;
    }
}
