package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class Clickable_androidKt {
    private static final long TapIndicationDelay = ViewConfiguration.getTapTimeout();

    public static final long getTapIndicationDelay() {
        return TapIndicationDelay;
    }

    /* JADX INFO: renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m213isClickZmokQxo(KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, "$this$isClick");
        return KeyEventType.m3932equalsimpl0(KeyEvent_androidKt.m3940getTypeZmokQxo(keyEvent), KeyEventType.Companion.m3937getKeyUpCS__XNY()) && m214isEnterZmokQxo(keyEvent);
    }

    public static final boolean isComposeRootInScrollableContainer(CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode) {
        AbstractC4492zt.h(compositionLocalConsumerModifierNode, "<this>");
        return isInScrollableViewGroup((View) CompositionLocalConsumerModifierNodeKt.currentValueOf(compositionLocalConsumerModifierNode, AndroidCompositionLocals_androidKt.getLocalView()));
    }

    /* JADX INFO: renamed from: isEnter-ZmokQxo, reason: not valid java name */
    private static final boolean m214isEnterZmokQxo(KeyEvent keyEvent) {
        int iM3946getNativeKeyCodeYVgTNJs = Key_androidKt.m3946getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent));
        return iM3946getNativeKeyCodeYVgTNJs == 23 || iM3946getNativeKeyCodeYVgTNJs == 66 || iM3946getNativeKeyCodeYVgTNJs == 160;
    }

    private static final boolean isInScrollableViewGroup(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = viewGroup.getParent();
        }
        return false;
    }

    /* JADX INFO: renamed from: isPress-ZmokQxo, reason: not valid java name */
    public static final boolean m215isPressZmokQxo(KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, "$this$isPress");
        return KeyEventType.m3932equalsimpl0(KeyEvent_androidKt.m3940getTypeZmokQxo(keyEvent), KeyEventType.Companion.m3936getKeyDownCS__XNY()) && m214isEnterZmokQxo(keyEvent);
    }
}
