package androidx.compose.ui.text.style;

import androidx.compose.runtime.Immutable;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class LineBreak {
    public static final Companion Companion = new Companion(null);
    private static final int Heading;
    private static final int Paragraph;
    private static final int Simple;
    private final int mask;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getHeading-rAG3T2k, reason: not valid java name */
        public final int m5000getHeadingrAG3T2k() {
            return LineBreak.Heading;
        }

        /* JADX INFO: renamed from: getParagraph-rAG3T2k, reason: not valid java name */
        public final int m5001getParagraphrAG3T2k() {
            return LineBreak.Paragraph;
        }

        /* JADX INFO: renamed from: getSimple-rAG3T2k, reason: not valid java name */
        public final int m5002getSimplerAG3T2k() {
            return LineBreak.Simple;
        }

        private Companion() {
        }
    }

    public static final class Strategy {
        private final int value;
        public static final Companion Companion = new Companion(null);
        private static final int Simple = m5004constructorimpl(1);
        private static final int HighQuality = m5004constructorimpl(2);
        private static final int Balanced = m5004constructorimpl(3);

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                this();
            }

            /* JADX INFO: renamed from: getBalanced-fcGXIks, reason: not valid java name */
            public final int m5010getBalancedfcGXIks() {
                return Strategy.Balanced;
            }

            /* JADX INFO: renamed from: getHighQuality-fcGXIks, reason: not valid java name */
            public final int m5011getHighQualityfcGXIks() {
                return Strategy.HighQuality;
            }

            /* JADX INFO: renamed from: getSimple-fcGXIks, reason: not valid java name */
            public final int m5012getSimplefcGXIks() {
                return Strategy.Simple;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Strategy(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strategy m5003boximpl(int i) {
            return new Strategy(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m5004constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m5005equalsimpl(int i, Object obj) {
            return (obj instanceof Strategy) && i == ((Strategy) obj).m5009unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m5006equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m5007hashCodeimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m5008toStringimpl(int i) {
            if (m5006equalsimpl0(i, Simple)) {
                return "Strategy.Simple";
            }
            if (m5006equalsimpl0(i, HighQuality)) {
                return "Strategy.HighQuality";
            }
            return m5006equalsimpl0(i, Balanced) ? "Strategy.Balanced" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m5005equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5007hashCodeimpl(this.value);
        }

        public String toString() {
            return m5008toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m5009unboximpl() {
            return this.value;
        }
    }

    public static final class Strictness {
        public static final Companion Companion = new Companion(null);
        private static final int Default = m5014constructorimpl(1);
        private static final int Loose = m5014constructorimpl(2);
        private static final int Normal = m5014constructorimpl(3);
        private static final int Strict = m5014constructorimpl(4);
        private final int value;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                this();
            }

            /* JADX INFO: renamed from: getDefault-usljTpc, reason: not valid java name */
            public final int m5020getDefaultusljTpc() {
                return Strictness.Default;
            }

            /* JADX INFO: renamed from: getLoose-usljTpc, reason: not valid java name */
            public final int m5021getLooseusljTpc() {
                return Strictness.Loose;
            }

            /* JADX INFO: renamed from: getNormal-usljTpc, reason: not valid java name */
            public final int m5022getNormalusljTpc() {
                return Strictness.Normal;
            }

            /* JADX INFO: renamed from: getStrict-usljTpc, reason: not valid java name */
            public final int m5023getStrictusljTpc() {
                return Strictness.Strict;
            }

            private Companion() {
            }
        }

        private /* synthetic */ Strictness(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Strictness m5013boximpl(int i) {
            return new Strictness(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m5014constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m5015equalsimpl(int i, Object obj) {
            return (obj instanceof Strictness) && i == ((Strictness) obj).m5019unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m5016equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m5017hashCodeimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m5018toStringimpl(int i) {
            if (m5016equalsimpl0(i, Default)) {
                return "Strictness.None";
            }
            if (m5016equalsimpl0(i, Loose)) {
                return "Strictness.Loose";
            }
            if (m5016equalsimpl0(i, Normal)) {
                return "Strictness.Normal";
            }
            return m5016equalsimpl0(i, Strict) ? "Strictness.Strict" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m5015equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5017hashCodeimpl(this.value);
        }

        public String toString() {
            return m5018toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m5019unboximpl() {
            return this.value;
        }
    }

    public static final class WordBreak {
        public static final Companion Companion = new Companion(null);
        private static final int Default = m5025constructorimpl(1);
        private static final int Phrase = m5025constructorimpl(2);
        private final int value;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                this();
            }

            /* JADX INFO: renamed from: getDefault-jp8hJ3c, reason: not valid java name */
            public final int m5031getDefaultjp8hJ3c() {
                return WordBreak.Default;
            }

            /* JADX INFO: renamed from: getPhrase-jp8hJ3c, reason: not valid java name */
            public final int m5032getPhrasejp8hJ3c() {
                return WordBreak.Phrase;
            }

            private Companion() {
            }
        }

        private /* synthetic */ WordBreak(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ WordBreak m5024boximpl(int i) {
            return new WordBreak(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m5025constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m5026equalsimpl(int i, Object obj) {
            return (obj instanceof WordBreak) && i == ((WordBreak) obj).m5030unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m5027equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m5028hashCodeimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m5029toStringimpl(int i) {
            if (m5027equalsimpl0(i, Default)) {
                return "WordBreak.None";
            }
            return m5027equalsimpl0(i, Phrase) ? "WordBreak.Phrase" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m5026equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5028hashCodeimpl(this.value);
        }

        public String toString() {
            return m5029toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m5030unboximpl() {
            return this.value;
        }
    }

    static {
        Strategy.Companion companion = Strategy.Companion;
        int iM5012getSimplefcGXIks = companion.m5012getSimplefcGXIks();
        Strictness.Companion companion2 = Strictness.Companion;
        int iM5022getNormalusljTpc = companion2.m5022getNormalusljTpc();
        WordBreak.Companion companion3 = WordBreak.Companion;
        Simple = m4989constructorimpl(iM5012getSimplefcGXIks, iM5022getNormalusljTpc, companion3.m5031getDefaultjp8hJ3c());
        Heading = m4989constructorimpl(companion.m5010getBalancedfcGXIks(), companion2.m5021getLooseusljTpc(), companion3.m5032getPhrasejp8hJ3c());
        Paragraph = m4989constructorimpl(companion.m5011getHighQualityfcGXIks(), companion2.m5023getStrictusljTpc(), companion3.m5031getDefaultjp8hJ3c());
    }

    private /* synthetic */ LineBreak(int i) {
        this.mask = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LineBreak m4987boximpl(int i) {
        return new LineBreak(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m4988constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: copy-gijOMQM, reason: not valid java name */
    public static final int m4990copygijOMQM(int i, int i2, int i3, int i4) {
        return m4989constructorimpl(i2, i3, i4);
    }

    /* JADX INFO: renamed from: copy-gijOMQM$default, reason: not valid java name */
    public static /* synthetic */ int m4991copygijOMQM$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = m4994getStrategyfcGXIks(i);
        }
        if ((i5 & 2) != 0) {
            i3 = m4995getStrictnessusljTpc(i);
        }
        if ((i5 & 4) != 0) {
            i4 = m4996getWordBreakjp8hJ3c(i);
        }
        return m4990copygijOMQM(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4992equalsimpl(int i, Object obj) {
        return (obj instanceof LineBreak) && i == ((LineBreak) obj).m4999unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4993equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: getStrategy-fcGXIks, reason: not valid java name */
    public static final int m4994getStrategyfcGXIks(int i) {
        return Strategy.m5004constructorimpl(LineBreak_androidKt.unpackByte1(i));
    }

    /* JADX INFO: renamed from: getStrictness-usljTpc, reason: not valid java name */
    public static final int m4995getStrictnessusljTpc(int i) {
        return Strictness.m5014constructorimpl(LineBreak_androidKt.unpackByte2(i));
    }

    /* JADX INFO: renamed from: getWordBreak-jp8hJ3c, reason: not valid java name */
    public static final int m4996getWordBreakjp8hJ3c(int i) {
        return WordBreak.m5025constructorimpl(LineBreak_androidKt.unpackByte3(i));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4997hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4998toStringimpl(int i) {
        return "LineBreak(strategy=" + ((Object) Strategy.m5008toStringimpl(m4994getStrategyfcGXIks(i))) + ", strictness=" + ((Object) Strictness.m5018toStringimpl(m4995getStrictnessusljTpc(i))) + ", wordBreak=" + ((Object) WordBreak.m5029toStringimpl(m4996getWordBreakjp8hJ3c(i))) + ')';
    }

    public boolean equals(Object obj) {
        return m4992equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m4997hashCodeimpl(this.mask);
    }

    public String toString() {
        return m4998toStringimpl(this.mask);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4999unboximpl() {
        return this.mask;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m4989constructorimpl(int i, int i2, int i3) {
        return m4988constructorimpl(LineBreak_androidKt.packBytes(i, i2, i3));
    }
}
