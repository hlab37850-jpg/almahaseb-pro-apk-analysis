package androidx.compose.material3;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.JL;
import defpackage.LL;
import defpackage.XS;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1", f = "Tooltip.kt", l = {212}, m = "invokeSuspend")
public final class TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ InterfaceC3588op $onLongPress;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1$1", f = "Tooltip.kt", l = {217, 221, 229}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends JL implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC3588op $onLongPress;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1$1$1", f = "Tooltip.kt", l = {222}, m = "invokeSuspend")
        public static final class C01321 extends JL implements InterfaceC0526Fp {
            final /* synthetic */ PointerEventPass $pass;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01321(PointerEventPass pointerEventPass, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$pass = pointerEventPass;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                C01321 c01321 = new C01321(this.$pass, interfaceC0793Of);
                c01321.L$0 = obj;
                return c01321;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
                return ((C01321) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    PointerEventPass pointerEventPass = this.$pass;
                    this.label = 1;
                    obj = TapGestureDetectorKt.waitForUpOrCancellation(awaitPointerEventScope, pointerEventPass, this);
                    if (obj == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                return obj;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$onLongPress = interfaceC3588op;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onLongPress, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0089 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:29:0x009c A[LOOP:0: B:27:0x0096->B:29:0x009c, LOOP_END] */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AwaitPointerEventScope awaitPointerEventScope;
            PointerEventPass pointerEventPass;
            long j;
            AwaitPointerEventScope awaitPointerEventScope2;
            Iterator<T> it;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i == 1) {
                        j = this.J$0;
                        pointerEventPass = (PointerEventPass) this.L$1;
                        AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                        LL.b(obj);
                        awaitPointerEventScope = awaitPointerEventScope3;
                    } else if (i == 2) {
                        pointerEventPass = (PointerEventPass) this.L$1;
                        awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        try {
                            LL.b(obj);
                        } catch (PointerEventTimeoutCancellationException unused) {
                            this.$onLongPress.invoke();
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 3;
                            obj = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, this);
                            if (obj == objD) {
                                return objD;
                            }
                            it = ((PointerEvent) obj).getChanges().iterator();
                            while (it.hasNext()) {
                                ((PointerInputChange) it.next()).consume();
                            }
                        }
                    } else {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj);
                        it = ((PointerEvent) obj).getChanges().iterator();
                        while (it.hasNext()) {
                            ((PointerInputChange) it.next()).consume();
                        }
                    }
                    return FW.a;
                }
                LL.b(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                pointerEventPass = PointerEventPass.Initial;
                this.L$0 = awaitPointerEventScope;
                this.L$1 = pointerEventPass;
                this.J$0 = longPressTimeoutMillis;
                this.label = 1;
                if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, pointerEventPass, this, 1, null) == objD) {
                    return objD;
                }
                j = longPressTimeoutMillis;
                C01321 c01321 = new C01321(pointerEventPass, null);
                this.L$0 = awaitPointerEventScope;
                this.L$1 = pointerEventPass;
                this.label = 2;
                if (awaitPointerEventScope.withTimeout(j, c01321, this) == objD) {
                    return objD;
                }
            } catch (PointerEventTimeoutCancellationException unused2) {
                awaitPointerEventScope2 = awaitPointerEventScope;
                this.$onLongPress.invoke();
                this.L$0 = null;
                this.L$1 = null;
                this.label = 3;
                obj = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, this);
                if (obj == objD) {
                    return objD;
                }
                it = ((PointerEvent) obj).getChanges().iterator();
                while (it.hasNext()) {
                    ((PointerInputChange) it.next()).consume();
                }
            }
            return FW.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1(InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$onLongPress = interfaceC3588op;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1 tooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1 = new TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1(this.$onLongPress, interfaceC0793Of);
        tooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1.L$0 = obj;
        return tooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
        return ((TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onLongPress, null);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(pointerInputScope, anonymousClass1, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
        }
        return FW.a;
    }
}
