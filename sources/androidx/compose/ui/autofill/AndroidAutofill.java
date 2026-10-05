package androidx.compose.ui.autofill;

import android.view.View;
import android.view.autofill.AutofillManager;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Rect;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC4492zt;
import defpackage.L2;
import defpackage.N2;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
@ExperimentalComposeUiApi
public final class AndroidAutofill implements Autofill {
    private final AutofillManager autofillManager;
    private final AutofillTree autofillTree;
    private final View view;

    public AndroidAutofill(View view, AutofillTree autofillTree) {
        AbstractC4492zt.h(view, "view");
        AbstractC4492zt.h(autofillTree, "autofillTree");
        this.view = view;
        this.autofillTree = autofillTree;
        AutofillManager autofillManagerA = N2.a(view.getContext().getSystemService(L2.a()));
        if (autofillManagerA == null) {
            throw new IllegalStateException("Autofill service could not be located.");
        }
        this.autofillManager = autofillManagerA;
        view.setImportantForAutofill(1);
    }

    @Override // androidx.compose.ui.autofill.Autofill
    public void cancelAutofillForNode(AutofillNode autofillNode) {
        AbstractC4492zt.h(autofillNode, "autofillNode");
        this.autofillManager.notifyViewExited(this.view, autofillNode.getId());
    }

    public final AutofillManager getAutofillManager() {
        return this.autofillManager;
    }

    public final AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final View getView() {
        return this.view;
    }

    @Override // androidx.compose.ui.autofill.Autofill
    public void requestAutofillForNode(AutofillNode autofillNode) {
        AbstractC4492zt.h(autofillNode, "autofillNode");
        Rect boundingBox = autofillNode.getBoundingBox();
        if (boundingBox == null) {
            throw new IllegalStateException("requestAutofill called before onChildPositioned()");
        }
        this.autofillManager.notifyViewEntered(this.view, autofillNode.getId(), new android.graphics.Rect(AbstractC1210aB.c(boundingBox.getLeft()), AbstractC1210aB.c(boundingBox.getTop()), AbstractC1210aB.c(boundingBox.getRight()), AbstractC1210aB.c(boundingBox.getBottom())));
    }
}
