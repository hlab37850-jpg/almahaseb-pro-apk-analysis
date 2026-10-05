package androidx.compose.ui.input.key;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class KeyEvent_androidKt {
    /* JADX INFO: renamed from: getKey-ZmokQxo, reason: not valid java name */
    public static final long m3939getKeyZmokQxo(android.view.KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, "$this$key");
        return Key_androidKt.Key(keyEvent.getKeyCode());
    }

    /* JADX INFO: renamed from: getType-ZmokQxo, reason: not valid java name */
    public static final int m3940getTypeZmokQxo(android.view.KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, "$this$type");
        int action = keyEvent.getAction();
        if (action != 0) {
            return action != 1 ? KeyEventType.Companion.m3938getUnknownCS__XNY() : KeyEventType.Companion.m3937getKeyUpCS__XNY();
        }
        return KeyEventType.Companion.m3936getKeyDownCS__XNY();
    }

    /* JADX INFO: renamed from: getUtf16CodePoint-ZmokQxo, reason: not valid java name */
    public static final int m3941getUtf16CodePointZmokQxo(android.view.KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, "$this$utf16CodePoint");
        return keyEvent.getUnicodeChar();
    }

    /* JADX INFO: renamed from: isAltPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m3942isAltPressedZmokQxo(android.view.KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, "$this$isAltPressed");
        return keyEvent.isAltPressed();
    }

    /* JADX INFO: renamed from: isCtrlPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m3943isCtrlPressedZmokQxo(android.view.KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, "$this$isCtrlPressed");
        return keyEvent.isCtrlPressed();
    }

    /* JADX INFO: renamed from: isMetaPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m3944isMetaPressedZmokQxo(android.view.KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, "$this$isMetaPressed");
        return keyEvent.isMetaPressed();
    }

    /* JADX INFO: renamed from: isShiftPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m3945isShiftPressedZmokQxo(android.view.KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, "$this$isShiftPressed");
        return keyEvent.isShiftPressed();
    }
}
