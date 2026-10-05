package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.style.TextGeometricTransform;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$TextGeometricTransformSaver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final SaversKt$TextGeometricTransformSaver$1 INSTANCE = new SaversKt$TextGeometricTransformSaver$1();

    public SaversKt$TextGeometricTransformSaver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(SaverScope saverScope, TextGeometricTransform textGeometricTransform) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(textGeometricTransform, "it");
        return AbstractC1886cc.g(Float.valueOf(textGeometricTransform.getScaleX()), Float.valueOf(textGeometricTransform.getSkewX()));
    }
}
