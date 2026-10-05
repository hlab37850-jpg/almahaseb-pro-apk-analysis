package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@LayoutScopeMarker
@Immutable
public interface ColumnScope {

    public static final class DefaultImpls {
    }

    @Stable
    Modifier align(Modifier modifier, Alignment.Horizontal horizontal);

    @Stable
    Modifier alignBy(Modifier modifier, VerticalAlignmentLine verticalAlignmentLine);

    @Stable
    Modifier alignBy(Modifier modifier, InterfaceC3750qp interfaceC3750qp);

    @Stable
    Modifier weight(Modifier modifier, float f, boolean z);
}
