package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.GreekList;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.RomanList;
import com.itextpdf.text.ZapfDingbatsList;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.net.ImageRetrieve;
import com.itextpdf.tool.xml.net.exc.NoImageException;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ListStyleTypeCssApplier implements CssApplier<List> {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) ListStyleTypeCssApplier.class);
    private final CssUtils utils = CssUtils.getInstance();

    private void shrinkSymbol(List list, float f, BaseColor baseColor) {
        list.setSymbolIndent(12.0f);
        Font font = list.getSymbol().getFont();
        font.setSize(f);
        font.setColor(baseColor);
    }

    private void synchronizeSymbol(float f, List list, BaseColor baseColor) {
        Font font = list.getSymbol().getFont();
        font.setSize(f);
        font.setColor(baseColor);
        list.setSymbolIndent(f);
    }

    public List apply(List list, Tag tag, HtmlPipelineContext htmlPipelineContext) {
        return apply(list, tag, (MarginMemory) null, (PageSizeContainable) null, htmlPipelineContext);
    }

    @Override // com.itextpdf.tool.xml.html.CssApplier
    public List apply(List list, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext) {
        float fontSize = FontSizeTranslator.getInstance().getFontSize(tag);
        Map<String, String> css = tag.getCSS();
        String str = css.get(CSS.Property.LIST_STYLE_TYPE);
        BaseColor baseColorDecodeColor = HtmlUtilities.decodeColor(css.get("color"));
        if (baseColorDecodeColor == null) {
            baseColorDecodeColor = BaseColor.BLACK;
        }
        if (str != null) {
            if (str.equalsIgnoreCase("none")) {
                list.setLettered(false);
                list.setNumbered(false);
                list.setListSymbol("");
            } else if (CSS.Value.DECIMAL.equalsIgnoreCase(str)) {
                list = new List(true);
            } else if (CSS.Value.DISC.equalsIgnoreCase(str)) {
                list = new ZapfDingbatsList(108);
                list.setAutoindent(false);
                list.setSymbolIndent(7.75f);
                Chunk symbol = list.getSymbol();
                symbol.setTextRise(1.5f);
                Font font = symbol.getFont();
                font.setSize(4.5f);
                font.setColor(baseColorDecodeColor);
            } else if (CSS.Value.SQUARE.equalsIgnoreCase(str)) {
                list = new ZapfDingbatsList(110);
                shrinkSymbol(list, fontSize, baseColorDecodeColor);
            } else if (CSS.Value.CIRCLE.equalsIgnoreCase(str)) {
                list = new ZapfDingbatsList(109);
                list.setAutoindent(false);
                list.setSymbolIndent(7.75f);
                Chunk symbol2 = list.getSymbol();
                symbol2.setTextRise(1.5f);
                symbol2.getFont().setSize(4.5f);
            } else if (CSS.Value.LOWER_ROMAN.equals(str)) {
                list = new RomanList(true, 0);
                synchronizeSymbol(fontSize, list, baseColorDecodeColor);
                list.setAutoindent(true);
            } else if (CSS.Value.UPPER_ROMAN.equals(str)) {
                list = new RomanList(false, 0);
                list.setAutoindent(true);
                synchronizeSymbol(fontSize, list, baseColorDecodeColor);
            } else if (CSS.Value.LOWER_GREEK.equals(str)) {
                list = new GreekList(true, 0);
                synchronizeSymbol(fontSize, list, baseColorDecodeColor);
                list.setAutoindent(true);
            } else if (CSS.Value.UPPER_GREEK.equals(str)) {
                list = new GreekList(false, 0);
                synchronizeSymbol(fontSize, list, baseColorDecodeColor);
                list.setAutoindent(true);
            } else if (!CSS.Value.LOWER_ALPHA.equals(str) && !CSS.Value.LOWER_LATIN.equals(str)) {
                if (CSS.Value.UPPER_ALPHA.equals(str) || CSS.Value.UPPER_LATIN.equals(str)) {
                    list = new List(true, true);
                    synchronizeSymbol(fontSize, list, baseColorDecodeColor);
                    list.setLowercase(false);
                    list.setAutoindent(true);
                }
            } else {
                list = new List(true, true);
                synchronizeSymbol(fontSize, list, baseColorDecodeColor);
                list.setLowercase(true);
                list.setAutoindent(true);
            }
        } else if (tag.getName().equalsIgnoreCase("ol")) {
            list = new List(true);
            String str2 = tag.getAttributes().get("type");
            if (str2 != null) {
                if (str2.equals("A")) {
                    list.setLettered(true);
                } else if (str2.equals("a")) {
                    list.setLettered(true);
                    list.setLowercase(true);
                }
            }
            synchronizeSymbol(fontSize, list, baseColorDecodeColor);
            list.setAutoindent(true);
        } else if (tag.getName().equalsIgnoreCase("ul")) {
            list = new List(false);
            shrinkSymbol(list, fontSize, baseColorDecodeColor);
        }
        if (css.get(CSS.Property.LIST_STYLE_IMAGE) != null && !css.get(CSS.Property.LIST_STYLE_IMAGE).equalsIgnoreCase("none")) {
            list = new List();
            String strExtractUrl = this.utils.extractUrl(css.get(CSS.Property.LIST_STYLE_IMAGE));
            try {
                Image imageRetrieveImage = new ImageRetrieve(htmlPipelineContext.getResourcesRootPath(), htmlPipelineContext.getImageProvider()).retrieveImage(strExtractUrl);
                list.setListSymbol(new Chunk(imageRetrieveImage, 0.0f, 0.0f, false));
                list.setSymbolIndent(imageRetrieveImage.getWidth());
                Logger logger = LOG;
                if (logger.isLogging(Level.TRACE)) {
                    logger.trace(String.format(LocaleMessages.getInstance().getMessage("html.tag.list"), strExtractUrl));
                }
            } catch (NoImageException e) {
                Logger logger2 = LOG;
                if (logger2.isLogging(Level.ERROR)) {
                    logger2.error(String.format(LocaleMessages.getInstance().getMessage("html.tag.img.failed"), strExtractUrl), e);
                }
                list = new List(false);
            }
            list.setAutoindent(false);
        }
        list.setAlignindent(false);
        list.setIndentationLeft(((css.get(CSS.Property.LIST_STYLE_POSITION) == null || !css.get(CSS.Property.LIST_STYLE_POSITION).equalsIgnoreCase(CSS.Value.INSIDE)) ? 15.0f : 30.0f) + (css.get(CSS.Property.MARGIN_LEFT) != null ? this.utils.parseValueToPt(css.get(CSS.Property.MARGIN_LEFT), fontSize) : 0.0f) + (css.get("padding-left") != null ? this.utils.parseValueToPt(css.get("padding-left"), fontSize) : 0.0f));
        String str3 = tag.getAttributes().get(HTML.Attribute.START);
        if (str3 != null) {
            try {
                list.setFirst(Integer.parseInt(str3));
            } catch (NumberFormatException unused) {
            }
        }
        return list;
    }

    public Element apply(List list, Tag tag) {
        return apply(list, tag, (MarginMemory) null, (PageSizeContainable) null, (HtmlPipelineContext) null);
    }
}
