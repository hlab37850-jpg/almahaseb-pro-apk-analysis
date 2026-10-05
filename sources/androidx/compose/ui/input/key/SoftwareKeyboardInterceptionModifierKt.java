package androidx.compose.ui.input.key;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SoftwareKeyboardInterceptionModifierKt {
    @ExperimentalComposeUiApi
    public static final Modifier onInterceptKeyBeforeSoftKeyboard(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onInterceptKeyBeforeSoftKeyboard");
        return modifier.then(new SoftKeyboardInterceptionElement(interfaceC3750qp, null));
    }

    @ExperimentalComposeUiApi
    public static final Modifier onPreInterceptKeyBeforeSoftKeyboard(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onPreInterceptKeyBeforeSoftKeyboard");
        return modifier.then(new SoftKeyboardInterceptionElement(null, interfaceC3750qp));
    }
}
