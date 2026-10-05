package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.net.ImageRetrieve;
import com.itextpdf.tool.xml.net.exc.NoImageException;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DivCssApplier implements CssApplier<PdfDiv> {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) ListStyleTypeCssApplier.class);
    private final CssUtils utils = CssUtils.getInstance();

    @Override // com.itextpdf.tool.xml.html.CssApplier
    public PdfDiv apply(PdfDiv pdfDiv, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext) {
        Map<String, String> css = tag.getCSS();
        float fTranslateFontSize = FontSizeTranslator.getInstance().translateFontSize(tag);
        if (fTranslateFontSize == -1.0f) {
            fTranslateFontSize = 12.0f;
        }
        String str = tag.getAttributes().containsKey("align") ? tag.getAttributes().get("align") : css.containsKey("text-align") ? css.get("text-align") : null;
        if (str != null) {
            pdfDiv.setTextAlignment(CSS.getElementAlignment(str));
        }
        String str2 = css.get("width");
        if (str2 == null) {
            str2 = tag.getAttributes().get("width");
        }
        if (str2 != null) {
            float width = pageSizeContainable.getPageSize().getWidth();
            if (this.utils.isNumericValue(str2) || this.utils.isMetricValue(str2)) {
                pdfDiv.setWidth(Float.valueOf(Math.min(width, this.utils.parsePxInCmMmPcToPt(str2))));
            } else if (this.utils.isRelativeValue(str2)) {
                if (str2.contains(CSS.Value.PERCENTAGE)) {
                    pdfDiv.setPercentageWidth(Float.valueOf(this.utils.parseRelativeValue(str2, 1.0f)));
                } else {
                    pdfDiv.setWidth(Float.valueOf(Math.min(width, this.utils.parseRelativeValue(str2, fTranslateFontSize))));
                }
            }
        }
        String str3 = css.get("height");
        if (str3 == null) {
            str3 = tag.getAttributes().get("height");
        }
        if (str3 != null) {
            if (this.utils.isNumericValue(str3) || this.utils.isMetricValue(str3)) {
                pdfDiv.setHeight(Float.valueOf(this.utils.parsePxInCmMmPcToPt(str3)));
            } else if (this.utils.isRelativeValue(str3)) {
                if (str3.contains(CSS.Value.PERCENTAGE)) {
                    pdfDiv.setPercentageHeight(Float.valueOf(this.utils.parseRelativeValue(str3, 1.0f)));
                } else {
                    pdfDiv.setHeight(Float.valueOf(this.utils.parseRelativeValue(str3, fTranslateFontSize)));
                }
            }
        }
        for (Map.Entry<String, String> entry : css.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.equalsIgnoreCase("left")) {
                pdfDiv.setLeft(Float.valueOf(this.utils.parseValueToPt(value, fTranslateFontSize)));
            } else if (key.equalsIgnoreCase("right")) {
                if (pdfDiv.getWidth() == null || pdfDiv.getLeft() == null) {
                    pdfDiv.setRight(Float.valueOf(this.utils.parseValueToPt(value, fTranslateFontSize)));
                }
            } else if (key.equalsIgnoreCase("top")) {
                pdfDiv.setTop(Float.valueOf(this.utils.parseValueToPt(value, fTranslateFontSize)));
            } else if (key.equalsIgnoreCase("bottom")) {
                if (pdfDiv.getHeight() == null || pdfDiv.getTop() == null) {
                    pdfDiv.setBottom(Float.valueOf(this.utils.parseValueToPt(value, fTranslateFontSize)));
                }
            } else if (key.equalsIgnoreCase(CSS.Property.BACKGROUND_COLOR)) {
                pdfDiv.setBackgroundColor(HtmlUtilities.decodeColor(value));
            } else if (key.equalsIgnoreCase(CSS.Property.BACKGROUND_IMAGE)) {
                String strExtractUrl = this.utils.extractUrl(value);
                try {
                    pdfDiv.setBackgroundImage(new ImageRetrieve(htmlPipelineContext.getResourcesRootPath(), htmlPipelineContext.getImageProvider()).retrieveImage(strExtractUrl));
                } catch (NoImageException e) {
                    Logger logger = LOG;
                    if (logger.isLogging(Level.ERROR)) {
                        logger.error(String.format(LocaleMessages.getInstance().getMessage("html.tag.img.failed"), strExtractUrl), e);
                    }
                }
            } else if (key.equalsIgnoreCase("padding-left")) {
                pdfDiv.setPaddingLeft(this.utils.parseValueToPt(value, fTranslateFontSize));
            } else if (key.equalsIgnoreCase(CSS.Property.PADDING_RIGHT)) {
                pdfDiv.setPaddingRight(this.utils.parseValueToPt(value, fTranslateFontSize));
            } else if (key.equalsIgnoreCase(CSS.Property.PADDING_TOP)) {
                pdfDiv.setPaddingTop(this.utils.parseValueToPt(value, fTranslateFontSize));
            } else if (key.equalsIgnoreCase(CSS.Property.PADDING_BOTTOM)) {
                pdfDiv.setPaddingBottom(this.utils.parseValueToPt(value, fTranslateFontSize));
            } else if (key.equalsIgnoreCase(CSS.Property.MARGIN_TOP)) {
                this.utils.calculateMarginTop(value, fTranslateFontSize, marginMemory);
            } else if (key.equalsIgnoreCase(CSS.Property.MARGIN_BOTTOM)) {
                this.utils.parseValueToPt(value, fTranslateFontSize);
            } else if (key.equalsIgnoreCase("float")) {
                if (value.equalsIgnoreCase("left")) {
                    pdfDiv.setFloatType(PdfDiv.FloatType.LEFT);
                } else if (value.equalsIgnoreCase("right")) {
                    pdfDiv.setFloatType(PdfDiv.FloatType.RIGHT);
                }
            } else if (key.equalsIgnoreCase(CSS.Property.POSITION)) {
                if (value.equalsIgnoreCase(CSS.Value.ABSOLUTE)) {
                    pdfDiv.setPosition(PdfDiv.PositionType.ABSOLUTE);
                } else if (value.equalsIgnoreCase(CSS.Value.FIXED)) {
                    pdfDiv.setPosition(PdfDiv.PositionType.FIXED);
                } else if (value.equalsIgnoreCase(CSS.Value.RELATIVE)) {
                    pdfDiv.setPosition(PdfDiv.PositionType.RELATIVE);
                }
            } else if (key.equalsIgnoreCase(CSS.Property.DISPLAY)) {
                if (value.equalsIgnoreCase(CSS.Value.BLOCK)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.BLOCK);
                } else if (value.equalsIgnoreCase(CSS.Value.INLINE)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.INLINE);
                } else if (value.equalsIgnoreCase(CSS.Value.INLINE_BLOCK)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.INLINE_BLOCK);
                } else if (value.equalsIgnoreCase(CSS.Value.INLINE_TABLE)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.INLINE_TABLE);
                } else if (value.equalsIgnoreCase(CSS.Value.LIST_ITEM)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.LIST_ITEM);
                } else if (value.equalsIgnoreCase("none")) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.NONE);
                } else if (value.equalsIgnoreCase(CSS.Value.RUN_IN)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.RUN_IN);
                } else if (value.equalsIgnoreCase("table")) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.TABLE);
                } else if (value.equalsIgnoreCase(CSS.Value.TABLE_CAPTION)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.TABLE_CAPTION);
                } else if (value.equalsIgnoreCase(CSS.Value.TABLE_CELL)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.TABLE_CELL);
                } else if (value.equalsIgnoreCase(CSS.Value.TABLE_COLUMN_GROUP)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.TABLE_COLUMN_GROUP);
                } else if (value.equalsIgnoreCase(CSS.Value.TABLE_COLUMN)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.TABLE_COLUMN);
                } else if (value.equalsIgnoreCase(CSS.Value.TABLE_FOOTER_GROUP)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.TABLE_FOOTER_GROUP);
                } else if (value.equalsIgnoreCase(CSS.Value.TABLE_HEADER_GROUP)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.TABLE_HEADER_GROUP);
                } else if (value.equalsIgnoreCase(CSS.Value.TABLE_ROW)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.TABLE_ROW);
                } else if (value.equalsIgnoreCase(CSS.Value.TABLE_ROW_GROUP)) {
                    pdfDiv.setDisplay(PdfDiv.DisplayType.TABLE_ROW_GROUP);
                }
            } else if (key.equalsIgnoreCase(CSS.Property.BORDER_TOP_STYLE)) {
                if (value.equalsIgnoreCase(CSS.Value.DOTTED)) {
                    pdfDiv.setBorderTopStyle(PdfDiv.BorderTopStyle.DOTTED);
                } else if (value.equalsIgnoreCase(CSS.Value.DASHED)) {
                    pdfDiv.setBorderTopStyle(PdfDiv.BorderTopStyle.DASHED);
                } else if (value.equalsIgnoreCase(CSS.Value.SOLID)) {
                    pdfDiv.setBorderTopStyle(PdfDiv.BorderTopStyle.SOLID);
                } else if (value.equalsIgnoreCase(CSS.Value.DOUBLE)) {
                    pdfDiv.setBorderTopStyle(PdfDiv.BorderTopStyle.DOUBLE);
                } else if (value.equalsIgnoreCase(CSS.Value.GROOVE)) {
                    pdfDiv.setBorderTopStyle(PdfDiv.BorderTopStyle.GROOVE);
                } else if (value.equalsIgnoreCase(CSS.Value.RIDGE)) {
                    pdfDiv.setBorderTopStyle(PdfDiv.BorderTopStyle.RIDGE);
                } else if (value.equalsIgnoreCase(CSS.Value.INSET)) {
                    pdfDiv.setBorderTopStyle(PdfDiv.BorderTopStyle.INSET);
                } else if (value.equalsIgnoreCase(CSS.Value.OUTSET)) {
                    pdfDiv.setBorderTopStyle(PdfDiv.BorderTopStyle.OUTSET);
                }
            } else if (key.equalsIgnoreCase(CSS.Property.PAGE_BREAK_INSIDE) && value.equalsIgnoreCase(CSS.Value.AVOID)) {
                pdfDiv.setKeepTogether(true);
            }
        }
        return pdfDiv;
    }
}
