package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public final class KU extends CancellationException {
    public final transient InterfaceC1830bu a;

    public KU(String str, InterfaceC1830bu interfaceC1830bu) {
        super(str);
        this.a = interfaceC1830bu;
    }

    public KU(String str) {
        this(str, null);
    }
}
