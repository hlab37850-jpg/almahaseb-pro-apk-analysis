package defpackage;

import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class T8 {
    public static boolean a = true;

    public static T8 K(byte[] bArr) {
        return a ? C4189wD.P(bArr) : W4.K(bArr);
    }

    public static T8 a(MappedByteBuffer mappedByteBuffer) {
        return new C4189wD(mappedByteBuffer);
    }

    public static T8 b(int i) {
        return a ? C4189wD.L(i) : W4.b(i);
    }

    public static T8 g(ByteBuffer byteBuffer) {
        return C4189wD.N(byteBuffer);
    }

    public abstract void A(char c);

    public abstract void B(int i);

    public abstract void C(int i, int i2);

    public abstract void D(long j);

    public abstract void E(short s);

    public abstract int F();

    public abstract void G();

    public abstract void H();

    public abstract T8 I();

    public abstract ByteBuffer J();

    public abstract byte[] c();

    public abstract int d();

    public abstract T8 e();

    public abstract void f();

    public abstract byte h();

    public abstract byte i(int i);

    public abstract void j(byte[] bArr);

    public abstract void k(byte[] bArr, int i, int i2);

    public abstract char l();

    public abstract char m(int i);

    public abstract int n();

    public abstract long o();

    public abstract short p();

    public abstract boolean q();

    public abstract boolean r();

    public abstract int s();

    public abstract void t(int i);

    public abstract void u();

    public abstract int v();

    public abstract void w(int i);

    public abstract void x(byte b);

    public abstract void y(T8 t8);

    public abstract void z(byte[] bArr);
}
