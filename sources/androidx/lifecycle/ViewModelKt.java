package androidx.lifecycle;

import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.InterfaceC2052dg;
import defpackage.TS;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewModelKt {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    public static final InterfaceC2052dg getViewModelScope(ViewModel viewModel) {
        AbstractC4492zt.h(viewModel, "<this>");
        InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) viewModel.getTag(JOB_KEY);
        if (interfaceC2052dg != null) {
            return interfaceC2052dg;
        }
        Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(TS.b(null, 1, null).plus(C0368Bj.c().I())));
        AbstractC4492zt.g(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (InterfaceC2052dg) tagIfAbsent;
    }
}
