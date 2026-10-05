package androidx.compose.ui.modifier;

import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.HV;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class ModifierLocalModifierNodeKt {
    public static final ModifierLocalMap modifierLocalMapOf() {
        return EmptyMap.INSTANCE;
    }

    public static final <T> ModifierLocalMap modifierLocalMapOf(ModifierLocal<T> modifierLocal) {
        AbstractC4492zt.h(modifierLocal, "key");
        return new SingleLocalMap(modifierLocal);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> ModifierLocalMap modifierLocalMapOf(C2020dG c2020dG) {
        AbstractC4492zt.h(c2020dG, "entry");
        SingleLocalMap singleLocalMap = new SingleLocalMap((ModifierLocal) c2020dG.c());
        singleLocalMap.mo4243set$ui_release((ModifierLocal) c2020dG.c(), c2020dG.e());
        return singleLocalMap;
    }

    public static final ModifierLocalMap modifierLocalMapOf(C2020dG... c2020dGArr) {
        AbstractC4492zt.h(c2020dGArr, "entries");
        return new MultiLocalMap((C2020dG[]) Arrays.copyOf(c2020dGArr, c2020dGArr.length));
    }

    public static final ModifierLocalMap modifierLocalMapOf(ModifierLocal<?>... modifierLocalArr) {
        AbstractC4492zt.h(modifierLocalArr, "keys");
        ArrayList arrayList = new ArrayList(modifierLocalArr.length);
        for (ModifierLocal<?> modifierLocal : modifierLocalArr) {
            arrayList.add(HV.a(modifierLocal, null));
        }
        C2020dG[] c2020dGArr = (C2020dG[]) arrayList.toArray(new C2020dG[0]);
        return new MultiLocalMap((C2020dG[]) Arrays.copyOf(c2020dGArr, c2020dGArr.length));
    }
}
