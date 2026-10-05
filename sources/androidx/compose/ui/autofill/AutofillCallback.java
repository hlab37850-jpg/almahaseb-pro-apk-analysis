package androidx.compose.ui.autofill;

import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.ExperimentalComposeUiApi;
import defpackage.AbstractC4492zt;
import defpackage.E6;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class AutofillCallback extends AutofillManager.AutofillCallback {
    public static final AutofillCallback INSTANCE = new AutofillCallback();

    private AutofillCallback() {
    }

    @Override // android.view.autofill.AutofillManager.AutofillCallback
    public void onAutofillEvent(View view, int i, int i2) {
        String str;
        AbstractC4492zt.h(view, "view");
        super.onAutofillEvent(view, i, i2);
        if (i2 == 1) {
            str = "Autofill popup was shown.";
        } else if (i2 != 2) {
            str = i2 != 3 ? "Unknown status event." : "Autofill popup isn't shown because autofill is not available.\n\nDid you set up autofill?\n1. Go to Settings > System > Languages&input > Advanced > Autofill Service\n2. Pick a service\n\nDid you add an account?\n1. Go to Settings > System > Languages&input > Advanced\n2. Click on the settings icon next to the Autofill Service\n3. Add your account";
        } else {
            str = "Autofill popup was hidden.";
        }
        Log.d("Autofill Status", str);
    }

    @DoNotInline
    @ExperimentalComposeUiApi
    public final void register(AndroidAutofill androidAutofill) {
        AbstractC4492zt.h(androidAutofill, "autofill");
        androidAutofill.getAutofillManager().registerCallback(E6.a(this));
    }

    @DoNotInline
    @ExperimentalComposeUiApi
    public final void unregister(AndroidAutofill androidAutofill) {
        AbstractC4492zt.h(androidAutofill, "autofill");
        androidAutofill.getAutofillManager().unregisterCallback(E6.a(this));
    }
}
