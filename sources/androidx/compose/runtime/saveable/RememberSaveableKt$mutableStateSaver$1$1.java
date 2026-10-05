package androidx.compose.runtime.saveable;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class RememberSaveableKt$mutableStateSaver$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ Saver<T, Object> $this_with;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RememberSaveableKt$mutableStateSaver$1$1(Saver<T, Object> saver) {
        super(2);
        this.$this_with = saver;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final MutableState<Object> mo13invoke(SaverScope saverScope, MutableState<T> mutableState) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(mutableState, "state");
        if (!(mutableState instanceof SnapshotMutableState)) {
            throw new IllegalArgumentException("If you use a custom MutableState implementation you have to write a custom Saver and pass it as a saver param to rememberSaveable()");
        }
        Object objSave = this.$this_with.save(saverScope, (T) mutableState.getValue());
        SnapshotMutationPolicy policy = ((SnapshotMutableState) mutableState).getPolicy();
        AbstractC4492zt.f(policy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<kotlin.Any?>");
        return SnapshotStateKt.mutableStateOf(objSave, policy);
    }
}
