package androidx.compose.animation;

import androidx.compose.ui.graphics.Color;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ColorVectorConverterKt {
    private static final InterfaceC3750qp ColorToVector = ColorVectorConverterKt$ColorToVector$1.INSTANCE;

    public static final InterfaceC3750qp getVectorConverter(Color.Companion companion) {
        AbstractC4492zt.h(companion, "<this>");
        return ColorToVector;
    }
}
