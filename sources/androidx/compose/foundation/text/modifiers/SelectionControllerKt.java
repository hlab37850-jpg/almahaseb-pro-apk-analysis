package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.LongPressTextDragObserverKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextPointerIcon_androidKt;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionControllerKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$1", f = "SelectionController.kt", l = {256}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1 $longPressDragObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1 selectionControllerKt$makeSelectionModifier$longPressDragObserver$1, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$longPressDragObserver = selectionControllerKt$makeSelectionModifier$longPressDragObserver$1;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$longPressDragObserver, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1 selectionControllerKt$makeSelectionModifier$longPressDragObserver$1 = this.$longPressDragObserver;
                this.label = 1;
                if (LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver(pointerInputScope, selectionControllerKt$makeSelectionModifier$longPressDragObserver$1, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$2", f = "SelectionController.kt", l = {345}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1 $mouseSelectionObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1 selectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$mouseSelectionObserver = selectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$mouseSelectionObserver, interfaceC0793Of);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1 selectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1 = this.$mouseSelectionObserver;
                this.label = 1;
                if (TextSelectionMouseDetectorKt.mouseSelectionDetector(pointerInputScope, selectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1, this) == objD) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r11v1, types: [androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1, types: [androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1, java.lang.Object] */
    public static final Modifier makeSelectionModifier(final SelectionRegistrar selectionRegistrar, final long j, final InterfaceC3588op interfaceC3588op, final InterfaceC3588op interfaceC3588op2, boolean z) {
        if (z) {
            ?? r12 = new TextDragObserver() { // from class: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1
                private long dragTotalDistance;
                private long lastPosition;

                {
                    Offset.Companion companion = Offset.Companion;
                    this.lastPosition = companion.m2814getZeroF1C5BW0();
                    this.dragTotalDistance = companion.m2814getZeroF1C5BW0();
                }

                public final long getDragTotalDistance() {
                    return this.dragTotalDistance;
                }

                public final long getLastPosition() {
                    return this.lastPosition;
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public void onCancel() {
                    if (SelectionRegistrarKt.hasSelection(selectionRegistrar, j)) {
                        selectionRegistrar.notifySelectionUpdateEnd();
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* JADX INFO: renamed from: onDown-k-4lQ0M */
                public void mo810onDownk4lQ0M(long j2) {
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* JADX INFO: renamed from: onDrag-k-4lQ0M */
                public void mo811onDragk4lQ0M(long j2) {
                    LayoutCoordinates layoutCoordinates = (LayoutCoordinates) interfaceC3588op.invoke();
                    if (layoutCoordinates != null) {
                        SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                        long j3 = j;
                        InterfaceC3588op interfaceC3588op3 = interfaceC3588op2;
                        if (layoutCoordinates.isAttached() && SelectionRegistrarKt.hasSelection(selectionRegistrar2, j3)) {
                            long jM2803plusMKHz9U = Offset.m2803plusMKHz9U(this.dragTotalDistance, j2);
                            this.dragTotalDistance = jM2803plusMKHz9U;
                            long jM2803plusMKHz9U2 = Offset.m2803plusMKHz9U(this.lastPosition, jM2803plusMKHz9U);
                            if (SelectionControllerKt.m870outOfBoundary2x9bVx0((TextLayoutResult) interfaceC3588op3.invoke(), this.lastPosition, jM2803plusMKHz9U2) || !selectionRegistrar2.mo945notifySelectionUpdate5iVPX68(layoutCoordinates, jM2803plusMKHz9U2, this.lastPosition, false, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
                                return;
                            }
                            this.lastPosition = jM2803plusMKHz9U2;
                            this.dragTotalDistance = Offset.Companion.m2814getZeroF1C5BW0();
                        }
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* JADX INFO: renamed from: onStart-k-4lQ0M */
                public void mo812onStartk4lQ0M(long j2) {
                    LayoutCoordinates layoutCoordinates = (LayoutCoordinates) interfaceC3588op.invoke();
                    if (layoutCoordinates != null) {
                        InterfaceC3588op interfaceC3588op3 = interfaceC3588op2;
                        SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                        long j3 = j;
                        if (!layoutCoordinates.isAttached()) {
                            return;
                        }
                        if (SelectionControllerKt.m870outOfBoundary2x9bVx0((TextLayoutResult) interfaceC3588op3.invoke(), j2, j2)) {
                            selectionRegistrar2.notifySelectionUpdateSelectAll(j3);
                        } else {
                            selectionRegistrar2.mo946notifySelectionUpdateStartd4ec7I(layoutCoordinates, j2, SelectionAdjustment.Companion.getWord());
                        }
                        this.lastPosition = j2;
                    }
                    if (SelectionRegistrarKt.hasSelection(selectionRegistrar, j)) {
                        this.dragTotalDistance = Offset.Companion.m2814getZeroF1C5BW0();
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public void onStop() {
                    if (SelectionRegistrarKt.hasSelection(selectionRegistrar, j)) {
                        selectionRegistrar.notifySelectionUpdateEnd();
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public void onUp() {
                }

                public final void setDragTotalDistance(long j2) {
                    this.dragTotalDistance = j2;
                }

                public final void setLastPosition(long j2) {
                    this.lastPosition = j2;
                }
            };
            return SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, (Object) r12, new AnonymousClass1(r12, null));
        }
        ?? r11 = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1
            private long lastPosition = Offset.Companion.m2814getZeroF1C5BW0();

            public final long getLastPosition() {
                return this.lastPosition;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onDrag-3MmeM6k, reason: not valid java name */
            public boolean mo871onDrag3MmeM6k(long j2, SelectionAdjustment selectionAdjustment) {
                AbstractC4492zt.h(selectionAdjustment, "adjustment");
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) interfaceC3588op.invoke();
                if (layoutCoordinates == null) {
                    return true;
                }
                SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                long j3 = j;
                if (!layoutCoordinates.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar2, j3)) {
                    return false;
                }
                if (!selectionRegistrar2.mo945notifySelectionUpdate5iVPX68(layoutCoordinates, j2, this.lastPosition, false, selectionAdjustment)) {
                    return true;
                }
                this.lastPosition = j2;
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onExtend-k-4lQ0M, reason: not valid java name */
            public boolean mo872onExtendk4lQ0M(long j2) {
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) interfaceC3588op.invoke();
                if (layoutCoordinates == null) {
                    return false;
                }
                SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                long j3 = j;
                if (!layoutCoordinates.isAttached()) {
                    return false;
                }
                if (selectionRegistrar2.mo945notifySelectionUpdate5iVPX68(layoutCoordinates, j2, this.lastPosition, false, SelectionAdjustment.Companion.getNone())) {
                    this.lastPosition = j2;
                }
                return SelectionRegistrarKt.hasSelection(selectionRegistrar2, j3);
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onExtendDrag-k-4lQ0M, reason: not valid java name */
            public boolean mo873onExtendDragk4lQ0M(long j2) {
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) interfaceC3588op.invoke();
                if (layoutCoordinates == null) {
                    return true;
                }
                SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                long j3 = j;
                if (!layoutCoordinates.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar2, j3)) {
                    return false;
                }
                if (!selectionRegistrar2.mo945notifySelectionUpdate5iVPX68(layoutCoordinates, j2, this.lastPosition, false, SelectionAdjustment.Companion.getNone())) {
                    return true;
                }
                this.lastPosition = j2;
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onStart-3MmeM6k, reason: not valid java name */
            public boolean mo874onStart3MmeM6k(long j2, SelectionAdjustment selectionAdjustment) {
                AbstractC4492zt.h(selectionAdjustment, "adjustment");
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) interfaceC3588op.invoke();
                if (layoutCoordinates == null) {
                    return false;
                }
                SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                long j3 = j;
                if (!layoutCoordinates.isAttached()) {
                    return false;
                }
                selectionRegistrar2.mo946notifySelectionUpdateStartd4ec7I(layoutCoordinates, j2, selectionAdjustment);
                this.lastPosition = j2;
                return SelectionRegistrarKt.hasSelection(selectionRegistrar2, j3);
            }

            public final void setLastPosition(long j2) {
                this.lastPosition = j2;
            }
        };
        return PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, (Object) r11, new AnonymousClass2(r11, null)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: outOfBoundary-2x9bVx0, reason: not valid java name */
    public static final boolean m870outOfBoundary2x9bVx0(TextLayoutResult textLayoutResult, long j, long j2) {
        if (textLayoutResult == null) {
            return false;
        }
        int length = textLayoutResult.getLayoutInput().getText().getText().length();
        int iM4677getOffsetForPositionk4lQ0M = textLayoutResult.m4677getOffsetForPositionk4lQ0M(j);
        int iM4677getOffsetForPositionk4lQ0M2 = textLayoutResult.m4677getOffsetForPositionk4lQ0M(j2);
        int i = length - 1;
        return (iM4677getOffsetForPositionk4lQ0M >= i && iM4677getOffsetForPositionk4lQ0M2 >= i) || (iM4677getOffsetForPositionk4lQ0M < 0 && iM4677getOffsetForPositionk4lQ0M2 < 0);
    }
}
