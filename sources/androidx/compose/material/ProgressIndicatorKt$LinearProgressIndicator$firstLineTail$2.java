package androidx.compose.material;

import androidx.compose.animation.core.KeyframesSpec;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2 INSTANCE = new ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2();

    public ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
        return FW.a;
    }

    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
        AbstractC4492zt.h(keyframesSpecConfig, "$this$keyframes");
        keyframesSpecConfig.setDurationMillis(1800);
        keyframesSpecConfig.with(keyframesSpecConfig.at(Float.valueOf(0.0f), TIFFConstants.TIFFTAG_INKNAMES), ProgressIndicatorKt.FirstLineTailEasing);
        keyframesSpecConfig.at(Float.valueOf(1.0f), 1183);
    }
}
