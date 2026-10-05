package androidx.compose.ui.graphics.vector;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class VectorComposeKt$Group$2$9 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final VectorComposeKt$Group$2$9 INSTANCE = new VectorComposeKt$Group$2$9();

    public VectorComposeKt$Group$2$9() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((GroupComponent) obj, (List<? extends PathNode>) obj2);
        return FW.a;
    }

    public final void invoke(GroupComponent groupComponent, List<? extends PathNode> list) {
        AbstractC4492zt.h(groupComponent, "$this$set");
        AbstractC4492zt.h(list, "it");
        groupComponent.setClipPathData(list);
    }
}
