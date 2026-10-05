package defpackage;

import com.google.common.base.Ascii;
import com.itextpdf.text.pdf.ByteBuffer;
import org.apache.poi.hssf.record.formula.RefErrorPtg;

/* JADX INFO: loaded from: classes3.dex */
public class WH {
    public static final byte[] A;
    public static final byte[] B;
    public static final byte[] C;
    public static final byte[] D;
    public static final byte[] E;
    public static final byte[] F;
    public static final byte[] G;
    public static final byte[] H;
    public static final byte[] a = {Ascii.ESC, 64};
    public static byte[] b = {10};
    public static byte[] c = {13};
    public static byte[] d;
    public static byte[] e;
    public static byte f;
    public static byte[] g;
    public static byte[] h;
    public static byte[] i;
    public static byte[] j;
    public static byte[] k;
    public static byte[] l;
    public static byte[] m;
    public static byte[] n;
    public static byte[] o;
    public static byte[] p;
    public static byte[] q;
    public static byte[] r;
    public static byte[] s;
    public static byte[] t;
    public static byte[] u;
    public static byte[] v;
    public static byte[] w;
    public static byte[] x;
    public static final byte[] y;
    public static final byte[] z;

    static {
        byte[] bArr = {Ascii.ESC, 33, 0};
        d = bArr;
        e = new byte[]{Ascii.ESC, -63, 1};
        f = (byte) (bArr[2] | 1);
        g = new byte[]{29, 104, 100};
        h = new byte[]{29, 107, 2};
        i = new byte[]{0};
        j = new byte[]{Ascii.ESC, 99, ByteBuffer.ZERO, 2};
        k = new byte[]{29, 86, 66, 0};
        l = new byte[]{29, 87};
        m = new byte[]{Ascii.ESC, 116, 17};
        n = new byte[]{Ascii.ESC, 116, 65};
        o = new byte[]{Ascii.ESC, 116, 65};
        p = new byte[]{Ascii.ESC, 116, 50};
        q = new byte[]{Ascii.ESC, 116, 50};
        r = new byte[]{Ascii.ESC, RefErrorPtg.sid, 33, -1, 3};
        s = new byte[]{Ascii.ESC, 51, Ascii.CAN};
        t = new byte[]{Ascii.ESC, 51, 30};
        u = new byte[]{16, 4, 1};
        v = new byte[]{16, 4, 2};
        w = new byte[]{16, 4, 3};
        x = new byte[]{16, 4, 4};
        y = new byte[]{Ascii.ESC, 114, 0};
        z = new byte[]{Ascii.FS, 33, 1, Ascii.ESC, 33, 1};
        A = new byte[]{Ascii.ESC, 97, 0};
        B = new byte[]{Ascii.ESC, 97, 2};
        C = new byte[]{Ascii.ESC, 97, 1};
        D = new byte[]{Ascii.ESC, 69, 0};
        E = new byte[]{Ascii.ESC, 68, 20, Ascii.FS, 0};
        F = new byte[]{Ascii.ESC, 68, 0};
        G = new byte[]{Ascii.ESC, 74, 64};
        H = new byte[]{29, 40, 65};
    }
}
