package androidx.compose.ui.modifier;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorValueInfo;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
public final class ModifierLocalProviderKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.ui.modifier.ModifierLocalProviderKt$modifierLocalProvider$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends InspectorValueInfo implements ModifierLocalProvider<T> {
        private final ProvidableModifierLocal<T> key;
        private final State value$delegate;

        public AnonymousClass1(ProvidableModifierLocal<T> providableModifierLocal, InterfaceC3588op interfaceC3588op, InterfaceC3750qp interfaceC3750qp) {
            super(interfaceC3750qp);
            this.key = providableModifierLocal;
            this.value$delegate = SnapshotStateKt.derivedStateOf(interfaceC3588op);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean all(InterfaceC3750qp interfaceC3750qp) {
            return ZB.a(this, interfaceC3750qp);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean any(InterfaceC3750qp interfaceC3750qp) {
            return ZB.b(this, interfaceC3750qp);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldIn(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
            return ZB.c(this, obj, interfaceC0526Fp);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldOut(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
            return ZB.d(this, obj, interfaceC0526Fp);
        }

        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        public ProvidableModifierLocal<T> getKey() {
            return this.key;
        }

        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        public T getValue() {
            return (T) this.value$delegate.getValue();
        }

        @Override // androidx.compose.ui.Modifier
        public /* synthetic */ Modifier then(Modifier modifier) {
            return YB.a(this, modifier);
        }
    }

    @ExperimentalComposeUiApi
    public static final <T> Modifier modifierLocalProvider(Modifier modifier, ProvidableModifierLocal<T> providableModifierLocal, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(providableModifierLocal, "key");
        AbstractC4492zt.h(interfaceC3588op, "value");
        return modifier.then(new AnonymousClass1(providableModifierLocal, interfaceC3588op, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ModifierLocalProviderKt$modifierLocalProvider$$inlined$debugInspectorInfo$1(providableModifierLocal, interfaceC3588op) : InspectableValueKt.getNoInspectorInfo()));
    }
}
