package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class KeyEventHelpers_androidKt {
    /* JADX INFO: renamed from: cancelsTextSelection-ZmokQxo, reason: not valid java name */
    public static final boolean m763cancelsTextSelectionZmokQxo(KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, "$this$cancelsTextSelection");
        return keyEvent.getKeyCode() == 4 && KeyEventType.m3932equalsimpl0(KeyEvent_androidKt.m3940getTypeZmokQxo(keyEvent), KeyEventType.Companion.m3937getKeyUpCS__XNY());
    }

    public static final void showCharacterPalette() {
    }
}
