package androidx.compose.material3;

import defpackage.AbstractC0819Pf;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.material3.DragGestureDetectorCopyKt", f = "DragGestureDetectorCopy.kt", l = {144, ShapeTypes.CORNER_TABS}, m = "awaitHorizontalPointerSlopOrCancellation-gDDlDlE")
public final class DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 extends AbstractC0819Pf {
    float F$0;
    float F$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    public DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1(InterfaceC0793Of interfaceC0793Of) {
        super(interfaceC0793Of);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorCopyKt.m1540awaitHorizontalPointerSlopOrCancellationgDDlDlE(null, 0L, 0, null, this);
    }
}
