package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.StrokeCap;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorComposeKt$Path$2$10 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final VectorComposeKt$Path$2$10 INSTANCE = new VectorComposeKt$Path$2$10();

    public VectorComposeKt$Path$2$10() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        m3587invokeCSYIeUk((PathComponent) obj, ((StrokeCap) obj2).m3355unboximpl());
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-CSYIeUk, reason: not valid java name */
    public final void m3587invokeCSYIeUk(PathComponent pathComponent, int i) {
        AbstractC4492zt.h(pathComponent, "$this$set");
        pathComponent.m3582setStrokeLineCapBeK7IIE(i);
    }
}
