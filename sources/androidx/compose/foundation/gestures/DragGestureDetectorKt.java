package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.J6;
import defpackage.JL;
import defpackage.LJ;
import defpackage.LL;
import defpackage.NJ;
import defpackage.OJ;
import java.util.List;
import java.util.concurrent.CancellationException;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
public final class DragGestureDetectorKt {
    private static final PointerDirectionConfig HorizontalPointerDirectionConfig = new PointerDirectionConfig() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$HorizontalPointerDirectionConfig$1
        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* JADX INFO: renamed from: crossAxisDelta-k-4lQ0M, reason: not valid java name */
        public float mo288crossAxisDeltak4lQ0M(long j) {
            return Offset.m2799getYimpl(j);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* JADX INFO: renamed from: mainAxisDelta-k-4lQ0M, reason: not valid java name */
        public float mo289mainAxisDeltak4lQ0M(long j) {
            return Offset.m2798getXimpl(j);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* JADX INFO: renamed from: offsetFromChanges-dBAh8RU, reason: not valid java name */
        public long mo290offsetFromChangesdBAh8RU(float f, float f2) {
            return OffsetKt.Offset(f, f2);
        }
    };
    private static final PointerDirectionConfig VerticalPointerDirectionConfig = new PointerDirectionConfig() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$VerticalPointerDirectionConfig$1
        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* JADX INFO: renamed from: crossAxisDelta-k-4lQ0M */
        public float mo288crossAxisDeltak4lQ0M(long j) {
            return Offset.m2798getXimpl(j);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* JADX INFO: renamed from: mainAxisDelta-k-4lQ0M */
        public float mo289mainAxisDeltak4lQ0M(long j) {
            return Offset.m2799getYimpl(j);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* JADX INFO: renamed from: offsetFromChanges-dBAh8RU */
        public long mo290offsetFromChangesdBAh8RU(float f, float f2) {
            return OffsetKt.Offset(f2, f);
        }
    };
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m291invokek4lQ0M(((Offset) obj).m2808unboximpl());
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m291invokek4lQ0M(long j) {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3588op {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m292invoke() {
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m292invoke();
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC3588op {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m293invoke() {
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m293invoke();
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5", f = "DragGestureDetector.kt", l = {ShapeTypes.MATH_PLUS, 890, 940, 193}, m = "invokeSuspend")
    public static final class AnonymousClass5 extends JL implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0526Fp $onDrag;
        final /* synthetic */ InterfaceC3588op $onDragCancel;
        final /* synthetic */ InterfaceC3588op $onDragEnd;
        final /* synthetic */ InterfaceC3750qp $onDragStart;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$2, reason: invalid class name */
        public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ InterfaceC0526Fp $onDrag;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(InterfaceC0526Fp interfaceC0526Fp) {
                super(1);
                this.$onDrag = interfaceC0526Fp;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PointerInputChange) obj);
                return FW.a;
            }

            public final void invoke(PointerInputChange pointerInputChange) {
                AbstractC4492zt.h(pointerInputChange, "it");
                this.$onDrag.mo13invoke(pointerInputChange, Offset.m2787boximpl(PointerEventKt.positionChange(pointerInputChange)));
                pointerInputChange.consume();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$onDragStart = interfaceC3750qp;
            this.$onDrag = interfaceC0526Fp;
            this.$onDragCancel = interfaceC3588op;
            this.$onDragEnd = interfaceC3588op2;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, interfaceC0793Of);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass5) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x011e  */
        /* JADX WARN: Code duplicated, block: B:30:0x013b A[LOOP:0: B:26:0x011c->B:30:0x013b, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:92:0x014e A[EDGE_INSN: B:92:0x014e->B:32:0x014e BREAK  A[LOOP:0: B:26:0x011c->B:30:0x013b], SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00d8 -> B:75:0x0241). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0154 -> B:35:0x0157). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0195 -> B:22:0x00f2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01f1 -> B:63:0x01f5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x023e -> B:75:0x0241). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // defpackage.AbstractC2171f7
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instruction units count: 687
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.AnonymousClass5.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13082 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C13082 INSTANCE = new C13082();

        public C13082() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m294invokek4lQ0M(((Offset) obj).m2808unboximpl());
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m294invokek4lQ0M(long j) {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$3, reason: invalid class name and case insensitive filesystem */
    public static final class C13093 extends AbstractC2233fv implements InterfaceC3588op {
        public static final C13093 INSTANCE = new C13093();

        public C13093() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m295invoke() {
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m295invoke();
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$4, reason: invalid class name and case insensitive filesystem */
    public static final class C13104 extends AbstractC2233fv implements InterfaceC3588op {
        public static final C13104 INSTANCE = new C13104();

        public C13104() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m296invoke() {
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m296invoke();
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", l = {235, 236, 241}, m = "invokeSuspend")
    public static final class C13115 extends JL implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0526Fp $onDrag;
        final /* synthetic */ InterfaceC3588op $onDragCancel;
        final /* synthetic */ InterfaceC3588op $onDragEnd;
        final /* synthetic */ InterfaceC3750qp $onDragStart;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ InterfaceC0526Fp $onDrag;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp) {
                super(1);
                this.$onDrag = interfaceC0526Fp;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PointerInputChange) obj);
                return FW.a;
            }

            public final void invoke(PointerInputChange pointerInputChange) {
                AbstractC4492zt.h(pointerInputChange, "it");
                this.$onDrag.mo13invoke(pointerInputChange, Offset.m2787boximpl(PointerEventKt.positionChange(pointerInputChange)));
                pointerInputChange.consume();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13115(InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$onDragStart = interfaceC3750qp;
            this.$onDragEnd = interfaceC3588op;
            this.$onDragCancel = interfaceC3588op2;
            this.$onDrag = interfaceC0526Fp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C13115 c13115 = new C13115(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, interfaceC0793Of);
            c13115.L$0 = obj;
            return c13115;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C13115) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0062 A[Catch: CancellationException -> 0x0019, TryCatch #0 {CancellationException -> 0x0019, blocks: (B:8:0x0015, B:33:0x0086, B:35:0x008e, B:37:0x009d, B:39:0x00a9, B:40:0x00ac, B:41:0x00af, B:42:0x00b5, B:15:0x0028, B:27:0x005e, B:29:0x0062, B:18:0x0030, B:24:0x004d, B:21:0x003c), top: B:47:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x0084 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:32:0x0085  */
        /* JADX WARN: Code duplicated, block: B:35:0x008e A[Catch: CancellationException -> 0x0019, TryCatch #0 {CancellationException -> 0x0019, blocks: (B:8:0x0015, B:33:0x0086, B:35:0x008e, B:37:0x009d, B:39:0x00a9, B:40:0x00ac, B:41:0x00af, B:42:0x00b5, B:15:0x0028, B:27:0x005e, B:29:0x0062, B:18:0x0030, B:24:0x004d, B:21:0x003c), top: B:47:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:37:0x009d A[Catch: CancellationException -> 0x0019, TryCatch #0 {CancellationException -> 0x0019, blocks: (B:8:0x0015, B:33:0x0086, B:35:0x008e, B:37:0x009d, B:39:0x00a9, B:40:0x00ac, B:41:0x00af, B:42:0x00b5, B:15:0x0028, B:27:0x005e, B:29:0x0062, B:18:0x0030, B:24:0x004d, B:21:0x003c), top: B:47:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:39:0x00a9 A[Catch: CancellationException -> 0x0019, TryCatch #0 {CancellationException -> 0x0019, blocks: (B:8:0x0015, B:33:0x0086, B:35:0x008e, B:37:0x009d, B:39:0x00a9, B:40:0x00ac, B:41:0x00af, B:42:0x00b5, B:15:0x0028, B:27:0x005e, B:29:0x0062, B:18:0x0030, B:24:0x004d, B:21:0x003c), top: B:47:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x00b5 A[Catch: CancellationException -> 0x0019, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0019, blocks: (B:8:0x0015, B:33:0x0086, B:35:0x008e, B:37:0x009d, B:39:0x00a9, B:40:0x00ac, B:41:0x00af, B:42:0x00b5, B:15:0x0028, B:27:0x005e, B:29:0x0062, B:18:0x0030, B:24:0x004d, B:21:0x003c), top: B:47:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:50:0x00ac A[SYNTHETIC] */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AwaitPointerEventScope awaitPointerEventScope;
            PointerInputChange pointerInputChange;
            AwaitPointerEventScope awaitPointerEventScope2;
            List<PointerInputChange> changes;
            int size;
            int i;
            PointerInputChange pointerInputChange2;
            Object objD = AbstractC0378Bt.d();
            int i2 = this.label;
            try {
                if (i2 != 0) {
                    if (i2 == 1) {
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        LL.b(obj);
                    } else {
                        if (i2 == 2) {
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            LL.b(obj);
                            pointerInputChange = (PointerInputChange) obj;
                            if (pointerInputChange != null) {
                                this.$onDragStart.invoke(Offset.m2787boximpl(pointerInputChange.m4054getPositionF1C5BW0()));
                                long jM4053getIdJ3iCeTQ = pointerInputChange.m4053getIdJ3iCeTQ();
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onDrag);
                                this.L$0 = awaitPointerEventScope;
                                this.label = 3;
                                obj = DragGestureDetectorKt.m283dragjO51t88(awaitPointerEventScope, jM4053getIdJ3iCeTQ, anonymousClass1, this);
                                if (obj == objD) {
                                    return objD;
                                }
                                awaitPointerEventScope2 = awaitPointerEventScope;
                            }
                            return FW.a;
                        }
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        LL.b(obj);
                    }
                    if (((Boolean) obj).booleanValue()) {
                        changes = awaitPointerEventScope2.getCurrentEvent().getChanges();
                        size = changes.size();
                        for (i = 0; i < size; i++) {
                            pointerInputChange2 = changes.get(i);
                            if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                pointerInputChange2.consume();
                            }
                        }
                        this.$onDragEnd.invoke();
                    } else {
                        this.$onDragCancel.invoke();
                    }
                    return FW.a;
                }
                LL.b(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, this, 2, null);
                if (obj == objD) {
                    return objD;
                }
                long jM4053getIdJ3iCeTQ2 = ((PointerInputChange) obj).m4053getIdJ3iCeTQ();
                this.L$0 = awaitPointerEventScope;
                this.label = 2;
                obj = DragGestureDetectorKt.m273awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, jM4053getIdJ3iCeTQ2, this);
                if (obj == objD) {
                    return objD;
                }
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    this.$onDragStart.invoke(Offset.m2787boximpl(pointerInputChange.m4054getPositionF1C5BW0()));
                    long jM4053getIdJ3iCeTQ3 = pointerInputChange.m4053getIdJ3iCeTQ();
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1(this.$onDrag);
                    this.L$0 = awaitPointerEventScope;
                    this.label = 3;
                    obj = DragGestureDetectorKt.m283dragjO51t88(awaitPointerEventScope, jM4053getIdJ3iCeTQ3, anonymousClass2, this);
                    if (obj == objD) {
                        return objD;
                    }
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    if (((Boolean) obj).booleanValue()) {
                        changes = awaitPointerEventScope2.getCurrentEvent().getChanges();
                        size = changes.size();
                        while (i < size) {
                            pointerInputChange2 = changes.get(i);
                            if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                pointerInputChange2.consume();
                            }
                        }
                        this.$onDragEnd.invoke();
                    } else {
                        this.$onDragCancel.invoke();
                    }
                }
                return FW.a;
            } catch (CancellationException e) {
                this.$onDragCancel.invoke();
                throw e;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13122 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C13122 INSTANCE = new C13122();

        public C13122() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m297invokek4lQ0M(((Offset) obj).m2808unboximpl());
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m297invokek4lQ0M(long j) {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$3, reason: invalid class name and case insensitive filesystem */
    public static final class C13133 extends AbstractC2233fv implements InterfaceC3588op {
        public static final C13133 INSTANCE = new C13133();

        public C13133() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m298invoke() {
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m298invoke();
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$4, reason: invalid class name and case insensitive filesystem */
    public static final class C13144 extends AbstractC2233fv implements InterfaceC3588op {
        public static final C13144 INSTANCE = new C13144();

        public C13144() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m299invoke() {
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m299invoke();
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", f = "DragGestureDetector.kt", l = {539, 541, MetaDo.META_FILLREGION}, m = "invokeSuspend")
    public static final class C13155 extends JL implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC3588op $onDragCancel;
        final /* synthetic */ InterfaceC3588op $onDragEnd;
        final /* synthetic */ InterfaceC3750qp $onDragStart;
        final /* synthetic */ InterfaceC0526Fp $onHorizontalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ InterfaceC0526Fp $onHorizontalDrag;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp) {
                super(1);
                this.$onHorizontalDrag = interfaceC0526Fp;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PointerInputChange) obj);
                return FW.a;
            }

            public final void invoke(PointerInputChange pointerInputChange) {
                AbstractC4492zt.h(pointerInputChange, "it");
                this.$onHorizontalDrag.mo13invoke(pointerInputChange, Float.valueOf(Offset.m2798getXimpl(PointerEventKt.positionChange(pointerInputChange))));
                pointerInputChange.consume();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13155(InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$onDragStart = interfaceC3750qp;
            this.$onHorizontalDrag = interfaceC0526Fp;
            this.$onDragEnd = interfaceC3588op;
            this.$onDragCancel = interfaceC3588op2;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C13155 c13155 = new C13155(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, interfaceC0793Of);
            c13155.L$0 = obj;
            return c13155;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C13155) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0076  */
        /* JADX WARN: Code duplicated, block: B:24:0x00a6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x00af  */
        /* JADX WARN: Code duplicated, block: B:28:0x00b5  */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AwaitPointerEventScope awaitPointerEventScope;
            AwaitPointerEventScope awaitPointerEventScope2;
            LJ lj;
            PointerInputChange pointerInputChange;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    LL.b(obj);
                } else {
                    if (i == 2) {
                        lj = (LJ) this.L$1;
                        awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        LL.b(obj);
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange != null) {
                            this.$onDragStart.invoke(Offset.m2787boximpl(pointerInputChange.m4054getPositionF1C5BW0()));
                            this.$onHorizontalDrag.mo13invoke(pointerInputChange, E8.b(lj.a));
                            long jM4053getIdJ3iCeTQ = pointerInputChange.m4053getIdJ3iCeTQ();
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onHorizontalDrag);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 3;
                            obj = DragGestureDetectorKt.m284horizontalDragjO51t88(awaitPointerEventScope2, jM4053getIdJ3iCeTQ, anonymousClass1, this);
                            if (obj == objD) {
                                return objD;
                            }
                        }
                        return FW.a;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    this.$onDragEnd.invoke();
                } else {
                    this.$onDragCancel.invoke();
                }
                return FW.a;
            }
            LL.b(obj);
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
            this.L$0 = awaitPointerEventScope3;
            this.label = 1;
            Object objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, null, this, 2, null);
            if (objAwaitFirstDown$default == objD) {
                return objD;
            }
            awaitPointerEventScope = awaitPointerEventScope3;
            obj = objAwaitFirstDown$default;
            PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
            LJ lj2 = new LJ();
            long jM4053getIdJ3iCeTQ2 = pointerInputChange2.m4053getIdJ3iCeTQ();
            int iM4057getTypeT8wyACA = pointerInputChange2.m4057getTypeT8wyACA();
            DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1 dragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1 = new DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1(lj2);
            this.L$0 = awaitPointerEventScope;
            this.L$1 = lj2;
            this.label = 2;
            obj = DragGestureDetectorKt.m271awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, jM4053getIdJ3iCeTQ2, iM4057getTypeT8wyACA, dragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1, this);
            if (obj == objD) {
                return objD;
            }
            awaitPointerEventScope2 = awaitPointerEventScope;
            lj = lj2;
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                this.$onDragStart.invoke(Offset.m2787boximpl(pointerInputChange.m4054getPositionF1C5BW0()));
                this.$onHorizontalDrag.mo13invoke(pointerInputChange, E8.b(lj.a));
                long jM4053getIdJ3iCeTQ3 = pointerInputChange.m4053getIdJ3iCeTQ();
                AnonymousClass1 anonymousClass2 = new AnonymousClass1(this.$onHorizontalDrag);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 3;
                obj = DragGestureDetectorKt.m284horizontalDragjO51t88(awaitPointerEventScope2, jM4053getIdJ3iCeTQ3, anonymousClass2, this);
                if (obj == objD) {
                    return objD;
                }
                if (((Boolean) obj).booleanValue()) {
                    this.$onDragEnd.invoke();
                } else {
                    this.$onDragCancel.invoke();
                }
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13162 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C13162 INSTANCE = new C13162();

        public C13162() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m300invokek4lQ0M(((Offset) obj).m2808unboximpl());
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m300invokek4lQ0M(long j) {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$3, reason: invalid class name and case insensitive filesystem */
    public static final class C13173 extends AbstractC2233fv implements InterfaceC3588op {
        public static final C13173 INSTANCE = new C13173();

        public C13173() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m301invoke() {
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m301invoke();
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$4, reason: invalid class name and case insensitive filesystem */
    public static final class C13184 extends AbstractC2233fv implements InterfaceC3588op {
        public static final C13184 INSTANCE = new C13184();

        public C13184() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m302invoke() {
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m302invoke();
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5", f = "DragGestureDetector.kt", l = {391, 393, 401}, m = "invokeSuspend")
    public static final class C13195 extends JL implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC3588op $onDragCancel;
        final /* synthetic */ InterfaceC3588op $onDragEnd;
        final /* synthetic */ InterfaceC3750qp $onDragStart;
        final /* synthetic */ InterfaceC0526Fp $onVerticalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ InterfaceC0526Fp $onVerticalDrag;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp) {
                super(1);
                this.$onVerticalDrag = interfaceC0526Fp;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PointerInputChange) obj);
                return FW.a;
            }

            public final void invoke(PointerInputChange pointerInputChange) {
                AbstractC4492zt.h(pointerInputChange, "it");
                this.$onVerticalDrag.mo13invoke(pointerInputChange, Float.valueOf(Offset.m2799getYimpl(PointerEventKt.positionChange(pointerInputChange))));
                pointerInputChange.consume();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13195(InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$onDragStart = interfaceC3750qp;
            this.$onVerticalDrag = interfaceC0526Fp;
            this.$onDragEnd = interfaceC3588op;
            this.$onDragCancel = interfaceC3588op2;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C13195 c13195 = new C13195(this.$onDragStart, this.$onVerticalDrag, this.$onDragEnd, this.$onDragCancel, interfaceC0793Of);
            c13195.L$0 = obj;
            return c13195;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C13195) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0076  */
        /* JADX WARN: Code duplicated, block: B:24:0x00a6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x00af  */
        /* JADX WARN: Code duplicated, block: B:28:0x00b5  */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AwaitPointerEventScope awaitPointerEventScope;
            AwaitPointerEventScope awaitPointerEventScope2;
            LJ lj;
            PointerInputChange pointerInputChange;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    LL.b(obj);
                } else {
                    if (i == 2) {
                        lj = (LJ) this.L$1;
                        awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        LL.b(obj);
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange != null) {
                            this.$onDragStart.invoke(Offset.m2787boximpl(pointerInputChange.m4054getPositionF1C5BW0()));
                            this.$onVerticalDrag.mo13invoke(pointerInputChange, E8.b(lj.a));
                            long jM4053getIdJ3iCeTQ = pointerInputChange.m4053getIdJ3iCeTQ();
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onVerticalDrag);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 3;
                            obj = DragGestureDetectorKt.m287verticalDragjO51t88(awaitPointerEventScope2, jM4053getIdJ3iCeTQ, anonymousClass1, this);
                            if (obj == objD) {
                                return objD;
                            }
                        }
                        return FW.a;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    this.$onDragEnd.invoke();
                } else {
                    this.$onDragCancel.invoke();
                }
                return FW.a;
            }
            LL.b(obj);
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
            this.L$0 = awaitPointerEventScope3;
            this.label = 1;
            Object objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, null, this, 2, null);
            if (objAwaitFirstDown$default == objD) {
                return objD;
            }
            awaitPointerEventScope = awaitPointerEventScope3;
            obj = objAwaitFirstDown$default;
            PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
            LJ lj2 = new LJ();
            long jM4053getIdJ3iCeTQ2 = pointerInputChange2.m4053getIdJ3iCeTQ();
            int iM4057getTypeT8wyACA = pointerInputChange2.m4057getTypeT8wyACA();
            DragGestureDetectorKt$detectVerticalDragGestures$5$drag$1 dragGestureDetectorKt$detectVerticalDragGestures$5$drag$1 = new DragGestureDetectorKt$detectVerticalDragGestures$5$drag$1(lj2);
            this.L$0 = awaitPointerEventScope;
            this.L$1 = lj2;
            this.label = 2;
            obj = DragGestureDetectorKt.m279awaitVerticalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, jM4053getIdJ3iCeTQ2, iM4057getTypeT8wyACA, dragGestureDetectorKt$detectVerticalDragGestures$5$drag$1, this);
            if (obj == objD) {
                return objD;
            }
            awaitPointerEventScope2 = awaitPointerEventScope;
            lj = lj2;
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                this.$onDragStart.invoke(Offset.m2787boximpl(pointerInputChange.m4054getPositionF1C5BW0()));
                this.$onVerticalDrag.mo13invoke(pointerInputChange, E8.b(lj.a));
                long jM4053getIdJ3iCeTQ3 = pointerInputChange.m4053getIdJ3iCeTQ();
                AnonymousClass1 anonymousClass2 = new AnonymousClass1(this.$onVerticalDrag);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 3;
                obj = DragGestureDetectorKt.m287verticalDragjO51t88(awaitPointerEventScope2, jM4053getIdJ3iCeTQ3, anonymousClass2, this);
                if (obj == objD) {
                    return objD;
                }
                if (((Boolean) obj).booleanValue()) {
                    this.$onDragEnd.invoke();
                } else {
                    this.$onDragCancel.invoke();
                }
            }
            return FW.a;
        }
    }

    static {
        float fM5160constructorimpl = Dp.m5160constructorimpl((float) 0.125d);
        mouseSlop = fM5160constructorimpl;
        float fM5160constructorimpl2 = Dp.m5160constructorimpl(18);
        defaultTouchSlop = fM5160constructorimpl2;
        mouseToTouchSlopRatio = fM5160constructorimpl / fM5160constructorimpl2;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007a  */
    /* JADX WARN: Code duplicated, block: B:27:0x008e A[LOOP:0: B:23:0x0078->B:27:0x008e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x0092 A[EDGE_INSN: B:54:0x0092->B:29:0x0092 BREAK  A[LOOP:0: B:23:0x0078->B:27:0x008e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    public static final java.lang.Object m268awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, defpackage.InterfaceC0793Of r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m268awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, Of):java.lang.Object");
    }

    /* JADX INFO: renamed from: awaitDragOrUp-jO51t88, reason: not valid java name */
    private static final Object m269awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        PointerInputChange pointerInputChange;
        NJ nj = new NJ();
        nj.a = j;
        while (true) {
            AbstractC0703Ks.c(0);
            PointerInputChange pointerInputChange2 = null;
            Object objT = J6.t(awaitPointerEventScope, null, interfaceC0793Of, 1, null);
            AbstractC0703Ks.c(1);
            PointerEvent pointerEvent = (PointerEvent) objT;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i);
                if (Boolean.valueOf(PointerId.m4037equalsimpl0(pointerInputChange.m4053getIdJ3iCeTQ(), nj.a)).booleanValue()) {
                    break;
                }
                i++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    PointerInputChange pointerInputChange4 = changes2.get(i2);
                    if (Boolean.valueOf(pointerInputChange4.getPressed()).booleanValue()) {
                        pointerInputChange2 = pointerInputChange4;
                        break;
                    }
                }
                PointerInputChange pointerInputChange5 = pointerInputChange2;
                if (pointerInputChange5 == null) {
                    return pointerInputChange3;
                }
                nj.a = pointerInputChange5.m4053getIdJ3iCeTQ();
            } else if (((Boolean) interfaceC3750qp.invoke(pointerInputChange3)).booleanValue()) {
                return pointerInputChange3;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007a  */
    /* JADX WARN: Code duplicated, block: B:27:0x008e A[LOOP:0: B:23:0x0078->B:27:0x008e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x0092 A[EDGE_INSN: B:56:0x0092->B:29:0x0092 BREAK  A[LOOP:0: B:23:0x0078->B:27:0x008e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitHorizontalDragOrCancellation-rnUCldI, reason: not valid java name */
    public static final java.lang.Object m270awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, defpackage.InterfaceC0793Of r20) {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m270awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, Of):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:29:0x00fe A[LOOP:0: B:25:0x00e3->B:29:0x00fe, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x010b A[EDGE_INSN: B:75:0x010b->B:31:0x010b BREAK  A[LOOP:0: B:25:0x00e3->B:29:0x00fe], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0143 -> B:50:0x014f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x01a3 -> B:61:0x01af). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01ed -> B:50:0x014f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    public static final java.lang.Object m271awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, int r24, defpackage.InterfaceC0526Fp r25, defpackage.InterfaceC0793Of r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m271awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, Fp, Of):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:29:0x0106 A[LOOP:0: B:25:0x00eb->B:29:0x0106, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x0113 A[EDGE_INSN: B:75:0x0113->B:31:0x0113 BREAK  A[LOOP:0: B:25:0x00eb->B:29:0x0106], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x014b -> B:20:0x00b9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01ac -> B:60:0x01b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01f7 -> B:64:0x01be). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    public static final java.lang.Object m272awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, defpackage.InterfaceC0526Fp r24, defpackage.InterfaceC0793Of r25) {
        /*
            Method dump skipped, instruction units count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m272awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, Fp, Of):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    public static final Object m273awaitLongPressOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        DragGestureDetectorKt$awaitLongPressOrCancellation$1 dragGestureDetectorKt$awaitLongPressOrCancellation$1;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        OJ oj;
        if (interfaceC0793Of instanceof DragGestureDetectorKt$awaitLongPressOrCancellation$1) {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = (DragGestureDetectorKt$awaitLongPressOrCancellation$1) interfaceC0793Of;
            int i = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = i - Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(interfaceC0793Of);
            }
        } else {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(interfaceC0793Of);
        }
        Object obj = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
        if (i2 == 0) {
            LL.b(obj);
            if (m285isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
            int size = changes.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i3);
                if (PointerId.m4037equalsimpl0(pointerInputChange.m4053getIdJ3iCeTQ(), j)) {
                    break;
                }
                i3++;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 == null) {
                return null;
            }
            OJ oj2 = new OJ();
            OJ oj3 = new OJ();
            oj3.a = pointerInputChange2;
            long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
            try {
                InterfaceC0526Fp dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(oj3, oj2, null);
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0 = pointerInputChange2;
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1 = oj2;
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = 1;
                if (awaitPointerEventScope.withTimeout(longPressTimeoutMillis, dragGestureDetectorKt$awaitLongPressOrCancellation$2, dragGestureDetectorKt$awaitLongPressOrCancellation$1) == objD) {
                    return objD;
                }
                return null;
            } catch (PointerEventTimeoutCancellationException unused) {
                oj = oj2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            oj = (OJ) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1;
            pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0;
            try {
                LL.b(obj);
                return null;
            } catch (PointerEventTimeoutCancellationException unused2) {
            }
        }
        PointerInputChange pointerInputChange3 = (PointerInputChange) oj.a;
        return pointerInputChange3 == null ? pointerInputChange2 : pointerInputChange3;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:29:0x0102 A[LOOP:0: B:25:0x00e7->B:29:0x0102, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:76:0x010f A[EDGE_INSN: B:76:0x010f->B:31:0x010f BREAK  A[LOOP:0: B:25:0x00e7->B:29:0x0102], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0148 -> B:52:0x0151). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01a8 -> B:63:0x01ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x01ea -> B:20:0x00b6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-wtdNQyU, reason: not valid java name */
    public static final java.lang.Object m274awaitPointerSlopOrCancellationwtdNQyU(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, int r23, androidx.compose.foundation.gestures.PointerDirectionConfig r24, boolean r25, defpackage.InterfaceC0526Fp r26, defpackage.InterfaceC0793Of r27) {
        /*
            Method dump skipped, instruction units count: 503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m274awaitPointerSlopOrCancellationwtdNQyU(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, androidx.compose.foundation.gestures.PointerDirectionConfig, boolean, Fp, Of):java.lang.Object");
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-wtdNQyU$$forInline, reason: not valid java name */
    private static final Object m275awaitPointerSlopOrCancellationwtdNQyU$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, int i, PointerDirectionConfig pointerDirectionConfig, boolean z, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        float f;
        PointerInputChange pointerInputChange;
        long jM2802minusMKHz9U;
        PointerInputChange pointerInputChange2;
        if (m285isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        float fM286pointerSlopE8SPZFQ = m286pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        NJ nj = new NJ();
        nj.a = j;
        float f2 = 0.0f;
        float fMo288crossAxisDeltak4lQ0M = 0.0f;
        while (true) {
            AbstractC0703Ks.c(0);
            Object objT = J6.t(awaitPointerEventScope, null, interfaceC0793Of, 1, null);
            AbstractC0703Ks.c(1);
            PointerEvent pointerEvent = (PointerEvent) objT;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    f = f2;
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                f = f2;
                if (Boolean.valueOf(PointerId.m4037equalsimpl0(pointerInputChange.m4053getIdJ3iCeTQ(), nj.a)).booleanValue()) {
                    break;
                }
                i2++;
                f2 = f;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i3);
                    if (Boolean.valueOf(pointerInputChange2.getPressed()).booleanValue()) {
                        break;
                    }
                    i3++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                nj.a = pointerInputChange4.m4053getIdJ3iCeTQ();
            } else {
                long jM4054getPositionF1C5BW0 = pointerInputChange3.m4054getPositionF1C5BW0();
                long jM4055getPreviousPositionF1C5BW0 = pointerInputChange3.m4055getPreviousPositionF1C5BW0();
                float fMo289mainAxisDeltak4lQ0M = f + (pointerDirectionConfig.mo289mainAxisDeltak4lQ0M(jM4054getPositionF1C5BW0) - pointerDirectionConfig.mo289mainAxisDeltak4lQ0M(jM4055getPreviousPositionF1C5BW0));
                fMo288crossAxisDeltak4lQ0M += pointerDirectionConfig.mo288crossAxisDeltak4lQ0M(jM4054getPositionF1C5BW0) - pointerDirectionConfig.mo288crossAxisDeltak4lQ0M(jM4055getPreviousPositionF1C5BW0);
                float fAbs = z ? Math.abs(fMo289mainAxisDeltak4lQ0M) : Offset.m2796getDistanceimpl(pointerDirectionConfig.mo290offsetFromChangesdBAh8RU(fMo289mainAxisDeltak4lQ0M, fMo288crossAxisDeltak4lQ0M));
                if (fAbs < fM286pointerSlopE8SPZFQ) {
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    AbstractC0703Ks.c(0);
                    awaitPointerEventScope.awaitPointerEvent(pointerEventPass, interfaceC0793Of);
                    AbstractC0703Ks.c(1);
                    if (pointerInputChange3.isConsumed()) {
                        return null;
                    }
                    f = fMo289mainAxisDeltak4lQ0M;
                } else {
                    if (z) {
                        jM2802minusMKHz9U = pointerDirectionConfig.mo290offsetFromChangesdBAh8RU(fMo289mainAxisDeltak4lQ0M - (Math.signum(fMo289mainAxisDeltak4lQ0M) * fM286pointerSlopE8SPZFQ), fMo288crossAxisDeltak4lQ0M);
                    } else {
                        long jMo290offsetFromChangesdBAh8RU = pointerDirectionConfig.mo290offsetFromChangesdBAh8RU(fMo289mainAxisDeltak4lQ0M, fMo288crossAxisDeltak4lQ0M);
                        jM2802minusMKHz9U = Offset.m2802minusMKHz9U(jMo290offsetFromChangesdBAh8RU, Offset.m2805timestuRUvjQ(Offset.m2793divtuRUvjQ(jMo290offsetFromChangesdBAh8RU, fAbs), fM286pointerSlopE8SPZFQ));
                    }
                    interfaceC0526Fp.mo13invoke(pointerInputChange3, Offset.m2787boximpl(jM2802minusMKHz9U));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    fMo288crossAxisDeltak4lQ0M = 0.0f;
                    f = 0.0f;
                }
                f2 = f;
            }
            f2 = f;
        }
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-wtdNQyU$default, reason: not valid java name */
    public static /* synthetic */ Object m276awaitPointerSlopOrCancellationwtdNQyU$default(AwaitPointerEventScope awaitPointerEventScope, long j, int i, PointerDirectionConfig pointerDirectionConfig, boolean z, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of, int i2, Object obj) {
        Object obj2;
        PointerInputChange pointerInputChange;
        Object obj3;
        float fAbs;
        long jM2802minusMKHz9U;
        PointerDirectionConfig horizontalPointerDirectionConfig = (i2 & 4) != 0 ? getHorizontalPointerDirectionConfig() : pointerDirectionConfig;
        int i3 = 1;
        boolean z2 = (i2 & 8) != 0 ? true : z;
        long jM4053getIdJ3iCeTQ = j;
        PointerEventPass pointerEventPass = null;
        if (m285isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), jM4053getIdJ3iCeTQ)) {
            return null;
        }
        float fM286pointerSlopE8SPZFQ = m286pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        while (true) {
            float fMo289mainAxisDeltak4lQ0M = 0.0f;
            float fMo288crossAxisDeltak4lQ0M = 0.0f;
            while (true) {
                int i4 = 0;
                AbstractC0703Ks.c(0);
                Object objT = J6.t(awaitPointerEventScope, pointerEventPass, interfaceC0793Of, i3, pointerEventPass);
                AbstractC0703Ks.c(i3);
                PointerEvent pointerEvent = (PointerEvent) objT;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        fM286pointerSlopE8SPZFQ = fM286pointerSlopE8SPZFQ;
                        obj2 = pointerEventPass;
                        break;
                    }
                    obj2 = changes.get(i5);
                    fM286pointerSlopE8SPZFQ = fM286pointerSlopE8SPZFQ;
                    if (PointerId.m4037equalsimpl0(((PointerInputChange) obj2).m4053getIdJ3iCeTQ(), jM4053getIdJ3iCeTQ)) {
                        break;
                    }
                    i5++;
                    fM286pointerSlopE8SPZFQ = fM286pointerSlopE8SPZFQ;
                }
                pointerInputChange = (PointerInputChange) obj2;
                if (pointerInputChange == null) {
                    return pointerEventPass;
                }
                if (pointerInputChange.isConsumed()) {
                    return pointerEventPass;
                }
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i4 >= size2) {
                            obj3 = pointerEventPass;
                            break;
                        }
                        obj3 = changes2.get(i4);
                        if (((PointerInputChange) obj3).getPressed()) {
                            break;
                        }
                        i4++;
                    }
                    PointerInputChange pointerInputChange2 = (PointerInputChange) obj3;
                    if (pointerInputChange2 == null) {
                        return pointerEventPass;
                    }
                    jM4053getIdJ3iCeTQ = pointerInputChange2.m4053getIdJ3iCeTQ();
                    i3 = 1;
                } else {
                    long jM4054getPositionF1C5BW0 = pointerInputChange.m4054getPositionF1C5BW0();
                    long jM4055getPreviousPositionF1C5BW0 = pointerInputChange.m4055getPreviousPositionF1C5BW0();
                    fMo289mainAxisDeltak4lQ0M += horizontalPointerDirectionConfig.mo289mainAxisDeltak4lQ0M(jM4054getPositionF1C5BW0) - horizontalPointerDirectionConfig.mo289mainAxisDeltak4lQ0M(jM4055getPreviousPositionF1C5BW0);
                    fMo288crossAxisDeltak4lQ0M += horizontalPointerDirectionConfig.mo288crossAxisDeltak4lQ0M(jM4054getPositionF1C5BW0) - horizontalPointerDirectionConfig.mo288crossAxisDeltak4lQ0M(jM4055getPreviousPositionF1C5BW0);
                    fAbs = z2 ? Math.abs(fMo289mainAxisDeltak4lQ0M) : Offset.m2796getDistanceimpl(horizontalPointerDirectionConfig.mo290offsetFromChangesdBAh8RU(fMo289mainAxisDeltak4lQ0M, fMo288crossAxisDeltak4lQ0M));
                    if (fAbs < fM286pointerSlopE8SPZFQ) {
                        PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                        AbstractC0703Ks.c(0);
                        awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, interfaceC0793Of);
                        AbstractC0703Ks.c(1);
                        if (pointerInputChange.isConsumed()) {
                            return null;
                        }
                        i3 = 1;
                        pointerEventPass = null;
                    }
                }
            }
            if (z2) {
                jM2802minusMKHz9U = horizontalPointerDirectionConfig.mo290offsetFromChangesdBAh8RU(fMo289mainAxisDeltak4lQ0M - (Math.signum(fMo289mainAxisDeltak4lQ0M) * fM286pointerSlopE8SPZFQ), fMo288crossAxisDeltak4lQ0M);
                fM286pointerSlopE8SPZFQ = fM286pointerSlopE8SPZFQ;
            } else {
                long jMo290offsetFromChangesdBAh8RU = horizontalPointerDirectionConfig.mo290offsetFromChangesdBAh8RU(fMo289mainAxisDeltak4lQ0M, fMo288crossAxisDeltak4lQ0M);
                long jM2793divtuRUvjQ = Offset.m2793divtuRUvjQ(jMo290offsetFromChangesdBAh8RU, fAbs);
                fM286pointerSlopE8SPZFQ = fM286pointerSlopE8SPZFQ;
                jM2802minusMKHz9U = Offset.m2802minusMKHz9U(jMo290offsetFromChangesdBAh8RU, Offset.m2805timestuRUvjQ(jM2793divtuRUvjQ, fM286pointerSlopE8SPZFQ));
            }
            interfaceC0526Fp.mo13invoke(pointerInputChange, Offset.m2787boximpl(jM2802minusMKHz9U));
            if (pointerInputChange.isConsumed()) {
                return pointerInputChange;
            }
            i3 = 1;
            pointerEventPass = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:29:0x0107 A[LOOP:0: B:25:0x00ec->B:29:0x0107, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x0116 A[EDGE_INSN: B:75:0x0116->B:31:0x0116 BREAK  A[LOOP:0: B:25:0x00ec->B:29:0x0107], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x014e -> B:20:0x00bc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01b2 -> B:60:0x01bb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01fc -> B:64:0x01c5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    public static final java.lang.Object m277awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, defpackage.InterfaceC0526Fp r23, defpackage.InterfaceC0793Of r24) {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m277awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, Fp, Of):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007a  */
    /* JADX WARN: Code duplicated, block: B:27:0x008e A[LOOP:0: B:23:0x0078->B:27:0x008e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x0092 A[EDGE_INSN: B:56:0x0092->B:29:0x0092 BREAK  A[LOOP:0: B:23:0x0078->B:27:0x008e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitVerticalDragOrCancellation-rnUCldI, reason: not valid java name */
    public static final java.lang.Object m278awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, defpackage.InterfaceC0793Of r20) {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m278awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, Of):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:29:0x00fe A[LOOP:0: B:25:0x00e3->B:29:0x00fe, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x010b A[EDGE_INSN: B:75:0x010b->B:31:0x010b BREAK  A[LOOP:0: B:25:0x00e3->B:29:0x00fe], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0143 -> B:50:0x014f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x01a3 -> B:61:0x01af). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01ed -> B:50:0x014f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    public static final java.lang.Object m279awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, int r24, defpackage.InterfaceC0526Fp r25, defpackage.InterfaceC0793Of r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m279awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, Fp, Of):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:29:0x0106 A[LOOP:0: B:25:0x00eb->B:29:0x0106, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x0113 A[EDGE_INSN: B:75:0x0113->B:31:0x0113 BREAK  A[LOOP:0: B:25:0x00eb->B:29:0x0106], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x014b -> B:20:0x00b9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01ac -> B:60:0x01b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01f7 -> B:64:0x01be). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    public static final java.lang.Object m280awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, defpackage.InterfaceC0526Fp r24, defpackage.InterfaceC0793Of r25) {
        /*
            Method dump skipped, instruction units count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m280awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, Fp, Of):java.lang.Object");
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass5(interfaceC3750qp, interfaceC0526Fp, interfaceC3588op2, interfaceC3588op, null), interfaceC0793Of);
        return objAwaitEachGesture == AbstractC0378Bt.d() ? objAwaitEachGesture : FW.a;
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3750qp = AnonymousClass2.INSTANCE;
        }
        InterfaceC3750qp interfaceC3750qp2 = interfaceC3750qp;
        if ((i & 2) != 0) {
            interfaceC3588op = AnonymousClass3.INSTANCE;
        }
        InterfaceC3588op interfaceC3588op3 = interfaceC3588op;
        if ((i & 4) != 0) {
            interfaceC3588op2 = AnonymousClass4.INSTANCE;
        }
        return detectDragGestures(pointerInputScope, interfaceC3750qp2, interfaceC3588op3, interfaceC3588op2, interfaceC0526Fp, interfaceC0793Of);
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope pointerInputScope, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C13115(interfaceC3750qp, interfaceC3588op, interfaceC3588op2, interfaceC0526Fp, null), interfaceC0793Of);
        return objAwaitEachGesture == AbstractC0378Bt.d() ? objAwaitEachGesture : FW.a;
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3750qp = C13082.INSTANCE;
        }
        InterfaceC3750qp interfaceC3750qp2 = interfaceC3750qp;
        if ((i & 2) != 0) {
            interfaceC3588op = C13093.INSTANCE;
        }
        InterfaceC3588op interfaceC3588op3 = interfaceC3588op;
        if ((i & 4) != 0) {
            interfaceC3588op2 = C13104.INSTANCE;
        }
        return detectDragGesturesAfterLongPress(pointerInputScope, interfaceC3750qp2, interfaceC3588op3, interfaceC3588op2, interfaceC0526Fp, interfaceC0793Of);
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope pointerInputScope, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C13155(interfaceC3750qp, interfaceC0526Fp, interfaceC3588op, interfaceC3588op2, null), interfaceC0793Of);
        return objAwaitEachGesture == AbstractC0378Bt.d() ? objAwaitEachGesture : FW.a;
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3750qp = C13122.INSTANCE;
        }
        InterfaceC3750qp interfaceC3750qp2 = interfaceC3750qp;
        if ((i & 2) != 0) {
            interfaceC3588op = C13133.INSTANCE;
        }
        InterfaceC3588op interfaceC3588op3 = interfaceC3588op;
        if ((i & 4) != 0) {
            interfaceC3588op2 = C13144.INSTANCE;
        }
        return detectHorizontalDragGestures(pointerInputScope, interfaceC3750qp2, interfaceC3588op3, interfaceC3588op2, interfaceC0526Fp, interfaceC0793Of);
    }

    public static final Object detectVerticalDragGestures(PointerInputScope pointerInputScope, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C13195(interfaceC3750qp, interfaceC0526Fp, interfaceC3588op, interfaceC3588op2, null), interfaceC0793Of);
        return objAwaitEachGesture == AbstractC0378Bt.d() ? objAwaitEachGesture : FW.a;
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3750qp = C13162.INSTANCE;
        }
        InterfaceC3750qp interfaceC3750qp2 = interfaceC3750qp;
        if ((i & 2) != 0) {
            interfaceC3588op = C13173.INSTANCE;
        }
        InterfaceC3588op interfaceC3588op3 = interfaceC3588op;
        if ((i & 4) != 0) {
            interfaceC3588op2 = C13184.INSTANCE;
        }
        return detectVerticalDragGestures(pointerInputScope, interfaceC3750qp2, interfaceC3588op3, interfaceC3588op2, interfaceC0526Fp, interfaceC0793Of);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b7 A[LOOP:0: B:24:0x009e->B:28:0x00b7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x00bd A[EDGE_INSN: B:64:0x00bd->B:30:0x00bd BREAK  A[LOOP:0: B:24:0x009e->B:28:0x00b7], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008d -> B:23:0x0093). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: drag-VnAYq1g, reason: not valid java name */
    public static final java.lang.Object m281dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, defpackage.InterfaceC3750qp r22, defpackage.InterfaceC3750qp r23, defpackage.InterfaceC3750qp r24, defpackage.InterfaceC0793Of r25) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m281dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, qp, qp, qp, Of):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: drag-VnAYq1g$$forInline, reason: not valid java name */
    private static final Object m282dragVnAYq1g$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC0793Of interfaceC0793Of) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        long jM4053getIdJ3iCeTQ = j;
        if (m285isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), jM4053getIdJ3iCeTQ)) {
            return null;
        }
        while (true) {
            NJ nj = new NJ();
            nj.a = jM4053getIdJ3iCeTQ;
            while (true) {
                int i = 0;
                AbstractC0703Ks.c(0);
                Object objT = J6.t(awaitPointerEventScope, null, interfaceC0793Of, 1, null);
                AbstractC0703Ks.c(1);
                PointerEvent pointerEvent = (PointerEvent) objT;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i2);
                    if (Boolean.valueOf(PointerId.m4037equalsimpl0(pointerInputChange.m4053getIdJ3iCeTQ(), nj.a)).booleanValue()) {
                        break;
                    }
                    i2++;
                }
                pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == null) {
                    pointerInputChange2 = null;
                    break;
                }
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange3 = null;
                            break;
                        }
                        pointerInputChange3 = changes2.get(i);
                        if (Boolean.valueOf(pointerInputChange3.getPressed()).booleanValue()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange3;
                    if (pointerInputChange4 == null) {
                        break;
                    }
                    nj.a = pointerInputChange4.m4053getIdJ3iCeTQ();
                } else {
                    if (Boolean.valueOf((((Number) interfaceC3750qp2.invoke(pointerInputChange2)).floatValue() == 0.0f ? 1 : 0) ^ 1).booleanValue()) {
                        break;
                    }
                }
            }
            if (pointerInputChange2 == null || ((Boolean) interfaceC3750qp3.invoke(pointerInputChange2)).booleanValue()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                return pointerInputChange2;
            }
            interfaceC3750qp.invoke(pointerInputChange2);
            jM4053getIdJ3iCeTQ = pointerInputChange2.m4053getIdJ3iCeTQ();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0055  */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0060  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0048 -> B:18:0x004b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: drag-jO51t88, reason: not valid java name */
    public static final java.lang.Object m283dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r4, long r5, defpackage.InterfaceC3750qp r7, defpackage.InterfaceC0793Of r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = defpackage.AbstractC0378Bt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$1
            qp r4 = (defpackage.InterfaceC3750qp) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            defpackage.LL.b(r8)
            r7 = r4
            r4 = r5
            goto L4b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            defpackage.LL.b(r8)
        L3e:
            r0.L$0 = r4
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = m268awaitDragOrCancellationrnUCldI(r4, r5, r0)
            if (r8 != r1) goto L4b
            return r1
        L4b:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L55
            r4 = 0
            java.lang.Boolean r4 = defpackage.E8.a(r4)
            return r4
        L55:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r8)
            if (r5 == 0) goto L60
            java.lang.Boolean r4 = defpackage.E8.a(r3)
            return r4
        L60:
            r7.invoke(r8)
            long r5 = r8.m4053getIdJ3iCeTQ()
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m283dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, qp, Of):java.lang.Object");
    }

    public static final PointerDirectionConfig getHorizontalPointerDirectionConfig() {
        return HorizontalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig getVerticalPointerDirectionConfig() {
        return VerticalPointerDirectionConfig;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x008b  */
    /* JADX WARN: Code duplicated, block: B:28:0x009f A[LOOP:0: B:24:0x0089->B:28:0x009f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00a4 A[EDGE_INSN: B:67:0x00a4->B:30:0x00a4 BREAK  A[LOOP:0: B:24:0x0089->B:28:0x009f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0079 -> B:23:0x007e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    public static final java.lang.Object m284horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, defpackage.InterfaceC3750qp r20, defpackage.InterfaceC0793Of r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m284horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, qp, Of):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m285isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.m4037equalsimpl0(pointerInputChange.m4053getIdJ3iCeTQ(), j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* JADX INFO: renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m286pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        AbstractC4492zt.h(viewConfiguration, "$this$pointerSlop");
        return PointerType.m4112equalsimpl0(i, PointerType.Companion.m4117getMouseT8wyACA()) ? viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio : viewConfiguration.getTouchSlop();
    }

    public static final PointerDirectionConfig toPointerDirectionConfig(Orientation orientation) {
        AbstractC4492zt.h(orientation, "<this>");
        return orientation == Orientation.Vertical ? VerticalPointerDirectionConfig : HorizontalPointerDirectionConfig;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x008b  */
    /* JADX WARN: Code duplicated, block: B:28:0x009f A[LOOP:0: B:24:0x0089->B:28:0x009f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00a4 A[EDGE_INSN: B:67:0x00a4->B:30:0x00a4 BREAK  A[LOOP:0: B:24:0x0089->B:28:0x009f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0079 -> B:23:0x007e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: verticalDrag-jO51t88, reason: not valid java name */
    public static final java.lang.Object m287verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, defpackage.InterfaceC3750qp r20, defpackage.InterfaceC0793Of r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m287verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, qp, Of):java.lang.Object");
    }
}
