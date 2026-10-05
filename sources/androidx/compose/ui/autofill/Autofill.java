package androidx.compose.ui.autofill;

import androidx.compose.ui.ExperimentalComposeUiApi;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeUiApi
public interface Autofill {
    void cancelAutofillForNode(AutofillNode autofillNode);

    void requestAutofillForNode(AutofillNode autofillNode);
}
