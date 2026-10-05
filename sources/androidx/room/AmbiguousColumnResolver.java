package androidx.room;

import androidx.annotation.RestrictTo;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0919Ss;
import defpackage.AbstractC1805bc;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2371hc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;
import defpackage.OJ;
import defpackage.PO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    public static final class Match {
        private final List<Integer> resultIndices;
        private final C1001Vs resultRange;

        public Match(C1001Vs c1001Vs, List<Integer> list) {
            AbstractC4492zt.h(c1001Vs, "resultRange");
            AbstractC4492zt.h(list, "resultIndices");
            this.resultRange = c1001Vs;
            this.resultIndices = list;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final C1001Vs getResultRange() {
            return this.resultRange;
        }
    }

    public static final class ResultColumn {
        private final int index;
        private final String name;

        public ResultColumn(String str, int i) {
            AbstractC4492zt.h(str, "name");
            this.name = str;
            this.index = i;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i2 & 2) != 0) {
                i = resultColumn.index;
            }
            return resultColumn.copy(str, i);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        public final ResultColumn copy(String str, int i) {
            AbstractC4492zt.h(str, "name");
            return new ResultColumn(str, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            return AbstractC4492zt.d(this.name, resultColumn.name) && this.index == resultColumn.index;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.index;
        }

        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + ')';
        }
    }

    public static final class Solution implements Comparable<Solution> {
        public static final Companion Companion = new Companion(null);
        private static final Solution NO_SOLUTION = new Solution(AbstractC1886cc.m(), Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                this();
            }

            public final Solution build(List<Match> list) {
                AbstractC4492zt.h(list, "matches");
                List<Match> list2 = list;
                int i = 0;
                int iC = 0;
                for (Match match : list2) {
                    iC += ((match.getResultRange().c() - match.getResultRange().b()) + 1) - match.getResultIndices().size();
                }
                Iterator<T> it = list2.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                int iB = ((Match) it.next()).getResultRange().b();
                while (it.hasNext()) {
                    int iB2 = ((Match) it.next()).getResultRange().b();
                    if (iB > iB2) {
                        iB = iB2;
                    }
                }
                Iterator<T> it2 = list2.iterator();
                if (!it2.hasNext()) {
                    throw new NoSuchElementException();
                }
                int iC2 = ((Match) it2.next()).getResultRange().c();
                while (it2.hasNext()) {
                    int iC3 = ((Match) it2.next()).getResultRange().c();
                    if (iC2 < iC3) {
                        iC2 = iC3;
                    }
                }
                Iterable c1001Vs = new C1001Vs(iB, iC2);
                if (!(c1001Vs instanceof Collection) || !((Collection) c1001Vs).isEmpty()) {
                    Iterator it3 = c1001Vs.iterator();
                    int i2 = 0;
                    while (it3.hasNext()) {
                        int iNextInt = ((AbstractC0919Ss) it3).nextInt();
                        Iterator<T> it4 = list2.iterator();
                        int i3 = 0;
                        while (it4.hasNext()) {
                            if (((Match) it4.next()).getResultRange().g(iNextInt)) {
                                i3++;
                            }
                            if (i3 > 1) {
                                i2++;
                                if (i2 >= 0) {
                                    break;
                                }
                                AbstractC1886cc.v();
                                break;
                            }
                        }
                    }
                    i = i2;
                }
                return new Solution(list, iC, i);
            }

            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }

            private Companion() {
            }
        }

        public Solution(List<Match> list, int i, int i2) {
            AbstractC4492zt.h(list, "matches");
            this.matches = list;
            this.coverageOffset = i;
            this.overlaps = i2;
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        @Override // java.lang.Comparable
        public int compareTo(Solution solution) {
            AbstractC4492zt.h(solution, "other");
            int iJ = AbstractC4492zt.j(this.overlaps, solution.overlaps);
            return iJ != 0 ? iJ : AbstractC4492zt.j(this.coverageOffset, solution.coverageOffset);
        }
    }

    /* JADX INFO: renamed from: androidx.room.AmbiguousColumnResolver$resolve$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ OJ $bestSolution;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(OJ oj) {
            super(1);
            this.$bestSolution = oj;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<Match>) obj);
            return FW.a;
        }

        public final void invoke(List<Match> list) {
            AbstractC4492zt.h(list, "it");
            Solution solutionBuild = Solution.Companion.build(list);
            if (solutionBuild.compareTo((Solution) this.$bestSolution.a) < 0) {
                this.$bestSolution.a = solutionBuild;
            }
        }
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> list, List<T> list2, int i, InterfaceC3750qp interfaceC3750qp) {
        if (i == list.size()) {
            interfaceC3750qp.invoke(AbstractC3240kc.C0(list2));
            return;
        }
        Iterator<T> it = list.get(i).iterator();
        while (it.hasNext()) {
            list2.add(it.next());
            INSTANCE.dfs(list, list2, i + 1, interfaceC3750qp);
            AbstractC2371hc.P(list2);
        }
    }

    public static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i, InterfaceC3750qp interfaceC3750qp, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i, interfaceC3750qp);
    }

    private final void rabinKarpSearch(List<ResultColumn> list, String[] strArr, InterfaceC0552Gp interfaceC0552Gp) {
        int i = 0;
        int iHashCode = 0;
        for (String str : strArr) {
            iHashCode += str.hashCode();
        }
        int length = strArr.length;
        Iterator<T> it = list.subList(0, length).iterator();
        int iHashCode2 = 0;
        while (it.hasNext()) {
            iHashCode2 += ((ResultColumn) it.next()).getName().hashCode();
        }
        while (true) {
            if (iHashCode == iHashCode2) {
                interfaceC0552Gp.invoke(Integer.valueOf(i), Integer.valueOf(length), list.subList(i, length));
            }
            int i2 = i + 1;
            int i3 = length + 1;
            if (i3 > list.size()) {
                return;
            }
            iHashCode2 = (iHashCode2 - list.get(i).getName().hashCode()) + list.get(length).getName().hashCode();
            i = i2;
            length = i3;
        }
    }

    public static final int[][] resolve(String[] strArr, String[][] strArr2) {
        AbstractC4492zt.h(strArr, "resultColumns");
        AbstractC4492zt.h(strArr2, "mappings");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String strSubstring = strArr[i];
            if (strSubstring.charAt(0) == '`' && strSubstring.charAt(strSubstring.length() - 1) == '`') {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Locale locale = Locale.US;
            AbstractC4492zt.g(locale, "US");
            String lowerCase = strSubstring.toLowerCase(locale);
            AbstractC4492zt.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            strArr[i] = lowerCase;
        }
        int length2 = strArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            int length3 = strArr2[i2].length;
            for (int i3 = 0; i3 < length3; i3++) {
                String[] strArr3 = strArr2[i2];
                String str = strArr3[i3];
                Locale locale2 = Locale.US;
                AbstractC4492zt.g(locale2, "US");
                String lowerCase2 = str.toLowerCase(locale2);
                AbstractC4492zt.g(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                strArr3[i3] = lowerCase2;
            }
        }
        Set setB = PO.b();
        for (String[] strArr4 : strArr2) {
            AbstractC2371hc.E(setB, strArr4);
        }
        Set setA = PO.a(setB);
        List listC = AbstractC1805bc.c();
        int length4 = strArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length4) {
            String str2 = strArr[i4];
            int i6 = i5 + 1;
            if (setA.contains(str2)) {
                listC.add(new ResultColumn(str2, i5));
            }
            i4++;
            i5 = i6;
        }
        List<ResultColumn> listA = AbstractC1805bc.a(listC);
        int length5 = strArr2.length;
        ArrayList arrayList = new ArrayList(length5);
        for (int i7 = 0; i7 < length5; i7++) {
            arrayList.add(new ArrayList());
        }
        int length6 = strArr2.length;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length6) {
            String[] strArr5 = strArr2[i8];
            int i10 = i9 + 1;
            INSTANCE.rabinKarpSearch(listA, strArr5, new AmbiguousColumnResolver$resolve$1$1(strArr5, arrayList, i9));
            if (((List) arrayList.get(i9)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr5.length);
                for (String str3 : strArr5) {
                    List listC2 = AbstractC1805bc.c();
                    for (ResultColumn resultColumn : listA) {
                        if (AbstractC4492zt.d(str3, resultColumn.getName())) {
                            listC2.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    List listA2 = AbstractC1805bc.a(listC2);
                    if (listA2.isEmpty()) {
                        throw new IllegalStateException(("Column " + str3 + " not found in result").toString());
                    }
                    arrayList2.add(listA2);
                }
                dfs$default(INSTANCE, arrayList2, null, 0, new AmbiguousColumnResolver$resolve$1$2(arrayList, i9), 6, null);
            }
            i8++;
            i9 = i10;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((List) it.next()).isEmpty()) {
                    throw new IllegalStateException("Failed to find matches for all mappings");
                }
            }
        }
        OJ oj = new OJ();
        oj.a = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, null, 0, new AnonymousClass4(oj), 6, null);
        List<Match> matches = ((Solution) oj.a).getMatches();
        ArrayList arrayList3 = new ArrayList(AbstractC2044dc.x(matches, 10));
        Iterator<T> it2 = matches.iterator();
        while (it2.hasNext()) {
            arrayList3.add(AbstractC3240kc.B0(((Match) it2.next()).getResultIndices()));
        }
        Object[] array = arrayList3.toArray(new int[0][]);
        AbstractC4492zt.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (int[][]) array;
    }
}
