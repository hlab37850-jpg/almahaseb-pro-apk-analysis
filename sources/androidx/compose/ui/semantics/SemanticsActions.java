package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SemanticsActions {
    public static final int $stable = 0;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> Collapse;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> CopyText;
    private static final SemanticsPropertyKey<List<CustomAccessibilityAction>> CustomActions;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> CutText;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> Dismiss;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> Expand;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3750qp>> GetTextLayoutResult;
    public static final SemanticsActions INSTANCE = new SemanticsActions();
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3750qp>> InsertTextAtCursor;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> OnClick;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> OnLongClick;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> PageDown;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> PageLeft;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> PageRight;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> PageUp;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> PasteText;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> PerformImeAction;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> RequestFocus;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC0526Fp>> ScrollBy;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3750qp>> ScrollToIndex;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3750qp>> SetProgress;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC0552Gp>> SetSelection;
    private static final SemanticsPropertyKey<AccessibilityAction<InterfaceC3750qp>> SetText;

    static {
        SemanticsPropertiesKt.AnonymousClass1 anonymousClass1 = SemanticsPropertiesKt.AnonymousClass1.INSTANCE;
        GetTextLayoutResult = new SemanticsPropertyKey<>("GetTextLayoutResult", anonymousClass1);
        OnClick = new SemanticsPropertyKey<>("OnClick", anonymousClass1);
        OnLongClick = new SemanticsPropertyKey<>("OnLongClick", anonymousClass1);
        ScrollBy = new SemanticsPropertyKey<>("ScrollBy", anonymousClass1);
        ScrollToIndex = new SemanticsPropertyKey<>("ScrollToIndex", anonymousClass1);
        SetProgress = new SemanticsPropertyKey<>("SetProgress", anonymousClass1);
        SetSelection = new SemanticsPropertyKey<>("SetSelection", anonymousClass1);
        SetText = new SemanticsPropertyKey<>("SetText", anonymousClass1);
        InsertTextAtCursor = new SemanticsPropertyKey<>("InsertTextAtCursor", anonymousClass1);
        PerformImeAction = new SemanticsPropertyKey<>("PerformImeAction", anonymousClass1);
        CopyText = new SemanticsPropertyKey<>("CopyText", anonymousClass1);
        CutText = new SemanticsPropertyKey<>("CutText", anonymousClass1);
        PasteText = new SemanticsPropertyKey<>("PasteText", anonymousClass1);
        Expand = new SemanticsPropertyKey<>("Expand", anonymousClass1);
        Collapse = new SemanticsPropertyKey<>("Collapse", anonymousClass1);
        Dismiss = new SemanticsPropertyKey<>("Dismiss", anonymousClass1);
        RequestFocus = new SemanticsPropertyKey<>("RequestFocus", anonymousClass1);
        CustomActions = new SemanticsPropertyKey<>("CustomActions", null, 2, null);
        PageUp = new SemanticsPropertyKey<>("PageUp", anonymousClass1);
        PageLeft = new SemanticsPropertyKey<>("PageLeft", anonymousClass1);
        PageDown = new SemanticsPropertyKey<>("PageDown", anonymousClass1);
        PageRight = new SemanticsPropertyKey<>("PageRight", anonymousClass1);
    }

    private SemanticsActions() {
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getCollapse() {
        return Collapse;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getCopyText() {
        return CopyText;
    }

    public final SemanticsPropertyKey<List<CustomAccessibilityAction>> getCustomActions() {
        return CustomActions;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getCutText() {
        return CutText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getDismiss() {
        return Dismiss;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getExpand() {
        return Expand;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3750qp>> getGetTextLayoutResult() {
        return GetTextLayoutResult;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3750qp>> getInsertTextAtCursor() {
        return InsertTextAtCursor;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getOnClick() {
        return OnClick;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getOnLongClick() {
        return OnLongClick;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getPageDown() {
        return PageDown;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getPageLeft() {
        return PageLeft;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getPageRight() {
        return PageRight;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getPageUp() {
        return PageUp;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getPasteText() {
        return PasteText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getPerformImeAction() {
        return PerformImeAction;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3588op>> getRequestFocus() {
        return RequestFocus;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC0526Fp>> getScrollBy() {
        return ScrollBy;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3750qp>> getScrollToIndex() {
        return ScrollToIndex;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3750qp>> getSetProgress() {
        return SetProgress;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC0552Gp>> getSetSelection() {
        return SetSelection;
    }

    public final SemanticsPropertyKey<AccessibilityAction<InterfaceC3750qp>> getSetText() {
        return SetText;
    }
}
