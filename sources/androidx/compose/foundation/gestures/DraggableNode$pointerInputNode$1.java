package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2133eg;
import defpackage.EnumC2379hg;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1009Wa;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.JL;
import defpackage.LL;
import defpackage.O8;
import defpackage.OJ;
import defpackage.XS;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1", f = "Draggable.kt", l = {302}, m = "invokeSuspend")
public final class DraggableNode$pointerInputNode$1 extends XS implements InterfaceC0526Fp {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DraggableNode this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1", f = "Draggable.kt", l = {TIFFConstants.TIFFTAG_BADFAXLINES}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DraggableNode this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1", f = "Draggable.kt", l = {305, 307, 309, 316, 318, TIFFConstants.TIFFTAG_HALFTONEHINTS}, m = "invokeSuspend")
        public static final class C00341 extends XS implements InterfaceC0526Fp {
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ DraggableNode this$0;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1$1, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1$1", f = "Draggable.kt", l = {312}, m = "invokeSuspend")
            public static final class C00351 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ OJ $event;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;
                final /* synthetic */ DraggableNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00351(OJ oj, DraggableNode draggableNode, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$event = oj;
                    this.this$0 = draggableNode;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    C00351 c00351 = new C00351(this.$event, this.this$0, interfaceC0793Of);
                    c00351.L$0 = obj;
                    return c00351;
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(DragScope dragScope, InterfaceC0793Of interfaceC0793Of) {
                    return ((C00351) create(dragScope, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0060 -> B:22:0x0063). Please report as a decompilation issue!!! */
                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    DragScope dragScope;
                    Object obj2;
                    OJ oj;
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i == 0) {
                        LL.b(obj);
                        dragScope = (DragScope) this.L$0;
                        obj2 = this.$event.a;
                        if (!(obj2 instanceof DragEvent.DragStopped) || (obj2 instanceof DragEvent.DragCancelled)) {
                            return FW.a;
                        }
                        DragEvent.DragDelta dragDelta = obj2 instanceof DragEvent.DragDelta ? (DragEvent.DragDelta) obj2 : null;
                        if (dragDelta != null) {
                            dragScope.dragBy(DraggableKt.m309toFloat3MmeM6k(dragDelta.m264getDeltaF1C5BW0(), this.this$0.orientation));
                        }
                        oj = this.$event;
                        InterfaceC1009Wa interfaceC1009Wa = this.this$0.channel;
                        this.L$0 = dragScope;
                        this.L$1 = oj;
                        this.label = 1;
                        obj = interfaceC1009Wa.f(this);
                        if (obj == objD) {
                            return objD;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        oj = (OJ) this.L$1;
                        dragScope = (DragScope) this.L$0;
                        LL.b(obj);
                    }
                    oj.a = obj;
                    obj2 = this.$event.a;
                    if (obj2 instanceof DragEvent.DragStopped) {
                    }
                    return FW.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00341(DraggableNode draggableNode, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.this$0 = draggableNode;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                C00341 c00341 = new C00341(this.this$0, interfaceC0793Of);
                c00341.L$0 = obj;
                return c00341;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((C00341) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            /* JADX WARN: Code duplicated, block: B:22:0x0067  */
            /* JADX WARN: Code duplicated, block: B:24:0x0081 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:25:0x0082  */
            /* JADX WARN: Code duplicated, block: B:28:0x008d  */
            /* JADX WARN: Code duplicated, block: B:30:0x00a0 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:31:0x00a1  */
            /* JADX WARN: Code duplicated, block: B:34:0x00bf A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:37:0x00c6 A[Catch: CancellationException -> 0x00dd, TryCatch #1 {CancellationException -> 0x00dd, blocks: (B:35:0x00c0, B:37:0x00c6, B:41:0x00e0, B:43:0x00e4), top: B:54:0x00c0 }] */
            /* JADX WARN: Code duplicated, block: B:39:0x00dc A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:41:0x00e0 A[Catch: CancellationException -> 0x00dd, TryCatch #1 {CancellationException -> 0x00dd, blocks: (B:35:0x00c0, B:37:0x00c6, B:41:0x00e0, B:43:0x00e4), top: B:54:0x00c0 }] */
            /* JADX WARN: Code duplicated, block: B:43:0x00e4 A[Catch: CancellationException -> 0x00dd, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x00dd, blocks: (B:35:0x00c0, B:37:0x00c6, B:41:0x00e0, B:43:0x00e4), top: B:54:0x00c0 }] */
            /* JADX WARN: Code duplicated, block: B:45:0x00f3 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:49:0x0104  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00da -> B:20:0x0061). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00e2 -> B:20:0x0061). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00f1 -> B:20:0x0061). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0101 -> B:12:0x002a). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0104 -> B:20:0x0061). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // defpackage.AbstractC2171f7
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    Method dump skipped, instruction units count: 284
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.C00341.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2", f = "Draggable.kt", l = {TIFFConstants.TIFFTAG_CONSECUTIVEBADFAXLINES, TIFFConstants.TIFFTAG_DOTRANGE}, m = "invokeSuspend")
        public static final class AnonymousClass2 extends JL implements InterfaceC0526Fp {
            final /* synthetic */ InterfaceC2052dg $$this$coroutineScope;
            int I$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ DraggableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(InterfaceC2052dg interfaceC2052dg, DraggableNode draggableNode, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$$this$coroutineScope = interfaceC2052dg;
                this.this$0 = draggableNode;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$$this$coroutineScope, this.this$0, interfaceC0793Of);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
                return ((AnonymousClass2) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            /* JADX WARN: Code duplicated, block: B:20:0x005c  */
            /* JADX WARN: Code duplicated, block: B:22:0x0085 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:25:0x008a  */
            /* JADX WARN: Code duplicated, block: B:30:0x00d2 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:31:0x00d3  */
            /* JADX WARN: Code duplicated, block: B:34:0x00e2  */
            /* JADX WARN: Code duplicated, block: B:36:0x00f9  */
            /* JADX WARN: Code duplicated, block: B:37:0x00fc  */
            /* JADX WARN: Code duplicated, block: B:39:0x0106  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00d3 -> B:74:0x00da). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0138 -> B:41:0x010f). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0176 -> B:18:0x0054). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // defpackage.AbstractC2171f7
            public final java.lang.Object invokeSuspend(java.lang.Object r22) {
                /*
                    Method dump skipped, instruction units count: 383
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PointerInputScope pointerInputScope, DraggableNode draggableNode, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
            this.this$0 = draggableNode;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$SuspendingPointerInputModifierNode, this.this$0, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0056  */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC2052dg interfaceC2052dg;
            CancellationException e;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg2 = (InterfaceC2052dg) this.L$0;
                O8.d(interfaceC2052dg2, null, EnumC2379hg.UNDISPATCHED, new C00341(this.this$0, null), 1, null);
                try {
                    PointerInputScope pointerInputScope = this.$$this$SuspendingPointerInputModifierNode;
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC2052dg2, this.this$0, null);
                    this.L$0 = interfaceC2052dg2;
                    this.label = 1;
                    if (pointerInputScope.awaitPointerEventScope(anonymousClass2, this) == objD) {
                        return objD;
                    }
                } catch (CancellationException e2) {
                    interfaceC2052dg = interfaceC2052dg2;
                    e = e2;
                    if (!AbstractC2133eg.e(interfaceC2052dg)) {
                        throw e;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                try {
                    LL.b(obj);
                } catch (CancellationException e3) {
                    e = e3;
                    if (!AbstractC2133eg.e(interfaceC2052dg)) {
                        throw e;
                    }
                }
            }
            return FW.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableNode$pointerInputNode$1(DraggableNode draggableNode, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.this$0 = draggableNode;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        DraggableNode$pointerInputNode$1 draggableNode$pointerInputNode$1 = new DraggableNode$pointerInputNode$1(this.this$0, interfaceC0793Of);
        draggableNode$pointerInputNode$1.L$0 = obj;
        return draggableNode$pointerInputNode$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
        return ((DraggableNode$pointerInputNode$1) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            if (!this.this$0.enabled) {
                return FW.a;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(pointerInputScope, this.this$0, null);
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
