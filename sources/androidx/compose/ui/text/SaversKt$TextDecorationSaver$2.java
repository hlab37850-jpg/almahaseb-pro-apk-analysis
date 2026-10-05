package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextDecoration;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$TextDecorationSaver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SaversKt$TextDecorationSaver$2 INSTANCE = new SaversKt$TextDecorationSaver$2();

    public SaversKt$TextDecorationSaver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final TextDecoration invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        return new TextDecoration(((Integer) obj).intValue());
    }
}
