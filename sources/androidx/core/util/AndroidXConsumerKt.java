package androidx.core.util;

import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidXConsumerKt {
    public static final <T> Consumer<T> asAndroidXConsumer(InterfaceC0793Of interfaceC0793Of) {
        return new AndroidXContinuationConsumer(interfaceC0793Of);
    }
}
