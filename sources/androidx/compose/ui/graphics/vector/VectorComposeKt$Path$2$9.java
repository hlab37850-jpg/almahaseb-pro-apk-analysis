package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.StrokeJoin;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorComposeKt$Path$2$9 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final VectorComposeKt$Path$2$9 INSTANCE = new VectorComposeKt$Path$2$9();

    public VectorComposeKt$Path$2$9() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        m3589invokekLtJ_vA((PathComponent) obj, ((StrokeJoin) obj2).m3365unboximpl());
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-kLtJ_vA, reason: not valid java name */
    public final void m3589invokekLtJ_vA(PathComponent pathComponent, int i) {
        AbstractC4492zt.h(pathComponent, "$this$set");
        pathComponent.m3583setStrokeLineJoinWw9F2mQ(i);
    }
}
