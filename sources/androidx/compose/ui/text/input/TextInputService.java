package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC4492zt;
import defpackage.FC;
import defpackage.InterfaceC3750qp;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public class TextInputService {
    public static final int $stable = 8;
    private final AtomicReference<TextInputSession> _currentInputSession;
    private final PlatformTextInputService platformTextInputService;

    public TextInputService(PlatformTextInputService platformTextInputService) {
        AbstractC4492zt.h(platformTextInputService, "platformTextInputService");
        this.platformTextInputService = platformTextInputService;
        this._currentInputSession = new AtomicReference<>(null);
    }

    public final TextInputSession getCurrentInputSession$ui_text_release() {
        return this._currentInputSession.get();
    }

    public final void hideSoftwareKeyboard() {
        this.platformTextInputService.hideSoftwareKeyboard();
    }

    public final void showSoftwareKeyboard() {
        if (this._currentInputSession.get() != null) {
            this.platformTextInputService.showSoftwareKeyboard();
        }
    }

    public TextInputSession startInput(TextFieldValue textFieldValue, ImeOptions imeOptions, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        AbstractC4492zt.h(textFieldValue, "value");
        AbstractC4492zt.h(imeOptions, "imeOptions");
        AbstractC4492zt.h(interfaceC3750qp, "onEditCommand");
        AbstractC4492zt.h(interfaceC3750qp2, "onImeActionPerformed");
        this.platformTextInputService.startInput(textFieldValue, imeOptions, interfaceC3750qp, interfaceC3750qp2);
        TextInputSession textInputSession = new TextInputSession(this, this.platformTextInputService);
        this._currentInputSession.set(textInputSession);
        return textInputSession;
    }

    public void stopInput(TextInputSession textInputSession) {
        AbstractC4492zt.h(textInputSession, "session");
        if (FC.a(this._currentInputSession, textInputSession, null)) {
            this.platformTextInputService.stopInput();
        }
    }
}
