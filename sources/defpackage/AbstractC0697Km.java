package defpackage;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: renamed from: Km, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0697Km {
    public static T8 a(BF bf, T8 t8, BF bf2) throws EF {
        DH dhD;
        Inflater inflater = new Inflater(false);
        int iF = t8.F();
        if (t8.q()) {
            inflater.setInput(t8.c(), t8.d() + t8.v(), iF);
            t8.w(t8.v() + iF);
        } else {
            byte[] bArr = new byte[iF];
            t8.j(bArr);
            inflater.setInput(bArr);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[iF];
        while (!inflater.finished()) {
            try {
                int iInflate = inflater.inflate(bArr2);
                if (iInflate <= 0) {
                    if (inflater.needsDictionary()) {
                        throw new EF("Don't know how to ask for a dictionary in FlateDecode");
                    }
                    return T8.b(0);
                }
                byteArrayOutputStream.write(bArr2, 0, iInflate);
            } catch (DataFormatException e) {
                throw new EF("Data format exception:" + e.getMessage());
            }
        }
        T8 t8K = T8.K(byteArrayOutputStream.toByteArray());
        return (bf2 == null || !bf2.k().containsKey("Predictor") || (dhD = DH.d(bf2)) == null) ? t8K : dhD.h(t8K);
    }
}
