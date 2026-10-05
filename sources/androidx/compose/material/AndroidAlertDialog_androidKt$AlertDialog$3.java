package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt$AlertDialog$3 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ InterfaceC0526Fp $buttons;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ InterfaceC0526Fp $text;
    final /* synthetic */ InterfaceC0526Fp $title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidAlertDialog_androidKt$AlertDialog$3(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Shape shape, long j, long j2, int i) {
        super(2);
        this.$buttons = interfaceC0526Fp;
        this.$modifier = modifier;
        this.$title = interfaceC0526Fp2;
        this.$text = interfaceC0526Fp3;
        this.$shape = shape;
        this.$backgroundColor = j;
        this.$contentColor = j2;
        this.$$dirty = i;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1787418772, i, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:139)");
        }
        InterfaceC0526Fp interfaceC0526Fp = this.$buttons;
        Modifier modifier = this.$modifier;
        InterfaceC0526Fp interfaceC0526Fp2 = this.$title;
        InterfaceC0526Fp interfaceC0526Fp3 = this.$text;
        Shape shape = this.$shape;
        long j = this.$backgroundColor;
        long j2 = this.$contentColor;
        int i2 = this.$$dirty;
        AlertDialogKt.m968AlertDialogContentWMdw5o4(interfaceC0526Fp, modifier, interfaceC0526Fp2, interfaceC0526Fp3, shape, j, j2, composer, ((i2 >> 3) & 14) | ((i2 >> 3) & 112) | ((i2 >> 3) & 896) | ((i2 >> 3) & 7168) | ((i2 >> 3) & 57344) | ((i2 >> 3) & 458752) | ((i2 >> 3) & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
