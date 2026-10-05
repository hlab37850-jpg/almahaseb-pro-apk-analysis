package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.AutoboxingStateValueProperty;
import defpackage.AbstractC1990cx;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface LongState extends State<Long> {

    public static final class DefaultImpls {
        @AutoboxingStateValueProperty(preferredPropertyName = "longValue")
        @Deprecated
        public static Long getValue(LongState longState) {
            return Long.valueOf(AbstractC1990cx.a(longState).longValue());
        }
    }

    long getLongValue();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.State
    @AutoboxingStateValueProperty(preferredPropertyName = "longValue")
    Long getValue();

    @Override // androidx.compose.runtime.State
    /* bridge */ /* synthetic */ Long getValue();
}
