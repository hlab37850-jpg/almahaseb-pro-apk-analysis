package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class AlertDialogKt$AlertDialogContent$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $buttonContentColor;
    final /* synthetic */ InterfaceC0526Fp $buttons;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ InterfaceC0526Fp $icon;
    final /* synthetic */ long $iconContentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ InterfaceC0526Fp $text;
    final /* synthetic */ long $textContentColor;
    final /* synthetic */ InterfaceC0526Fp $title;
    final /* synthetic */ long $titleContentColor;
    final /* synthetic */ float $tonalElevation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogContent$2(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, Shape shape, long j, float f, long j2, long j3, long j4, long j5, int i, int i2, int i3) {
        super(2);
        this.$buttons = interfaceC0526Fp;
        this.$modifier = modifier;
        this.$icon = interfaceC0526Fp2;
        this.$title = interfaceC0526Fp3;
        this.$text = interfaceC0526Fp4;
        this.$shape = shape;
        this.$containerColor = j;
        this.$tonalElevation = f;
        this.$buttonContentColor = j2;
        this.$iconContentColor = j3;
        this.$titleContentColor = j4;
        this.$textContentColor = j5;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    public final void invoke(Composer composer, int i) {
        AlertDialogKt.m1325AlertDialogContent4hvqGtA(this.$buttons, this.$modifier, this.$icon, this.$title, this.$text, this.$shape, this.$containerColor, this.$tonalElevation, this.$buttonContentColor, this.$iconContentColor, this.$titleContentColor, this.$textContentColor, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
