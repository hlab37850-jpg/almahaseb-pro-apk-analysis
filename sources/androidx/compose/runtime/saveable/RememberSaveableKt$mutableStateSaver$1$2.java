package androidx.compose.runtime.saveable;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class RememberSaveableKt$mutableStateSaver$1$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Saver<T, Object> $this_with;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RememberSaveableKt$mutableStateSaver$1$2(Saver<T, Object> saver) {
        super(1);
        this.$this_with = saver;
    }

    @Override // defpackage.InterfaceC3750qp
    public final MutableState<T> invoke(MutableState<Object> mutableState) {
        Object objRestore;
        AbstractC4492zt.h(mutableState, "it");
        if (!(mutableState instanceof SnapshotMutableState)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (mutableState.getValue() != null) {
            Saver<T, Object> saver = this.$this_with;
            Object value = mutableState.getValue();
            AbstractC4492zt.e(value);
            objRestore = saver.restore(value);
        } else {
            objRestore = null;
        }
        SnapshotMutationPolicy policy = ((SnapshotMutableState) mutableState).getPolicy();
        AbstractC4492zt.f(policy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver$lambda$2?>");
        MutableState<T> mutableStateMutableStateOf = SnapshotStateKt.mutableStateOf(objRestore, policy);
        AbstractC4492zt.f(mutableStateMutableStateOf, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver$lambda$2>");
        return mutableStateMutableStateOf;
    }
}
