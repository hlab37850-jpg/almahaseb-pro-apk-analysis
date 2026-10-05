package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.platform.InspectorValueInfo;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
@Stable
final class ConsumedInsetsModifier extends InspectorValueInfo implements ModifierLocalConsumer {
    private final InterfaceC3750qp block;
    private WindowInsets oldWindowInsets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumedInsetsModifier(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        super(interfaceC3750qp2);
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        AbstractC4492zt.h(interfaceC3750qp2, "inspectorInfo");
        this.block = interfaceC3750qp;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(InterfaceC3750qp interfaceC3750qp) {
        return ZB.a(this, interfaceC3750qp);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(InterfaceC3750qp interfaceC3750qp) {
        return ZB.b(this, interfaceC3750qp);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumedInsetsModifier) {
            return AbstractC4492zt.d(((ConsumedInsetsModifier) obj).block, this.block);
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        return ZB.c(this, obj, interfaceC0526Fp);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        return ZB.d(this, obj, interfaceC0526Fp);
    }

    public int hashCode() {
        return this.block.hashCode();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope modifierLocalReadScope) {
        AbstractC4492zt.h(modifierLocalReadScope, "scope");
        WindowInsets windowInsets = (WindowInsets) modifierLocalReadScope.getCurrent(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets());
        if (AbstractC4492zt.d(windowInsets, this.oldWindowInsets)) {
            return;
        }
        this.oldWindowInsets = windowInsets;
        this.block.invoke(windowInsets);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return YB.a(this, modifier);
    }
}
