package androidx.compose.ui.platform;

import android.content.res.Configuration;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeView_androidKt {
    /* JADX INFO: renamed from: dot-p89u6pk, reason: not valid java name */
    private static final float m4467dotp89u6pk(float[] fArr, int i, float[] fArr2, int i2) {
        int i3 = i * 4;
        return (fArr[i3] * fArr2[i2]) + (fArr[i3 + 1] * fArr2[4 + i2]) + (fArr[i3 + 2] * fArr2[8 + i2]) + (fArr[i3 + 3] * fArr2[12 + i2]);
    }

    public static final LayoutDirection getLocaleLayoutDirection(Configuration configuration) {
        AbstractC4492zt.h(configuration, "<this>");
        return layoutDirectionFromInt(configuration.getLayoutDirection());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutDirection layoutDirectionFromInt(int i) {
        if (i != 0) {
            return i != 1 ? LayoutDirection.Ltr : LayoutDirection.Rtl;
        }
        return LayoutDirection.Ltr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: preTransform-JiSxe2E, reason: not valid java name */
    public static final void m4468preTransformJiSxe2E(float[] fArr, float[] fArr2) {
        float fM4467dotp89u6pk = m4467dotp89u6pk(fArr2, 0, fArr, 0);
        float fM4467dotp89u6pk2 = m4467dotp89u6pk(fArr2, 0, fArr, 1);
        float fM4467dotp89u6pk3 = m4467dotp89u6pk(fArr2, 0, fArr, 2);
        float fM4467dotp89u6pk4 = m4467dotp89u6pk(fArr2, 0, fArr, 3);
        float fM4467dotp89u6pk5 = m4467dotp89u6pk(fArr2, 1, fArr, 0);
        float fM4467dotp89u6pk6 = m4467dotp89u6pk(fArr2, 1, fArr, 1);
        float fM4467dotp89u6pk7 = m4467dotp89u6pk(fArr2, 1, fArr, 2);
        float fM4467dotp89u6pk8 = m4467dotp89u6pk(fArr2, 1, fArr, 3);
        float fM4467dotp89u6pk9 = m4467dotp89u6pk(fArr2, 2, fArr, 0);
        float fM4467dotp89u6pk10 = m4467dotp89u6pk(fArr2, 2, fArr, 1);
        float fM4467dotp89u6pk11 = m4467dotp89u6pk(fArr2, 2, fArr, 2);
        float fM4467dotp89u6pk12 = m4467dotp89u6pk(fArr2, 2, fArr, 3);
        float fM4467dotp89u6pk13 = m4467dotp89u6pk(fArr2, 3, fArr, 0);
        float fM4467dotp89u6pk14 = m4467dotp89u6pk(fArr2, 3, fArr, 1);
        float fM4467dotp89u6pk15 = m4467dotp89u6pk(fArr2, 3, fArr, 2);
        float fM4467dotp89u6pk16 = m4467dotp89u6pk(fArr2, 3, fArr, 3);
        fArr[0] = fM4467dotp89u6pk;
        fArr[1] = fM4467dotp89u6pk2;
        fArr[2] = fM4467dotp89u6pk3;
        fArr[3] = fM4467dotp89u6pk4;
        fArr[4] = fM4467dotp89u6pk5;
        fArr[5] = fM4467dotp89u6pk6;
        fArr[6] = fM4467dotp89u6pk7;
        fArr[7] = fM4467dotp89u6pk8;
        fArr[8] = fM4467dotp89u6pk9;
        fArr[9] = fM4467dotp89u6pk10;
        fArr[10] = fM4467dotp89u6pk11;
        fArr[11] = fM4467dotp89u6pk12;
        fArr[12] = fM4467dotp89u6pk13;
        fArr[13] = fM4467dotp89u6pk14;
        fArr[14] = fM4467dotp89u6pk15;
        fArr[15] = fM4467dotp89u6pk16;
    }
}
