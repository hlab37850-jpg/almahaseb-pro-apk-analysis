package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: ng, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3494ng implements InterfaceC3461nF {
    public Map a;
    public InterfaceC3461nF b;
    public InterfaceC3461nF c;

    public C3494ng(Map map, String str, String str2) throws EF {
        this.a = map;
        InterfaceC3461nF interfaceC3461nF = (InterfaceC3461nF) map.get(str);
        this.b = interfaceC3461nF;
        if (interfaceC3461nF == null) {
            throw new EF("Unknown crypt filter specified as default for streams: " + str);
        }
        InterfaceC3461nF interfaceC3461nF2 = (InterfaceC3461nF) this.a.get(str2);
        this.c = interfaceC3461nF2;
        if (interfaceC3461nF2 != null) {
            return;
        }
        throw new EF("Unknown crypt filter specified as default for strings: " + str2);
    }

    @Override // defpackage.InterfaceC3461nF
    public T8 a(String str, BF bf, T8 t8) throws EF {
        InterfaceC3461nF interfaceC3461nF;
        if (str == null) {
            interfaceC3461nF = this.b;
        } else {
            interfaceC3461nF = (InterfaceC3461nF) this.a.get(str);
            if (interfaceC3461nF == null) {
                throw new EF("Unknown CryptFilter: " + str);
            }
        }
        if (str != null) {
            bf = null;
        }
        return interfaceC3461nF.a(null, bf, t8);
    }

    @Override // defpackage.InterfaceC3461nF
    public boolean b() {
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            if (((InterfaceC3461nF) it.next()).b()) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.InterfaceC3461nF
    public String c(int i, int i2, String str) {
        return this.c.c(i, i2, str);
    }
}
