package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.text.TextStyle;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SnackbarKt$NewLineButtonSnackbar$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ InterfaceC0526Fp $action;
    final /* synthetic */ long $actionContentColor;
    final /* synthetic */ TextStyle $actionTextStyle;
    final /* synthetic */ InterfaceC0526Fp $dismissAction;
    final /* synthetic */ long $dismissActionContentColor;
    final /* synthetic */ InterfaceC0526Fp $text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnackbarKt$NewLineButtonSnackbar$2(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, TextStyle textStyle, long j, long j2, int i) {
        super(2);
        this.$text = interfaceC0526Fp;
        this.$action = interfaceC0526Fp2;
        this.$dismissAction = interfaceC0526Fp3;
        this.$actionTextStyle = textStyle;
        this.$actionContentColor = j;
        this.$dismissActionContentColor = j2;
        this.$$changed = i;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    public final void invoke(Composer composer, int i) {
        SnackbarKt.m1761NewLineButtonSnackbarkKq0p4A(this.$text, this.$action, this.$dismissAction, this.$actionTextStyle, this.$actionContentColor, this.$dismissActionContentColor, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
