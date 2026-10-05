package androidx.compose.material;

import defpackage.AbstractC0819Pf;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.material.SliderKt", f = "Slider.kt", l = {812}, m = "awaitSlop-8vUncbI")
public final class SliderKt$awaitSlop$1 extends AbstractC0819Pf {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public SliderKt$awaitSlop$1(InterfaceC0793Of interfaceC0793Of) {
        super(interfaceC0793Of);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SliderKt.m1202awaitSlop8vUncbI(null, 0L, 0, this);
    }
}
