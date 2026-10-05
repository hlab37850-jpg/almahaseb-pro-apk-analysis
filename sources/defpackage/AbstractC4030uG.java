package defpackage;

import com.itextpdf.text.pdf.BaseFont;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: uG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4030uG {
    public static float[] a(List list, float f, BaseFont baseFont) {
        String str;
        if (list == null || list.isEmpty()) {
            float[] fArr = new float[1];
            Arrays.fill(fArr, 1.0f);
            return fArr;
        }
        int length = ((String[]) list.get(0)).length;
        float[] fArr2 = new float[length];
        Arrays.fill(fArr2, 1.0f);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String[] strArr = (String[]) it.next();
            for (int i = 0; i < length; i++) {
                if (strArr == null || i >= strArr.length || (str = strArr[i]) == null) {
                    str = "";
                }
                float widthPoint = baseFont.getWidthPoint(str, f) + 0.0f;
                if (widthPoint > fArr2[i]) {
                    fArr2[i] = widthPoint;
                }
            }
        }
        int i2 = 0;
        while (i2 < length) {
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    fArr2[i2] = Math.min(fArr2[i2], 60.0f);
                    break;
                }
                String strTrim = (list.get(i3) == null || i2 >= ((String[]) list.get(i3)).length || ((String[]) list.get(i3))[i2] == null) ? "" : ((String[]) list.get(i3))[i2].trim();
                if (!strTrim.isEmpty() && !strTrim.matches("[,]?\\d+(\\.\\d+)?")) {
                    break;
                }
                i3++;
            }
            i2++;
        }
        for (int i4 = 0; i4 < length; i4++) {
            fArr2[i4] = Math.max(35.0f, Math.min(80.0f, fArr2[i4]));
        }
        int i5 = 0;
        while (i5 < length) {
            for (int i6 = 0; i6 < list.size(); i6++) {
                String strTrim2 = (list.get(i6) == null || i5 >= ((String[]) list.get(i6)).length || ((String[]) list.get(i6))[i5] == null) ? "" : ((String[]) list.get(i6))[i5].trim();
                if (!strTrim2.isEmpty() && strTrim2.matches("\\d+-\\d+-\\d+")) {
                    fArr2[i5] = Math.min(fArr2[i5], 50.0f);
                    break;
                }
            }
            i5++;
        }
        return fArr2;
    }
}
