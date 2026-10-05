package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2133eg;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1009Wa;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.JL;
import defpackage.LL;
import defpackage.XS;
import java.util.concurrent.CancellationException;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1", f = "Transformable.kt", l = {124}, m = "invokeSuspend")
public final class TransformableKt$transformable$3$block$1$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ InterfaceC1009Wa $channel;
    final /* synthetic */ State<Boolean> $updatePanZoomLock;
    final /* synthetic */ State<InterfaceC3588op> $updatedCanPan;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1$1", f = "Transformable.kt", l = {125}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ PointerInputScope $$this$null;
        final /* synthetic */ InterfaceC1009Wa $channel;
        final /* synthetic */ State<Boolean> $updatePanZoomLock;
        final /* synthetic */ State<InterfaceC3588op> $updatedCanPan;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1$1$1", f = "Transformable.kt", l = {ShapeTypes.VERTICAL_SCROLL}, m = "invokeSuspend")
        public static final class C00431 extends JL implements InterfaceC0526Fp {
            final /* synthetic */ InterfaceC2052dg $$this$coroutineScope;
            final /* synthetic */ InterfaceC1009Wa $channel;
            final /* synthetic */ State<Boolean> $updatePanZoomLock;
            final /* synthetic */ State<InterfaceC3588op> $updatedCanPan;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00431(State<Boolean> state, InterfaceC1009Wa interfaceC1009Wa, State<? extends InterfaceC3588op> state2, InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$updatePanZoomLock = state;
                this.$channel = interfaceC1009Wa;
                this.$updatedCanPan = state2;
                this.$$this$coroutineScope = interfaceC2052dg;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                C00431 c00431 = new C00431(this.$updatePanZoomLock, this.$channel, this.$updatedCanPan, this.$$this$coroutineScope, interfaceC0793Of);
                c00431.L$0 = obj;
                return c00431;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
                return ((C00431) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                try {
                    try {
                        if (i == 0) {
                            LL.b(obj);
                            AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            State<Boolean> state = this.$updatePanZoomLock;
                            InterfaceC1009Wa interfaceC1009Wa = this.$channel;
                            State<InterfaceC3588op> state2 = this.$updatedCanPan;
                            this.label = 1;
                            if (TransformableKt.detectZoom(awaitPointerEventScope, state, interfaceC1009Wa, state2, this) == objD) {
                                return objD;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            LL.b(obj);
                        }
                    } catch (CancellationException e) {
                        if (!AbstractC2133eg.e(this.$$this$coroutineScope)) {
                            throw e;
                        }
                    }
                    this.$channel.mo0trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                    return FW.a;
                } catch (Throwable th) {
                    this.$channel.mo0trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                    throw th;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(PointerInputScope pointerInputScope, State<Boolean> state, InterfaceC1009Wa interfaceC1009Wa, State<? extends InterfaceC3588op> state2, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$$this$null = pointerInputScope;
            this.$updatePanZoomLock = state;
            this.$channel = interfaceC1009Wa;
            this.$updatedCanPan = state2;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$null, this.$updatePanZoomLock, this.$channel, this.$updatedCanPan, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                PointerInputScope pointerInputScope = this.$$this$null;
                C00431 c00431 = new C00431(this.$updatePanZoomLock, this.$channel, this.$updatedCanPan, interfaceC2052dg, null);
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(pointerInputScope, c00431, this) == objD) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TransformableKt$transformable$3$block$1$1(State<Boolean> state, InterfaceC1009Wa interfaceC1009Wa, State<? extends InterfaceC3588op> state2, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$updatePanZoomLock = state;
        this.$channel = interfaceC1009Wa;
        this.$updatedCanPan = state2;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        TransformableKt$transformable$3$block$1$1 transformableKt$transformable$3$block$1$1 = new TransformableKt$transformable$3$block$1$1(this.$updatePanZoomLock, this.$channel, this.$updatedCanPan, interfaceC0793Of);
        transformableKt$transformable$3$block$1$1.L$0 = obj;
        return transformableKt$transformable$3$block$1$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
        return ((TransformableKt$transformable$3$block$1$1) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((PointerInputScope) this.L$0, this.$updatePanZoomLock, this.$channel, this.$updatedCanPan, null);
            this.label = 1;
            if (AbstractC2133eg.d(anonymousClass1, this) == objD) {
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
