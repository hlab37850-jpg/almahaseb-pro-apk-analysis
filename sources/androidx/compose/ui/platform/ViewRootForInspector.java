package androidx.compose.ui.platform;

import android.view.View;
import defpackage.UX;

/* JADX INFO: loaded from: classes.dex */
public interface ViewRootForInspector {

    public static final class DefaultImpls {
        @Deprecated
        public static AbstractComposeView getSubCompositionView(ViewRootForInspector viewRootForInspector) {
            return UX.a(viewRootForInspector);
        }

        @Deprecated
        public static View getViewRoot(ViewRootForInspector viewRootForInspector) {
            return UX.b(viewRootForInspector);
        }
    }

    AbstractComposeView getSubCompositionView();

    View getViewRoot();
}
