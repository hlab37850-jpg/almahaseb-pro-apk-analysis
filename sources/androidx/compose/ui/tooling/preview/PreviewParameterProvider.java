package androidx.compose.ui.tooling.preview;

import defpackage.InterfaceC4362yO;
import defpackage.MH;

/* JADX INFO: loaded from: classes.dex */
public interface PreviewParameterProvider<T> {

    public static final class DefaultImpls {
        @Deprecated
        public static <T> int getCount(PreviewParameterProvider<T> previewParameterProvider) {
            return MH.a(previewParameterProvider);
        }
    }

    int getCount();

    InterfaceC4362yO getValues();
}
