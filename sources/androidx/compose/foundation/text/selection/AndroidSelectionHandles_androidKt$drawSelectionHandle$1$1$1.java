package androidx.compose.foundation.text.selection;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ ResolvedTextDirection $direction;
    final /* synthetic */ long $handleColor;
    final /* synthetic */ boolean $handlesCrossed;
    final /* synthetic */ boolean $isStartHandle;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ ColorFilter $colorFilter;
        final /* synthetic */ ResolvedTextDirection $direction;
        final /* synthetic */ ImageBitmap $handleImage;
        final /* synthetic */ boolean $handlesCrossed;
        final /* synthetic */ boolean $isStartHandle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2, ImageBitmap imageBitmap, ColorFilter colorFilter) {
            super(1);
            this.$isStartHandle = z;
            this.$direction = resolvedTextDirection;
            this.$handlesCrossed = z2;
            this.$handleImage = imageBitmap;
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
            if (!AndroidSelectionHandles_androidKt.isLeft(this.$isStartHandle, this.$direction, this.$handlesCrossed)) {
                AbstractC3255kk.A(contentDrawScope, this.$handleImage, 0L, 0.0f, null, this.$colorFilter, 0, 46, null);
                return;
            }
            ImageBitmap imageBitmap = this.$handleImage;
            ColorFilter colorFilter = this.$colorFilter;
            long jMo3468getCenterF1C5BW0 = contentDrawScope.mo3468getCenterF1C5BW0();
            DrawContext drawContext = contentDrawScope.getDrawContext();
            long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().mo3482scale0AR0LA0(-1.0f, 1.0f, jMo3468getCenterF1C5BW0);
            AbstractC3255kk.A(contentDrawScope, imageBitmap, 0L, 0.0f, null, colorFilter, 0, 46, null);
            drawContext.getCanvas().restore();
            drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1(long j, boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        super(1);
        this.$handleColor = j;
        this.$isStartHandle = z;
        this.$direction = resolvedTextDirection;
        this.$handlesCrossed = z2;
    }

    @Override // defpackage.InterfaceC3750qp
    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
        AbstractC4492zt.h(cacheDrawScope, "$this$drawWithCache");
        return cacheDrawScope.onDrawWithContent(new AnonymousClass1(this.$isStartHandle, this.$direction, this.$handlesCrossed, AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, Size.m2867getWidthimpl(cacheDrawScope.m2701getSizeNHjbRc()) / 2.0f), ColorFilter.Companion.m3073tintxETnrds$default(ColorFilter.Companion, this.$handleColor, 0, 2, null)));
    }
}
