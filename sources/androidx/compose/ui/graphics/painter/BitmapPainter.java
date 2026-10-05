package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapPainter extends Painter {
    private float alpha;
    private ColorFilter colorFilter;
    private int filterQuality;
    private final ImageBitmap image;
    private final long size;
    private final long srcOffset;
    private final long srcSize;

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j, long j2, AbstractC0419Di abstractC0419Di) {
        this(imageBitmap, j, j2);
    }

    /* JADX INFO: renamed from: validateSize-N5eqBDc, reason: not valid java name */
    private final long m3560validateSizeN5eqBDc(long j, long j2) {
        if (IntOffset.m5278getXimpl(j) < 0 || IntOffset.m5279getYimpl(j) < 0 || IntSize.m5320getWidthimpl(j2) < 0 || IntSize.m5319getHeightimpl(j2) < 0 || IntSize.m5320getWidthimpl(j2) > this.image.getWidth() || IntSize.m5319getHeightimpl(j2) > this.image.getHeight()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        return j2;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public boolean applyAlpha(float f) {
        this.alpha = f;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public boolean applyColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitmapPainter)) {
            return false;
        }
        BitmapPainter bitmapPainter = (BitmapPainter) obj;
        return AbstractC4492zt.d(this.image, bitmapPainter.image) && IntOffset.m5277equalsimpl0(this.srcOffset, bitmapPainter.srcOffset) && IntSize.m5318equalsimpl0(this.srcSize, bitmapPainter.srcSize) && FilterQuality.m3122equalsimpl0(this.filterQuality, bitmapPainter.filterQuality);
    }

    /* JADX INFO: renamed from: getFilterQuality-f-v9h1I$ui_graphics_release, reason: not valid java name */
    public final int m3561getFilterQualityfv9h1I$ui_graphics_release() {
        return this.filterQuality;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long mo3562getIntrinsicSizeNHjbRc() {
        return IntSizeKt.m5330toSizeozmzZPI(this.size);
    }

    public int hashCode() {
        return (((((this.image.hashCode() * 31) + IntOffset.m5280hashCodeimpl(this.srcOffset)) * 31) + IntSize.m5321hashCodeimpl(this.srcSize)) * 31) + FilterQuality.m3123hashCodeimpl(this.filterQuality);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope drawScope) {
        AbstractC4492zt.h(drawScope, "<this>");
        AbstractC3255kk.z(drawScope, this.image, this.srcOffset, this.srcSize, 0L, IntSizeKt.IntSize(AbstractC1210aB.c(Size.m2867getWidthimpl(drawScope.mo3469getSizeNHjbRc())), AbstractC1210aB.c(Size.m2864getHeightimpl(drawScope.mo3469getSizeNHjbRc()))), this.alpha, null, this.colorFilter, 0, this.filterQuality, TIFFConstants.TIFFTAG_CONSECUTIVEBADFAXLINES, null);
    }

    /* JADX INFO: renamed from: setFilterQuality-vDHp3xo$ui_graphics_release, reason: not valid java name */
    public final void m3563setFilterQualityvDHp3xo$ui_graphics_release(int i) {
        this.filterQuality = i;
    }

    public String toString() {
        return "BitmapPainter(image=" + this.image + ", srcOffset=" + ((Object) IntOffset.m5285toStringimpl(this.srcOffset)) + ", srcSize=" + ((Object) IntSize.m5323toStringimpl(this.srcSize)) + ", filterQuality=" + ((Object) FilterQuality.m3124toStringimpl(this.filterQuality)) + ')';
    }

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j, long j2, int i, AbstractC0419Di abstractC0419Di) {
        this(imageBitmap, (i & 2) != 0 ? IntOffset.Companion.m5288getZeronOccac() : j, (i & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2, null);
    }

    private BitmapPainter(ImageBitmap imageBitmap, long j, long j2) {
        AbstractC4492zt.h(imageBitmap, "image");
        this.image = imageBitmap;
        this.srcOffset = j;
        this.srcSize = j2;
        this.filterQuality = FilterQuality.Companion.m3127getLowfv9h1I();
        this.size = m3560validateSizeN5eqBDc(j, j2);
        this.alpha = 1.0f;
    }
}
