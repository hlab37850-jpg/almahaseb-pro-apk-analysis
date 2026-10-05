package defpackage;

import com.google.android.gms.auth.api.credentials.CredentialsApi;

/* JADX INFO: loaded from: classes2.dex */
public class J8 {
    public final byte[][] a = new byte[a.values().length][];
    public final char[][] b = new char[b.values().length][];

    public enum a {
        READ_IO_BUFFER(4000),
        WRITE_ENCODING_BUFFER(4000),
        WRITE_CONCAT_BUFFER(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE),
        BASE64_CODEC_BUFFER(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);

        public final int a;

        a(int i) {
            this.a = i;
        }
    }

    public enum b {
        TOKEN_BUFFER(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE),
        CONCAT_BUFFER(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE),
        TEXT_BUFFER(200),
        NAME_COPY_BUFFER(200);

        public final int a;

        b(int i) {
            this.a = i;
        }
    }

    public final byte[] a(a aVar) {
        int iOrdinal = aVar.ordinal();
        byte[][] bArr = this.a;
        byte[] bArr2 = bArr[iOrdinal];
        if (bArr2 == null) {
            return d(aVar.a);
        }
        bArr[iOrdinal] = null;
        return bArr2;
    }

    public final char[] b(b bVar) {
        return c(bVar, 0);
    }

    public final char[] c(b bVar, int i) {
        int i2 = bVar.a;
        if (i2 > i) {
            i = i2;
        }
        int iOrdinal = bVar.ordinal();
        char[][] cArr = this.b;
        char[] cArr2 = cArr[iOrdinal];
        if (cArr2 == null || cArr2.length < i) {
            return e(i);
        }
        cArr[iOrdinal] = null;
        return cArr2;
    }

    public final byte[] d(int i) {
        return new byte[i];
    }

    public final char[] e(int i) {
        return new char[i];
    }

    public final void f(a aVar, byte[] bArr) {
        this.a[aVar.ordinal()] = bArr;
    }

    public final void g(b bVar, char[] cArr) {
        this.b[bVar.ordinal()] = cArr;
    }
}
