package defpackage;

import android.util.Log;

/* JADX INFO: renamed from: fE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2181fE {
    public static final String[] a = {"", "واحد", "إثنان", "ثلاثة", "أربعة", "خمسة", "ستة", "سبعة", "ثمانية", "تسعة", "عشرة", "إحدى عشر", "إثنا عشر", "ثلاثة عشر", "أربعة عشر", "خمسة عشر", "ستة عشر", "سبعة عشر", "ثمانية عشر", "تسعة عشر"};
    public static final String[] b = {"", "", "عشرون", "ثلاثون", "أربعون", "خمسون", "ستون", "سبعون", "ثمانون", "تسعون"};
    public static final String[] c = {"", "مائة", "مائتان", "ثلاثمائة", "أربعمائة", "خمسمائة", "ستمائة", "سبعمائة", "ثمانمائة", "تسعمائة"};

    public static String a(double d) {
        if (d < 0.0d) {
            return "minus " + a(-d);
        }
        Log.d("total_alph=", d + "");
        if (d < 20.0d) {
            return a[(int) d];
        }
        if (d < 100.0d) {
            StringBuilder sb = new StringBuilder();
            sb.append(a[(int) (d % 10.0d)]);
            sb.append(((int) d) % 10 != 0 ? " و " : "");
            sb.append(b[(int) (d / 10.0d)]);
            return sb.toString();
        }
        if (d < 1000.0d) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c[(int) (d / 100.0d)]);
            sb2.append(((int) d) % 100 != 0 ? " و " : "");
            sb2.append(a(d % 100.0d));
            return sb2.toString();
        }
        if (d < 1000000.0d) {
            if (d >= 2000.0d && d < 3000.0d) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" ألفين");
                sb3.append(((int) d) % 1000 != 0 ? " و " : "");
                sb3.append(a(d % 1000.0d));
                return sb3.toString();
            }
            if (d >= 1000.0d && d < 2000.0d) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(" ألف");
                sb4.append(((int) d) % 1000 != 0 ? " و " : "");
                sb4.append(a(d % 1000.0d));
                return sb4.toString();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(a(d / 1000.0d));
            sb5.append(" ألف");
            sb5.append(((int) d) % 1000 != 0 ? " و " : "");
            sb5.append(a(d % 1000.0d));
            return sb5.toString();
        }
        if (d >= 1.0E9d) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(a(d / 1.0E9d));
            sb6.append(" مليار");
            sb6.append(((int) d) % 1000000000 != 0 ? " و " : "");
            sb6.append(a(d % 1.0E9d));
            return sb6.toString();
        }
        if (d >= 1000000.0d && d < 2000000.0d) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(" مليون");
            sb7.append(((int) d) % 1000000 != 0 ? " و " : "");
            sb7.append(a(d % 1000000.0d));
            return sb7.toString();
        }
        if (d >= 2000000.0d && d < 3000000.0d) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append(" مليونين");
            sb8.append(((int) d) % 1000000 != 0 ? " و " : "");
            sb8.append(a(d % 1000000.0d));
            return sb8.toString();
        }
        StringBuilder sb9 = new StringBuilder();
        sb9.append(a(d / 1000000.0d));
        sb9.append(" مليون");
        sb9.append(((int) d) % 1000000 != 0 ? " و " : "");
        sb9.append(a(d % 1000000.0d));
        return sb9.toString();
    }
}
