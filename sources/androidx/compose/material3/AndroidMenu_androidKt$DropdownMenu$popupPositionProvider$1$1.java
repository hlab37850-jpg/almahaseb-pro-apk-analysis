package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntRect;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1(MutableState<TransformOrigin> mutableState) {
        super(2);
        this.$transformOriginState = mutableState;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((IntRect) obj, (IntRect) obj2);
        return FW.a;
    }

    public final void invoke(IntRect intRect, IntRect intRect2) {
        AbstractC4492zt.h(intRect, "parentBounds");
        AbstractC4492zt.h(intRect2, "menuBounds");
        this.$transformOriginState.setValue(TransformOrigin.m3381boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
    }
}
