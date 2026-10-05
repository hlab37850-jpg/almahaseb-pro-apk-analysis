package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.tooling.CompositionData;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0988Vf;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class CompositionContext {
    public static final int $stable = 0;

    public abstract void composeInitial$runtime_release(ControlledComposition controlledComposition, InterfaceC0526Fp interfaceC0526Fp);

    public abstract void deletedMovableContent$runtime_release(MovableContentStateReference movableContentStateReference);

    public void doneComposing$runtime_release() {
    }

    public abstract boolean getCollectingParameterInformation$runtime_release();

    public PersistentCompositionLocalMap getCompositionLocalScope$runtime_release() {
        return CompositionContextKt.EmptyPersistentCompositionLocalMap;
    }

    public abstract int getCompoundHashKey$runtime_release();

    public abstract InterfaceC0988Vf getEffectCoroutineContext();

    public abstract InterfaceC0988Vf getRecomposeCoroutineContext$runtime_release();

    public abstract void insertMovableContent$runtime_release(MovableContentStateReference movableContentStateReference);

    public abstract void invalidate$runtime_release(ControlledComposition controlledComposition);

    public abstract void invalidateScope$runtime_release(RecomposeScopeImpl recomposeScopeImpl);

    public abstract void movableContentStateReleased$runtime_release(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState);

    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference movableContentStateReference) {
        AbstractC4492zt.h(movableContentStateReference, "reference");
        return null;
    }

    public void recordInspectionTable$runtime_release(Set<CompositionData> set) {
        AbstractC4492zt.h(set, "table");
    }

    public void registerComposer$runtime_release(Composer composer) {
        AbstractC4492zt.h(composer, "composer");
    }

    public abstract void registerComposition$runtime_release(ControlledComposition controlledComposition);

    public abstract void reportRemovedComposition$runtime_release(ControlledComposition controlledComposition);

    public void startComposing$runtime_release() {
    }

    public void unregisterComposer$runtime_release(Composer composer) {
        AbstractC4492zt.h(composer, "composer");
    }

    public abstract void unregisterComposition$runtime_release(ControlledComposition controlledComposition);
}
