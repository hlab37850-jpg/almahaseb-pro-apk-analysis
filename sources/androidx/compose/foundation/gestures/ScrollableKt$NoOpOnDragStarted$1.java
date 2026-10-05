package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.foundation.gestures.ScrollableKt$NoOpOnDragStarted$1", f = "Scrollable.kt", l = {}, m = "invokeSuspend")
public final class ScrollableKt$NoOpOnDragStarted$1 extends XS implements InterfaceC0552Gp {
    int label;

    public ScrollableKt$NoOpOnDragStarted$1(InterfaceC0793Of interfaceC0793Of) {
        super(3, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m338invoked4ec7I((InterfaceC2052dg) obj, ((Offset) obj2).m2808unboximpl(), (InterfaceC0793Of) obj3);
    }

    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
    public final Object m338invoked4ec7I(InterfaceC2052dg interfaceC2052dg, long j, InterfaceC0793Of interfaceC0793Of) {
        return new ScrollableKt$NoOpOnDragStarted$1(interfaceC0793Of).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC0378Bt.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LL.b(obj);
        return FW.a;
    }
}
