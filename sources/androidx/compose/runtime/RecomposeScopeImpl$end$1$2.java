package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class RecomposeScopeImpl$end$1$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ IdentityArrayIntMap $instances;
    final /* synthetic */ int $token;
    final /* synthetic */ RecomposeScopeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecomposeScopeImpl$end$1$2(RecomposeScopeImpl recomposeScopeImpl, int i, IdentityArrayIntMap identityArrayIntMap) {
        super(1);
        this.this$0 = recomposeScopeImpl;
        this.$token = i;
        this.$instances = identityArrayIntMap;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Composition) obj);
        return FW.a;
    }

    public final void invoke(Composition composition) {
        AbstractC4492zt.h(composition, "composition");
        if (this.this$0.currentToken == this.$token && AbstractC4492zt.d(this.$instances, this.this$0.trackedInstances) && (composition instanceof CompositionImpl)) {
            IdentityArrayIntMap identityArrayIntMap = this.$instances;
            int i = this.$token;
            RecomposeScopeImpl recomposeScopeImpl = this.this$0;
            Object[] keys = identityArrayIntMap.getKeys();
            int[] values = identityArrayIntMap.getValues();
            int size = identityArrayIntMap.getSize();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = keys[i3];
                AbstractC4492zt.f(obj, "null cannot be cast to non-null type kotlin.Any");
                int i4 = values[i3];
                boolean z = i4 != i;
                if (z) {
                    CompositionImpl compositionImpl = (CompositionImpl) composition;
                    compositionImpl.removeObservation$runtime_release(obj, recomposeScopeImpl);
                    DerivedState<?> derivedState = obj instanceof DerivedState ? (DerivedState) obj : null;
                    if (derivedState != null) {
                        compositionImpl.removeDerivedStateObservation$runtime_release(derivedState);
                        IdentityArrayMap identityArrayMap = recomposeScopeImpl.trackedDependencies;
                        if (identityArrayMap != null) {
                            identityArrayMap.remove(derivedState);
                            if (identityArrayMap.getSize() == 0) {
                                recomposeScopeImpl.trackedDependencies = null;
                            }
                        }
                    }
                }
                if (!z) {
                    if (i2 != i3) {
                        keys[i2] = obj;
                        values[i2] = i4;
                    }
                    i2++;
                }
            }
            for (int i5 = i2; i5 < size; i5++) {
                keys[i5] = null;
            }
            identityArrayIntMap.size = i2;
            if (this.$instances.getSize() == 0) {
                this.this$0.trackedInstances = null;
            }
        }
    }
}
