package androidx.compose.runtime;

import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.GD;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ComposablesKt {

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposablesKt$ComposeNode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC3588op $factory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC3588op interfaceC3588op) {
            super(0);
            this.$factory = interfaceC3588op;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // defpackage.InterfaceC3588op
        public final T invoke() {
            return this.$factory.invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposablesKt$ReusableComposeNode$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16121 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC3588op $factory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16121(InterfaceC3588op interfaceC3588op) {
            super(0);
            this.$factory = interfaceC3588op;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // defpackage.InterfaceC3588op
        public final T invoke() {
            return this.$factory.invoke();
        }
    }

    @Composable
    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(InterfaceC3588op interfaceC3588op, InterfaceC3750qp interfaceC3750qp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC3588op, "factory");
        AbstractC4492zt.h(interfaceC3750qp, "update");
        composer.startReplaceableGroup(1886828752);
        Applier<?> applier = composer.getApplier();
        AbstractC4492zt.m(3, "E");
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(new AnonymousClass1(interfaceC3588op));
        } else {
            composer.useNode();
        }
        interfaceC3750qp.invoke(Updater.m2660boximpl(Updater.m2661constructorimpl(composer)));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(InterfaceC3588op interfaceC3588op, InterfaceC3750qp interfaceC3750qp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC3588op, "factory");
        AbstractC4492zt.h(interfaceC3750qp, "update");
        composer.startReplaceableGroup(1405779621);
        Applier<?> applier = composer.getApplier();
        AbstractC4492zt.m(3, "E");
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(new C16121(interfaceC3588op));
        } else {
            composer.useNode();
        }
        interfaceC3750qp.invoke(Updater.m2660boximpl(Updater.m2661constructorimpl(composer)));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void ReusableContent(Object obj, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        composer.startReplaceableGroup(444418301);
        composer.startReusableGroup(ComposerKt.reuseKey, obj);
        interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i >> 3) & 14));
        composer.endReusableGroup();
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void ReusableContentHost(boolean z, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        composer.startReusableGroup(ComposerKt.reuseKey, Boolean.valueOf(z));
        boolean zChanged = composer.changed(z);
        if (z) {
            interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i >> 3) & 14));
        } else {
            composer.deactivateToEndGroup(zChanged);
        }
        composer.endReusableGroup();
    }

    @Composable
    @ReadOnlyComposable
    public static final Composer getCurrentComposer(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-554250212, i, -1, "androidx.compose.runtime.<get-currentComposer> (Composables.kt:183)");
        }
        throw new GD("Implemented as an intrinsic");
    }

    @Composable
    public static final int getCurrentCompositeKeyHash(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(524444915, i, -1, "androidx.compose.runtime.<get-currentCompositeKeyHash> (Composables.kt:224)");
        }
        int compoundKeyHash = composer.getCompoundKeyHash();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return compoundKeyHash;
    }

    @Composable
    public static final CompositionLocalContext getCurrentCompositionLocalContext(Composer composer, int i) {
        composer.startReplaceableGroup(-43352356);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-43352356, i, -1, "androidx.compose.runtime.<get-currentCompositionLocalContext> (Composables.kt:207)");
        }
        CompositionLocalContext compositionLocalContext = new CompositionLocalContext(composer.buildContext().getCompositionLocalScope$runtime_release());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return compositionLocalContext;
    }

    public static /* synthetic */ void getCurrentCompositionLocalContext$annotations() {
    }

    @Composable
    @ReadOnlyComposable
    public static final RecomposeScope getCurrentRecomposeScope(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(394957799, i, -1, "androidx.compose.runtime.<get-currentRecomposeScope> (Composables.kt:192)");
        }
        RecomposeScope recomposeScope = composer.getRecomposeScope();
        if (recomposeScope == null) {
            throw new IllegalStateException("no recompose scope found");
        }
        composer.recordUsed(recomposeScope);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return recomposeScope;
    }

    public static final void invalidApplier() {
        throw new IllegalStateException("Invalid applier");
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> T key(Object[] objArr, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(objArr, "keys");
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        composer.startReplaceableGroup(-11941951);
        T t = (T) interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i >> 3) & 14));
        composer.endReplaceableGroup();
        return t;
    }

    @Composable
    public static final <T> T remember(Object obj, InterfaceC3588op interfaceC3588op, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC3588op, "calculation");
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(obj);
        T t = (T) composer.rememberedValue();
        if (zChanged || t == Composer.Companion.getEmpty()) {
            t = (T) interfaceC3588op.invoke();
            composer.updateRememberedValue(t);
        }
        composer.endReplaceableGroup();
        return t;
    }

    @Composable
    public static final CompositionContext rememberCompositionContext(Composer composer, int i) {
        composer.startReplaceableGroup(-1165786124);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1165786124, i, -1, "androidx.compose.runtime.rememberCompositionContext (Composables.kt:480)");
        }
        CompositionContext compositionContextBuildContext = composer.buildContext();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return compositionContextBuildContext;
    }

    @Composable
    public static final <T> T remember(Object obj, Object obj2, InterfaceC3588op interfaceC3588op, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC3588op, "calculation");
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(obj) | composer.changed(obj2);
        T t = (T) composer.rememberedValue();
        if (zChanged || t == Composer.Companion.getEmpty()) {
            t = (T) interfaceC3588op.invoke();
            composer.updateRememberedValue(t);
        }
        composer.endReplaceableGroup();
        return t;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(InterfaceC3588op interfaceC3588op, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC3588op, "factory");
        AbstractC4492zt.h(interfaceC3750qp, "update");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        composer.startReplaceableGroup(-548224868);
        Applier<?> applier = composer.getApplier();
        AbstractC4492zt.m(3, "E");
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(interfaceC3588op);
        } else {
            composer.useNode();
        }
        interfaceC3750qp.invoke(Updater.m2660boximpl(Updater.m2661constructorimpl(composer)));
        interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i >> 6) & 14));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(InterfaceC3588op interfaceC3588op, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC3588op, "factory");
        AbstractC4492zt.h(interfaceC3750qp, "update");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        composer.startReplaceableGroup(-692256719);
        Applier<?> applier = composer.getApplier();
        AbstractC4492zt.m(3, "E");
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(interfaceC3588op);
        } else {
            composer.useNode();
        }
        interfaceC3750qp.invoke(Updater.m2660boximpl(Updater.m2661constructorimpl(composer)));
        interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i >> 6) & 14));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final <T> T remember(Object obj, Object obj2, Object obj3, InterfaceC3588op interfaceC3588op, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC3588op, "calculation");
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        T t = (T) composer.rememberedValue();
        if (zChanged || t == Composer.Companion.getEmpty()) {
            t = (T) interfaceC3588op.invoke();
            composer.updateRememberedValue(t);
        }
        composer.endReplaceableGroup();
        return t;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(InterfaceC3588op interfaceC3588op, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC3588op, "factory");
        AbstractC4492zt.h(interfaceC3750qp, "update");
        AbstractC4492zt.h(interfaceC0552Gp, "skippableUpdate");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Applier<?> applier = composer.getApplier();
        AbstractC4492zt.m(3, "E");
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(interfaceC3588op);
        } else {
            composer.useNode();
        }
        interfaceC3750qp.invoke(Updater.m2660boximpl(Updater.m2661constructorimpl(composer)));
        interfaceC0552Gp.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, Integer.valueOf((i >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(InterfaceC3588op interfaceC3588op, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC3588op, "factory");
        AbstractC4492zt.h(interfaceC3750qp, "update");
        AbstractC4492zt.h(interfaceC0552Gp, "skippableUpdate");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Applier<?> applier = composer.getApplier();
        AbstractC4492zt.m(3, "E");
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(interfaceC3588op);
        } else {
            composer.useNode();
        }
        interfaceC3750qp.invoke(Updater.m2660boximpl(Updater.m2661constructorimpl(composer)));
        interfaceC0552Gp.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, Integer.valueOf((i >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
    }

    @Composable
    public static final <T> T remember(Object[] objArr, InterfaceC3588op interfaceC3588op, Composer composer, int i) {
        AbstractC4492zt.h(objArr, "keys");
        AbstractC4492zt.h(interfaceC3588op, "calculation");
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (Object obj : objArr) {
            zChanged |= composer.changed(obj);
        }
        T t = (T) composer.rememberedValue();
        if (zChanged || t == Composer.Companion.getEmpty()) {
            t = (T) interfaceC3588op.invoke();
            composer.updateRememberedValue(t);
        }
        composer.endReplaceableGroup();
        return t;
    }

    @Composable
    public static final <T> T remember(InterfaceC3588op interfaceC3588op, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC3588op, "calculation");
        composer.startReplaceableGroup(-492369756);
        T t = (T) composer.rememberedValue();
        if (t == Composer.Companion.getEmpty()) {
            t = (T) interfaceC3588op.invoke();
            composer.updateRememberedValue(t);
        }
        composer.endReplaceableGroup();
        return t;
    }
}
