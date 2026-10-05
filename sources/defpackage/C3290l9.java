package defpackage;

import com.google.common.net.HttpHeaders;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: l9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3290l9 {
    public static final b n = new b(null);
    public static final C3290l9 o = new a().d().a();
    public static final C3290l9 p = new a().e().c(Integer.MAX_VALUE, TimeUnit.SECONDS).a();
    public final boolean a;
    public final boolean b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public String m;

    /* JADX INFO: renamed from: l9$a */
    public static final class a {
        public boolean a;
        public boolean b;
        public int c = -1;
        public int d = -1;
        public int e = -1;
        public boolean f;
        public boolean g;
        public boolean h;

        public final C3290l9 a() {
            return new C3290l9(this.a, this.b, this.c, -1, false, false, false, this.d, this.e, this.f, this.g, this.h, null, null);
        }

        public final int b(long j) {
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }

        public final a c(int i, TimeUnit timeUnit) {
            AbstractC4492zt.h(timeUnit, "timeUnit");
            if (i >= 0) {
                this.d = b(timeUnit.toSeconds(i));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i).toString());
        }

        public final a d() {
            this.a = true;
            return this;
        }

        public final a e() {
            this.f = true;
            return this;
        }
    }

    /* JADX INFO: renamed from: l9$b */
    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final int a(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (AbstractC3961tS.F(str2, str.charAt(i), false, 2, null)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }

        /* JADX WARN: Code duplicated, block: B:15:0x004b  */
        /* JADX WARN: Code duplicated, block: B:17:0x0068  */
        /* JADX WARN: Code duplicated, block: B:28:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:40:0x00fc  */
        /* JADX WARN: Code duplicated, block: B:43:0x010a  */
        /* JADX WARN: Code duplicated, block: B:55:0x014b  */
        /* JADX WARN: Code duplicated, block: B:58:0x0159  */
        /* JADX WARN: Code duplicated, block: B:76:0x00d8 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:77:0x00e8 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:78:0x00d0 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:79:0x0184 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:80:0x00e0 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:81:0x0112 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:82:0x0122 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:83:0x0132 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:84:0x0162 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:85:0x0173 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:86:0x00f5 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:87:0x00f0 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:88:0x0104 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:89:0x0143 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:90:0x0153 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:91:0x017c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:92:0x016b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:93:0x013b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:94:0x012a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:95:0x011a A[SYNTHETIC] */
        public final C3290l9 b(C3994tr c3994tr) {
            int iA;
            int iA2;
            String string;
            String string2;
            C3994tr c3994tr2 = c3994tr;
            AbstractC4492zt.h(c3994tr2, "headers");
            int size = c3994tr.size();
            boolean z = true;
            int i = 0;
            boolean z2 = true;
            String str = null;
            boolean z3 = false;
            boolean z4 = false;
            int iX = -1;
            int iX2 = -1;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            int iX3 = -1;
            int iX4 = -1;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            while (i < size) {
                String strB = c3994tr2.b(i);
                String strE = c3994tr2.e(i);
                if (AbstractC3880sS.q(strB, HttpHeaders.CACHE_CONTROL, z)) {
                    if (str == null) {
                        str = strE;
                    }
                    iA = 0;
                    while (iA < strE.length()) {
                        iA2 = a(strE, "=,;", iA);
                        String strSubstring = strE.substring(iA, iA2);
                        AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        string = AbstractC3961tS.D0(strSubstring).toString();
                        if (iA2 != strE.length()) {
                            size = size;
                            if (strE.charAt(iA2) == ',' && strE.charAt(iA2) != ';') {
                                int iD = AbstractC3724qX.D(strE, iA2 + 1);
                                if (iD >= strE.length() || strE.charAt(iD) != '\"') {
                                    iA = a(strE, ",;", iD);
                                    String strSubstring2 = strE.substring(iD, iA);
                                    AbstractC4492zt.g(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                    string2 = AbstractC3961tS.D0(strSubstring2).toString();
                                } else {
                                    int i2 = iD + 1;
                                    int iQ = AbstractC3961tS.Q(strE, '\"', i2, false, 4, null);
                                    string2 = strE.substring(i2, iQ);
                                    AbstractC4492zt.g(string2, "this as java.lang.String…ing(startIndex, endIndex)");
                                    iA = iQ + 1;
                                }
                            }
                            z = true;
                            if (AbstractC3880sS.q("no-cache", string, true)) {
                                z3 = true;
                            } else if (AbstractC3880sS.q("no-store", string, true)) {
                                z4 = true;
                            } else if (AbstractC3880sS.q("max-age", string, true)) {
                                iX = AbstractC3724qX.X(string2, -1);
                            } else if (AbstractC3880sS.q("s-maxage", string, true)) {
                                iX2 = AbstractC3724qX.X(string2, -1);
                            } else if (AbstractC3880sS.q("private", string, true)) {
                                z5 = true;
                            } else if (AbstractC3880sS.q("public", string, true)) {
                                z6 = true;
                            } else if (AbstractC3880sS.q("must-revalidate", string, true)) {
                                z7 = true;
                            } else if (AbstractC3880sS.q("max-stale", string, true)) {
                                iX3 = AbstractC3724qX.X(string2, Integer.MAX_VALUE);
                            } else if (AbstractC3880sS.q("min-fresh", string, true)) {
                                iX4 = AbstractC3724qX.X(string2, -1);
                            } else if (AbstractC3880sS.q("only-if-cached", string, true)) {
                                z8 = true;
                            } else if (AbstractC3880sS.q("no-transform", string, true)) {
                                z9 = true;
                            } else if (AbstractC3880sS.q("immutable", string, true)) {
                                z10 = true;
                            }
                        } else {
                            size = size;
                        }
                        iA = iA2 + 1;
                        string2 = null;
                        z = true;
                        if (AbstractC3880sS.q("no-cache", string, true)) {
                            z3 = true;
                        } else if (AbstractC3880sS.q("no-store", string, true)) {
                            z4 = true;
                        } else if (AbstractC3880sS.q("max-age", string, true)) {
                            iX = AbstractC3724qX.X(string2, -1);
                        } else if (AbstractC3880sS.q("s-maxage", string, true)) {
                            iX2 = AbstractC3724qX.X(string2, -1);
                        } else if (AbstractC3880sS.q("private", string, true)) {
                            z5 = true;
                        } else if (AbstractC3880sS.q("public", string, true)) {
                            z6 = true;
                        } else if (AbstractC3880sS.q("must-revalidate", string, true)) {
                            z7 = true;
                        } else if (AbstractC3880sS.q("max-stale", string, true)) {
                            iX3 = AbstractC3724qX.X(string2, Integer.MAX_VALUE);
                        } else if (AbstractC3880sS.q("min-fresh", string, true)) {
                            iX4 = AbstractC3724qX.X(string2, -1);
                        } else if (AbstractC3880sS.q("only-if-cached", string, true)) {
                            z8 = true;
                        } else if (AbstractC3880sS.q("no-transform", string, true)) {
                            z9 = true;
                        } else if (AbstractC3880sS.q("immutable", string, true)) {
                            z10 = true;
                        }
                    }
                    i++;
                    c3994tr2 = c3994tr;
                    size = size;
                } else {
                    if (AbstractC3880sS.q(strB, HttpHeaders.PRAGMA, z)) {
                    }
                    i++;
                    c3994tr2 = c3994tr;
                    size = size;
                }
                z2 = false;
                iA = 0;
                while (iA < strE.length()) {
                    iA2 = a(strE, "=,;", iA);
                    String strSubstring3 = strE.substring(iA, iA2);
                    AbstractC4492zt.g(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    string = AbstractC3961tS.D0(strSubstring3).toString();
                    if (iA2 != strE.length()) {
                        size = size;
                        if (strE.charAt(iA2) == ',') {
                        }
                        z = true;
                        if (AbstractC3880sS.q("no-cache", string, true)) {
                            z3 = true;
                        } else if (AbstractC3880sS.q("no-store", string, true)) {
                            z4 = true;
                        } else if (AbstractC3880sS.q("max-age", string, true)) {
                            iX = AbstractC3724qX.X(string2, -1);
                        } else if (AbstractC3880sS.q("s-maxage", string, true)) {
                            iX2 = AbstractC3724qX.X(string2, -1);
                        } else if (AbstractC3880sS.q("private", string, true)) {
                            z5 = true;
                        } else if (AbstractC3880sS.q("public", string, true)) {
                            z6 = true;
                        } else if (AbstractC3880sS.q("must-revalidate", string, true)) {
                            z7 = true;
                        } else if (AbstractC3880sS.q("max-stale", string, true)) {
                            iX3 = AbstractC3724qX.X(string2, Integer.MAX_VALUE);
                        } else if (AbstractC3880sS.q("min-fresh", string, true)) {
                            iX4 = AbstractC3724qX.X(string2, -1);
                        } else if (AbstractC3880sS.q("only-if-cached", string, true)) {
                            z8 = true;
                        } else if (AbstractC3880sS.q("no-transform", string, true)) {
                            z9 = true;
                        } else if (AbstractC3880sS.q("immutable", string, true)) {
                            z10 = true;
                        }
                    } else {
                        size = size;
                    }
                    iA = iA2 + 1;
                    string2 = null;
                    z = true;
                    if (AbstractC3880sS.q("no-cache", string, true)) {
                        z3 = true;
                    } else if (AbstractC3880sS.q("no-store", string, true)) {
                        z4 = true;
                    } else if (AbstractC3880sS.q("max-age", string, true)) {
                        iX = AbstractC3724qX.X(string2, -1);
                    } else if (AbstractC3880sS.q("s-maxage", string, true)) {
                        iX2 = AbstractC3724qX.X(string2, -1);
                    } else if (AbstractC3880sS.q("private", string, true)) {
                        z5 = true;
                    } else if (AbstractC3880sS.q("public", string, true)) {
                        z6 = true;
                    } else if (AbstractC3880sS.q("must-revalidate", string, true)) {
                        z7 = true;
                    } else if (AbstractC3880sS.q("max-stale", string, true)) {
                        iX3 = AbstractC3724qX.X(string2, Integer.MAX_VALUE);
                    } else if (AbstractC3880sS.q("min-fresh", string, true)) {
                        iX4 = AbstractC3724qX.X(string2, -1);
                    } else if (AbstractC3880sS.q("only-if-cached", string, true)) {
                        z8 = true;
                    } else if (AbstractC3880sS.q("no-transform", string, true)) {
                        z9 = true;
                    } else if (AbstractC3880sS.q("immutable", string, true)) {
                        z10 = true;
                    }
                }
                i++;
                c3994tr2 = c3994tr;
                size = size;
            }
            return new C3290l9(z3, z4, iX, iX2, z5, z6, z7, iX3, iX4, z8, z9, z10, !z2 ? null : str, null);
        }

        public b() {
        }
    }

    public /* synthetic */ C3290l9(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str, AbstractC0419Di abstractC0419Di) {
        this(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, z8, str);
    }

    public final boolean a() {
        return this.e;
    }

    public final boolean b() {
        return this.f;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.h;
    }

    public final int e() {
        return this.i;
    }

    public final boolean f() {
        return this.g;
    }

    public final boolean g() {
        return this.a;
    }

    public final boolean h() {
        return this.b;
    }

    public final boolean i() {
        return this.j;
    }

    public String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.a) {
            sb.append("no-cache, ");
        }
        if (this.b) {
            sb.append("no-store, ");
        }
        if (this.c != -1) {
            sb.append("max-age=");
            sb.append(this.c);
            sb.append(", ");
        }
        if (this.d != -1) {
            sb.append("s-maxage=");
            sb.append(this.d);
            sb.append(", ");
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        if (this.h != -1) {
            sb.append("max-stale=");
            sb.append(this.h);
            sb.append(", ");
        }
        if (this.i != -1) {
            sb.append("min-fresh=");
            sb.append(this.i);
            sb.append(", ");
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        AbstractC4492zt.g(string, "StringBuilder().apply(builderAction).toString()");
        this.m = string;
        return string;
    }

    public C3290l9(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.a = z;
        this.b = z2;
        this.c = i;
        this.d = i2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = i3;
        this.i = i4;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }
}
