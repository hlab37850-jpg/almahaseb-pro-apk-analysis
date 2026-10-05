package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.HyphenationEvent;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.draw.DrawInterface;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.zebra.sdk.util.internal.StringUtilities;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Chunk implements Element, IAccessibleElement {
    public static final String ACTION = "ACTION";
    public static final String BACKGROUND = "BACKGROUND";
    public static final String CHAR_SPACING = "CHAR_SPACING";
    public static final String COLOR = "COLOR";
    public static final String ENCODING = "ENCODING";
    public static final String GENERICTAG = "GENERICTAG";
    public static final String HSCALE = "HSCALE";
    public static final String HYPHENATION = "HYPHENATION";
    public static final String IMAGE = "IMAGE";
    public static final String LINEHEIGHT = "LINEHEIGHT";
    public static final String LOCALDESTINATION = "LOCALDESTINATION";
    public static final String LOCALGOTO = "LOCALGOTO";
    public static final Chunk NEWLINE;
    public static final String NEWPAGE = "NEWPAGE";
    public static final Chunk NEXTPAGE;
    public static final String OBJECT_REPLACEMENT_CHARACTER = "￼";
    public static final String PDFANNOTATION = "PDFANNOTATION";
    public static final String REMOTEGOTO = "REMOTEGOTO";
    public static final String SEPARATOR = "SEPARATOR";
    public static final String SKEW = "SKEW";
    public static final Chunk SPACETABBING;
    public static final String SPLITCHARACTER = "SPLITCHARACTER";
    public static final String SUBSUPSCRIPT = "SUBSUPSCRIPT";
    public static final String TAB = "TAB";
    public static final Chunk TABBING;
    public static final String TABSETTINGS = "TABSETTINGS";
    public static final String TEXTRENDERMODE = "TEXTRENDERMODE";
    public static final String UNDERLINE = "UNDERLINE";
    public static final String WHITESPACE = "WHITESPACE";
    public static final String WORD_SPACING = "WORD_SPACING";
    protected HashMap<PdfName, PdfObject> accessibleAttributes;
    protected HashMap<String, Object> attributes;
    protected StringBuffer content;
    private String contentWithNoTabs;
    protected Font font;
    private AccessibleElementId id;
    protected PdfName role;

    static {
        Chunk chunk = new Chunk(StringUtilities.LF);
        NEWLINE = chunk;
        chunk.setRole(PdfName.P);
        Chunk chunk2 = new Chunk("");
        NEXTPAGE = chunk2;
        chunk2.setNewPage();
        Float fValueOf = Float.valueOf(Float.NaN);
        TABBING = new Chunk(fValueOf, false);
        SPACETABBING = new Chunk(fValueOf, true);
    }

    public Chunk() {
        this.content = null;
        this.font = null;
        this.attributes = null;
        this.role = null;
        this.accessibleAttributes = null;
        this.id = null;
        this.contentWithNoTabs = null;
        this.content = new StringBuffer();
        this.font = new Font();
        this.role = PdfName.SPAN;
    }

    @Deprecated
    public static Chunk createTabspace() {
        return createTabspace(60.0f);
    }

    public static Chunk createWhitespace(String str) {
        return createWhitespace(str, false);
    }

    private Chunk setAttribute(String str, Object obj) {
        if (this.attributes == null) {
            this.attributes = new HashMap<>();
        }
        this.attributes.put(str, obj);
        return this;
    }

    public StringBuffer append(String str) {
        this.contentWithNoTabs = null;
        StringBuffer stringBuffer = this.content;
        stringBuffer.append(str);
        return stringBuffer;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfObject getAccessibleAttribute(PdfName pdfName) {
        if (getImage() != null) {
            return getImage().getAccessibleAttribute(pdfName);
        }
        HashMap<PdfName, PdfObject> map = this.accessibleAttributes;
        if (map != null) {
            return map.get(pdfName);
        }
        return null;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public HashMap<PdfName, PdfObject> getAccessibleAttributes() {
        return getImage() != null ? getImage().getAccessibleAttributes() : this.accessibleAttributes;
    }

    public HashMap<String, Object> getAttributes() {
        return this.attributes;
    }

    public float getCharacterSpacing() {
        HashMap<String, Object> map = this.attributes;
        if (map == null || !map.containsKey(CHAR_SPACING)) {
            return 0.0f;
        }
        return ((Float) this.attributes.get(CHAR_SPACING)).floatValue();
    }

    @Override // com.itextpdf.text.Element
    public java.util.List<Chunk> getChunks() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        return arrayList;
    }

    public String getContent() {
        if (this.contentWithNoTabs == null) {
            this.contentWithNoTabs = this.content.toString().replaceAll("\t", "");
        }
        return this.contentWithNoTabs;
    }

    public Font getFont() {
        return this.font;
    }

    public float getHorizontalScaling() {
        Float f;
        HashMap<String, Object> map = this.attributes;
        if (map == null || (f = (Float) map.get(HSCALE)) == null) {
            return 1.0f;
        }
        return f.floatValue();
    }

    public HyphenationEvent getHyphenation() {
        HashMap<String, Object> map = this.attributes;
        if (map == null) {
            return null;
        }
        return (HyphenationEvent) map.get(HYPHENATION);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public AccessibleElementId getId() {
        if (this.id == null) {
            this.id = new AccessibleElementId();
        }
        return this.id;
    }

    public Image getImage() {
        Object[] objArr;
        HashMap<String, Object> map = this.attributes;
        if (map == null || (objArr = (Object[]) map.get(IMAGE)) == null) {
            return null;
        }
        return (Image) objArr[0];
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return getImage() != null ? getImage().getRole() : this.role;
    }

    public String getTextExpansion() {
        PdfObject accessibleAttribute = getAccessibleAttribute(PdfName.E);
        if (accessibleAttribute instanceof PdfString) {
            return ((PdfString) accessibleAttribute).toUnicodeString();
        }
        return null;
    }

    public float getTextRise() {
        HashMap<String, Object> map = this.attributes;
        if (map == null || !map.containsKey(SUBSUPSCRIPT)) {
            return 0.0f;
        }
        return ((Float) this.attributes.get(SUBSUPSCRIPT)).floatValue();
    }

    public float getWidthPoint() {
        return getImage() != null ? getImage().getScaledWidth() : this.font.getCalculatedBaseFont(true).getWidthPoint(getContent(), this.font.getCalculatedSize()) * getHorizontalScaling();
    }

    public float getWordSpacing() {
        HashMap<String, Object> map = this.attributes;
        if (map == null || !map.containsKey(WORD_SPACING)) {
            return 0.0f;
        }
        return ((Float) this.attributes.get(WORD_SPACING)).floatValue();
    }

    public boolean hasAccessibleAttributes() {
        HashMap<PdfName, PdfObject> map = this.accessibleAttributes;
        return (map == null || map.isEmpty()) ? false : true;
    }

    public boolean hasAttributes() {
        HashMap<String, Object> map = this.attributes;
        return (map == null || map.isEmpty()) ? false : true;
    }

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return true;
    }

    public boolean isEmpty() {
        return this.content.toString().trim().length() == 0 && this.content.toString().indexOf(StringUtilities.LF) == -1 && this.attributes == null;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return true;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return true;
    }

    @Deprecated
    public boolean isTabspace() {
        HashMap<String, Object> map = this.attributes;
        return map != null && map.containsKey(TAB);
    }

    public boolean isWhitespace() {
        HashMap<String, Object> map = this.attributes;
        return map != null && map.containsKey(WHITESPACE);
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setAccessibleAttribute(PdfName pdfName, PdfObject pdfObject) {
        if (getImage() != null) {
            getImage().setAccessibleAttribute(pdfName, pdfObject);
            return;
        }
        if (this.accessibleAttributes == null) {
            this.accessibleAttributes = new HashMap<>();
        }
        this.accessibleAttributes.put(pdfName, pdfObject);
    }

    public Chunk setAction(PdfAction pdfAction) {
        setRole(PdfName.LINK);
        return setAttribute(ACTION, pdfAction);
    }

    public Chunk setAnchor(URL url) {
        setRole(PdfName.LINK);
        String externalForm = url.toExternalForm();
        setAccessibleAttribute(PdfName.ALT, new PdfString(externalForm));
        return setAttribute(ACTION, new PdfAction(externalForm));
    }

    public Chunk setAnnotation(PdfAnnotation pdfAnnotation) {
        return setAttribute(PDFANNOTATION, pdfAnnotation);
    }

    public void setAttributes(HashMap<String, Object> map) {
        this.attributes = map;
    }

    public Chunk setBackground(BaseColor baseColor) {
        return setBackground(baseColor, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public Chunk setCharacterSpacing(float f) {
        return setAttribute(CHAR_SPACING, new Float(f));
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Chunk setGenericTag(String str) {
        return setAttribute(GENERICTAG, str);
    }

    public Chunk setHorizontalScaling(float f) {
        return setAttribute(HSCALE, new Float(f));
    }

    public Chunk setHyphenation(HyphenationEvent hyphenationEvent) {
        return setAttribute(HYPHENATION, hyphenationEvent);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.id = accessibleElementId;
    }

    public Chunk setLineHeight(float f) {
        return setAttribute(LINEHEIGHT, Float.valueOf(f));
    }

    public Chunk setLocalDestination(String str) {
        return setAttribute(LOCALDESTINATION, str);
    }

    public Chunk setLocalGoto(String str) {
        return setAttribute(LOCALGOTO, str);
    }

    public Chunk setNewPage() {
        return setAttribute(NEWPAGE, null);
    }

    public Chunk setRemoteGoto(String str, String str2) {
        return setAttribute(REMOTEGOTO, new Object[]{str, str2});
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        if (getImage() != null) {
            getImage().setRole(pdfName);
        } else {
            this.role = pdfName;
        }
    }

    public Chunk setSkew(float f, float f2) {
        return setAttribute(SKEW, new float[]{(float) Math.tan((((double) f) * 3.141592653589793d) / 180.0d), (float) Math.tan((((double) f2) * 3.141592653589793d) / 180.0d)});
    }

    public Chunk setSplitCharacter(SplitCharacter splitCharacter) {
        return setAttribute(SPLITCHARACTER, splitCharacter);
    }

    public void setTextExpansion(String str) {
        setAccessibleAttribute(PdfName.E, new PdfString(str));
    }

    public Chunk setTextRenderMode(int i, float f, BaseColor baseColor) {
        return setAttribute(TEXTRENDERMODE, new Object[]{Integer.valueOf(i), new Float(f), baseColor});
    }

    public Chunk setTextRise(float f) {
        return setAttribute(SUBSUPSCRIPT, new Float(f));
    }

    public Chunk setUnderline(float f, float f2) {
        return setUnderline(null, f, 0.0f, f2, 0.0f, 0);
    }

    public Chunk setWordSpacing(float f) {
        return setAttribute(WORD_SPACING, new Float(f));
    }

    @Override // com.itextpdf.text.Element
    public String toString() {
        return getContent();
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return 10;
    }

    @Deprecated
    public static Chunk createTabspace(float f) {
        return new Chunk(Float.valueOf(f), true);
    }

    public static Chunk createWhitespace(String str, boolean z) {
        if (z) {
            return new Chunk(str);
        }
        Chunk chunk = new Chunk(' ');
        chunk.setAttribute(WHITESPACE, str);
        return chunk;
    }

    public Chunk setBackground(BaseColor baseColor, float f, float f2, float f3, float f4) {
        return setAttribute(BACKGROUND, new Object[]{baseColor, new float[]{f, f2, f3, f4}});
    }

    public Chunk setRemoteGoto(String str, int i) {
        return setAttribute(REMOTEGOTO, new Object[]{str, Integer.valueOf(i)});
    }

    public Chunk setUnderline(BaseColor baseColor, float f, float f2, float f3, float f4, int i) {
        if (this.attributes == null) {
            this.attributes = new HashMap<>();
        }
        return setAttribute(UNDERLINE, Utilities.addToArray((Object[][]) this.attributes.get(UNDERLINE), new Object[]{baseColor, new float[]{f, f2, f3, f4, i}}));
    }

    public Chunk setAnchor(String str) {
        setRole(PdfName.LINK);
        setAccessibleAttribute(PdfName.ALT, new PdfString(str));
        return setAttribute(ACTION, new PdfAction(str));
    }

    public Chunk(Chunk chunk) {
        this.content = null;
        this.font = null;
        this.attributes = null;
        this.role = null;
        this.accessibleAttributes = null;
        this.id = null;
        this.contentWithNoTabs = null;
        StringBuffer stringBuffer = chunk.content;
        if (stringBuffer != null) {
            this.content = new StringBuffer(stringBuffer.toString());
        }
        Font font = chunk.font;
        if (font != null) {
            this.font = new Font(font);
        }
        if (chunk.attributes != null) {
            this.attributes = new HashMap<>(chunk.attributes);
        }
        this.role = chunk.role;
        if (chunk.accessibleAttributes != null) {
            this.accessibleAttributes = new HashMap<>(chunk.accessibleAttributes);
        }
        this.id = chunk.getId();
    }

    public Chunk(String str, Font font) {
        this.content = null;
        this.font = null;
        this.attributes = null;
        this.role = null;
        this.accessibleAttributes = null;
        this.id = null;
        this.contentWithNoTabs = null;
        this.content = new StringBuffer(str);
        this.font = font;
        this.role = PdfName.SPAN;
    }

    public Chunk(String str) {
        this(str, new Font());
    }

    public Chunk(char c, Font font) {
        this.content = null;
        this.font = null;
        this.attributes = null;
        this.role = null;
        this.accessibleAttributes = null;
        this.id = null;
        this.contentWithNoTabs = null;
        StringBuffer stringBuffer = new StringBuffer();
        this.content = stringBuffer;
        stringBuffer.append(c);
        this.font = font;
        this.role = PdfName.SPAN;
    }

    public Chunk(char c) {
        this(c, new Font());
    }

    public Chunk(Image image, float f, float f2) {
        this("￼", new Font());
        Image image2 = Image.getInstance(image);
        image2.setAbsolutePosition(Float.NaN, Float.NaN);
        setAttribute(IMAGE, new Object[]{image2, new Float(f), new Float(f2), Boolean.FALSE});
        this.role = null;
    }

    public Chunk(DrawInterface drawInterface) {
        this(drawInterface, false);
    }

    public Chunk(DrawInterface drawInterface, boolean z) {
        this("￼", new Font());
        setAttribute(SEPARATOR, new Object[]{drawInterface, Boolean.valueOf(z)});
        this.role = null;
    }

    @Deprecated
    public Chunk(DrawInterface drawInterface, float f) {
        this(drawInterface, f, false);
    }

    @Deprecated
    public Chunk(DrawInterface drawInterface, float f, boolean z) {
        this("￼", new Font());
        if (f >= 0.0f) {
            setAttribute(TAB, new Object[]{drawInterface, new Float(f), Boolean.valueOf(z), new Float(0.0f)});
            this.role = PdfName.ARTIFACT;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("a.tab.position.may.not.be.lower.than.0.yours.is.1", String.valueOf(f)));
    }

    private Chunk(Float f, boolean z) {
        this("￼", new Font());
        if (f.floatValue() >= 0.0f) {
            setAttribute(TAB, new Object[]{f, Boolean.valueOf(z)});
            setAttribute(SPLITCHARACTER, TabSplitCharacter.TAB);
            setAttribute(TABSETTINGS, null);
            this.role = PdfName.ARTIFACT;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("a.tab.position.may.not.be.lower.than.0.yours.is.1", String.valueOf(f)));
    }

    public Chunk(Image image, float f, float f2, boolean z) {
        this("￼", new Font());
        setAttribute(IMAGE, new Object[]{image, new Float(f), new Float(f2), Boolean.valueOf(z)});
        this.role = PdfName.ARTIFACT;
    }
}
