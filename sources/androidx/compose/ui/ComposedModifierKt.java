package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.InspectableValueKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ComposedModifierKt {

    /* JADX INFO: renamed from: androidx.compose.ui.ComposedModifierKt$materialize$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(Modifier.Element element) {
            AbstractC4492zt.h(element, "it");
            return Boolean.valueOf(!(element instanceof ComposedModifier));
        }
    }

    public static final Modifier composed(Modifier modifier, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        AbstractC4492zt.h(interfaceC0552Gp, "factory");
        return modifier.then(new ComposedModifier(interfaceC3750qp, interfaceC0552Gp));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC3750qp = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, interfaceC3750qp, interfaceC0552Gp);
    }

    public static final /* synthetic */ Modifier materialize(Composer composer, Modifier modifier) {
        AbstractC4492zt.h(composer, "<this>");
        AbstractC4492zt.h(modifier, "modifier");
        return materializeWithCompositionLocalInjectionInternal(composer, modifier);
    }

    public static final Modifier materializeModifier(Composer composer, Modifier modifier) {
        AbstractC4492zt.h(composer, "<this>");
        AbstractC4492zt.h(modifier, "modifier");
        if (modifier.all(AnonymousClass1.INSTANCE)) {
            return modifier;
        }
        composer.startReplaceableGroup(1219399079);
        Modifier modifier2 = (Modifier) modifier.foldIn(Modifier.Companion, new ComposedModifierKt$materialize$result$1(composer));
        composer.endReplaceableGroup();
        return modifier2;
    }

    public static final Modifier materializeWithCompositionLocalInjectionInternal(Composer composer, Modifier modifier) {
        AbstractC4492zt.h(composer, "<this>");
        AbstractC4492zt.h(modifier, "modifier");
        return modifier == Modifier.Companion ? modifier : materializeModifier(composer, new CompositionLocalMapInjectionElement(composer.getCurrentCompositionLocalMap()).then(modifier));
    }

    @ExperimentalComposeUiApi
    public static final Modifier composed(Modifier modifier, String str, Object obj, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(str, "fullyQualifiedName");
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        AbstractC4492zt.h(interfaceC0552Gp, "factory");
        return modifier.then(new KeyedComposedModifier1(str, obj, interfaceC3750qp, interfaceC0552Gp));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp, int i, Object obj2) {
        if ((i & 4) != 0) {
            interfaceC3750qp = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, interfaceC3750qp, interfaceC0552Gp);
    }

    @ExperimentalComposeUiApi
    public static final Modifier composed(Modifier modifier, String str, Object obj, Object obj2, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(str, "fullyQualifiedName");
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        AbstractC4492zt.h(interfaceC0552Gp, "factory");
        return modifier.then(new KeyedComposedModifier2(str, obj, obj2, interfaceC3750qp, interfaceC0552Gp));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Object obj2, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp, int i, Object obj3) {
        if ((i & 8) != 0) {
            interfaceC3750qp = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, obj2, interfaceC3750qp, interfaceC0552Gp);
    }

    @ExperimentalComposeUiApi
    public static final Modifier composed(Modifier modifier, String str, Object obj, Object obj2, Object obj3, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(str, "fullyQualifiedName");
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        AbstractC4492zt.h(interfaceC0552Gp, "factory");
        return modifier.then(new KeyedComposedModifier3(str, obj, obj2, obj3, interfaceC3750qp, interfaceC0552Gp));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Object obj2, Object obj3, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp, int i, Object obj4) {
        if ((i & 16) != 0) {
            interfaceC3750qp = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, obj2, obj3, interfaceC3750qp, interfaceC0552Gp);
    }

    @ExperimentalComposeUiApi
    public static final Modifier composed(Modifier modifier, String str, Object[] objArr, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(str, "fullyQualifiedName");
        AbstractC4492zt.h(objArr, "keys");
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        AbstractC4492zt.h(interfaceC0552Gp, "factory");
        return modifier.then(new KeyedComposedModifierN(str, objArr, interfaceC3750qp, interfaceC0552Gp));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object[] objArr, InterfaceC3750qp interfaceC3750qp, InterfaceC0552Gp interfaceC0552Gp, int i, Object obj) {
        if ((i & 4) != 0) {
            interfaceC3750qp = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, objArr, interfaceC3750qp, interfaceC0552Gp);
    }
}
