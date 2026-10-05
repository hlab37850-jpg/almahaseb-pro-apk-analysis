package androidx.compose.ui.semantics;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SemanticsProperties$ContentDescription$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final SemanticsProperties$ContentDescription$1 INSTANCE = new SemanticsProperties$ContentDescription$1();

    public SemanticsProperties$ContentDescription$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final List<String> mo13invoke(List<String> list, List<String> list2) {
        List<String> listF0;
        AbstractC4492zt.h(list2, "childValue");
        if (list == null || (listF0 = AbstractC3240kc.F0(list)) == null) {
            return list2;
        }
        listF0.addAll(list2);
        return listF0;
    }
}
