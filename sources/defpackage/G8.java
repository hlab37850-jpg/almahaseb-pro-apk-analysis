package defpackage;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.ui.geometry.Rect;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class G8 {
    public static /* synthetic */ Object a(BringIntoViewRequester bringIntoViewRequester, Rect rect, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bringIntoView");
        }
        if ((i & 1) != 0) {
            rect = null;
        }
        return bringIntoViewRequester.bringIntoView(rect, interfaceC0793Of);
    }
}
