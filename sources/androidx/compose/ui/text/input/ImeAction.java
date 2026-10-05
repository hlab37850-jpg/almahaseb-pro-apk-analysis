package androidx.compose.ui.text.input;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
public final class ImeAction {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Default = m4848constructorimpl(1);
    private static final int None = m4848constructorimpl(0);
    private static final int Go = m4848constructorimpl(2);
    private static final int Search = m4848constructorimpl(3);
    private static final int Send = m4848constructorimpl(4);
    private static final int Previous = m4848constructorimpl(5);
    private static final int Next = m4848constructorimpl(6);
    private static final int Done = m4848constructorimpl(7);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        @Stable
        /* JADX INFO: renamed from: getDefault-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4854getDefaulteUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getDone-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4855getDoneeUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getGo-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4856getGoeUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getNext-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4857getNexteUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getNone-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4858getNoneeUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getPrevious-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4859getPreviouseUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getSearch-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4860getSearcheUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getSend-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4861getSendeUduSuo$annotations() {
        }

        /* JADX INFO: renamed from: getDefault-eUduSuo, reason: not valid java name */
        public final int m4862getDefaulteUduSuo() {
            return ImeAction.Default;
        }

        /* JADX INFO: renamed from: getDone-eUduSuo, reason: not valid java name */
        public final int m4863getDoneeUduSuo() {
            return ImeAction.Done;
        }

        /* JADX INFO: renamed from: getGo-eUduSuo, reason: not valid java name */
        public final int m4864getGoeUduSuo() {
            return ImeAction.Go;
        }

        /* JADX INFO: renamed from: getNext-eUduSuo, reason: not valid java name */
        public final int m4865getNexteUduSuo() {
            return ImeAction.Next;
        }

        /* JADX INFO: renamed from: getNone-eUduSuo, reason: not valid java name */
        public final int m4866getNoneeUduSuo() {
            return ImeAction.None;
        }

        /* JADX INFO: renamed from: getPrevious-eUduSuo, reason: not valid java name */
        public final int m4867getPreviouseUduSuo() {
            return ImeAction.Previous;
        }

        /* JADX INFO: renamed from: getSearch-eUduSuo, reason: not valid java name */
        public final int m4868getSearcheUduSuo() {
            return ImeAction.Search;
        }

        /* JADX INFO: renamed from: getSend-eUduSuo, reason: not valid java name */
        public final int m4869getSendeUduSuo() {
            return ImeAction.Send;
        }

        private Companion() {
        }
    }

    private /* synthetic */ ImeAction(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ImeAction m4847boximpl(int i) {
        return new ImeAction(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m4848constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4849equalsimpl(int i, Object obj) {
        return (obj instanceof ImeAction) && i == ((ImeAction) obj).m4853unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4850equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4851hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4852toStringimpl(int i) {
        if (m4850equalsimpl0(i, None)) {
            return "None";
        }
        if (m4850equalsimpl0(i, Default)) {
            return "Default";
        }
        if (m4850equalsimpl0(i, Go)) {
            return "Go";
        }
        if (m4850equalsimpl0(i, Search)) {
            return "Search";
        }
        if (m4850equalsimpl0(i, Send)) {
            return "Send";
        }
        if (m4850equalsimpl0(i, Previous)) {
            return "Previous";
        }
        if (m4850equalsimpl0(i, Next)) {
            return "Next";
        }
        return m4850equalsimpl0(i, Done) ? "Done" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m4849equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4851hashCodeimpl(this.value);
    }

    public String toString() {
        return m4852toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4853unboximpl() {
        return this.value;
    }
}
