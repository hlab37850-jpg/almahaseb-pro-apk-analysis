package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.JL;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1", f = "Scrollable.kt", l = {TIFFConstants.TIFFTAG_DOTRANGE}, m = "invokeSuspend")
public final class MouseWheelScrollNode$pointerInputNode$1 extends XS implements InterfaceC0526Fp {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MouseWheelScrollNode this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1$1", f = "Scrollable.kt", l = {TIFFConstants.TIFFTAG_EXTRASAMPLES}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends JL implements InterfaceC0526Fp {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MouseWheelScrollNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MouseWheelScrollNode mouseWheelScrollNode, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = mouseWheelScrollNode;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x003c  */
        /* JADX WARN: Code duplicated, block: B:17:0x0049 A[LOOP:0: B:13:0x003a->B:17:0x0049, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:21:0x007c  */
        /* JADX WARN: Code duplicated, block: B:23:0x0086 A[LOOP:1: B:22:0x0084->B:23:0x0086, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:24:0x004c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:25:0x0023 A[EDGE_INSN: B:25:0x0023->B:9:0x0023 BREAK  A[LOOP:0: B:13:0x003a->B:17:0x0049], SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:12:0x002e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:17:0x0049
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // defpackage.AbstractC2171f7
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = defpackage.AbstractC0378Bt.d()
                int r1 = r8.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r8.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                defpackage.LL.b(r9)
                goto L2e
            L13:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1b:
                defpackage.LL.b(r9)
                java.lang.Object r9 = r8.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
                r1 = r9
            L23:
                r8.L$0 = r1
                r8.label = r2
                java.lang.Object r9 = androidx.compose.foundation.gestures.ScrollableKt.access$awaitScrollEvent(r1, r8)
                if (r9 != r0) goto L2e
                return r0
            L2e:
                androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
                java.util.List r3 = r9.getChanges()
                int r4 = r3.size()
                r5 = 0
                r6 = 0
            L3a:
                if (r6 >= r4) goto L4c
                java.lang.Object r7 = r3.get(r6)
                androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                boolean r7 = r7.isConsumed()
                if (r7 == 0) goto L49
                goto L23
            L49:
                int r6 = r6 + 1
                goto L3a
            L4c:
                androidx.compose.foundation.gestures.MouseWheelScrollNode r3 = r8.this$0
                androidx.compose.foundation.gestures.ScrollConfig r3 = r3.getMouseWheelScrollConfig()
                androidx.compose.foundation.gestures.MouseWheelScrollNode r4 = r8.this$0
                long r6 = r1.mo3967getSizeYbymL2g()
                long r6 = r3.mo254calculateMouseWheelScroll8xgXZGE(r1, r9, r6)
                androidx.compose.runtime.State r3 = r4.getScrollingLogicState()
                java.lang.Object r3 = r3.getValue()
                androidx.compose.foundation.gestures.ScrollingLogic r3 = (androidx.compose.foundation.gestures.ScrollingLogic) r3
                float r4 = r3.m352toFloatk4lQ0M(r6)
                float r4 = r3.reverseIfNeeded(r4)
                androidx.compose.foundation.gestures.ScrollableState r3 = r3.getScrollableState()
                float r3 = r3.dispatchRawDelta(r4)
                r4 = 0
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 != 0) goto L7c
                goto L23
            L7c:
                java.util.List r9 = r9.getChanges()
                int r3 = r9.size()
            L84:
                if (r5 >= r3) goto L23
                java.lang.Object r4 = r9.get(r5)
                androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                r4.consume()
                int r5 = r5 + 1
                goto L84
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MouseWheelScrollNode$pointerInputNode$1(MouseWheelScrollNode mouseWheelScrollNode, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.this$0 = mouseWheelScrollNode;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        MouseWheelScrollNode$pointerInputNode$1 mouseWheelScrollNode$pointerInputNode$1 = new MouseWheelScrollNode$pointerInputNode$1(this.this$0, interfaceC0793Of);
        mouseWheelScrollNode$pointerInputNode$1.L$0 = obj;
        return mouseWheelScrollNode$pointerInputNode$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
        return ((MouseWheelScrollNode$pointerInputNode$1) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (pointerInputScope.awaitPointerEventScope(anonymousClass1, this) == objD) {
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
