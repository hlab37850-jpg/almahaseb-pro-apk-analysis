package defpackage;

import com.google.common.net.HttpHeaders;

/* JADX INFO: renamed from: jY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3152jY {
    public static final a g = new a(null);
    public final boolean a;
    public final Integer b;
    public final boolean c;
    public final Integer d;
    public final boolean e;
    public final boolean f;

    /* JADX INFO: renamed from: jY$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final C3152jY a(C3994tr c3994tr) {
            AbstractC4492zt.h(c3994tr, "responseHeaders");
            int size = c3994tr.size();
            boolean z = false;
            Integer numI = null;
            boolean z2 = false;
            Integer numI2 = null;
            boolean z3 = false;
            boolean z4 = false;
            for (int i = 0; i < size; i++) {
                if (AbstractC3880sS.q(c3994tr.b(i), HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, true)) {
                    String strE = c3994tr.e(i);
                    int i2 = 0;
                    while (i2 < strE.length()) {
                        int iR = AbstractC3724qX.r(strE, ',', i2, 0, 4, null);
                        int iP = AbstractC3724qX.p(strE, ';', i2, iR);
                        String strY = AbstractC3724qX.Y(strE, i2, iP);
                        int i3 = iP + 1;
                        if (AbstractC3880sS.q(strY, "permessage-deflate", true)) {
                            if (z) {
                                z4 = true;
                            }
                            i2 = i3;
                            while (i2 < iR) {
                                int iP2 = AbstractC3724qX.p(strE, ';', i2, iR);
                                int iP3 = AbstractC3724qX.p(strE, '=', i2, iP2);
                                String strY2 = AbstractC3724qX.Y(strE, i2, iP3);
                                String strI0 = iP3 < iP2 ? AbstractC3961tS.i0(AbstractC3724qX.Y(strE, iP3 + 1, iP2), "\"") : null;
                                i2 = iP2 + 1;
                                if (AbstractC3880sS.q(strY2, "client_max_window_bits", true)) {
                                    if (numI != null) {
                                        z4 = true;
                                    }
                                    numI = strI0 != null ? AbstractC3799rS.i(strI0) : null;
                                    if (numI == null) {
                                        z4 = true;
                                    }
                                } else if (AbstractC3880sS.q(strY2, "client_no_context_takeover", true)) {
                                    if (z2) {
                                        z4 = true;
                                    }
                                    if (strI0 != null) {
                                        z4 = true;
                                    }
                                    z2 = true;
                                } else if (AbstractC3880sS.q(strY2, "server_max_window_bits", true)) {
                                    if (numI2 != null) {
                                        z4 = true;
                                    }
                                    numI2 = strI0 != null ? AbstractC3799rS.i(strI0) : null;
                                    if (numI2 == null) {
                                        z4 = true;
                                    }
                                } else if (AbstractC3880sS.q(strY2, "server_no_context_takeover", true)) {
                                    if (z3) {
                                        z4 = true;
                                    }
                                    if (strI0 != null) {
                                        z4 = true;
                                    }
                                    z3 = true;
                                } else {
                                    z4 = true;
                                }
                            }
                            z = true;
                        } else {
                            i2 = i3;
                            z4 = true;
                        }
                    }
                }
            }
            return new C3152jY(z, numI, z2, numI2, z3, z4);
        }

        public a() {
        }
    }

    public C3152jY(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        this.a = z;
        this.b = num;
        this.c = z2;
        this.d = num2;
        this.e = z3;
        this.f = z4;
    }

    public final boolean a(boolean z) {
        return z ? this.c : this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3152jY)) {
            return false;
        }
        C3152jY c3152jY = (C3152jY) obj;
        return this.a == c3152jY.a && AbstractC4492zt.d(this.b, c3152jY.b) && this.c == c3152jY.c && AbstractC4492zt.d(this.d, c3152jY.d) && this.e == c3152jY.e && this.f == c3152jY.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z = this.a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        Integer num = this.b;
        int iHashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        boolean z2 = this.c;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (iHashCode + r2) * 31;
        Integer num2 = this.d;
        int iHashCode2 = (i2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z3 = this.e;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i3 = (iHashCode2 + r3) * 31;
        boolean z4 = this.f;
        return i3 + (z4 ? 1 : z4);
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.a + ", clientMaxWindowBits=" + this.b + ", clientNoContextTakeover=" + this.c + ", serverMaxWindowBits=" + this.d + ", serverNoContextTakeover=" + this.e + ", unknownValues=" + this.f + ')';
    }
}
