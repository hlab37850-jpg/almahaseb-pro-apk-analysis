package androidx.compose.material3;

import defpackage.AbstractC0819Pf;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.material3.SwipeableState$animateTo$2", f = "Swipeable.kt", l = {335}, m = "emit")
public final class SwipeableState$animateTo$2$emit$1 extends AbstractC0819Pf {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SwipeableState$animateTo$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableState$animateTo$2$emit$1(SwipeableState$animateTo$2 swipeableState$animateTo$2, InterfaceC0793Of interfaceC0793Of) {
        super(interfaceC0793Of);
        this.this$0 = swipeableState$animateTo$2;
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Map) null, (InterfaceC0793Of) this);
    }
}
