package androidx.compose.ui.graphics.vector;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorComposeKt$Path$2$12 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final VectorComposeKt$Path$2$12 INSTANCE = new VectorComposeKt$Path$2$12();

    public VectorComposeKt$Path$2$12() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((PathComponent) obj, ((Number) obj2).floatValue());
        return FW.a;
    }

    public final void invoke(PathComponent pathComponent, float f) {
        AbstractC4492zt.h(pathComponent, "$this$set");
        pathComponent.setTrimPathStart(f);
    }
}
