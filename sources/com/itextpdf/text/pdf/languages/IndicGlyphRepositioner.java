package com.itextpdf.text.pdf.languages;

import com.itextpdf.text.pdf.Glyph;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class IndicGlyphRepositioner implements GlyphRepositioner {
    private Glyph getNextGlyph(List<Glyph> list, int i) {
        int i2 = i + 1;
        if (i2 < list.size()) {
            return list.get(i2);
        }
        return null;
    }

    public abstract List<String> getCharactersToBeShiftedLeftByOnePosition();

    @Override // com.itextpdf.text.pdf.languages.GlyphRepositioner
    public void repositionGlyphs(List<Glyph> list) {
        int i = 0;
        while (i < list.size()) {
            Glyph glyph = list.get(i);
            Glyph nextGlyph = getNextGlyph(list, i);
            if (nextGlyph != null && getCharactersToBeShiftedLeftByOnePosition().contains(nextGlyph.chars)) {
                list.set(i, nextGlyph);
                i++;
                list.set(i, glyph);
            }
            i++;
        }
    }
}
