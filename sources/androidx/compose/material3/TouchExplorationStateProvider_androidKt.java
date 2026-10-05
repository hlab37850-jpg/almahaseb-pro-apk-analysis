package androidx.compose.material3;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TouchExplorationStateProvider_androidKt {

    /* JADX INFO: renamed from: androidx.compose.material3.TouchExplorationStateProvider_androidKt$ObserveState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(Lifecycle.Event event) {
            AbstractC4492zt.h(event, "it");
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Lifecycle.Event) obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TouchExplorationStateProvider_androidKt$ObserveState$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2063invoke() {
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m2063invoke();
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TouchExplorationStateProvider_androidKt$ObserveState$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $handleEvent;
        final /* synthetic */ InterfaceC3588op $onDispose;
        final /* synthetic */ Lifecycle $this_ObserveState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Lifecycle lifecycle, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op) {
            super(1);
            this.$this_ObserveState = lifecycle;
            this.$handleEvent = interfaceC3750qp;
            this.$onDispose = interfaceC3588op;
        }

        @Override // defpackage.InterfaceC3750qp
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
            final InterfaceC3750qp interfaceC3750qp = this.$handleEvent;
            final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.compose.material3.TouchExplorationStateProvider_androidKt$ObserveState$3$observer$1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    AbstractC4492zt.h(lifecycleOwner, "<anonymous parameter 0>");
                    AbstractC4492zt.h(event, NotificationCompat.CATEGORY_EVENT);
                    interfaceC3750qp.invoke(event);
                }
            };
            this.$this_ObserveState.addObserver(lifecycleEventObserver);
            final InterfaceC3588op interfaceC3588op = this.$onDispose;
            final Lifecycle lifecycle = this.$this_ObserveState;
            return new DisposableEffectResult() { // from class: androidx.compose.material3.TouchExplorationStateProvider_androidKt$ObserveState$3$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    interfaceC3588op.invoke();
                    lifecycle.removeObserver(lifecycleEventObserver);
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TouchExplorationStateProvider_androidKt$ObserveState$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC3750qp $handleEvent;
        final /* synthetic */ InterfaceC3588op $onDispose;
        final /* synthetic */ Lifecycle $this_ObserveState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Lifecycle lifecycle, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, int i, int i2) {
            super(2);
            this.$this_ObserveState = lifecycle;
            this.$handleEvent = interfaceC3750qp;
            this.$onDispose = interfaceC3588op;
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
            TouchExplorationStateProvider_androidKt.ObserveState(this.$this_ObserveState, this.$handleEvent, this.$onDispose, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TouchExplorationStateProvider_androidKt$touchExplorationState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16091 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ AccessibilityManager $accessibilityManager;
        final /* synthetic */ Listener $listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16091(Listener listener, AccessibilityManager accessibilityManager) {
            super(1);
            this.$listener = listener;
            this.$accessibilityManager = accessibilityManager;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Lifecycle.Event) obj);
            return FW.a;
        }

        public final void invoke(Lifecycle.Event event) {
            AbstractC4492zt.h(event, NotificationCompat.CATEGORY_EVENT);
            if (event == Lifecycle.Event.ON_RESUME) {
                this.$listener.register(this.$accessibilityManager);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TouchExplorationStateProvider_androidKt$touchExplorationState$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16102 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ AccessibilityManager $accessibilityManager;
        final /* synthetic */ Listener $listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16102(Listener listener, AccessibilityManager accessibilityManager) {
            super(0);
            this.$listener = listener;
            this.$accessibilityManager = accessibilityManager;
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m2064invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2064invoke() {
            this.$listener.unregister(this.$accessibilityManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void ObserveState(Lifecycle lifecycle, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, Composer composer, int i, int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1703772404);
        if ((i2 & 1) != 0) {
            interfaceC3750qp = AnonymousClass1.INSTANCE;
        }
        InterfaceC3750qp interfaceC3750qp2 = interfaceC3750qp;
        if ((i2 & 2) != 0) {
            interfaceC3588op = AnonymousClass2.INSTANCE;
        }
        InterfaceC3588op interfaceC3588op2 = interfaceC3588op;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1703772404, i, -1, "androidx.compose.material3.ObserveState (TouchExplorationStateProvider.android.kt:63)");
        }
        EffectsKt.DisposableEffect(lifecycle, new AnonymousClass3(lifecycle, interfaceC3750qp2, interfaceC3588op2), composerStartRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(lifecycle, interfaceC3750qp2, interfaceC3588op2, i, i2));
    }

    @Composable
    public static final State<Boolean> touchExplorationState(Composer composer, int i) {
        composer.startReplaceableGroup(-906157724);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-906157724, i, -1, "androidx.compose.material3.touchExplorationState (TouchExplorationStateProvider.android.kt:40)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            Object systemService = context.getSystemService("accessibility");
            AbstractC4492zt.f(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
            objRememberedValue = (AccessibilityManager) systemService;
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        AccessibilityManager accessibilityManager = (AccessibilityManager) objRememberedValue;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Listener();
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        Listener listener = (Listener) objRememberedValue2;
        ObserveState(((LifecycleOwner) composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle(), new C16091(listener, accessibilityManager), new C16102(listener, accessibilityManager), composer, 8, 0);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt.derivedStateOf(new TouchExplorationStateProvider_androidKt$touchExplorationState$3$1(listener));
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceableGroup();
        State<Boolean> state = (State) objRememberedValue3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return state;
    }
}
