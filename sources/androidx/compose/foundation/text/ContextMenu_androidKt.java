package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class ContextMenu_androidKt {
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void ContextMenuArea(TextFieldSelectionManager textFieldSelectionManager, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(textFieldSelectionManager, "manager");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        composer.startReplaceableGroup(-1985516685);
        interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i >> 3) & 14));
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void ContextMenuArea(SelectionManager selectionManager, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(selectionManager, "manager");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        composer.startReplaceableGroup(605522716);
        interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i >> 3) & 14));
        composer.endReplaceableGroup();
    }
}
