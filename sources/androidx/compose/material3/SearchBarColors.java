package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Color;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Immutable
@ExperimentalMaterial3Api
public final class SearchBarColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long dividerColor;
    private final TextFieldColors inputFieldColors;

    public /* synthetic */ SearchBarColors(long j, long j2, TextFieldColors textFieldColors, AbstractC0419Di abstractC0419Di) {
        this(j, j2, textFieldColors);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC4492zt.d(SearchBarColors.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type androidx.compose.material3.SearchBarColors");
        SearchBarColors searchBarColors = (SearchBarColors) obj;
        return Color.m3033equalsimpl0(this.containerColor, searchBarColors.containerColor) && Color.m3033equalsimpl0(this.dividerColor, searchBarColors.dividerColor) && AbstractC4492zt.d(this.inputFieldColors, searchBarColors.inputFieldColors);
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name */
    public final long m1729getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getDividerColor-0d7_KjU, reason: not valid java name */
    public final long m1730getDividerColor0d7_KjU() {
        return this.dividerColor;
    }

    public final TextFieldColors getInputFieldColors() {
        return this.inputFieldColors;
    }

    public int hashCode() {
        return (((Color.m3039hashCodeimpl(this.containerColor) * 31) + Color.m3039hashCodeimpl(this.dividerColor)) * 31) + this.inputFieldColors.hashCode();
    }

    private SearchBarColors(long j, long j2, TextFieldColors textFieldColors) {
        AbstractC4492zt.h(textFieldColors, "inputFieldColors");
        this.containerColor = j;
        this.dividerColor = j2;
        this.inputFieldColors = textFieldColors;
    }
}
