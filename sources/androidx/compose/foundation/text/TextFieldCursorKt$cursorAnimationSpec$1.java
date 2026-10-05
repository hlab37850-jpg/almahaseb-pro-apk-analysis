package androidx.compose.foundation.text;

import androidx.compose.animation.core.KeyframesSpec;
import androidx.room.RoomDatabase;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldCursorKt$cursorAnimationSpec$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final TextFieldCursorKt$cursorAnimationSpec$1 INSTANCE = new TextFieldCursorKt$cursorAnimationSpec$1();

    public TextFieldCursorKt$cursorAnimationSpec$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
        return FW.a;
    }

    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
        AbstractC4492zt.h(keyframesSpecConfig, "$this$keyframes");
        keyframesSpecConfig.setDurationMillis(1000);
        Float fValueOf = Float.valueOf(1.0f);
        keyframesSpecConfig.at(fValueOf, 0);
        keyframesSpecConfig.at(fValueOf, 499);
        Float fValueOf2 = Float.valueOf(0.0f);
        keyframesSpecConfig.at(fValueOf2, 500);
        keyframesSpecConfig.at(fValueOf2, RoomDatabase.MAX_BIND_PARAMETER_CNT);
    }
}
