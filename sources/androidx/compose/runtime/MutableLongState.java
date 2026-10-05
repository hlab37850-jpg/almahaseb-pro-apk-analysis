package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.AutoboxingStateValueProperty;
import defpackage.AbstractC4188wC;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface MutableLongState extends LongState, MutableState<Long> {

    public static final class DefaultImpls {
        @AutoboxingStateValueProperty(preferredPropertyName = "longValue")
        @Deprecated
        public static Long getValue(MutableLongState mutableLongState) {
            return Long.valueOf(AbstractC4188wC.a(mutableLongState).longValue());
        }

        @AutoboxingStateValueProperty(preferredPropertyName = "longValue")
        @Deprecated
        public static void setValue(MutableLongState mutableLongState, long j) {
            AbstractC4188wC.c(mutableLongState, j);
        }
    }

    @Override // androidx.compose.runtime.LongState
    long getLongValue();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.LongState, androidx.compose.runtime.State
    @AutoboxingStateValueProperty(preferredPropertyName = "longValue")
    Long getValue();

    @Override // androidx.compose.runtime.LongState, androidx.compose.runtime.State
    /* bridge */ /* synthetic */ Long getValue();

    void setLongValue(long j);

    @AutoboxingStateValueProperty(preferredPropertyName = "longValue")
    void setValue(long j);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ void setValue(Long l);
}
