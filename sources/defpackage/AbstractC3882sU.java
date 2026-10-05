package defpackage;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.TextToolbar;

/* JADX INFO: renamed from: sU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC3882sU {
    public static /* synthetic */ void a(TextToolbar textToolbar, Rect rect, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3, InterfaceC3588op interfaceC3588op4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMenu");
        }
        textToolbar.showMenu(rect, (i & 2) != 0 ? null : interfaceC3588op, (i & 4) != 0 ? null : interfaceC3588op2, (i & 8) != 0 ? null : interfaceC3588op3, (i & 16) != 0 ? null : interfaceC3588op4);
    }
}
