package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.AutoboxingStateValueProperty;
import defpackage.AbstractC4107vC;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface MutableIntState extends IntState, MutableState<Integer> {

    public static final class DefaultImpls {
        @AutoboxingStateValueProperty(preferredPropertyName = "intValue")
        @Deprecated
        public static Integer getValue(MutableIntState mutableIntState) {
            return Integer.valueOf(AbstractC4107vC.a(mutableIntState).intValue());
        }

        @AutoboxingStateValueProperty(preferredPropertyName = "intValue")
        @Deprecated
        public static void setValue(MutableIntState mutableIntState, int i) {
            AbstractC4107vC.c(mutableIntState, i);
        }
    }

    @Override // androidx.compose.runtime.IntState
    int getIntValue();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.IntState, androidx.compose.runtime.State
    @AutoboxingStateValueProperty(preferredPropertyName = "intValue")
    Integer getValue();

    @Override // androidx.compose.runtime.IntState, androidx.compose.runtime.State
    /* bridge */ /* synthetic */ Integer getValue();

    void setIntValue(int i);

    @AutoboxingStateValueProperty(preferredPropertyName = "intValue")
    void setValue(int i);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ void setValue(Integer num);
}
