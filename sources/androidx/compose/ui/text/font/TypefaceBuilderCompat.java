package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.fonts.FontVariationAxis;
import android.os.ParcelFileDescriptor;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC1231aW;
import defpackage.AbstractC1797bW;
import defpackage.AbstractC1878cW;
import defpackage.AbstractC2036dW;
import defpackage.AbstractC2117eW;
import defpackage.AbstractC2199fW;
import defpackage.AbstractC4492zt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 26)
final class TypefaceBuilderCompat {
    public static final TypefaceBuilderCompat INSTANCE = new TypefaceBuilderCompat();

    private TypefaceBuilderCompat() {
    }

    @ExperimentalTextApi
    @RequiresApi(26)
    private final FontVariationAxis[] toVariationSettings(FontVariation.Settings settings, Context context) {
        Density Density;
        if (context != null) {
            Density = AndroidDensity_androidKt.Density(context);
        } else {
            if (settings.getNeedsDensity$ui_text_release()) {
                throw new IllegalStateException("Required density, but not provided");
            }
            Density = DensityKt.Density(1.0f, 1.0f);
        }
        List<FontVariation.Setting> settings2 = settings.getSettings();
        ArrayList arrayList = new ArrayList(settings2.size());
        int size = settings2.size();
        for (int i = 0; i < size; i++) {
            FontVariation.Setting setting = settings2.get(i);
            AbstractC2036dW.a();
            arrayList.add(AbstractC1878cW.a(setting.getAxisName(), setting.toVariationValue(Density)));
        }
        return (FontVariationAxis[]) arrayList.toArray(new FontVariationAxis[0]);
    }

    @ExperimentalTextApi
    @DoNotInline
    public final android.graphics.Typeface createFromAssets(AssetManager assetManager, String str, Context context, FontVariation.Settings settings) {
        AbstractC4492zt.h(assetManager, "assetManager");
        AbstractC4492zt.h(str, "path");
        AbstractC4492zt.h(settings, "variationSettings");
        if (context == null) {
            return null;
        }
        return AbstractC1797bW.a(assetManager, str).setFontVariationSettings(toVariationSettings(settings, context)).build();
    }

    @ExperimentalTextApi
    @DoNotInline
    public final android.graphics.Typeface createFromFile(File file, Context context, FontVariation.Settings settings) {
        AbstractC4492zt.h(file, Annotation.FILE);
        AbstractC4492zt.h(settings, "variationSettings");
        if (context == null) {
            return null;
        }
        return AbstractC1231aW.a(file).setFontVariationSettings(toVariationSettings(settings, context)).build();
    }

    @ExperimentalTextApi
    @DoNotInline
    public final android.graphics.Typeface createFromFileDescriptor(ParcelFileDescriptor parcelFileDescriptor, Context context, FontVariation.Settings settings) {
        AbstractC4492zt.h(parcelFileDescriptor, "fileDescriptor");
        AbstractC4492zt.h(settings, "variationSettings");
        if (context == null) {
            return null;
        }
        AbstractC2199fW.a();
        return AbstractC2117eW.a(parcelFileDescriptor.getFileDescriptor()).setFontVariationSettings(toVariationSettings(settings, context)).build();
    }
}
