package androidx.compose.ui.graphics.vector;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorComposeKt$Group$2$5 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final VectorComposeKt$Group$2$5 INSTANCE = new VectorComposeKt$Group$2$5();

    public VectorComposeKt$Group$2$5() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((GroupComponent) obj, ((Number) obj2).floatValue());
        return FW.a;
    }

    public final void invoke(GroupComponent groupComponent, float f) {
        AbstractC4492zt.h(groupComponent, "$this$set");
        groupComponent.setScaleX(f);
    }
}
