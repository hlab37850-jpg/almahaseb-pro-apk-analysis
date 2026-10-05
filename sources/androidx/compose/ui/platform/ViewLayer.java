package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Matrix;
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
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ViewLayer extends View implements OwnedLayer, GraphicLayerInfo {
    private static boolean hasRetrievedMethod;
    private static Field recreateDisplayList;
    private static boolean shouldUseDispatchDraw;
    private static Method updateDisplayListIfDirtyMethod;
    private final CanvasHolder canvasHolder;
    private Rect clipBoundsCache;
    private boolean clipToBounds;
    private final DrawChildContainer container;
    private InterfaceC3750qp drawBlock;
    private boolean drawnWithZ;
    private InterfaceC3588op invalidateParentLayer;
    private boolean isInvalidated;
    private final long layerId;
    private boolean mHasOverlappingRendering;
    private long mTransformOrigin;
    private final LayerMatrixCache<View> matrixCache;
    private final OutlineResolver outlineResolver;
    private final AndroidComposeView ownerView;
    public static final Companion Companion = new Companion(null);
    private static final InterfaceC0526Fp getMatrix = ViewLayer$Companion$getMatrix$1.INSTANCE;
    private static final ViewOutlineProvider OutlineProvider = new ViewOutlineProvider() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$OutlineProvider$1
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            AbstractC4492zt.h(view, "view");
            AbstractC4492zt.h(outline, "outline");
            Outline outline2 = ((ViewLayer) view).outlineResolver.getOutline();
            AbstractC4492zt.e(outline2);
            outline.set(outline2);
        }
    };

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final boolean getHasRetrievedMethod() {
            return ViewLayer.hasRetrievedMethod;
        }

        public final ViewOutlineProvider getOutlineProvider() {
            return ViewLayer.OutlineProvider;
        }

        public final boolean getShouldUseDispatchDraw() {
            return ViewLayer.shouldUseDispatchDraw;
        }

        public final void setShouldUseDispatchDraw$ui_release(boolean z) {
            ViewLayer.shouldUseDispatchDraw = z;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public final void updateDisplayList(View view) {
            AbstractC4492zt.h(view, "view");
            try {
                if (!getHasRetrievedMethod()) {
                    ViewLayer.hasRetrievedMethod = true;
                    if (Build.VERSION.SDK_INT < 28) {
                        ViewLayer.updateDisplayListIfDirtyMethod = View.class.getDeclaredMethod("updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.recreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                    } else {
                        ViewLayer.updateDisplayListIfDirtyMethod = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass()).invoke(View.class, "updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.recreateDisplayList = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(View.class, "mRecreateDisplayList");
                    }
                    Method method = ViewLayer.updateDisplayListIfDirtyMethod;
                    if (method != null) {
                        method.setAccessible(true);
                    }
                    Field field = ViewLayer.recreateDisplayList;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                }
                Field field2 = ViewLayer.recreateDisplayList;
                if (field2 != null) {
                    field2.setBoolean(view, true);
                }
                Method method2 = ViewLayer.updateDisplayListIfDirtyMethod;
                if (method2 != null) {
                    method2.invoke(view, new Object[0]);
                }
            } catch (Throwable unused) {
                setShouldUseDispatchDraw$ui_release(true);
            }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewLayer(AndroidComposeView androidComposeView, DrawChildContainer drawChildContainer, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op) {
        super(androidComposeView.getContext());
        AbstractC4492zt.h(androidComposeView, "ownerView");
        AbstractC4492zt.h(drawChildContainer, "container");
        AbstractC4492zt.h(interfaceC3750qp, "drawBlock");
        AbstractC4492zt.h(interfaceC3588op, "invalidateParentLayer");
        this.ownerView = androidComposeView;
        this.container = drawChildContainer;
        this.drawBlock = interfaceC3750qp;
        this.invalidateParentLayer = interfaceC3588op;
        this.outlineResolver = new OutlineResolver(androidComposeView.getDensity());
        this.canvasHolder = new CanvasHolder();
        this.matrixCache = new LayerMatrixCache<>(getMatrix);
        this.mTransformOrigin = TransformOrigin.Companion.m3394getCenterSzJe1aQ();
        this.mHasOverlappingRendering = true;
        setWillNotDraw(false);
        drawChildContainer.addView(this);
        this.layerId = View.generateViewId();
    }

    private final Path getManualClipPath() {
        if (!getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
            return null;
        }
        return this.outlineResolver.getClipPath();
    }

    private final void resetClipBounds() {
        Rect rect;
        if (this.clipToBounds) {
            Rect rect2 = this.clipBoundsCache;
            if (rect2 == null) {
                this.clipBoundsCache = new Rect(0, 0, getWidth(), getHeight());
            } else {
                AbstractC4492zt.e(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.clipBoundsCache;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    private final void setInvalidated(boolean z) {
        if (z != this.isInvalidated) {
            this.isInvalidated = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    private final void updateOutlineResolver() {
        setOutlineProvider(this.outlineResolver.getOutline() != null ? OutlineProvider : null);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        setInvalidated(false);
        this.ownerView.requestClearInvalidObservations();
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        boolean zRecycle$ui_release = this.ownerView.recycle$ui_release(this);
        if (Build.VERSION.SDK_INT >= 23 || shouldUseDispatchDraw || !zRecycle$ui_release) {
            this.container.removeViewInLayout(this);
        } else {
            setVisibility(8);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
        boolean z = false;
        setInvalidated(false);
        CanvasHolder canvasHolder = this.canvasHolder;
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (getManualClipPath() != null || !canvas.isHardwareAccelerated()) {
            androidCanvas.save();
            this.outlineResolver.clipToOutline(androidCanvas);
            z = true;
        }
        InterfaceC3750qp interfaceC3750qp = this.drawBlock;
        if (interfaceC3750qp != null) {
            interfaceC3750qp.invoke(androidCanvas);
        }
        if (z) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(androidx.compose.ui.graphics.Canvas canvas) {
        AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
        boolean z = getElevation() > 0.0f;
        this.drawnWithZ = z;
        if (z) {
            canvas.enableZ();
        }
        this.container.drawChild$ui_release(canvas, this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.disableZ();
        }
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / getResources().getDisplayMetrics().densityDpi;
    }

    public final DrawChildContainer getContainer() {
        return this.container;
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.layerId;
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

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    @Override // android.view.View, androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isInvalidated) {
            return;
        }
        setInvalidated(true);
        super.invalidate();
        this.ownerView.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: inverseTransform-58bKbWc */
    public void mo4423inverseTransform58bKbWc(float[] fArr) {
        AbstractC4492zt.h(fArr, "matrix");
        float[] fArrM4498calculateInverseMatrixbWbORWo = this.matrixCache.m4498calculateInverseMatrixbWbORWo(this);
        if (fArrM4498calculateInverseMatrixbWbORWo != null) {
            Matrix.m3254timesAssign58bKbWc(fArr, fArrM4498calculateInverseMatrixbWbORWo);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: isInLayer-k-4lQ0M */
    public boolean mo4424isInLayerk4lQ0M(long j) {
        float fM2798getXimpl = Offset.m2798getXimpl(j);
        float fM2799getYimpl = Offset.m2799getYimpl(j);
        if (this.clipToBounds) {
            return 0.0f <= fM2798getXimpl && fM2798getXimpl < ((float) getWidth()) && 0.0f <= fM2799getYimpl && fM2799getYimpl < ((float) getHeight());
        }
        if (getClipToOutline()) {
            return this.outlineResolver.m4521isInOutlinek4lQ0M(j);
        }
        return true;
    }

    public final boolean isInvalidated() {
        return this.isInvalidated;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect mutableRect, boolean z) {
        AbstractC4492zt.h(mutableRect, "rect");
        if (!z) {
            Matrix.m3245mapimpl(this.matrixCache.m4499calculateMatrixGrdbGEg(this), mutableRect);
            return;
        }
        float[] fArrM4498calculateInverseMatrixbWbORWo = this.matrixCache.m4498calculateInverseMatrixbWbORWo(this);
        if (fArrM4498calculateInverseMatrixbWbORWo != null) {
            Matrix.m3245mapimpl(fArrM4498calculateInverseMatrixbWbORWo, mutableRect);
        } else {
            mutableRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: mapOffset-8S9VItk */
    public long mo4425mapOffset8S9VItk(long j, boolean z) {
        if (!z) {
            return Matrix.m3243mapMKHz9U(this.matrixCache.m4499calculateMatrixGrdbGEg(this), j);
        }
        float[] fArrM4498calculateInverseMatrixbWbORWo = this.matrixCache.m4498calculateInverseMatrixbWbORWo(this);
        return fArrM4498calculateInverseMatrixbWbORWo != null ? Matrix.m3243mapMKHz9U(fArrM4498calculateInverseMatrixbWbORWo, j) : Offset.Companion.m2812getInfiniteF1C5BW0();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: move--gyyYBs */
    public void mo4426movegyyYBs(long j) {
        int iM5278getXimpl = IntOffset.m5278getXimpl(j);
        if (iM5278getXimpl != getLeft()) {
            offsetLeftAndRight(iM5278getXimpl - getLeft());
            this.matrixCache.invalidate();
        }
        int iM5279getYimpl = IntOffset.m5279getYimpl(j);
        if (iM5279getYimpl != getTop()) {
            offsetTopAndBottom(iM5279getYimpl - getTop());
            this.matrixCache.invalidate();
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: resize-ozmzZPI */
    public void mo4427resizeozmzZPI(long j) {
        int iM5320getWidthimpl = IntSize.m5320getWidthimpl(j);
        int iM5319getHeightimpl = IntSize.m5319getHeightimpl(j);
        if (iM5320getWidthimpl == getWidth() && iM5319getHeightimpl == getHeight()) {
            return;
        }
        float f = iM5320getWidthimpl;
        setPivotX(TransformOrigin.m3389getPivotFractionXimpl(this.mTransformOrigin) * f);
        float f2 = iM5319getHeightimpl;
        setPivotY(TransformOrigin.m3390getPivotFractionYimpl(this.mTransformOrigin) * f2);
        this.outlineResolver.m4522updateuvyYCjk(SizeKt.Size(f, f2));
        updateOutlineResolver();
        layout(getLeft(), getTop(), getLeft() + iM5320getWidthimpl, getTop() + iM5319getHeightimpl);
        resetClipBounds();
        this.matrixCache.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3750qp, "drawBlock");
        AbstractC4492zt.h(interfaceC3588op, "invalidateParentLayer");
        if (Build.VERSION.SDK_INT >= 23 || shouldUseDispatchDraw) {
            this.container.addView(this);
        } else {
            setVisibility(0);
        }
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = TransformOrigin.Companion.m3394getCenterSzJe1aQ();
        this.drawBlock = interfaceC3750qp;
        this.invalidateParentLayer = interfaceC3588op;
    }

    public final void setCameraDistancePx(float f) {
        setCameraDistance(f * getResources().getDisplayMetrics().densityDpi);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: transform-58bKbWc */
    public void mo4428transform58bKbWc(float[] fArr) {
        AbstractC4492zt.h(fArr, "matrix");
        Matrix.m3254timesAssign58bKbWc(fArr, this.matrixCache.m4499calculateMatrixGrdbGEg(this));
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (!this.isInvalidated || shouldUseDispatchDraw) {
            return;
        }
        setInvalidated(false);
        Companion.updateDisplayList(this);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: updateLayerProperties-dDxr-wY */
    public void mo4429updateLayerPropertiesdDxrwY(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, LayoutDirection layoutDirection, Density density) {
        InterfaceC3588op interfaceC3588op;
        AbstractC4492zt.h(shape, "shape");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        AbstractC4492zt.h(density, "density");
        this.mTransformOrigin = j;
        setScaleX(f);
        setScaleY(f2);
        setAlpha(f3);
        setTranslationX(f4);
        setTranslationY(f5);
        setElevation(f6);
        setRotation(f9);
        setRotationX(f7);
        setRotationY(f8);
        setPivotX(TransformOrigin.m3389getPivotFractionXimpl(this.mTransformOrigin) * getWidth());
        setPivotY(TransformOrigin.m3390getPivotFractionYimpl(this.mTransformOrigin) * getHeight());
        setCameraDistancePx(f10);
        boolean z2 = true;
        this.clipToBounds = z && shape == RectangleShapeKt.getRectangleShape();
        resetClipBounds();
        boolean z3 = getManualClipPath() != null;
        setClipToOutline(z && shape != RectangleShapeKt.getRectangleShape());
        boolean zUpdate = this.outlineResolver.update(shape, getAlpha(), getClipToOutline(), getElevation(), layoutDirection, density);
        updateOutlineResolver();
        boolean z4 = getManualClipPath() != null;
        if (z3 != z4 || (z4 && zUpdate)) {
            invalidate();
        }
        if (!this.drawnWithZ && getElevation() > 0.0f && (interfaceC3588op = this.invalidateParentLayer) != null) {
            interfaceC3588op.invoke();
        }
        this.matrixCache.invalidate();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            ViewLayerVerificationHelper28 viewLayerVerificationHelper28 = ViewLayerVerificationHelper28.INSTANCE;
            viewLayerVerificationHelper28.setOutlineAmbientShadowColor(this, ColorKt.m3086toArgb8_81llA(j2));
            viewLayerVerificationHelper28.setOutlineSpotShadowColor(this, ColorKt.m3086toArgb8_81llA(j3));
        }
        if (i2 >= 31) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this, renderEffect);
        }
        CompositingStrategy.Companion companion = CompositingStrategy.Companion;
        if (CompositingStrategy.m3112equalsimpl0(i, companion.m3118getOffscreenNrFUSI())) {
            setLayerType(2, null);
        } else if (CompositingStrategy.m3112equalsimpl0(i, companion.m3117getModulateAlphaNrFUSI())) {
            setLayerType(0, null);
            z2 = false;
        } else {
            setLayerType(0, null);
        }
        this.mHasOverlappingRendering = z2;
    }
}
