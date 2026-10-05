package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1805bc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import defpackage.KJ;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldKeyInput {
    private final boolean editable;
    private final int imeAction;
    private final DeadKeyCombiner keyCombiner;
    private final KeyMapping keyMapping;
    private final OffsetMapping offsetMapping;
    private final InterfaceC3750qp onValueChange;
    private final TextPreparedSelectionState preparedSelectionState;
    private final TextFieldSelectionManager selectionManager;
    private final boolean singleLine;
    private final TextFieldState state;
    private final UndoManager undoManager;
    private final TextFieldValue value;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(TextFieldValue textFieldValue) {
            AbstractC4492zt.h(textFieldValue, "it");
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((TextFieldValue) obj);
            return FW.a;
        }
    }

    public /* synthetic */ TextFieldKeyInput(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z, boolean z2, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner deadKeyCombiner, KeyMapping keyMapping, InterfaceC3750qp interfaceC3750qp, int i, AbstractC0419Di abstractC0419Di) {
        this(textFieldState, textFieldSelectionManager, textFieldValue, z, z2, textPreparedSelectionState, offsetMapping, undoManager, deadKeyCombiner, keyMapping, interfaceC3750qp, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void apply(List<? extends EditCommand> list) {
        EditProcessor processor = this.state.getProcessor();
        List<? extends EditCommand> listF0 = AbstractC3240kc.F0(list);
        listF0.add(0, new FinishComposingTextCommand());
        this.onValueChange.invoke(processor.apply(listF0));
    }

    private final void commandExecutionContext(InterfaceC3750qp interfaceC3750qp) {
        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(this.value, this.offsetMapping, this.state.getLayoutResult(), this.preparedSelectionState);
        interfaceC3750qp.invoke(textFieldPreparedSelection);
        if (TextRange.m4698equalsimpl0(textFieldPreparedSelection.m881getSelectiond9O1mEE(), this.value.m4922getSelectiond9O1mEE()) && AbstractC4492zt.d(textFieldPreparedSelection.getAnnotatedString(), this.value.getAnnotatedString())) {
            return;
        }
        this.onValueChange.invoke(textFieldPreparedSelection.getValue());
    }

    /* JADX INFO: renamed from: typedCommand-ZmokQxo, reason: not valid java name */
    private final CommitTextCommand m822typedCommandZmokQxo(KeyEvent keyEvent) {
        Integer numM762consumeZmokQxo;
        if (!TextFieldKeyInput_androidKt.m827isTypedEventZmokQxo(keyEvent) || (numM762consumeZmokQxo = this.keyCombiner.m762consumeZmokQxo(keyEvent)) == null) {
            return null;
        }
        String string = StringHelpers_jvmKt.appendCodePointX(new StringBuilder(), numM762consumeZmokQxo.intValue()).toString();
        AbstractC4492zt.g(string, "StringBuilder().appendCo…ntX(codePoint).toString()");
        return new CommitTextCommand(string, 1);
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final TextPreparedSelectionState getPreparedSelectionState() {
        return this.preparedSelectionState;
    }

    public final TextFieldSelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final TextFieldState getState() {
        return this.state;
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    public final TextFieldValue getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: process-ZmokQxo, reason: not valid java name */
    public final boolean m823processZmokQxo(KeyEvent keyEvent) {
        KeyCommand keyCommandMo764mapZmokQxo;
        AbstractC4492zt.h(keyEvent, NotificationCompat.CATEGORY_EVENT);
        CommitTextCommand commitTextCommandM822typedCommandZmokQxo = m822typedCommandZmokQxo(keyEvent);
        if (commitTextCommandM822typedCommandZmokQxo != null) {
            if (!this.editable) {
                return false;
            }
            apply(commitTextCommandM822typedCommandZmokQxo);
            this.preparedSelectionState.resetCachedX();
            return true;
        }
        if (!KeyEventType.m3932equalsimpl0(KeyEvent_androidKt.m3940getTypeZmokQxo(keyEvent), KeyEventType.Companion.m3936getKeyDownCS__XNY()) || (keyCommandMo764mapZmokQxo = this.keyMapping.mo764mapZmokQxo(keyEvent)) == null || (keyCommandMo764mapZmokQxo.getEditsText() && !this.editable)) {
            return false;
        }
        KJ kj = new KJ();
        kj.a = true;
        commandExecutionContext(new TextFieldKeyInput$process$2(keyCommandMo764mapZmokQxo, this, kj));
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
        return kj.a;
    }

    private TextFieldKeyInput(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z, boolean z2, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner deadKeyCombiner, KeyMapping keyMapping, InterfaceC3750qp interfaceC3750qp, int i) {
        AbstractC4492zt.h(textFieldState, "state");
        AbstractC4492zt.h(textFieldSelectionManager, "selectionManager");
        AbstractC4492zt.h(textFieldValue, "value");
        AbstractC4492zt.h(textPreparedSelectionState, "preparedSelectionState");
        AbstractC4492zt.h(offsetMapping, "offsetMapping");
        AbstractC4492zt.h(deadKeyCombiner, "keyCombiner");
        AbstractC4492zt.h(keyMapping, "keyMapping");
        AbstractC4492zt.h(interfaceC3750qp, "onValueChange");
        this.state = textFieldState;
        this.selectionManager = textFieldSelectionManager;
        this.value = textFieldValue;
        this.editable = z;
        this.singleLine = z2;
        this.preparedSelectionState = textPreparedSelectionState;
        this.offsetMapping = offsetMapping;
        this.undoManager = undoManager;
        this.keyCombiner = deadKeyCombiner;
        this.keyMapping = keyMapping;
        this.onValueChange = interfaceC3750qp;
        this.imeAction = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void apply(EditCommand editCommand) {
        apply(AbstractC1805bc.e(editCommand));
    }

    public /* synthetic */ TextFieldKeyInput(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z, boolean z2, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner deadKeyCombiner, KeyMapping keyMapping, InterfaceC3750qp interfaceC3750qp, int i, int i2, AbstractC0419Di abstractC0419Di) {
        this(textFieldState, textFieldSelectionManager, (i2 & 4) != 0 ? new TextFieldValue((String) null, 0L, (TextRange) null, 7, (AbstractC0419Di) null) : textFieldValue, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? false : z2, textPreparedSelectionState, (i2 & 64) != 0 ? OffsetMapping.Companion.getIdentity() : offsetMapping, (i2 & 128) != 0 ? null : undoManager, deadKeyCombiner, (i2 & 512) != 0 ? KeyMapping_androidKt.getPlatformDefaultKeyMapping() : keyMapping, (i2 & 1024) != 0 ? AnonymousClass1.INSTANCE : interfaceC3750qp, i, null);
    }
}
