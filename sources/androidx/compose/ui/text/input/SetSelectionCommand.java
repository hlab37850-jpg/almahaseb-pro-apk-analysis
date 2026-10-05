package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SetSelectionCommand implements EditCommand {
    public static final int $stable = 0;
    private final int end;
    private final int start;

    public SetSelectionCommand(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer editingBuffer) {
        AbstractC4492zt.h(editingBuffer, "buffer");
        int iL = AbstractC3871sJ.l(this.start, 0, editingBuffer.getLength$ui_text_release());
        int iL2 = AbstractC3871sJ.l(this.end, 0, editingBuffer.getLength$ui_text_release());
        if (iL < iL2) {
            editingBuffer.setSelection$ui_text_release(iL, iL2);
        } else {
            editingBuffer.setSelection$ui_text_release(iL2, iL);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetSelectionCommand)) {
            return false;
        }
        SetSelectionCommand setSelectionCommand = (SetSelectionCommand) obj;
        return this.start == setSelectionCommand.start && this.end == setSelectionCommand.end;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getStart() {
        return this.start;
    }

    public int hashCode() {
        return (this.start * 31) + this.end;
    }

    public String toString() {
        return "SetSelectionCommand(start=" + this.start + ", end=" + this.end + ')';
    }
}
