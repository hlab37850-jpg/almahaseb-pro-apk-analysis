package androidx.compose.ui.graphics;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.Offset;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
final class RenderEffectVerificationHelper {
    public static final RenderEffectVerificationHelper INSTANCE = new RenderEffectVerificationHelper();

    private RenderEffectVerificationHelper() {
    }

    @DoNotInline
    /* JADX INFO: renamed from: createBlurEffect-8A-3gB4, reason: not valid java name */
    public final android.graphics.RenderEffect m3313createBlurEffect8A3gB4(RenderEffect renderEffect, float f, float f2, int i) {
        if (renderEffect == null) {
            android.graphics.RenderEffect renderEffectCreateBlurEffect = android.graphics.RenderEffect.createBlurEffect(f, f2, AndroidTileMode_androidKt.m2945toAndroidTileMode0vamqd0(i));
            AbstractC4492zt.g(renderEffectCreateBlurEffect, "{\n            android.gr…)\n            )\n        }");
            return renderEffectCreateBlurEffect;
        }
        android.graphics.RenderEffect renderEffectCreateBlurEffect2 = android.graphics.RenderEffect.createBlurEffect(f, f2, renderEffect.asAndroidRenderEffect(), AndroidTileMode_androidKt.m2945toAndroidTileMode0vamqd0(i));
        AbstractC4492zt.g(renderEffectCreateBlurEffect2, "{\n            android.gr…)\n            )\n        }");
        return renderEffectCreateBlurEffect2;
    }

    @DoNotInline
    /* JADX INFO: renamed from: createOffsetEffect-Uv8p0NA, reason: not valid java name */
    public final android.graphics.RenderEffect m3314createOffsetEffectUv8p0NA(RenderEffect renderEffect, long j) {
        if (renderEffect == null) {
            android.graphics.RenderEffect renderEffectCreateOffsetEffect = android.graphics.RenderEffect.createOffsetEffect(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j));
            AbstractC4492zt.g(renderEffectCreateOffsetEffect, "{\n            android.gr…et.x, offset.y)\n        }");
            return renderEffectCreateOffsetEffect;
        }
        android.graphics.RenderEffect renderEffectCreateOffsetEffect2 = android.graphics.RenderEffect.createOffsetEffect(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), renderEffect.asAndroidRenderEffect());
        AbstractC4492zt.g(renderEffectCreateOffsetEffect2, "{\n            android.gr…)\n            )\n        }");
        return renderEffectCreateOffsetEffect2;
    }
}
