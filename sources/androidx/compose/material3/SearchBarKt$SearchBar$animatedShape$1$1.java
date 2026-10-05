package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class SearchBarKt$SearchBar$animatedShape$1$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ State<Float> $animationProgress;
    final /* synthetic */ Density $density;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarKt$SearchBar$animatedShape$1$1(Density density, State<Float> state) {
        super(3);
        this.$density = density;
        this.$animationProgress = state;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m1741invoke12SF9DM((Path) obj, ((Size) obj2).m2872unboximpl(), (LayoutDirection) obj3);
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-12SF9DM, reason: not valid java name */
    public final void m1741invoke12SF9DM(Path path, long j, LayoutDirection layoutDirection) {
        AbstractC4492zt.h(path, "$this$$receiver");
        AbstractC4492zt.h(layoutDirection, "<anonymous parameter 1>");
        path.addRoundRect(RoundRectKt.m2853RoundRectsniSvfs(SizeKt.m2888toRectuvyYCjk(j), CornerRadiusKt.CornerRadius$default(this.$density.mo333toPx0680j_4(Dp.m5160constructorimpl(SearchBarKt.SearchBarCornerRadius * (1 - this.$animationProgress.getValue().floatValue()))), 0.0f, 2, null)));
    }
}
