package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public final class AutofillApi23Helper {
    public static final AutofillApi23Helper INSTANCE = new AutofillApi23Helper();

    private AutofillApi23Helper() {
    }

    @DoNotInline
    @RequiresApi(23)
    public final int addChildCount(ViewStructure viewStructure, int i) {
        AbstractC4492zt.h(viewStructure, "structure");
        return viewStructure.addChildCount(i);
    }

    @DoNotInline
    @RequiresApi(23)
    public final ViewStructure newChild(ViewStructure viewStructure, int i) {
        AbstractC4492zt.h(viewStructure, "structure");
        return viewStructure.newChild(i);
    }

    @DoNotInline
    @RequiresApi(23)
    public final void setDimens(ViewStructure viewStructure, int i, int i2, int i3, int i4, int i5, int i6) {
        AbstractC4492zt.h(viewStructure, "structure");
        viewStructure.setDimens(i, i2, i3, i4, i5, i6);
    }

    @DoNotInline
    @RequiresApi(23)
    public final void setId(ViewStructure viewStructure, int i, String str, String str2, String str3) {
        AbstractC4492zt.h(viewStructure, "structure");
        viewStructure.setId(i, str, str2, str3);
    }
}
