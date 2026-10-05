package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC3337lk;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ long $handleColor;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ ColorFilter $colorFilter;
        final /* synthetic */ ImageBitmap $imageBitmap;
        final /* synthetic */ float $radius;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(float f, ImageBitmap imageBitmap, ColorFilter colorFilter) {
            super(1);
            this.$radius = f;
            this.$imageBitmap = imageBitmap;
            this.$colorFilter = colorFilter;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ContentDrawScope) obj);
            return FW.a;
        }

        public final void invoke(ContentDrawScope contentDrawScope) {
            AbstractC4492zt.h(contentDrawScope, "$this$onDrawWithContent");
            contentDrawScope.drawContent();
            float f = this.$radius;
            ImageBitmap imageBitmap = this.$imageBitmap;
            ColorFilter colorFilter = this.$colorFilter;
            DrawContext drawContext = contentDrawScope.getDrawContext();
            long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
            drawContext.getCanvas().save();
            DrawTransform transform = drawContext.getTransform();
            AbstractC3337lk.g(transform, f, 0.0f, 2, null);
            transform.mo3481rotateUv8p0NA(45.0f, Offset.Companion.m2814getZeroF1C5BW0());
            AbstractC3255kk.A(contentDrawScope, imageBitmap, 0L, 0.0f, null, colorFilter, 0, 46, null);
            drawContext.getCanvas().restore();
            drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1(long j) {
        super(1);
        this.$handleColor = j;
    }

    @Override // defpackage.InterfaceC3750qp
    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
        AbstractC4492zt.h(cacheDrawScope, "$this$drawWithCache");
        float fM2867getWidthimpl = Size.m2867getWidthimpl(cacheDrawScope.m2701getSizeNHjbRc()) / 2.0f;
        return cacheDrawScope.onDrawWithContent(new AnonymousClass1(fM2867getWidthimpl, AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, fM2867getWidthimpl), ColorFilter.Companion.m3073tintxETnrds$default(ColorFilter.Companion, this.$handleColor, 0, 2, null)));
    }
}
