package androidx.compose.foundation.text;

import android.view.InputDevice;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.text.input.TextInputSession;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldFocusModifier_androidKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ FocusManager $focusManager;
        final /* synthetic */ TextFieldState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FocusManager focusManager, TextFieldState textFieldState) {
            super(1);
            this.$focusManager = focusManager;
            this.$state = textFieldState;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m821invokeZmokQxo(((KeyEvent) obj).m3928unboximpl());
        }

        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
        public final Boolean m821invokeZmokQxo(android.view.KeyEvent keyEvent) {
            AbstractC4492zt.h(keyEvent, "keyEvent");
            InputDevice device = keyEvent.getDevice();
            boolean zMo2733moveFocus3ESFkO8 = false;
            if (device != null && device.supportsSource(513) && !device.isVirtual() && KeyEventType.m3932equalsimpl0(KeyEvent_androidKt.m3940getTypeZmokQxo(keyEvent), KeyEventType.Companion.m3936getKeyDownCS__XNY())) {
                if (TextFieldFocusModifier_androidKt.m820isKeyCodeYhN2O0w(keyEvent, 19)) {
                    zMo2733moveFocus3ESFkO8 = this.$focusManager.mo2733moveFocus3ESFkO8(FocusDirection.Companion.m2731getUpdhqQ8s());
                } else if (TextFieldFocusModifier_androidKt.m820isKeyCodeYhN2O0w(keyEvent, 20)) {
                    zMo2733moveFocus3ESFkO8 = this.$focusManager.mo2733moveFocus3ESFkO8(FocusDirection.Companion.m2722getDowndhqQ8s());
                } else if (TextFieldFocusModifier_androidKt.m820isKeyCodeYhN2O0w(keyEvent, 21)) {
                    zMo2733moveFocus3ESFkO8 = this.$focusManager.mo2733moveFocus3ESFkO8(FocusDirection.Companion.m2726getLeftdhqQ8s());
                } else if (TextFieldFocusModifier_androidKt.m820isKeyCodeYhN2O0w(keyEvent, 22)) {
                    zMo2733moveFocus3ESFkO8 = this.$focusManager.mo2733moveFocus3ESFkO8(FocusDirection.Companion.m2730getRightdhqQ8s());
                } else if (TextFieldFocusModifier_androidKt.m820isKeyCodeYhN2O0w(keyEvent, 23)) {
                    TextInputSession inputSession = this.$state.getInputSession();
                    if (inputSession != null) {
                        inputSession.showSoftwareKeyboard();
                    }
                    zMo2733moveFocus3ESFkO8 = true;
                }
            }
            return Boolean.valueOf(zMo2733moveFocus3ESFkO8);
        }
    }

    public static final Modifier interceptDPadAndMoveFocus(Modifier modifier, TextFieldState textFieldState, FocusManager focusManager) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(textFieldState, "state");
        AbstractC4492zt.h(focusManager, "focusManager");
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new AnonymousClass1(focusManager, textFieldState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isKeyCode-YhN2O0w, reason: not valid java name */
    public static final boolean m820isKeyCodeYhN2O0w(android.view.KeyEvent keyEvent, int i) {
        return Key_androidKt.m3946getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent)) == i;
    }
}
