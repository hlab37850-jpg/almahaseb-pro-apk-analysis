package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntSizeKt;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class VectorComponent extends VNode {
    private final DrawCache cacheDrawScope;
    private final InterfaceC3750qp drawVectorBlock;
    private final MutableState intrinsicColorFilter$delegate;
    private InterfaceC3588op invalidateCallback;
    private boolean isDirty;
    private long previousDrawSize;
    private final GroupComponent root;
    private float viewportHeight;
    private float viewportWidth;

    public VectorComponent() {
        super(null);
        GroupComponent groupComponent = new GroupComponent();
        groupComponent.setPivotX(0.0f);
        groupComponent.setPivotY(0.0f);
        groupComponent.setInvalidateListener$ui_release(new VectorComponent$root$1$1(this));
        this.root = groupComponent;
        this.isDirty = true;
        this.cacheDrawScope = new DrawCache();
        this.invalidateCallback = VectorComponent$invalidateCallback$1.INSTANCE;
        this.intrinsicColorFilter$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.previousDrawSize = Size.Companion.m2875getUnspecifiedNHjbRc();
        this.drawVectorBlock = new VectorComponent$drawVectorBlock$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doInvalidate() {
        this.isDirty = true;
        this.invalidateCallback.invoke();
    }

    public final void draw(DrawScope drawScope, float f, ColorFilter colorFilter) {
        AbstractC4492zt.h(drawScope, "<this>");
        if (colorFilter == null) {
            colorFilter = getIntrinsicColorFilter$ui_release();
        }
        if (this.isDirty || !Size.m2863equalsimpl0(this.previousDrawSize, drawScope.mo3469getSizeNHjbRc())) {
            this.root.setScaleX(Size.m2867getWidthimpl(drawScope.mo3469getSizeNHjbRc()) / this.viewportWidth);
            this.root.setScaleY(Size.m2864getHeightimpl(drawScope.mo3469getSizeNHjbRc()) / this.viewportHeight);
            this.cacheDrawScope.m3569drawCachedImageCJJARo(IntSizeKt.IntSize((int) Math.ceil(Size.m2867getWidthimpl(drawScope.mo3469getSizeNHjbRc())), (int) Math.ceil(Size.m2864getHeightimpl(drawScope.mo3469getSizeNHjbRc()))), drawScope, drawScope.getLayoutDirection(), this.drawVectorBlock);
            this.isDirty = false;
            this.previousDrawSize = drawScope.mo3469getSizeNHjbRc();
        }
        this.cacheDrawScope.drawInto(drawScope, f, colorFilter);
    }

    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return (ColorFilter) this.intrinsicColorFilter$delegate.getValue();
    }

    public final InterfaceC3588op getInvalidateCallback$ui_release() {
        return this.invalidateCallback;
    }

    public final String getName() {
        return this.root.getName();
    }

    public final GroupComponent getRoot() {
        return this.root;
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public final void setIntrinsicColorFilter$ui_release(ColorFilter colorFilter) {
        this.intrinsicColorFilter$delegate.setValue(colorFilter);
    }

    public final void setInvalidateCallback$ui_release(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "<set-?>");
        this.invalidateCallback = interfaceC3588op;
    }

    public final void setName(String str) {
        AbstractC4492zt.h(str, "value");
        this.root.setName(str);
    }

    public final void setViewportHeight(float f) {
        if (this.viewportHeight == f) {
            return;
        }
        this.viewportHeight = f;
        doInvalidate();
    }

    public final void setViewportWidth(float f) {
        if (this.viewportWidth == f) {
            return;
        }
        this.viewportWidth = f;
        doInvalidate();
    }

    public String toString() {
        String str = "Params: \tname: " + getName() + StringUtilities.LF + "\tviewportWidth: " + this.viewportWidth + StringUtilities.LF + "\tviewportHeight: " + this.viewportHeight + StringUtilities.LF;
        AbstractC4492zt.g(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(DrawScope drawScope) {
        AbstractC4492zt.h(drawScope, "<this>");
        draw(drawScope, 1.0f, null);
    }
}
