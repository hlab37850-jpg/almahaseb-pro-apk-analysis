package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutIdKt {
    public static final Object getLayoutId(Measurable measurable) {
        AbstractC4492zt.h(measurable, "<this>");
        Object parentData = measurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    @Stable
    public static final Modifier layoutId(Modifier modifier, Object obj) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(obj, "layoutId");
        return modifier.then(new LayoutIdElement(obj));
    }
}
