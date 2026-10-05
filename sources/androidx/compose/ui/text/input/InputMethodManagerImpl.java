package androidx.compose.ui.text.input;

import android.view.View;
import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.platform.coreshims.SoftwareKeyboardControllerCompat;
import defpackage.AbstractC3756qv;
import defpackage.AbstractC4492zt;
import defpackage.EnumC4322xv;
import defpackage.InterfaceC3430mv;

/* JADX INFO: loaded from: classes.dex */
public final class InputMethodManagerImpl implements InputMethodManager {
    private final InterfaceC3430mv imm$delegate;
    private final SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat;
    private final View view;

    public InputMethodManagerImpl(View view) {
        AbstractC4492zt.h(view, "view");
        this.view = view;
        this.imm$delegate = AbstractC3756qv.b(EnumC4322xv.NONE, new InputMethodManagerImpl$imm$2(this));
        this.softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
    }

    private final android.view.inputmethod.InputMethodManager getImm() {
        return (android.view.inputmethod.InputMethodManager) this.imm$delegate.getValue();
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void hideSoftInput() {
        this.softwareKeyboardControllerCompat.hide();
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void restartInput() {
        getImm().restartInput(this.view);
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void showSoftInput() {
        this.softwareKeyboardControllerCompat.show();
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void updateExtractedText(int i, ExtractedText extractedText) {
        AbstractC4492zt.h(extractedText, "extractedText");
        getImm().updateExtractedText(this.view, i, extractedText);
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void updateSelection(int i, int i2, int i3, int i4) {
        getImm().updateSelection(this.view, i, i2, i3, i4);
    }
}
