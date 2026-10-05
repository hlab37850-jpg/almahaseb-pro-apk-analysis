package androidx.compose.material3;

import defpackage.AbstractC0819Pf;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1", f = "Swipeable.kt", l = {869}, m = "onPreFling-QWom1Mo")
public final class SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 extends AbstractC0819Pf {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SwipeableKt$PreUpPostDownNestedScrollConnection$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1(SwipeableKt$PreUpPostDownNestedScrollConnection$1 swipeableKt$PreUpPostDownNestedScrollConnection$1, InterfaceC0793Of interfaceC0793Of) {
        super(interfaceC0793Of);
        this.this$0 = swipeableKt$PreUpPostDownNestedScrollConnection$1;
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo342onPreFlingQWom1Mo(0L, this);
    }
}
