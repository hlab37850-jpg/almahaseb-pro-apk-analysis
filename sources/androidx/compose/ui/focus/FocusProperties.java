package androidx.compose.ui.focus;

import androidx.compose.ui.ExperimentalComposeUiApi;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public interface FocusProperties {
    boolean getCanFocus();

    FocusRequester getDown();

    FocusRequester getEnd();

    @ExperimentalComposeUiApi
    InterfaceC3750qp getEnter();

    @ExperimentalComposeUiApi
    InterfaceC3750qp getExit();

    FocusRequester getLeft();

    FocusRequester getNext();

    FocusRequester getPrevious();

    FocusRequester getRight();

    FocusRequester getStart();

    FocusRequester getUp();

    void setCanFocus(boolean z);

    void setDown(FocusRequester focusRequester);

    void setEnd(FocusRequester focusRequester);

    @ExperimentalComposeUiApi
    void setEnter(InterfaceC3750qp interfaceC3750qp);

    @ExperimentalComposeUiApi
    void setExit(InterfaceC3750qp interfaceC3750qp);

    void setLeft(FocusRequester focusRequester);

    void setNext(FocusRequester focusRequester);

    void setPrevious(FocusRequester focusRequester);

    void setRight(FocusRequester focusRequester);

    void setStart(FocusRequester focusRequester);

    void setUp(FocusRequester focusRequester);

    /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusProperties$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static FocusRequester a(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        public static FocusRequester b(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        public static InterfaceC3750qp c(FocusProperties focusProperties) {
            return FocusProperties$enter$1.INSTANCE;
        }

        public static InterfaceC3750qp d(FocusProperties focusProperties) {
            return FocusProperties$exit$1.INSTANCE;
        }

        public static FocusRequester e(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        public static FocusRequester f(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        public static FocusRequester g(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        public static FocusRequester h(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        public static FocusRequester i(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        public static FocusRequester j(FocusProperties focusProperties) {
            return FocusRequester.Companion.getDefault();
        }

        public static void k(FocusProperties focusProperties, FocusRequester focusRequester) {
            AbstractC4492zt.h(focusRequester, "<anonymous parameter 0>");
        }

        public static void l(FocusProperties focusProperties, FocusRequester focusRequester) {
            AbstractC4492zt.h(focusRequester, "<anonymous parameter 0>");
        }

        public static void m(FocusProperties focusProperties, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "<anonymous parameter 0>");
        }

        public static void n(FocusProperties focusProperties, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "<anonymous parameter 0>");
        }

        public static void o(FocusProperties focusProperties, FocusRequester focusRequester) {
            AbstractC4492zt.h(focusRequester, "<anonymous parameter 0>");
        }

        public static void p(FocusProperties focusProperties, FocusRequester focusRequester) {
            AbstractC4492zt.h(focusRequester, "<anonymous parameter 0>");
        }

        public static void q(FocusProperties focusProperties, FocusRequester focusRequester) {
            AbstractC4492zt.h(focusRequester, "<anonymous parameter 0>");
        }

        public static void r(FocusProperties focusProperties, FocusRequester focusRequester) {
            AbstractC4492zt.h(focusRequester, "<anonymous parameter 0>");
        }

        public static void s(FocusProperties focusProperties, FocusRequester focusRequester) {
            AbstractC4492zt.h(focusRequester, "<anonymous parameter 0>");
        }

        public static void t(FocusProperties focusProperties, FocusRequester focusRequester) {
            AbstractC4492zt.h(focusRequester, "<anonymous parameter 0>");
        }

        public static /* synthetic */ void u() {
        }

        public static /* synthetic */ void v() {
        }
    }
}
