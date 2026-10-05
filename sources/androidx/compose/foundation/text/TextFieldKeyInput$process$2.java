package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import defpackage.KJ;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldKeyInput$process$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ KeyCommand $command;
    final /* synthetic */ KJ $consumed;
    final /* synthetic */ TextFieldKeyInput this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((TextFieldPreparedSelection) obj);
            return FW.a;
        }

        public final void invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
            AbstractC4492zt.h(textFieldPreparedSelection, "$this$collapseLeftOr");
            textFieldPreparedSelection.moveCursorLeft();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((TextFieldPreparedSelection) obj);
            return FW.a;
        }

        public final void invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
            AbstractC4492zt.h(textFieldPreparedSelection, "$this$collapseRightOr");
            textFieldPreparedSelection.moveCursorRight();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
            AbstractC4492zt.h(textFieldPreparedSelection, "$this$deleteIfSelectedOr");
            return new DeleteSurroundingTextCommand(TextRange.m4700getEndimpl(textFieldPreparedSelection.m881getSelectiond9O1mEE()) - textFieldPreparedSelection.getPrecedingCharacterIndex(), 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
            AbstractC4492zt.h(textFieldPreparedSelection, "$this$deleteIfSelectedOr");
            int nextCharacterIndex = textFieldPreparedSelection.getNextCharacterIndex();
            if (nextCharacterIndex != -1) {
                return new DeleteSurroundingTextCommand(0, nextCharacterIndex - TextRange.m4700getEndimpl(textFieldPreparedSelection.m881getSelectiond9O1mEE()));
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
            AbstractC4492zt.h(textFieldPreparedSelection, "$this$deleteIfSelectedOr");
            Integer previousWordOffset = textFieldPreparedSelection.getPreviousWordOffset();
            if (previousWordOffset == null) {
                return null;
            }
            return new DeleteSurroundingTextCommand(TextRange.m4700getEndimpl(textFieldPreparedSelection.m881getSelectiond9O1mEE()) - previousWordOffset.intValue(), 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$6, reason: invalid class name */
    public static final class AnonymousClass6 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public AnonymousClass6() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
            AbstractC4492zt.h(textFieldPreparedSelection, "$this$deleteIfSelectedOr");
            Integer nextWordOffset = textFieldPreparedSelection.getNextWordOffset();
            if (nextWordOffset != null) {
                return new DeleteSurroundingTextCommand(0, nextWordOffset.intValue() - TextRange.m4700getEndimpl(textFieldPreparedSelection.m881getSelectiond9O1mEE()));
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$7, reason: invalid class name */
    public static final class AnonymousClass7 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        public AnonymousClass7() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
            AbstractC4492zt.h(textFieldPreparedSelection, "$this$deleteIfSelectedOr");
            Integer lineStartByOffset = textFieldPreparedSelection.getLineStartByOffset();
            if (lineStartByOffset == null) {
                return null;
            }
            return new DeleteSurroundingTextCommand(TextRange.m4700getEndimpl(textFieldPreparedSelection.m881getSelectiond9O1mEE()) - lineStartByOffset.intValue(), 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldKeyInput$process$2$8, reason: invalid class name */
    public static final class AnonymousClass8 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass8 INSTANCE = new AnonymousClass8();

        public AnonymousClass8() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final EditCommand invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
            AbstractC4492zt.h(textFieldPreparedSelection, "$this$deleteIfSelectedOr");
            Integer lineEndByOffset = textFieldPreparedSelection.getLineEndByOffset();
            if (lineEndByOffset != null) {
                return new DeleteSurroundingTextCommand(0, lineEndByOffset.intValue() - TextRange.m4700getEndimpl(textFieldPreparedSelection.m881getSelectiond9O1mEE()));
            }
            return null;
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KeyCommand.values().length];
            try {
                iArr[KeyCommand.COPY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KeyCommand.PASTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KeyCommand.CUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KeyCommand.LEFT_CHAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[KeyCommand.RIGHT_CHAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[KeyCommand.LEFT_WORD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[KeyCommand.RIGHT_WORD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[KeyCommand.UP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[KeyCommand.DOWN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[KeyCommand.PAGE_UP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[KeyCommand.PAGE_DOWN.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[KeyCommand.LINE_START.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[KeyCommand.LINE_END.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[KeyCommand.LINE_LEFT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[KeyCommand.LINE_RIGHT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[KeyCommand.HOME.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[KeyCommand.END.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[KeyCommand.NEW_LINE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[KeyCommand.TAB.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[KeyCommand.SELECT_ALL.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_START.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_END.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[KeyCommand.SELECT_UP.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[KeyCommand.SELECT_DOWN.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[KeyCommand.SELECT_HOME.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[KeyCommand.SELECT_END.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[KeyCommand.DESELECT.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[KeyCommand.UNDO.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[KeyCommand.REDO.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldKeyInput$process$2(KeyCommand keyCommand, TextFieldKeyInput textFieldKeyInput, KJ kj) {
        super(1);
        this.$command = keyCommand;
        this.this$0 = textFieldKeyInput;
        this.$consumed = kj;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldPreparedSelection) obj);
        return FW.a;
    }

    public final void invoke(TextFieldPreparedSelection textFieldPreparedSelection) {
        TextFieldValue textFieldValueUndo;
        TextFieldValue textFieldValueRedo;
        AbstractC4492zt.h(textFieldPreparedSelection, "$this$commandExecutionContext");
        switch (WhenMappings.$EnumSwitchMapping$0[this.$command.ordinal()]) {
            case 1:
                this.this$0.getSelectionManager().copy$foundation_release(false);
                break;
            case 2:
                this.this$0.getSelectionManager().paste$foundation_release();
                break;
            case 3:
                this.this$0.getSelectionManager().cut$foundation_release();
                break;
            case 4:
                textFieldPreparedSelection.collapseLeftOr(AnonymousClass1.INSTANCE);
                break;
            case 5:
                textFieldPreparedSelection.collapseRightOr(AnonymousClass2.INSTANCE);
                break;
            case 6:
                textFieldPreparedSelection.moveCursorLeftByWord();
                break;
            case 7:
                textFieldPreparedSelection.moveCursorRightByWord();
                break;
            case 8:
                textFieldPreparedSelection.moveCursorPrevByParagraph();
                break;
            case 9:
                textFieldPreparedSelection.moveCursorNextByParagraph();
                break;
            case 10:
                textFieldPreparedSelection.moveCursorUpByLine();
                break;
            case 11:
                textFieldPreparedSelection.moveCursorDownByLine();
                break;
            case 12:
                textFieldPreparedSelection.moveCursorUpByPage();
                break;
            case 13:
                textFieldPreparedSelection.moveCursorDownByPage();
                break;
            case 14:
                textFieldPreparedSelection.moveCursorToLineStart();
                break;
            case 15:
                textFieldPreparedSelection.moveCursorToLineEnd();
                break;
            case 16:
                textFieldPreparedSelection.moveCursorToLineLeftSide();
                break;
            case 17:
                textFieldPreparedSelection.moveCursorToLineRightSide();
                break;
            case 18:
                textFieldPreparedSelection.moveCursorToHome();
                break;
            case 19:
                textFieldPreparedSelection.moveCursorToEnd();
                break;
            case 20:
                List<EditCommand> listDeleteIfSelectedOr = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass3.INSTANCE);
                if (listDeleteIfSelectedOr != null) {
                    this.this$0.apply((List<? extends EditCommand>) listDeleteIfSelectedOr);
                }
                break;
            case 21:
                List<EditCommand> listDeleteIfSelectedOr2 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass4.INSTANCE);
                if (listDeleteIfSelectedOr2 != null) {
                    this.this$0.apply((List<? extends EditCommand>) listDeleteIfSelectedOr2);
                }
                break;
            case 22:
                List<EditCommand> listDeleteIfSelectedOr3 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass5.INSTANCE);
                if (listDeleteIfSelectedOr3 != null) {
                    this.this$0.apply((List<? extends EditCommand>) listDeleteIfSelectedOr3);
                }
                break;
            case 23:
                List<EditCommand> listDeleteIfSelectedOr4 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass6.INSTANCE);
                if (listDeleteIfSelectedOr4 != null) {
                    this.this$0.apply((List<? extends EditCommand>) listDeleteIfSelectedOr4);
                }
                break;
            case 24:
                List<EditCommand> listDeleteIfSelectedOr5 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass7.INSTANCE);
                if (listDeleteIfSelectedOr5 != null) {
                    this.this$0.apply((List<? extends EditCommand>) listDeleteIfSelectedOr5);
                }
                break;
            case 25:
                List<EditCommand> listDeleteIfSelectedOr6 = textFieldPreparedSelection.deleteIfSelectedOr(AnonymousClass8.INSTANCE);
                if (listDeleteIfSelectedOr6 != null) {
                    this.this$0.apply((List<? extends EditCommand>) listDeleteIfSelectedOr6);
                }
                break;
            case 26:
                if (!this.this$0.getSingleLine()) {
                    this.this$0.apply(new CommitTextCommand(StringUtilities.LF, 1));
                } else {
                    this.this$0.getState().getOnImeActionPerformed().invoke(ImeAction.m4847boximpl(this.this$0.imeAction));
                }
                break;
            case 27:
                if (!this.this$0.getSingleLine()) {
                    this.this$0.apply(new CommitTextCommand("\t", 1));
                } else {
                    this.$consumed.a = false;
                }
                break;
            case 28:
                textFieldPreparedSelection.selectAll();
                break;
            case 29:
                textFieldPreparedSelection.moveCursorLeft().selectMovement();
                break;
            case 30:
                textFieldPreparedSelection.moveCursorRight().selectMovement();
                break;
            case 31:
                textFieldPreparedSelection.moveCursorLeftByWord().selectMovement();
                break;
            case 32:
                textFieldPreparedSelection.moveCursorRightByWord().selectMovement();
                break;
            case 33:
                textFieldPreparedSelection.moveCursorPrevByParagraph().selectMovement();
                break;
            case 34:
                textFieldPreparedSelection.moveCursorNextByParagraph().selectMovement();
                break;
            case 35:
                textFieldPreparedSelection.moveCursorToLineStart().selectMovement();
                break;
            case 36:
                textFieldPreparedSelection.moveCursorToLineEnd().selectMovement();
                break;
            case 37:
                textFieldPreparedSelection.moveCursorToLineLeftSide().selectMovement();
                break;
            case 38:
                textFieldPreparedSelection.moveCursorToLineRightSide().selectMovement();
                break;
            case 39:
                textFieldPreparedSelection.moveCursorUpByLine().selectMovement();
                break;
            case 40:
                textFieldPreparedSelection.moveCursorDownByLine().selectMovement();
                break;
            case 41:
                textFieldPreparedSelection.moveCursorUpByPage().selectMovement();
                break;
            case 42:
                textFieldPreparedSelection.moveCursorDownByPage().selectMovement();
                break;
            case 43:
                textFieldPreparedSelection.moveCursorToHome().selectMovement();
                break;
            case 44:
                textFieldPreparedSelection.moveCursorToEnd().selectMovement();
                break;
            case 45:
                textFieldPreparedSelection.deselect();
                break;
            case 46:
                UndoManager undoManager = this.this$0.getUndoManager();
                if (undoManager != null) {
                    undoManager.makeSnapshot(textFieldPreparedSelection.getValue());
                }
                UndoManager undoManager2 = this.this$0.getUndoManager();
                if (undoManager2 != null && (textFieldValueUndo = undoManager2.undo()) != null) {
                    this.this$0.onValueChange.invoke(textFieldValueUndo);
                    break;
                }
                break;
            case 47:
                UndoManager undoManager3 = this.this$0.getUndoManager();
                if (undoManager3 != null && (textFieldValueRedo = undoManager3.redo()) != null) {
                    this.this$0.onValueChange.invoke(textFieldValueRedo);
                    break;
                }
                break;
            case 48:
                KeyEventHelpers_androidKt.showCharacterPalette();
                break;
        }
    }
}
