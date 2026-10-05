package androidx.core.util;

import androidx.annotation.RequiresApi;
import defpackage.AbstractC2377hf;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
public final class ConsumerKt {
    @RequiresApi(24)
    public static final <T> java.util.function.Consumer<T> asConsumer(InterfaceC0793Of interfaceC0793Of) {
        return AbstractC2377hf.a(new ContinuationConsumer(interfaceC0793Of));
    }
}
