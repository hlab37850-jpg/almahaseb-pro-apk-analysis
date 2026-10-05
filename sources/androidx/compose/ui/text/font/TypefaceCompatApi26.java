package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Paint;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.TempListUtilsKt;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class TypefaceCompatApi26 {
    public static final TypefaceCompatApi26 INSTANCE = new TypefaceCompatApi26();
    private static ThreadLocal<Paint> threadLocalPaint = new ThreadLocal<>();

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.TypefaceCompatApi26$toAndroidString$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Density $density;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Density density) {
            super(1);
            this.$density = density;
        }

        @Override // defpackage.InterfaceC3750qp
        public final CharSequence invoke(FontVariation.Setting setting) {
            AbstractC4492zt.h(setting, "setting");
            return '\'' + setting.getAxisName() + "' " + setting.toVariationValue(this.$density);
        }
    }

    private TypefaceCompatApi26() {
    }

    @ExperimentalTextApi
    private final String toAndroidString(FontVariation.Settings settings, Context context) {
        return TempListUtilsKt.fastJoinToString$default(settings.getSettings(), null, null, null, 0, null, new AnonymousClass1(AndroidDensity_androidKt.Density(context)), 31, null);
    }

    @ExperimentalTextApi
    public final android.graphics.Typeface setFontVariationSettings(android.graphics.Typeface typeface, FontVariation.Settings settings, Context context) {
        AbstractC4492zt.h(settings, "variationSettings");
        AbstractC4492zt.h(context, "context");
        if (typeface == null) {
            return null;
        }
        if (settings.getSettings().isEmpty()) {
            return typeface;
        }
        Paint paint = threadLocalPaint.get();
        if (paint == null) {
            paint = new Paint();
            threadLocalPaint.set(paint);
        }
        paint.setTypeface(typeface);
        paint.setFontVariationSettings(toAndroidString(settings, context));
        return paint.getTypeface();
    }
}
