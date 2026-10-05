package defpackage;

import android.util.Log;
import com.itextpdf.tool.xml.css.CSS;
import com.zebra.sdk.util.internal.StringUtilities;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: Mn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0749Mn {
    public String a;
    public int b;
    public double c;
    public int d;
    public double e;
    public String f;

    public C0749Mn() {
        this.f = "%1$-10s %2$-10s %3$10s";
    }

    public void A(int i, String str, int i2) {
        String strM = M(i2);
        for (int i3 = 0; i3 < i - i2; i3++) {
            strM = strM + str;
        }
        this.a += f(strM, i) + StringUtilities.LF;
    }

    public String B(String[] strArr, int i, int i2, double d, boolean z, String str) {
        s(strArr, Z00.G0, i, i2, z, str);
        System.out.println("commandSet" + this.a);
        return this.a;
    }

    public void C(String str, double d) {
        y(str, Z00.G0);
    }

    public void D(String str, double d, boolean z) {
        int i = Z00.G0;
        if (z) {
            z(str, i);
        } else {
            y(str, i);
        }
    }

    public String E(String str) {
        String[] strArrSplit = Pattern.compile("\\s").split(str);
        String str2 = "";
        for (int i = 0; i < strArrSplit.length; i++) {
            str2 = i == strArrSplit.length - 1 ? strArrSplit[i] + str2 : " " + strArrSplit[i] + str2;
        }
        return str2;
    }

    public void F(int i) {
        this.d = i;
    }

    public String G(int i) {
        String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            str = str + " ";
        }
        return str;
    }

    public String[] H(String str, int i) {
        int iCeil = (int) Math.ceil(((double) str.length()) / ((double) i));
        int length = str.length() % i;
        String[] strArr = new String[iCeil];
        for (int i2 = 0; i2 < iCeil; i2++) {
            if (i2 < iCeil - 1 || length == 0) {
                strArr[i2] = str.substring(i2 * i, (i2 + 1) * i);
            } else {
                int i3 = i2 * i;
                String strSubstring = str.substring(i3, i3 + length);
                strArr[i2] = strSubstring;
                strArr[i2] = strSubstring.concat(G(i - length));
            }
        }
        return strArr;
    }

    public String[] I(String str, int i) {
        int iCeil = (int) Math.ceil(((double) str.length()) / ((double) i));
        int length = str.length() % i;
        String[] strArr = new String[iCeil];
        for (int i2 = 0; i2 < iCeil; i2++) {
            if (i2 < iCeil - 1 || length == 0) {
                strArr[i2] = str.substring(i2 * i, (i2 + 1) * i);
            } else {
                int i3 = i2 * i;
                String strSubstring = str.substring(i3, i3 + length);
                strArr[i2] = strSubstring;
                strArr[i2] = strSubstring.concat(G(i - length));
            }
        }
        return strArr;
    }

    public String[] J(String str, int i) {
        double d = i;
        int iCeil = (int) Math.ceil(((double) str.length()) / d);
        Log.d("num_lines=", iCeil + ":" + ((int) Math.ceil(((double) str.length()) / d)) + ":" + i + ":" + str.length());
        Log.d("num_lines=", str);
        int length = str.length() % i;
        String[] strArr = new String[iCeil];
        for (int i2 = 0; i2 < iCeil; i2++) {
            if (i2 < iCeil - 1 || length == 0) {
                strArr[i2] = str.substring(i2 * i, (i2 + 1) * i);
            } else {
                int i3 = i2 * i;
                strArr[i2] = str.substring(i3, i3 + length);
            }
            Log.d("num_lines=_p", i2 + ":" + strArr[i2] + ":" + length);
        }
        return strArr;
    }

    public String[] K(String str, int i) {
        return EZ.a(str, i).split(StringUtilities.LF);
    }

    public char L() {
        return (char) 8235;
    }

    public String M(int i) {
        String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            str = str + (char) 8235;
        }
        return str;
    }

    public int[] a(int i, int i2, int i3, int i4, boolean z, String str) {
        int[] iArrT;
        int i5 = i - i4;
        int[] iArr = new int[i2];
        int i6 = i5 / i2;
        if (Z00.M0.equals("3")) {
            iArrT = z ? t(iArr, i6 - 1) : t(iArr, i6 - 1);
            if (iArrT.length >= 2) {
                iArrT[0] = iArrT[0] - 1;
            }
        } else {
            iArrT = z ? t(iArr, i6 - str.length()) : t(iArr, i6 - str.length());
        }
        iArrT[i3 - 1] = iArrT[0] + i4 + (i5 - (i6 * i2));
        return iArrT;
    }

    public String b(String str, int i) {
        int length = i - str.length();
        if (length < 0) {
            return str;
        }
        Log.d("align_left=", str + ":" + str.length() + ":" + i + ":" + length);
        return str + new String(new char[length]).replace("\u0000", " ");
    }

    public String c(String str, int i) {
        int length = i - str.length();
        Log.d("align_righ_len=", length + "");
        if (length < 0) {
            return str;
        }
        return new String(new char[length]).replace("\u0000", " ") + str;
    }

    public String d(String str, int i) {
        String strI;
        int length = str.length();
        Log.d("print_len=", length + ":" + str + ":" + str.length() + ":" + i);
        if (length < i) {
            int i2 = i - length;
            int i3 = i2 / 2;
            strI = (new String(new char[i3]).replace("\u0000", " ") + str + new String(new char[i3 + (i2 % 2)]).replace("\u0000", " ")) + StringUtilities.LF;
        } else {
            strI = i(H(str, i), i);
        }
        this.a += strI;
        Log.d("printHeader=", strI + ":" + strI.length());
        return strI;
    }

    public int e(double d, double d2) {
        double dM = m(n(d2), d);
        F((int) Math.ceil(dM));
        this.e = Math.ceil(dM);
        Log.d("width=", dM + ":" + Math.ceil(dM) + ":" + d2);
        return r();
    }

    public String f(String str, int i) {
        if (i <= str.length()) {
            return str.substring(0, i);
        }
        int length = (i - str.length()) / 2;
        if (length == 0) {
            Log.d("format_string_c=", "%-" + i + "s" + str);
            return String.format("%-" + i + "s", str);
        }
        int i2 = i - length;
        Log.d("format_string_c=", CSS.Value.PERCENTAGE + length + "s%-" + i2 + "s" + str);
        return String.format("%1$" + length + "s%2$-" + i2 + "s", new String(new char[length]).replace("\u0000", " "), str);
    }

    public boolean g(int i, int i2) {
        return i <= i2;
    }

    public boolean h(String str, int i) {
        Log.d("check_length=", str + ":" + str.length() + ":" + i);
        return str.length() <= i;
    }

    public String i(String[] strArr, int i) {
        String str = "";
        for (String str2 : strArr) {
            str = str + str2 + StringUtilities.LF;
        }
        return str;
    }

    public String j(String[] strArr, String str, int i, int[] iArr, boolean z, boolean z2) {
        String str2;
        String str3;
        String str4;
        int i2 = i;
        boolean z3 = z;
        int i3 = 4;
        int i4 = 1;
        Log.d("toStr2=", iArr.length + ":" + z3 + ":" + i2 + ":" + this.f);
        String string = "";
        char c = 0;
        String str5 = "";
        int i5 = 0;
        while (i5 < i2) {
            Log.d("toStr3=", iArr.length + ":" + z3 + ":" + i2 + ":" + strArr[i5]);
            if (iArr.length == i3) {
                if (!z3) {
                    boolean z4 = true;
                    for (int i6 = 1; i6 < strArr.length; i6++) {
                        if (strArr[i6].length() > 0) {
                            z4 = false;
                        }
                    }
                    if (z4) {
                        for (int i7 = 1; i7 < strArr.length; i7++) {
                        }
                    }
                    if (Z00.M0.equals("3")) {
                        str4 = String.format(Locale.ENGLISH, this.f, f(E(strArr[iArr.length * i5]), iArr[0]), f(strArr[(iArr.length * i5) + 1], iArr[1]), f(strArr[(iArr.length * i5) + 2], iArr[2]), f(strArr[(iArr.length * i5) + 3], iArr[3]));
                    } else {
                        str4 = String.format(Locale.ENGLISH, this.f, L() + b(strArr[iArr.length * i5], iArr[0]), L() + c(strArr[(iArr.length * i5) + 1], iArr[1]), L() + c(strArr[(iArr.length * i5) + 2], iArr[2]), L() + c(strArr[(iArr.length * i5) + 3], iArr[3]));
                    }
                    str3 = string + str4;
                    str5 = str4;
                    str2 = StringUtilities.LF;
                } else if (Z00.M0.equals("3")) {
                    String str6 = this.f;
                    String strB = b(strArr[iArr.length * i5], iArr[c]);
                    String strF = f(strArr[(iArr.length * i5) + i4], iArr[i4]);
                    String strF2 = f(strArr[(iArr.length * i5) + 2], iArr[2]);
                    String strF3 = f(strArr[(iArr.length * i5) + 3], iArr[3]);
                    Object[] objArr = new Object[i3];
                    objArr[0] = strB;
                    objArr[1] = strF;
                    objArr[2] = strF2;
                    objArr[3] = strF3;
                    str4 = String.format(str6, objArr);
                } else {
                    str4 = String.format(Locale.ENGLISH, this.f, b(strArr[iArr.length * i5], iArr[0]), c(strArr[(iArr.length * i5) + 1], iArr[1]), f(strArr[(iArr.length * i5) + 2], iArr[2]), c(strArr[(iArr.length * i5) + 3], iArr[3]));
                }
                str3 = string + str4;
                str5 = str4;
                str2 = StringUtilities.LF;
            } else if (iArr.length == 2) {
                Log.d("string_format=", this.f + ":" + iArr[0] + ":" + iArr[1]);
                String str7 = Z00.M0.equals("3") ? String.format(this.f, f(E(strArr[iArr.length * i5]), iArr[0]), f(strArr[(iArr.length * i5) + 1], iArr[1])) : String.format(this.f, b(strArr[iArr.length * i5], iArr[0]), c(strArr[(iArr.length * i5) + 1], iArr[1]));
                str3 = string + str7;
                str5 = str7;
                str2 = StringUtilities.LF;
            } else {
                for (int i8 = 0; i8 < iArr.length; i8++) {
                    string = (i8 == 0 && iArr.length == 3) ? string + b(strArr[(iArr.length * i5) + i8], iArr[i8]) + str : string + f(strArr[(iArr.length * i5) + i8], iArr[i8]) + str;
                    Log.d("row_w2=", f(strArr[(iArr.length * i5) + i8], iArr[i8]) + str + StringUtilities.LF + strArr[i5] + ":" + iArr[i8]);
                }
                str2 = StringUtilities.LF;
                str3 = string;
            }
            Log.d("row_w=", str5.length() + "=" + str5 + ":" + u(str5));
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(str2);
            string = sb.toString();
            i5++;
            i2 = i;
            z3 = z;
            i3 = 4;
            i4 = 1;
            c = 0;
        }
        return string;
    }

    public String k(String[] strArr, int i) {
        String str = "";
        for (int i2 = 0; i2 < strArr.length; i2++) {
            str = Z00.M0.equals("3") ? str + E(strArr[i2]) + StringUtilities.LF : str + strArr[i2] + StringUtilities.LF;
        }
        return str;
    }

    public double l(double d, int i) {
        double d2 = i;
        return d2 / ((double) e(d, d2));
    }

    public double m(double d, double d2) {
        return d * d2;
    }

    public double n(double d) {
        return d * 0.0393701d;
    }

    public double o(int i, int i2) {
        return ((double) (i * i2)) / 25.4d;
    }

    public int p(int[] iArr) {
        int iMax = iArr[0];
        for (int i = 1; i < iArr.length; i++) {
            iMax = Math.max(iArr[i], iMax);
        }
        System.out.println("The Maximum value is : " + iMax);
        return iMax;
    }

    public int q(String[] strArr, int i, int[] iArr, int i2) {
        boolean[] zArr = new boolean[strArr.length];
        int[] iArr2 = new int[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (i3 == i2 - 1) {
                zArr[i3] = g(strArr[i3].length(), iArr[i3]);
            } else {
                zArr[i3] = g(strArr[i3].length(), iArr[i3]);
            }
            Log.d("max_row=", zArr[i3] + ":" + i3 + ":" + strArr[i3] + ":" + iArr[i3]);
        }
        int[] iArrT = t(iArr2, 1);
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (zArr[i4]) {
                iArrT[i4] = 1;
            } else {
                iArrT[i4] = x(strArr[i4].length(), iArr[i4]);
            }
        }
        return p(iArrT);
    }

    public int r() {
        return this.d;
    }

    public String s(String[] strArr, int i, int i2, int i3, boolean z, String str) {
        int[] iArrA;
        int i4;
        int iQ;
        String[] strArrJ;
        int i5;
        int[] iArr = new int[strArr.length];
        if (!z || strArr.length < 4) {
            iArrA = a(i, strArr.length, i2, i3, u(strArr[0]), str);
            int i6 = Z00.G0;
            if (i6 <= 35 || iArrA.length < 4) {
                i4 = 5;
            } else {
                iArrA[1] = iArrA[1] - 3;
                iArrA[2] = iArrA[2] - 2;
                i4 = 5;
                iArrA[0] = iArrA[0] + 5;
            }
            if (i6 > 35 && iArrA.length == 3) {
                int i7 = iArrA[2] - i4;
                iArrA[2] = i7;
                iArrA[1] = iArrA[1] - 2;
                int i8 = iArrA[0] + 7;
                iArrA[0] = i8;
                if (i7 <= 4) {
                    iArrA[0] = i8 - (5 - i7);
                    iArrA[2] = i4;
                }
                int i9 = iArrA[2];
                if (i9 > i4) {
                    iArrA[0] = iArrA[0] + (i9 - i4);
                    iArrA[2] = i4;
                }
            } else if (i6 > 30 && iArrA.length == 3) {
                int i10 = iArrA[2] - 2;
                iArrA[2] = i10;
                iArrA[1] = iArrA[1] - 1;
                int i11 = iArrA[0] + 4;
                iArrA[0] = i11;
                if (i10 <= 4) {
                    iArrA[0] = i11 - (5 - i10);
                    iArrA[2] = i4;
                }
                int i12 = iArrA[2];
                if (i12 > i4) {
                    iArrA[0] = iArrA[0] + (i12 - i4);
                    iArrA[2] = i4;
                }
            } else if (iArrA.length == 3) {
                int i13 = iArrA[2];
                if (i13 <= 4) {
                    iArrA[0] = iArrA[0] - (5 - i13);
                    iArrA[2] = i4;
                }
                int i14 = iArrA[2];
                if (i14 > i4) {
                    iArrA[0] = iArrA[0] + (i14 - i4);
                    iArrA[2] = i4;
                }
            }
            int length = iArrA.length;
            iQ = q(strArr, i - strArr.length, iArrA, i2);
        } else {
            iArrA = a(i, strArr.length, i2, i3, false, str);
            Log.d("col_w_h=", iArrA[0] + ":" + iArrA[1] + ":" + iArrA[2] + ":" + iArrA[3]);
            if (Z00.G0 <= 35) {
                strArr[0] = "صنف";
                strArr[1] = "كمية";
                strArr[2] = "سعر";
                strArr[3] = "مجموع";
            }
            if (Z00.M0.equals("3") && Z00.G0 <= 32) {
                strArr[0] = "صنف";
                strArr[1] = "كمية";
                strArr[2] = "سعر";
                strArr[3] = "مجموع";
            }
            if (iArrA[1] <= strArr[1].length() && (iArrA[0] - strArr[0].length()) - (strArr[1].length() - iArrA[1]) > 0) {
                int i15 = iArrA[0];
                int length2 = strArr[1].length();
                int i16 = iArrA[1];
                iArrA[0] = i15 - (length2 - i16);
                iArrA[1] = i16 + (strArr[1].length() - iArrA[1]);
            }
            if (iArrA[2] <= strArr[2].length() && (iArrA[0] - strArr[0].length()) - (strArr[2].length() - iArrA[1]) > 0) {
                int i17 = iArrA[0];
                int length3 = strArr[2].length();
                int i18 = iArrA[2];
                iArrA[0] = i17 - (length3 - i18);
                iArrA[2] = i18 + (strArr[2].length() - iArrA[2]);
            }
            if (iArrA[3] <= strArr[3].length() && (iArrA[0] - strArr[0].length()) - (strArr[3].length() - iArrA[3]) > 0) {
                int i19 = iArrA[0];
                int length4 = strArr[3].length();
                int i20 = iArrA[3];
                iArrA[0] = i19 - (length4 - i20);
                iArrA[3] = i20 + (strArr[3].length() - iArrA[3]);
            }
            if (Z00.M0.equals("3")) {
                int i21 = Z00.G0;
                if (i21 >= 38) {
                    iArrA[0] = iArrA[0] + 3;
                    int i22 = iArrA[1];
                    iArrA[1] = i22 - 1;
                    iArrA[2] = i22 - 3;
                } else if (i21 >= 31) {
                    iArrA[0] = iArrA[0] + 3;
                    int i23 = iArrA[1];
                    iArrA[1] = i23 - 1;
                    iArrA[2] = i23 - 3;
                }
            } else {
                int i24 = Z00.G0;
                if (i24 <= 35 || iArrA.length < 4) {
                    i5 = 5;
                } else {
                    iArrA[1] = iArrA[1] - 2;
                    iArrA[2] = iArrA[2] - 2;
                    i5 = 5;
                    iArrA[0] = iArrA[0] + 5;
                }
                if (i24 > 35 && iArrA.length == 3) {
                    int i25 = iArrA[2] - i5;
                    iArrA[2] = i25;
                    iArrA[1] = iArrA[1] - 2;
                    int i26 = iArrA[0] + 7;
                    iArrA[0] = i26;
                    if (i25 <= 4) {
                        iArrA[0] = i26 - (5 - i25);
                        iArrA[2] = i5;
                    }
                    int i27 = iArrA[2];
                    if (i27 > i5) {
                        iArrA[0] = iArrA[0] + (i27 - i5);
                        iArrA[2] = i5;
                    }
                } else if (i24 > 35 && iArrA.length == 3) {
                    int i28 = iArrA[2] - 2;
                    iArrA[2] = i28;
                    iArrA[1] = iArrA[1] - 1;
                    int i29 = iArrA[0] + 4;
                    iArrA[0] = i29;
                    if (i28 <= 4) {
                        iArrA[0] = i29 - (5 - i28);
                        iArrA[2] = i5;
                    }
                    int i30 = iArrA[2];
                    if (i30 > i5) {
                        iArrA[0] = iArrA[0] + (i30 - i5);
                        iArrA[2] = i5;
                    }
                }
            }
            iQ = q(strArr, i, iArrA, i2);
        }
        int[] iArr2 = iArrA;
        int i31 = iQ;
        this.f = "";
        int i32 = 0;
        while (i32 < iArr2.length) {
            Log.d("col_w=", iArr2[i32] + ":" + i32 + ":" + i + "::" + strArr[i32] + ":" + i31);
            if (!Z00.M0.equals("3")) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f);
                sb.append(CSS.Value.PERCENTAGE);
                sb.append(i32 + 1);
                sb.append("$");
                sb.append((z && i32 == 0) ? "" : "-");
                sb.append(iArr2[i32]);
                sb.append("s");
                sb.append(str);
                this.f = sb.toString();
            } else if (i32 == 0) {
                this.f += CSS.Value.PERCENTAGE + (i32 + 1) + "$-" + iArr2[i32] + "s " + str;
            } else {
                this.f += CSS.Value.PERCENTAGE + (i32 + 1) + "$-" + iArr2[i32] + "s" + str;
            }
            i32++;
        }
        Log.d("format_string=", this.f + ":" + i31);
        String[] strArr2 = new String[i31];
        String[] strArr3 = new String[strArr.length * i31];
        for (int i33 = 0; i33 < strArr.length; i33++) {
            String[] strArr4 = new String[i31];
            if (h(strArr[i33], iArr2[i33])) {
                int i34 = 0;
                while (i34 < i31) {
                    strArr2[i34] = i34 == 0 ? strArr[i33] : "";
                    i34++;
                }
                for (int i35 = 0; i35 < i31; i35++) {
                    System.out.println("Final strrrrr not part:" + i35 + ":" + strArr2[i35] + ":" + strArr2[i35].length() + ":" + iArr2[i33]);
                }
            } else {
                if (i33 == 0) {
                    strArrJ = K(strArr[i33], iArr2[i33]);
                    boolean z2 = true;
                    for (String str2 : strArrJ) {
                        if (str2.length() > iArr2[i33]) {
                            z2 = false;
                        }
                    }
                    if (!z2) {
                        strArrJ = J(strArr[i33], iArr2[i33]);
                    }
                } else {
                    strArrJ = J(strArr[i33], iArr2[i33]);
                }
                int i36 = 0;
                while (i36 < i31) {
                    strArr2[i36] = i36 < strArrJ.length ? strArrJ[i36] : "";
                    i36++;
                }
                for (int i37 = 0; i37 < i31; i37++) {
                    System.out.println("Final strrrrr with part:" + i37 + ":" + strArr2[i37] + ":" + strArr2[i37].length() + ":" + strArr[i33].length() + ":" + iArr2[i33]);
                }
            }
            for (int i38 = 0; i38 < i31; i38++) {
                strArr3[(strArr.length * i38) + i33] = strArr2[i38];
            }
        }
        String strJ = j(strArr3, str, i31, iArr2, z, u(strArr[0]));
        this.a += strJ;
        System.out.println("Header format" + this.a);
        return strJ;
    }

    public int[] t(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = i;
        }
        return iArr;
    }

    public boolean u(String str) {
        return str.matches(".*[a-zA-Z].*");
    }

    public String v(String str, String str2, int i) {
        if (Z00.M0.equals("3")) {
            str = E(str);
        }
        String str3 = str + str2;
        int iW = i + w(str3);
        if (str3.length() >= iW) {
            return str3;
        }
        return str + new String(new char[(iW - str.length()) - str2.length()]).replace("\u0000", " ") + str2;
    }

    public int w(String str) {
        int iCharCount = 0;
        int i = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 1536 && iCodePointAt <= 1760) {
                i++;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        Log.d("arabic_cnt=", i + ":" + str + ":" + str.length());
        int i2 = i / Z00.J0;
        int i3 = Z00.G0 / Z00.J0;
        return 0;
    }

    public int x(double d, double d2) {
        return (int) Math.ceil(d / d2);
    }

    public String y(String str, int i) {
        String strI;
        int iW = w(str) + i;
        if (h(str, iW)) {
            Log.d("printHeader=", "Y1:" + i + ":" + iW);
            strI = d(str, iW);
        } else {
            Log.d("printHeader=", "Y2:" + i + ":" + iW);
            strI = i(I(str, iW), iW);
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(strI);
            this.a = sb.toString();
        }
        new WH();
        Log.d("commandSet=", this.a);
        return strI;
    }

    public String z(String str, int i) {
        String strK;
        int iW = w(str) + i;
        if (h(str, iW)) {
            strK = Z00.M0.equals("3") ? d(E(str), iW) : d(str, iW);
        } else {
            int iQ = q(new String[]{str}, i, new int[]{i}, 0);
            String[] strArrK = K(str, i);
            String[] strArr = new String[iQ];
            boolean z = true;
            for (String str2 : strArrK) {
                if (str2.length() > i) {
                    z = false;
                }
            }
            if (!z) {
                strArrK = J(str, i);
            }
            strK = k(strArrK, i);
            this.a += strK;
        }
        new WH();
        Log.d("commandSet=", this.a);
        return strK;
    }

    public C0749Mn(double d, int i) {
        this.f = "%1$-10s %2$-10s %3$10s";
        this.a = "";
        this.b = i;
        this.c = d;
        this.d = e(d, i);
    }
}
