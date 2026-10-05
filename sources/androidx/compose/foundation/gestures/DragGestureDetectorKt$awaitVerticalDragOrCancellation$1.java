package androidx.compose.foundation.gestures;

import defpackage.AbstractC0819Pf;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", l = {876}, m = "awaitVerticalDragOrCancellation-rnUCldI")
public final class DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 extends AbstractC0819Pf {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public DragGestureDetectorKt$awaitVerticalDragOrCancellation$1(InterfaceC0793Of interfaceC0793Of) {
        super(interfaceC0793Of);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m278awaitVerticalDragOrCancellationrnUCldI(null, 0L, this);
    }
}
