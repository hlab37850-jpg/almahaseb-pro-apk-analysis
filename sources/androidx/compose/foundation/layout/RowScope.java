package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@LayoutScopeMarker
@Immutable
public interface RowScope {

    public static final class DefaultImpls {
    }

    @Stable
    Modifier align(Modifier modifier, Alignment.Vertical vertical);

    @Stable
    Modifier alignBy(Modifier modifier, HorizontalAlignmentLine horizontalAlignmentLine);

    @Stable
    Modifier alignBy(Modifier modifier, InterfaceC3750qp interfaceC3750qp);

    @Stable
    Modifier alignByBaseline(Modifier modifier);

    @Stable
    Modifier weight(Modifier modifier, float f, boolean z);
}
