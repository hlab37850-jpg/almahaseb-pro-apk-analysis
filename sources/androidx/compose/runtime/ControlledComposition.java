package androidx.compose.runtime;

import defpackage.C2020dG;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface ControlledComposition extends Composition {
    void applyChanges();

    void applyLateChanges();

    void changesApplied();

    void composeContent(InterfaceC0526Fp interfaceC0526Fp);

    <R> R delegateInvalidations(ControlledComposition controlledComposition, int i, InterfaceC3588op interfaceC3588op);

    @InternalComposeApi
    void disposeUnusedMovableContent(MovableContentState movableContentState);

    boolean getHasPendingChanges();

    @InternalComposeApi
    void insertMovableContent(List<C2020dG> list);

    void invalidateAll();

    boolean isComposing();

    boolean observesAnyOf(Set<? extends Object> set);

    void prepareCompose(InterfaceC3588op interfaceC3588op);

    boolean recompose();

    void recordModificationsOf(Set<? extends Object> set);

    void recordReadOf(Object obj);

    void recordWriteOf(Object obj);

    @InternalComposeApi
    void verifyConsistent();
}
