package defpackage;

import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;

/* JADX INFO: loaded from: classes3.dex */
public class DW {
    public static int[] e = {65154, 65156, 65166, 65167, 65173, 65177, 1548, 65181, 65185, 65189, 1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641, 65233, 1563, 65201, 65205, 65209, 1567, 65152, 65153, 65155, 65157, 65226, 65163, 65165, 65169, 65171, 65175, 65179, 65183, 65187, 65191, 65193, 65195, 65197, 65199, 65203, 65207, 65211, 65215, 65219, 65223, 65227, 65231, 65225, 1600, 65235, 65239, 65243, 65247, 65251, 65255, 65259, 65261, 65263, 65267, 65213, 65228, 65230, 65229, 65249, 65253, 65257, 65260, 65264, 65266, 65232, 65237, 65269, 65270, 65245, 65241, 65265, 65275, 46};
    public StringBuilder a;
    public StringBuilder b;
    public String c = "دذرزوؤء";
    public String d = "ع غ ه ي";

    public DW() {
        this.a = new StringBuilder();
        this.b = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        this.a = sb;
        sb.append("ﺂ");
        this.a.append("ﺄ");
        this.a.append("ﺎ");
        this.a.append("ب");
        this.a.append("ت");
        this.a.append("ث");
        this.a.append("،");
        this.a.append("ج");
        this.a.append("ح");
        this.a.append("خ");
        this.a.append("٠");
        this.a.append("١");
        this.a.append("٢");
        this.a.append("٣");
        this.a.append("٤");
        this.a.append("٥");
        this.a.append("٦");
        this.a.append("٧");
        this.a.append("٨");
        this.a.append("٩");
        this.a.append("ف");
        this.a.append("؛");
        this.a.append("س");
        this.a.append("ش");
        this.a.append("ص");
        this.a.append("؟");
        this.a.append("ء");
        this.a.append("آ");
        this.a.append("أ");
        this.a.append("ؤ");
        this.a.append("ﻊ");
        this.a.append("ئ");
        this.a.append("ا");
        this.a.append("ﺑ");
        this.a.append("ة");
        this.a.append("ﺗ");
        this.a.append("ﺛ");
        this.a.append("ﺟ");
        this.a.append("ﺣ");
        this.a.append("ﺧ");
        this.a.append("د");
        this.a.append("ذ");
        this.a.append("ر");
        this.a.append("ز");
        this.a.append("ﺳ");
        this.a.append("ﺷ");
        this.a.append("ﺻ");
        this.a.append("ﺿ");
        this.a.append("ط");
        this.a.append("ظ");
        this.a.append("ﻋ");
        this.a.append("ﻏ");
        this.a.append("ع");
        this.a.append("ـ");
        this.a.append("ﻓ");
        this.a.append("ﻗ");
        this.a.append("ﻛ");
        this.a.append("ﻟ");
        this.a.append("ﻣ");
        this.a.append("ﻧ");
        this.a.append("ﻫ");
        this.a.append("و");
        this.a.append("ﻯ");
        this.a.append("ﻳ");
        this.a.append("ض");
        this.a.append("ﻌ");
        this.a.append("ﻎ");
        this.a.append("غ");
        this.a.append("م");
        this.a.append("ن");
        this.a.append("ه");
        this.a.append("ﻬ");
        this.a.append("ﻰ");
        this.a.append("ﻲ");
        this.a.append("ﻐ");
        this.a.append("ق");
        this.a.append("ﻵ");
        this.a.append("ﻶ");
        this.a.append("ل");
        this.a.append("ك");
        this.a.append("ي");
        this.a.append("إ");
        this.a.append(".");
        StringBuilder sb2 = new StringBuilder();
        this.b = sb2;
        sb2.append("ﺂ");
        this.b.append("ﺄ");
        this.b.append("ﺎ");
        this.b.append("ﺏ");
        this.b.append("ﺕ");
        this.b.append("ﺙ");
        this.b.append("،");
        this.b.append("ﺝ");
        this.b.append("ﺡ");
        this.b.append("ﺥ");
        this.b.append("٠");
        this.b.append("١");
        this.b.append("٢");
        this.b.append("٣");
        this.b.append("٤");
        this.b.append("٥");
        this.b.append("٦");
        this.b.append("٧");
        this.b.append("٨");
        this.b.append("٩");
        this.b.append("ﻑ");
        this.b.append("؛");
        this.b.append("ﺱ");
        this.b.append("ﺵ");
        this.b.append("ﺹ");
        this.b.append("؟");
        this.b.append("ء");
        this.b.append("آ");
        this.b.append("أ");
        this.b.append("ؤ");
        this.b.append("ﻊ");
        this.b.append("ئ");
        this.b.append("ا");
        this.b.append("ب");
        this.b.append("ﺓ");
        this.b.append("ت");
        this.b.append("ث");
        this.b.append("ج");
        this.b.append("ح");
        this.b.append("خ");
        this.b.append("د");
        this.b.append("ذ");
        this.b.append("ر");
        this.b.append("ز");
        this.b.append("س");
        this.b.append("ش");
        this.b.append("ص");
        this.b.append("ض");
        this.b.append("ط");
        this.b.append("ظ");
        this.b.append("ع");
        this.b.append("غ");
        this.b.append("ﻉ");
        this.b.append("ـ");
        this.b.append("ف");
        this.b.append("ق");
        this.b.append("ك");
        this.b.append("ل");
        this.b.append("م");
        this.b.append("ن");
        this.b.append("ه");
        this.b.append("و");
        this.b.append("ى");
        this.b.append("ي");
        this.b.append("ﺽ");
        this.b.append("ﻌ");
        this.b.append("ﻎ");
        this.b.append("ﻍ");
        this.b.append("ﻡ");
        this.b.append("ﻥ");
        this.b.append("ﻩ");
        this.b.append("ه");
        this.b.append("ﻰ");
        this.b.append("ﻲ");
        this.b.append("ﻐ");
        this.b.append("ﻕ");
        this.b.append("ﻵ");
        this.b.append("ﻶ");
        this.b.append("ﻝ");
        this.b.append("ﻙ");
        this.b.append("ﻱ");
        this.b.append("إ");
        this.b.append(".");
    }

