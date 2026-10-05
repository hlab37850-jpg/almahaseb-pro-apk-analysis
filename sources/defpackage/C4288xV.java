package defpackage;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.e;
import java.util.Set;

/* JADX INFO: renamed from: xV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4288xV implements TransportFactory {
    public final Set a;
    public final TransportContext b;
    public final InterfaceC4460zV c;

    public C4288xV(Set set, TransportContext transportContext, InterfaceC4460zV interfaceC4460zV) {
        this.a = set;
        this.b = transportContext;
        this.c = interfaceC4460zV;
    }

    @Override // com.google.android.datatransport.TransportFactory
    public Transport getTransport(String str, Class cls, Transformer transformer) {
        return getTransport(str, cls, Encoding.of("proto"), transformer);
    }

    @Override // com.google.android.datatransport.TransportFactory
    public Transport getTransport(String str, Class cls, Encoding encoding, Transformer transformer) {
        if (this.a.contains(encoding)) {
            return new e(this.b, str, encoding, transformer, this.c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", encoding, this.a));
    }
}
