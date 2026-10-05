package androidx.compose.runtime.saveable;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.NV;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ListSaverKt {

    /* JADX INFO: renamed from: androidx.compose.runtime.saveable.ListSaverKt$listSaver$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0526Fp $save;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp) {
            super(2);
            this.$save = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(SaverScope saverScope, Original original) {
            AbstractC4492zt.h(saverScope, "$this$Saver");
            List list = (List) this.$save.mo13invoke(saverScope, original);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj = list.get(i);
                if (obj != null && !saverScope.canBeSaved(obj)) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            List list2 = list;
            if (list2.isEmpty()) {
                return null;
            }
            return new ArrayList(list2);
        }
    }

    public static final <Original, Saveable> Saver<Original, Object> listSaver(InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC0526Fp, "save");
        AbstractC4492zt.h(interfaceC3750qp, "restore");
        return SaverKt.Saver(new AnonymousClass1(interfaceC0526Fp), (InterfaceC3750qp) NV.d(interfaceC3750qp, 1));
    }
}
