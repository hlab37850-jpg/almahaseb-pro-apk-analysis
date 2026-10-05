package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.pdf.HyphenationAuto;
import com.itextpdf.text.pdf.HyphenationEvent;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.tool.xml.css.CSS;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ElementFactory {
    private FontProvider provider = FontFactory.getFontImp();

    public static void setParagraphLeading(Paragraph paragraph, String str) {
        if (str == null) {
            paragraph.setLeading(0.0f, 1.5f);
            return;
        }
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ,");
            float f = Float.parseFloat(stringTokenizer.nextToken());
            if (stringTokenizer.hasMoreTokens()) {
                paragraph.setLeading(f, Float.parseFloat(stringTokenizer.nextToken()));
            } else {
                paragraph.setLeading(f, 0.0f);
            }
        } catch (Exception unused) {
            paragraph.setLeading(0.0f, 1.5f);
        }
    }

    public Chunk createChunk(String str, ChainedProperties chainedProperties) {
        Font font = getFont(chainedProperties);
        Chunk chunk = new Chunk(str, font);
        if (chainedProperties.hasProperty("sub")) {
            chunk.setTextRise((-font.getSize()) / 2.0f);
        } else if (chainedProperties.hasProperty("sup")) {
            chunk.setTextRise(font.getSize() / 2.0f);
        }
        chunk.setHyphenation(getHyphenation(chainedProperties));
        return chunk;
    }

    public Image createImage(String str, Map<String, String> map, ChainedProperties chainedProperties, DocListener docListener, ImageProvider imageProvider, HashMap<String, Image> map2, String str2) {
        Image image;
        Image image2 = imageProvider != null ? imageProvider.getImage(str, map, chainedProperties, docListener) : null;
        if (image2 == null && map2 != null && (image = map2.get(str)) != null) {
            image2 = Image.getInstance(image);
        }
        if (image2 != null) {
            return image2;
        }
        if (!str.startsWith("http") && str2 != null) {
            str = str2 + str;
        } else if (image2 == null && !str.startsWith("http")) {
            String property = chainedProperties.getProperty(HtmlTags.IMAGEPATH);
            if (property == null) {
                property = "";
            }
            str = new File(property, str).getPath();
        }
        Image image3 = Image.getInstance(str);
        if (image3 == null) {
            return null;
        }
        float length = HtmlUtilities.parseLength(chainedProperties.getProperty("size"), 12.0f);
        float f = length > 0.0f ? length : 12.0f;
        float length2 = HtmlUtilities.parseLength(map.get("width"), f);
        float length3 = HtmlUtilities.parseLength(map.get("height"), f);
        if (length2 > 0.0f && length3 > 0.0f) {
            image3.scaleAbsolute(length2, length3);
        } else if (length2 > 0.0f) {
            image3.scaleAbsolute(length2, (image3.getHeight() * length2) / image3.getWidth());
        } else if (length3 > 0.0f) {
            image3.scaleAbsolute((image3.getWidth() * length3) / image3.getHeight(), length3);
        }
        String property2 = chainedProperties.getProperty("before");
        if (property2 != null) {
            image3.setSpacingBefore(Float.parseFloat(property2));
        }
        String property3 = chainedProperties.getProperty("after");
        if (property3 != null) {
            image3.setSpacingAfter(Float.parseFloat(property3));
        }
        image3.setWidthPercentage(0.0f);
        return image3;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public LineSeparator createLineSeparator(Map<String, String> map, float f) {
        float f2;
        float f3;
        String str = map.get("size");
        if (str != null) {
            float length = HtmlUtilities.parseLength(str, 12.0f);
            if (length > 0.0f) {
                f2 = length;
            } else {
                f2 = 1.0f;
            }
        } else {
            f2 = 1.0f;
        }
        String str2 = map.get("width");
        if (str2 != null) {
            float length2 = HtmlUtilities.parseLength(str2, 12.0f);
            if (length2 <= 0.0f) {
                length2 = 100.0f;
            }
            if (str2.endsWith(CSS.Value.PERCENTAGE)) {
                f3 = length2;
            } else {
                f3 = 100.0f;
            }
        } else {
            f3 = 100.0f;
        }
        return new LineSeparator(f2, f3, null, HtmlUtilities.alignmentValue(map.get("align")), f);
    }

    public List createList(String str, ChainedProperties chainedProperties) {
        List list;
        if ("ul".equalsIgnoreCase(str)) {
            list = new List(false);
            list.setListSymbol("• ");
        } else {
            list = new List(true);
        }
        try {
            list.setIndentationLeft(new Float(chainedProperties.getProperty(HtmlTags.INDENT)).floatValue());
        } catch (Exception unused) {
            list.setAutoindent(true);
        }
        return list;
    }

    public ListItem createListItem(ChainedProperties chainedProperties) {
        ListItem listItem = new ListItem();
        updateElement(listItem, chainedProperties);
        return listItem;
    }

    public Paragraph createParagraph(ChainedProperties chainedProperties) {
        Paragraph paragraph = new Paragraph();
        updateElement(paragraph, chainedProperties);
        return paragraph;
    }

    public Font getFont(ChainedProperties chainedProperties) {
        String property = chainedProperties.getProperty("face");
        if (property == null || property.trim().length() == 0) {
            property = chainedProperties.getProperty("font-family");
        }
        int i = 0;
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                property = stringTokenizer.nextToken().trim();
                if (property.startsWith("\"")) {
                    property = property.substring(1);
                }
                if (property.endsWith("\"")) {
                    property = property.substring(0, property.length() - 1);
                }
                if (this.provider.isRegistered(property)) {
                    break;
                }
            }
        }
        String str = property;
        String property2 = chainedProperties.getProperty(HtmlTags.ENCODING);
        if (property2 == null) {
            property2 = "Cp1252";
        }
        String str2 = property2;
        String property3 = chainedProperties.getProperty("size");
        float f = property3 != null ? Float.parseFloat(property3) : 12.0f;
        String property4 = chainedProperties.getProperty("text-decoration");
        if (property4 != null && property4.trim().length() != 0) {
            if ("underline".equals(property4)) {
                i = 4;
            } else if ("line-through".equals(property4)) {
                i = 8;
            }
        }
        if (chainedProperties.hasProperty("i")) {
            i |= 2;
        }
        if (chainedProperties.hasProperty("b")) {
            i |= 1;
        }
        if (chainedProperties.hasProperty("u")) {
            i |= 4;
        }
        return this.provider.getFont(str, str2, true, f, chainedProperties.hasProperty("s") ? i | 8 : i, HtmlUtilities.decodeColor(chainedProperties.getProperty("color")));
    }

    public FontProvider getFontProvider() {
        return this.provider;
    }

    public HyphenationEvent getHyphenation(ChainedProperties chainedProperties) {
        int i;
        String property = chainedProperties.getProperty(HtmlTags.HYPHENATION);
        if (property == null || property.length() == 0) {
            return null;
        }
        int iIndexOf = property.indexOf(95);
        int i2 = 2;
        if (iIndexOf == -1) {
            return new HyphenationAuto(property, null, 2, 2);
        }
        String strSubstring = property.substring(0, iIndexOf);
        String strSubstring2 = property.substring(iIndexOf + 1);
        int iIndexOf2 = strSubstring2.indexOf(44);
        if (iIndexOf2 == -1) {
            return new HyphenationAuto(strSubstring, strSubstring2, 2, 2);
        }
        String strSubstring3 = strSubstring2.substring(iIndexOf2 + 1);
        String strSubstring4 = strSubstring2.substring(0, iIndexOf2);
        int iIndexOf3 = strSubstring3.indexOf(44);
        if (iIndexOf3 == -1) {
            i = Integer.parseInt(strSubstring3);
        } else {
            i = Integer.parseInt(strSubstring3.substring(0, iIndexOf3));
            i2 = Integer.parseInt(strSubstring3.substring(iIndexOf3 + 1));
        }
        return new HyphenationAuto(strSubstring, strSubstring4, i, i2);
    }

    public void setFontProvider(FontProvider fontProvider) {
        this.provider = fontProvider;
    }

    public void updateElement(Paragraph paragraph, ChainedProperties chainedProperties) {
        paragraph.setAlignment(HtmlUtilities.alignmentValue(chainedProperties.getProperty("align")));
        paragraph.setHyphenation(getHyphenation(chainedProperties));
        setParagraphLeading(paragraph, chainedProperties.getProperty(HtmlTags.LEADING));
        String property = chainedProperties.getProperty("after");
        if (property != null) {
            try {
                paragraph.setSpacingBefore(Float.parseFloat(property));
            } catch (Exception unused) {
            }
        }
        String property2 = chainedProperties.getProperty("after");
        if (property2 != null) {
            try {
                paragraph.setSpacingAfter(Float.parseFloat(property2));
            } catch (Exception unused2) {
            }
        }
        String property3 = chainedProperties.getProperty(HtmlTags.EXTRAPARASPACE);
        if (property3 != null) {
            try {
                paragraph.setExtraParagraphSpace(Float.parseFloat(property3));
            } catch (Exception unused3) {
            }
        }
        String property4 = chainedProperties.getProperty(HtmlTags.INDENT);
        if (property4 != null) {
            try {
                paragraph.setIndentationLeft(Float.parseFloat(property4));
            } catch (Exception unused4) {
            }
        }
    }
}
