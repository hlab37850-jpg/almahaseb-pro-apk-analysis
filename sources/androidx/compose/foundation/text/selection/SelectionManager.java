package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3882sU;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0604Ip;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.JL;
import defpackage.LL;
import defpackage.XS;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionManager {
    private final MutableState<Selection> _selection;
    private ClipboardManager clipboardManager;
    private LayoutCoordinates containerLayoutCoordinates;
    private final MutableState currentDragPosition$delegate;
    private final MutableState dragBeginPosition$delegate;
    private final MutableState dragTotalDistance$delegate;
    private final MutableState draggingHandle$delegate;
    private final MutableState endHandlePosition$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MutableState hasFocus$delegate;
    private InterfaceC3750qp onSelectionChange;
    private Offset previousPosition;
    private final SelectionRegistrarImpl selectionRegistrar;
    private final MutableState startHandlePosition$delegate;
    private TextToolbar textToolbar;
    private boolean touchMode;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).longValue());
            return FW.a;
        }

        public final void invoke(long j) {
            Selection selection;
            Selection.AnchorInfo end;
            Selection.AnchorInfo start;
            Selection selection2 = SelectionManager.this.getSelection();
            if ((selection2 == null || (start = selection2.getStart()) == null || j != start.getSelectableId()) && ((selection = SelectionManager.this.getSelection()) == null || (end = selection.getEnd()) == null || j != end.getSelectableId())) {
                return;
            }
            SelectionManager.this.updateHandleOffsets();
            SelectionManager.this.updateSelectionToolbarPosition();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
        public AnonymousClass2() {
            super(3);
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            m930invoked4ec7I((LayoutCoordinates) obj, ((Offset) obj2).m2808unboximpl(), (SelectionAdjustment) obj3);
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final void m930invoked4ec7I(LayoutCoordinates layoutCoordinates, long j, SelectionAdjustment selectionAdjustment) {
            AbstractC4492zt.h(layoutCoordinates, "layoutCoordinates");
            AbstractC4492zt.h(selectionAdjustment, "selectionMode");
            Offset offsetM915convertToContainerCoordinatesQ7Q5hAU = SelectionManager.this.m915convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j);
            if (offsetM915convertToContainerCoordinatesQ7Q5hAU != null) {
                SelectionManager.this.m921startSelection9KIMszo(offsetM915convertToContainerCoordinatesQ7Q5hAU.m2808unboximpl(), false, selectionAdjustment);
                SelectionManager.this.getFocusRequester().requestFocus();
                SelectionManager.this.hideSelectionToolbar$foundation_release();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        public AnonymousClass3() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).longValue());
            return FW.a;
        }

        public final void invoke(long j) {
            SelectionManager selectionManager = SelectionManager.this;
            C2020dG c2020dGSelectAll$foundation_release = selectionManager.selectAll$foundation_release(j, selectionManager.getSelection());
            Selection selection = (Selection) c2020dGSelectAll$foundation_release.a();
            Map<Long, Selection> map = (Map) c2020dGSelectAll$foundation_release.b();
            if (!AbstractC4492zt.d(selection, SelectionManager.this.getSelection())) {
                SelectionManager.this.selectionRegistrar.setSubselections(map);
                SelectionManager.this.getOnSelectionChange().invoke(selection);
            }
            SelectionManager.this.getFocusRequester().requestFocus();
            SelectionManager.this.hideSelectionToolbar$foundation_release();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0604Ip {
        public AnonymousClass4() {
            super(5);
        }

        @Override // defpackage.InterfaceC0604Ip
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return m931invoke5iVPX68((LayoutCoordinates) obj, ((Offset) obj2).m2808unboximpl(), ((Offset) obj3).m2808unboximpl(), ((Boolean) obj4).booleanValue(), (SelectionAdjustment) obj5);
        }

        /* JADX INFO: renamed from: invoke-5iVPX68, reason: not valid java name */
        public final Boolean m931invoke5iVPX68(LayoutCoordinates layoutCoordinates, long j, long j2, boolean z, SelectionAdjustment selectionAdjustment) {
            AbstractC4492zt.h(layoutCoordinates, "layoutCoordinates");
            AbstractC4492zt.h(selectionAdjustment, "selectionMode");
            return Boolean.valueOf(SelectionManager.this.m929updateSelectionRHHTvR4$foundation_release(SelectionManager.this.m915convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j), SelectionManager.this.m915convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j2), z, selectionAdjustment));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC3588op {
        public AnonymousClass5() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m932invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m932invoke() {
            SelectionManager.this.showSelectionToolbar$foundation_release();
            SelectionManager.this.setDraggingHandle(null);
            SelectionManager.this.m916setCurrentDragPosition_kEHs6E(null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$6, reason: invalid class name */
    public static final class AnonymousClass6 extends AbstractC2233fv implements InterfaceC3750qp {
        public AnonymousClass6() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).longValue());
            return FW.a;
        }

        public final void invoke(long j) {
            if (SelectionManager.this.selectionRegistrar.getSubselections().containsKey(Long.valueOf(j))) {
                SelectionManager.this.onRelease();
                SelectionManager.this.setSelection(null);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$7, reason: invalid class name */
    public static final class AnonymousClass7 extends AbstractC2233fv implements InterfaceC3750qp {
        public AnonymousClass7() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).longValue());
            return FW.a;
        }

        public final void invoke(long j) {
            Selection selection;
            Selection.AnchorInfo end;
            Selection.AnchorInfo start;
            Selection selection2 = SelectionManager.this.getSelection();
            if ((selection2 == null || (start = selection2.getStart()) == null || j != start.getSelectableId()) && ((selection = SelectionManager.this.getSelection()) == null || (end = selection.getEnd()) == null || j != end.getSelectableId())) {
                return;
            }
            SelectionManager.this.m920setStartHandlePosition_kEHs6E(null);
            SelectionManager.this.m919setEndHandlePosition_kEHs6E(null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2", f = "SelectionManager.kt", l = {627}, m = "invokeSuspend")
    public static final class C14042 extends JL implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC3750qp $onTap;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14042(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$onTap = interfaceC3750qp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C14042 c14042 = new C14042(this.$onTap, interfaceC0793Of);
            c14042.L$0 = obj;
            return c14042;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C14042) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                this.label = 1;
                obj = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope, null, this, 1, null);
                if (obj == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            PointerInputChange pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                this.$onTap.invoke(Offset.m2787boximpl(pointerInputChange.m4054getPositionF1C5BW0()));
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1", f = "SelectionManager.kt", l = {634}, m = "invokeSuspend")
    public static final class C14061 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC3588op $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00631 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ InterfaceC3588op $block;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00631(InterfaceC3588op interfaceC3588op) {
                super(1);
                this.$block = interfaceC3588op;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m935invokek4lQ0M(((Offset) obj).m2808unboximpl());
                return FW.a;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m935invokek4lQ0M(long j) {
                this.$block.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14061(InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$block = interfaceC3588op;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C14061 c14061 = SelectionManager.this.new C14061(this.$block, interfaceC0793Of);
            c14061.L$0 = obj;
            return c14061;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C14061) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                SelectionManager selectionManager = SelectionManager.this;
                C00631 c00631 = new C00631(this.$block);
                this.label = 1;
                if (selectionManager.detectNonConsumingTap(pointerInputScope, c00631, this) == objD) {
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

    public SelectionManager(SelectionRegistrarImpl selectionRegistrarImpl) {
        AbstractC4492zt.h(selectionRegistrarImpl, "selectionRegistrar");
        this.selectionRegistrar = selectionRegistrarImpl;
        this._selection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.touchMode = true;
        this.onSelectionChange = SelectionManager$onSelectionChange$1.INSTANCE;
        this.focusRequester = new FocusRequester();
        this.hasFocus$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        Offset.Companion companion = Offset.Companion;
        this.dragBeginPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2787boximpl(companion.m2814getZeroF1C5BW0()), null, 2, null);
        this.dragTotalDistance$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2787boximpl(companion.m2814getZeroF1C5BW0()), null, 2, null);
        this.startHandlePosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.endHandlePosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        selectionRegistrarImpl.setOnPositionChangeCallback$foundation_release(new AnonymousClass1());
        selectionRegistrarImpl.setOnSelectionUpdateStartCallback$foundation_release(new AnonymousClass2());
        selectionRegistrarImpl.setOnSelectionUpdateSelectAll$foundation_release(new AnonymousClass3());
        selectionRegistrarImpl.setOnSelectionUpdateCallback$foundation_release(new AnonymousClass4());
        selectionRegistrarImpl.setOnSelectionUpdateEndCallback$foundation_release(new AnonymousClass5());
        selectionRegistrarImpl.setOnSelectableChangeCallback$foundation_release(new AnonymousClass6());
        selectionRegistrarImpl.setAfterSelectableUnsubscribe$foundation_release(new AnonymousClass7());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: convertToContainerCoordinates-Q7Q5hAU, reason: not valid java name */
    public final Offset m915convertToContainerCoordinatesQ7Q5hAU(LayoutCoordinates layoutCoordinates, long j) {
        LayoutCoordinates layoutCoordinates2 = this.containerLayoutCoordinates;
        if (layoutCoordinates2 == null || !layoutCoordinates2.isAttached()) {
            return null;
        }
        return Offset.m2787boximpl(requireContainerCoordinates$foundation_release().mo4167localPositionOfR5De75A(layoutCoordinates, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object detectNonConsumingTap(PointerInputScope pointerInputScope, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C14042(interfaceC3750qp, null), interfaceC0793Of);
        return objAwaitEachGesture == AbstractC0378Bt.d() ? objAwaitEachGesture : FW.a;
    }

    private final Rect getContentRect() {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2;
        Selection selection = getSelection();
        if (selection == null) {
            return Rect.Companion.getZero();
        }
        Selectable anchorSelectable$foundation_release = getAnchorSelectable$foundation_release(selection.getStart());
        Selectable anchorSelectable$foundation_release2 = getAnchorSelectable$foundation_release(selection.getEnd());
        if (anchorSelectable$foundation_release == null || (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) == null) {
            return Rect.Companion.getZero();
        }
        if (anchorSelectable$foundation_release2 == null || (layoutCoordinates2 = anchorSelectable$foundation_release2.getLayoutCoordinates()) == null) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates layoutCoordinates3 = this.containerLayoutCoordinates;
        if (layoutCoordinates3 == null || !layoutCoordinates3.isAttached()) {
            return Rect.Companion.getZero();
        }
        long jMo4167localPositionOfR5De75A = layoutCoordinates3.mo4167localPositionOfR5De75A(layoutCoordinates, anchorSelectable$foundation_release.mo884getHandlePositiondBAh8RU(selection, true));
        long jMo4167localPositionOfR5De75A2 = layoutCoordinates3.mo4167localPositionOfR5De75A(layoutCoordinates2, anchorSelectable$foundation_release2.mo884getHandlePositiondBAh8RU(selection, false));
        long jMo4168localToRootMKHz9U = layoutCoordinates3.mo4168localToRootMKHz9U(jMo4167localPositionOfR5De75A);
        long jMo4168localToRootMKHz9U2 = layoutCoordinates3.mo4168localToRootMKHz9U(jMo4167localPositionOfR5De75A2);
        return new Rect(Math.min(Offset.m2798getXimpl(jMo4168localToRootMKHz9U), Offset.m2798getXimpl(jMo4168localToRootMKHz9U2)), Math.min(Offset.m2799getYimpl(layoutCoordinates3.mo4168localToRootMKHz9U(layoutCoordinates3.mo4167localPositionOfR5De75A(layoutCoordinates, OffsetKt.Offset(0.0f, anchorSelectable$foundation_release.getBoundingBox(selection.getStart().getOffset()).getTop())))), Offset.m2799getYimpl(layoutCoordinates3.mo4168localToRootMKHz9U(layoutCoordinates3.mo4167localPositionOfR5De75A(layoutCoordinates2, OffsetKt.Offset(0.0f, anchorSelectable$foundation_release2.getBoundingBox(selection.getEnd().getOffset()).getTop()))))), Math.max(Offset.m2798getXimpl(jMo4168localToRootMKHz9U), Offset.m2798getXimpl(jMo4168localToRootMKHz9U2)), Math.max(Offset.m2799getYimpl(jMo4168localToRootMKHz9U), Offset.m2799getYimpl(jMo4168localToRootMKHz9U2)) + ((float) (((double) SelectionHandlesKt.getHandleHeight()) * 4.0d)));
    }

    private final boolean getShouldShowMagnifier() {
        return getDraggingHandle() != null;
    }

    private final Modifier onClearSelectionRequested(Modifier modifier, InterfaceC3588op interfaceC3588op) {
        return getHasFocus() ? SuspendingPointerInputFilterKt.pointerInput(modifier, FW.a, new C14061(interfaceC3588op, null)) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m916setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setDragBeginPosition-k-4lQ0M, reason: not valid java name */
    public final void m917setDragBeginPositionk4lQ0M(long j) {
        this.dragBeginPosition$delegate.setValue(Offset.m2787boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setDragTotalDistance-k-4lQ0M, reason: not valid java name */
    public final void m918setDragTotalDistancek4lQ0M(long j) {
        this.dragTotalDistance$delegate.setValue(Offset.m2787boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setEndHandlePosition-_kEHs6E, reason: not valid java name */
    public final void m919setEndHandlePosition_kEHs6E(Offset offset) {
        this.endHandlePosition$delegate.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setStartHandlePosition-_kEHs6E, reason: not valid java name */
    public final void m920setStartHandlePosition_kEHs6E(Offset offset) {
        this.startHandlePosition$delegate.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startSelection-9KIMszo, reason: not valid java name */
    public final void m921startSelection9KIMszo(long j, boolean z, SelectionAdjustment selectionAdjustment) {
        m928updateSelection3R_tFg$foundation_release(j, j, null, z, selectionAdjustment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHandleOffsets() {
        Selection.AnchorInfo end;
        Selection.AnchorInfo start;
        Selection selection = getSelection();
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        Selectable anchorSelectable$foundation_release = (selection == null || (start = selection.getStart()) == null) ? null : getAnchorSelectable$foundation_release(start);
        Selectable anchorSelectable$foundation_release2 = (selection == null || (end = selection.getEnd()) == null) ? null : getAnchorSelectable$foundation_release(end);
        LayoutCoordinates layoutCoordinates2 = anchorSelectable$foundation_release != null ? anchorSelectable$foundation_release.getLayoutCoordinates() : null;
        LayoutCoordinates layoutCoordinates3 = anchorSelectable$foundation_release2 != null ? anchorSelectable$foundation_release2.getLayoutCoordinates() : null;
        if (selection == null || layoutCoordinates == null || !layoutCoordinates.isAttached() || layoutCoordinates2 == null || layoutCoordinates3 == null) {
            m920setStartHandlePosition_kEHs6E(null);
            m919setEndHandlePosition_kEHs6E(null);
            return;
        }
        long jMo4167localPositionOfR5De75A = layoutCoordinates.mo4167localPositionOfR5De75A(layoutCoordinates2, anchorSelectable$foundation_release.mo884getHandlePositiondBAh8RU(selection, true));
        long jMo4167localPositionOfR5De75A2 = layoutCoordinates.mo4167localPositionOfR5De75A(layoutCoordinates3, anchorSelectable$foundation_release2.mo884getHandlePositiondBAh8RU(selection, false));
        Rect rectVisibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates);
        Offset offsetM2787boximpl = Offset.m2787boximpl(jMo4167localPositionOfR5De75A);
        offsetM2787boximpl.m2808unboximpl();
        if (!SelectionManagerKt.m938containsInclusiveUv8p0NA(rectVisibleBounds, jMo4167localPositionOfR5De75A) && getDraggingHandle() != Handle.SelectionStart) {
            offsetM2787boximpl = null;
        }
        m920setStartHandlePosition_kEHs6E(offsetM2787boximpl);
        Offset offsetM2787boximpl2 = Offset.m2787boximpl(jMo4167localPositionOfR5De75A2);
        offsetM2787boximpl2.m2808unboximpl();
        m919setEndHandlePosition_kEHs6E((SelectionManagerKt.m938containsInclusiveUv8p0NA(rectVisibleBounds, jMo4167localPositionOfR5De75A2) || getDraggingHandle() == Handle.SelectionEnd) ? offsetM2787boximpl2 : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionToolbarPosition() {
        if (getHasFocus()) {
            TextToolbar textToolbar = this.textToolbar;
            if ((textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Shown) {
                showSelectionToolbar$foundation_release();
            }
        }
    }

    /* JADX INFO: renamed from: contextMenuOpenAdjustment-k-4lQ0M, reason: not valid java name */
    public final void m922contextMenuOpenAdjustmentk4lQ0M(long j) {
        Selection selection = getSelection();
        if (selection != null ? TextRange.m4699getCollapsedimpl(selection.m892toTextRanged9O1mEE()) : true) {
            m921startSelection9KIMszo(j, true, SelectionAdjustment.Companion.getWord());
        }
    }

    public final void copy$foundation_release() {
        ClipboardManager clipboardManager;
        AnnotatedString selectedText$foundation_release = getSelectedText$foundation_release();
        if (selectedText$foundation_release == null || (clipboardManager = this.clipboardManager) == null) {
            return;
        }
        clipboardManager.setText(selectedText$foundation_release);
    }

    public final Selectable getAnchorSelectable$foundation_release(Selection.AnchorInfo anchorInfo) {
        AbstractC4492zt.h(anchorInfo, "anchor");
        return this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(anchorInfo.getSelectableId()));
    }

    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    /* JADX INFO: renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m923getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    /* JADX INFO: renamed from: getDragBeginPosition-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m924getDragBeginPositionF1C5BW0$foundation_release() {
        return ((Offset) this.dragBeginPosition$delegate.getValue()).m2808unboximpl();
    }

    /* JADX INFO: renamed from: getDragTotalDistance-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m925getDragTotalDistanceF1C5BW0$foundation_release() {
        return ((Offset) this.dragTotalDistance$delegate.getValue()).m2808unboximpl();
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    /* JADX INFO: renamed from: getEndHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m926getEndHandlePosition_m7T9E() {
        return (Offset) this.endHandlePosition$delegate.getValue();
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    public final Modifier getModifier() {
        Modifier modifierSelectionMagnifier = Modifier.Companion;
        Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested(modifierSelectionMagnifier, new SelectionManager$modifier$1(this)), new SelectionManager$modifier$2(this)), this.focusRequester), new SelectionManager$modifier$3(this)), false, null, 3, null), new SelectionManager$modifier$4(this));
        if (getShouldShowMagnifier()) {
            modifierSelectionMagnifier = SelectionManager_androidKt.selectionMagnifier(modifierSelectionMagnifier, this);
        }
        return modifierOnKeyEvent.then(modifierSelectionMagnifier);
    }

    public final InterfaceC3750qp getOnSelectionChange() {
        return this.onSelectionChange;
    }

    public final AnnotatedString getSelectedText$foundation_release() {
        AnnotatedString annotatedStringPlus;
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        Selection selection = getSelection();
        AnnotatedString annotatedString = null;
        if (selection == null) {
            return null;
        }
        int size = listSort.size();
        for (int i = 0; i < size; i++) {
            Selectable selectable = listSort.get(i);
            if (selectable.getSelectableId() == selection.getStart().getSelectableId() || selectable.getSelectableId() == selection.getEnd().getSelectableId() || annotatedString != null) {
                AnnotatedString currentSelectedText = SelectionManagerKt.getCurrentSelectedText(selectable, selection);
                if (annotatedString != null && (annotatedStringPlus = annotatedString.plus(currentSelectedText)) != null) {
                    currentSelectedText = annotatedStringPlus;
                }
                if ((selectable.getSelectableId() == selection.getEnd().getSelectableId() && !selection.getHandlesCrossed()) || (selectable.getSelectableId() == selection.getStart().getSelectableId() && selection.getHandlesCrossed())) {
                    return currentSelectedText;
                }
                annotatedString = currentSelectedText;
            }
        }
        return annotatedString;
    }

    public final Selection getSelection() {
        return this._selection.getValue();
    }

    /* JADX INFO: renamed from: getStartHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m927getStartHandlePosition_m7T9E() {
        return (Offset) this.startHandlePosition$delegate.getValue();
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final boolean getTouchMode() {
        return this.touchMode;
    }

    public final TextDragObserver handleDragObserver(final boolean z) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.SelectionManager.handleDragObserver.1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                SelectionManager.this.showSelectionToolbar$foundation_release();
                SelectionManager.this.setDraggingHandle(null);
                SelectionManager.this.m916setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public void mo810onDownk4lQ0M(long j) {
                LayoutCoordinates layoutCoordinates;
                Selection selection = SelectionManager.this.getSelection();
                if (selection == null) {
                    return;
                }
                Selectable anchorSelectable$foundation_release = SelectionManager.this.getAnchorSelectable$foundation_release(z ? selection.getStart() : selection.getEnd());
                if (anchorSelectable$foundation_release == null || (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) == null) {
                    return;
                }
                long jM902getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m902getAdjustedCoordinatesk4lQ0M(anchorSelectable$foundation_release.mo884getHandlePositiondBAh8RU(selection, z));
                SelectionManager selectionManager = SelectionManager.this;
                selectionManager.m916setCurrentDragPosition_kEHs6E(Offset.m2787boximpl(selectionManager.requireContainerCoordinates$foundation_release().mo4167localPositionOfR5De75A(layoutCoordinates, jM902getAdjustedCoordinatesk4lQ0M)));
                SelectionManager.this.setDraggingHandle(z ? Handle.SelectionStart : Handle.SelectionEnd);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public void mo811onDragk4lQ0M(long j) {
                SelectionManager selectionManager = SelectionManager.this;
                selectionManager.m918setDragTotalDistancek4lQ0M(Offset.m2803plusMKHz9U(selectionManager.m925getDragTotalDistanceF1C5BW0$foundation_release(), j));
                long jM2803plusMKHz9U = Offset.m2803plusMKHz9U(SelectionManager.this.m924getDragBeginPositionF1C5BW0$foundation_release(), SelectionManager.this.m925getDragTotalDistanceF1C5BW0$foundation_release());
                if (SelectionManager.this.m929updateSelectionRHHTvR4$foundation_release(Offset.m2787boximpl(jM2803plusMKHz9U), Offset.m2787boximpl(SelectionManager.this.m924getDragBeginPositionF1C5BW0$foundation_release()), z, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
                    SelectionManager.this.m917setDragBeginPositionk4lQ0M(jM2803plusMKHz9U);
                    SelectionManager.this.m918setDragTotalDistancek4lQ0M(Offset.Companion.m2814getZeroF1C5BW0());
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-k-4lQ0M */
            public void mo812onStartk4lQ0M(long j) {
                LayoutCoordinates layoutCoordinates;
                long jMo884getHandlePositiondBAh8RU;
                SelectionManager.this.hideSelectionToolbar$foundation_release();
                Selection selection = SelectionManager.this.getSelection();
                AbstractC4492zt.e(selection);
                Selectable selectable = SelectionManager.this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection.getStart().getSelectableId()));
                Selectable selectable2 = SelectionManager.this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection.getEnd().getSelectableId()));
                if (z) {
                    layoutCoordinates = selectable != null ? selectable.getLayoutCoordinates() : null;
                    AbstractC4492zt.e(layoutCoordinates);
                } else {
                    layoutCoordinates = selectable2 != null ? selectable2.getLayoutCoordinates() : null;
                    AbstractC4492zt.e(layoutCoordinates);
                }
                if (z) {
                    AbstractC4492zt.e(selectable);
                    jMo884getHandlePositiondBAh8RU = selectable.mo884getHandlePositiondBAh8RU(selection, true);
                } else {
                    AbstractC4492zt.e(selectable2);
                    jMo884getHandlePositiondBAh8RU = selectable2.mo884getHandlePositiondBAh8RU(selection, false);
                }
                long jM902getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m902getAdjustedCoordinatesk4lQ0M(jMo884getHandlePositiondBAh8RU);
                SelectionManager selectionManager = SelectionManager.this;
                selectionManager.m917setDragBeginPositionk4lQ0M(selectionManager.requireContainerCoordinates$foundation_release().mo4167localPositionOfR5De75A(layoutCoordinates, jM902getAdjustedCoordinatesk4lQ0M));
                SelectionManager.this.m918setDragTotalDistancek4lQ0M(Offset.Companion.m2814getZeroF1C5BW0());
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                SelectionManager.this.showSelectionToolbar$foundation_release();
                SelectionManager.this.setDraggingHandle(null);
                SelectionManager.this.m916setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                SelectionManager.this.setDraggingHandle(null);
                SelectionManager.this.m916setCurrentDragPosition_kEHs6E(null);
            }
        };
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        if (getHasFocus()) {
            TextToolbar textToolbar2 = this.textToolbar;
            if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
                return;
            }
            textToolbar.hide();
        }
    }

    public final void onRelease() {
        this.selectionRegistrar.setSubselections(AbstractC4243wx.g());
        hideSelectionToolbar$foundation_release();
        if (getSelection() != null) {
            this.onSelectionChange.invoke(null);
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo3602performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m3611getTextHandleMove5zf0vsI());
            }
        }
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        if (layoutCoordinates == null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (layoutCoordinates.isAttached()) {
            return layoutCoordinates;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public final C2020dG selectAll$foundation_release(long j, Selection selection) {
        HapticFeedback hapticFeedback;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = listSort.size();
        Selection selectionMerge = null;
        for (int i = 0; i < size; i++) {
            Selectable selectable = listSort.get(i);
            Selection selectAllSelection = selectable.getSelectableId() == j ? selectable.getSelectAllSelection() : null;
            if (selectAllSelection != null) {
                linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), selectAllSelection);
            }
            selectionMerge = SelectionManagerKt.merge(selectionMerge, selectAllSelection);
        }
        if (!AbstractC4492zt.d(selectionMerge, selection) && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo3602performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m3611getTextHandleMove5zf0vsI());
        }
        return new C2020dG(selectionMerge, linkedHashMap);
    }

    public final void setClipboardManager(ClipboardManager clipboardManager) {
        this.clipboardManager = clipboardManager;
    }

    public final void setContainerLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.containerLayoutCoordinates = layoutCoordinates;
        if (!getHasFocus() || getSelection() == null) {
            return;
        }
        Offset offsetM2787boximpl = layoutCoordinates != null ? Offset.m2787boximpl(LayoutCoordinatesKt.positionInWindow(layoutCoordinates)) : null;
        if (AbstractC4492zt.d(this.previousPosition, offsetM2787boximpl)) {
            return;
        }
        this.previousPosition = offsetM2787boximpl;
        updateHandleOffsets();
        updateSelectionToolbarPosition();
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        AbstractC4492zt.h(focusRequester, "<set-?>");
        this.focusRequester = focusRequester;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final void setHasFocus(boolean z) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setOnSelectionChange(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "<set-?>");
        this.onSelectionChange = interfaceC3750qp;
    }

    public final void setSelection(Selection selection) {
        this._selection.setValue(selection);
        if (selection != null) {
            updateHandleOffsets();
        }
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final void setTouchMode(boolean z) {
        this.touchMode = z;
    }

    public final void showSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        if (!getHasFocus() || getSelection() == null || (textToolbar = this.textToolbar) == null) {
            return;
        }
        AbstractC3882sU.a(textToolbar, getContentRect(), new SelectionManager$showSelectionToolbar$1$1(this), null, null, null, 28, null);
    }

    /* JADX INFO: renamed from: updateSelection-3R_-tFg$foundation_release, reason: not valid java name */
    public final boolean m928updateSelection3R_tFg$foundation_release(long j, long j2, Offset offset, boolean z, SelectionAdjustment selectionAdjustment) {
        AbstractC4492zt.h(selectionAdjustment, "adjustment");
        setDraggingHandle(z ? Handle.SelectionStart : Handle.SelectionEnd);
        m916setCurrentDragPosition_kEHs6E(z ? Offset.m2787boximpl(j) : Offset.m2787boximpl(j2));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = listSort.size();
        Selection selectionMerge = null;
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            Selectable selectable = listSort.get(i);
            int i2 = i;
            Selection selection = selectionMerge;
            C2020dG c2020dGMo886updateSelectionqCDeeow = selectable.mo886updateSelectionqCDeeow(j, j2, offset, z, requireContainerCoordinates$foundation_release(), selectionAdjustment, this.selectionRegistrar.getSubselections().get(Long.valueOf(selectable.getSelectableId())));
            Selection selection2 = (Selection) c2020dGMo886updateSelectionqCDeeow.a();
            z2 = z2 || ((Boolean) c2020dGMo886updateSelectionqCDeeow.b()).booleanValue();
            if (selection2 != null) {
                linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), selection2);
            }
            selectionMerge = SelectionManagerKt.merge(selection, selection2);
            i = i2 + 1;
        }
        Selection selection3 = selectionMerge;
        if (!AbstractC4492zt.d(selection3, getSelection())) {
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo3602performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m3611getTextHandleMove5zf0vsI());
            }
            this.selectionRegistrar.setSubselections(linkedHashMap);
            this.onSelectionChange.invoke(selection3);
        }
        return z2;
    }

    /* JADX INFO: renamed from: updateSelection-RHHTvR4$foundation_release, reason: not valid java name */
    public final boolean m929updateSelectionRHHTvR4$foundation_release(Offset offset, Offset offset2, boolean z, SelectionAdjustment selectionAdjustment) {
        Selection selection;
        Offset offsetM915convertToContainerCoordinatesQ7Q5hAU;
        AbstractC4492zt.h(selectionAdjustment, "adjustment");
        if (offset == null || (selection = getSelection()) == null) {
            return false;
        }
        Selectable selectable = this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(z ? selection.getEnd().getSelectableId() : selection.getStart().getSelectableId()));
        if (selectable == null) {
            offsetM915convertToContainerCoordinatesQ7Q5hAU = null;
        } else {
            LayoutCoordinates layoutCoordinates = selectable.getLayoutCoordinates();
            AbstractC4492zt.e(layoutCoordinates);
            offsetM915convertToContainerCoordinatesQ7Q5hAU = m915convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, SelectionHandlesKt.m902getAdjustedCoordinatesk4lQ0M(selectable.mo884getHandlePositiondBAh8RU(selection, !z)));
        }
        if (offsetM915convertToContainerCoordinatesQ7Q5hAU == null) {
            return false;
        }
        long jM2808unboximpl = offsetM915convertToContainerCoordinatesQ7Q5hAU.m2808unboximpl();
        long jM2808unboximpl2 = z ? offset.m2808unboximpl() : jM2808unboximpl;
        if (!z) {
            jM2808unboximpl = offset.m2808unboximpl();
        }
        return m928updateSelection3R_tFg$foundation_release(jM2808unboximpl2, jM2808unboximpl, offset2, z, selectionAdjustment);
    }
}
