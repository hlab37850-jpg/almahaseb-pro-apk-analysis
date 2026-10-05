package androidx.compose.ui.text.input;

import android.graphics.Rect;
import android.view.Choreographer;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3756qv;
import defpackage.AbstractC4492zt;
import defpackage.EnumC4322xv;
import defpackage.FW;
import defpackage.InterfaceC3430mv;
import defpackage.InterfaceC3750qp;
import defpackage.OJ;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class TextInputServiceAndroid implements PlatformTextInputService {
    private final InterfaceC3430mv baseInputConnection$delegate;
    private Rect focusedRect;
    private Runnable frameCallback;
    private List<WeakReference<RecordingInputConnection>> ics;
    private ImeOptions imeOptions;
    private final Executor inputCommandProcessorExecutor;
    private final InputMethodManager inputMethodManager;
    private InterfaceC3750qp onEditCommand;
    private InterfaceC3750qp onImeActionPerformed;
    private final PlatformTextInput platformTextInput;
    private TextFieldValue state;
    private final MutableVector<TextInputCommand> textInputCommandQueue;
    private final View view;

    public enum TextInputCommand {
        StartInput,
        StopInput,
        ShowKeyboard,
        HideKeyboard
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextInputCommand.values().length];
            try {
                iArr[TextInputCommand.StartInput.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextInputCommand.StopInput.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextInputCommand.ShowKeyboard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TextInputCommand.HideKeyboard.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16671 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C16671 INSTANCE = new C16671();

        public C16671() {
            super(1);
        }

        public final void invoke(List<? extends EditCommand> list) {
            AbstractC4492zt.h(list, "it");
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends EditCommand>) obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m4924invokeKlQnJC8(((ImeAction) obj).m4853unboximpl());
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke-KlQnJC8, reason: not valid java name */
        public final void m4924invokeKlQnJC8(int i) {
        }
    }

    public TextInputServiceAndroid(View view, InputMethodManager inputMethodManager, PlatformTextInput platformTextInput, Executor executor) {
        AbstractC4492zt.h(view, "view");
        AbstractC4492zt.h(inputMethodManager, "inputMethodManager");
        AbstractC4492zt.h(executor, "inputCommandProcessorExecutor");
        this.view = view;
        this.inputMethodManager = inputMethodManager;
        this.platformTextInput = platformTextInput;
        this.inputCommandProcessorExecutor = executor;
        this.onEditCommand = TextInputServiceAndroid$onEditCommand$1.INSTANCE;
        this.onImeActionPerformed = TextInputServiceAndroid$onImeActionPerformed$1.INSTANCE;
        this.state = new TextFieldValue("", TextRange.Companion.m4710getZerod9O1mEE(), (TextRange) null, 4, (AbstractC0419Di) null);
        this.imeOptions = ImeOptions.Companion.getDefault();
        this.ics = new ArrayList();
        this.baseInputConnection$delegate = AbstractC3756qv.b(EnumC4322xv.NONE, new TextInputServiceAndroid$baseInputConnection$2(this));
        this.textInputCommandQueue = new MutableVector<>(new TextInputCommand[16], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection$delegate.getValue();
    }

    private final void processInputCommands() {
        if (!this.view.isFocused()) {
            this.textInputCommandQueue.clear();
            return;
        }
        OJ oj = new OJ();
        OJ oj2 = new OJ();
        MutableVector<TextInputCommand> mutableVector = this.textInputCommandQueue;
        int size = mutableVector.getSize();
        if (size > 0) {
            TextInputCommand[] content = mutableVector.getContent();
            int i = 0;
            do {
                processInputCommands$applyToState(content[i], oj, oj2);
                i++;
            } while (i < size);
        }
        if (AbstractC4492zt.d(oj.a, Boolean.TRUE)) {
            restartInputImmediately();
        }
        Boolean bool = (Boolean) oj2.a;
        if (bool != null) {
            setKeyboardVisibleImmediately(bool.booleanValue());
        }
        if (AbstractC4492zt.d(oj.a, Boolean.FALSE)) {
            restartInputImmediately();
        }
    }

    private static final void processInputCommands$applyToState(TextInputCommand textInputCommand, OJ oj, OJ oj2) {
        int i = WhenMappings.$EnumSwitchMapping$0[textInputCommand.ordinal()];
        if (i == 1) {
            Boolean bool = Boolean.TRUE;
            oj.a = bool;
            oj2.a = bool;
        } else if (i == 2) {
            Boolean bool2 = Boolean.FALSE;
            oj.a = bool2;
            oj2.a = bool2;
        } else if ((i == 3 || i == 4) && !AbstractC4492zt.d(oj.a, Boolean.FALSE)) {
            oj2.a = Boolean.valueOf(textInputCommand == TextInputCommand.ShowKeyboard);
        }
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }

    private final void sendInputCommand(TextInputCommand textInputCommand) {
        this.textInputCommandQueue.add(textInputCommand);
        if (this.frameCallback == null) {
            Runnable runnable = new Runnable() { // from class: pU
                @Override // java.lang.Runnable
                public final void run() {
                    TextInputServiceAndroid.sendInputCommand$lambda$1(this.a);
                }
            };
            this.inputCommandProcessorExecutor.execute(runnable);
            this.frameCallback = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendInputCommand$lambda$1(TextInputServiceAndroid textInputServiceAndroid) {
        AbstractC4492zt.h(textInputServiceAndroid, "this$0");
        textInputServiceAndroid.frameCallback = null;
        textInputServiceAndroid.processInputCommands();
    }

    private final void setKeyboardVisibleImmediately(boolean z) {
        if (z) {
            this.inputMethodManager.showSoftInput();
        } else {
            this.inputMethodManager.hideSoftInput();
        }
    }

    public final InputConnection createInputConnection(EditorInfo editorInfo) {
        AbstractC4492zt.h(editorInfo, "outAttrs");
        TextInputServiceAndroid_androidKt.update(editorInfo, this.imeOptions, this.state);
        TextInputServiceAndroid_androidKt.updateWithEmojiCompat(editorInfo);
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.state, new InputEventCallback2() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid.createInputConnection.1
            @Override // androidx.compose.ui.text.input.InputEventCallback2
            public void onConnectionClosed(RecordingInputConnection recordingInputConnection2) {
                AbstractC4492zt.h(recordingInputConnection2, "ic");
                int size = TextInputServiceAndroid.this.ics.size();
                for (int i = 0; i < size; i++) {
                    if (AbstractC4492zt.d(((WeakReference) TextInputServiceAndroid.this.ics.get(i)).get(), recordingInputConnection2)) {
                        TextInputServiceAndroid.this.ics.remove(i);
                        return;
                    }
                }
            }

            @Override // androidx.compose.ui.text.input.InputEventCallback2
            public void onEditCommands(List<? extends EditCommand> list) {
                AbstractC4492zt.h(list, "editCommands");
                TextInputServiceAndroid.this.onEditCommand.invoke(list);
            }

            @Override // androidx.compose.ui.text.input.InputEventCallback2
            /* JADX INFO: renamed from: onImeAction-KlQnJC8 */
            public void mo4876onImeActionKlQnJC8(int i) {
                TextInputServiceAndroid.this.onImeActionPerformed.invoke(ImeAction.m4847boximpl(i));
            }

            @Override // androidx.compose.ui.text.input.InputEventCallback2
            public void onKeyEvent(KeyEvent keyEvent) {
                AbstractC4492zt.h(keyEvent, NotificationCompat.CATEGORY_EVENT);
                TextInputServiceAndroid.this.getBaseInputConnection().sendKeyEvent(keyEvent);
            }
        }, this.imeOptions.getAutoCorrect());
        this.ics.add(new WeakReference<>(recordingInputConnection));
        return recordingInputConnection;
    }

    public final TextFieldValue getState$ui_release() {
        return this.state;
    }

    public final View getView() {
        return this.view;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void hideSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.HideKeyboard);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void notifyFocusedRect(androidx.compose.ui.geometry.Rect rect) {
        Rect rect2;
        AbstractC4492zt.h(rect, "rect");
        this.focusedRect = new Rect(AbstractC1210aB.c(rect.getLeft()), AbstractC1210aB.c(rect.getTop()), AbstractC1210aB.c(rect.getRight()), AbstractC1210aB.c(rect.getBottom()));
        if (!this.ics.isEmpty() || (rect2 = this.focusedRect) == null) {
            return;
        }
        this.view.requestRectangleOnScreen(new Rect(rect2));
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void showSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.ShowKeyboard);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void startInput(TextFieldValue textFieldValue, ImeOptions imeOptions, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        AbstractC4492zt.h(textFieldValue, "value");
        AbstractC4492zt.h(imeOptions, "imeOptions");
        AbstractC4492zt.h(interfaceC3750qp, "onEditCommand");
        AbstractC4492zt.h(interfaceC3750qp2, "onImeActionPerformed");
        PlatformTextInput platformTextInput = this.platformTextInput;
        if (platformTextInput != null) {
            platformTextInput.requestInputFocus();
        }
        this.state = textFieldValue;
        this.imeOptions = imeOptions;
        this.onEditCommand = interfaceC3750qp;
        this.onImeActionPerformed = interfaceC3750qp2;
        sendInputCommand(TextInputCommand.StartInput);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void stopInput() {
        PlatformTextInput platformTextInput = this.platformTextInput;
        if (platformTextInput != null) {
            platformTextInput.releaseInputFocus();
        }
        this.onEditCommand = C16671.INSTANCE;
        this.onImeActionPerformed = AnonymousClass2.INSTANCE;
        this.focusedRect = null;
        sendInputCommand(TextInputCommand.StopInput);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        AbstractC4492zt.h(textFieldValue2, "newValue");
        boolean z = (TextRange.m4698equalsimpl0(this.state.m4922getSelectiond9O1mEE(), textFieldValue2.m4922getSelectiond9O1mEE()) && AbstractC4492zt.d(this.state.m4921getCompositionMzsxiRA(), textFieldValue2.m4921getCompositionMzsxiRA())) ? false : true;
        this.state = textFieldValue2;
        int size = this.ics.size();
        for (int i = 0; i < size; i++) {
            RecordingInputConnection recordingInputConnection = this.ics.get(i).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.setMTextFieldValue$ui_release(textFieldValue2);
            }
        }
        if (AbstractC4492zt.d(textFieldValue, textFieldValue2)) {
            if (z) {
                InputMethodManager inputMethodManager = this.inputMethodManager;
                int iM4703getMinimpl = TextRange.m4703getMinimpl(textFieldValue2.m4922getSelectiond9O1mEE());
                int iM4702getMaximpl = TextRange.m4702getMaximpl(textFieldValue2.m4922getSelectiond9O1mEE());
                TextRange textRangeM4921getCompositionMzsxiRA = this.state.m4921getCompositionMzsxiRA();
                int iM4703getMinimpl2 = textRangeM4921getCompositionMzsxiRA != null ? TextRange.m4703getMinimpl(textRangeM4921getCompositionMzsxiRA.m4709unboximpl()) : -1;
                TextRange textRangeM4921getCompositionMzsxiRA2 = this.state.m4921getCompositionMzsxiRA();
                inputMethodManager.updateSelection(iM4703getMinimpl, iM4702getMaximpl, iM4703getMinimpl2, textRangeM4921getCompositionMzsxiRA2 != null ? TextRange.m4702getMaximpl(textRangeM4921getCompositionMzsxiRA2.m4709unboximpl()) : -1);
                return;
            }
            return;
        }
        if (textFieldValue != null && (!AbstractC4492zt.d(textFieldValue.getText(), textFieldValue2.getText()) || (TextRange.m4698equalsimpl0(textFieldValue.m4922getSelectiond9O1mEE(), textFieldValue2.m4922getSelectiond9O1mEE()) && !AbstractC4492zt.d(textFieldValue.m4921getCompositionMzsxiRA(), textFieldValue2.m4921getCompositionMzsxiRA())))) {
            restartInputImmediately();
            return;
        }
        int size2 = this.ics.size();
        for (int i2 = 0; i2 < size2; i2++) {
            RecordingInputConnection recordingInputConnection2 = this.ics.get(i2).get();
            if (recordingInputConnection2 != null) {
                recordingInputConnection2.updateInputState(this.state, this.inputMethodManager);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextInputServiceAndroid(View view, InputMethodManager inputMethodManager, PlatformTextInput platformTextInput, Executor executor, int i, AbstractC0419Di abstractC0419Di) {
        if ((i & 8) != 0) {
            Choreographer choreographer = Choreographer.getInstance();
            AbstractC4492zt.g(choreographer, "getInstance()");
            executor = TextInputServiceAndroid_androidKt.asExecutor(choreographer);
        }
        this(view, inputMethodManager, platformTextInput, executor);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextInputServiceAndroid(View view, InputMethodManager inputMethodManager, Executor executor, int i, AbstractC0419Di abstractC0419Di) {
        if ((i & 4) != 0) {
            Choreographer choreographer = Choreographer.getInstance();
            AbstractC4492zt.g(choreographer, "getInstance()");
            executor = TextInputServiceAndroid_androidKt.asExecutor(choreographer);
        }
        this(view, inputMethodManager, executor);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextInputServiceAndroid(View view, InputMethodManager inputMethodManager, Executor executor) {
        this(view, inputMethodManager, (PlatformTextInput) null, executor);
        AbstractC4492zt.h(view, "view");
        AbstractC4492zt.h(inputMethodManager, "inputMethodManager");
        AbstractC4492zt.h(executor, "inputCommandProcessorExecutor");
    }

    public /* synthetic */ TextInputServiceAndroid(View view, PlatformTextInput platformTextInput, int i, AbstractC0419Di abstractC0419Di) {
        this(view, (i & 2) != 0 ? null : platformTextInput);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextInputServiceAndroid(View view, PlatformTextInput platformTextInput) {
        this(view, new InputMethodManagerImpl(view), platformTextInput, null, 8, null);
        AbstractC4492zt.h(view, "view");
    }
}
