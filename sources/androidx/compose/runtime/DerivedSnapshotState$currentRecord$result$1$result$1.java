package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.snapshots.StateObject;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DerivedSnapshotState$currentRecord$result$1$result$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ int $nestedCalculationLevel;
    final /* synthetic */ IdentityArrayMap<StateObject, Integer> $newDependencies;
    final /* synthetic */ DerivedSnapshotState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DerivedSnapshotState$currentRecord$result$1$result$1(DerivedSnapshotState<T> derivedSnapshotState, IdentityArrayMap<StateObject, Integer> identityArrayMap, int i) {
        super(1);
        this.this$0 = derivedSnapshotState;
        this.$newDependencies = identityArrayMap;
        this.$nestedCalculationLevel = i;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m2633invoke(obj);
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2633invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        if (obj == this.this$0) {
            throw new IllegalStateException("A derived state calculation cannot read itself");
        }
        if (obj instanceof StateObject) {
            Object obj2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
            AbstractC4492zt.e(obj2);
            int iIntValue = ((Number) obj2).intValue();
            IdentityArrayMap<StateObject, Integer> identityArrayMap = this.$newDependencies;
            int i = iIntValue - this.$nestedCalculationLevel;
            Integer num = identityArrayMap.get(obj);
            identityArrayMap.set(obj, Integer.valueOf(Math.min(i, num != null ? num.intValue() : Integer.MAX_VALUE)));
        }
    }
}
