package androidx.compose.foundation.text;

import android.view.KeyEvent;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldKeyInput_androidKt {
    /* JADX INFO: renamed from: isTypedEvent-ZmokQxo, reason: not valid java name */
    public static final boolean m827isTypedEventZmokQxo(KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, "$this$isTypedEvent");
        return keyEvent.getAction() == 0 && !Character.isISOControl(keyEvent.getUnicodeChar());
    }
}