    public static String a(byte b) {
        char[] cArr = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', 'a', 'b', Barcode128.CODE_AB_TO_C, Barcode128.CODE_AC_TO_B, Barcode128.CODE_BC_TO_A, Barcode128.FNC1_INDEX};
        return new String(new char[]{cArr[(b >> 4) & 15], cArr[b & 15]});
    }

    public String b(String str) {
        String[] strArrSplit = str.split(" ");
        int i = 0;
        String string = "";
        while (i < strArrSplit.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(d(strArrSplit[i]));
            sb.append(i != strArrSplit.length + (-1) ? " " : "");
            string = sb.toString();
            i++;
        }
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0059 A[RETURN, SYNTHETIC] */
    public int c(String str, int i) {
        if (i == 4) {
            if (str.equals("ع")) {
                return 30;
            }
            if (str.equals("غ")) {
                return 66;
            }
            if (str.equals("ه")) {
                return 70;
            }
            if (str.equals("ي")) {
                return 73;
            }
        } else {
            if (i == 3) {
                if (str.equals("ع")) {
                    return 65;
                }
                if (str.equals("غ")) {
                    return 74;
                }
                if (!str.equals("ه")) {
                    if (str.equals("ي")) {
                        return 63;
                    }
                }
                return 71;
            }
            if (i == 2) {
                if (str.equals("ع")) {
                    return 50;
                }
                if (str.equals("غ")) {
                    return 51;
                }
                if (!str.equals("ه")) {
                    if (str.equals("ي")) {
                        return 63;
                    }
                }
                return 71;
            }
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0056  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:30:0x007d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:34:0x0092  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e7  */
    public String d(String str) {
        int i;
        String str2 = "";
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + 1;
            String strSubstring = str.substring(i2, i3);
            int iIndexOf = 2;
            if (i2 == str.length() - 1 || (i2 > 0 && (i = i2 + 2) < str.length() && "1234567890#:".contains(str.substring(i3, i)))) {
                if (strSubstring.equals("ا") && i2 != 0) {
                    int i4 = i2 - 1;
                    if (!Z00.ca(str.substring(i4, i2)) || this.c.contains(str.substring(i4, i2))) {
                        if (this.d.contains(strSubstring)) {
                            iIndexOf = this.a.toString().indexOf(strSubstring);
                        } else {
                            iIndexOf = this.a.toString().indexOf(strSubstring);
                        }
                    }
                } else if (this.d.contains(strSubstring) || i2 == 0 || this.c.contains(str.substring(i2 - 1, i2))) {
                    iIndexOf = this.a.toString().indexOf(strSubstring);
                } else {
                    iIndexOf = c(strSubstring, 4);
                }
            } else if (i2 <= 0) {
                iIndexOf = this.b.toString().indexOf(strSubstring);
            } else if (strSubstring.equals("ا") && i2 != 0) {
                int i5 = i2 - 1;
                if (!Z00.ca(str.substring(i5, i2)) || this.c.contains(str.substring(i5, i2))) {
                    if (!this.d.contains(strSubstring)) {
                        if (this.d.contains(strSubstring)) {
                            iIndexOf = this.b.toString().indexOf(strSubstring);
                        } else {
                            iIndexOf = this.b.toString().indexOf(strSubstring);
                        }
                    } else if (this.d.contains(strSubstring)) {
                        iIndexOf = this.b.toString().indexOf(strSubstring);
                    } else {
                        iIndexOf = this.b.toString().indexOf(strSubstring);
                    }
                }
            } else if (!this.d.contains(strSubstring) && i2 != 0 && !this.c.contains(str.substring(i2 - 1, i2))) {
                iIndexOf = c(strSubstring, 3);
            } else if (this.d.contains(strSubstring) || i2 == 0 || !this.c.contains(str.substring(i2 - 1, i2))) {
                iIndexOf = this.b.toString().indexOf(strSubstring);
            } else {
                iIndexOf = c(strSubstring, 2);
            }
            if (iIndexOf < 0) {
                str2 = str2 + strSubstring;
            } else {
                str2 = str2 + String.valueOf((char) e[iIndexOf]);
            }
            i2 = i3;
        }
        return str2;
    }
}
