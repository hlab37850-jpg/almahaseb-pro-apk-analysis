package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.text.TextLayoutResult;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.O8;
import defpackage.OJ;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1", f = "ClickableText.kt", l = {ShapeTypes.GEAR_9}, m = "invokeSuspend")
public final class ClickableTextKt$ClickableText$pointerInputModifier$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ InterfaceC2052dg $coroutineScope;
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ InterfaceC3750qp $onClick;
    final /* synthetic */ InterfaceC3750qp $onHover;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$1", f = "ClickableText.kt", l = {ShapeTypes.ACTION_BUTTON_FORWARD_NEXT}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ PointerInputScope $$this$pointerInput;
        final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
        final /* synthetic */ InterfaceC3750qp $onHover;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00511 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
            final /* synthetic */ InterfaceC3750qp $onHover;
            final /* synthetic */ OJ $previousIndex;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00511(OJ oj, InterfaceC3750qp interfaceC3750qp, MutableState<TextLayoutResult> mutableState) {
                super(1);
                this.$previousIndex = oj;
                this.$onHover = interfaceC3750qp;
                this.$layoutResult = mutableState;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m752invokek4lQ0M(((Offset) obj).m2808unboximpl());
                return FW.a;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m752invokek4lQ0M(long j) {
                Integer numClickableText_03UYbkw$getOffset = ClickableTextKt.ClickableText_03UYbkw$getOffset(this.$layoutResult, j);
                if (AbstractC4492zt.d(this.$previousIndex.a, numClickableText_03UYbkw$getOffset)) {
                    return;
                }
                this.$previousIndex.a = numClickableText_03UYbkw$getOffset;
                this.$onHover.invoke(numClickableText_03UYbkw$getOffset);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PointerInputScope pointerInputScope, InterfaceC3750qp interfaceC3750qp, MutableState<TextLayoutResult> mutableState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$$this$pointerInput = pointerInputScope;
            this.$onHover = interfaceC3750qp;
            this.$layoutResult = mutableState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.$$this$pointerInput, this.$onHover, this.$layoutResult, interfaceC0793Of);
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
                OJ oj = new OJ();
                PointerInputScope pointerInputScope = this.$$this$pointerInput;
                PointerEventPass pointerEventPass = PointerEventPass.Main;
                C00511 c00511 = new C00511(oj, this.$onHover, this.$layoutResult);
                this.label = 1;
                if (PointerMoveDetectorKt.detectMoves(pointerInputScope, pointerEventPass, c00511, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.text.ClickableTextKt$ClickableText$pointerInputModifier$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
        final /* synthetic */ InterfaceC3750qp $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3750qp interfaceC3750qp, MutableState<TextLayoutResult> mutableState) {
            super(1);
            this.$onClick = interfaceC3750qp;
            this.$layoutResult = mutableState;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m753invokek4lQ0M(((Offset) obj).m2808unboximpl());
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m753invokek4lQ0M(long j) {
            Integer numClickableText_03UYbkw$getOffset = ClickableTextKt.ClickableText_03UYbkw$getOffset(this.$layoutResult, j);
            if (numClickableText_03UYbkw$getOffset != null) {
                this.$onClick.invoke(numClickableText_03UYbkw$getOffset);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableTextKt$ClickableText$pointerInputModifier$1(InterfaceC2052dg interfaceC2052dg, InterfaceC3750qp interfaceC3750qp, MutableState<TextLayoutResult> mutableState, InterfaceC3750qp interfaceC3750qp2, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$coroutineScope = interfaceC2052dg;
        this.$onHover = interfaceC3750qp;
        this.$layoutResult = mutableState;
        this.$onClick = interfaceC3750qp2;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        ClickableTextKt$ClickableText$pointerInputModifier$1 clickableTextKt$ClickableText$pointerInputModifier$1 = new ClickableTextKt$ClickableText$pointerInputModifier$1(this.$coroutineScope, this.$onHover, this.$layoutResult, this.$onClick, interfaceC0793Of);
        clickableTextKt$ClickableText$pointerInputModifier$1.L$0 = obj;
        return clickableTextKt$ClickableText$pointerInputModifier$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
        return ((ClickableTextKt$ClickableText$pointerInputModifier$1) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            O8.d(this.$coroutineScope, null, null, new AnonymousClass1(pointerInputScope, this.$onHover, this.$layoutResult, null), 3, null);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$onClick, this.$layoutResult);
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, anonymousClass2, this, 7, null) == objD) {
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
