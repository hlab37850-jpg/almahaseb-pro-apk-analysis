package androidx.compose.ui.graphics.vector;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorComposeKt$Group$2$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final VectorComposeKt$Group$2$1 INSTANCE = new VectorComposeKt$Group$2$1();

    public VectorComposeKt$Group$2$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((GroupComponent) obj, (String) obj2);
        return FW.a;
    }

    public final void invoke(GroupComponent groupComponent, String str) {
        AbstractC4492zt.h(groupComponent, "$this$set");
        AbstractC4492zt.h(str, "it");
        groupComponent.setName(str);
    }
}
