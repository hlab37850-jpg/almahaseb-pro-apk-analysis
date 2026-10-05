package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ InterfaceC3750qp $afterTextChanged;
    final /* synthetic */ InterfaceC0578Hp $beforeTextChanged;
    final /* synthetic */ InterfaceC0578Hp $onTextChanged;

    public TextViewKt$addTextChangedListener$textWatcher$1(InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp, InterfaceC0578Hp interfaceC0578Hp2) {
        this.$afterTextChanged = interfaceC3750qp;
        this.$beforeTextChanged = interfaceC0578Hp;
        this.$onTextChanged = interfaceC0578Hp2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
