package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.BasicText_androidKt;
import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionController implements RememberObserver {
    private final long backgroundSelectionColor;
    private final Modifier modifier;
    private StaticTextSelectionParams params;
    private Selectable selectable;
    private final long selectableId;
    private final SelectionRegistrar selectionRegistrar;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.modifiers.SelectionController$onRemembered$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public AnonymousClass1() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final LayoutCoordinates invoke() {
            return SelectionController.this.params.getLayoutCoordinates();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.modifiers.SelectionController$onRemembered$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        public AnonymousClass2() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final TextLayoutResult invoke() {
            return SelectionController.this.params.getTextLayoutResult();
        }
    }

    public /* synthetic */ SelectionController(SelectionRegistrar selectionRegistrar, long j, StaticTextSelectionParams staticTextSelectionParams, AbstractC0419Di abstractC0419Di) {
        this(selectionRegistrar, j, staticTextSelectionParams);
    }

    public final void draw(DrawScope drawScope) {
        AbstractC4492zt.h(drawScope, "drawScope");
        Selection selection = this.selectionRegistrar.getSubselections().get(Long.valueOf(this.selectableId));
        if (selection == null) {
            return;
        }
        int offset = !selection.getHandlesCrossed() ? selection.getStart().getOffset() : selection.getEnd().getOffset();
        int offset2 = !selection.getHandlesCrossed() ? selection.getEnd().getOffset() : selection.getStart().getOffset();
        if (offset == offset2) {
            return;
        }
        Selectable selectable = this.selectable;
        int lastVisibleOffset = selectable != null ? selectable.getLastVisibleOffset() : 0;
        Path pathForRange = this.params.getPathForRange(AbstractC3871sJ.g(offset, lastVisibleOffset), AbstractC3871sJ.g(offset2, lastVisibleOffset));
        if (pathForRange == null) {
            return;
        }
        if (!this.params.getShouldClip()) {
            AbstractC3255kk.G(drawScope, pathForRange, this.backgroundSelectionColor, 0.0f, null, null, 0, 60, null);
            return;
        }
        float fM2867getWidthimpl = Size.m2867getWidthimpl(drawScope.mo3469getSizeNHjbRc());
        float fM2864getHeightimpl = Size.m2864getHeightimpl(drawScope.mo3469getSizeNHjbRc());
        int iM3021getIntersectrtfAjoo = ClipOp.Companion.m3021getIntersectrtfAjoo();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3478clipRectN_I0leg(0.0f, 0.0f, fM2867getWidthimpl, fM2864getHeightimpl, iM3021getIntersectrtfAjoo);
        AbstractC3255kk.G(drawScope, pathForRange, this.backgroundSelectionColor, 0.0f, null, null, 0, 60, null);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        Selectable selectable = this.selectable;
        if (selectable != null) {
            this.selectionRegistrar.unsubscribe(selectable);
            this.selectable = null;
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        Selectable selectable = this.selectable;
        if (selectable != null) {
            this.selectionRegistrar.unsubscribe(selectable);
            this.selectable = null;
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.selectable = this.selectionRegistrar.subscribe(new MultiWidgetSelectionDelegate(this.selectableId, new AnonymousClass1(), new AnonymousClass2()));
    }

    public final void updateGlobalPosition(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "coordinates");
        this.params = StaticTextSelectionParams.copy$default(this.params, layoutCoordinates, null, 2, null);
    }

    public final void updateTextLayout(TextLayoutResult textLayoutResult) {
        AbstractC4492zt.h(textLayoutResult, "textLayoutResult");
        this.params = StaticTextSelectionParams.copy$default(this.params, null, textLayoutResult, 1, null);
    }

    private SelectionController(SelectionRegistrar selectionRegistrar, long j, StaticTextSelectionParams staticTextSelectionParams) {
        AbstractC4492zt.h(selectionRegistrar, "selectionRegistrar");
        AbstractC4492zt.h(staticTextSelectionParams, "params");
        this.selectionRegistrar = selectionRegistrar;
        this.backgroundSelectionColor = j;
        this.params = staticTextSelectionParams;
        long jNextSelectableId = selectionRegistrar.nextSelectableId();
        this.selectableId = jNextSelectableId;
        this.modifier = BasicText_androidKt.textPointerHoverIcon(SelectionControllerKt.makeSelectionModifier(selectionRegistrar, jNextSelectableId, new SelectionController$modifier$1(this), new SelectionController$modifier$2(this), TouchMode_androidKt.isInTouchMode()), selectionRegistrar);
    }

    public /* synthetic */ SelectionController(SelectionRegistrar selectionRegistrar, long j, StaticTextSelectionParams staticTextSelectionParams, int i, AbstractC0419Di abstractC0419Di) {
        this(selectionRegistrar, j, (i & 4) != 0 ? StaticTextSelectionParams.Companion.getEmpty() : staticTextSelectionParams, null);
    }
}
