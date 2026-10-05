package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.QJ;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class EditProcessor {
    public static final int $stable = 8;
    private TextFieldValue mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.Companion.m4710getZerod9O1mEE(), (TextRange) null, (AbstractC0419Di) null);
    private EditingBuffer mBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.m4922getSelectiond9O1mEE(), (AbstractC0419Di) null);

    private final String generateBatchErrorMessage(List<? extends EditCommand> list, EditCommand editCommand) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while applying EditCommand batch to buffer (length=" + this.mBuffer.getLength$ui_text_release() + ", composition=" + this.mBuffer.m4844getCompositionMzsxiRA$ui_text_release() + ", selection=" + ((Object) TextRange.m4708toStringimpl(this.mBuffer.m4845getSelectiond9O1mEE$ui_text_release())) + "):");
        AbstractC4492zt.g(sb, "append(value)");
        sb.append('\n');
        AbstractC4492zt.g(sb, "append('\\n')");
        AbstractC3240kc.g0(list, sb, (124 & 2) != 0 ? ", " : StringUtilities.LF, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new EditProcessor$generateBatchErrorMessage$1$1(editCommand, this));
        String string = sb.toString();
        AbstractC4492zt.g(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toStringForLog(EditCommand editCommand) {
        if (editCommand instanceof CommitTextCommand) {
            StringBuilder sb = new StringBuilder();
            sb.append("CommitTextCommand(text.length=");
            CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
            sb.append(commitTextCommand.getText().length());
            sb.append(", newCursorPosition=");
            sb.append(commitTextCommand.getNewCursorPosition());
            sb.append(')');
            return sb.toString();
        }
        if (editCommand instanceof SetComposingTextCommand) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SetComposingTextCommand(text.length=");
            SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
            sb2.append(setComposingTextCommand.getText().length());
            sb2.append(", newCursorPosition=");
            sb2.append(setComposingTextCommand.getNewCursorPosition());
            sb2.append(')');
            return sb2.toString();
        }
        if (editCommand instanceof SetComposingRegionCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof DeleteSurroundingTextCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof DeleteSurroundingTextInCodePointsCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof SetSelectionCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof FinishComposingTextCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof BackspaceCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof MoveCursorCommand) {
            return editCommand.toString();
        }
        if (editCommand instanceof DeleteAllCommand) {
            return editCommand.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Unknown EditCommand: ");
        String strA = QJ.b(editCommand.getClass()).a();
        if (strA == null) {
            strA = "{anonymous EditCommand}";
        }
        sb3.append(strA);
        return sb3.toString();
    }

    public final TextFieldValue apply(List<? extends EditCommand> list) {
        EditCommand editCommand;
        Exception e;
        AbstractC4492zt.h(list, "editCommands");
        EditCommand editCommand2 = null;
        try {
            int size = list.size();
            int i = 0;
            while (i < size) {
                editCommand = list.get(i);
                try {
                    editCommand.applyTo(this.mBuffer);
                    i++;
                    editCommand2 = editCommand;
                } catch (Exception e2) {
                    e = e2;
                    throw new RuntimeException(generateBatchErrorMessage(list, editCommand), e);
                }
            }
            TextFieldValue textFieldValue = new TextFieldValue(this.mBuffer.toAnnotatedString$ui_text_release(), this.mBuffer.m4845getSelectiond9O1mEE$ui_text_release(), this.mBuffer.m4844getCompositionMzsxiRA$ui_text_release(), (AbstractC0419Di) null);
            this.mBufferState = textFieldValue;
            return textFieldValue;
        } catch (Exception e3) {
            editCommand = editCommand2;
            e = e3;
        }
    }

    public final EditingBuffer getMBuffer$ui_text_release() {
        return this.mBuffer;
    }

    public final TextFieldValue getMBufferState$ui_text_release() {
        return this.mBufferState;
    }

    public final void reset(TextFieldValue textFieldValue, TextInputSession textInputSession) {
        AbstractC4492zt.h(textFieldValue, "value");
        boolean zD = AbstractC4492zt.d(textFieldValue.m4921getCompositionMzsxiRA(), this.mBuffer.m4844getCompositionMzsxiRA$ui_text_release());
        boolean z = true;
        boolean z2 = false;
        if (!AbstractC4492zt.d(this.mBufferState.getAnnotatedString(), textFieldValue.getAnnotatedString())) {
            this.mBuffer = new EditingBuffer(textFieldValue.getAnnotatedString(), textFieldValue.m4922getSelectiond9O1mEE(), (AbstractC0419Di) null);
        } else if (TextRange.m4698equalsimpl0(this.mBufferState.m4922getSelectiond9O1mEE(), textFieldValue.m4922getSelectiond9O1mEE())) {
            z = false;
        } else {
            this.mBuffer.setSelection$ui_text_release(TextRange.m4703getMinimpl(textFieldValue.m4922getSelectiond9O1mEE()), TextRange.m4702getMaximpl(textFieldValue.m4922getSelectiond9O1mEE()));
            z = false;
            z2 = true;
        }
        if (textFieldValue.m4921getCompositionMzsxiRA() == null) {
            this.mBuffer.commitComposition$ui_text_release();
        } else if (!TextRange.m4699getCollapsedimpl(textFieldValue.m4921getCompositionMzsxiRA().m4709unboximpl())) {
            this.mBuffer.setComposition$ui_text_release(TextRange.m4703getMinimpl(textFieldValue.m4921getCompositionMzsxiRA().m4709unboximpl()), TextRange.m4702getMaximpl(textFieldValue.m4921getCompositionMzsxiRA().m4709unboximpl()));
        }
        if (z || (!z2 && !zD)) {
            this.mBuffer.commitComposition$ui_text_release();
            textFieldValue = TextFieldValue.m4917copy3r_uNRQ$default(textFieldValue, (AnnotatedString) null, 0L, (TextRange) null, 3, (Object) null);
        }
        TextFieldValue textFieldValue2 = this.mBufferState;
        this.mBufferState = textFieldValue;
        if (textInputSession != null) {
            textInputSession.updateState(textFieldValue2, textFieldValue);
        }
    }

    public final TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }
}
