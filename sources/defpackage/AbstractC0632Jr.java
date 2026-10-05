package defpackage;

import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: Jr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0632Jr {
    public static final W8 a;
    public static final W8 b;

    static {
        W8.a aVar = W8.d;
        a = aVar.c("\"\\");
        b = aVar.c("\t ,=");
    }

    public static final List a(C3994tr c3994tr, String str) {
        AbstractC4492zt.h(c3994tr, "<this>");
        AbstractC4492zt.h(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = c3994tr.size();
        for (int i = 0; i < size; i++) {
            if (AbstractC3880sS.q(str, c3994tr.b(i), true)) {
                try {
                    c(new H8().l(c3994tr.e(i)), arrayList);
                } catch (EOFException e) {
                    EG.a.g().j("Unable to parse challenge", 5, e);
                }
            }
        }
        return arrayList;
    }

    public static final boolean b(EL el) {
        AbstractC4492zt.h(el, "<this>");
        if (AbstractC4492zt.d(el.K().g(), HttpMethods.HEAD)) {
            return false;
        }
        int iR = el.r();
        return (((iR >= 100 && iR < 200) || iR == 204 || iR == 304) && AbstractC3724qX.v(el) == -1 && !AbstractC3880sS.q("chunked", EL.x(el, HttpHeaders.TRANSFER_ENCODING, null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0083  */
    /* JADX WARN: Code duplicated, block: B:35:0x0096  */
    /* JADX WARN: Code duplicated, block: B:36:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ba A[EDGE_INSN: B:59:0x00ba->B:48:0x00ba BREAK  A[LOOP:2: B:22:0x0071->B:47:0x00b8], SYNTHETIC] */
    public static final void c(H8 h8, List list) throws EOFException {
        String strE;
        while (true) {
            String strE2 = null;
            while (true) {
                if (strE2 == null) {
                    g(h8);
                    strE2 = e(h8);
                    if (strE2 == null) {
                        return;
                    }
                }
                boolean zG = g(h8);
                String strE3 = e(h8);
                if (strE3 == null) {
                    if (h8.h()) {
                        list.add(new C0983Va(strE2, AbstractC4243wx.g()));
                        return;
                    }
                    return;
                }
                int iK = AbstractC3724qX.K(h8, (byte) 61);
                boolean zG2 = g(h8);
                if (zG || !(zG2 || h8.h())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iK2 = iK + AbstractC3724qX.K(h8, (byte) 61);
                    while (true) {
                        if (strE3 != null) {
                            if (iK2 != 0) {
                                break;
                                break;
                            }
                            if (iK2 <= 1) {
                                return;
                            }
                            if (h(h8, (byte) 34)) {
                                strE = d(h8);
                            } else {
                                strE = e(h8);
                            }
                            if (strE != null) {
                                return;
                            }
                            if (g(h8)) {
                            }
                            strE3 = null;
                        } else {
                            strE3 = e(h8);
                            if (!g(h8)) {
                                iK2 = AbstractC3724qX.K(h8, (byte) 61);
                                if (iK2 != 0) {
                                    break;
                                }
                                if (iK2 <= 1 || g(h8)) {
                                    return;
                                }
                                if (h(h8, (byte) 34)) {
                                    strE = d(h8);
                                } else {
                                    strE = e(h8);
                                }
                                if (strE != null || ((String) linkedHashMap.put(strE3, strE)) != null) {
                                    return;
                                }
                                if (g(h8) && !h8.h()) {
                                    return;
                                } else {
                                    strE3 = null;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    list.add(new C0983Va(strE2, linkedHashMap));
                    strE2 = strE3;
                } else {
                    Map mapSingletonMap = Collections.singletonMap(null, strE3 + AbstractC3880sS.t("=", iK));
                    AbstractC4492zt.g(mapSingletonMap, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
                    list.add(new C0983Va(strE2, mapSingletonMap));
                }
            }
        }
    }

    public static final String d(H8 h8) throws EOFException {
        if (h8.readByte() != 34) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        H8 h9 = new H8();
        while (true) {
            long jA = h8.A(a);
            if (jA == -1) {
                return null;
            }
            if (h8.x(jA) == 34) {
                h9.p(h8, jA);
                h8.readByte();
                return h9.O();
            }
            if (h8.R() == jA + 1) {
                return null;
            }
            h9.p(h8, jA);
            h8.readByte();
            h9.p(h8, 1L);
        }
    }

    public static final String e(H8 h8) {
        long jA = h8.A(b);
        if (jA == -1) {
            jA = h8.R();
        }
        if (jA != 0) {
            return h8.P(jA);
        }
        return null;
    }

    public static final void f(InterfaceC0932Tf interfaceC0932Tf, C0779Nr c0779Nr, C3994tr c3994tr) {
        AbstractC4492zt.h(interfaceC0932Tf, "<this>");
        AbstractC4492zt.h(c0779Nr, "url");
        AbstractC4492zt.h(c3994tr, "headers");
        if (interfaceC0932Tf == InterfaceC0932Tf.b) {
            return;
        }
        List listE = C0906Sf.j.e(c0779Nr, c3994tr);
        if (listE.isEmpty()) {
            return;
        }
        interfaceC0932Tf.a(c0779Nr, listE);
    }

    public static final boolean g(H8 h8) throws EOFException {
        boolean z = false;
        while (!h8.h()) {
            byte bX = h8.x(0L);
            if (bX == 44) {
                h8.readByte();
                z = true;
            } else {
                if (bX != 32 && bX != 9) {
                    break;
                }
                h8.readByte();
            }
        }
        return z;
    }

    public static final boolean h(H8 h8, byte b2) {
        return !h8.h() && h8.x(0L) == b2;
    }
}
