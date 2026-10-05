package androidx.compose.ui.text.platform.extensions;

import android.text.style.TtsSpan;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.VerbatimTtsAnnotation;
import defpackage.AD;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class TtsAnnotationExtensions_androidKt {
    public static final TtsSpan toSpan(TtsAnnotation ttsAnnotation) {
        AbstractC4492zt.h(ttsAnnotation, "<this>");
        if (ttsAnnotation instanceof VerbatimTtsAnnotation) {
            return toSpan((VerbatimTtsAnnotation) ttsAnnotation);
        }
        throw new AD();
    }

    public static final TtsSpan toSpan(VerbatimTtsAnnotation verbatimTtsAnnotation) {
        AbstractC4492zt.h(verbatimTtsAnnotation, "<this>");
        TtsSpan ttsSpanBuild = new TtsSpan.VerbatimBuilder(verbatimTtsAnnotation.getVerbatim()).build();
        AbstractC4492zt.g(ttsSpanBuild, "builder.build()");
        return ttsSpanBuild;
    }
}
