package androidx.compose.material;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1118invoke() {
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m1118invoke();
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            AbstractC4492zt.h(semanticsPropertyReceiver, "$this$clearAndSetSemantics");
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SemanticsPropertyReceiver) obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ boolean $expanded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(boolean z) {
            super(2);
            this.$expanded = z;
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
                ComposerKt.traceEventStart(726122713, i, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.<anonymous> (ExposedDropdownMenu.kt:299)");
            }
            IconKt.m1140Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE), "Trailing icon for exposed dropdown menu", RotateKt.rotate(Modifier.Companion, this.$expanded ? 180.0f : 360.0f), 0L, composer, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $expanded;
        final /* synthetic */ InterfaceC3588op $onIconClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(boolean z, InterfaceC3588op interfaceC3588op, int i, int i2) {
            super(2);
            this.$expanded = z;
            this.$onIconClick = interfaceC3588op;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            ExposedDropdownMenuDefaults.this.TrailingIcon(this.$expanded, this.$onIconClick, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    private ExposedDropdownMenuDefaults() {
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterialApi
    public final void TrailingIcon(boolean z, InterfaceC3588op interfaceC3588op, Composer composer, int i, int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(876077373);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 32 : 16;
        }
        if ((i3 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                interfaceC3588op = AnonymousClass1.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(876077373, i3, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:291)");
            }
            IconButtonKt.IconButton(interfaceC3588op, SemanticsModifierKt.clearAndSetSemantics(Modifier.Companion, AnonymousClass2.INSTANCE), false, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 726122713, true, new AnonymousClass3(z)), composerStartRestartGroup, ((i3 >> 3) & 14) | 24576, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        InterfaceC3588op interfaceC3588op2 = interfaceC3588op;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(z, interfaceC3588op2, i, i2));
    }

    @Composable
    /* JADX INFO: renamed from: outlinedTextFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m1116outlinedTextFieldColorsDlUQjxs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, Composer composer, int i, int i2, int i3, int i4) {
        long jM3031copywmQWz5c$default;
        long jM3031copywmQWz5c$default2;
        long jM3031copywmQWz5c$default3;
        long jM3031copywmQWz5c$default4;
        long jM3031copywmQWz5c$default5;
        long jM3031copywmQWz5c$default6;
        composer.startReplaceableGroup(1162641182);
        long jM3031copywmQWz5c$default7 = (i4 & 1) != 0 ? Color.m3031copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j;
        if ((i4 & 2) != 0) {
            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default7, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default = j2;
        }
        long jM3067getTransparent0d7_KjU = (i4 & 4) != 0 ? Color.Companion.m3067getTransparent0d7_KjU() : j3;
        long jM1051getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU() : j4;
        long jM1045getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j5;
        long jM3031copywmQWz5c$default8 = (i4 & 32) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM3031copywmQWz5c$default9 = (i4 & 64) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i4 & 128) != 0) {
            jM3031copywmQWz5c$default2 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default9, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default2 = j8;
        }
        long jM1045getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j9;
        long jM3031copywmQWz5c$default10 = (i4 & 512) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            jM3031copywmQWz5c$default3 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default10, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default3 = j11;
        }
        long j23 = (i4 & 2048) != 0 ? jM3031copywmQWz5c$default10 : j12;
        long jM3031copywmQWz5c$default11 = (i4 & 4096) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long jM3031copywmQWz5c$default12 = (i4 & 8192) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j14;
        if ((i4 & 16384) != 0) {
            jM3031copywmQWz5c$default4 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default11, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default4 = j15;
        }
        long jM1045getError0d7_KjU3 = (32768 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j16;
        long jM3031copywmQWz5c$default13 = (65536 & i4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long jM3031copywmQWz5c$default14 = (131072 & i4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j18;
        if ((262144 & i4) != 0) {
            jM3031copywmQWz5c$default5 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default5 = j19;
        }
        long jM1045getError0d7_KjU4 = (524288 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j20;
        long jM3031copywmQWz5c$default15 = (1048576 & i4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if ((i4 & 2097152) != 0) {
            jM3031copywmQWz5c$default6 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default15, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default6 = j22;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1162641182, i, i2, "androidx.compose.material.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:460)");
        }
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(jM3031copywmQWz5c$default7, jM3031copywmQWz5c$default, jM1051getPrimary0d7_KjU, jM1045getError0d7_KjU, jM3031copywmQWz5c$default8, jM3031copywmQWz5c$default9, jM1045getError0d7_KjU2, jM3031copywmQWz5c$default2, jM3031copywmQWz5c$default10, jM3031copywmQWz5c$default3, j23, jM3031copywmQWz5c$default11, jM3031copywmQWz5c$default12, jM3031copywmQWz5c$default4, jM1045getError0d7_KjU3, jM3067getTransparent0d7_KjU, jM3031copywmQWz5c$default13, jM3031copywmQWz5c$default14, jM3031copywmQWz5c$default5, jM1045getError0d7_KjU4, jM3031copywmQWz5c$default15, jM3031copywmQWz5c$default6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }

    @Composable
    /* JADX INFO: renamed from: textFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m1117textFieldColorsDlUQjxs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, Composer composer, int i, int i2, int i3, int i4) {
        long jM3031copywmQWz5c$default;
        long jM3031copywmQWz5c$default2;
        long jM3031copywmQWz5c$default3;
        long jM3031copywmQWz5c$default4;
        long jM3031copywmQWz5c$default5;
        long jM3031copywmQWz5c$default6;
        composer.startReplaceableGroup(1208167904);
        long jM3031copywmQWz5c$default7 = (i4 & 1) != 0 ? Color.m3031copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j;
        if ((i4 & 2) != 0) {
            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default7, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default = j2;
        }
        long jM3031copywmQWz5c$default8 = (i4 & 4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM1051getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU() : j4;
        long jM1045getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j5;
        long jM3031copywmQWz5c$default9 = (i4 & 32) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM3031copywmQWz5c$default10 = (i4 & 64) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i4 & 128) != 0) {
            jM3031copywmQWz5c$default2 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default10, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default2 = j8;
        }
        long jM1045getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j9;
        long jM3031copywmQWz5c$default11 = (i4 & 512) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            jM3031copywmQWz5c$default3 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default11, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default3 = j11;
        }
        long j23 = (i4 & 2048) != 0 ? jM3031copywmQWz5c$default11 : j12;
        long jM3031copywmQWz5c$default12 = (i4 & 4096) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long jM3031copywmQWz5c$default13 = (i4 & 8192) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j14;
        if ((i4 & 16384) != 0) {
            jM3031copywmQWz5c$default4 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default12, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default4 = j15;
        }
        long jM1045getError0d7_KjU3 = (32768 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j16;
        long jM3031copywmQWz5c$default14 = (65536 & i4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long jM3031copywmQWz5c$default15 = (131072 & i4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j18;
        if ((262144 & i4) != 0) {
            jM3031copywmQWz5c$default5 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default15, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default5 = j19;
        }
        long jM1045getError0d7_KjU4 = (524288 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j20;
        long jM3031copywmQWz5c$default16 = (1048576 & i4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if ((i4 & 2097152) != 0) {
            jM3031copywmQWz5c$default6 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default16, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default6 = j22;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1208167904, i, i2, "androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:357)");
        }
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(jM3031copywmQWz5c$default7, jM3031copywmQWz5c$default, jM1051getPrimary0d7_KjU, jM1045getError0d7_KjU, jM3031copywmQWz5c$default9, jM3031copywmQWz5c$default10, jM1045getError0d7_KjU2, jM3031copywmQWz5c$default2, jM3031copywmQWz5c$default11, jM3031copywmQWz5c$default3, j23, jM3031copywmQWz5c$default12, jM3031copywmQWz5c$default13, jM3031copywmQWz5c$default4, jM1045getError0d7_KjU3, jM3031copywmQWz5c$default8, jM3031copywmQWz5c$default14, jM3031copywmQWz5c$default15, jM3031copywmQWz5c$default5, jM1045getError0d7_KjU4, jM3031copywmQWz5c$default16, jM3031copywmQWz5c$default6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }
}
