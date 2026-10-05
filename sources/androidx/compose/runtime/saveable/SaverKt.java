package androidx.compose.runtime.saveable;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SaverKt {
    private static final Saver<Object, Object> AutoSaver = Saver(SaverKt$AutoSaver$1.INSTANCE, SaverKt$AutoSaver$2.INSTANCE);

    public static final <Original, Saveable> Saver<Original, Saveable> Saver(final InterfaceC0526Fp interfaceC0526Fp, final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC0526Fp, "save");
        AbstractC4492zt.h(interfaceC3750qp, "restore");
        return new Saver<Original, Saveable>() { // from class: androidx.compose.runtime.saveable.SaverKt.Saver.1
            @Override // androidx.compose.runtime.saveable.Saver
            public Original restore(Saveable saveable) {
                AbstractC4492zt.h(saveable, "value");
                return (Original) interfaceC3750qp.invoke(saveable);
            }

            @Override // androidx.compose.runtime.saveable.Saver
            public Saveable save(SaverScope saverScope, Original original) {
                AbstractC4492zt.h(saverScope, "<this>");
                return (Saveable) interfaceC0526Fp.mo13invoke(saverScope, original);
            }
        };
    }

    public static final <T> Saver<T, Object> autoSaver() {
        Saver<T, Object> saver = (Saver<T, Object>) AutoSaver;
        AbstractC4492zt.f(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.SaverKt.autoSaver, kotlin.Any>");
        return saver;
    }
}
