package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.PathFillType;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorComposeKt$Path$2$3 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final VectorComposeKt$Path$2$3 INSTANCE = new VectorComposeKt$Path$2$3();

    public VectorComposeKt$Path$2$3() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        m3588invokepweu1eQ((PathComponent) obj, ((PathFillType) obj2).m3285unboximpl());
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-pweu1eQ, reason: not valid java name */
    public final void m3588invokepweu1eQ(PathComponent pathComponent, int i) {
        AbstractC4492zt.h(pathComponent, "$this$set");
        pathComponent.m3581setPathFillTypeoQ8Xj4U(i);
    }
}
