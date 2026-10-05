package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.geometry.Rect;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public interface BringIntoViewResponder {
    @ExperimentalFoundationApi
    Object bringChildIntoView(InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of);

    @ExperimentalFoundationApi
    Rect calculateRectForParent(Rect rect);
}
