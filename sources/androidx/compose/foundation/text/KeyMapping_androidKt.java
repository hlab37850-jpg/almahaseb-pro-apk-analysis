package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class KeyMapping_androidKt {
    private static final KeyMapping platformDefaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMapping_androidKt$platformDefaultKeyMapping$1
        @Override // androidx.compose.foundation.text.KeyMapping
        /* JADX INFO: renamed from: map-ZmokQxo */
        public KeyCommand mo764mapZmokQxo(KeyEvent keyEvent) {
            AbstractC4492zt.h(keyEvent, NotificationCompat.CATEGORY_EVENT);
            KeyCommand keyCommand = null;
            if (KeyEvent_androidKt.m3945isShiftPressedZmokQxo(keyEvent) && KeyEvent_androidKt.m3942isAltPressedZmokQxo(keyEvent)) {
                long jM3939getKeyZmokQxo = KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent);
                MappedKeys mappedKeys = MappedKeys.INSTANCE;
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m788getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_LEFT;
                } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m789getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m790getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_HOME;
                } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m787getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_END;
                }
            } else if (KeyEvent_androidKt.m3942isAltPressedZmokQxo(keyEvent)) {
                long jM3939getKeyZmokQxo2 = KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent);
                MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m788getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_LEFT;
                } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m789getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_RIGHT;
                } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m790getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.HOME;
                } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m787getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.END;
                }
            }
            return keyCommand == null ? KeyMappingKt.getDefaultKeyMapping().mo764mapZmokQxo(keyEvent) : keyCommand;
        }
    };

    public static final KeyMapping getPlatformDefaultKeyMapping() {
        return platformDefaultKeyMapping;
    }
}
