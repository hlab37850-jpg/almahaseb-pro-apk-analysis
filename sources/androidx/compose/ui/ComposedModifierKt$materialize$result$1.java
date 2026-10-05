package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.NV;

/* JADX INFO: loaded from: classes.dex */
public final class ComposedModifierKt$materialize$result$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ Composer $this_materialize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposedModifierKt$materialize$result$1(Composer composer) {
        super(2);
        this.$this_materialize = composer;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Modifier mo13invoke(Modifier modifier, Modifier.Element element) {
        AbstractC4492zt.h(modifier, "acc");
        AbstractC4492zt.h(element, "element");
        boolean z = element instanceof ComposedModifier;
        Modifier modifierMaterializeModifier = element;
        if (z) {
            InterfaceC0552Gp factory = ((ComposedModifier) element).getFactory();
            AbstractC4492zt.f(factory, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function3<androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
            modifierMaterializeModifier = ComposedModifierKt.materializeModifier(this.$this_materialize, (Modifier) ((InterfaceC0552Gp) NV.d(factory, 3)).invoke(Modifier.Companion, this.$this_materialize, 0));
        }
        return modifier.then(modifierMaterializeModifier);
    }
}
