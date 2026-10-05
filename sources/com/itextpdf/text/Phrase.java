package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.HyphenationEvent;
import com.itextpdf.text.pdf.PdfName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class Phrase extends ArrayList<Element> implements TextElementArray {
    private static final long serialVersionUID = 2643594602455068231L;
    protected Font font;
    protected HyphenationEvent hyphenation;
    protected float leading;
    protected float multipliedLeading;
    protected TabSettings tabSettings;

    public Phrase() {
        this(16.0f);
    }

    public static final Phrase getInstance(String str) {
        return getInstance(16, str, new Font());
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Element> collection) {
        Iterator<? extends Element> it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return true;
    }

    public boolean addChunk(Chunk chunk) {
        Font font = chunk.getFont();
        String content = chunk.getContent();
        Font font2 = this.font;
        if (font2 != null && !font2.isStandardFont()) {
            font = this.font.difference(chunk.getFont());
        }
        if (size() > 0 && !chunk.hasAttributes()) {
            try {
                Chunk chunk2 = (Chunk) get(size() - 1);
                PdfName role = chunk2.getRole();
                PdfName role2 = chunk.getRole();
                if (((role == null || role2 == null) ? true : role.equals(role2)) && !chunk2.hasAttributes() && !chunk.hasAccessibleAttributes() && !chunk2.hasAccessibleAttributes() && ((font == null || font.compareTo(chunk2.getFont()) == 0) && !"".equals(chunk2.getContent().trim()) && !"".equals(content.trim()))) {
                    chunk2.append(content);
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        Chunk chunk3 = new Chunk(content, font);
        chunk3.setAttributes(chunk.getAttributes());
        chunk3.role = chunk.getRole();
        chunk3.accessibleAttributes = chunk.getAccessibleAttributes();
        if (this.hyphenation != null && chunk3.getHyphenation() == null && !chunk3.isEmpty()) {
            chunk3.setHyphenation(this.hyphenation);
        }
        return super.add(chunk3);
    }

    public void addSpecial(Element element) {
        super.add(element);
    }

    public java.util.List<Chunk> getChunks() {
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getChunks());
        }
        return arrayList;
    }

    public String getContent() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Chunk> it = getChunks().iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toString());
        }
        return stringBuffer.toString();
    }

    public Font getFont() {
        return this.font;
    }

    public HyphenationEvent getHyphenation() {
        return this.hyphenation;
    }

    public float getLeading() {
        Font font;
        return (!Float.isNaN(this.leading) || (font = this.font) == null) ? this.leading : font.getCalculatedLeading(1.5f);
    }

    public float getMultipliedLeading() {
        return this.multipliedLeading;
    }

    public TabSettings getTabSettings() {
        return this.tabSettings;
    }

    public float getTotalLeading() {
        Font font = this.font;
        float calculatedLeading = font == null ? this.multipliedLeading * 12.0f : font.getCalculatedLeading(this.multipliedLeading);
        return (calculatedLeading <= 0.0f || hasLeading()) ? getLeading() + calculatedLeading : calculatedLeading;
    }

    public boolean hasLeading() {
        return !Float.isNaN(this.leading);
    }

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        int size = size();
        if (size == 0) {
            return true;
        }
        if (size != 1) {
            return false;
        }
        Element element = get(0);
        return element.type() == 10 && ((Chunk) element).isEmpty();
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return true;
    }

    public boolean process(ElementListener elementListener) {
        try {
            Iterator<Element> it = iterator();
            while (it.hasNext()) {
                elementListener.add(it.next());
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setHyphenation(HyphenationEvent hyphenationEvent) {
        this.hyphenation = hyphenationEvent;
    }

    public void setLeading(float f, float f2) {
        this.leading = f;
        this.multipliedLeading = f2;
    }

    public void setMultipliedLeading(float f) {
        this.leading = 0.0f;
        this.multipliedLeading = f;
    }

    public void setTabSettings(TabSettings tabSettings) {
        this.tabSettings = tabSettings;
    }

    public boolean trim() {
        while (size() > 0) {
            Element element = get(0);
            if (!(element instanceof Chunk) || !((Chunk) element).isWhitespace()) {
                break;
            }
            remove(element);
        }
        while (size() > 0) {
            Element element2 = get(size() - 1);
            if (!(element2 instanceof Chunk) || !((Chunk) element2).isWhitespace()) {
                break;
            }
            remove(element2);
        }
        return size() > 0;
    }

    public int type() {
        return 11;
    }

    public Phrase(Phrase phrase) {
        this.leading = Float.NaN;
        this.multipliedLeading = 0.0f;
        this.hyphenation = null;
        this.tabSettings = null;
        addAll(phrase);
        setLeading(phrase.getLeading(), phrase.getMultipliedLeading());
        this.font = phrase.getFont();
        this.tabSettings = phrase.getTabSettings();
        setHyphenation(phrase.getHyphenation());
    }

    public static final Phrase getInstance(int i, String str) {
        return getInstance(i, str, new Font());
    }

    public static final Phrase getInstance(int i, String str, Font font) {
        Phrase phrase = new Phrase(true);
        phrase.setLeading(i);
        phrase.font = font;
        if (font.getFamily() != Font.FontFamily.SYMBOL && font.getFamily() != Font.FontFamily.ZAPFDINGBATS && font.getBaseFont() == null) {
            while (true) {
                int iIndex = SpecialSymbol.index(str);
                if (iIndex <= -1) {
                    break;
                }
                if (iIndex > 0) {
                    phrase.add((Element) new Chunk(str.substring(0, iIndex), font));
                    str = str.substring(iIndex);
                }
                Font font2 = new Font(Font.FontFamily.SYMBOL, font.getSize(), font.getStyle(), font.getColor());
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(SpecialSymbol.getCorrespondingSymbol(str.charAt(0)));
                str = str.substring(1);
                while (SpecialSymbol.index(str) == 0) {
                    stringBuffer.append(SpecialSymbol.getCorrespondingSymbol(str.charAt(0)));
                    str = str.substring(1);
                }
                phrase.add((Element) new Chunk(stringBuffer.toString(), font2));
            }
        }
        if (str != null && str.length() != 0) {
            phrase.add((Element) new Chunk(str, font));
        }
        return phrase;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i, Element element) {
        if (element == null) {
            return;
        }
        int iType = element.type();
        if (iType != 14 && iType != 17 && iType != 23 && iType != 29 && iType != 37 && iType != 50 && iType != 55 && iType != 666) {
            switch (iType) {
                case 10:
                    Chunk chunk = (Chunk) element;
                    if (!this.font.isStandardFont()) {
                        chunk.setFont(this.font.difference(chunk.getFont()));
                    }
                    if (this.hyphenation != null && chunk.getHyphenation() == null && !chunk.isEmpty()) {
                        chunk.setHyphenation(this.hyphenation);
                    }
                    super.add(i, chunk);
                    return;
                case 11:
                case 12:
                    break;
                default:
                    throw new ClassCastException(MessageLocalization.getComposedMessage("insertion.of.illegal.element.1", element.getClass().getName()));
            }
        }
        super.add(i, element);
    }

    public void setLeading(float f) {
        this.leading = f;
        this.multipliedLeading = 0.0f;
    }

    public Phrase(float f) {
        this.multipliedLeading = 0.0f;
        this.hyphenation = null;
        this.tabSettings = null;
        this.leading = f;
        this.font = new Font();
    }

    public boolean add(String str) {
        if (str == null) {
            return false;
        }
        return super.add(new Chunk(str, this.font));
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Element element) {
        boolean zAdd;
        if (element == null) {
            return false;
        }
        try {
            int iType = element.type();
            if (iType != 14 && iType != 17 && iType != 23 && iType != 29 && iType != 37 && iType != 50 && iType != 55 && iType != 666) {
                switch (iType) {
                    case 10:
                        return addChunk((Chunk) element);
                    case 11:
                    case 12:
                        boolean z = true;
                        for (Element element2 : (Phrase) element) {
                            if (element2 instanceof Chunk) {
                                zAdd = addChunk((Chunk) element2);
                            } else {
                                zAdd = add(element2);
                            }
                            z &= zAdd;
                        }
                        return z;
                    default:
                        throw new ClassCastException(String.valueOf(element.type()));
                }
            }
            return super.add(element);
        } catch (ClassCastException e) {
            throw new ClassCastException(MessageLocalization.getComposedMessage("insertion.of.illegal.element.1", e.getMessage()));
        }
    }

    public Phrase(Chunk chunk) {
        this.leading = Float.NaN;
        this.multipliedLeading = 0.0f;
        this.hyphenation = null;
        this.tabSettings = null;
        super.add(chunk);
        this.font = chunk.getFont();
        setHyphenation(chunk.getHyphenation());
    }

    public Phrase(float f, Chunk chunk) {
        this.multipliedLeading = 0.0f;
        this.hyphenation = null;
        this.tabSettings = null;
        this.leading = f;
        super.add(chunk);
        this.font = chunk.getFont();
        setHyphenation(chunk.getHyphenation());
    }

    public Phrase(String str) {
        this(Float.NaN, str, new Font());
    }

    public Phrase(String str, Font font) {
        this(Float.NaN, str, font);
    }

    public Phrase(float f, String str) {
        this(f, str, new Font());
    }

    public Phrase(float f, String str, Font font) {
        this.multipliedLeading = 0.0f;
        this.hyphenation = null;
        this.tabSettings = null;
        this.leading = f;
        this.font = font;
        if (str == null || str.length() == 0) {
            return;
        }
        super.add(new Chunk(str, font));
    }

    private Phrase(boolean z) {
        this.leading = Float.NaN;
        this.multipliedLeading = 0.0f;
        this.hyphenation = null;
        this.tabSettings = null;
    }
}
