package androidx.compose.ui.autofill;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Rect;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
public final class AutofillNode {
    private static int previousId;
    private final List<AutofillType> autofillTypes;
    private Rect boundingBox;
    private final int id;
    private final InterfaceC3750qp onFill;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int generateId() {
            int i;
            synchronized (this) {
                AutofillNode.previousId++;
                i = AutofillNode.previousId;
            }
            return i;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutofillNode(List<? extends AutofillType> list, Rect rect, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "autofillTypes");
        this.autofillTypes = list;
        this.boundingBox = rect;
        this.onFill = interfaceC3750qp;
        this.id = Companion.generateId();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutofillNode)) {
            return false;
        }
        AutofillNode autofillNode = (AutofillNode) obj;
        return AbstractC4492zt.d(this.autofillTypes, autofillNode.autofillTypes) && AbstractC4492zt.d(this.boundingBox, autofillNode.boundingBox) && AbstractC4492zt.d(this.onFill, autofillNode.onFill);
    }

    public final List<AutofillType> getAutofillTypes() {
        return this.autofillTypes;
    }

    public final Rect getBoundingBox() {
        return this.boundingBox;
    }

    public final int getId() {
        return this.id;
    }

    public final InterfaceC3750qp getOnFill() {
        return this.onFill;
    }

    public int hashCode() {
        int iHashCode = this.autofillTypes.hashCode() * 31;
        Rect rect = this.boundingBox;
        int iHashCode2 = (iHashCode + (rect != null ? rect.hashCode() : 0)) * 31;
        InterfaceC3750qp interfaceC3750qp = this.onFill;
        return iHashCode2 + (interfaceC3750qp != null ? interfaceC3750qp.hashCode() : 0);
    }

    public final void setBoundingBox(Rect rect) {
        this.boundingBox = rect;
    }

    public /* synthetic */ AutofillNode(List list, Rect rect, InterfaceC3750qp interfaceC3750qp, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? AbstractC1886cc.m() : list, (i & 2) != 0 ? null : rect, interfaceC3750qp);
    }
}
