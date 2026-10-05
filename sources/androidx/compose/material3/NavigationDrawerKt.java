package androidx.compose.material3;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC3955tM;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class NavigationDrawerKt {
    private static final float DrawerVelocityThreshold = Dp.m5160constructorimpl(400);
    private static final float MinimumDrawerWidth = Dp.m5160constructorimpl(240);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ThresholdConfig mo13invoke(DrawerValue drawerValue, DrawerValue drawerValue2) {
            AbstractC4492zt.h(drawerValue, "<anonymous parameter 0>");
            AbstractC4492zt.h(drawerValue2, "<anonymous parameter 1>");
            return new FractionalThreshold(0.5f);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ InterfaceC0526Fp $drawerContent;
        final /* synthetic */ DrawerState $drawerState;
        final /* synthetic */ boolean $gesturesEnabled;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, DrawerState drawerState, boolean z, InterfaceC0526Fp interfaceC0526Fp2, int i, int i2) {
            super(2);
            this.$drawerContent = interfaceC0526Fp;
            this.$modifier = modifier;
            this.$drawerState = drawerState;
            this.$gesturesEnabled = z;
            this.$content = interfaceC0526Fp2;
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
            NavigationDrawerKt.DismissibleNavigationDrawer(this.$drawerContent, this.$modifier, this.$drawerState, this.$gesturesEnabled, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SemanticsPropertyReceiver) obj);
            return FW.a;
        }

        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
            SemanticsPropertiesKt.m4564setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m4556getTabo7Vup1c());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3, reason: invalid class name and case insensitive filesystem */
    public static final class C15353 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0526Fp $badge;
        final /* synthetic */ NavigationDrawerItemColors $colors;
        final /* synthetic */ InterfaceC0526Fp $icon;
        final /* synthetic */ InterfaceC0526Fp $label;
        final /* synthetic */ boolean $selected;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15353(InterfaceC0526Fp interfaceC0526Fp, NavigationDrawerItemColors navigationDrawerItemColors, boolean z, int i, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3) {
            super(2);
            this.$icon = interfaceC0526Fp;
            this.$colors = navigationDrawerItemColors;
            this.$selected = z;
            this.$$dirty = i;
            this.$badge = interfaceC0526Fp2;
            this.$label = interfaceC0526Fp3;
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
                ComposerKt.traceEventStart(191488423, i, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:670)");
            }
            Modifier.Companion companion = Modifier.Companion;
            Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(companion, Dp.m5160constructorimpl(16), 0.0f, Dp.m5160constructorimpl(24), 0.0f, 10, null);
            Alignment.Companion companion2 = Alignment.Companion;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            InterfaceC0526Fp interfaceC0526Fp = this.$icon;
            NavigationDrawerItemColors navigationDrawerItemColors = this.$colors;
            boolean z = this.$selected;
            int i2 = this.$$dirty;
            InterfaceC0526Fp interfaceC0526Fp2 = this.$badge;
            InterfaceC0526Fp interfaceC0526Fp3 = this.$label;
            composer.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierM489paddingqDBjuR0$default);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            composer.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composer.startReplaceableGroup(-1538531918);
            if (interfaceC0526Fp != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(navigationDrawerItemColors.iconColor(z, composer, ((i2 >> 3) & 14) | ((i2 >> 18) & 112)).getValue().m3042unboximpl()))}, interfaceC0526Fp, composer, ((i2 >> 9) & 112) | 8);
                SpacerKt.Spacer(SizeKt.m537width3ABfNKs(companion, Dp.m5160constructorimpl(12)), composer, 6);
            }
            composer.endReplaceableGroup();
            Modifier modifierA = AbstractC3955tM.a(rowScopeInstance, companion, 1.0f, false, 2, null);
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer, 0);
            composer.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            InterfaceC3588op constructor2 = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierA);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composer);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
            composer.enableReusing();
            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = ((i2 >> 3) & 14) | ((i2 >> 18) & 112);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(navigationDrawerItemColors.textColor(z, composer, i3).getValue().m3042unboximpl()))}, interfaceC0526Fp3, composer, ((i2 << 3) & 112) | 8);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(-533539227);
            if (interfaceC0526Fp2 != null) {
                SpacerKt.Spacer(SizeKt.m537width3ABfNKs(companion, Dp.m5160constructorimpl(12)), composer, 6);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(navigationDrawerItemColors.badgeColor(z, composer, i3).getValue().m3042unboximpl()))}, interfaceC0526Fp2, composer, ((i2 >> 12) & 112) | 8);
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $badge;
        final /* synthetic */ NavigationDrawerItemColors $colors;
        final /* synthetic */ InterfaceC0526Fp $icon;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ InterfaceC0526Fp $label;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ boolean $selected;
        final /* synthetic */ Shape $shape;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(InterfaceC0526Fp interfaceC0526Fp, boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Shape shape, NavigationDrawerItemColors navigationDrawerItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2) {
            super(2);
            this.$label = interfaceC0526Fp;
            this.$selected = z;
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$icon = interfaceC0526Fp2;
            this.$badge = interfaceC0526Fp3;
            this.$shape = shape;
            this.$colors = navigationDrawerItemColors;
            this.$interactionSource = mutableInteractionSource;
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
            NavigationDrawerKt.NavigationDrawerItem(this.$label, this.$selected, this.$onClick, this.$modifier, this.$icon, this.$badge, this.$shape, this.$colors, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$PermanentNavigationDrawer$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15362 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ InterfaceC0526Fp $drawerContent;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15362(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, int i, int i2) {
            super(2);
            this.$drawerContent = interfaceC0526Fp;
            this.$modifier = modifier;
            this.$content = interfaceC0526Fp2;
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
            NavigationDrawerKt.PermanentNavigationDrawer(this.$drawerContent, this.$modifier, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15371 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C15371 INSTANCE = new C15371();

        public C15371() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(DrawerValue drawerValue) {
            AbstractC4492zt.h(drawerValue, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012b  */
    /* JADX WARN: Code duplicated, block: B:102:0x012f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0139  */
    /* JADX WARN: Code duplicated, block: B:108:0x0149  */
    /* JADX WARN: Code duplicated, block: B:110:0x0156  */
    /* JADX WARN: Code duplicated, block: B:113:0x0161  */
    /* JADX WARN: Code duplicated, block: B:115:0x0174  */
    /* JADX WARN: Code duplicated, block: B:118:0x0186  */
    /* JADX WARN: Code duplicated, block: B:121:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:126:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:30:0x005b  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:54:0x0099  */
    /* JADX WARN: Code duplicated, block: B:55:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:98:0x0126 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x0128  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: DismissibleDrawerSheet-afqeVBk, reason: not valid java name */
    public static final void m1666DismissibleDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Shape rectangleShape;
        long jM1413getSurface0d7_KjU;
        long jM1449contentColorForek8zF_U;
        int i4;
        float fM1544getDismissibleDrawerElevationD9Ej5fM;
        int i5;
        WindowInsets windowInsets2;
        int i6;
        Modifier modifier2;
        WindowInsets windowInsets3;
        float f2;
        Modifier modifier3;
        Modifier modifier4;
        Shape shape2;
        long j3;
        long j4;
        float f3;
        WindowInsets windowInsets4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-588600583);
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 112) == 0) {
                rectangleShape = shape;
                i3 |= composerStartRestartGroup.changed(rectangleShape) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    jM1413getSurface0d7_KjU = j;
                    int i10 = composerStartRestartGroup.changed(jM1413getSurface0d7_KjU) ? 256 : 128;
                    i3 |= i10;
                } else {
                    jM1413getSurface0d7_KjU = j;
                }
                i3 |= i10;
            } else {
                jM1413getSurface0d7_KjU = j;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    jM1449contentColorForek8zF_U = j2;
                    int i11 = composerStartRestartGroup.changed(jM1449contentColorForek8zF_U) ? 2048 : 1024;
                    i3 |= i11;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                i3 |= i11;
            } else {
                jM1449contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 57344) == 0) {
                    fM1544getDismissibleDrawerElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM1544getDismissibleDrawerElevationD9Ej5fM)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i & 458752) == 0) {
                    windowInsets2 = windowInsets;
                    if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(windowInsets2)) {
                        i7 = 65536;
                    } else {
                        i7 = 131072;
                    }
                    i3 |= i7;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i2 & 64) != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i6 = 1048576;
                        } else {
                            i6 = 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i9 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 4) != 0) {
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            } else {
                                windowInsets3 = windowInsets2;
                            }
                            f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            rectangleShape = rectangleShape;
                            jM1413getSurface0d7_KjU = jM1413getSurface0d7_KjU;
                            jM1449contentColorForek8zF_U = jM1449contentColorForek8zF_U;
                            windowInsets3 = windowInsets2;
                            f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                            modifier3 = modifier;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
                        }
                        int i12 = i3 << 3;
                        m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (i12 & 458752) | (i3 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        shape2 = rectangleShape;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f3 = f2;
                        windowInsets4 = windowInsets3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier;
                        shape2 = rectangleShape;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        windowInsets4 = windowInsets2;
                        f3 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DismissibleDrawerSheet$1(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
                }
                i6 = 1572864;
                i3 |= i6;
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
                    }
                    int i13 = i3 << 3;
                    m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (i13 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape2 = rectangleShape;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f3 = f2;
                    windowInsets4 = windowInsets3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
                    }
                    int i14 = i3 << 3;
                    m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i14 & 112) | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (i14 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape2 = rectangleShape;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f3 = f2;
                    windowInsets4 = windowInsets3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DismissibleDrawerSheet$1(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            fM1544getDismissibleDrawerElevationD9Ej5fM = f;
            if ((i & 458752) == 0) {
                windowInsets2 = windowInsets;
                if ((i2 & 32) == 0) {
                    i7 = 65536;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
                    }
                    int i15 = i3 << 3;
                    m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i15 & 112) | (i15 & 896) | (i15 & 7168) | (57344 & i15) | (i15 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape2 = rectangleShape;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f3 = f2;
                    windowInsets4 = windowInsets3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
                    }
                    int i16 = i3 << 3;
                    m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (i16 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape2 = rectangleShape;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f3 = f2;
                    windowInsets4 = windowInsets3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DismissibleDrawerSheet$1(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
            }
            i6 = 1572864;
            i3 |= i6;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
                }
                int i17 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i17 & 112) | (i17 & 896) | (i17 & 7168) | (57344 & i17) | (i17 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j3 = jM1413getSurface0d7_KjU;
                j4 = jM1449contentColorForek8zF_U;
                f3 = f2;
                windowInsets4 = windowInsets3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
                }
                int i18 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i18 & 112) | (i18 & 896) | (i18 & 7168) | (57344 & i18) | (i18 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j3 = jM1413getSurface0d7_KjU;
                j4 = jM1449contentColorForek8zF_U;
                f3 = f2;
                windowInsets4 = windowInsets3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DismissibleDrawerSheet$1(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
        }
        i3 |= 48;
        rectangleShape = shape;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                jM1413getSurface0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM1413getSurface0d7_KjU)) {
                }
                i3 |= i10;
            } else {
                jM1413getSurface0d7_KjU = j;
            }
            i3 |= i10;
        } else {
            jM1413getSurface0d7_KjU = j;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                jM1449contentColorForek8zF_U = j2;
                if (composerStartRestartGroup.changed(jM1449contentColorForek8zF_U)) {
                }
                i3 |= i11;
            } else {
                jM1449contentColorForek8zF_U = j2;
            }
            i3 |= i11;
        } else {
            jM1449contentColorForek8zF_U = j2;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 57344) == 0) {
                fM1544getDismissibleDrawerElevationD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM1544getDismissibleDrawerElevationD9Ej5fM)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i & 458752) == 0) {
                windowInsets2 = windowInsets;
                if ((i2 & 32) == 0) {
                    i7 = 65536;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
                    }
                    int i19 = i3 << 3;
                    m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i19 & 112) | (i19 & 896) | (i19 & 7168) | (57344 & i19) | (i19 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape2 = rectangleShape;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f3 = f2;
                    windowInsets4 = windowInsets3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
                    }
                    int i110 = i3 << 3;
                    m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i110 & 112) | (i110 & 896) | (i110 & 7168) | (57344 & i110) | (i110 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape2 = rectangleShape;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f3 = f2;
                    windowInsets4 = windowInsets3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DismissibleDrawerSheet$1(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
            }
            i6 = 1572864;
            i3 |= i6;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
                }
                int i111 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i111 & 112) | (i111 & 896) | (i111 & 7168) | (57344 & i111) | (i111 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j3 = jM1413getSurface0d7_KjU;
                j4 = jM1449contentColorForek8zF_U;
                f3 = f2;
                windowInsets4 = windowInsets3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
                }
                int i112 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i112 & 112) | (i112 & 896) | (i112 & 7168) | (57344 & i112) | (i112 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j3 = jM1413getSurface0d7_KjU;
                j4 = jM1449contentColorForek8zF_U;
                f3 = f2;
                windowInsets4 = windowInsets3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DismissibleDrawerSheet$1(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
        }
        i3 |= 24576;
        fM1544getDismissibleDrawerElevationD9Ej5fM = f;
        if ((i & 458752) == 0) {
            windowInsets2 = windowInsets;
            if ((i2 & 32) == 0) {
                i7 = 65536;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i2 & 64) != 0) {
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
                }
                int i113 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i113 & 112) | (i113 & 896) | (i113 & 7168) | (57344 & i113) | (i113 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j3 = jM1413getSurface0d7_KjU;
                j4 = jM1449contentColorForek8zF_U;
                f3 = f2;
                windowInsets4 = windowInsets3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
                }
                int i114 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i114 & 112) | (i114 & 896) | (i114 & 7168) | (57344 & i114) | (i114 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j3 = jM1413getSurface0d7_KjU;
                j4 = jM1449contentColorForek8zF_U;
                f3 = f2;
                windowInsets4 = windowInsets3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DismissibleDrawerSheet$1(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
        }
        i6 = 1572864;
        i3 |= i6;
        if ((i3 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i9 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets3 = windowInsets2;
                }
                f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                modifier3 = modifier2;
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i9 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets3 = windowInsets2;
                }
                f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
            }
            int i115 = i3 << 3;
            m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i115 & 112) | (i115 & 896) | (i115 & 7168) | (57344 & i115) | (i115 & 458752) | (i3 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape2 = rectangleShape;
            j3 = jM1413getSurface0d7_KjU;
            j4 = jM1449contentColorForek8zF_U;
            f3 = f2;
            windowInsets4 = windowInsets3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i9 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets3 = windowInsets2;
                }
                f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                modifier3 = modifier2;
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i9 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM1544getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1544getDismissibleDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets3 = windowInsets2;
                }
                f2 = fM1544getDismissibleDrawerElevationD9Ej5fM;
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-588600583, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:491)");
            }
            int i116 = i3 << 3;
            m1667DrawerSheetvywBR7E(windowInsets3, modifier3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i116 & 112) | (i116 & 896) | (i116 & 7168) | (57344 & i116) | (i116 & 458752) | (i3 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape2 = rectangleShape;
            j3 = jM1413getSurface0d7_KjU;
            j4 = jM1449contentColorForek8zF_U;
            f3 = f2;
            windowInsets4 = windowInsets3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DismissibleDrawerSheet$1(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x027c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0302  */
    /* JADX WARN: Code duplicated, block: B:106:0x030e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0312  */
    /* JADX WARN: Code duplicated, block: B:110:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:113:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:114:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:117:0x042a  */
    /* JADX WARN: Code duplicated, block: B:122:0x0439  */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX WARN: Code duplicated, block: B:28:0x0059  */
    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    /* JADX WARN: Code duplicated, block: B:34:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x0070  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x0081  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x008f  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x009b  */
    /* JADX WARN: Code duplicated, block: B:54:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00da  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:82:0x0125  */
    /* JADX WARN: Code duplicated, block: B:85:0x0176  */
    /* JADX WARN: Code duplicated, block: B:86:0x0179  */
    /* JADX WARN: Code duplicated, block: B:89:0x01de  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:93:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:96:0x026c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0278  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void DismissibleNavigationDrawer(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, DrawerState drawerState, boolean z, InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        final DrawerState drawerStateRememberDrawerState;
        int i4;
        boolean z2;
        int i5;
        int i6;
        Object objRememberedValue;
        boolean z3;
        InterfaceC3588op constructor;
        InterfaceC3588op constructor2;
        InterfaceC3588op constructor3;
        InterfaceC3588op constructor4;
        boolean z4;
        DrawerState drawerState2;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp, "drawerContent");
        AbstractC4492zt.h(interfaceC0526Fp2, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(398812198);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    drawerStateRememberDrawerState = drawerState;
                    int i8 = composerStartRestartGroup.changed(drawerStateRememberDrawerState) ? 256 : 128;
                    i3 |= i8;
                } else {
                    drawerStateRememberDrawerState = drawerState;
                }
                i3 |= i8;
            } else {
                drawerStateRememberDrawerState = drawerState;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i3 |= i6;
                }
                if ((46811 & i3) == 9362 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(398812198, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:344)");
                    }
                    float f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    Map mapJ = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                    if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Modifier modifierM1862swipeablepPrIpRY = SwipeableKt.m1862swipeablepPrIpRY(modifier2, drawerStateRememberDrawerState.getSwipeableState$material3_release(), mapJ, Orientation.Horizontal, (32 & 8) != 0 ? true : z2, (32 & 16) != 0 ? false : z3, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : AnonymousClass1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Alignment.Companion companion = Alignment.Companion;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                    boolean z5 = z2;
                    constructor = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                            return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                            return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            AbstractC4492zt.h(measureScope, "$this$Layout");
                            AbstractC4492zt.h(list, "measurables");
                            Placeable placeableMo4159measureBRTryo0 = list.get(0).mo4159measureBRTryo0(j);
                            Placeable placeableMo4159measureBRTryo1 = list.get(1).mo4159measureBRTryo0(j);
                            return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo1.getWidth(), placeableMo4159measureBRTryo1.getHeight(), null, new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1(placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo0, drawerStateRememberDrawerState), 4, null);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                            return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                            return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Modifier.Companion companion3 = Modifier.Companion;
                    Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor2 = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(companion3);
                    Modifier modifier4 = modifier2;
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion2.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
                    interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion3, false, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1(strM1841getStringNWtq28, drawerStateRememberDrawerState, coroutineScope), 1, null);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor3 = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierSemantics$default);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl3, density3, companion2.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion2.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion2.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor4 = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf4 = LayoutKt.materializerOf(companion3);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor4);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl4 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl4, measurePolicyRememberBoxMeasurePolicy3, companion2.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl4, density4, companion2.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl4, layoutDirection4, companion2.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl4, viewConfiguration4, companion2.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                    drawerState2 = drawerStateRememberDrawerState;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z2;
                    modifier3 = modifier2;
                    drawerState2 = drawerStateRememberDrawerState;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0526Fp, modifier3, drawerState2, z4, interfaceC0526Fp2, i, i2));
            }
            i3 |= 3072;
            z2 = z;
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((46811 & i3) == 9362) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(398812198, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:344)");
                }
                float f2 = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller2;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                String strM1841getStringNWtq29 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                Map mapJ2 = AbstractC4243wx.j(HV.a(Float.valueOf(f2), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Modifier modifierM1862swipeablepPrIpRY2 = SwipeableKt.m1862swipeablepPrIpRY(modifier2, drawerStateRememberDrawerState.getSwipeableState$material3_release(), mapJ2, Orientation.Horizontal, (32 & 8) != 0 ? true : z2, (32 & 16) != 0 ? false : z3, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : AnonymousClass1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ2.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion4 = Alignment.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(companion4.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection5 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion5 = ComposeUiNode.Companion;
                boolean z6 = z2;
                constructor = companion5.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf5 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY2);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl5 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl5, measurePolicyRememberBoxMeasurePolicy4, companion5.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl5, density5, companion5.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl5, layoutDirection5, companion5.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl5, viewConfiguration5, companion5.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf5.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                MeasurePolicy measurePolicy2 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        AbstractC4492zt.h(measureScope, "$this$Layout");
                        AbstractC4492zt.h(list, "measurables");
                        Placeable placeableMo4159measureBRTryo0 = list.get(0).mo4159measureBRTryo0(j);
                        Placeable placeableMo4159measureBRTryo1 = list.get(1).mo4159measureBRTryo0(j);
                        return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo1.getWidth(), placeableMo4159measureBRTryo1.getHeight(), null, new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1(placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo0, drawerStateRememberDrawerState), 4, null);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Modifier.Companion companion6 = Modifier.Companion;
                Density density6 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection6 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration6 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion5.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf6 = LayoutKt.materializerOf(companion6);
                Modifier modifier5 = modifier2;
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl6 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl6, measurePolicy2, companion5.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl6, density6, companion5.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl6, layoutDirection6, companion5.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl6, viewConfiguration6, companion5.getSetViewConfiguration());
                interfaceC0552GpMaterializerOf6.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(companion6, false, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1(strM1841getStringNWtq29, drawerStateRememberDrawerState, coroutineScope2), 1, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(companion4.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density7 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection7 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration7 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor3 = companion5.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf7 = LayoutKt.materializerOf(modifierSemantics$default2);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl7 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl7, measurePolicyRememberBoxMeasurePolicy5, companion5.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl7, density7, companion5.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl7, layoutDirection7, companion5.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl7, viewConfiguration7, companion5.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf7.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(companion4.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density8 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection8 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration8 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor4 = companion5.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf8 = LayoutKt.materializerOf(companion6);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl8 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl8, measurePolicyRememberBoxMeasurePolicy6, companion5.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl8, density8, companion5.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl8, layoutDirection8, companion5.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl8, viewConfiguration8, companion5.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf8.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z6;
                drawerState2 = drawerStateRememberDrawerState;
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(398812198, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:344)");
                }
                float f3 = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller3 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller3);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller3;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope3 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                String strM1841getStringNWtq210 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                Map mapJ3 = AbstractC4243wx.j(HV.a(Float.valueOf(f3), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Modifier modifierM1862swipeablepPrIpRY3 = SwipeableKt.m1862swipeablepPrIpRY(modifier2, drawerStateRememberDrawerState.getSwipeableState$material3_release(), mapJ3, Orientation.Horizontal, (32 & 8) != 0 ? true : z2, (32 & 16) != 0 ? false : z3, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : AnonymousClass1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ3.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion7 = Alignment.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(companion7.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density9 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection9 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration9 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion8 = ComposeUiNode.Companion;
                boolean z7 = z2;
                constructor = companion8.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf9 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY3);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl9 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl9, measurePolicyRememberBoxMeasurePolicy7, companion8.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl9, density9, companion8.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl9, layoutDirection9, companion8.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl9, viewConfiguration9, companion8.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf9.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                MeasurePolicy measurePolicy3 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        AbstractC4492zt.h(measureScope, "$this$Layout");
                        AbstractC4492zt.h(list, "measurables");
                        Placeable placeableMo4159measureBRTryo0 = list.get(0).mo4159measureBRTryo0(j);
                        Placeable placeableMo4159measureBRTryo1 = list.get(1).mo4159measureBRTryo0(j);
                        return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo1.getWidth(), placeableMo4159measureBRTryo1.getHeight(), null, new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1(placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo0, drawerStateRememberDrawerState), 4, null);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Modifier.Companion companion9 = Modifier.Companion;
                Density density10 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection10 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration10 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion8.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf10 = LayoutKt.materializerOf(companion9);
                Modifier modifier6 = modifier2;
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl10 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl10, measurePolicy3, companion8.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl10, density10, companion8.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl10, layoutDirection10, companion8.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl10, viewConfiguration10, companion8.getSetViewConfiguration());
                interfaceC0552GpMaterializerOf10.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(companion9, false, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1(strM1841getStringNWtq210, drawerStateRememberDrawerState, coroutineScope3), 1, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy8 = BoxKt.rememberBoxMeasurePolicy(companion7.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density11 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection11 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration11 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor3 = companion8.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf11 = LayoutKt.materializerOf(modifierSemantics$default3);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl11 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl11, measurePolicyRememberBoxMeasurePolicy8, companion8.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl11, density11, companion8.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl11, layoutDirection11, companion8.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl11, viewConfiguration11, companion8.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf11.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy9 = BoxKt.rememberBoxMeasurePolicy(companion7.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density12 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection12 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration12 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor4 = companion8.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf12 = LayoutKt.materializerOf(companion9);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl12 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl12, measurePolicyRememberBoxMeasurePolicy9, companion8.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl12, density12, companion8.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl12, layoutDirection12, companion8.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl12, viewConfiguration12, companion8.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf12.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z7;
                drawerState2 = drawerStateRememberDrawerState;
                modifier3 = modifier6;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0526Fp, modifier3, drawerState2, z4, interfaceC0526Fp2, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                drawerStateRememberDrawerState = drawerState;
                if (composerStartRestartGroup.changed(drawerStateRememberDrawerState)) {
                }
                i3 |= i8;
            } else {
                drawerStateRememberDrawerState = drawerState;
            }
            i3 |= i8;
        } else {
            drawerStateRememberDrawerState = drawerState;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((46811 & i3) == 9362) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(398812198, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:344)");
                }
                float f4 = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller4);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller4;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope4 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                String strM1841getStringNWtq211 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                Map mapJ4 = AbstractC4243wx.j(HV.a(Float.valueOf(f4), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Modifier modifierM1862swipeablepPrIpRY4 = SwipeableKt.m1862swipeablepPrIpRY(modifier2, drawerStateRememberDrawerState.getSwipeableState$material3_release(), mapJ4, Orientation.Horizontal, (32 & 8) != 0 ? true : z2, (32 & 16) != 0 ? false : z3, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : AnonymousClass1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ4.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion10 = Alignment.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy10 = BoxKt.rememberBoxMeasurePolicy(companion10.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density13 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection13 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration13 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion11 = ComposeUiNode.Companion;
                boolean z8 = z2;
                constructor = companion11.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf13 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY4);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl13 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl13, measurePolicyRememberBoxMeasurePolicy10, companion11.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl13, density13, companion11.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl13, layoutDirection13, companion11.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl13, viewConfiguration13, companion11.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf13.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                MeasurePolicy measurePolicy4 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        AbstractC4492zt.h(measureScope, "$this$Layout");
                        AbstractC4492zt.h(list, "measurables");
                        Placeable placeableMo4159measureBRTryo0 = list.get(0).mo4159measureBRTryo0(j);
                        Placeable placeableMo4159measureBRTryo1 = list.get(1).mo4159measureBRTryo0(j);
                        return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo1.getWidth(), placeableMo4159measureBRTryo1.getHeight(), null, new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1(placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo0, drawerStateRememberDrawerState), 4, null);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Modifier.Companion companion12 = Modifier.Companion;
                Density density14 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection14 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration14 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion11.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf14 = LayoutKt.materializerOf(companion12);
                Modifier modifier7 = modifier2;
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl14 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl14, measurePolicy4, companion11.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl14, density14, companion11.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl14, layoutDirection14, companion11.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl14, viewConfiguration14, companion11.getSetViewConfiguration());
                interfaceC0552GpMaterializerOf14.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(companion12, false, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1(strM1841getStringNWtq211, drawerStateRememberDrawerState, coroutineScope4), 1, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy11 = BoxKt.rememberBoxMeasurePolicy(companion10.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density15 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection15 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration15 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor3 = companion11.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf15 = LayoutKt.materializerOf(modifierSemantics$default4);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl15 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl15, measurePolicyRememberBoxMeasurePolicy11, companion11.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl15, density15, companion11.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl15, layoutDirection15, companion11.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl15, viewConfiguration15, companion11.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf15.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy12 = BoxKt.rememberBoxMeasurePolicy(companion10.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density16 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection16 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration16 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor4 = companion11.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf16 = LayoutKt.materializerOf(companion12);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl16 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl16, measurePolicyRememberBoxMeasurePolicy12, companion11.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl16, density16, companion11.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl16, layoutDirection16, companion11.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl16, viewConfiguration16, companion11.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf16.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z8;
                drawerState2 = drawerStateRememberDrawerState;
                modifier3 = modifier7;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(398812198, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:344)");
                }
                float f5 = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller5 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller5);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller5;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope5 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                String strM1841getStringNWtq212 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                Map mapJ5 = AbstractC4243wx.j(HV.a(Float.valueOf(f5), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Modifier modifierM1862swipeablepPrIpRY5 = SwipeableKt.m1862swipeablepPrIpRY(modifier2, drawerStateRememberDrawerState.getSwipeableState$material3_release(), mapJ5, Orientation.Horizontal, (32 & 8) != 0 ? true : z2, (32 & 16) != 0 ? false : z3, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : AnonymousClass1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ5.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion13 = Alignment.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy13 = BoxKt.rememberBoxMeasurePolicy(companion13.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density17 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection17 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration17 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion14 = ComposeUiNode.Companion;
                boolean z9 = z2;
                constructor = companion14.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf17 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY5);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl17 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl17, measurePolicyRememberBoxMeasurePolicy13, companion14.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl17, density17, companion14.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl17, layoutDirection17, companion14.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl17, viewConfiguration17, companion14.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf17.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                MeasurePolicy measurePolicy5 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        AbstractC4492zt.h(measureScope, "$this$Layout");
                        AbstractC4492zt.h(list, "measurables");
                        Placeable placeableMo4159measureBRTryo0 = list.get(0).mo4159measureBRTryo0(j);
                        Placeable placeableMo4159measureBRTryo1 = list.get(1).mo4159measureBRTryo0(j);
                        return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo1.getWidth(), placeableMo4159measureBRTryo1.getHeight(), null, new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1(placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo0, drawerStateRememberDrawerState), 4, null);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Modifier.Companion companion15 = Modifier.Companion;
                Density density18 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection18 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration18 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion14.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf18 = LayoutKt.materializerOf(companion15);
                Modifier modifier8 = modifier2;
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl18 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl18, measurePolicy5, companion14.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl18, density18, companion14.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl18, layoutDirection18, companion14.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl18, viewConfiguration18, companion14.getSetViewConfiguration());
                interfaceC0552GpMaterializerOf18.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                Modifier modifierSemantics$default5 = SemanticsModifierKt.semantics$default(companion15, false, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1(strM1841getStringNWtq212, drawerStateRememberDrawerState, coroutineScope5), 1, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy14 = BoxKt.rememberBoxMeasurePolicy(companion13.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density19 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection19 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration19 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor3 = companion14.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf19 = LayoutKt.materializerOf(modifierSemantics$default5);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl19 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl19, measurePolicyRememberBoxMeasurePolicy14, companion14.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl19, density19, companion14.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl19, layoutDirection19, companion14.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl19, viewConfiguration19, companion14.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf19.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy15 = BoxKt.rememberBoxMeasurePolicy(companion13.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density110 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection110 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration110 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor4 = companion14.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf110 = LayoutKt.materializerOf(companion15);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl110 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl110, measurePolicyRememberBoxMeasurePolicy15, companion14.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl110, density110, companion14.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl110, layoutDirection110, companion14.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl110, viewConfiguration110, companion14.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z9;
                drawerState2 = drawerStateRememberDrawerState;
                modifier3 = modifier8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0526Fp, modifier3, drawerState2, z4, interfaceC0526Fp2, i, i2));
        }
        i3 |= 3072;
        z2 = z;
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i3 |= i6;
        }
        if ((46811 & i3) == 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                }
                if (i4 != 0) {
                    z2 = true;
                }
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                }
                if (i4 != 0) {
                    z2 = true;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(398812198, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:344)");
            }
            float f6 = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller6 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller6);
                objRememberedValue = compositionScopedCoroutineScopeCanceller6;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope6 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            String strM1841getStringNWtq213 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
            Map mapJ6 = AbstractC4243wx.j(HV.a(Float.valueOf(f6), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
            if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                z3 = true;
            } else {
                z3 = false;
            }
            Modifier modifierM1862swipeablepPrIpRY6 = SwipeableKt.m1862swipeablepPrIpRY(modifier2, drawerStateRememberDrawerState.getSwipeableState$material3_release(), mapJ6, Orientation.Horizontal, (32 & 8) != 0 ? true : z2, (32 & 16) != 0 ? false : z3, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : AnonymousClass1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ6.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion16 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy16 = BoxKt.rememberBoxMeasurePolicy(companion16.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density111 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection111 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration111 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion17 = ComposeUiNode.Companion;
            boolean z10 = z2;
            constructor = companion17.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf111 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY6);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl111 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl111, measurePolicyRememberBoxMeasurePolicy16, companion17.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl111, density111, companion17.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl111, layoutDirection111, companion17.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl111, viewConfiguration111, companion17.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
            MeasurePolicy measurePolicy6 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    Placeable placeableMo4159measureBRTryo0 = list.get(0).mo4159measureBRTryo0(j);
                    Placeable placeableMo4159measureBRTryo1 = list.get(1).mo4159measureBRTryo0(j);
                    return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo1.getWidth(), placeableMo4159measureBRTryo1.getHeight(), null, new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1(placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo0, drawerStateRememberDrawerState), 4, null);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion18 = Modifier.Companion;
            Density density112 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection112 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration112 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor2 = companion17.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf112 = LayoutKt.materializerOf(companion18);
            Modifier modifier9 = modifier2;
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2661constructorimpl112 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl112, measurePolicy6, companion17.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl112, density112, companion17.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl112, layoutDirection112, companion17.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl112, viewConfiguration112, companion17.getSetViewConfiguration());
            interfaceC0552GpMaterializerOf112.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            Modifier modifierSemantics$default6 = SemanticsModifierKt.semantics$default(companion18, false, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1(strM1841getStringNWtq213, drawerStateRememberDrawerState, coroutineScope6), 1, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy17 = BoxKt.rememberBoxMeasurePolicy(companion16.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density113 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection113 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration113 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor3 = companion17.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf113 = LayoutKt.materializerOf(modifierSemantics$default6);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl113 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl113, measurePolicyRememberBoxMeasurePolicy17, companion17.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl113, density113, companion17.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl113, layoutDirection113, companion17.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl113, viewConfiguration113, companion17.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf113.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy18 = BoxKt.rememberBoxMeasurePolicy(companion16.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density114 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection114 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration114 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor4 = companion17.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf114 = LayoutKt.materializerOf(companion18);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl114 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl114, measurePolicyRememberBoxMeasurePolicy18, companion17.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl114, density114, companion17.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl114, layoutDirection114, companion17.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl114, viewConfiguration114, companion17.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf114.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z10;
            drawerState2 = drawerStateRememberDrawerState;
            modifier3 = modifier9;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                }
                if (i4 != 0) {
                    z2 = true;
                }
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                }
                if (i4 != 0) {
                    z2 = true;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(398812198, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:344)");
            }
            float f7 = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller7 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller7);
                objRememberedValue = compositionScopedCoroutineScopeCanceller7;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope7 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            String strM1841getStringNWtq214 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
            Map mapJ7 = AbstractC4243wx.j(HV.a(Float.valueOf(f7), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
            if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                z3 = true;
            } else {
                z3 = false;
            }
            Modifier modifierM1862swipeablepPrIpRY7 = SwipeableKt.m1862swipeablepPrIpRY(modifier2, drawerStateRememberDrawerState.getSwipeableState$material3_release(), mapJ7, Orientation.Horizontal, (32 & 8) != 0 ? true : z2, (32 & 16) != 0 ? false : z3, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : AnonymousClass1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ7.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion19 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy19 = BoxKt.rememberBoxMeasurePolicy(companion19.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density115 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection115 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration115 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion110 = ComposeUiNode.Companion;
            boolean z11 = z2;
            constructor = companion110.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf115 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY7);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl115 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl115, measurePolicyRememberBoxMeasurePolicy19, companion110.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl115, density115, companion110.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl115, layoutDirection115, companion110.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl115, viewConfiguration115, companion110.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf115.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
            MeasurePolicy measurePolicy7 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    Placeable placeableMo4159measureBRTryo0 = list.get(0).mo4159measureBRTryo0(j);
                    Placeable placeableMo4159measureBRTryo1 = list.get(1).mo4159measureBRTryo0(j);
                    return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo1.getWidth(), placeableMo4159measureBRTryo1.getHeight(), null, new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$measure$1(placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo0, drawerStateRememberDrawerState), 4, null);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion111 = Modifier.Companion;
            Density density116 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection116 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration116 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor2 = companion110.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf116 = LayoutKt.materializerOf(companion111);
            Modifier modifier10 = modifier2;
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2661constructorimpl116 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl116, measurePolicy7, companion110.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl116, density116, companion110.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl116, layoutDirection116, companion110.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl116, viewConfiguration116, companion110.getSetViewConfiguration());
            interfaceC0552GpMaterializerOf116.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            Modifier modifierSemantics$default7 = SemanticsModifierKt.semantics$default(companion111, false, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1(strM1841getStringNWtq214, drawerStateRememberDrawerState, coroutineScope7), 1, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy110 = BoxKt.rememberBoxMeasurePolicy(companion19.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density117 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection117 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration117 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor3 = companion110.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf117 = LayoutKt.materializerOf(modifierSemantics$default7);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl117 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl117, measurePolicyRememberBoxMeasurePolicy110, companion110.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl117, density117, companion110.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl117, layoutDirection117, companion110.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl117, viewConfiguration117, companion110.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf117.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy111 = BoxKt.rememberBoxMeasurePolicy(companion19.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density118 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection118 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration118 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor4 = companion110.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf118 = LayoutKt.materializerOf(companion111);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl118 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl118, measurePolicyRememberBoxMeasurePolicy111, companion110.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl118, density118, companion110.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl118, layoutDirection118, companion110.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl118, viewConfiguration118, companion110.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf118.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z11;
            drawerState2 = drawerStateRememberDrawerState;
            modifier3 = modifier10;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(interfaceC0526Fp, modifier3, drawerState2, z4, interfaceC0526Fp2, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x0123  */
    /* JADX WARN: Code duplicated, block: B:103:0x0131  */
    /* JADX WARN: Code duplicated, block: B:106:0x0136  */
    /* JADX WARN: Code duplicated, block: B:107:0x0140  */
    /* JADX WARN: Code duplicated, block: B:109:0x0143  */
    /* JADX WARN: Code duplicated, block: B:113:0x0155  */
    /* JADX WARN: Code duplicated, block: B:116:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:121:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0045  */
    /* JADX WARN: Code duplicated, block: B:28:0x004a  */
    /* JADX WARN: Code duplicated, block: B:30:0x004e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0056  */
    /* JADX WARN: Code duplicated, block: B:33:0x0059  */
    /* JADX WARN: Code duplicated, block: B:37:0x0060  */
    /* JADX WARN: Code duplicated, block: B:39:0x0066  */
    /* JADX WARN: Code duplicated, block: B:42:0x006f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0073  */
    /* JADX WARN: Code duplicated, block: B:47:0x007c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0080  */
    /* JADX WARN: Code duplicated, block: B:51:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x008b  */
    /* JADX WARN: Code duplicated, block: B:55:0x0091  */
    /* JADX WARN: Code duplicated, block: B:58:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x009e  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00af  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:94:0x0110 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0112  */
    /* JADX WARN: Code duplicated, block: B:96:0x0115  */
    /* JADX WARN: Code duplicated, block: B:98:0x0119  */
    /* JADX WARN: Code duplicated, block: B:99:0x011e  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: DrawerSheet-vywBR7E, reason: not valid java name */
    public static final void m1667DrawerSheetvywBR7E(WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        int i4;
        Shape shape2;
        int i5;
        long j3;
        long j4;
        int i6;
        float fM1547getPermanentDrawerElevationD9Ej5fM;
        int i7;
        int i8;
        Modifier modifier2;
        Shape rectangleShape;
        long jM1413getSurface0d7_KjU;
        long jM1449contentColorForek8zF_U;
        long j5;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(175072821);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 7168) == 0) {
                    j3 = j;
                    if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(j3)) {
                        i9 = 1024;
                    } else {
                        i9 = 2048;
                    }
                    i3 |= i9;
                } else {
                    j3 = j;
                }
                if ((i & 57344) == 0) {
                    if ((i2 & 16) == 0) {
                        j4 = j2;
                        int i11 = composerStartRestartGroup.changed(j4) ? 16384 : 8192;
                        i3 |= i11;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    fM1547getPermanentDrawerElevationD9Ej5fM = f;
                } else {
                    fM1547getPermanentDrawerElevationD9Ej5fM = f;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(fM1547getPermanentDrawerElevationD9Ej5fM)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                }
                if ((i2 & 64) != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i8 = 1048576;
                        } else {
                            i8 = 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            } else {
                                rectangleShape = shape2;
                            }
                            if ((i2 & 8) != 0) {
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                                i3 &= -7169;
                            } else {
                                jM1413getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 16) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                                i3 &= -57345;
                            } else {
                                jM1449contentColorForek8zF_U = j4;
                            }
                            if (i6 != 0) {
                                fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                            }
                            j5 = jM1449contentColorForek8zF_U;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            modifier2 = modifier;
                            rectangleShape = shape2;
                            jM1413getSurface0d7_KjU = j3;
                            j5 = j4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
                        }
                        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
                        int i12 = i3 >> 3;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda, composerStartRestartGroup, (i12 & 112) | 12582912 | (i12 & 896) | (i12 & 7168) | (i12 & 57344), 96);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        rectangleShape = shape2;
                        jM1413getSurface0d7_KjU = j3;
                        j5 = j4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DrawerSheet$2(windowInsets, modifier3, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, interfaceC0552Gp, i, i2));
                }
                i8 = 1572864;
                i3 |= i8;
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -7169;
                        } else {
                            jM1413getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 16) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        } else {
                            jM1449contentColorForek8zF_U = j4;
                        }
                        if (i6 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        j5 = jM1449contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -7169;
                        } else {
                            jM1413getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 16) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        } else {
                            jM1449contentColorForek8zF_U = j4;
                        }
                        if (i6 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        j5 = jM1449contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
                    }
                    Modifier modifierFillMaxHeight$default2 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
                    int i13 = i3 >> 3;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default2, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda2, composerStartRestartGroup, (i13 & 112) | 12582912 | (i13 & 896) | (i13 & 7168) | (i13 & 57344), 96);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -7169;
                        } else {
                            jM1413getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 16) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        } else {
                            jM1449contentColorForek8zF_U = j4;
                        }
                        if (i6 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        j5 = jM1449contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -7169;
                        } else {
                            jM1413getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 16) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        } else {
                            jM1449contentColorForek8zF_U = j4;
                        }
                        if (i6 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        j5 = jM1449contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
                    }
                    Modifier modifierFillMaxHeight$default3 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
                    int i14 = i3 >> 3;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default3, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda3, composerStartRestartGroup, (i14 & 112) | 12582912 | (i14 & 896) | (i14 & 7168) | (i14 & 57344), 96);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DrawerSheet$2(windowInsets, modifier3, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, interfaceC0552Gp, i, i2));
            }
            i3 |= 384;
            shape2 = shape;
            if ((i & 7168) == 0) {
                j3 = j;
                if ((i2 & 8) == 0) {
                    i9 = 1024;
                } else {
                    i9 = 1024;
                }
                i3 |= i9;
            } else {
                j3 = j;
            }
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                i3 |= i11;
            } else {
                j4 = j2;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                fM1547getPermanentDrawerElevationD9Ej5fM = f;
            } else {
                fM1547getPermanentDrawerElevationD9Ej5fM = f;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(fM1547getPermanentDrawerElevationD9Ej5fM)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -7169;
                        } else {
                            jM1413getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 16) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        } else {
                            jM1449contentColorForek8zF_U = j4;
                        }
                        if (i6 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        j5 = jM1449contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -7169;
                        } else {
                            jM1413getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 16) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        } else {
                            jM1449contentColorForek8zF_U = j4;
                        }
                        if (i6 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        j5 = jM1449contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
                    }
                    Modifier modifierFillMaxHeight$default4 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
                    ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
                    int i15 = i3 >> 3;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default4, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda4, composerStartRestartGroup, (i15 & 112) | 12582912 | (i15 & 896) | (i15 & 7168) | (i15 & 57344), 96);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -7169;
                        } else {
                            jM1413getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 16) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        } else {
                            jM1449contentColorForek8zF_U = j4;
                        }
                        if (i6 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        j5 = jM1449contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -7169;
                        } else {
                            jM1413getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 16) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        } else {
                            jM1449contentColorForek8zF_U = j4;
                        }
                        if (i6 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        j5 = jM1449contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
                    }
                    Modifier modifierFillMaxHeight$default5 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
                    ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
                    int i16 = i3 >> 3;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default5, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda5, composerStartRestartGroup, (i16 & 112) | 12582912 | (i16 & 896) | (i16 & 7168) | (i16 & 57344), 96);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DrawerSheet$2(windowInsets, modifier3, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, interfaceC0552Gp, i, i2));
            }
            i8 = 1572864;
            i3 |= i8;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -7169;
                    } else {
                        jM1413getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j4;
                    }
                    if (i6 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    j5 = jM1449contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -7169;
                    } else {
                        jM1413getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j4;
                    }
                    if (i6 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    j5 = jM1449contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
                }
                Modifier modifierFillMaxHeight$default6 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
                ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
                int i17 = i3 >> 3;
                SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default6, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda6, composerStartRestartGroup, (i17 & 112) | 12582912 | (i17 & 896) | (i17 & 7168) | (i17 & 57344), 96);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -7169;
                    } else {
                        jM1413getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j4;
                    }
                    if (i6 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    j5 = jM1449contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -7169;
                    } else {
                        jM1413getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j4;
                    }
                    if (i6 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    j5 = jM1449contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
                }
                Modifier modifierFillMaxHeight$default7 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
                ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
                int i18 = i3 >> 3;
                SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default7, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda7, composerStartRestartGroup, (i18 & 112) | 12582912 | (i18 & 896) | (i18 & 7168) | (i18 & 57344), 96);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DrawerSheet$2(windowInsets, modifier3, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, interfaceC0552Gp, i, i2));
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 7168) == 0) {
                j3 = j;
                if ((i2 & 8) == 0) {
                    i9 = 1024;
                } else {
                    i9 = 1024;
                }
                i3 |= i9;
            } else {
                j3 = j;
            }
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                    }
                    i3 |= i11;
                } else {
                    j4 = j2;
                }
                i3 |= i11;
            } else {
                j4 = j2;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                fM1547getPermanentDrawerElevationD9Ej5fM = f;
            } else {
                fM1547getPermanentDrawerElevationD9Ej5fM = f;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(fM1547getPermanentDrawerElevationD9Ej5fM)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -7169;
                        } else {
                            jM1413getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 16) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        } else {
                            jM1449contentColorForek8zF_U = j4;
                        }
                        if (i6 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        j5 = jM1449contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -7169;
                        } else {
                            jM1413getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 16) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        } else {
                            jM1449contentColorForek8zF_U = j4;
                        }
                        if (i6 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        j5 = jM1449contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
                    }
                    Modifier modifierFillMaxHeight$default8 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
                    ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
                    int i19 = i3 >> 3;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default8, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda8, composerStartRestartGroup, (i19 & 112) | 12582912 | (i19 & 896) | (i19 & 7168) | (i19 & 57344), 96);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -7169;
                        } else {
                            jM1413getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 16) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        } else {
                            jM1449contentColorForek8zF_U = j4;
                        }
                        if (i6 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        j5 = jM1449contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -7169;
                        } else {
                            jM1413getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 16) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        } else {
                            jM1449contentColorForek8zF_U = j4;
                        }
                        if (i6 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        j5 = jM1449contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
                    }
                    Modifier modifierFillMaxHeight$default9 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
                    ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
                    int i110 = i3 >> 3;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default9, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda9, composerStartRestartGroup, (i110 & 112) | 12582912 | (i110 & 896) | (i110 & 7168) | (i110 & 57344), 96);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DrawerSheet$2(windowInsets, modifier3, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, interfaceC0552Gp, i, i2));
            }
            i8 = 1572864;
            i3 |= i8;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -7169;
                    } else {
                        jM1413getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j4;
                    }
                    if (i6 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    j5 = jM1449contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -7169;
                    } else {
                        jM1413getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j4;
                    }
                    if (i6 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    j5 = jM1449contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
                }
                Modifier modifierFillMaxHeight$default10 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
                ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
                int i111 = i3 >> 3;
                SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default10, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda10, composerStartRestartGroup, (i111 & 112) | 12582912 | (i111 & 896) | (i111 & 7168) | (i111 & 57344), 96);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -7169;
                    } else {
                        jM1413getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j4;
                    }
                    if (i6 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    j5 = jM1449contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -7169;
                    } else {
                        jM1413getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j4;
                    }
                    if (i6 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    j5 = jM1449contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
                }
                Modifier modifierFillMaxHeight$default11 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
                ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
                int i112 = i3 >> 3;
                SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default11, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda11, composerStartRestartGroup, (i112 & 112) | 12582912 | (i112 & 896) | (i112 & 7168) | (i112 & 57344), 96);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DrawerSheet$2(windowInsets, modifier3, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        shape2 = shape;
        if ((i & 7168) == 0) {
            j3 = j;
            if ((i2 & 8) == 0) {
                i9 = 1024;
            } else {
                i9 = 1024;
            }
            i3 |= i9;
        } else {
            j3 = j;
        }
        if ((i & 57344) == 0) {
            if ((i2 & 16) == 0) {
                j4 = j2;
                if (composerStartRestartGroup.changed(j4)) {
                }
                i3 |= i11;
            } else {
                j4 = j2;
            }
            i3 |= i11;
        } else {
            j4 = j2;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            fM1547getPermanentDrawerElevationD9Ej5fM = f;
        } else {
            fM1547getPermanentDrawerElevationD9Ej5fM = f;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(fM1547getPermanentDrawerElevationD9Ej5fM)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
        }
        if ((i2 & 64) != 0) {
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -7169;
                    } else {
                        jM1413getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j4;
                    }
                    if (i6 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    j5 = jM1449contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -7169;
                    } else {
                        jM1413getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j4;
                    }
                    if (i6 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    j5 = jM1449contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
                }
                Modifier modifierFillMaxHeight$default12 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
                ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
                int i113 = i3 >> 3;
                SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default12, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda12, composerStartRestartGroup, (i113 & 112) | 12582912 | (i113 & 896) | (i113 & 7168) | (i113 & 57344), 96);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -7169;
                    } else {
                        jM1413getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j4;
                    }
                    if (i6 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    j5 = jM1449contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -7169;
                    } else {
                        jM1413getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 16) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    } else {
                        jM1449contentColorForek8zF_U = j4;
                    }
                    if (i6 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    j5 = jM1449contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
                }
                Modifier modifierFillMaxHeight$default13 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
                ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
                int i114 = i3 >> 3;
                SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default13, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda13, composerStartRestartGroup, (i114 & 112) | 12582912 | (i114 & 896) | (i114 & 7168) | (i114 & 57344), 96);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DrawerSheet$2(windowInsets, modifier3, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, interfaceC0552Gp, i, i2));
        }
        i8 = 1572864;
        i3 |= i8;
        if ((i3 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -7169;
                } else {
                    jM1413getSurface0d7_KjU = j3;
                }
                if ((i2 & 16) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                } else {
                    jM1449contentColorForek8zF_U = j4;
                }
                if (i6 != 0) {
                    fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                }
                j5 = jM1449contentColorForek8zF_U;
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -7169;
                } else {
                    jM1413getSurface0d7_KjU = j3;
                }
                if ((i2 & 16) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                } else {
                    jM1449contentColorForek8zF_U = j4;
                }
                if (i6 != 0) {
                    fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                }
                j5 = jM1449contentColorForek8zF_U;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
            }
            Modifier modifierFillMaxHeight$default14 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
            ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
            int i115 = i3 >> 3;
            SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default14, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda14, composerStartRestartGroup, (i115 & 112) | 12582912 | (i115 & 896) | (i115 & 7168) | (i115 & 57344), 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -7169;
                } else {
                    jM1413getSurface0d7_KjU = j3;
                }
                if ((i2 & 16) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                } else {
                    jM1449contentColorForek8zF_U = j4;
                }
                if (i6 != 0) {
                    fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                }
                j5 = jM1449contentColorForek8zF_U;
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -7169;
                } else {
                    jM1413getSurface0d7_KjU = j3;
                }
                if ((i2 & 16) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                } else {
                    jM1449contentColorForek8zF_U = j4;
                }
                if (i6 != 0) {
                    fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                }
                j5 = jM1449contentColorForek8zF_U;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:552)");
            }
            Modifier modifierFillMaxHeight$default15 = SizeKt.fillMaxHeight$default(SizeKt.m536sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1545getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null);
            ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 959363152, true, new NavigationDrawerKt$DrawerSheet$1(windowInsets, interfaceC0552Gp, i3));
            int i116 = i3 >> 3;
            SurfaceKt.m1850SurfaceT9BRK9s(modifierFillMaxHeight$default15, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, 0.0f, null, composableLambda15, composerStartRestartGroup, (i116 & 112) | 12582912 | (i116 & 896) | (i116 & 7168) | (i116 & 57344), 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$DrawerSheet$2(windowInsets, modifier3, rectangleShape, jM1413getSurface0d7_KjU, j5, fM1547getPermanentDrawerElevationD9Ej5fM, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x012c  */
    /* JADX WARN: Code duplicated, block: B:103:0x012f  */
    /* JADX WARN: Code duplicated, block: B:106:0x0135  */
    /* JADX WARN: Code duplicated, block: B:109:0x0142  */
    /* JADX WARN: Code duplicated, block: B:112:0x0152  */
    /* JADX WARN: Code duplicated, block: B:114:0x015f  */
    /* JADX WARN: Code duplicated, block: B:117:0x016a  */
    /* JADX WARN: Code duplicated, block: B:118:0x017d  */
    /* JADX WARN: Code duplicated, block: B:121:0x0191  */
    /* JADX WARN: Code duplicated, block: B:124:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:129:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fc  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ModalDrawerSheet-afqeVBk, reason: not valid java name */
    public static final void m1668ModalDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        long jM1413getSurface0d7_KjU;
        long jM1449contentColorForek8zF_U;
        float fM1546getModalDrawerElevationD9Ej5fM;
        WindowInsets windowInsets2;
        int i4;
        Modifier modifier3;
        Shape shape3;
        long j3;
        long j4;
        float f2;
        WindowInsets windowInsets3;
        Modifier modifier4;
        Modifier modifier5;
        Shape shape4;
        long j5;
        long j6;
        float f3;
        WindowInsets windowInsets4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i5;
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1001163336);
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                int i7 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i3 |= i7;
            } else {
                shape2 = shape;
            }
            i3 |= i7;
        } else {
            shape2 = shape;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                jM1413getSurface0d7_KjU = j;
                int i8 = composerStartRestartGroup.changed(jM1413getSurface0d7_KjU) ? 256 : 128;
                i3 |= i8;
            } else {
                jM1413getSurface0d7_KjU = j;
            }
            i3 |= i8;
        } else {
            jM1413getSurface0d7_KjU = j;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                jM1449contentColorForek8zF_U = j2;
                int i9 = composerStartRestartGroup.changed(jM1449contentColorForek8zF_U) ? 2048 : 1024;
                i3 |= i9;
            } else {
                jM1449contentColorForek8zF_U = j2;
            }
            i3 |= i9;
        } else {
            jM1449contentColorForek8zF_U = j2;
        }
        int i10 = i2 & 16;
        if (i10 == 0) {
            if ((i & 57344) == 0) {
                fM1546getModalDrawerElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM1546getModalDrawerElevationD9Ej5fM) ? 16384 : 8192;
            }
            if ((i & 458752) == 0) {
                windowInsets2 = windowInsets;
                if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(windowInsets2)) {
                    i5 = 65536;
                } else {
                    i5 = 131072;
                }
                i3 |= i5;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i4 = 1048576;
                    } else {
                        i4 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i10 != 0) {
                            fM1546getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1546getModalDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier4 = modifier3;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            shape3 = shape2;
                            j3 = jM1413getSurface0d7_KjU;
                            j4 = jM1449contentColorForek8zF_U;
                            f2 = fM1546getModalDrawerElevationD9Ej5fM;
                        } else {
                            shape3 = shape2;
                            j3 = jM1413getSurface0d7_KjU;
                            j4 = jM1449contentColorForek8zF_U;
                            f2 = fM1546getModalDrawerElevationD9Ej5fM;
                            windowInsets3 = windowInsets2;
                            modifier4 = modifier3;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        modifier4 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1001163336, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:454)");
                    }
                    int i11 = i3 << 3;
                    m1667DrawerSheetvywBR7E(windowInsets3, modifier4, shape3, j3, j4, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (i11 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    shape4 = shape3;
                    j5 = j3;
                    j6 = j4;
                    f3 = f2;
                    windowInsets4 = windowInsets3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier5 = modifier2;
                    shape4 = shape2;
                    j5 = jM1413getSurface0d7_KjU;
                    j6 = jM1449contentColorForek8zF_U;
                    f3 = fM1546getModalDrawerElevationD9Ej5fM;
                    windowInsets4 = windowInsets2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$ModalDrawerSheet$1(modifier5, shape4, j5, j6, f3, windowInsets4, interfaceC0552Gp, i, i2));
            }
            i4 = 1572864;
            i3 |= i4;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i10 != 0) {
                        fM1546getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1546getModalDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier4 = modifier3;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                    } else {
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        modifier4 = modifier3;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i10 != 0) {
                        fM1546getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1546getModalDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier4 = modifier3;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                    } else {
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        modifier4 = modifier3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1001163336, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:454)");
                }
                int i12 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifier4, shape3, j3, j4, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (i12 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                shape4 = shape3;
                j5 = j3;
                j6 = j4;
                f3 = f2;
                windowInsets4 = windowInsets3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i10 != 0) {
                        fM1546getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1546getModalDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier4 = modifier3;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                    } else {
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        modifier4 = modifier3;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i10 != 0) {
                        fM1546getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1546getModalDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier4 = modifier3;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                    } else {
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        modifier4 = modifier3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1001163336, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:454)");
                }
                int i13 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifier4, shape3, j3, j4, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (i13 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                shape4 = shape3;
                j5 = j3;
                j6 = j4;
                f3 = f2;
                windowInsets4 = windowInsets3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$ModalDrawerSheet$1(modifier5, shape4, j5, j6, f3, windowInsets4, interfaceC0552Gp, i, i2));
        }
        i3 |= 24576;
        fM1546getModalDrawerElevationD9Ej5fM = f;
        if ((i & 458752) == 0) {
            windowInsets2 = windowInsets;
            if ((i2 & 32) == 0) {
                i5 = 65536;
            } else {
                i5 = 65536;
            }
            i3 |= i5;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i2 & 64) != 0) {
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i4 = 1048576;
                } else {
                    i4 = 524288;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i10 != 0) {
                        fM1546getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1546getModalDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier4 = modifier3;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                    } else {
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        modifier4 = modifier3;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i10 != 0) {
                        fM1546getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1546getModalDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier4 = modifier3;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                    } else {
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        modifier4 = modifier3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1001163336, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:454)");
                }
                int i14 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifier4, shape3, j3, j4, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i14 & 112) | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (i14 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                shape4 = shape3;
                j5 = j3;
                j6 = j4;
                f3 = f2;
                windowInsets4 = windowInsets3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i10 != 0) {
                        fM1546getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1546getModalDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier4 = modifier3;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                    } else {
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        modifier4 = modifier3;
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i10 != 0) {
                        fM1546getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1546getModalDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier4 = modifier3;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                    } else {
                        shape3 = shape2;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f2 = fM1546getModalDrawerElevationD9Ej5fM;
                        windowInsets3 = windowInsets2;
                        modifier4 = modifier3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1001163336, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:454)");
                }
                int i15 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifier4, shape3, j3, j4, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i15 & 112) | (i15 & 896) | (i15 & 7168) | (57344 & i15) | (i15 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                shape4 = shape3;
                j5 = j3;
                j6 = j4;
                f3 = f2;
                windowInsets4 = windowInsets3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$ModalDrawerSheet$1(modifier5, shape4, j5, j6, f3, windowInsets4, interfaceC0552Gp, i, i2));
        }
        i4 = 1572864;
        i3 |= i4;
        if ((i3 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 4) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i10 != 0) {
                    fM1546getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1546getModalDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    modifier4 = modifier3;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    shape3 = shape2;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f2 = fM1546getModalDrawerElevationD9Ej5fM;
                } else {
                    shape3 = shape2;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f2 = fM1546getModalDrawerElevationD9Ej5fM;
                    windowInsets3 = windowInsets2;
                    modifier4 = modifier3;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 4) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i10 != 0) {
                    fM1546getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1546getModalDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    modifier4 = modifier3;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    shape3 = shape2;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f2 = fM1546getModalDrawerElevationD9Ej5fM;
                } else {
                    shape3 = shape2;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f2 = fM1546getModalDrawerElevationD9Ej5fM;
                    windowInsets3 = windowInsets2;
                    modifier4 = modifier3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1001163336, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:454)");
            }
            int i16 = i3 << 3;
            m1667DrawerSheetvywBR7E(windowInsets3, modifier4, shape3, j3, j4, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (i16 & 458752) | (i3 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            shape4 = shape3;
            j5 = j3;
            j6 = j4;
            f3 = f2;
            windowInsets4 = windowInsets3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 4) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i10 != 0) {
                    fM1546getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1546getModalDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    modifier4 = modifier3;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    shape3 = shape2;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f2 = fM1546getModalDrawerElevationD9Ej5fM;
                } else {
                    shape3 = shape2;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f2 = fM1546getModalDrawerElevationD9Ej5fM;
                    windowInsets3 = windowInsets2;
                    modifier4 = modifier3;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 4) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i10 != 0) {
                    fM1546getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1546getModalDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    modifier4 = modifier3;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    shape3 = shape2;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f2 = fM1546getModalDrawerElevationD9Ej5fM;
                } else {
                    shape3 = shape2;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f2 = fM1546getModalDrawerElevationD9Ej5fM;
                    windowInsets3 = windowInsets2;
                    modifier4 = modifier3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1001163336, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:454)");
            }
            int i17 = i3 << 3;
            m1667DrawerSheetvywBR7E(windowInsets3, modifier4, shape3, j3, j4, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i17 & 112) | (i17 & 896) | (i17 & 7168) | (57344 & i17) | (i17 & 458752) | (i3 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            shape4 = shape3;
            j5 = j3;
            j6 = j4;
            f3 = f2;
            windowInsets4 = windowInsets3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$ModalDrawerSheet$1(modifier5, shape4, j5, j6, f3, windowInsets4, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0159  */
    /* JADX WARN: Code duplicated, block: B:104:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:105:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:108:0x0232  */
    /* JADX WARN: Code duplicated, block: B:111:0x023e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0242  */
    /* JADX WARN: Code duplicated, block: B:115:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:118:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:119:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:122:0x035b  */
    /* JADX WARN: Code duplicated, block: B:124:0x0361  */
    /* JADX WARN: Code duplicated, block: B:127:0x0392  */
    /* JADX WARN: Code duplicated, block: B:129:0x0398  */
    /* JADX WARN: Code duplicated, block: B:132:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:135:0x0406  */
    /* JADX WARN: Code duplicated, block: B:136:0x040a  */
    /* JADX WARN: Code duplicated, block: B:139:0x0472  */
    /* JADX WARN: Code duplicated, block: B:144:0x0481  */
    /* JADX WARN: Code duplicated, block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0057  */
    /* JADX WARN: Code duplicated, block: B:28:0x005b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0063  */
    /* JADX WARN: Code duplicated, block: B:31:0x0066  */
    /* JADX WARN: Code duplicated, block: B:34:0x006d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    /* JADX WARN: Code duplicated, block: B:39:0x0078  */
    /* JADX WARN: Code duplicated, block: B:41:0x007c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0084  */
    /* JADX WARN: Code duplicated, block: B:44:0x0087  */
    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:50:0x0096  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:84:0x0103 A[PHI: r0 r9 r12 r13
      0x0103: PHI (r0v23 boolean) = (r0v3 boolean), (r0v2 boolean), (r0v2 boolean) binds: [B:94:0x0121, B:82:0x0100, B:83:0x0102] A[DONT_GENERATE, DONT_INLINE]
      0x0103: PHI (r9v47 int) = (r9v17 int), (r9v48 int), (r9v49 int) binds: [B:94:0x0121, B:82:0x0100, B:83:0x0102] A[DONT_GENERATE, DONT_INLINE]
      0x0103: PHI (r12v11 androidx.compose.ui.Modifier) = (r12v3 androidx.compose.ui.Modifier), (r12v2 androidx.compose.ui.Modifier), (r12v2 androidx.compose.ui.Modifier) binds: [B:94:0x0121, B:82:0x0100, B:83:0x0102] A[DONT_GENERATE, DONT_INLINE]
      0x0103: PHI (r13v11 androidx.compose.material3.DrawerState) = 
      (r13v7 androidx.compose.material3.DrawerState)
      (r13v6 androidx.compose.material3.DrawerState)
      (r13v6 androidx.compose.material3.DrawerState)
     binds: [B:94:0x0121, B:82:0x0100, B:83:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x0109 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x010b  */
    /* JADX WARN: Code duplicated, block: B:90:0x0112  */
    /* JADX WARN: Code duplicated, block: B:92:0x011e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0123  */
    /* JADX WARN: Code duplicated, block: B:98:0x0138  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ModalNavigationDrawer-FHprtrg, reason: not valid java name */
    public static final void m1669ModalNavigationDrawerFHprtrg(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, DrawerState drawerState, boolean z, long j, InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        DrawerState drawerStateRememberDrawerState;
        int i4;
        boolean z2;
        int i5;
        int i6;
        long j2;
        int i7;
        long scrimColor;
        DrawerState drawerState2;
        boolean z3;
        Modifier modifier3;
        int i8;
        Object objRememberedValue;
        Composer.Companion companion;
        float f;
        float f2;
        Object obj;
        boolean z4;
        InterfaceC3588op constructor;
        InterfaceC3588op constructor2;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composer2;
        boolean zChanged2;
        Object objRememberedValue3;
        InterfaceC3588op constructor3;
        boolean z5;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp, "drawerContent");
        AbstractC4492zt.h(interfaceC0526Fp2, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1169303680);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    drawerStateRememberDrawerState = drawerState;
                    int i10 = composerStartRestartGroup.changed(drawerStateRememberDrawerState) ? 256 : 128;
                    i3 |= i10;
                } else {
                    drawerStateRememberDrawerState = drawerState;
                }
                i3 |= i10;
            } else {
                drawerStateRememberDrawerState = drawerState;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 57344) == 0) {
                    if ((i2 & 16) == 0) {
                        i6 = i9;
                        j2 = j;
                        int i11 = composerStartRestartGroup.changed(j2) ? 16384 : 8192;
                        i3 |= i11;
                    } else {
                        i6 = i9;
                        j2 = j;
                    }
                    i3 |= i11;
                } else {
                    i6 = i9;
                    j2 = j;
                }
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                    }
                    if ((374491 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i6 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                drawerState2 = drawerStateRememberDrawerState;
                                z3 = z2;
                                modifier3 = modifier2;
                            }
                            i8 = i3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.Companion;
                            if (objRememberedValue == companion.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                objRememberedValue = compositionScopedCoroutineScopeCanceller;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                            f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                            Map mapJ = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                            if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                                f2 = 0.0f;
                                obj = null;
                                z4 = true;
                            } else {
                                f2 = 0.0f;
                                obj = null;
                                z4 = false;
                            }
                            Modifier modifierM1862swipeablepPrIpRY = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                            Modifier modifier5 = modifier3;
                            composerStartRestartGroup.startReplaceableGroup(733328855);
                            Alignment.Companion companion2 = Alignment.Companion;
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                            constructor = companion3.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl, density, companion3.getSetDensity());
                            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
                            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(733328855);
                            Modifier.Companion companion4 = Modifier.Companion;
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            constructor2 = companion3.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(companion4);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor2);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerStartRestartGroup.disableReusing();
                            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion3.getSetDensity());
                            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
                            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
                            composerStartRestartGroup.enableReusing();
                            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            boolean zIsOpen = drawerState2.isOpen();
                            NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$2 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope);
                            Float fValueOf = Float.valueOf(f);
                            Float fValueOf2 = Float.valueOf(0.0f);
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            zChanged = composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(fValueOf2) | composerStartRestartGroup.changed(drawerState2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                                objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            boolean z6 = z3;
                            composer2 = composerStartRestartGroup;
                            m1671ScrimBx497Mc(zIsOpen, navigationDrawerKt$ModalNavigationDrawer$2$2, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                            composer2.startReplaceableGroup(1157296644);
                            zChanged2 = composer2.changed(drawerState2);
                            objRememberedValue3 = composer2.rememberedValue();
                            if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                                objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                                composer2.updateRememberedValue(objRememberedValue3);
                            }
                            composer2.endReplaceableGroup();
                            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion4, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq28, drawerState2, coroutineScope), 1, null);
                            composer2.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            constructor3 = companion3.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierSemantics$default);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor3);
                            } else {
                                composer2.useNode();
                            }
                            composer2.disableReusing();
                            Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composer2);
                            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRememberBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl3, density3, companion3.getSetDensity());
                            Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion3.getSetLayoutDirection());
                            Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion3.getSetViewConfiguration());
                            composer2.enableReusing();
                            interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z6;
                            drawerStateRememberDrawerState = drawerState2;
                            modifier4 = modifier5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                        }
                        z3 = z2;
                        scrimColor = j2;
                        modifier3 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                        i8 = i3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller2;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        String strM1841getStringNWtq29 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                        f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                        Map mapJ2 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                        if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                            f2 = 0.0f;
                            obj = null;
                            z4 = true;
                        } else {
                            f2 = 0.0f;
                            obj = null;
                            z4 = false;
                        }
                        Modifier modifierM1862swipeablepPrIpRY2 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ2, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ2.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                        Modifier modifier6 = modifier3;
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        Alignment.Companion companion5 = Alignment.Companion;
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(companion5.getTopStart(), false, composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion6 = ComposeUiNode.Companion;
                        constructor = companion6.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpMaterializerOf4 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY2);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM2661constructorimpl4 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl4, measurePolicyRememberBoxMeasurePolicy4, companion6.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl4, density4, companion6.getSetDensity());
                        Updater.m2668setimpl(composerM2661constructorimpl4, layoutDirection4, companion6.getSetLayoutDirection());
                        Updater.m2668setimpl(composerM2661constructorimpl4, viewConfiguration4, companion6.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        interfaceC0552GpMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        Modifier.Companion companion7 = Modifier.Companion;
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(companion5.getTopStart(), false, composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection5 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        constructor2 = companion6.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpMaterializerOf5 = LayoutKt.materializerOf(companion7);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor2);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM2661constructorimpl5 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl5, measurePolicyRememberBoxMeasurePolicy5, companion6.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl5, density5, companion6.getSetDensity());
                        Updater.m2668setimpl(composerM2661constructorimpl5, layoutDirection5, companion6.getSetLayoutDirection());
                        Updater.m2668setimpl(composerM2661constructorimpl5, viewConfiguration5, companion6.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        interfaceC0552GpMaterializerOf5.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        boolean zIsOpen2 = drawerState2.isOpen();
                        NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$3 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope2);
                        Float fValueOf3 = Float.valueOf(f);
                        Float fValueOf4 = Float.valueOf(0.0f);
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        zChanged = composerStartRestartGroup.changed(fValueOf3) | composerStartRestartGroup.changed(fValueOf4) | composerStartRestartGroup.changed(drawerState2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        boolean z7 = z3;
                        composer2 = composerStartRestartGroup;
                        m1671ScrimBx497Mc(zIsOpen2, navigationDrawerKt$ModalNavigationDrawer$2$3, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                        composer2.startReplaceableGroup(1157296644);
                        zChanged2 = composer2.changed(drawerState2);
                        objRememberedValue3 = composer2.rememberedValue();
                        if (zChanged2) {
                            objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                            composer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion7, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq29, drawerState2, coroutineScope2), 1, null);
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(companion5.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        Density density6 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection6 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration6 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        constructor3 = companion6.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpMaterializerOf6 = LayoutKt.materializerOf(modifierSemantics$default2);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor3);
                        } else {
                            composer2.useNode();
                        }
                        composer2.disableReusing();
                        Composer composerM2661constructorimpl6 = Updater.m2661constructorimpl(composer2);
                        Updater.m2668setimpl(composerM2661constructorimpl6, measurePolicyRememberBoxMeasurePolicy6, companion6.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl6, density6, companion6.getSetDensity());
                        Updater.m2668setimpl(composerM2661constructorimpl6, layoutDirection6, companion6.getSetLayoutDirection());
                        Updater.m2668setimpl(composerM2661constructorimpl6, viewConfiguration6, companion6.getSetViewConfiguration());
                        composer2.enableReusing();
                        interfaceC0552GpMaterializerOf6.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z7;
                        drawerStateRememberDrawerState = drawerState2;
                        modifier4 = modifier6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z5 = z2;
                        scrimColor = j2;
                        modifier4 = modifier2;
                        composer2 = composerStartRestartGroup;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$ModalNavigationDrawer$3(interfaceC0526Fp, modifier4, drawerStateRememberDrawerState, z5, scrimColor, interfaceC0526Fp2, i, i2));
                }
                i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i7;
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i6 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            drawerState2 = drawerStateRememberDrawerState;
                            z3 = z2;
                            modifier3 = modifier2;
                        } else {
                            z3 = z2;
                            scrimColor = j2;
                            modifier3 = modifier2;
                            drawerState2 = drawerStateRememberDrawerState;
                        }
                    } else {
                        if (i6 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            drawerState2 = drawerStateRememberDrawerState;
                            z3 = z2;
                            modifier3 = modifier2;
                        } else {
                            z3 = z2;
                            scrimColor = j2;
                            modifier3 = modifier2;
                            drawerState2 = drawerStateRememberDrawerState;
                        }
                    }
                    i8 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller3 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller3);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller3;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope3 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    String strM1841getStringNWtq210 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                    Map mapJ3 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                    if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                        f2 = 0.0f;
                        obj = null;
                        z4 = true;
                    } else {
                        f2 = 0.0f;
                        obj = null;
                        z4 = false;
                    }
                    Modifier modifierM1862swipeablepPrIpRY3 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ3, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ3.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                    Modifier modifier7 = modifier3;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Alignment.Companion companion8 = Alignment.Companion;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(companion8.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density7 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection7 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration7 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion9 = ComposeUiNode.Companion;
                    constructor = companion9.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf7 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY3);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl7 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl7, measurePolicyRememberBoxMeasurePolicy7, companion9.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl7, density7, companion9.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl7, layoutDirection7, companion9.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl7, viewConfiguration7, companion9.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf7.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Modifier.Companion companion10 = Modifier.Companion;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy8 = BoxKt.rememberBoxMeasurePolicy(companion8.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density8 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection8 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration8 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor2 = companion9.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf8 = LayoutKt.materializerOf(companion10);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl8 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl8, measurePolicyRememberBoxMeasurePolicy8, companion9.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl8, density8, companion9.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl8, layoutDirection8, companion9.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl8, viewConfiguration8, companion9.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf8.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    boolean zIsOpen3 = drawerState2.isOpen();
                    NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$4 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope3);
                    Float fValueOf5 = Float.valueOf(f);
                    Float fValueOf6 = Float.valueOf(0.0f);
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(fValueOf5) | composerStartRestartGroup.changed(fValueOf6) | composerStartRestartGroup.changed(drawerState2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    boolean z8 = z3;
                    composer2 = composerStartRestartGroup;
                    m1671ScrimBx497Mc(zIsOpen3, navigationDrawerKt$ModalNavigationDrawer$2$4, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                    composer2.startReplaceableGroup(1157296644);
                    zChanged2 = composer2.changed(drawerState2);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion10, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq210, drawerState2, coroutineScope3), 1, null);
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy9 = BoxKt.rememberBoxMeasurePolicy(companion8.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density9 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection9 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration9 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor3 = companion9.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf9 = LayoutKt.materializerOf(modifierSemantics$default3);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM2661constructorimpl9 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl9, measurePolicyRememberBoxMeasurePolicy9, companion9.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl9, density9, companion9.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl9, layoutDirection9, companion9.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl9, viewConfiguration9, companion9.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf9.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z8;
                    drawerStateRememberDrawerState = drawerState2;
                    modifier4 = modifier7;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i6 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            drawerState2 = drawerStateRememberDrawerState;
                            z3 = z2;
                            modifier3 = modifier2;
                        } else {
                            z3 = z2;
                            scrimColor = j2;
                            modifier3 = modifier2;
                            drawerState2 = drawerStateRememberDrawerState;
                        }
                    } else {
                        if (i6 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            drawerState2 = drawerStateRememberDrawerState;
                            z3 = z2;
                            modifier3 = modifier2;
                        } else {
                            z3 = z2;
                            scrimColor = j2;
                            modifier3 = modifier2;
                            drawerState2 = drawerStateRememberDrawerState;
                        }
                    }
                    i8 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller4);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller4;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope4 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    String strM1841getStringNWtq211 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                    Map mapJ4 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                    if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                        f2 = 0.0f;
                        obj = null;
                        z4 = true;
                    } else {
                        f2 = 0.0f;
                        obj = null;
                        z4 = false;
                    }
                    Modifier modifierM1862swipeablepPrIpRY4 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ4, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ4.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                    Modifier modifier8 = modifier3;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Alignment.Companion companion11 = Alignment.Companion;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy10 = BoxKt.rememberBoxMeasurePolicy(companion11.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density10 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection10 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration10 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion12 = ComposeUiNode.Companion;
                    constructor = companion12.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf10 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY4);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl10 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl10, measurePolicyRememberBoxMeasurePolicy10, companion12.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl10, density10, companion12.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl10, layoutDirection10, companion12.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl10, viewConfiguration10, companion12.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf10.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Modifier.Companion companion13 = Modifier.Companion;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy11 = BoxKt.rememberBoxMeasurePolicy(companion11.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density11 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection11 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration11 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor2 = companion12.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf11 = LayoutKt.materializerOf(companion13);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl11 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl11, measurePolicyRememberBoxMeasurePolicy11, companion12.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl11, density11, companion12.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl11, layoutDirection11, companion12.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl11, viewConfiguration11, companion12.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf11.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    boolean zIsOpen4 = drawerState2.isOpen();
                    NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$5 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope4);
                    Float fValueOf7 = Float.valueOf(f);
                    Float fValueOf8 = Float.valueOf(0.0f);
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(fValueOf7) | composerStartRestartGroup.changed(fValueOf8) | composerStartRestartGroup.changed(drawerState2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    boolean z9 = z3;
                    composer2 = composerStartRestartGroup;
                    m1671ScrimBx497Mc(zIsOpen4, navigationDrawerKt$ModalNavigationDrawer$2$5, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                    composer2.startReplaceableGroup(1157296644);
                    zChanged2 = composer2.changed(drawerState2);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion13, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq211, drawerState2, coroutineScope4), 1, null);
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy12 = BoxKt.rememberBoxMeasurePolicy(companion11.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density12 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection12 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration12 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor3 = companion12.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf12 = LayoutKt.materializerOf(modifierSemantics$default4);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM2661constructorimpl12 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl12, measurePolicyRememberBoxMeasurePolicy12, companion12.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl12, density12, companion12.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl12, layoutDirection12, companion12.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl12, viewConfiguration12, companion12.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf12.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z9;
                    drawerStateRememberDrawerState = drawerState2;
                    modifier4 = modifier8;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$ModalNavigationDrawer$3(interfaceC0526Fp, modifier4, drawerStateRememberDrawerState, z5, scrimColor, interfaceC0526Fp2, i, i2));
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    i6 = i9;
                    j2 = j;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i3 |= i11;
                } else {
                    i6 = i9;
                    j2 = j;
                }
                i3 |= i11;
            } else {
                i6 = i9;
                j2 = j;
            }
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i6 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            drawerState2 = drawerStateRememberDrawerState;
                            z3 = z2;
                            modifier3 = modifier2;
                        } else {
                            z3 = z2;
                            scrimColor = j2;
                            modifier3 = modifier2;
                            drawerState2 = drawerStateRememberDrawerState;
                        }
                    } else {
                        if (i6 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            drawerState2 = drawerStateRememberDrawerState;
                            z3 = z2;
                            modifier3 = modifier2;
                        } else {
                            z3 = z2;
                            scrimColor = j2;
                            modifier3 = modifier2;
                            drawerState2 = drawerStateRememberDrawerState;
                        }
                    }
                    i8 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller5 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller5);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller5;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope5 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    String strM1841getStringNWtq212 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                    Map mapJ5 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                    if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                        f2 = 0.0f;
                        obj = null;
                        z4 = true;
                    } else {
                        f2 = 0.0f;
                        obj = null;
                        z4 = false;
                    }
                    Modifier modifierM1862swipeablepPrIpRY5 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ5, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ5.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                    Modifier modifier9 = modifier3;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Alignment.Companion companion14 = Alignment.Companion;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy13 = BoxKt.rememberBoxMeasurePolicy(companion14.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density13 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection13 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration13 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion15 = ComposeUiNode.Companion;
                    constructor = companion15.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf13 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY5);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl13 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl13, measurePolicyRememberBoxMeasurePolicy13, companion15.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl13, density13, companion15.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl13, layoutDirection13, companion15.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl13, viewConfiguration13, companion15.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf13.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Modifier.Companion companion16 = Modifier.Companion;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy14 = BoxKt.rememberBoxMeasurePolicy(companion14.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density14 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection14 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration14 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor2 = companion15.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf14 = LayoutKt.materializerOf(companion16);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl14 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl14, measurePolicyRememberBoxMeasurePolicy14, companion15.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl14, density14, companion15.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl14, layoutDirection14, companion15.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl14, viewConfiguration14, companion15.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf14.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    boolean zIsOpen5 = drawerState2.isOpen();
                    NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$6 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope5);
                    Float fValueOf9 = Float.valueOf(f);
                    Float fValueOf10 = Float.valueOf(0.0f);
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(fValueOf9) | composerStartRestartGroup.changed(fValueOf10) | composerStartRestartGroup.changed(drawerState2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    boolean z10 = z3;
                    composer2 = composerStartRestartGroup;
                    m1671ScrimBx497Mc(zIsOpen5, navigationDrawerKt$ModalNavigationDrawer$2$6, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                    composer2.startReplaceableGroup(1157296644);
                    zChanged2 = composer2.changed(drawerState2);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    Modifier modifierSemantics$default5 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion16, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq212, drawerState2, coroutineScope5), 1, null);
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy15 = BoxKt.rememberBoxMeasurePolicy(companion14.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density15 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection15 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration15 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor3 = companion15.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf15 = LayoutKt.materializerOf(modifierSemantics$default5);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM2661constructorimpl15 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl15, measurePolicyRememberBoxMeasurePolicy15, companion15.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl15, density15, companion15.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl15, layoutDirection15, companion15.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl15, viewConfiguration15, companion15.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf15.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z10;
                    drawerStateRememberDrawerState = drawerState2;
                    modifier4 = modifier9;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i6 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            drawerState2 = drawerStateRememberDrawerState;
                            z3 = z2;
                            modifier3 = modifier2;
                        } else {
                            z3 = z2;
                            scrimColor = j2;
                            modifier3 = modifier2;
                            drawerState2 = drawerStateRememberDrawerState;
                        }
                    } else {
                        if (i6 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            drawerState2 = drawerStateRememberDrawerState;
                            z3 = z2;
                            modifier3 = modifier2;
                        } else {
                            z3 = z2;
                            scrimColor = j2;
                            modifier3 = modifier2;
                            drawerState2 = drawerStateRememberDrawerState;
                        }
                    }
                    i8 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller6 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller6);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller6;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope6 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    String strM1841getStringNWtq213 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                    Map mapJ6 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                    if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                        f2 = 0.0f;
                        obj = null;
                        z4 = true;
                    } else {
                        f2 = 0.0f;
                        obj = null;
                        z4 = false;
                    }
                    Modifier modifierM1862swipeablepPrIpRY6 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ6, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ6.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                    Modifier modifier10 = modifier3;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Alignment.Companion companion17 = Alignment.Companion;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy16 = BoxKt.rememberBoxMeasurePolicy(companion17.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density16 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection16 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration16 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion18 = ComposeUiNode.Companion;
                    constructor = companion18.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf16 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY6);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl16 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl16, measurePolicyRememberBoxMeasurePolicy16, companion18.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl16, density16, companion18.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl16, layoutDirection16, companion18.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl16, viewConfiguration16, companion18.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf16.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Modifier.Companion companion19 = Modifier.Companion;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy17 = BoxKt.rememberBoxMeasurePolicy(companion17.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density17 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection17 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration17 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor2 = companion18.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf17 = LayoutKt.materializerOf(companion19);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl17 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl17, measurePolicyRememberBoxMeasurePolicy17, companion18.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl17, density17, companion18.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl17, layoutDirection17, companion18.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl17, viewConfiguration17, companion18.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf17.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    boolean zIsOpen6 = drawerState2.isOpen();
                    NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$7 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope6);
                    Float fValueOf11 = Float.valueOf(f);
                    Float fValueOf12 = Float.valueOf(0.0f);
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(fValueOf11) | composerStartRestartGroup.changed(fValueOf12) | composerStartRestartGroup.changed(drawerState2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    boolean z11 = z3;
                    composer2 = composerStartRestartGroup;
                    m1671ScrimBx497Mc(zIsOpen6, navigationDrawerKt$ModalNavigationDrawer$2$7, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                    composer2.startReplaceableGroup(1157296644);
                    zChanged2 = composer2.changed(drawerState2);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    Modifier modifierSemantics$default6 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion19, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq213, drawerState2, coroutineScope6), 1, null);
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy18 = BoxKt.rememberBoxMeasurePolicy(companion17.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density18 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection18 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration18 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor3 = companion18.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf18 = LayoutKt.materializerOf(modifierSemantics$default6);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM2661constructorimpl18 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl18, measurePolicyRememberBoxMeasurePolicy18, companion18.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl18, density18, companion18.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl18, layoutDirection18, companion18.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl18, viewConfiguration18, companion18.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf18.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z11;
                    drawerStateRememberDrawerState = drawerState2;
                    modifier4 = modifier10;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$ModalNavigationDrawer$3(interfaceC0526Fp, modifier4, drawerStateRememberDrawerState, z5, scrimColor, interfaceC0526Fp2, i, i2));
            }
            i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i7;
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        drawerState2 = drawerStateRememberDrawerState;
                        z3 = z2;
                        modifier3 = modifier2;
                    } else {
                        z3 = z2;
                        scrimColor = j2;
                        modifier3 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                    }
                } else {
                    if (i6 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        drawerState2 = drawerStateRememberDrawerState;
                        z3 = z2;
                        modifier3 = modifier2;
                    } else {
                        z3 = z2;
                        scrimColor = j2;
                        modifier3 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                    }
                }
                i8 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller7 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller7);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller7;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope7 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                String strM1841getStringNWtq214 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                Map mapJ7 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    f2 = 0.0f;
                    obj = null;
                    z4 = true;
                } else {
                    f2 = 0.0f;
                    obj = null;
                    z4 = false;
                }
                Modifier modifierM1862swipeablepPrIpRY7 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ7, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ7.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                Modifier modifier11 = modifier3;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion110 = Alignment.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy19 = BoxKt.rememberBoxMeasurePolicy(companion110.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density19 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection19 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration19 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion111 = ComposeUiNode.Companion;
                constructor = companion111.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf19 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY7);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl19 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl19, measurePolicyRememberBoxMeasurePolicy19, companion111.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl19, density19, companion111.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl19, layoutDirection19, companion111.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl19, viewConfiguration19, companion111.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf19.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Modifier.Companion companion112 = Modifier.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy110 = BoxKt.rememberBoxMeasurePolicy(companion110.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density110 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection110 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration110 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion111.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf110 = LayoutKt.materializerOf(companion112);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl110 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl110, measurePolicyRememberBoxMeasurePolicy110, companion111.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl110, density110, companion111.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl110, layoutDirection110, companion111.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl110, viewConfiguration110, companion111.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                boolean zIsOpen7 = drawerState2.isOpen();
                NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$8 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope7);
                Float fValueOf13 = Float.valueOf(f);
                Float fValueOf14 = Float.valueOf(0.0f);
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(fValueOf13) | composerStartRestartGroup.changed(fValueOf14) | composerStartRestartGroup.changed(drawerState2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                boolean z12 = z3;
                composer2 = composerStartRestartGroup;
                m1671ScrimBx497Mc(zIsOpen7, navigationDrawerKt$ModalNavigationDrawer$2$8, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                composer2.startReplaceableGroup(1157296644);
                zChanged2 = composer2.changed(drawerState2);
                objRememberedValue3 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                composer2.endReplaceableGroup();
                Modifier modifierSemantics$default7 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion112, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq214, drawerState2, coroutineScope7), 1, null);
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy111 = BoxKt.rememberBoxMeasurePolicy(companion110.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density111 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection111 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration111 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor3 = companion111.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf111 = LayoutKt.materializerOf(modifierSemantics$default7);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM2661constructorimpl111 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl111, measurePolicyRememberBoxMeasurePolicy111, companion111.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl111, density111, companion111.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl111, layoutDirection111, companion111.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl111, viewConfiguration111, companion111.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z12;
                drawerStateRememberDrawerState = drawerState2;
                modifier4 = modifier11;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        drawerState2 = drawerStateRememberDrawerState;
                        z3 = z2;
                        modifier3 = modifier2;
                    } else {
                        z3 = z2;
                        scrimColor = j2;
                        modifier3 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                    }
                } else {
                    if (i6 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        drawerState2 = drawerStateRememberDrawerState;
                        z3 = z2;
                        modifier3 = modifier2;
                    } else {
                        z3 = z2;
                        scrimColor = j2;
                        modifier3 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                    }
                }
                i8 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller8 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller8);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller8;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope8 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                String strM1841getStringNWtq215 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                Map mapJ8 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    f2 = 0.0f;
                    obj = null;
                    z4 = true;
                } else {
                    f2 = 0.0f;
                    obj = null;
                    z4 = false;
                }
                Modifier modifierM1862swipeablepPrIpRY8 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ8, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ8.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                Modifier modifier12 = modifier3;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion113 = Alignment.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy112 = BoxKt.rememberBoxMeasurePolicy(companion113.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density112 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection112 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration112 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion114 = ComposeUiNode.Companion;
                constructor = companion114.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf112 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY8);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl112 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl112, measurePolicyRememberBoxMeasurePolicy112, companion114.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl112, density112, companion114.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl112, layoutDirection112, companion114.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl112, viewConfiguration112, companion114.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf112.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Modifier.Companion companion115 = Modifier.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy113 = BoxKt.rememberBoxMeasurePolicy(companion113.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density113 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection113 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration113 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion114.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf113 = LayoutKt.materializerOf(companion115);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl113 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl113, measurePolicyRememberBoxMeasurePolicy113, companion114.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl113, density113, companion114.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl113, layoutDirection113, companion114.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl113, viewConfiguration113, companion114.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf113.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                boolean zIsOpen8 = drawerState2.isOpen();
                NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$9 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope8);
                Float fValueOf15 = Float.valueOf(f);
                Float fValueOf16 = Float.valueOf(0.0f);
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(fValueOf15) | composerStartRestartGroup.changed(fValueOf16) | composerStartRestartGroup.changed(drawerState2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                boolean z13 = z3;
                composer2 = composerStartRestartGroup;
                m1671ScrimBx497Mc(zIsOpen8, navigationDrawerKt$ModalNavigationDrawer$2$9, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                composer2.startReplaceableGroup(1157296644);
                zChanged2 = composer2.changed(drawerState2);
                objRememberedValue3 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                composer2.endReplaceableGroup();
                Modifier modifierSemantics$default8 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion115, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq215, drawerState2, coroutineScope8), 1, null);
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy114 = BoxKt.rememberBoxMeasurePolicy(companion113.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density114 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection114 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration114 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor3 = companion114.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf114 = LayoutKt.materializerOf(modifierSemantics$default8);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM2661constructorimpl114 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl114, measurePolicyRememberBoxMeasurePolicy114, companion114.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl114, density114, companion114.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl114, layoutDirection114, companion114.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl114, viewConfiguration114, companion114.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf114.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z13;
                drawerStateRememberDrawerState = drawerState2;
                modifier4 = modifier12;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$ModalNavigationDrawer$3(interfaceC0526Fp, modifier4, drawerStateRememberDrawerState, z5, scrimColor, interfaceC0526Fp2, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                drawerStateRememberDrawerState = drawerState;
                if (composerStartRestartGroup.changed(drawerStateRememberDrawerState)) {
                }
                i3 |= i10;
            } else {
                drawerStateRememberDrawerState = drawerState;
            }
            i3 |= i10;
        } else {
            drawerStateRememberDrawerState = drawerState;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    i6 = i9;
                    j2 = j;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i3 |= i11;
                } else {
                    i6 = i9;
                    j2 = j;
                }
                i3 |= i11;
            } else {
                i6 = i9;
                j2 = j;
            }
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                }
                if ((374491 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i6 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            drawerState2 = drawerStateRememberDrawerState;
                            z3 = z2;
                            modifier3 = modifier2;
                        } else {
                            z3 = z2;
                            scrimColor = j2;
                            modifier3 = modifier2;
                            drawerState2 = drawerStateRememberDrawerState;
                        }
                    } else {
                        if (i6 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            drawerState2 = drawerStateRememberDrawerState;
                            z3 = z2;
                            modifier3 = modifier2;
                        } else {
                            z3 = z2;
                            scrimColor = j2;
                            modifier3 = modifier2;
                            drawerState2 = drawerStateRememberDrawerState;
                        }
                    }
                    i8 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller9 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller9);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller9;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope9 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    String strM1841getStringNWtq216 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                    Map mapJ9 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                    if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                        f2 = 0.0f;
                        obj = null;
                        z4 = true;
                    } else {
                        f2 = 0.0f;
                        obj = null;
                        z4 = false;
                    }
                    Modifier modifierM1862swipeablepPrIpRY9 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ9, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ9.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                    Modifier modifier13 = modifier3;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Alignment.Companion companion116 = Alignment.Companion;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy115 = BoxKt.rememberBoxMeasurePolicy(companion116.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density115 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection115 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration115 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion117 = ComposeUiNode.Companion;
                    constructor = companion117.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf115 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY9);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl115 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl115, measurePolicyRememberBoxMeasurePolicy115, companion117.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl115, density115, companion117.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl115, layoutDirection115, companion117.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl115, viewConfiguration115, companion117.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf115.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Modifier.Companion companion118 = Modifier.Companion;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy116 = BoxKt.rememberBoxMeasurePolicy(companion116.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density116 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection116 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration116 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor2 = companion117.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf116 = LayoutKt.materializerOf(companion118);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl116 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl116, measurePolicyRememberBoxMeasurePolicy116, companion117.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl116, density116, companion117.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl116, layoutDirection116, companion117.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl116, viewConfiguration116, companion117.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf116.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    boolean zIsOpen9 = drawerState2.isOpen();
                    NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$10 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope9);
                    Float fValueOf17 = Float.valueOf(f);
                    Float fValueOf18 = Float.valueOf(0.0f);
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(fValueOf17) | composerStartRestartGroup.changed(fValueOf18) | composerStartRestartGroup.changed(drawerState2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    boolean z14 = z3;
                    composer2 = composerStartRestartGroup;
                    m1671ScrimBx497Mc(zIsOpen9, navigationDrawerKt$ModalNavigationDrawer$2$10, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                    composer2.startReplaceableGroup(1157296644);
                    zChanged2 = composer2.changed(drawerState2);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    Modifier modifierSemantics$default9 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion118, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq216, drawerState2, coroutineScope9), 1, null);
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy117 = BoxKt.rememberBoxMeasurePolicy(companion116.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density117 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection117 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration117 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor3 = companion117.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf117 = LayoutKt.materializerOf(modifierSemantics$default9);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM2661constructorimpl117 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl117, measurePolicyRememberBoxMeasurePolicy117, companion117.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl117, density117, companion117.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl117, layoutDirection117, companion117.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl117, viewConfiguration117, companion117.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf117.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z14;
                    drawerStateRememberDrawerState = drawerState2;
                    modifier4 = modifier13;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i6 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            drawerState2 = drawerStateRememberDrawerState;
                            z3 = z2;
                            modifier3 = modifier2;
                        } else {
                            z3 = z2;
                            scrimColor = j2;
                            modifier3 = modifier2;
                            drawerState2 = drawerStateRememberDrawerState;
                        }
                    } else {
                        if (i6 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            drawerState2 = drawerStateRememberDrawerState;
                            z3 = z2;
                            modifier3 = modifier2;
                        } else {
                            z3 = z2;
                            scrimColor = j2;
                            modifier3 = modifier2;
                            drawerState2 = drawerStateRememberDrawerState;
                        }
                    }
                    i8 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller10 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller10);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller10;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope10 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    String strM1841getStringNWtq217 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                    Map mapJ10 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                    if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                        f2 = 0.0f;
                        obj = null;
                        z4 = true;
                    } else {
                        f2 = 0.0f;
                        obj = null;
                        z4 = false;
                    }
                    Modifier modifierM1862swipeablepPrIpRY10 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ10, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ10.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                    Modifier modifier14 = modifier3;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Alignment.Companion companion119 = Alignment.Companion;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy118 = BoxKt.rememberBoxMeasurePolicy(companion119.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density118 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection118 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration118 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion1110 = ComposeUiNode.Companion;
                    constructor = companion1110.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf118 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY10);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl118 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl118, measurePolicyRememberBoxMeasurePolicy118, companion1110.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl118, density118, companion1110.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl118, layoutDirection118, companion1110.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl118, viewConfiguration118, companion1110.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf118.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    Modifier.Companion companion1111 = Modifier.Companion;
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy119 = BoxKt.rememberBoxMeasurePolicy(companion119.getTopStart(), false, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density119 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection119 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration119 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor2 = companion1110.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf119 = LayoutKt.materializerOf(companion1111);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl119 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl119, measurePolicyRememberBoxMeasurePolicy119, companion1110.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl119, density119, companion1110.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl119, layoutDirection119, companion1110.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl119, viewConfiguration119, companion1110.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf119.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    boolean zIsOpen10 = drawerState2.isOpen();
                    NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$11 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope10);
                    Float fValueOf19 = Float.valueOf(f);
                    Float fValueOf110 = Float.valueOf(0.0f);
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    zChanged = composerStartRestartGroup.changed(fValueOf19) | composerStartRestartGroup.changed(fValueOf110) | composerStartRestartGroup.changed(drawerState2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    boolean z15 = z3;
                    composer2 = composerStartRestartGroup;
                    m1671ScrimBx497Mc(zIsOpen10, navigationDrawerKt$ModalNavigationDrawer$2$11, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                    composer2.startReplaceableGroup(1157296644);
                    zChanged2 = composer2.changed(drawerState2);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    Modifier modifierSemantics$default10 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion1111, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq217, drawerState2, coroutineScope10), 1, null);
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy1110 = BoxKt.rememberBoxMeasurePolicy(companion119.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density1110 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection1110 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration1110 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor3 = companion1110.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf1110 = LayoutKt.materializerOf(modifierSemantics$default10);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer composerM2661constructorimpl1110 = Updater.m2661constructorimpl(composer2);
                    Updater.m2668setimpl(composerM2661constructorimpl1110, measurePolicyRememberBoxMeasurePolicy1110, companion1110.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl1110, density1110, companion1110.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl1110, layoutDirection1110, companion1110.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl1110, viewConfiguration1110, companion1110.getSetViewConfiguration());
                    composer2.enableReusing();
                    interfaceC0552GpMaterializerOf1110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z15;
                    drawerStateRememberDrawerState = drawerState2;
                    modifier4 = modifier14;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$ModalNavigationDrawer$3(interfaceC0526Fp, modifier4, drawerStateRememberDrawerState, z5, scrimColor, interfaceC0526Fp2, i, i2));
            }
            i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i7;
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        drawerState2 = drawerStateRememberDrawerState;
                        z3 = z2;
                        modifier3 = modifier2;
                    } else {
                        z3 = z2;
                        scrimColor = j2;
                        modifier3 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                    }
                } else {
                    if (i6 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        drawerState2 = drawerStateRememberDrawerState;
                        z3 = z2;
                        modifier3 = modifier2;
                    } else {
                        z3 = z2;
                        scrimColor = j2;
                        modifier3 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                    }
                }
                i8 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller11;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope11 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                String strM1841getStringNWtq218 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                Map mapJ11 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    f2 = 0.0f;
                    obj = null;
                    z4 = true;
                } else {
                    f2 = 0.0f;
                    obj = null;
                    z4 = false;
                }
                Modifier modifierM1862swipeablepPrIpRY11 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ11, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ11.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                Modifier modifier15 = modifier3;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion1112 = Alignment.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy1111 = BoxKt.rememberBoxMeasurePolicy(companion1112.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density1111 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection1111 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration1111 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion1113 = ComposeUiNode.Companion;
                constructor = companion1113.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf1111 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY11);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl1111 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl1111, measurePolicyRememberBoxMeasurePolicy1111, companion1113.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl1111, density1111, companion1113.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl1111, layoutDirection1111, companion1113.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl1111, viewConfiguration1111, companion1113.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf1111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Modifier.Companion companion1114 = Modifier.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy1112 = BoxKt.rememberBoxMeasurePolicy(companion1112.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density1112 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection1112 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration1112 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion1113.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf1112 = LayoutKt.materializerOf(companion1114);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl1112 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl1112, measurePolicyRememberBoxMeasurePolicy1112, companion1113.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl1112, density1112, companion1113.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl1112, layoutDirection1112, companion1113.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl1112, viewConfiguration1112, companion1113.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf1112.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                boolean zIsOpen11 = drawerState2.isOpen();
                NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$12 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope11);
                Float fValueOf111 = Float.valueOf(f);
                Float fValueOf112 = Float.valueOf(0.0f);
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(fValueOf111) | composerStartRestartGroup.changed(fValueOf112) | composerStartRestartGroup.changed(drawerState2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                boolean z16 = z3;
                composer2 = composerStartRestartGroup;
                m1671ScrimBx497Mc(zIsOpen11, navigationDrawerKt$ModalNavigationDrawer$2$12, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                composer2.startReplaceableGroup(1157296644);
                zChanged2 = composer2.changed(drawerState2);
                objRememberedValue3 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                composer2.endReplaceableGroup();
                Modifier modifierSemantics$default11 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion1114, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq218, drawerState2, coroutineScope11), 1, null);
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy1113 = BoxKt.rememberBoxMeasurePolicy(companion1112.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density1113 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection1113 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration1113 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor3 = companion1113.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf1113 = LayoutKt.materializerOf(modifierSemantics$default11);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM2661constructorimpl1113 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl1113, measurePolicyRememberBoxMeasurePolicy1113, companion1113.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl1113, density1113, companion1113.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl1113, layoutDirection1113, companion1113.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl1113, viewConfiguration1113, companion1113.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf1113.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z16;
                drawerStateRememberDrawerState = drawerState2;
                modifier4 = modifier15;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        drawerState2 = drawerStateRememberDrawerState;
                        z3 = z2;
                        modifier3 = modifier2;
                    } else {
                        z3 = z2;
                        scrimColor = j2;
                        modifier3 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                    }
                } else {
                    if (i6 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        drawerState2 = drawerStateRememberDrawerState;
                        z3 = z2;
                        modifier3 = modifier2;
                    } else {
                        z3 = z2;
                        scrimColor = j2;
                        modifier3 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                    }
                }
                i8 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller12 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller12);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller12;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope12 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                String strM1841getStringNWtq219 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                Map mapJ12 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    f2 = 0.0f;
                    obj = null;
                    z4 = true;
                } else {
                    f2 = 0.0f;
                    obj = null;
                    z4 = false;
                }
                Modifier modifierM1862swipeablepPrIpRY12 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ12, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ12.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                Modifier modifier16 = modifier3;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion1115 = Alignment.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy1114 = BoxKt.rememberBoxMeasurePolicy(companion1115.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density1114 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection1114 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration1114 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion1116 = ComposeUiNode.Companion;
                constructor = companion1116.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf1114 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY12);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl1114 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl1114, measurePolicyRememberBoxMeasurePolicy1114, companion1116.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl1114, density1114, companion1116.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl1114, layoutDirection1114, companion1116.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl1114, viewConfiguration1114, companion1116.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf1114.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Modifier.Companion companion1117 = Modifier.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy1115 = BoxKt.rememberBoxMeasurePolicy(companion1115.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density1115 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection1115 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration1115 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion1116.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf1115 = LayoutKt.materializerOf(companion1117);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl1115 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl1115, measurePolicyRememberBoxMeasurePolicy1115, companion1116.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl1115, density1115, companion1116.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl1115, layoutDirection1115, companion1116.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl1115, viewConfiguration1115, companion1116.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf1115.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                boolean zIsOpen12 = drawerState2.isOpen();
                NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$13 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope12);
                Float fValueOf113 = Float.valueOf(f);
                Float fValueOf114 = Float.valueOf(0.0f);
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(fValueOf113) | composerStartRestartGroup.changed(fValueOf114) | composerStartRestartGroup.changed(drawerState2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                boolean z17 = z3;
                composer2 = composerStartRestartGroup;
                m1671ScrimBx497Mc(zIsOpen12, navigationDrawerKt$ModalNavigationDrawer$2$13, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                composer2.startReplaceableGroup(1157296644);
                zChanged2 = composer2.changed(drawerState2);
                objRememberedValue3 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                composer2.endReplaceableGroup();
                Modifier modifierSemantics$default12 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion1117, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq219, drawerState2, coroutineScope12), 1, null);
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy1116 = BoxKt.rememberBoxMeasurePolicy(companion1115.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density1116 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection1116 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration1116 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor3 = companion1116.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf1116 = LayoutKt.materializerOf(modifierSemantics$default12);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM2661constructorimpl1116 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl1116, measurePolicyRememberBoxMeasurePolicy1116, companion1116.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl1116, density1116, companion1116.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl1116, layoutDirection1116, companion1116.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl1116, viewConfiguration1116, companion1116.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf1116.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z17;
                drawerStateRememberDrawerState = drawerState2;
                modifier4 = modifier16;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$ModalNavigationDrawer$3(interfaceC0526Fp, modifier4, drawerStateRememberDrawerState, z5, scrimColor, interfaceC0526Fp2, i, i2));
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 57344) == 0) {
            if ((i2 & 16) == 0) {
                i6 = i9;
                j2 = j;
                if (composerStartRestartGroup.changed(j2)) {
                }
                i3 |= i11;
            } else {
                i6 = i9;
                j2 = j;
            }
            i3 |= i11;
        } else {
            i6 = i9;
            j2 = j;
        }
        if ((i2 & 32) != 0) {
            if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
            }
            if ((374491 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        drawerState2 = drawerStateRememberDrawerState;
                        z3 = z2;
                        modifier3 = modifier2;
                    } else {
                        z3 = z2;
                        scrimColor = j2;
                        modifier3 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                    }
                } else {
                    if (i6 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        drawerState2 = drawerStateRememberDrawerState;
                        z3 = z2;
                        modifier3 = modifier2;
                    } else {
                        z3 = z2;
                        scrimColor = j2;
                        modifier3 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                    }
                }
                i8 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller13 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller13);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller13;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope13 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                String strM1841getStringNWtq2110 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                Map mapJ13 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    f2 = 0.0f;
                    obj = null;
                    z4 = true;
                } else {
                    f2 = 0.0f;
                    obj = null;
                    z4 = false;
                }
                Modifier modifierM1862swipeablepPrIpRY13 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ13, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ13.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                Modifier modifier17 = modifier3;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion1118 = Alignment.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy1117 = BoxKt.rememberBoxMeasurePolicy(companion1118.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density1117 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection1117 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration1117 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion1119 = ComposeUiNode.Companion;
                constructor = companion1119.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf1117 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY13);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl1117 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl1117, measurePolicyRememberBoxMeasurePolicy1117, companion1119.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl1117, density1117, companion1119.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl1117, layoutDirection1117, companion1119.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl1117, viewConfiguration1117, companion1119.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf1117.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Modifier.Companion companion11110 = Modifier.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy1118 = BoxKt.rememberBoxMeasurePolicy(companion1118.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density1118 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection1118 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration1118 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion1119.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf1118 = LayoutKt.materializerOf(companion11110);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl1118 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl1118, measurePolicyRememberBoxMeasurePolicy1118, companion1119.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl1118, density1118, companion1119.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl1118, layoutDirection1118, companion1119.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl1118, viewConfiguration1118, companion1119.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf1118.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                boolean zIsOpen13 = drawerState2.isOpen();
                NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$14 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope13);
                Float fValueOf115 = Float.valueOf(f);
                Float fValueOf116 = Float.valueOf(0.0f);
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(fValueOf115) | composerStartRestartGroup.changed(fValueOf116) | composerStartRestartGroup.changed(drawerState2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                boolean z18 = z3;
                composer2 = composerStartRestartGroup;
                m1671ScrimBx497Mc(zIsOpen13, navigationDrawerKt$ModalNavigationDrawer$2$14, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                composer2.startReplaceableGroup(1157296644);
                zChanged2 = composer2.changed(drawerState2);
                objRememberedValue3 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                composer2.endReplaceableGroup();
                Modifier modifierSemantics$default13 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion11110, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq2110, drawerState2, coroutineScope13), 1, null);
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy1119 = BoxKt.rememberBoxMeasurePolicy(companion1118.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density1119 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection1119 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration1119 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor3 = companion1119.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf1119 = LayoutKt.materializerOf(modifierSemantics$default13);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM2661constructorimpl1119 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl1119, measurePolicyRememberBoxMeasurePolicy1119, companion1119.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl1119, density1119, companion1119.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl1119, layoutDirection1119, companion1119.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl1119, viewConfiguration1119, companion1119.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf1119.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z18;
                drawerStateRememberDrawerState = drawerState2;
                modifier4 = modifier17;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        drawerState2 = drawerStateRememberDrawerState;
                        z3 = z2;
                        modifier3 = modifier2;
                    } else {
                        z3 = z2;
                        scrimColor = j2;
                        modifier3 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                    }
                } else {
                    if (i6 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        drawerState2 = drawerStateRememberDrawerState;
                        z3 = z2;
                        modifier3 = modifier2;
                    } else {
                        z3 = z2;
                        scrimColor = j2;
                        modifier3 = modifier2;
                        drawerState2 = drawerStateRememberDrawerState;
                    }
                }
                i8 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller14 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller14);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller14;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope14 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                String strM1841getStringNWtq2111 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
                Map mapJ14 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
                if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                    f2 = 0.0f;
                    obj = null;
                    z4 = true;
                } else {
                    f2 = 0.0f;
                    obj = null;
                    z4 = false;
                }
                Modifier modifierM1862swipeablepPrIpRY14 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ14, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ14.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
                Modifier modifier18 = modifier3;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion11111 = Alignment.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy11110 = BoxKt.rememberBoxMeasurePolicy(companion11111.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density11110 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection11110 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration11110 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion11112 = ComposeUiNode.Companion;
                constructor = companion11112.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf11110 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY14);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl11110 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl11110, measurePolicyRememberBoxMeasurePolicy11110, companion11112.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl11110, density11110, companion11112.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl11110, layoutDirection11110, companion11112.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl11110, viewConfiguration11110, companion11112.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf11110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Modifier.Companion companion11113 = Modifier.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy11111 = BoxKt.rememberBoxMeasurePolicy(companion11111.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density11111 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection11111 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration11111 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion11112.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf11111 = LayoutKt.materializerOf(companion11113);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl11111 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl11111, measurePolicyRememberBoxMeasurePolicy11111, companion11112.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl11111, density11111, companion11112.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl11111, layoutDirection11111, companion11112.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl11111, viewConfiguration11111, companion11112.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf11111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                boolean zIsOpen14 = drawerState2.isOpen();
                NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$15 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope14);
                Float fValueOf117 = Float.valueOf(f);
                Float fValueOf118 = Float.valueOf(0.0f);
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(fValueOf117) | composerStartRestartGroup.changed(fValueOf118) | composerStartRestartGroup.changed(drawerState2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                boolean z19 = z3;
                composer2 = composerStartRestartGroup;
                m1671ScrimBx497Mc(zIsOpen14, navigationDrawerKt$ModalNavigationDrawer$2$15, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
                composer2.startReplaceableGroup(1157296644);
                zChanged2 = composer2.changed(drawerState2);
                objRememberedValue3 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                composer2.endReplaceableGroup();
                Modifier modifierSemantics$default14 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion11113, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq2111, drawerState2, coroutineScope14), 1, null);
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy11112 = BoxKt.rememberBoxMeasurePolicy(companion11111.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density11112 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection11112 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration11112 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor3 = companion11112.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf11112 = LayoutKt.materializerOf(modifierSemantics$default14);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM2661constructorimpl11112 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl11112, measurePolicyRememberBoxMeasurePolicy11112, companion11112.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl11112, density11112, companion11112.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl11112, layoutDirection11112, companion11112.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl11112, viewConfiguration11112, companion11112.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf11112.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z19;
                drawerStateRememberDrawerState = drawerState2;
                modifier4 = modifier18;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$ModalNavigationDrawer$3(interfaceC0526Fp, modifier4, drawerStateRememberDrawerState, z5, scrimColor, interfaceC0526Fp2, i, i2));
        }
        i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i7;
        if ((374491 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    drawerState2 = drawerStateRememberDrawerState;
                    z3 = z2;
                    modifier3 = modifier2;
                } else {
                    z3 = z2;
                    scrimColor = j2;
                    modifier3 = modifier2;
                    drawerState2 = drawerStateRememberDrawerState;
                }
            } else {
                if (i6 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    drawerState2 = drawerStateRememberDrawerState;
                    z3 = z2;
                    modifier3 = modifier2;
                } else {
                    z3 = z2;
                    scrimColor = j2;
                    modifier3 = modifier2;
                    drawerState2 = drawerStateRememberDrawerState;
                }
            }
            i8 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
            }
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller15 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller15);
                objRememberedValue = compositionScopedCoroutineScopeCanceller15;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope15 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            String strM1841getStringNWtq2112 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
            f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
            Map mapJ15 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
            if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                f2 = 0.0f;
                obj = null;
                z4 = true;
            } else {
                f2 = 0.0f;
                obj = null;
                z4 = false;
            }
            Modifier modifierM1862swipeablepPrIpRY15 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ15, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ15.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
            Modifier modifier19 = modifier3;
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion11114 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy11113 = BoxKt.rememberBoxMeasurePolicy(companion11114.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density11113 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection11113 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration11113 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion11115 = ComposeUiNode.Companion;
            constructor = companion11115.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf11113 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY15);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl11113 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl11113, measurePolicyRememberBoxMeasurePolicy11113, companion11115.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl11113, density11113, companion11115.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl11113, layoutDirection11113, companion11115.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl11113, viewConfiguration11113, companion11115.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf11113.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Modifier.Companion companion11116 = Modifier.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy11114 = BoxKt.rememberBoxMeasurePolicy(companion11114.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density11114 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection11114 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration11114 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor2 = companion11115.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf11114 = LayoutKt.materializerOf(companion11116);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl11114 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl11114, measurePolicyRememberBoxMeasurePolicy11114, companion11115.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl11114, density11114, companion11115.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl11114, layoutDirection11114, companion11115.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl11114, viewConfiguration11114, companion11115.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf11114.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            boolean zIsOpen15 = drawerState2.isOpen();
            NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$16 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope15);
            Float fValueOf119 = Float.valueOf(f);
            Float fValueOf1110 = Float.valueOf(0.0f);
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            zChanged = composerStartRestartGroup.changed(fValueOf119) | composerStartRestartGroup.changed(fValueOf1110) | composerStartRestartGroup.changed(drawerState2);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            boolean z110 = z3;
            composer2 = composerStartRestartGroup;
            m1671ScrimBx497Mc(zIsOpen15, navigationDrawerKt$ModalNavigationDrawer$2$16, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
            composer2.startReplaceableGroup(1157296644);
            zChanged2 = composer2.changed(drawerState2);
            objRememberedValue3 = composer2.rememberedValue();
            if (zChanged2) {
                objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                composer2.updateRememberedValue(objRememberedValue3);
            }
            composer2.endReplaceableGroup();
            Modifier modifierSemantics$default15 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion11116, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq2112, drawerState2, coroutineScope15), 1, null);
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy11115 = BoxKt.rememberBoxMeasurePolicy(companion11114.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density11115 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection11115 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration11115 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor3 = companion11115.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf11115 = LayoutKt.materializerOf(modifierSemantics$default15);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM2661constructorimpl11115 = Updater.m2661constructorimpl(composer2);
            Updater.m2668setimpl(composerM2661constructorimpl11115, measurePolicyRememberBoxMeasurePolicy11115, companion11115.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl11115, density11115, companion11115.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl11115, layoutDirection11115, companion11115.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl11115, viewConfiguration11115, companion11115.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf11115.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z110;
            drawerStateRememberDrawerState = drawerState2;
            modifier4 = modifier19;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    drawerState2 = drawerStateRememberDrawerState;
                    z3 = z2;
                    modifier3 = modifier2;
                } else {
                    z3 = z2;
                    scrimColor = j2;
                    modifier3 = modifier2;
                    drawerState2 = drawerStateRememberDrawerState;
                }
            } else {
                if (i6 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    drawerState2 = drawerStateRememberDrawerState;
                    z3 = z2;
                    modifier3 = modifier2;
                } else {
                    z3 = z2;
                    scrimColor = j2;
                    modifier3 = modifier2;
                    drawerState2 = drawerStateRememberDrawerState;
                }
            }
            i8 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1169303680, i8, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:253)");
            }
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller16 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller16);
                objRememberedValue = compositionScopedCoroutineScopeCanceller16;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope16 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            String strM1841getStringNWtq2113 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
            f = -((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(NavigationDrawerTokens.INSTANCE.m2359getContainerWidthD9Ej5fM());
            Map mapJ16 = AbstractC4243wx.j(HV.a(Float.valueOf(f), DrawerValue.Closed), HV.a(Float.valueOf(0.0f), DrawerValue.Open));
            if (composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl) {
                f2 = 0.0f;
                obj = null;
                z4 = true;
            } else {
                f2 = 0.0f;
                obj = null;
                z4 = false;
            }
            Modifier modifierM1862swipeablepPrIpRY16 = SwipeableKt.m1862swipeablepPrIpRY(SizeKt.fillMaxSize$default(modifier3, f2, 1, obj), drawerState2.getSwipeableState$material3_release(), mapJ16, Orientation.Horizontal, (32 & 8) != 0 ? true : z3, (32 & 16) != 0 ? false : z4, (32 & 32) != 0 ? null : null, (32 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : NavigationDrawerKt$ModalNavigationDrawer$1.INSTANCE, (32 & 128) != 0 ? SwipeableDefaults.resistanceConfig$material3_release$default(SwipeableDefaults.INSTANCE, mapJ16.keySet(), 0.0f, 0.0f, 6, null) : null, (32 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1861getVelocityThresholdD9Ej5fM$material3_release() : DrawerVelocityThreshold);
            Modifier modifier110 = modifier3;
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion11117 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy11116 = BoxKt.rememberBoxMeasurePolicy(companion11117.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density11116 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection11116 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration11116 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion11118 = ComposeUiNode.Companion;
            constructor = companion11118.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf11116 = LayoutKt.materializerOf(modifierM1862swipeablepPrIpRY16);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl11116 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl11116, measurePolicyRememberBoxMeasurePolicy11116, companion11118.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl11116, density11116, companion11118.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl11116, layoutDirection11116, companion11118.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl11116, viewConfiguration11116, companion11118.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf11116.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Modifier.Companion companion11119 = Modifier.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy11117 = BoxKt.rememberBoxMeasurePolicy(companion11117.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density11117 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection11117 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration11117 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor2 = companion11118.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf11117 = LayoutKt.materializerOf(companion11119);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl11117 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl11117, measurePolicyRememberBoxMeasurePolicy11117, companion11118.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl11117, density11117, companion11118.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl11117, layoutDirection11117, companion11118.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl11117, viewConfiguration11117, companion11118.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf11117.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            boolean zIsOpen16 = drawerState2.isOpen();
            NavigationDrawerKt$ModalNavigationDrawer$2$2 navigationDrawerKt$ModalNavigationDrawer$2$17 = new NavigationDrawerKt$ModalNavigationDrawer$2$2(z3, drawerState2, coroutineScope16);
            Float fValueOf1111 = Float.valueOf(f);
            Float fValueOf1112 = Float.valueOf(0.0f);
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            zChanged = composerStartRestartGroup.changed(fValueOf1111) | composerStartRestartGroup.changed(fValueOf1112) | composerStartRestartGroup.changed(drawerState2);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new NavigationDrawerKt$ModalNavigationDrawer$2$3$1(f, 0.0f, drawerState2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            boolean z111 = z3;
            composer2 = composerStartRestartGroup;
            m1671ScrimBx497Mc(zIsOpen16, navigationDrawerKt$ModalNavigationDrawer$2$17, (InterfaceC3588op) objRememberedValue2, scrimColor, composerStartRestartGroup, (i8 >> 3) & 7168);
            composer2.startReplaceableGroup(1157296644);
            zChanged2 = composer2.changed(drawerState2);
            objRememberedValue3 = composer2.rememberedValue();
            if (zChanged2) {
                objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new NavigationDrawerKt$ModalNavigationDrawer$2$4$1(drawerState2);
                composer2.updateRememberedValue(objRememberedValue3);
            }
            composer2.endReplaceableGroup();
            Modifier modifierSemantics$default16 = SemanticsModifierKt.semantics$default(OffsetKt.offset(companion11119, (InterfaceC3750qp) objRememberedValue3), false, new NavigationDrawerKt$ModalNavigationDrawer$2$5(strM1841getStringNWtq2113, drawerState2, coroutineScope16), 1, null);
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy11118 = BoxKt.rememberBoxMeasurePolicy(companion11117.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density11118 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection11118 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration11118 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor3 = companion11118.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf11118 = LayoutKt.materializerOf(modifierSemantics$default16);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM2661constructorimpl11118 = Updater.m2661constructorimpl(composer2);
            Updater.m2668setimpl(composerM2661constructorimpl11118, measurePolicyRememberBoxMeasurePolicy11118, companion11118.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl11118, density11118, companion11118.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl11118, layoutDirection11118, companion11118.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl11118, viewConfiguration11118, companion11118.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf11118.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf(i8 & 14));
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z111;
            drawerStateRememberDrawerState = drawerState2;
            modifier4 = modifier110;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$ModalNavigationDrawer$3(interfaceC0526Fp, modifier4, drawerStateRememberDrawerState, z5, scrimColor, interfaceC0526Fp2, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x011d  */
    /* JADX WARN: Code duplicated, block: B:104:0x0133  */
    /* JADX WARN: Code duplicated, block: B:106:0x013e  */
    /* JADX WARN: Code duplicated, block: B:116:0x0164 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:117:0x0166  */
    /* JADX WARN: Code duplicated, block: B:118:0x0169  */
    /* JADX WARN: Code duplicated, block: B:120:0x016d  */
    /* JADX WARN: Code duplicated, block: B:122:0x0170  */
    /* JADX WARN: Code duplicated, block: B:125:0x0175  */
    /* JADX WARN: Code duplicated, block: B:126:0x0183  */
    /* JADX WARN: Code duplicated, block: B:129:0x0188  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:132:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:134:0x01be  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:140:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:143:0x0264  */
    /* JADX WARN: Code duplicated, block: B:148:0x0279  */
    /* JADX WARN: Code duplicated, block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00db  */
    /* JADX WARN: Code duplicated, block: B:81:0x00df  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:93:0x0106  */
    /* JADX WARN: Code duplicated, block: B:95:0x010c  */
    /* JADX WARN: Code duplicated, block: B:96:0x010f  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void NavigationDrawerItem(InterfaceC0526Fp interfaceC0526Fp, boolean z, InterfaceC3588op interfaceC3588op, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Shape shape, NavigationDrawerItemColors navigationDrawerItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2) {
        int i3;
        int i4;
        InterfaceC0526Fp interfaceC0526Fp4;
        int i5;
        int i6;
        InterfaceC0526Fp interfaceC0526Fp5;
        int i7;
        Shape shape2;
        NavigationDrawerItemColors navigationDrawerItemColors2;
        int i8;
        int i9;
        Modifier modifier2;
        Shape shape3;
        NavigationDrawerItemColors navigationDrawerItemColorsM1665colorsoq7We08;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape4;
        NavigationDrawerItemColors navigationDrawerItemColors3;
        InterfaceC0526Fp interfaceC0526Fp6;
        InterfaceC0526Fp interfaceC0526Fp7;
        int i10;
        Object objRememberedValue;
        Composer composer2;
        Modifier modifier3;
        InterfaceC0526Fp interfaceC0526Fp8;
        InterfaceC0526Fp interfaceC0526Fp9;
        Shape shape5;
        MutableInteractionSource mutableInteractionSource3;
        NavigationDrawerItemColors navigationDrawerItemColors4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp, HTML.Tag.LABEL);
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1304626543);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 256 : 128;
        }
        int i11 = i2 & 8;
        if (i11 == 0) {
            if ((i & 7168) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 57344) == 0) {
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((458752 & i) == 0) {
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((3670016 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            shape2 = shape;
                            int i12 = composerStartRestartGroup.changed(shape2) ? 1048576 : 524288;
                            i3 |= i12;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 29360128) == 0) {
                        if ((i2 & 128) == 0) {
                            navigationDrawerItemColors2 = navigationDrawerItemColors;
                            int i13 = composerStartRestartGroup.changed(navigationDrawerItemColors2) ? 8388608 : 4194304;
                            i3 |= i13;
                        } else {
                            navigationDrawerItemColors2 = navigationDrawerItemColors;
                        }
                        i3 |= i13;
                    } else {
                        navigationDrawerItemColors2 = navigationDrawerItemColors;
                    }
                    i8 = i2 & 256;
                    if (i8 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp5 = null;
                            }
                            if ((i2 & 64) != 0) {
                                shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i2 & 128) != 0) {
                                navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                                i3 &= -29360129;
                            } else {
                                navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            shape4 = shape3;
                            navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                            interfaceC0526Fp6 = interfaceC0526Fp4;
                            interfaceC0526Fp7 = interfaceC0526Fp5;
                            i10 = i3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            modifier2 = modifier;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i10 = i3;
                            navigationDrawerItemColors3 = navigationDrawerItemColors2;
                            interfaceC0526Fp6 = interfaceC0526Fp4;
                            interfaceC0526Fp7 = interfaceC0526Fp5;
                            shape4 = shape2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
                        }
                        int i14 = i10 >> 3;
                        composer2 = composerStartRestartGroup;
                        NavigationDrawerItemColors navigationDrawerItemColors5 = navigationDrawerItemColors3;
                        SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i14 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i14 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        interfaceC0526Fp8 = interfaceC0526Fp6;
                        interfaceC0526Fp9 = interfaceC0526Fp7;
                        shape5 = shape4;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        navigationDrawerItemColors4 = navigationDrawerItemColors5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        navigationDrawerItemColors4 = navigationDrawerItemColors2;
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                        interfaceC0526Fp9 = interfaceC0526Fp5;
                        composer2 = composerStartRestartGroup;
                        shape5 = shape2;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, z, interfaceC3588op, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape5, navigationDrawerItemColors4, mutableInteractionSource3, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp5 = interfaceC0526Fp3;
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i & 29360128) == 0) {
                    if ((i2 & 128) == 0) {
                        navigationDrawerItemColors2 = navigationDrawerItemColors;
                        if (composerStartRestartGroup.changed(navigationDrawerItemColors2)) {
                        }
                        i3 |= i13;
                    } else {
                        navigationDrawerItemColors2 = navigationDrawerItemColors;
                    }
                    i3 |= i13;
                } else {
                    navigationDrawerItemColors2 = navigationDrawerItemColors;
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 64) != 0) {
                            shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 &= -29360129;
                        } else {
                            navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        shape4 = shape3;
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        i10 = i3;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 64) != 0) {
                            shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 &= -29360129;
                        } else {
                            navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        shape4 = shape3;
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
                    }
                    int i15 = i10 >> 3;
                    composer2 = composerStartRestartGroup;
                    NavigationDrawerItemColors navigationDrawerItemColors6 = navigationDrawerItemColors3;
                    SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i15 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i15 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                    shape5 = shape4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    navigationDrawerItemColors4 = navigationDrawerItemColors6;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 64) != 0) {
                            shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 &= -29360129;
                        } else {
                            navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        shape4 = shape3;
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        i10 = i3;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 64) != 0) {
                            shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 &= -29360129;
                        } else {
                            navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        shape4 = shape3;
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
                    }
                    int i16 = i10 >> 3;
                    composer2 = composerStartRestartGroup;
                    NavigationDrawerItemColors navigationDrawerItemColors7 = navigationDrawerItemColors3;
                    SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i16 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i16 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                    shape5 = shape4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    navigationDrawerItemColors4 = navigationDrawerItemColors7;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, z, interfaceC3588op, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape5, navigationDrawerItemColors4, mutableInteractionSource3, i, i2));
            }
            i3 |= 24576;
            interfaceC0526Fp4 = interfaceC0526Fp2;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((458752 & i) == 0) {
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i & 29360128) == 0) {
                    if ((i2 & 128) == 0) {
                        navigationDrawerItemColors2 = navigationDrawerItemColors;
                        if (composerStartRestartGroup.changed(navigationDrawerItemColors2)) {
                        }
                        i3 |= i13;
                    } else {
                        navigationDrawerItemColors2 = navigationDrawerItemColors;
                    }
                    i3 |= i13;
                } else {
                    navigationDrawerItemColors2 = navigationDrawerItemColors;
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 64) != 0) {
                            shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 &= -29360129;
                        } else {
                            navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        shape4 = shape3;
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        i10 = i3;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 64) != 0) {
                            shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 &= -29360129;
                        } else {
                            navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        shape4 = shape3;
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
                    }
                    int i17 = i10 >> 3;
                    composer2 = composerStartRestartGroup;
                    NavigationDrawerItemColors navigationDrawerItemColors8 = navigationDrawerItemColors3;
                    SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i17 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i17 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                    shape5 = shape4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    navigationDrawerItemColors4 = navigationDrawerItemColors8;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 64) != 0) {
                            shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 &= -29360129;
                        } else {
                            navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        shape4 = shape3;
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        i10 = i3;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 64) != 0) {
                            shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 &= -29360129;
                        } else {
                            navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        shape4 = shape3;
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
                    }
                    int i18 = i10 >> 3;
                    composer2 = composerStartRestartGroup;
                    NavigationDrawerItemColors navigationDrawerItemColors9 = navigationDrawerItemColors3;
                    SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i18 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i18 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                    shape5 = shape4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    navigationDrawerItemColors4 = navigationDrawerItemColors9;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, z, interfaceC3588op, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape5, navigationDrawerItemColors4, mutableInteractionSource3, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526Fp5 = interfaceC0526Fp3;
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((i & 29360128) == 0) {
                if ((i2 & 128) == 0) {
                    navigationDrawerItemColors2 = navigationDrawerItemColors;
                    if (composerStartRestartGroup.changed(navigationDrawerItemColors2)) {
                    }
                    i3 |= i13;
                } else {
                    navigationDrawerItemColors2 = navigationDrawerItemColors;
                }
                i3 |= i13;
            } else {
                navigationDrawerItemColors2 = navigationDrawerItemColors;
            }
            i8 = i2 & 256;
            if (i8 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 64) != 0) {
                        shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 &= -29360129;
                    } else {
                        navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    shape4 = shape3;
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    i10 = i3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 64) != 0) {
                        shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 &= -29360129;
                    } else {
                        navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    shape4 = shape3;
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
                }
                int i19 = i10 >> 3;
                composer2 = composerStartRestartGroup;
                NavigationDrawerItemColors navigationDrawerItemColors10 = navigationDrawerItemColors3;
                SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i19 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i19 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                interfaceC0526Fp9 = interfaceC0526Fp7;
                shape5 = shape4;
                mutableInteractionSource3 = mutableInteractionSource2;
                navigationDrawerItemColors4 = navigationDrawerItemColors10;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 64) != 0) {
                        shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 &= -29360129;
                    } else {
                        navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    shape4 = shape3;
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    i10 = i3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 64) != 0) {
                        shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 &= -29360129;
                    } else {
                        navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    shape4 = shape3;
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
                }
                int i110 = i10 >> 3;
                composer2 = composerStartRestartGroup;
                NavigationDrawerItemColors navigationDrawerItemColors11 = navigationDrawerItemColors3;
                SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i110 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i110 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                interfaceC0526Fp9 = interfaceC0526Fp7;
                shape5 = shape4;
                mutableInteractionSource3 = mutableInteractionSource2;
                navigationDrawerItemColors4 = navigationDrawerItemColors11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, z, interfaceC3588op, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape5, navigationDrawerItemColors4, mutableInteractionSource3, i, i2));
        }
        i3 |= 3072;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 57344) == 0) {
                interfaceC0526Fp4 = interfaceC0526Fp2;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((458752 & i) == 0) {
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i & 29360128) == 0) {
                    if ((i2 & 128) == 0) {
                        navigationDrawerItemColors2 = navigationDrawerItemColors;
                        if (composerStartRestartGroup.changed(navigationDrawerItemColors2)) {
                        }
                        i3 |= i13;
                    } else {
                        navigationDrawerItemColors2 = navigationDrawerItemColors;
                    }
                    i3 |= i13;
                } else {
                    navigationDrawerItemColors2 = navigationDrawerItemColors;
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 64) != 0) {
                            shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 &= -29360129;
                        } else {
                            navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        shape4 = shape3;
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        i10 = i3;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 64) != 0) {
                            shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 &= -29360129;
                        } else {
                            navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        shape4 = shape3;
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
                    }
                    int i111 = i10 >> 3;
                    composer2 = composerStartRestartGroup;
                    NavigationDrawerItemColors navigationDrawerItemColors12 = navigationDrawerItemColors3;
                    SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i111 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i111 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                    shape5 = shape4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    navigationDrawerItemColors4 = navigationDrawerItemColors12;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 64) != 0) {
                            shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 &= -29360129;
                        } else {
                            navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        shape4 = shape3;
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        i10 = i3;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp5 = null;
                        }
                        if ((i2 & 64) != 0) {
                            shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 128) != 0) {
                            navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 &= -29360129;
                        } else {
                            navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        shape4 = shape3;
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                        interfaceC0526Fp6 = interfaceC0526Fp4;
                        interfaceC0526Fp7 = interfaceC0526Fp5;
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
                    }
                    int i112 = i10 >> 3;
                    composer2 = composerStartRestartGroup;
                    NavigationDrawerItemColors navigationDrawerItemColors13 = navigationDrawerItemColors3;
                    SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i112 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i112 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    interfaceC0526Fp8 = interfaceC0526Fp6;
                    interfaceC0526Fp9 = interfaceC0526Fp7;
                    shape5 = shape4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    navigationDrawerItemColors4 = navigationDrawerItemColors13;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, z, interfaceC3588op, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape5, navigationDrawerItemColors4, mutableInteractionSource3, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526Fp5 = interfaceC0526Fp3;
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((i & 29360128) == 0) {
                if ((i2 & 128) == 0) {
                    navigationDrawerItemColors2 = navigationDrawerItemColors;
                    if (composerStartRestartGroup.changed(navigationDrawerItemColors2)) {
                    }
                    i3 |= i13;
                } else {
                    navigationDrawerItemColors2 = navigationDrawerItemColors;
                }
                i3 |= i13;
            } else {
                navigationDrawerItemColors2 = navigationDrawerItemColors;
            }
            i8 = i2 & 256;
            if (i8 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 64) != 0) {
                        shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 &= -29360129;
                    } else {
                        navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    shape4 = shape3;
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    i10 = i3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 64) != 0) {
                        shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 &= -29360129;
                    } else {
                        navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    shape4 = shape3;
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
                }
                int i113 = i10 >> 3;
                composer2 = composerStartRestartGroup;
                NavigationDrawerItemColors navigationDrawerItemColors14 = navigationDrawerItemColors3;
                SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i113 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i113 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                interfaceC0526Fp9 = interfaceC0526Fp7;
                shape5 = shape4;
                mutableInteractionSource3 = mutableInteractionSource2;
                navigationDrawerItemColors4 = navigationDrawerItemColors14;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 64) != 0) {
                        shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 &= -29360129;
                    } else {
                        navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    shape4 = shape3;
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    i10 = i3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 64) != 0) {
                        shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 &= -29360129;
                    } else {
                        navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    shape4 = shape3;
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
                }
                int i114 = i10 >> 3;
                composer2 = composerStartRestartGroup;
                NavigationDrawerItemColors navigationDrawerItemColors15 = navigationDrawerItemColors3;
                SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i114 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i114 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                interfaceC0526Fp9 = interfaceC0526Fp7;
                shape5 = shape4;
                mutableInteractionSource3 = mutableInteractionSource2;
                navigationDrawerItemColors4 = navigationDrawerItemColors15;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, z, interfaceC3588op, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape5, navigationDrawerItemColors4, mutableInteractionSource3, i, i2));
        }
        i3 |= 24576;
        interfaceC0526Fp4 = interfaceC0526Fp2;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((458752 & i) == 0) {
                interfaceC0526Fp5 = interfaceC0526Fp3;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((i & 29360128) == 0) {
                if ((i2 & 128) == 0) {
                    navigationDrawerItemColors2 = navigationDrawerItemColors;
                    if (composerStartRestartGroup.changed(navigationDrawerItemColors2)) {
                    }
                    i3 |= i13;
                } else {
                    navigationDrawerItemColors2 = navigationDrawerItemColors;
                }
                i3 |= i13;
            } else {
                navigationDrawerItemColors2 = navigationDrawerItemColors;
            }
            i8 = i2 & 256;
            if (i8 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 64) != 0) {
                        shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 &= -29360129;
                    } else {
                        navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    shape4 = shape3;
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    i10 = i3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 64) != 0) {
                        shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 &= -29360129;
                    } else {
                        navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    shape4 = shape3;
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
                }
                int i115 = i10 >> 3;
                composer2 = composerStartRestartGroup;
                NavigationDrawerItemColors navigationDrawerItemColors16 = navigationDrawerItemColors3;
                SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i115 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i115 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                interfaceC0526Fp9 = interfaceC0526Fp7;
                shape5 = shape4;
                mutableInteractionSource3 = mutableInteractionSource2;
                navigationDrawerItemColors4 = navigationDrawerItemColors16;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 64) != 0) {
                        shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 &= -29360129;
                    } else {
                        navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    shape4 = shape3;
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    i10 = i3;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp5 = null;
                    }
                    if ((i2 & 64) != 0) {
                        shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 128) != 0) {
                        navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 &= -29360129;
                    } else {
                        navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    shape4 = shape3;
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                    interfaceC0526Fp6 = interfaceC0526Fp4;
                    interfaceC0526Fp7 = interfaceC0526Fp5;
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
                }
                int i116 = i10 >> 3;
                composer2 = composerStartRestartGroup;
                NavigationDrawerItemColors navigationDrawerItemColors17 = navigationDrawerItemColors3;
                SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i116 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i116 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                interfaceC0526Fp8 = interfaceC0526Fp6;
                interfaceC0526Fp9 = interfaceC0526Fp7;
                shape5 = shape4;
                mutableInteractionSource3 = mutableInteractionSource2;
                navigationDrawerItemColors4 = navigationDrawerItemColors17;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, z, interfaceC3588op, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape5, navigationDrawerItemColors4, mutableInteractionSource3, i, i2));
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        interfaceC0526Fp5 = interfaceC0526Fp3;
        if ((3670016 & i) == 0) {
            if ((i2 & 64) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            i3 |= i12;
        } else {
            shape2 = shape;
        }
        if ((i & 29360128) == 0) {
            if ((i2 & 128) == 0) {
                navigationDrawerItemColors2 = navigationDrawerItemColors;
                if (composerStartRestartGroup.changed(navigationDrawerItemColors2)) {
                }
                i3 |= i13;
            } else {
                navigationDrawerItemColors2 = navigationDrawerItemColors;
            }
            i3 |= i13;
        } else {
            navigationDrawerItemColors2 = navigationDrawerItemColors;
        }
        i8 = i2 & 256;
        if (i8 != 0) {
            i3 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i9 = 67108864;
            } else {
                i9 = 33554432;
            }
            i3 |= i9;
        }
        if ((i3 & 191739611) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i6 != 0) {
                    interfaceC0526Fp5 = null;
                }
                if ((i2 & 64) != 0) {
                    shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 128) != 0) {
                    navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                    i3 &= -29360129;
                } else {
                    navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                shape4 = shape3;
                navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                interfaceC0526Fp6 = interfaceC0526Fp4;
                interfaceC0526Fp7 = interfaceC0526Fp5;
                i10 = i3;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i6 != 0) {
                    interfaceC0526Fp5 = null;
                }
                if ((i2 & 64) != 0) {
                    shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 128) != 0) {
                    navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                    i3 &= -29360129;
                } else {
                    navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                shape4 = shape3;
                navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                interfaceC0526Fp6 = interfaceC0526Fp4;
                interfaceC0526Fp7 = interfaceC0526Fp5;
                i10 = i3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
            }
            int i117 = i10 >> 3;
            composer2 = composerStartRestartGroup;
            NavigationDrawerItemColors navigationDrawerItemColors18 = navigationDrawerItemColors3;
            SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i117 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i117 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            interfaceC0526Fp8 = interfaceC0526Fp6;
            interfaceC0526Fp9 = interfaceC0526Fp7;
            shape5 = shape4;
            mutableInteractionSource3 = mutableInteractionSource2;
            navigationDrawerItemColors4 = navigationDrawerItemColors18;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i6 != 0) {
                    interfaceC0526Fp5 = null;
                }
                if ((i2 & 64) != 0) {
                    shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 128) != 0) {
                    navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                    i3 &= -29360129;
                } else {
                    navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                shape4 = shape3;
                navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                interfaceC0526Fp6 = interfaceC0526Fp4;
                interfaceC0526Fp7 = interfaceC0526Fp5;
                i10 = i3;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i6 != 0) {
                    interfaceC0526Fp5 = null;
                }
                if ((i2 & 64) != 0) {
                    shape3 = ShapesKt.toShape(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    shape3 = shape2;
                }
                if ((i2 & 128) != 0) {
                    navigationDrawerItemColorsM1665colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m1665colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                    i3 &= -29360129;
                } else {
                    navigationDrawerItemColorsM1665colorsoq7We08 = navigationDrawerItemColors2;
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                shape4 = shape3;
                navigationDrawerItemColors3 = navigationDrawerItemColorsM1665colorsoq7We08;
                interfaceC0526Fp6 = interfaceC0526Fp4;
                interfaceC0526Fp7 = interfaceC0526Fp5;
                i10 = i3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:650)");
            }
            int i118 = i10 >> 3;
            composer2 = composerStartRestartGroup;
            NavigationDrawerItemColors navigationDrawerItemColors19 = navigationDrawerItemColors3;
            SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SizeKt.fillMaxWidth$default(SizeKt.m518height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, AnonymousClass2.INSTANCE, 1, null), NavigationDrawerTokens.INSTANCE.m2357getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i118 & 14) | ((i10 >> 18) & 112)).getValue().m3042unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 191488423, true, new C15353(interfaceC0526Fp6, navigationDrawerItemColors3, z, i10, interfaceC0526Fp7, interfaceC0526Fp)), composer2, (i118 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            interfaceC0526Fp8 = interfaceC0526Fp6;
            interfaceC0526Fp9 = interfaceC0526Fp7;
            shape5 = shape4;
            mutableInteractionSource3 = mutableInteractionSource2;
            navigationDrawerItemColors4 = navigationDrawerItemColors19;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC0526Fp, z, interfaceC3588op, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape5, navigationDrawerItemColors4, mutableInteractionSource3, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012c  */
    /* JADX WARN: Code duplicated, block: B:102:0x0130  */
    /* JADX WARN: Code duplicated, block: B:105:0x0139  */
    /* JADX WARN: Code duplicated, block: B:108:0x0149  */
    /* JADX WARN: Code duplicated, block: B:110:0x0156  */
    /* JADX WARN: Code duplicated, block: B:113:0x0161  */
    /* JADX WARN: Code duplicated, block: B:115:0x0177  */
    /* JADX WARN: Code duplicated, block: B:118:0x0189  */
    /* JADX WARN: Code duplicated, block: B:121:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:123:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:126:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:131:0x020c  */
    /* JADX WARN: Code duplicated, block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:30:0x005b  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:54:0x0099  */
    /* JADX WARN: Code duplicated, block: B:55:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:98:0x0127 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x0129  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: PermanentDrawerSheet-afqeVBk, reason: not valid java name */
    public static final void m1670PermanentDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Shape rectangleShape;
        long jM1413getSurface0d7_KjU;
        long jM1449contentColorForek8zF_U;
        int i4;
        float fM1547getPermanentDrawerElevationD9Ej5fM;
        int i5;
        WindowInsets windowInsets2;
        int i6;
        Modifier modifier2;
        WindowInsets windowInsets3;
        float f2;
        Modifier modifier3;
        String strM1841getStringNWtq28;
        boolean zChanged;
        Object objRememberedValue;
        Modifier modifier4;
        Shape shape2;
        long j3;
        long j4;
        float f3;
        WindowInsets windowInsets4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1733353241);
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 112) == 0) {
                rectangleShape = shape;
                i3 |= composerStartRestartGroup.changed(rectangleShape) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    jM1413getSurface0d7_KjU = j;
                    int i10 = composerStartRestartGroup.changed(jM1413getSurface0d7_KjU) ? 256 : 128;
                    i3 |= i10;
                } else {
                    jM1413getSurface0d7_KjU = j;
                }
                i3 |= i10;
            } else {
                jM1413getSurface0d7_KjU = j;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    jM1449contentColorForek8zF_U = j2;
                    int i11 = composerStartRestartGroup.changed(jM1449contentColorForek8zF_U) ? 2048 : 1024;
                    i3 |= i11;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                i3 |= i11;
            } else {
                jM1449contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 57344) == 0) {
                    fM1547getPermanentDrawerElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM1547getPermanentDrawerElevationD9Ej5fM)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i & 458752) == 0) {
                    windowInsets2 = windowInsets;
                    if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(windowInsets2)) {
                        i7 = 65536;
                    } else {
                        i7 = 131072;
                    }
                    i3 |= i7;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i2 & 64) != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i6 = 1048576;
                        } else {
                            i6 = 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i9 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 4) != 0) {
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            } else {
                                windowInsets3 = windowInsets2;
                            }
                            f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            rectangleShape = rectangleShape;
                            jM1413getSurface0d7_KjU = jM1413getSurface0d7_KjU;
                            jM1449contentColorForek8zF_U = jM1449contentColorForek8zF_U;
                            windowInsets3 = windowInsets2;
                            f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                            modifier3 = modifier;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
                        }
                        strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
                        int i12 = i3 << 3;
                        m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (i12 & 458752) | (i3 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        shape2 = rectangleShape;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        f3 = f2;
                        windowInsets4 = windowInsets3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier;
                        shape2 = rectangleShape;
                        j3 = jM1413getSurface0d7_KjU;
                        j4 = jM1449contentColorForek8zF_U;
                        windowInsets4 = windowInsets2;
                        f3 = fM1547getPermanentDrawerElevationD9Ej5fM;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$PermanentDrawerSheet$2(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
                }
                i6 = 1572864;
                i3 |= i6;
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
                    }
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
                    int i13 = i3 << 3;
                    m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default2, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (i13 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape2 = rectangleShape;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f3 = f2;
                    windowInsets4 = windowInsets3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
                    }
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
                    int i14 = i3 << 3;
                    m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default3, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (i14 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape2 = rectangleShape;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f3 = f2;
                    windowInsets4 = windowInsets3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$PermanentDrawerSheet$2(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            fM1547getPermanentDrawerElevationD9Ej5fM = f;
            if ((i & 458752) == 0) {
                windowInsets2 = windowInsets;
                if ((i2 & 32) == 0) {
                    i7 = 65536;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
                    }
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
                    int i15 = i3 << 3;
                    m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default4, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i15 & 896) | (i15 & 7168) | (57344 & i15) | (i15 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape2 = rectangleShape;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f3 = f2;
                    windowInsets4 = windowInsets3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
                    }
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierSemantics$default5 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
                    int i16 = i3 << 3;
                    m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default5, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (i16 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape2 = rectangleShape;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f3 = f2;
                    windowInsets4 = windowInsets3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$PermanentDrawerSheet$2(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
            }
            i6 = 1572864;
            i3 |= i6;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierSemantics$default6 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
                int i17 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default6, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i17 & 896) | (i17 & 7168) | (57344 & i17) | (i17 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j3 = jM1413getSurface0d7_KjU;
                j4 = jM1449contentColorForek8zF_U;
                f3 = f2;
                windowInsets4 = windowInsets3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierSemantics$default7 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
                int i18 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default7, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i18 & 896) | (i18 & 7168) | (57344 & i18) | (i18 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j3 = jM1413getSurface0d7_KjU;
                j4 = jM1449contentColorForek8zF_U;
                f3 = f2;
                windowInsets4 = windowInsets3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$PermanentDrawerSheet$2(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
        }
        i3 |= 48;
        rectangleShape = shape;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                jM1413getSurface0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM1413getSurface0d7_KjU)) {
                }
                i3 |= i10;
            } else {
                jM1413getSurface0d7_KjU = j;
            }
            i3 |= i10;
        } else {
            jM1413getSurface0d7_KjU = j;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                jM1449contentColorForek8zF_U = j2;
                if (composerStartRestartGroup.changed(jM1449contentColorForek8zF_U)) {
                }
                i3 |= i11;
            } else {
                jM1449contentColorForek8zF_U = j2;
            }
            i3 |= i11;
        } else {
            jM1449contentColorForek8zF_U = j2;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 57344) == 0) {
                fM1547getPermanentDrawerElevationD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM1547getPermanentDrawerElevationD9Ej5fM)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i & 458752) == 0) {
                windowInsets2 = windowInsets;
                if ((i2 & 32) == 0) {
                    i7 = 65536;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
                    }
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierSemantics$default8 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
                    int i19 = i3 << 3;
                    m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default8, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i19 & 896) | (i19 & 7168) | (57344 & i19) | (i19 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape2 = rectangleShape;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f3 = f2;
                    windowInsets4 = windowInsets3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i9 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets3 = windowInsets2;
                        }
                        f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                        modifier3 = modifier2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
                    }
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierSemantics$default9 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
                    int i110 = i3 << 3;
                    m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default9, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i110 & 896) | (i110 & 7168) | (57344 & i110) | (i110 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    shape2 = rectangleShape;
                    j3 = jM1413getSurface0d7_KjU;
                    j4 = jM1449contentColorForek8zF_U;
                    f3 = f2;
                    windowInsets4 = windowInsets3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$PermanentDrawerSheet$2(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
            }
            i6 = 1572864;
            i3 |= i6;
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierSemantics$default10 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
                int i111 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default10, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i111 & 896) | (i111 & 7168) | (57344 & i111) | (i111 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j3 = jM1413getSurface0d7_KjU;
                j4 = jM1449contentColorForek8zF_U;
                f3 = f2;
                windowInsets4 = windowInsets3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierSemantics$default11 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
                int i112 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default11, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i112 & 896) | (i112 & 7168) | (57344 & i112) | (i112 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j3 = jM1413getSurface0d7_KjU;
                j4 = jM1449contentColorForek8zF_U;
                f3 = f2;
                windowInsets4 = windowInsets3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$PermanentDrawerSheet$2(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
        }
        i3 |= 24576;
        fM1547getPermanentDrawerElevationD9Ej5fM = f;
        if ((i & 458752) == 0) {
            windowInsets2 = windowInsets;
            if ((i2 & 32) == 0) {
                i7 = 65536;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i2 & 64) != 0) {
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierSemantics$default12 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
                int i113 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default12, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i113 & 896) | (i113 & 7168) | (57344 & i113) | (i113 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j3 = jM1413getSurface0d7_KjU;
                j4 = jM1449contentColorForek8zF_U;
                f3 = f2;
                windowInsets4 = windowInsets3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i9 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets3 = windowInsets2;
                    }
                    f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                    modifier3 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierSemantics$default13 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
                int i114 = i3 << 3;
                m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default13, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i114 & 896) | (i114 & 7168) | (57344 & i114) | (i114 & 458752) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                shape2 = rectangleShape;
                j3 = jM1413getSurface0d7_KjU;
                j4 = jM1449contentColorForek8zF_U;
                f3 = f2;
                windowInsets4 = windowInsets3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$PermanentDrawerSheet$2(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
        }
        i6 = 1572864;
        i3 |= i6;
        if ((i3 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i9 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets3 = windowInsets2;
                }
                f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                modifier3 = modifier2;
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i9 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets3 = windowInsets2;
                }
                f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
            }
            strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierSemantics$default14 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
            int i115 = i3 << 3;
            m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default14, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i115 & 896) | (i115 & 7168) | (57344 & i115) | (i115 & 458752) | (i3 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape2 = rectangleShape;
            j3 = jM1413getSurface0d7_KjU;
            j4 = jM1449contentColorForek8zF_U;
            f3 = f2;
            windowInsets4 = windowInsets3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i9 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets3 = windowInsets2;
                }
                f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                modifier3 = modifier2;
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i9 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM1547getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1547getPermanentDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets3 = windowInsets2;
                }
                f2 = fM1547getPermanentDrawerElevationD9Ej5fM;
                modifier3 = modifier2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1733353241, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:528)");
            }
            strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1821getNavigationMenuadMyvUU(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new NavigationDrawerKt$PermanentDrawerSheet$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierSemantics$default15 = SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null);
            int i116 = i3 << 3;
            m1667DrawerSheetvywBR7E(windowInsets3, modifierSemantics$default15, rectangleShape, jM1413getSurface0d7_KjU, jM1449contentColorForek8zF_U, f2, interfaceC0552Gp, composerStartRestartGroup, ((i3 >> 15) & 14) | (i116 & 896) | (i116 & 7168) | (57344 & i116) | (i116 & 458752) | (i3 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shape2 = rectangleShape;
            j3 = jM1413getSurface0d7_KjU;
            j4 = jM1449contentColorForek8zF_U;
            f3 = f2;
            windowInsets4 = windowInsets3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$PermanentDrawerSheet$2(modifier4, shape2, j3, j4, f3, windowInsets4, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:40:0x0078 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x007a  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:55:0x017a  */
    /* JADX WARN: Code duplicated, block: B:58:0x0186  */
    /* JADX WARN: Code duplicated, block: B:59:0x018a  */
    /* JADX WARN: Code duplicated, block: B:62:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:67:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void PermanentNavigationDrawer(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Modifier modifier3;
        InterfaceC3588op constructor;
        InterfaceC3588op constructor2;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp, "drawerContent");
        AbstractC4492zt.h(interfaceC0526Fp2, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-276843608);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 4) != 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i3 & 731) == 146 || !composerStartRestartGroup.getSkipping()) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-276843608, i3, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:424)");
                }
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null);
                composerStartRestartGroup.startReplaceableGroup(693286680);
                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                Alignment.Companion companion = Alignment.Companion;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion.getTop(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                constructor = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierFillMaxSize$default);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                composerStartRestartGroup.startReplaceableGroup(733328855);
                Modifier.Companion companion3 = Modifier.Companion;
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(companion3);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion2.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C15362(interfaceC0526Fp, modifier4, interfaceC0526Fp2, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i3 & 731) == 146) {
            if (i5 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-276843608, i3, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:424)");
            }
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null);
            composerStartRestartGroup.startReplaceableGroup(693286680);
            Arrangement.Horizontal start2 = Arrangement.INSTANCE.getStart();
            Alignment.Companion companion4 = Alignment.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(start2, companion4.getTop(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion5 = ComposeUiNode.Companion;
            constructor = companion5.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierFillMaxSize$default2);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRowMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, density3, companion5.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion5.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion5.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Modifier.Companion companion6 = Modifier.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion4.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor2 = companion5.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf4 = LayoutKt.materializerOf(companion6);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl4 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl4, measurePolicyRememberBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl4, density4, companion5.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl4, layoutDirection4, companion5.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl4, viewConfiguration4, companion5.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        } else {
            if (i5 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-276843608, i3, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:424)");
            }
            Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null);
            composerStartRestartGroup.startReplaceableGroup(693286680);
            Arrangement.Horizontal start3 = Arrangement.INSTANCE.getStart();
            Alignment.Companion companion7 = Alignment.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(start3, companion7.getTop(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection5 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion8 = ComposeUiNode.Companion;
            constructor = companion8.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf5 = LayoutKt.materializerOf(modifierFillMaxSize$default3);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl5 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl5, measurePolicyRowMeasurePolicy3, companion8.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl5, density5, companion8.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl5, layoutDirection5, companion8.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl5, viewConfiguration5, companion8.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf5.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Modifier.Companion companion9 = Modifier.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion7.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density6 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection6 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration6 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor2 = companion8.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf6 = LayoutKt.materializerOf(companion9);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl6 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl6, measurePolicyRememberBoxMeasurePolicy3, companion8.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl6, density6, companion8.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl6, layoutDirection6, companion8.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl6, viewConfiguration6, companion8.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf6.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            interfaceC0526Fp2.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15362(interfaceC0526Fp, modifier4, interfaceC0526Fp2, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Scrim-Bx497Mc, reason: not valid java name */
    public static final void m1671ScrimBx497Mc(boolean z, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, long j, Composer composer, int i) {
        int i2;
        Modifier modifierSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(2106487387);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106487387, i2, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:842)");
            }
            String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1783getCloseDraweradMyvUU(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1858703321);
            if (z) {
                Modifier.Companion companion = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                boolean zChanged = composerStartRestartGroup.changed(interfaceC3588op);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new NavigationDrawerKt$Scrim$dismissDrawer$1$1(interfaceC3588op, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, interfaceC3588op, (InterfaceC0526Fp) objRememberedValue);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                boolean zChanged2 = composerStartRestartGroup.changed(strM1841getStringNWtq28) | composerStartRestartGroup.changed(interfaceC3588op);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new NavigationDrawerKt$Scrim$dismissDrawer$2$1(strM1841getStringNWtq28, interfaceC3588op);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                modifierSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (InterfaceC3750qp) objRememberedValue2);
            } else {
                modifierSemantics = Modifier.Companion;
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null).then(modifierSemantics);
            Color colorM3022boximpl = Color.m3022boximpl(j);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged3 = composerStartRestartGroup.changed(colorM3022boximpl) | composerStartRestartGroup.changed(interfaceC3588op2);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new NavigationDrawerKt$Scrim$1$1(j, interfaceC3588op2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierThen, (InterfaceC3750qp) objRememberedValue3, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new NavigationDrawerKt$Scrim$2(z, interfaceC3588op, interfaceC3588op2, j, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float f, float f2, float f3) {
        return AbstractC3871sJ.k((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    @Composable
    public static final DrawerState rememberDrawerState(DrawerValue drawerValue, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        AbstractC4492zt.h(drawerValue, "initialValue");
        composer.startReplaceableGroup(2098699222);
        if ((i2 & 2) != 0) {
            interfaceC3750qp = C15371.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2098699222, i, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:223)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.Companion.Saver(interfaceC3750qp);
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(drawerValue) | composer.changed(interfaceC3750qp);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new NavigationDrawerKt$rememberDrawerState$2$1(drawerValue, interfaceC3750qp);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m2674rememberSaveable(objArr, (Saver) Saver, (String) null, (InterfaceC3588op) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return drawerState;
    }
}
