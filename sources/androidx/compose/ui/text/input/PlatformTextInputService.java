package androidx.compose.ui.text.input;

import androidx.compose.ui.geometry.Rect;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public interface PlatformTextInputService {
    void hideSoftwareKeyboard();

    void notifyFocusedRect(Rect rect);

    void showSoftwareKeyboard();

    void startInput(TextFieldValue textFieldValue, ImeOptions imeOptions, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2);

    void stopInput();

    void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2);
}
