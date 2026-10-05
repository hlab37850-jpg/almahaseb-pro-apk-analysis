package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.C2020dG;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CompositionKt {
    private static final Object PendingApplyNoModifications = new Object();

    public static final Composition Composition(Applier<?> applier, CompositionContext compositionContext) {
        AbstractC4492zt.h(applier, "applier");
        AbstractC4492zt.h(compositionContext, "parent");
        return new CompositionImpl(compositionContext, applier, null, 4, null);
    }

    public static final ControlledComposition ControlledComposition(Applier<?> applier, CompositionContext compositionContext) {
        AbstractC4492zt.h(applier, "applier");
        AbstractC4492zt.h(compositionContext, "parent");
        return new CompositionImpl(compositionContext, applier, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> void addValue(IdentityArrayMap<K, IdentityArraySet<V>> identityArrayMap, K k, V v) {
        if (identityArrayMap.contains(k)) {
            IdentityArraySet<V> identityArraySet = identityArrayMap.get(k);
            if (identityArraySet != null) {
                identityArraySet.add(v);
                return;
            }
            return;
        }
        IdentityArraySet<V> identityArraySet2 = new IdentityArraySet<>();
        identityArraySet2.add(v);
        FW fw = FW.a;
        identityArrayMap.set(k, identityArraySet2);
    }

    public static final void clearCompositionErrors() {
        HotReloader.Companion.clearErrors$runtime_release();
    }

    public static final List<C2020dG> currentCompositionErrors() {
        List<RecomposerErrorInfo> currentErrors$runtime_release = HotReloader.Companion.getCurrentErrors$runtime_release();
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(currentErrors$runtime_release, 10));
        for (RecomposerErrorInfo recomposerErrorInfo : currentErrors$runtime_release) {
            arrayList.add(HV.a(recomposerErrorInfo.getCause(), Boolean.valueOf(recomposerErrorInfo.getRecoverable())));
        }
        return arrayList;
    }

    @ExperimentalComposeApi
    public static final InterfaceC0988Vf getRecomposeCoroutineContext(ControlledComposition controlledComposition) {
        InterfaceC0988Vf recomposeContext;
        AbstractC4492zt.h(controlledComposition, "<this>");
        CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
        return (compositionImpl == null || (recomposeContext = compositionImpl.getRecomposeContext()) == null) ? C1172Zk.a : recomposeContext;
    }

    @ExperimentalComposeApi
    public static /* synthetic */ void getRecomposeCoroutineContext$annotations(ControlledComposition controlledComposition) {
    }

    public static final void invalidateGroupsWithKey(int i) {
        HotReloader.Companion.invalidateGroupsWithKey$runtime_release(i);
    }

    private static final <E> void removeValueIf(HashSet<E> hashSet, InterfaceC3750qp interfaceC3750qp) {
        Iterator<E> it = hashSet.iterator();
        AbstractC4492zt.g(it, "iterator()");
        while (it.hasNext()) {
            if (((Boolean) interfaceC3750qp.invoke(it.next())).booleanValue()) {
                it.remove();
            }
        }
    }

    public static final void simulateHotReload(Object obj) {
        AbstractC4492zt.h(obj, "context");
        HotReloader.Companion.simulateHotReload$runtime_release(obj);
    }

    @ExperimentalComposeApi
    public static final Composition Composition(Applier<?> applier, CompositionContext compositionContext, InterfaceC0988Vf interfaceC0988Vf) {
        AbstractC4492zt.h(applier, "applier");
        AbstractC4492zt.h(compositionContext, "parent");
        AbstractC4492zt.h(interfaceC0988Vf, "recomposeCoroutineContext");
        return new CompositionImpl(compositionContext, applier, interfaceC0988Vf);
    }

    @ExperimentalComposeApi
    public static final ControlledComposition ControlledComposition(Applier<?> applier, CompositionContext compositionContext, InterfaceC0988Vf interfaceC0988Vf) {
        AbstractC4492zt.h(applier, "applier");
        AbstractC4492zt.h(compositionContext, "parent");
        AbstractC4492zt.h(interfaceC0988Vf, "recomposeCoroutineContext");
        return new CompositionImpl(compositionContext, applier, interfaceC0988Vf);
    }
}
