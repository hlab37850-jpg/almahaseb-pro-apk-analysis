package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class AutofillApi26Helper {
    public static final AutofillApi26Helper INSTANCE = new AutofillApi26Helper();

    private AutofillApi26Helper() {
    }

    @DoNotInline
    @RequiresApi(26)
    public final AutofillId getAutofillId(ViewStructure viewStructure) {
        AbstractC4492zt.h(viewStructure, "structure");
        return viewStructure.getAutofillId();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isDate(AutofillValue autofillValue) {
        AbstractC4492zt.h(autofillValue, "value");
        return autofillValue.isDate();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isList(AutofillValue autofillValue) {
        AbstractC4492zt.h(autofillValue, "value");
        return autofillValue.isList();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isText(AutofillValue autofillValue) {
        AbstractC4492zt.h(autofillValue, "value");
        return autofillValue.isText();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isToggle(AutofillValue autofillValue) {
        AbstractC4492zt.h(autofillValue, "value");
        return autofillValue.isToggle();
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAutofillHints(ViewStructure viewStructure, String[] strArr) {
        AbstractC4492zt.h(viewStructure, "structure");
        AbstractC4492zt.h(strArr, "hints");
        viewStructure.setAutofillHints(strArr);
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAutofillId(ViewStructure viewStructure, AutofillId autofillId, int i) {
        AbstractC4492zt.h(viewStructure, "structure");
        AbstractC4492zt.h(autofillId, "parent");
        viewStructure.setAutofillId(autofillId, i);
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAutofillType(ViewStructure viewStructure, int i) {
        AbstractC4492zt.h(viewStructure, "structure");
        viewStructure.setAutofillType(i);
    }

    @DoNotInline
    @RequiresApi(26)
    public final CharSequence textValue(AutofillValue autofillValue) {
        AbstractC4492zt.h(autofillValue, "value");
        CharSequence textValue = autofillValue.getTextValue();
        AbstractC4492zt.g(textValue, "value.textValue");
        return textValue;
    }
}
