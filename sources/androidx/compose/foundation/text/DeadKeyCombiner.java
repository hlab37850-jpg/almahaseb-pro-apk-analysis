package androidx.compose.foundation.text;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class DeadKeyCombiner {
    private Integer deadKeyCode;

    /* JADX INFO: renamed from: consume-ZmokQxo, reason: not valid java name */
    public final Integer m762consumeZmokQxo(KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, NotificationCompat.CATEGORY_EVENT);
        int iM3941getUtf16CodePointZmokQxo = KeyEvent_androidKt.m3941getUtf16CodePointZmokQxo(keyEvent);
        if ((Integer.MIN_VALUE & iM3941getUtf16CodePointZmokQxo) != 0) {
            this.deadKeyCode = Integer.valueOf(iM3941getUtf16CodePointZmokQxo & Integer.MAX_VALUE);
            return null;
        }
        Integer num = this.deadKeyCode;
        if (num == null) {
            return Integer.valueOf(iM3941getUtf16CodePointZmokQxo);
        }
        this.deadKeyCode = null;
        Integer numValueOf = Integer.valueOf(KeyCharacterMap.getDeadChar(num.intValue(), iM3941getUtf16CodePointZmokQxo));
        Integer num2 = numValueOf.intValue() != 0 ? numValueOf : null;
        return num2 == null ? Integer.valueOf(iM3941getUtf16CodePointZmokQxo) : num2;
    }
}
