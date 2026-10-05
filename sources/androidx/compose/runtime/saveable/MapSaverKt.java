package androidx.compose.runtime.saveable;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MapSaverKt {

    /* JADX INFO: renamed from: androidx.compose.runtime.saveable.MapSaverKt$mapSaver$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0526Fp $save;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp) {
            super(2);
            this.$save = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final List<Object> mo13invoke(SaverScope saverScope, T t) {
            AbstractC4492zt.h(saverScope, "$this$listSaver");
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : ((Map) this.$save.mo13invoke(saverScope, t)).entrySet()) {
                arrayList.add(entry.getKey());
                arrayList.add(entry.getValue());
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.saveable.MapSaverKt$mapSaver$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $restore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$restore = interfaceC3750qp;
        }

        /* JADX WARN: Type inference failed for: r5v3, types: [T, java.lang.Object] */
        @Override // defpackage.InterfaceC3750qp
        public final T invoke(List<? extends Object> list) {
            AbstractC4492zt.h(list, "list");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (list.size() % 2 != 0) {
                throw new IllegalStateException("Check failed.");
            }
            for (int i = 0; i < list.size(); i += 2) {
                Object obj = list.get(i);
                AbstractC4492zt.f(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, list.get(i + 1));
            }
            return this.$restore.invoke(linkedHashMap);
        }
    }

    public static final <T> Saver<T, Object> mapSaver(InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC0526Fp, "save");
        AbstractC4492zt.h(interfaceC3750qp, "restore");
        return ListSaverKt.listSaver(new AnonymousClass1(interfaceC0526Fp), new AnonymousClass2(interfaceC3750qp));
    }
}
