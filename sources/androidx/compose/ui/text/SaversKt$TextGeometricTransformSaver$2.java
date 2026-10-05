package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextGeometricTransform;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$TextGeometricTransformSaver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SaversKt$TextGeometricTransformSaver$2 INSTANCE = new SaversKt$TextGeometricTransformSaver$2();

    public SaversKt$TextGeometricTransformSaver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final TextGeometricTransform invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        List list = (List) obj;
        return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
    }
}
