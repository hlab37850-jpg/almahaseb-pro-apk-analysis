package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.semantics.Role;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import defpackage.O8;
import defpackage.RG;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode {
    private boolean enabled;
    private final InteractionData interactionData;
    private MutableInteractionSource interactionSource;
    private InterfaceC3588op onClick;
    private String onClickLabel;
    private Role role;

    @StabilityInferred(parameters = 0)
    public static final class InteractionData {
        public static final int $stable = 8;
        private PressInteraction.Press pressInteraction;
        private final Map<Key, PressInteraction.Press> currentKeyPressInteractions = new LinkedHashMap();
        private long centreOffset = Offset.Companion.m2814getZeroF1C5BW0();

        /* JADX INFO: renamed from: getCentreOffset-F1C5BW0, reason: not valid java name */
        public final long m153getCentreOffsetF1C5BW0() {
            return this.centreOffset;
        }

        public final Map<Key, PressInteraction.Press> getCurrentKeyPressInteractions() {
            return this.currentKeyPressInteractions;
        }

        public final PressInteraction.Press getPressInteraction() {
            return this.pressInteraction;
        }

        /* JADX INFO: renamed from: setCentreOffset-k-4lQ0M, reason: not valid java name */
        public final void m154setCentreOffsetk4lQ0M(long j) {
            this.centreOffset = j;
        }

        public final void setPressInteraction(PressInteraction.Press press) {
            this.pressInteraction = press;
        }
    }

    public /* synthetic */ AbstractClickableNode(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, AbstractC0419Di abstractC0419Di) {
        this(mutableInteractionSource, z, str, role, interfaceC3588op);
    }

    /* JADX INFO: renamed from: updateCommon-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ void m148updateCommonXHw0xAI$default(AbstractClickableNode abstractClickableNode, MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCommon-XHw0xAI");
        }
        if ((i & 8) != 0) {
            role = null;
        }
        abstractClickableNode.m152updateCommonXHw0xAI(mutableInteractionSource, z, str, role, interfaceC3588op);
    }

    public final void disposeInteractionSource() {
        PressInteraction.Press pressInteraction = this.interactionData.getPressInteraction();
        if (pressInteraction != null) {
            this.interactionSource.tryEmit(new PressInteraction.Cancel(pressInteraction));
        }
        Iterator<T> it = this.interactionData.getCurrentKeyPressInteractions().values().iterator();
        while (it.hasNext()) {
            this.interactionSource.tryEmit(new PressInteraction.Cancel((PressInteraction.Press) it.next()));
        }
        this.interactionData.setPressInteraction(null);
        this.interactionData.getCurrentKeyPressInteractions().clear();
    }

    public abstract AbstractClickablePointerInputNode getClickablePointerInputNode();

    public abstract ClickableSemanticsNode getClickableSemanticsNode();

    public final InteractionData getInteractionData() {
        return this.interactionData;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return RG.a(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        getClickablePointerInputNode().onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ void onDensityChange() {
        RG.b(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        disposeInteractionSource();
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    public boolean mo149onKeyEventZmokQxo(KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (this.enabled && Clickable_androidKt.m215isPressZmokQxo(keyEvent)) {
            if (this.interactionData.getCurrentKeyPressInteractions().containsKey(Key.m3628boximpl(KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent)))) {
                return false;
            }
            PressInteraction.Press press = new PressInteraction.Press(this.interactionData.m153getCentreOffsetF1C5BW0(), null);
            this.interactionData.getCurrentKeyPressInteractions().put(Key.m3628boximpl(KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent)), press);
            O8.d(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(this, press, null), 3, null);
        } else {
            if (!this.enabled || !Clickable_androidKt.m213isClickZmokQxo(keyEvent)) {
                return false;
            }
            PressInteraction.Press pressRemove = this.interactionData.getCurrentKeyPressInteractions().remove(Key.m3628boximpl(KeyEvent_androidKt.m3939getKeyZmokQxo(keyEvent)));
            if (pressRemove != null) {
                O8.d(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$2$1(this, pressRemove, null), 3, null);
            }
            this.onClick.invoke();
        }
        return true;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void mo150onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        AbstractC4492zt.h(pointerEvent, "pointerEvent");
        AbstractC4492zt.h(pointerEventPass, "pass");
        getClickablePointerInputNode().mo150onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    public boolean mo151onPreKeyEventZmokQxo(KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, NotificationCompat.CATEGORY_EVENT);
        return false;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ void onViewConfigurationChange() {
        RG.c(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return RG.d(this);
    }

    /* JADX INFO: renamed from: updateCommon-XHw0xAI, reason: not valid java name */
    public final void m152updateCommonXHw0xAI(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        if (!AbstractC4492zt.d(this.interactionSource, mutableInteractionSource)) {
            disposeInteractionSource();
            this.interactionSource = mutableInteractionSource;
        }
        if (this.enabled != z) {
            if (!z) {
                disposeInteractionSource();
            }
            this.enabled = z;
        }
        this.onClickLabel = str;
        this.role = role;
        this.onClick = interfaceC3588op;
    }

    private AbstractClickableNode(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(mutableInteractionSource, "interactionSource");
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        this.interactionSource = mutableInteractionSource;
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role;
        this.onClick = interfaceC3588op;
        this.interactionData = new InteractionData();
    }
}
