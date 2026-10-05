package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public interface TextToolbar {

    public static final class DefaultImpls {
    }

    TextToolbarStatus getStatus();

    void hide();

    void showMenu(Rect rect, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3, InterfaceC3588op interfaceC3588op4);
}
