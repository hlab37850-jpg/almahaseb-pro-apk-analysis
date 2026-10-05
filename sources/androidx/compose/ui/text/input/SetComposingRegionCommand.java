package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SetComposingRegionCommand implements EditCommand {
    public static final int $stable = 0;
    private final int end;
    private final int start;

    public SetComposingRegionCommand(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer editingBuffer) {
        AbstractC4492zt.h(editingBuffer, "buffer");
        if (editingBuffer.hasComposition$ui_text_release()) {
            editingBuffer.commitComposition$ui_text_release();
        }
        int iL = AbstractC3871sJ.l(this.start, 0, editingBuffer.getLength$ui_text_release());
        int iL2 = AbstractC3871sJ.l(this.end, 0, editingBuffer.getLength$ui_text_release());
        if (iL != iL2) {
            if (iL < iL2) {
                editingBuffer.setComposition$ui_text_release(iL, iL2);
            } else {
                editingBuffer.setComposition$ui_text_release(iL2, iL);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetComposingRegionCommand)) {
            return false;
        }
        SetComposingRegionCommand setComposingRegionCommand = (SetComposingRegionCommand) obj;
        return this.start == setComposingRegionCommand.start && this.end == setComposingRegionCommand.end;
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
        return "SetComposingRegionCommand(start=" + this.start + ", end=" + this.end + ')';
    }
}
