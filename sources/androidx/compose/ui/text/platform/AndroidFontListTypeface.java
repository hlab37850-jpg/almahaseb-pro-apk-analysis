package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.TempListUtilsKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import androidx.compose.ui.text.font.FontMatcher;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontListTypeface implements AndroidTypeface {
    private static final Companion Companion = new Companion(null);
    private static final FontMatcher fontMatcher = new FontMatcher();
    private final FontFamily fontFamily;
    private final FontMatcher fontMatcher$1;
    private final Map<Font, Typeface> loadedTypefaces;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final FontMatcher getFontMatcher() {
            return AndroidFontListTypeface.fontMatcher;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00b2  */
    public AndroidFontListTypeface(FontListFontFamily fontListFontFamily, Context context, List<C2020dG> list, FontMatcher fontMatcher2) {
        ArrayList arrayList;
        AbstractC4492zt.h(fontListFontFamily, "fontFamily");
        AbstractC4492zt.h(context, "context");
        AbstractC4492zt.h(fontMatcher2, "fontMatcher");
        this.fontMatcher$1 = fontMatcher2;
        List<Font> fonts = fontListFontFamily.getFonts();
        ArrayList arrayList2 = new ArrayList(fonts.size());
        int size = fonts.size();
        for (int i = 0; i < size; i++) {
            Font font = fonts.get(i);
            if (FontLoadingStrategy.m4788equalsimpl0(font.mo4747getLoadingStrategyPKNRLFQ(), FontLoadingStrategy.Companion.m4793getBlockingPKNRLFQ())) {
                arrayList2.add(font);
            }
        }
        if (list != null) {
            ArrayList arrayList3 = new ArrayList(list.size());
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                C2020dG c2020dG = list.get(i2);
                arrayList3.add((Font) AbstractC3240kc.d0(this.fontMatcher$1.m4797matchFontRetOiIg(arrayList2, (FontWeight) c2020dG.a(), ((FontStyle) c2020dG.b()).m4804unboximpl())));
            }
            List listFastFilterNotNull = TempListUtilsKt.fastFilterNotNull(arrayList3);
            if (listFastFilterNotNull != null) {
                HashSet hashSet = new HashSet(listFastFilterNotNull.size());
                arrayList = new ArrayList(listFastFilterNotNull.size());
                int size3 = listFastFilterNotNull.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    Object obj = listFastFilterNotNull.get(i3);
                    if (hashSet.add((Font) obj)) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
        } else {
            arrayList = null;
        }
        arrayList2 = arrayList != null ? arrayList : arrayList2;
        if (arrayList2.isEmpty()) {
            throw new IllegalStateException("Could not match font");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size4 = arrayList2.size();
        for (int i4 = 0; i4 < size4; i4++) {
            Font font2 = (Font) arrayList2.get(i4);
            try {
                linkedHashMap.put(font2, AndroidTypefaceCache.INSTANCE.getOrCreate(context, font2));
            } catch (Exception unused) {
                throw new IllegalStateException("Cannot create Typeface from " + font2);
            }
        }
        this.loadedTypefaces = linkedHashMap;
        this.fontFamily = fontListFontFamily;
    }

    @Override // androidx.compose.ui.text.font.Typeface
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final FontMatcher getFontMatcher() {
        return this.fontMatcher$1;
    }

    @Override // androidx.compose.ui.text.platform.AndroidTypeface
    /* JADX INFO: renamed from: getNativeTypeface-PYhJU0U */
    public Typeface mo4925getNativeTypefacePYhJU0U(FontWeight fontWeight, int i, int i2) {
        AbstractC4492zt.h(fontWeight, "fontWeight");
        Font font = (Font) AbstractC3240kc.d0(this.fontMatcher$1.m4797matchFontRetOiIg(new ArrayList(this.loadedTypefaces.keySet()), fontWeight, i));
        if (font == null) {
            throw new IllegalStateException("Could not load font");
        }
        Typeface typeface = this.loadedTypefaces.get(font);
        if (typeface == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Object objM4820synthesizeTypefaceFxwP2eA = FontSynthesis_androidKt.m4820synthesizeTypefaceFxwP2eA(i2, typeface, font, fontWeight, i);
        AbstractC4492zt.f(objM4820synthesizeTypefaceFxwP2eA, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) objM4820synthesizeTypefaceFxwP2eA;
    }

    public /* synthetic */ AndroidFontListTypeface(FontListFontFamily fontListFontFamily, Context context, List list, FontMatcher fontMatcher2, int i, AbstractC0419Di abstractC0419Di) {
        this(fontListFontFamily, context, (i & 4) != 0 ? null : list, (i & 8) != 0 ? fontMatcher : fontMatcher2);
    }
}
