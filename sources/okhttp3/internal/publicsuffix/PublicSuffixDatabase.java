package okhttp3.internal.publicsuffix;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC0712Lb;
import defpackage.AbstractC1805bc;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3724qX;
import defpackage.AbstractC3961tS;
import defpackage.AbstractC4443zE;
import defpackage.AbstractC4492zt;
import defpackage.C1025Wq;
import defpackage.EG;
import defpackage.FO;
import defpackage.FW;
import defpackage.L8;
import defpackage.OJ;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.poi.hssf.record.formula.RefErrorPtg;

/* JADX INFO: loaded from: classes3.dex */
public final class PublicSuffixDatabase {
    public static final a e = new a(null);
    public static final byte[] f = {RefErrorPtg.sid};
    public static final List g = AbstractC1805bc.e("*");
    public static final PublicSuffixDatabase h = new PublicSuffixDatabase();
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final CountDownLatch b = new CountDownLatch(1);
    public byte[] c;
    public byte[] d;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final String b(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            int iD;
            boolean z;
            int iD2;
            int length = bArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = (i3 + length) / 2;
                while (i4 > -1 && bArr[i4] != 10) {
                    i4--;
                }
                int i5 = i4 + 1;
                int i6 = 1;
                while (true) {
                    i2 = i5 + i6;
                    if (bArr[i2] == 10) {
                        break;
                    }
                    i6++;
                }
                int i7 = i2 - i5;
                int i8 = i;
                boolean z2 = false;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    if (z2) {
                        iD = 46;
                        z = false;
                    } else {
                        boolean z3 = z2;
                        iD = AbstractC3724qX.d(bArr2[i8][i9], 255);
                        z = z3;
                    }
                    iD2 = iD - AbstractC3724qX.d(bArr[i5 + i10], 255);
                    if (iD2 != 0) {
                        break;
                    }
                    i10++;
                    i9++;
                    if (i10 == i7) {
                        break;
                    }
                    if (bArr2[i8].length != i9) {
                        z2 = z;
                    } else {
                        if (i8 == bArr2.length - 1) {
                            break;
                        }
                        i8++;
                        z2 = true;
                        i9 = -1;
                    }
                }
                if (iD2 >= 0) {
                    if (iD2 <= 0) {
                        int i11 = i7 - i10;
                        int length2 = bArr2[i8].length - i9;
                        int length3 = bArr2.length;
                        for (int i12 = i8 + 1; i12 < length3; i12++) {
                            length2 += bArr2[i12].length;
                        }
                        if (length2 >= i11) {
                            if (length2 <= i11) {
                                Charset charset = StandardCharsets.UTF_8;
                                AbstractC4492zt.g(charset, "UTF_8");
                                return new String(bArr, i5, i7, charset);
                            }
                        }
                    }
                    i3 = i2 + 1;
                }
                length = i4;
            }
            return null;
        }

        public final PublicSuffixDatabase c() {
            return PublicSuffixDatabase.h;
        }

        public a() {
        }
    }

    public final List b(List list) {
        String str;
        String strB;
        String str2;
        List listM;
        List listM2;
        if (this.a.get() || !this.a.compareAndSet(false, true)) {
            try {
                this.b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            e();
        }
        if (this.c == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i = 0; i < size; i++) {
            String str3 = (String) list.get(i);
            Charset charset = StandardCharsets.UTF_8;
            AbstractC4492zt.g(charset, "UTF_8");
            byte[] bytes = str3.getBytes(charset);
            AbstractC4492zt.g(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i] = bytes;
        }
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= size) {
                strB = null;
                break;
            }
            a aVar = e;
            byte[] bArr2 = this.c;
            if (bArr2 == null) {
                AbstractC4492zt.x("publicSuffixListBytes");
                bArr2 = null;
            }
            strB = aVar.b(bArr2, bArr, i2);
            if (strB != null) {
                break;
            }
            i2++;
        }
        if (size <= 1) {
            str2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                str2 = null;
                break;
            }
            bArr3[i3] = f;
            a aVar2 = e;
            byte[] bArr4 = this.c;
            if (bArr4 == null) {
                AbstractC4492zt.x("publicSuffixListBytes");
                bArr4 = null;
            }
            String strB2 = aVar2.b(bArr4, bArr3, i3);
            if (strB2 != null) {
                str2 = strB2;
                break;
            }
            i3++;
        }
        if (str2 != null) {
            int i4 = size - 1;
            for (int i5 = 0; i5 < i4; i5++) {
                a aVar3 = e;
                byte[] bArr5 = this.d;
                if (bArr5 == null) {
                    AbstractC4492zt.x("publicSuffixExceptionListBytes");
                    bArr5 = null;
                }
                String strB3 = aVar3.b(bArr5, bArr, i5);
                if (strB3 != null) {
                    str = strB3;
                    break;
                }
            }
        }
        if (str != null) {
            return AbstractC3961tS.p0('!' + str, new char[]{'.'}, false, 0, 6, null);
        }
        if (strB == null && str2 == null) {
            return g;
        }
        if (strB == null || (listM = AbstractC3961tS.p0(strB, new char[]{'.'}, false, 0, 6, null)) == null) {
            listM = AbstractC1886cc.m();
        }
        if (str2 == null || (listM2 = AbstractC3961tS.p0(str2, new char[]{'.'}, false, 0, 6, null)) == null) {
            listM2 = AbstractC1886cc.m();
        }
        return listM.size() > listM2.size() ? listM : listM2;
    }

    public final String c(String str) {
        int size;
        int size2;
        AbstractC4492zt.h(str, "domain");
        String unicode = IDN.toUnicode(str);
        AbstractC4492zt.g(unicode, "unicodeDomain");
        List listF = f(unicode);
        List listB = b(listF);
        if (listF.size() == listB.size() && ((String) listB.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listB.get(0)).charAt(0) == '!') {
            size = listF.size();
            size2 = listB.size();
        } else {
            size = listF.size();
            size2 = listB.size() + 1;
        }
        return FO.q(FO.k(AbstractC3240kc.T(f(str)), size - size2), ".", null, null, 0, null, null, 62, null);
    }

    public final void d() {
        try {
            OJ oj = new OJ();
            OJ oj2 = new OJ();
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
            if (resourceAsStream == null) {
                this.b.countDown();
                return;
            }
            L8 l8B = AbstractC4443zE.b(new C1025Wq(AbstractC4443zE.e(resourceAsStream)));
            try {
                oj.a = l8B.w(l8B.readInt());
                oj2.a = l8B.w(l8B.readInt());
                FW fw = FW.a;
                AbstractC0712Lb.a(l8B, null);
                synchronized (this) {
                    Object obj = oj.a;
                    AbstractC4492zt.e(obj);
                    this.c = (byte[]) obj;
                    Object obj2 = oj2.a;
                    AbstractC4492zt.e(obj2);
                    this.d = (byte[]) obj2;
                }
                this.b.countDown();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AbstractC0712Lb.a(l8B, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            this.b.countDown();
            throw th3;
        }
    }

    public final void e() {
        boolean z = false;
        while (true) {
            try {
                try {
                    d();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e2) {
                    EG.a.g().j("Failed to read public suffix list", 5, e2);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final List f(String str) {
        List listP0 = AbstractC3961tS.p0(str, new char[]{'.'}, false, 0, 6, null);
        return AbstractC4492zt.d(AbstractC3240kc.k0(listP0), "") ? AbstractC3240kc.X(listP0, 1) : listP0;
    }
}
