package defpackage;

import com.zebra.sdk.util.internal.StringUtilities;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: lS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3310lS extends AbstractC3228kS {

    /* JADX INFO: renamed from: lS$a */
    public static final class a extends AbstractC2233fv implements InterfaceC3750qp {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str) {
            AbstractC4492zt.h(str, "line");
            return str;
        }
    }

    /* JADX INFO: renamed from: lS$b */
    public static final class b extends AbstractC2233fv implements InterfaceC3750qp {
        public final /* synthetic */ String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.a = str;
        }

        @Override // defpackage.InterfaceC3750qp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str) {
            AbstractC4492zt.h(str, "line");
            return this.a + str;
        }
    }

    public static final InterfaceC3750qp b(String str) {
        return str.length() == 0 ? a.a : new b(str);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0019  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    public static final int c(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (!AbstractC3566ob.c(str.charAt(i))) {
                if (i == -1) {
                    return str.length();
                }
                return i;
            }
            i++;
        }
        i = -1;
        if (i == -1) {
            return str.length();
        }
        return i;
    }

    public static final String d(String str, String str2) {
        String str3;
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(str2, "newIndent");
        List listA0 = AbstractC3961tS.a0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA0) {
            if (!AbstractC3961tS.T((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC2044dc.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(c((String) it.next())));
        }
        Integer num = (Integer) AbstractC3240kc.n0(arrayList2);
        int i = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * listA0.size());
        InterfaceC3750qp interfaceC3750qpB = b(str2);
        int iO = AbstractC1886cc.o(listA0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listA0) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC1886cc.w();
            }
            String str4 = (String) obj2;
            if ((i == 0 || i == iO) && AbstractC3961tS.T(str4)) {
                str4 = null;
            } else {
                String strE0 = AbstractC4123vS.E0(str4, iIntValue);
                if (strE0 != null && (str3 = (String) interfaceC3750qpB.invoke(strE0)) != null) {
                    str4 = str3;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i = i2;
        }
        String string = ((StringBuilder) AbstractC3240kc.g0(arrayList3, new StringBuilder(length), (124 & 2) != 0 ? ", " : StringUtilities.LF, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
        AbstractC4492zt.g(string, "toString(...)");
        return string;
    }

    public static final String e(String str, String str2, String str3) {
        int i;
        String str4;
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(str2, "newIndent");
        AbstractC4492zt.h(str3, "marginPrefix");
        if (AbstractC3961tS.T(str3)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List listA0 = AbstractC3961tS.a0(str);
        int length = str.length() + (str2.length() * listA0.size());
        InterfaceC3750qp interfaceC3750qpB = b(str2);
        int iO = AbstractC1886cc.o(listA0);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : listA0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC1886cc.w();
            }
            String str5 = (String) obj;
            String strSubstring = null;
            if ((i2 == 0 || i2 == iO) && AbstractC3961tS.T(str5)) {
                str5 = null;
            } else {
                int length2 = str5.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        i = -1;
                        break;
                    }
                    if (!AbstractC3566ob.c(str5.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1) {
                    int i5 = i;
                    if (AbstractC3880sS.A(str5, str3, i, false, 4, null)) {
                        int length3 = i5 + str3.length();
                        AbstractC4492zt.f(str5, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str5.substring(length3);
                        AbstractC4492zt.g(strSubstring, "substring(...)");
                    }
                }
                if (strSubstring != null && (str4 = (String) interfaceC3750qpB.invoke(strSubstring)) != null) {
                    str5 = str4;
                }
            }
            if (str5 != null) {
                arrayList.add(str5);
            }
            i2 = i3;
        }
        String string = ((StringBuilder) AbstractC3240kc.g0(arrayList, new StringBuilder(length), (124 & 2) != 0 ? ", " : StringUtilities.LF, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
        AbstractC4492zt.g(string, "toString(...)");
        return string;
    }

    public static String f(String str) {
        AbstractC4492zt.h(str, "<this>");
        return d(str, "");
    }

    public static final String g(String str, String str2) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(str2, "marginPrefix");
        return e(str, "", str2);
    }

    public static /* synthetic */ String h(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return g(str, str2);
    }
}
