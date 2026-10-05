package androidx.compose.ui.tooling.preview.datasource;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC4362yO;
import defpackage.MH;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public class CollectionPreviewParameterProvider<T> implements PreviewParameterProvider<T> {
    public static final int $stable = 8;
    private final Collection<T> collection;

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionPreviewParameterProvider(Collection<? extends T> collection) {
        AbstractC4492zt.h(collection, "collection");
        this.collection = collection;
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public /* synthetic */ int getCount() {
        return MH.a(this);
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public InterfaceC4362yO getValues() {
        return AbstractC3240kc.T(this.collection);
    }
}
