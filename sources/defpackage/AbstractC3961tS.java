package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.zebra.sdk.util.internal.StringUtilities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: tS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3961tS extends AbstractC3880sS {

    /* JADX INFO: renamed from: tS$a */
    public static final class a extends AbstractC2233fv implements InterfaceC0526Fp {
        public final /* synthetic */ char[] a;
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(char[] cArr, boolean z) {
            super(2);
            this.a = cArr;
            this.b = z;
        }

        public final C2020dG a(CharSequence charSequence, int i) {
            AbstractC4492zt.h(charSequence, "$this$$receiver");
            int iS = AbstractC3961tS.S(charSequence, this.a, i, this.b);
            if (iS < 0) {
                return null;
            }
            return HV.a(Integer.valueOf(iS), 1);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    /* JADX INFO: renamed from: tS$b */
    public static final class b extends AbstractC2233fv implements InterfaceC0526Fp {
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List list, boolean z) {
            super(2);
            this.a = list;
            this.b = z;
        }

        public final C2020dG a(CharSequence charSequence, int i) {
            AbstractC4492zt.h(charSequence, "$this$$receiver");
            C2020dG c2020dGJ = AbstractC3961tS.J(charSequence, this.a, i, this.b, false);
            if (c2020dGJ != null) {
                return HV.a(c2020dGJ.c(), Integer.valueOf(((String) c2020dGJ.e()).length()));
            }
            return null;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    /* JADX INFO: renamed from: tS$c */
    public static final class c extends AbstractC2233fv implements InterfaceC3750qp {
        public final /* synthetic */ CharSequence a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CharSequence charSequence) {
            super(1);
            this.a = charSequence;
        }

        @Override // defpackage.InterfaceC3750qp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(C1001Vs c1001Vs) {
            AbstractC4492zt.h(c1001Vs, "it");
            return AbstractC3961tS.v0(this.a, c1001Vs);
        }
    }

    public static /* synthetic */ String A0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return y0(str, str2, str3);
    }

    public static final String B0(String str, char c2, String str2) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(str2, "missingDelimiterValue");
        int iW = W(str, c2, 0, false, 6, null);
        if (iW == -1) {
            return str2;
        }
        String strSubstring = str.substring(iW + 1, str.length());
        AbstractC4492zt.g(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String C0(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return B0(str, c2, str2);
    }

    public static final boolean D(CharSequence charSequence, char c2, boolean z) {
        AbstractC4492zt.h(charSequence, "<this>");
        return Q(charSequence, c2, 0, z, 2, null) >= 0;
    }

    public static CharSequence D0(CharSequence charSequence) {
        AbstractC4492zt.h(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zC = AbstractC3566ob.c(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static boolean E(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (R(charSequence, (String) charSequence2, 0, z, 2, null) < 0) {
                return false;
            }
        } else if (P(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean F(CharSequence charSequence, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return D(charSequence, c2, z);
    }

    public static /* synthetic */ boolean G(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return E(charSequence, charSequence2, z);
    }

    public static final boolean H(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(charSequence2, "suffix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? AbstractC3880sS.p((String) charSequence, (String) charSequence2, false, 2, null) : f0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean I(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return H(charSequence, charSequence2, z);
    }

    public static final C2020dG J(CharSequence charSequence, Collection collection, int i, boolean z, boolean z2) {
        Object next;
        String str;
        Object next2;
        String str2;
        if (!z && collection.size() == 1) {
            String str3 = (String) AbstractC3240kc.s0(collection);
            int iR = !z2 ? R(charSequence, str3, i, false, 4, null) : X(charSequence, str3, i, false, 4, null);
            if (iR < 0) {
                return null;
            }
            return HV.a(Integer.valueOf(iR), str3);
        }
        C0945Ts c1001Vs = !z2 ? new C1001Vs(AbstractC3871sJ.d(i, 0), charSequence.length()) : AbstractC3871sJ.p(AbstractC3871sJ.g(i, L(charSequence)), 0);
        if (charSequence instanceof String) {
            int iB = c1001Vs.b();
            int iC = c1001Vs.c();
            int iD = c1001Vs.d();
            if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
                while (true) {
                    Iterator it = collection.iterator();
                    do {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        str2 = (String) next2;
                    } while (!AbstractC3880sS.s(str2, 0, (String) charSequence, iB, str2.length(), z));
                    String str4 = (String) next2;
                    if (str4 != null) {
                        return HV.a(Integer.valueOf(iB), str4);
                    }
                    if (iB != iC) {
                        iB += iD;
                    }
                }
            }
        } else {
            int iB2 = c1001Vs.b();
            int iC2 = c1001Vs.c();
            int iD2 = c1001Vs.d();
            if ((iD2 > 0 && iB2 <= iC2) || (iD2 < 0 && iC2 <= iB2)) {
                while (true) {
                    Iterator it2 = collection.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        str = (String) next;
                    } while (!f0(str, 0, charSequence, iB2, str.length(), z));
                    String str5 = (String) next;
                    if (str5 != null) {
                        return HV.a(Integer.valueOf(iB2), str5);
                    }
                    if (iB2 != iC2) {
                        iB2 += iD2;
                    }
                }
            }
        }
        return null;
    }

    public static C1001Vs K(CharSequence charSequence) {
        AbstractC4492zt.h(charSequence, "<this>");
        return new C1001Vs(0, charSequence.length() - 1);
    }

    public static int L(CharSequence charSequence) {
        AbstractC4492zt.h(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int M(CharSequence charSequence, char c2, int i, boolean z) {
        AbstractC4492zt.h(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? S(charSequence, new char[]{c2}, i, z) : ((String) charSequence).indexOf(c2, i);
    }

    public static final int N(CharSequence charSequence, String str, int i, boolean z) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(str, TypedValues.Custom.S_STRING);
        return (z || !(charSequence instanceof String)) ? P(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    public static final int O(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        C0945Ts c1001Vs = !z2 ? new C1001Vs(AbstractC3871sJ.d(i, 0), AbstractC3871sJ.g(i2, charSequence.length())) : AbstractC3871sJ.p(AbstractC3871sJ.g(i, L(charSequence)), AbstractC3871sJ.d(i2, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iB = c1001Vs.b();
            int iC = c1001Vs.c();
            int iD = c1001Vs.d();
            if ((iD <= 0 || iB > iC) && (iD >= 0 || iC > iB)) {
                return -1;
            }
            while (!AbstractC3880sS.s((String) charSequence2, 0, (String) charSequence, iB, charSequence2.length(), z)) {
                if (iB == iC) {
                    return -1;
                }
                iB += iD;
            }
            return iB;
        }
        int iB2 = c1001Vs.b();
        int iC2 = c1001Vs.c();
        int iD2 = c1001Vs.d();
        if ((iD2 <= 0 || iB2 > iC2) && (iD2 >= 0 || iC2 > iB2)) {
            return -1;
        }
        while (!f0(charSequence2, 0, charSequence, iB2, charSequence2.length(), z)) {
            if (iB2 == iC2) {
                return -1;
            }
            iB2 += iD2;
        }
        return iB2;
    }

    public static /* synthetic */ int P(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return O(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ int Q(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return M(charSequence, c2, i, z);
    }

    public static /* synthetic */ int R(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return N(charSequence, str, i, z);
    }

    public static final int S(CharSequence charSequence, char[] cArr, int i, boolean z) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(R5.c0(cArr), i);
        }
        int iD = AbstractC3871sJ.d(i, 0);
        int iL = L(charSequence);
        if (iD > iL) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iD);
            for (char c2 : cArr) {
                if (AbstractC3648pb.h(c2, cCharAt, z)) {
                    return iD;
                }
            }
            if (iD == iL) {
                return -1;
            }
            iD++;
        }
    }

    public static boolean T(CharSequence charSequence) {
        AbstractC4492zt.h(charSequence, "<this>");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!AbstractC3566ob.c(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static final int U(CharSequence charSequence, char c2, int i, boolean z) {
        AbstractC4492zt.h(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? Y(charSequence, new char[]{c2}, i, z) : ((String) charSequence).lastIndexOf(c2, i);
    }

    public static final int V(CharSequence charSequence, String str, int i, boolean z) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(str, TypedValues.Custom.S_STRING);
        return (z || !(charSequence instanceof String)) ? O(charSequence, str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ int W(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = L(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return U(charSequence, c2, i, z);
    }

    public static /* synthetic */ int X(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = L(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return V(charSequence, str, i, z);
    }

    public static final int Y(CharSequence charSequence, char[] cArr, int i, boolean z) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(R5.c0(cArr), i);
        }
        for (int iG = AbstractC3871sJ.g(i, L(charSequence)); -1 < iG; iG--) {
            char cCharAt = charSequence.charAt(iG);
            for (char c2 : cArr) {
                if (AbstractC3648pb.h(c2, cCharAt, z)) {
                    return iG;
                }
            }
        }
        return -1;
    }

    public static final InterfaceC4362yO Z(CharSequence charSequence) {
        AbstractC4492zt.h(charSequence, "<this>");
        return s0(charSequence, new String[]{StringUtilities.CRLF, StringUtilities.LF, "\r"}, false, 0, 6, null);
    }

    public static final List a0(CharSequence charSequence) {
        AbstractC4492zt.h(charSequence, "<this>");
        return FO.v(Z(charSequence));
    }

    public static final InterfaceC4362yO b0(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        l0(i2);
        return new C1253aj(charSequence, i, i2, new a(cArr, z));
    }

    public static final InterfaceC4362yO c0(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        l0(i2);
        return new C1253aj(charSequence, i, i2, new b(Q5.c(strArr), z));
    }

    public static /* synthetic */ InterfaceC4362yO d0(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return b0(charSequence, cArr, i, z, i2);
    }

    public static /* synthetic */ InterfaceC4362yO e0(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return c0(charSequence, strArr, i, z, i2);
    }

    public static final boolean f0(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!AbstractC3648pb.h(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String g0(String str, CharSequence charSequence) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(charSequence, "prefix");
        if (!u0(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length());
        AbstractC4492zt.g(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String h0(String str, CharSequence charSequence) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(charSequence, "suffix");
        if (!I(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - charSequence.length());
        AbstractC4492zt.g(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String i0(String str, CharSequence charSequence) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(charSequence, "delimiter");
        return j0(str, charSequence, charSequence);
    }

    public static final String j0(String str, CharSequence charSequence, CharSequence charSequence2) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(charSequence, "prefix");
        AbstractC4492zt.h(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length() || !u0(str, charSequence, false, 2, null) || !I(str, charSequence2, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        AbstractC4492zt.g(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence k0(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(charSequence2, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            AbstractC4492zt.g(sb, "append(...)");
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            AbstractC4492zt.g(sb, "append(...)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static final void l0(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    public static final List m0(CharSequence charSequence, char[] cArr, boolean z, int i) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(cArr, "delimiters");
        if (cArr.length == 1) {
            return o0(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable iterableI = FO.i(d0(charSequence, cArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(iterableI, 10));
        Iterator it = iterableI.iterator();
        while (it.hasNext()) {
            arrayList.add(v0(charSequence, (C1001Vs) it.next()));
        }
        return arrayList;
    }

    public static final List n0(CharSequence charSequence, String[] strArr, boolean z, int i) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return o0(charSequence, str, z, i);
            }
        }
        Iterable iterableI = FO.i(e0(charSequence, strArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(iterableI, 10));
        Iterator it = iterableI.iterator();
        while (it.hasNext()) {
            arrayList.add(v0(charSequence, (C1001Vs) it.next()));
        }
        return arrayList;
    }

    public static final List o0(CharSequence charSequence, String str, boolean z, int i) {
        l0(i);
        int length = 0;
        int iN = N(charSequence, str, 0, z);
        if (iN == -1 || i == 1) {
            return AbstractC1805bc.e(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? AbstractC3871sJ.g(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iN).toString());
            length = str.length() + iN;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iN = N(charSequence, str, length, z);
        } while (iN != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List p0(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m0(charSequence, cArr, z, i);
    }

    public static /* synthetic */ List q0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return n0(charSequence, strArr, z, i);
    }

    public static final InterfaceC4362yO r0(CharSequence charSequence, String[] strArr, boolean z, int i) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(strArr, "delimiters");
        return FO.r(e0(charSequence, strArr, 0, z, i, 2, null), new c(charSequence));
    }

    public static /* synthetic */ InterfaceC4362yO s0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return r0(charSequence, strArr, z, i);
    }

    public static final boolean t0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(charSequence2, "prefix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? AbstractC3880sS.B((String) charSequence, (String) charSequence2, false, 2, null) : f0(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean u0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return t0(charSequence, charSequence2, z);
    }

    public static final String v0(CharSequence charSequence, C1001Vs c1001Vs) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(c1001Vs, "range");
        return charSequence.subSequence(c1001Vs.getStart().intValue(), c1001Vs.getEndInclusive().intValue() + 1).toString();
    }

    public static String w0(String str, C1001Vs c1001Vs) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(c1001Vs, "range");
        String strSubstring = str.substring(c1001Vs.getStart().intValue(), c1001Vs.getEndInclusive().intValue() + 1);
        AbstractC4492zt.g(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String x0(String str, char c2, String str2) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(str2, "missingDelimiterValue");
        int iQ = Q(str, c2, 0, false, 6, null);
        if (iQ == -1) {
            return str2;
        }
        String strSubstring = str.substring(iQ + 1, str.length());
        AbstractC4492zt.g(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String y0(String str, String str2, String str3) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(str2, "delimiter");
        AbstractC4492zt.h(str3, "missingDelimiterValue");
        int iR = R(str, str2, 0, false, 6, null);
        if (iR == -1) {
            return str3;
        }
        String strSubstring = str.substring(iR + str2.length(), str.length());
        AbstractC4492zt.g(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String z0(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return x0(str, c2, str2);
    }
}
