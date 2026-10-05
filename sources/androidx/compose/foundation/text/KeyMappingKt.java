package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC3870sI;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    static {
        final KeyMapping keyMappingCommonKeyMapping = commonKeyMapping(new AbstractC3870sI() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Override // defpackage.InterfaceC1029Wu
            public Object get(Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.m3943isCtrlPressedZmokQxo(((KeyEvent) obj).m3928unboximpl()));
            }
        });
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo764mapZmokQxo(android.view.KeyEvent keyEvent) {
                AbstractC4492zt.h(keyEvent, NotificationCompat.CATEGORY_EVENT);
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.m3945isShiftPressedZmokQxo(keyEvent) && KeyEvent_androidKt.m3943isCtrlPressedZmokQxo(keyEvent)) {
                    long jM3939getKeyZmokQxo = KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m788getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m789getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m790getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m787getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyEvent_androidKt.m3943isCtrlPressedZmokQxo(keyEvent)) {
                    long jM3939getKeyZmokQxo2 = KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m788getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.LEFT_WORD;
                    } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m789getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.RIGHT_WORD;
                    } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m790getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m787getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m792getHEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m786getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m782getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m781getBackslashEK5gGoQ())) {
                        keyCommand = KeyCommand.DESELECT;
                    }
                } else if (KeyEvent_androidKt.m3945isShiftPressedZmokQxo(keyEvent)) {
                    long jM3939getKeyZmokQxo3 = KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m795getMoveHomeEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_LEFT;
                    } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m794getMoveEndEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                    }
                } else if (KeyEvent_androidKt.m3942isAltPressedZmokQxo(keyEvent)) {
                    long jM3939getKeyZmokQxo4 = KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys4 = MappedKeys.INSTANCE;
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo4, mappedKeys4.m782getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                    } else if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo4, mappedKeys4.m786getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_TO_LINE_END;
                    }
                }
                return keyCommand == null ? keyMappingCommonKeyMapping.mo764mapZmokQxo(keyEvent) : keyCommand;
            }
        };
    }

    public static final KeyMapping commonKeyMapping(final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "shortcutModifier");
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt.commonKeyMapping.1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* JADX INFO: renamed from: map-ZmokQxo */
            public KeyCommand mo764mapZmokQxo(android.view.KeyEvent keyEvent) {
                AbstractC4492zt.h(keyEvent, NotificationCompat.CATEGORY_EVENT);
                if (((Boolean) interfaceC3750qp.invoke(KeyEvent.m3922boximpl(keyEvent))).booleanValue() && KeyEvent_androidKt.m3945isShiftPressedZmokQxo(keyEvent)) {
                    if (Key.m3631equalsimpl0(KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent), MappedKeys.INSTANCE.m803getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (((Boolean) interfaceC3750qp.invoke(KeyEvent.m3922boximpl(keyEvent))).booleanValue()) {
                    long jM3939getKeyZmokQxo = KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m783getCEK5gGoQ()) ? true : Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m793getInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m800getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m801getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m780getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m802getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo, mappedKeys.m803getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyEvent_androidKt.m3943isCtrlPressedZmokQxo(keyEvent)) {
                    return null;
                }
                if (KeyEvent_androidKt.m3945isShiftPressedZmokQxo(keyEvent)) {
                    long jM3939getKeyZmokQxo2 = KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m788getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m789getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m790getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m787getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m797getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m796getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m795getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m794getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo2, mappedKeys2.m793getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long jM3939getKeyZmokQxo3 = KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent);
                MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m788getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m789getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m790getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m787getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m797getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m796getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m795getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m794getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m791getEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m782getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m786getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m798getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m785getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m784getCopyEK5gGoQ())) {
                    return KeyCommand.COPY;
                }
                if (Key.m3631equalsimpl0(jM3939getKeyZmokQxo3, mappedKeys3.m799getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }
}
