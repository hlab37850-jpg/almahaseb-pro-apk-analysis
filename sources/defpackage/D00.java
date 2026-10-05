package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class D00 {
    public static final byte[] a(String str) {
        AbstractC4492zt.h(str, "<this>");
        byte[] bytes = str.getBytes(C3809rb.b);
        AbstractC4492zt.g(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] bArr) {
        AbstractC4492zt.h(bArr, "<this>");
        return new String(bArr, C3809rb.b);
    }
}
