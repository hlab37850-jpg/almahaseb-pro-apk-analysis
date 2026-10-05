package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextInputSession;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class KeyboardActionRunner implements KeyboardActionScope {
    public FocusManager focusManager;
    private TextInputSession inputSession;
    public KeyboardActions keyboardActions;

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    /* JADX INFO: renamed from: defaultKeyboardAction-KlQnJC8, reason: not valid java name */
    public void mo765defaultKeyboardActionKlQnJC8(int i) {
        ImeAction.Companion companion = ImeAction.Companion;
        if (ImeAction.m4850equalsimpl0(i, companion.m4865getNexteUduSuo())) {
            getFocusManager().mo2733moveFocus3ESFkO8(FocusDirection.Companion.m2727getNextdhqQ8s());
            return;
        }
        if (ImeAction.m4850equalsimpl0(i, companion.m4867getPreviouseUduSuo())) {
            getFocusManager().mo2733moveFocus3ESFkO8(FocusDirection.Companion.m2729getPreviousdhqQ8s());
            return;
        }
        if (!ImeAction.m4850equalsimpl0(i, companion.m4863getDoneeUduSuo())) {
            if (ImeAction.m4850equalsimpl0(i, companion.m4864getGoeUduSuo()) ? true : ImeAction.m4850equalsimpl0(i, companion.m4868getSearcheUduSuo()) ? true : ImeAction.m4850equalsimpl0(i, companion.m4869getSendeUduSuo()) ? true : ImeAction.m4850equalsimpl0(i, companion.m4862getDefaulteUduSuo())) {
                return;
            }
            ImeAction.m4850equalsimpl0(i, companion.m4866getNoneeUduSuo());
        } else {
            TextInputSession textInputSession = this.inputSession;
            if (textInputSession != null) {
                textInputSession.hideSoftwareKeyboard();
            }
        }
    }

    public final FocusManager getFocusManager() {
        FocusManager focusManager = this.focusManager;
        if (focusManager != null) {
            return focusManager;
        }
        AbstractC4492zt.x("focusManager");
        return null;
    }

    public final TextInputSession getInputSession() {
        return this.inputSession;
    }

    public final KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions = this.keyboardActions;
        if (keyboardActions != null) {
            return keyboardActions;
        }
        AbstractC4492zt.x("keyboardActions");
        return null;
    }

    /* JADX INFO: renamed from: runAction-KlQnJC8, reason: not valid java name */
    public final void m766runActionKlQnJC8(int i) {
        InterfaceC3750qp onSend;
        ImeAction.Companion companion = ImeAction.Companion;
        FW fw = null;
        if (ImeAction.m4850equalsimpl0(i, companion.m4863getDoneeUduSuo())) {
            onSend = getKeyboardActions().getOnDone();
        } else if (ImeAction.m4850equalsimpl0(i, companion.m4864getGoeUduSuo())) {
            onSend = getKeyboardActions().getOnGo();
        } else if (ImeAction.m4850equalsimpl0(i, companion.m4865getNexteUduSuo())) {
            onSend = getKeyboardActions().getOnNext();
        } else if (ImeAction.m4850equalsimpl0(i, companion.m4867getPreviouseUduSuo())) {
            onSend = getKeyboardActions().getOnPrevious();
        } else if (ImeAction.m4850equalsimpl0(i, companion.m4868getSearcheUduSuo())) {
            onSend = getKeyboardActions().getOnSearch();
        } else if (ImeAction.m4850equalsimpl0(i, companion.m4869getSendeUduSuo())) {
            onSend = getKeyboardActions().getOnSend();
        } else {
            if (!(ImeAction.m4850equalsimpl0(i, companion.m4862getDefaulteUduSuo()) ? true : ImeAction.m4850equalsimpl0(i, companion.m4866getNoneeUduSuo()))) {
                throw new IllegalStateException("invalid ImeAction");
            }
            onSend = null;
        }
        if (onSend != null) {
            onSend.invoke(this);
            fw = FW.a;
        }
        if (fw == null) {
            mo765defaultKeyboardActionKlQnJC8(i);
        }
    }

    public final void setFocusManager(FocusManager focusManager) {
        AbstractC4492zt.h(focusManager, "<set-?>");
        this.focusManager = focusManager;
    }

    public final void setInputSession(TextInputSession textInputSession) {
        this.inputSession = textInputSession;
    }

    public final void setKeyboardActions(KeyboardActions keyboardActions) {
        AbstractC4492zt.h(keyboardActions, "<set-?>");
        this.keyboardActions = keyboardActions;
    }
}
