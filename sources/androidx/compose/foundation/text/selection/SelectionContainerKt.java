package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionContainerKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$DisableSelection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC0526Fp $content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp, int i) {
            super(2);
            this.$content = interfaceC0526Fp;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            SelectionContainerKt.DisableSelection(this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$modifier = modifier;
            this.$content = interfaceC0526Fp;
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
            SelectionContainerKt.SelectionContainer(this.$modifier, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ SelectionManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(SelectionManager selectionManager) {
            super(1);
            this.$manager = selectionManager;
        }

        @Override // defpackage.InterfaceC3750qp
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
            final SelectionManager selectionManager = this.$manager;
            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    selectionManager.onRelease();
                    selectionManager.setHasFocus(false);
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $children;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $onSelectionChange;
        final /* synthetic */ Selection $selection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(Modifier modifier, Selection selection, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$modifier = modifier;
            this.$selection = selection;
            this.$onSelectionChange = interfaceC3750qp;
            this.$children = interfaceC0526Fp;
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
            SelectionContainerKt.SelectionContainer(this.$modifier, this.$selection, this.$onSelectionChange, this.$children, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void DisableSelection(InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        int i2;
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(336063542);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(336063542, i2, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:60)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{SelectionRegistrarKt.getLocalSelectionRegistrar().provides(null)}, interfaceC0526Fp, composerStartRestartGroup, ((i2 << 3) & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(interfaceC0526Fp, i));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void SelectionContainer(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1075498320);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        if ((i3 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1075498320, i3, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:41)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            Selection selectionSelectionContainer$lambda$1 = SelectionContainer$lambda$1(mutableState);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new SelectionContainerKt$SelectionContainer$1$1(mutableState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SelectionContainer(modifier, selectionSelectionContainer$lambda$1, (InterfaceC3750qp) objRememberedValue2, interfaceC0526Fp, composerStartRestartGroup, (i3 & 14) | ((i3 << 6) & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier, interfaceC0526Fp, i, i2));
    }

    private static final Selection SelectionContainer$lambda$1(MutableState<Selection> mutableState) {
        return mutableState.getValue();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void SelectionContainer(Modifier modifier, Selection selection, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        AbstractC4492zt.h(interfaceC3750qp, "onSelectionChange");
        AbstractC4492zt.h(interfaceC0526Fp, "children");
        Composer composerStartRestartGroup = composer.startRestartGroup(2078139907);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((2 & i2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(selection) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 2048 : 1024;
        }
        if ((i3 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2078139907, i3, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:75)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new SelectionRegistrarImpl();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new SelectionManager(selectionRegistrarImpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SelectionManager selectionManager = (SelectionManager) objRememberedValue2;
            selectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
            selectionManager.setClipboardManager((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
            selectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
            selectionManager.setOnSelectionChange(interfaceC3750qp);
            selectionManager.setSelection(selection);
            selectionManager.setTouchMode(TouchMode_androidKt.isInTouchMode());
            composerStartRestartGroup.startReplaceableGroup(605522716);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{SelectionRegistrarKt.getLocalSelectionRegistrar().provides(selectionRegistrarImpl)}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 935424596, true, new SelectionContainerKt$SelectionContainer$3$1(modifier, selectionManager, interfaceC0526Fp, i3)), composerStartRestartGroup, 56);
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(selectionManager, new AnonymousClass4(selectionManager), composerStartRestartGroup, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(modifier2, selection, interfaceC3750qp, interfaceC0526Fp, i, i2));
    }
}
