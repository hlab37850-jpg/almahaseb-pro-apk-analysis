package androidx.compose.ui.platform;

import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public final class RenderNodeLayer implements OwnedLayer, GraphicLayerInfo {
    public static final Companion Companion = new Companion(null);
    private static final InterfaceC0526Fp getMatrix = RenderNodeLayer$Companion$getMatrix$1.INSTANCE;
    private final CanvasHolder canvasHolder;
    private InterfaceC3750qp drawBlock;
    private boolean drawnWithZ;
    private InterfaceC3588op invalidateParentLayer;
    private boolean isDestroyed;
    private boolean isDirty;
    private final LayerMatrixCache<DeviceRenderNode> matrixCache;
    private final OutlineResolver outlineResolver;
    private final AndroidComposeView ownerView;
    private final DeviceRenderNode renderNode;
    private Paint softwareLayerPaint;
    private long transformOrigin;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

    @RequiresApi(29)
    public static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @DoNotInline
        public static final long getUniqueDrawingId(View view) {
            AbstractC4492zt.h(view, "view");
            return view.getUniqueDrawingId();
        }
    }

    public RenderNodeLayer(AndroidComposeView androidComposeView, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(androidComposeView, "ownerView");
        AbstractC4492zt.h(interfaceC3750qp, "drawBlock");
        AbstractC4492zt.h(interfaceC3588op, "invalidateParentLayer");
        this.ownerView = androidComposeView;
        this.drawBlock = interfaceC3750qp;
        this.invalidateParentLayer = interfaceC3588op;
        this.outlineResolver = new OutlineResolver(androidComposeView.getDensity());
        this.matrixCache = new LayerMatrixCache<>(getMatrix);
        this.canvasHolder = new CanvasHolder();
        this.transformOrigin = TransformOrigin.Companion.m3394getCenterSzJe1aQ();
        DeviceRenderNode renderNodeApi29 = Build.VERSION.SDK_INT >= 29 ? new RenderNodeApi29(androidComposeView) : new RenderNodeApi23(androidComposeView);
        renderNodeApi29.setHasOverlappingRendering(true);
        this.renderNode = renderNodeApi29;
    }

    private final void clipRenderNode(Canvas canvas) {
        if (this.renderNode.getClipToOutline() || this.renderNode.getClipToBounds()) {
            this.outlineResolver.clipToOutline(canvas);
        }
    }

    private final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    private final void triggerRepaint() {
        if (Build.VERSION.SDK_INT >= 26) {
            WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
        } else {
            this.ownerView.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        if (this.renderNode.getHasDisplayList()) {
            this.renderNode.discardDisplayList();
        }
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        this.ownerView.requestClearInvalidObservations();
        this.ownerView.recycle$ui_release(this);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas) {
        AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            boolean z = this.renderNode.getElevation() > 0.0f;
            this.drawnWithZ = z;
            if (z) {
                canvas.enableZ();
            }
            this.renderNode.drawInto(nativeCanvas);
            if (this.drawnWithZ) {
                canvas.disableZ();
                return;
            }
            return;
        }
        float left = this.renderNode.getLeft();
        float top = this.renderNode.getTop();
        float right = this.renderNode.getRight();
        float bottom = this.renderNode.getBottom();
        if (this.renderNode.getAlpha() < 1.0f) {
            Paint Paint = this.softwareLayerPaint;
            if (Paint == null) {
                Paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = Paint;
            }
            Paint.setAlpha(this.renderNode.getAlpha());
            nativeCanvas.saveLayer(left, top, right, bottom, Paint.asFrameworkPaint());
        } else {
            canvas.save();
        }
        canvas.translate(left, top);
        canvas.mo2895concat58bKbWc(this.matrixCache.m4499calculateMatrixGrdbGEg(this.renderNode));
        clipRenderNode(canvas);
        InterfaceC3750qp interfaceC3750qp = this.drawBlock;
        if (interfaceC3750qp != null) {
            interfaceC3750qp.invoke(canvas);
        }
        canvas.restore();
        setDirty(false);
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.renderNode.getUniqueId();
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1L;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: inverseTransform-58bKbWc */
    public void mo4423inverseTransform58bKbWc(float[] fArr) {
        AbstractC4492zt.h(fArr, "matrix");
        float[] fArrM4498calculateInverseMatrixbWbORWo = this.matrixCache.m4498calculateInverseMatrixbWbORWo(this.renderNode);
        if (fArrM4498calculateInverseMatrixbWbORWo != null) {
            Matrix.m3254timesAssign58bKbWc(fArr, fArrM4498calculateInverseMatrixbWbORWo);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: isInLayer-k-4lQ0M */
    public boolean mo4424isInLayerk4lQ0M(long j) {
        float fM2798getXimpl = Offset.m2798getXimpl(j);
        float fM2799getYimpl = Offset.m2799getYimpl(j);
        if (this.renderNode.getClipToBounds()) {
            return 0.0f <= fM2798getXimpl && fM2798getXimpl < ((float) this.renderNode.getWidth()) && 0.0f <= fM2799getYimpl && fM2799getYimpl < ((float) this.renderNode.getHeight());
        }
        if (this.renderNode.getClipToOutline()) {
            return this.outlineResolver.m4521isInOutlinek4lQ0M(j);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect mutableRect, boolean z) {
        AbstractC4492zt.h(mutableRect, "rect");
        if (!z) {
            Matrix.m3245mapimpl(this.matrixCache.m4499calculateMatrixGrdbGEg(this.renderNode), mutableRect);
            return;
        }
        float[] fArrM4498calculateInverseMatrixbWbORWo = this.matrixCache.m4498calculateInverseMatrixbWbORWo(this.renderNode);
        if (fArrM4498calculateInverseMatrixbWbORWo == null) {
            mutableRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            Matrix.m3245mapimpl(fArrM4498calculateInverseMatrixbWbORWo, mutableRect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: mapOffset-8S9VItk */
    public long mo4425mapOffset8S9VItk(long j, boolean z) {
        if (!z) {
            return Matrix.m3243mapMKHz9U(this.matrixCache.m4499calculateMatrixGrdbGEg(this.renderNode), j);
        }
        float[] fArrM4498calculateInverseMatrixbWbORWo = this.matrixCache.m4498calculateInverseMatrixbWbORWo(this.renderNode);
        return fArrM4498calculateInverseMatrixbWbORWo != null ? Matrix.m3243mapMKHz9U(fArrM4498calculateInverseMatrixbWbORWo, j) : Offset.Companion.m2812getInfiniteF1C5BW0();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: move--gyyYBs */
    public void mo4426movegyyYBs(long j) {
        int left = this.renderNode.getLeft();
        int top = this.renderNode.getTop();
        int iM5278getXimpl = IntOffset.m5278getXimpl(j);
        int iM5279getYimpl = IntOffset.m5279getYimpl(j);
        if (left == iM5278getXimpl && top == iM5279getYimpl) {
            return;
        }
        if (left != iM5278getXimpl) {
            this.renderNode.offsetLeftAndRight(iM5278getXimpl - left);
        }
        if (top != iM5279getYimpl) {
            this.renderNode.offsetTopAndBottom(iM5279getYimpl - top);
        }
        triggerRepaint();
        this.matrixCache.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: resize-ozmzZPI */
    public void mo4427resizeozmzZPI(long j) {
        int iM5320getWidthimpl = IntSize.m5320getWidthimpl(j);
        int iM5319getHeightimpl = IntSize.m5319getHeightimpl(j);
        float f = iM5320getWidthimpl;
        this.renderNode.setPivotX(TransformOrigin.m3389getPivotFractionXimpl(this.transformOrigin) * f);
        float f2 = iM5319getHeightimpl;
        this.renderNode.setPivotY(TransformOrigin.m3390getPivotFractionYimpl(this.transformOrigin) * f2);
        DeviceRenderNode deviceRenderNode = this.renderNode;
        if (deviceRenderNode.setPosition(deviceRenderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getLeft() + iM5320getWidthimpl, this.renderNode.getTop() + iM5319getHeightimpl)) {
            this.outlineResolver.m4522updateuvyYCjk(SizeKt.Size(f, f2));
            this.renderNode.setOutline(this.outlineResolver.getOutline());
            invalidate();
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3750qp, "drawBlock");
        AbstractC4492zt.h(interfaceC3588op, "invalidateParentLayer");
        setDirty(false);
        this.isDestroyed = false;
        this.drawnWithZ = false;
        this.transformOrigin = TransformOrigin.Companion.m3394getCenterSzJe1aQ();
        this.drawBlock = interfaceC3750qp;
        this.invalidateParentLayer = interfaceC3588op;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: transform-58bKbWc */
    public void mo4428transform58bKbWc(float[] fArr) {
        AbstractC4492zt.h(fArr, "matrix");
        Matrix.m3254timesAssign58bKbWc(fArr, this.matrixCache.m4499calculateMatrixGrdbGEg(this.renderNode));
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.isDirty || !this.renderNode.getHasDisplayList()) {
            setDirty(false);
            Path clipPath = (!this.renderNode.getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) ? null : this.outlineResolver.getClipPath();
            InterfaceC3750qp interfaceC3750qp = this.drawBlock;
            if (interfaceC3750qp != null) {
                this.renderNode.record(this.canvasHolder, clipPath, interfaceC3750qp);
            }
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: updateLayerProperties-dDxr-wY */
    public void mo4429updateLayerPropertiesdDxrwY(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, LayoutDirection layoutDirection, Density density) {
        InterfaceC3588op interfaceC3588op;
        AbstractC4492zt.h(shape, "shape");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        AbstractC4492zt.h(density, "density");
        this.transformOrigin = j;
        boolean z2 = false;
        boolean z3 = this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported();
        this.renderNode.setScaleX(f);
        this.renderNode.setScaleY(f2);
        this.renderNode.setAlpha(f3);
        this.renderNode.setTranslationX(f4);
        this.renderNode.setTranslationY(f5);
        this.renderNode.setElevation(f6);
        this.renderNode.setAmbientShadowColor(ColorKt.m3086toArgb8_81llA(j2));
        this.renderNode.setSpotShadowColor(ColorKt.m3086toArgb8_81llA(j3));
        this.renderNode.setRotationZ(f9);
        this.renderNode.setRotationX(f7);
        this.renderNode.setRotationY(f8);
        this.renderNode.setCameraDistance(f10);
        this.renderNode.setPivotX(TransformOrigin.m3389getPivotFractionXimpl(j) * this.renderNode.getWidth());
        this.renderNode.setPivotY(TransformOrigin.m3390getPivotFractionYimpl(j) * this.renderNode.getHeight());
        this.renderNode.setClipToOutline(z && shape != RectangleShapeKt.getRectangleShape());
        this.renderNode.setClipToBounds(z && shape == RectangleShapeKt.getRectangleShape());
        this.renderNode.setRenderEffect(renderEffect);
        this.renderNode.mo4482setCompositingStrategyaDBOjCE(i);
        boolean zUpdate = this.outlineResolver.update(shape, this.renderNode.getAlpha(), this.renderNode.getClipToOutline(), this.renderNode.getElevation(), layoutDirection, density);
        this.renderNode.setOutline(this.outlineResolver.getOutline());
        if (this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported()) {
            z2 = true;
        }
        if (z3 != z2 || (z2 && zUpdate)) {
            invalidate();
        } else {
            triggerRepaint();
        }
        if (!this.drawnWithZ && this.renderNode.getElevation() > 0.0f && (interfaceC3588op = this.invalidateParentLayer) != null) {
            interfaceC3588op.invoke();
        }
        this.matrixCache.invalidate();
    }
}
