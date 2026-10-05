package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SnackbarKt$Snackbar$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $action;
    final /* synthetic */ long $actionContentColor;
    final /* synthetic */ boolean $actionOnNewLine;
    final /* synthetic */ InterfaceC0526Fp $content;
    final /* synthetic */ InterfaceC0526Fp $dismissAction;
    final /* synthetic */ long $dismissActionContentColor;

    /* JADX INFO: renamed from: androidx.compose.material3.SnackbarKt$Snackbar$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0526Fp $action;
        final /* synthetic */ long $actionContentColor;
        final /* synthetic */ boolean $actionOnNewLine;
        final /* synthetic */ TextStyle $actionTextStyle;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ InterfaceC0526Fp $dismissAction;
        final /* synthetic */ long $dismissActionContentColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, TextStyle textStyle, long j, long j2, int i, boolean z) {
            super(2);
            this.$action = interfaceC0526Fp;
            this.$content = interfaceC0526Fp2;
            this.$dismissAction = interfaceC0526Fp3;
            this.$actionTextStyle = textStyle;
            this.$actionContentColor = j;
            this.$dismissActionContentColor = j2;
            this.$$dirty = i;
            this.$actionOnNewLine = z;
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
                ComposerKt.traceEventStart(835891690, i, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:115)");
            }
            if (this.$action == null) {
                composer.startReplaceableGroup(-2104362496);
                InterfaceC0526Fp interfaceC0526Fp = this.$content;
                InterfaceC0526Fp interfaceC0526Fp2 = this.$dismissAction;
                TextStyle textStyle = this.$actionTextStyle;
                long j = this.$actionContentColor;
                long j2 = this.$dismissActionContentColor;
                int i2 = this.$$dirty;
                SnackbarKt.m1762OneRowSnackbarkKq0p4A(interfaceC0526Fp, null, interfaceC0526Fp2, textStyle, j, j2, composer, (57344 & (i2 >> 9)) | ((i2 >> 27) & 14) | 48 | (i2 & 896) | ((i2 >> 9) & 458752));
                composer.endReplaceableGroup();
            } else if (this.$actionOnNewLine) {
                composer.startReplaceableGroup(-2104362182);
                InterfaceC0526Fp interfaceC0526Fp3 = this.$content;
                InterfaceC0526Fp interfaceC0526Fp4 = this.$action;
                InterfaceC0526Fp interfaceC0526Fp5 = this.$dismissAction;
                TextStyle textStyle2 = this.$actionTextStyle;
                long j3 = this.$actionContentColor;
                long j4 = this.$dismissActionContentColor;
                int i3 = this.$$dirty;
                SnackbarKt.m1761NewLineButtonSnackbarkKq0p4A(interfaceC0526Fp3, interfaceC0526Fp4, interfaceC0526Fp5, textStyle2, j3, j4, composer, (57344 & (i3 >> 9)) | ((i3 >> 27) & 14) | (i3 & 112) | (i3 & 896) | ((i3 >> 9) & 458752));
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-2104361902);
                InterfaceC0526Fp interfaceC0526Fp6 = this.$content;
                InterfaceC0526Fp interfaceC0526Fp7 = this.$action;
                InterfaceC0526Fp interfaceC0526Fp8 = this.$dismissAction;
                TextStyle textStyle3 = this.$actionTextStyle;
                long j5 = this.$actionContentColor;
                long j6 = this.$dismissActionContentColor;
                int i4 = this.$$dirty;
                SnackbarKt.m1762OneRowSnackbarkKq0p4A(interfaceC0526Fp6, interfaceC0526Fp7, interfaceC0526Fp8, textStyle3, j5, j6, composer, (57344 & (i4 >> 9)) | ((i4 >> 27) & 14) | (i4 & 112) | (i4 & 896) | ((i4 >> 9) & 458752));
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnackbarKt$Snackbar$1(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, long j, long j2, int i, boolean z) {
        super(2);
        this.$action = interfaceC0526Fp;
        this.$content = interfaceC0526Fp2;
        this.$dismissAction = interfaceC0526Fp3;
        this.$actionContentColor = j;
        this.$dismissActionContentColor = j2;
        this.$$dirty = i;
        this.$actionOnNewLine = z;
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
            ComposerKt.traceEventStart(-1829663446, i, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:112)");
        }
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        Typography typography = materialTheme.getTypography(composer, 6);
        SnackbarTokens snackbarTokens = SnackbarTokens.INSTANCE;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TypographyKt.fromToken(typography, snackbarTokens.getSupportingTextFont()))}, ComposableLambdaKt.composableLambda(composer, 835891690, true, new AnonymousClass1(this.$action, this.$content, this.$dismissAction, TypographyKt.fromToken(materialTheme.getTypography(composer, 6), snackbarTokens.getActionLabelTextFont()), this.$actionContentColor, this.$dismissActionContentColor, this.$$dirty, this.$actionOnNewLine)), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
