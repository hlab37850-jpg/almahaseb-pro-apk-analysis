package defpackage;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: renamed from: a6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public class C1201a6 {
    public final View a;
    public final AttributeSet b;
    public final N6 c = new N6();

    public C1201a6(View view, AttributeSet attributeSet) {
        this.a = view;
        this.b = attributeSet;
        b();
    }

    public N6 a() {
        return this.c;
    }

    public final void b() {
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(this.b, AbstractC2432iJ.ImageBadgeView);
        int i = typedArrayObtainStyledAttributes.getInt(AbstractC2432iJ.ImageBadgeView_ibv_badgeValue, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(AbstractC2432iJ.ImageBadgeView_ibv_maxBadgeValue, 99);
        float dimension = typedArrayObtainStyledAttributes.getDimension(AbstractC2432iJ.ImageBadgeView_ibv_badgeTextSize, AbstractC1900cj.b(12.0f));
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(AbstractC2432iJ.ImageBadgeView_ibv_badgePadding, AbstractC1900cj.a(0.0f));
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(AbstractC2432iJ.ImageBadgeView_ibv_fixedBadgeRadius, AbstractC1900cj.a(-1.0f));
        int i3 = typedArrayObtainStyledAttributes.getInt(AbstractC2432iJ.ImageBadgeView_ibv_badgeTextStyle, 0);
        String string = typedArrayObtainStyledAttributes.getString(AbstractC2432iJ.ImageBadgeView_ibv_badgeTextFont);
        Typeface typefaceCreateFromFile = string != null ? Typeface.createFromFile(string) : AbstractC1811bf.b;
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(AbstractC2432iJ.ImageBadgeView_ibv_badgeBackground);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(AbstractC2432iJ.ImageBadgeView_ibv_visibleBadge, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(AbstractC2432iJ.ImageBadgeView_ibv_badgeLimitValue, true);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(AbstractC2432iJ.ImageBadgeView_ibv_roundBadge, true);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(AbstractC2432iJ.ImageBadgeView_ibv_fixedRadius, false);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(AbstractC2432iJ.ImageBadgeView_ibv_badgeOvalAfterFirst, false);
        boolean z6 = typedArrayObtainStyledAttributes.getBoolean(AbstractC2432iJ.ImageBadgeView_ibv_showCounter, true);
        int color = typedArrayObtainStyledAttributes.getColor(AbstractC2432iJ.ImageBadgeView_ibv_badgeColor, AbstractC1811bf.a);
        this.c.L(i).C(i2).y(dimension).E(dimension2).A(dimension3).J(i3).x(typefaceCreateFromFile).u(drawable).M(z).B(z2).H(z3).z(z4).D(z5).I(z6).v(color).w(typedArrayObtainStyledAttributes.getColor(AbstractC2432iJ.ImageBadgeView_ibv_badgeTextColor, -1)).F(typedArrayObtainStyledAttributes.getInt(AbstractC2432iJ.ImageBadgeView_ibv_badgePosition, 1));
        typedArrayObtainStyledAttributes.recycle();
    }
}
