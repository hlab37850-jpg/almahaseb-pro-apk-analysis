package androidx.compose.foundation.text;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3750qp;
import defpackage.O8;

/* JADX INFO: loaded from: classes.dex */
public final class CoreTextFieldKt$CoreTextField$focusModifier$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ InterfaceC2052dg $coroutineScope;
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextInputService $textInputService;
    final /* synthetic */ TextFieldValue $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$focusModifier$1(TextFieldState textFieldState, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, InterfaceC2052dg interfaceC2052dg, BringIntoViewRequester bringIntoViewRequester) {
        super(1);
        this.$state = textFieldState;
        this.$textInputService = textInputService;
        this.$value = textFieldValue;
        this.$imeOptions = imeOptions;
        this.$offsetMapping = offsetMapping;
        this.$manager = textFieldSelectionManager;
        this.$coroutineScope = interfaceC2052dg;
        this.$bringIntoViewRequester = bringIntoViewRequester;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusState) obj);
        return FW.a;
    }

    public final void invoke(FocusState focusState) {
        TextLayoutResultProxy layoutResult;
        AbstractC4492zt.h(focusState, "it");
        if (this.$state.getHasFocus() == focusState.isFocused()) {
            return;
        }
        this.$state.setHasFocus(focusState.isFocused());
        TextInputService textInputService = this.$textInputService;
        if (textInputService != null) {
            CoreTextFieldKt.notifyTextInputServiceOnFocusChange(textInputService, this.$state, this.$value, this.$imeOptions, this.$offsetMapping);
            if (focusState.isFocused() && (layoutResult = this.$state.getLayoutResult()) != null) {
                O8.d(this.$coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(this.$bringIntoViewRequester, this.$value, this.$state, layoutResult, this.$offsetMapping, null), 3, null);
            }
        }
        if (focusState.isFocused()) {
            return;
        }
        TextFieldSelectionManager.m951deselect_kEHs6E$foundation_release$default(this.$manager, null, 1, null);
    }
}
