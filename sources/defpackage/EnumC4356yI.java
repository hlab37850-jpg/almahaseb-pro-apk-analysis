package defpackage;

import java.io.IOException;

/* JADX INFO: renamed from: yI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC4356yI {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    public static final a b = new a(null);
    public final String a;

    /* JADX INFO: renamed from: yI$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final EnumC4356yI a(String str) throws IOException {
            AbstractC4492zt.h(str, "protocol");
            EnumC4356yI enumC4356yI = EnumC4356yI.HTTP_1_0;
            if (!AbstractC4492zt.d(str, enumC4356yI.a)) {
                enumC4356yI = EnumC4356yI.HTTP_1_1;
                if (!AbstractC4492zt.d(str, enumC4356yI.a)) {
                    enumC4356yI = EnumC4356yI.H2_PRIOR_KNOWLEDGE;
                    if (!AbstractC4492zt.d(str, enumC4356yI.a)) {
                        enumC4356yI = EnumC4356yI.HTTP_2;
                        if (!AbstractC4492zt.d(str, enumC4356yI.a)) {
                            enumC4356yI = EnumC4356yI.SPDY_3;
                            if (!AbstractC4492zt.d(str, enumC4356yI.a)) {
                                enumC4356yI = EnumC4356yI.QUIC;
                                if (!AbstractC4492zt.d(str, enumC4356yI.a)) {
                                    throw new IOException("Unexpected protocol: " + str);
                                }
                            }
                        }
                    }
                }
            }
            return enumC4356yI;
        }

        public a() {
        }
    }

    EnumC4356yI(String str) {
        this.a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.a;
    }
}
