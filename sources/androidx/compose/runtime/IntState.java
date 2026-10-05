package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.AutoboxingStateValueProperty;
import defpackage.AbstractC1027Ws;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface IntState extends State<Integer> {

    public static final class DefaultImpls {
        @AutoboxingStateValueProperty(preferredPropertyName = "intValue")
        @Deprecated
        public static Integer getValue(IntState intState) {
            return Integer.valueOf(AbstractC1027Ws.a(intState).intValue());
        }
    }

    int getIntValue();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.State
    @AutoboxingStateValueProperty(preferredPropertyName = "intValue")
    Integer getValue();

    @Override // androidx.compose.runtime.State
    /* bridge */ /* synthetic */ Integer getValue();
}
