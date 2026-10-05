package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import com.itextpdf.tool.xml.css.HeightCalculator;
import com.itextpdf.tool.xml.css.WidthCalculator;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.html.pdfelement.HtmlCell;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Table extends AbstractTagProcessor {
    public static final float DEFAULT_CELL_BORDER_WIDTH = 0.75f;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) Table.class);
    private static final CssUtils utils = CssUtils.getInstance();
    private static final FontSizeTranslator fst = FontSizeTranslator.getInstance();

    public final class NormalRowComparator implements Comparator<TableRowElement> {
        private NormalRowComparator() {
        }

        @Override // java.util.Comparator
        public int compare(TableRowElement tableRowElement, TableRowElement tableRowElement2) {
            return tableRowElement.getPlace().getNormal().compareTo(tableRowElement2.getPlace().getNormal());
        }
    }

    public final class RepeatedRowComparator implements Comparator<TableRowElement> {
        private RepeatedRowComparator() {
        }

        @Override // java.util.Comparator
        public int compare(TableRowElement tableRowElement, TableRowElement tableRowElement2) {
            return tableRowElement.getPlace().getRepeated().compareTo(tableRowElement2.getPlace().getRepeated());
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007c  */
    private float calculateDivWidestElementWidth(ArrayList<Element> arrayList) {
        float totalWidth;
        float widestWord;
        float f = 0.0f;
        for (Element element : arrayList) {
            if (element instanceof PdfDiv) {
                totalWidth = calculateDivWidestElementWidth(((PdfDiv) element).getContent());
            } else if (element instanceof PdfPTable) {
                totalWidth = ((PdfPTable) element).getTotalWidth();
            } else if (element instanceof Paragraph) {
                float f2 = 0.0f;
                for (Element element2 : (Paragraph) element) {
                    if (element2 instanceof Chunk) {
                        Chunk chunk = (Chunk) element2;
                        HashMap<String, Object> attributes = chunk.getAttributes();
                        if (attributes == null || !attributes.containsKey(Chunk.IMAGE)) {
                            widestWord = getCssAppliers().getChunkCssAplier().getWidestWord(chunk);
                        } else {
                            Object obj = attributes.get(Chunk.IMAGE);
                            if (obj instanceof Object[]) {
                                Object obj2 = ((Object[]) obj)[0];
                                if (obj2 instanceof Image) {
                                    widestWord = ((Image) obj2).getWidth();
                                } else {
                                    widestWord = 0.0f;
                                }
                            } else {
                                widestWord = 0.0f;
                            }
                        }
                    } else {
                        widestWord = 0.0f;
                    }
                    if (widestWord > f2) {
                        f2 = widestWord;
                    }
                }
                totalWidth = f2;
            } else {
                totalWidth = 0.0f;
            }
            if (totalWidth > f) {
                f = totalWidth;
            }
        }
        return f;
    }

    private float calculateTargetWidth(Tag tag, float[] fArr, float f, WorkerContext workerContext) {
        HtmlPipelineContext htmlPipelineContext = getHtmlPipelineContext(workerContext);
        float width = htmlPipelineContext.getPageSize().getWidth() - f;
        float tableWidth = getTableWidth(fArr, 0.0f);
        if (tag.getAttributes().get("width") != null || tag.getCSS().get("width") != null) {
            float width2 = new WidthCalculator().getWidth(tag, htmlPipelineContext.getRootTags(), htmlPipelineContext.getPageSize().getWidth());
            return width2 > width ? width : width2;
        }
        if (tableWidth <= width) {
            return tableWidth;
        }
        if (tag.getParent() != null) {
            return (tag.getParent() == null || !htmlPipelineContext.getRootTags().contains(tag.getParent().getName())) ? getTableWidth(fArr, f) : width;
        }
        return width;
    }

    public static float getBorderOrCellSpacing(boolean z, Map<String, String> map, Map<String, String> map2) {
        String str = map.get(CSS.Property.BORDER_COLLAPSE);
        if (str != null && !str.equals(CSS.Value.SEPARATE)) {
            str.equals(CSS.Value.COLLAPSE);
            return 0.0f;
        }
        String str2 = map.get(CSS.Property.BORDER_SPACING);
        String str3 = map2.get(HTML.Attribute.CELLSPACING);
        if (str2 != null) {
            if (str2.contains(" ")) {
                return z ? utils.parsePxInCmMmPcToPt(str2.split(" ")[0]) : utils.parsePxInCmMmPcToPt(str2.split(" ")[1]);
            }
            return utils.parsePxInCmMmPcToPt(str2);
        }
        if (str3 != null) {
            return utils.parsePxInCmMmPcToPt(str3);
        }
        return 1.5f;
    }

    private float getCellStartWidth(HtmlCell htmlCell) {
        return ((htmlCell.getColspan() - 1) * htmlCell.getCellValues().getHorBorderSpacing()) + htmlCell.getPaddingLeft() + htmlCell.getPaddingRight();
    }

    private float getTableOuterWidth(Tag tag, float f, WorkerContext workerContext) {
        CssUtils cssUtils = utils;
        float leftAndRightMargin = cssUtils.getLeftAndRightMargin(tag, getHtmlPipelineContext(workerContext).getPageSize().getWidth()) + cssUtils.checkMetricStyle(tag, CSS.Property.BORDER_LEFT_WIDTH) + cssUtils.checkMetricStyle(tag, CSS.Property.BORDER_RIGHT_WIDTH) + f;
        Tag parent = tag.getParent();
        return parent != null ? leftAndRightMargin + cssUtils.getLeftAndRightMargin(parent, getHtmlPipelineContext(workerContext).getPageSize().getWidth()) : leftAndRightMargin;
    }

    private float getTableWidth(float[] fArr, float f) {
        float f2 = 0.0f;
        for (float f3 : fArr) {
            f2 += f3;
        }
        return f2 + f;
    }

    public static TableStyleValues setBorderAttributeForCell(Tag tag) {
        TableStyleValues tableStyleValues = new TableStyleValues();
        if (tag == null) {
            return tableStyleValues;
        }
        Map<String, String> attributes = tag.getAttributes();
        Map<String, String> css = tag.getCSS();
        String str = attributes.get("border");
        if (str != null && (str.trim().length() == 0 || utils.parsePxInCmMmPcToPt(attributes.get("border")) > 0.0f)) {
            tableStyleValues.setBorderColor(BaseColor.BLACK);
            tableStyleValues.setBorderWidth(0.75f);
        }
        tableStyleValues.setHorBorderSpacing(getBorderOrCellSpacing(true, css, attributes));
        tableStyleValues.setVerBorderSpacing(getBorderOrCellSpacing(false, css, attributes));
        return tableStyleValues;
    }

    private float[] setCellWidthAndWidestWord(HtmlCell htmlCell) {
        Iterator<Element> it;
        int i = 1;
        ArrayList<Float> arrayList = new ArrayList();
        float cellStartWidth = getCellStartWidth(htmlCell);
        List<Element> compositeElements = htmlCell.getCompositeElements();
        float f = 0.0f;
        if (compositeElements != null) {
            Iterator<Element> it2 = compositeElements.iterator();
            while (it2.hasNext()) {
                Element next = it2.next();
                if (next instanceof Phrase) {
                    float widthPoint = Float.NaN;
                    int i2 = 0;
                    while (true) {
                        Phrase phrase = (Phrase) next;
                        if (i2 >= phrase.size()) {
                            break;
                        }
                        Element element = phrase.get(i2);
                        if (element instanceof Chunk) {
                            if (Float.isNaN(widthPoint)) {
                                widthPoint = cellStartWidth + 0.001f;
                            }
                            Chunk chunk = (Chunk) element;
                            widthPoint += chunk.getWidthPoint();
                            float widestWord = cellStartWidth + 0.001f + getCssAppliers().getChunkCssAplier().getWidestWord(chunk);
                            if (widestWord > f) {
                                f = widestWord;
                            }
                        }
                        i2 += i;
                    }
                    if (!Float.isNaN(widthPoint)) {
                        arrayList.add(Float.valueOf(widthPoint));
                    }
                } else {
                    if (next instanceof com.itextpdf.text.List) {
                        for (Element element2 : ((com.itextpdf.text.List) next).getItems()) {
                            float f2 = cellStartWidth + 0.001f;
                            float indentationLeft = ((ListItem) element2).getIndentationLeft() + f2;
                            for (Chunk chunk2 : element2.getChunks()) {
                                indentationLeft += chunk2.getWidthPoint();
                                float widestWord2 = getCssAppliers().getChunkCssAplier().getWidestWord(chunk2) + f2;
                                if (widestWord2 > f) {
                                    f = widestWord2;
                                }
                            }
                            arrayList.add(Float.valueOf(indentationLeft));
                        }
                    } else if (next instanceof PdfPTable) {
                        PdfPTable pdfPTable = (PdfPTable) next;
                        float totalWidth = 0.001f + cellStartWidth + pdfPTable.getTotalWidth();
                        for (PdfPRow pdfPRow : pdfPTable.getRows()) {
                            int length = pdfPRow.getCells().length;
                            TableStyleValues tableStyleValues = ((TableBorderEvent) pdfPTable.getTableEvent()).getTableStyleValues();
                            float borderWidthLeft = tableStyleValues.getBorderWidthLeft() + ((length + 1) * tableStyleValues.getHorBorderSpacing()) + tableStyleValues.getBorderWidthRight();
                            PdfPCell[] cells = pdfPRow.getCells();
                            int length2 = cells.length;
                            int i3 = 0;
                            int i4 = 0;
                            while (i3 < length2) {
                                PdfPCell pdfPCell = cells[i3];
                                i4 += i;
                                if (pdfPCell != null) {
                                    i = 1;
                                    borderWidthLeft += setCellWidthAndWidestWord(new HtmlCell(pdfPCell, i4 == length))[1];
                                }
                                i3 += i;
                                it2 = it2;
                            }
                            Iterator<Element> it3 = it2;
                            if (borderWidthLeft > f) {
                                f = borderWidthLeft;
                            }
                            it2 = it3;
                            i = 1;
                        }
                        it = it2;
                        arrayList.add(Float.valueOf(totalWidth));
                    } else {
                        it = it2;
                        if (next instanceof PdfDiv) {
                            PdfDiv pdfDiv = (PdfDiv) next;
                            arrayList.add(Float.valueOf(0.001f + cellStartWidth + (pdfDiv.getWidth() != null ? pdfDiv.getWidth().floatValue() : calculateDivWidestElementWidth(pdfDiv.getContent()))));
                        }
                    }
                    it2 = it;
                    i = 1;
                }
                it = it2;
                it2 = it;
                i = 1;
            }
        }
        for (Float f3 : arrayList) {
            if (f3.floatValue() > cellStartWidth) {
                cellStartWidth = f3.floatValue();
            }
        }
        return new float[]{cellStartWidth, f};
    }

    public static TableStyleValues setStyleValues(Tag tag) {
        TableStyleValues tableStyleValues = new TableStyleValues();
        Map<String, String> css = tag.getCSS();
        Map<String, String> attributes = tag.getAttributes();
        if (attributes.containsKey("border")) {
            tableStyleValues.setBorderColor(BaseColor.BLACK);
            String str = attributes.get("border");
            if ("".equals(str)) {
                tableStyleValues.setBorderWidth(0.75f);
            } else {
                tableStyleValues.setBorderWidth(utils.parsePxInCmMmPcToPt(str));
            }
        } else {
            for (Map.Entry<String, String> entry : css.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key.equalsIgnoreCase(CSS.Property.BORDER_LEFT_STYLE) && CSS.Value.SOLID.equalsIgnoreCase(value)) {
                    tableStyleValues.setBorderColorLeft(BaseColor.BLACK);
                    tableStyleValues.setBorderWidthLeft(0.75f);
                } else if (key.equalsIgnoreCase(CSS.Property.BORDER_RIGHT_STYLE) && CSS.Value.SOLID.equalsIgnoreCase(value)) {
                    tableStyleValues.setBorderColorRight(BaseColor.BLACK);
                    tableStyleValues.setBorderWidthRight(0.75f);
                } else if (key.equalsIgnoreCase(CSS.Property.BORDER_TOP_STYLE) && CSS.Value.SOLID.equalsIgnoreCase(value)) {
                    tableStyleValues.setBorderColorTop(BaseColor.BLACK);
                    tableStyleValues.setBorderWidthTop(0.75f);
                } else if (key.equalsIgnoreCase(CSS.Property.BORDER_BOTTOM_STYLE) && CSS.Value.SOLID.equalsIgnoreCase(value)) {
                    tableStyleValues.setBorderColorBottom(BaseColor.BLACK);
                    tableStyleValues.setBorderWidthBottom(0.75f);
                }
            }
            String str2 = css.get(CSS.Property.BORDER_BOTTOM_COLOR);
            if (str2 != null) {
                tableStyleValues.setBorderColorBottom(HtmlUtilities.decodeColor(str2));
            }
            String str3 = css.get(CSS.Property.BORDER_TOP_COLOR);
            if (str3 != null) {
                tableStyleValues.setBorderColorTop(HtmlUtilities.decodeColor(str3));
            }
            String str4 = css.get(CSS.Property.BORDER_LEFT_COLOR);
            if (str4 != null) {
                tableStyleValues.setBorderColorLeft(HtmlUtilities.decodeColor(str4));
            }
            String str5 = css.get(CSS.Property.BORDER_RIGHT_COLOR);
            if (str5 != null) {
                tableStyleValues.setBorderColorRight(HtmlUtilities.decodeColor(str5));
            }
            CssUtils cssUtils = utils;
            Float fCheckMetricStyle = cssUtils.checkMetricStyle(css, CSS.Property.BORDER_BOTTOM_WIDTH);
            if (fCheckMetricStyle != null) {
                tableStyleValues.setBorderWidthBottom(fCheckMetricStyle.floatValue());
            }
            Float fCheckMetricStyle2 = cssUtils.checkMetricStyle(css, CSS.Property.BORDER_TOP_WIDTH);
            if (fCheckMetricStyle2 != null) {
                tableStyleValues.setBorderWidthTop(fCheckMetricStyle2.floatValue());
            }
            Float fCheckMetricStyle3 = cssUtils.checkMetricStyle(css, CSS.Property.BORDER_RIGHT_WIDTH);
            if (fCheckMetricStyle3 != null) {
                tableStyleValues.setBorderWidthRight(fCheckMetricStyle3.floatValue());
            }
            Float fCheckMetricStyle4 = cssUtils.checkMetricStyle(css, CSS.Property.BORDER_LEFT_WIDTH);
            if (fCheckMetricStyle4 != null) {
                tableStyleValues.setBorderWidthLeft(fCheckMetricStyle4.floatValue());
            }
        }
        tableStyleValues.setBackground(HtmlUtilities.decodeColor(css.get(CSS.Property.BACKGROUND_COLOR)));
        tableStyleValues.setHorBorderSpacing(getBorderOrCellSpacing(true, css, attributes));
        tableStyleValues.setVerBorderSpacing(getBorderOrCellSpacing(false, css, attributes));
        return tableStyleValues;
    }

    private void setVerticalMargin(PdfPTable pdfPTable, Tag tag, TableStyleValues tableStyleValues, WorkerContext workerContext) {
        float borderWidthTop = tableStyleValues.getBorderWidthTop();
        float verBorderSpacing = tableStyleValues.getVerBorderSpacing() + tableStyleValues.getBorderWidthBottom();
        for (Map.Entry<String, String> entry : tag.getCSS().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (CSS.Property.MARGIN_TOP.equalsIgnoreCase(key)) {
                borderWidthTop += CssUtils.getInstance().calculateMarginTop(value, fst.getFontSize(tag), getHtmlPipelineContext(workerContext));
            } else if (CSS.Property.MARGIN_BOTTOM.equalsIgnoreCase(key)) {
                float valueToPt = utils.parseValueToPt(value, fst.getFontSize(tag));
                verBorderSpacing += valueToPt;
                getHtmlPipelineContext(workerContext).getMemory().put(HtmlPipelineContext.LAST_MARGIN_BOTTOM, Float.valueOf(valueToPt));
            } else if (CSS.Property.PADDING_TOP.equalsIgnoreCase(key)) {
                pdfPTable.setPaddingTop(utils.parseValueToPt(value, fst.getFontSize(tag)));
            }
        }
        pdfPTable.setSpacingBefore(borderWidthTop);
        pdfPTable.setSpacingAfter(verBorderSpacing);
    }

    private void widenLastCell(List<TableRowElement> list, float f) {
        Iterator<TableRowElement> it = list.iterator();
        while (it.hasNext()) {
            List<HtmlCell> content = it.next().getContent();
            if (content.size() >= 1) {
                HtmlCell htmlCell = content.get(content.size() - 1);
                htmlCell.getCellValues().setLastInRow(true);
                htmlCell.setPaddingRight(htmlCell.getPaddingRight() + f);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:218:0x043f A[PHI: r11
      0x043f: PHI (r11v12 float) = (r11v11 float), (r11v11 float), (r11v15 float) binds: [B:212:0x042a, B:214:0x0432, B:217:0x043a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:240:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:244:0x04c6 A[Catch: NoCustomContextException -> 0x009f, TryCatch #1 {NoCustomContextException -> 0x009f, blocks: (B:19:0x007b, B:21:0x007f, B:22:0x008c, B:24:0x0092, B:29:0x00a7, B:31:0x00ac, B:33:0x00b2, B:35:0x00be, B:37:0x00c3, B:39:0x00c9, B:41:0x00d5, B:42:0x00d8, B:48:0x00f0, B:51:0x00f7, B:53:0x0108, B:55:0x011e, B:56:0x012f, B:57:0x0142, B:59:0x0148, B:61:0x015c, B:63:0x016a, B:64:0x016f, B:65:0x019b, B:67:0x01a1, B:68:0x01b9, B:70:0x01bf, B:72:0x01cd, B:74:0x01d1, B:75:0x01dc, B:77:0x01e7, B:80:0x01ed, B:81:0x01f4, B:83:0x0202, B:84:0x0215, B:87:0x021b, B:89:0x0225, B:91:0x022a, B:95:0x0231, B:97:0x0239, B:100:0x024b, B:102:0x0253, B:104:0x0259, B:106:0x0269, B:131:0x02b0, B:110:0x0271, B:112:0x0279, B:114:0x027f, B:125:0x029e, B:127:0x02a4, B:128:0x02a7, B:130:0x02ad, B:134:0x02b9, B:136:0x02c3, B:137:0x02de, B:138:0x02e1, B:147:0x0312, B:150:0x031e, B:152:0x0342, B:173:0x039a, B:175:0x03a2, B:179:0x03ab, B:234:0x047d, B:235:0x048b, B:237:0x04a2, B:239:0x04ab, B:241:0x04bb, B:242:0x04c0, B:244:0x04c6, B:247:0x04d8, B:248:0x04dd, B:250:0x04e3, B:252:0x04ef, B:253:0x04f3, B:255:0x04f9, B:257:0x0503, B:259:0x050d, B:261:0x051a, B:262:0x052d, B:264:0x0535, B:265:0x053c, B:260:0x0516, B:267:0x055e, B:268:0x0569, B:273:0x0573, B:275:0x057c, B:277:0x058c, B:279:0x059a, B:281:0x05a2, B:284:0x05c1, B:286:0x05c7, B:287:0x05d6, B:289:0x05e1, B:290:0x05ed, B:292:0x05f9, B:294:0x0603, B:295:0x0610, B:297:0x061e, B:299:0x0626, B:300:0x062f, B:301:0x0638, B:304:0x063d, B:186:0x03c4, B:187:0x03cd, B:191:0x03da, B:193:0x03e1, B:195:0x03eb, B:201:0x0409, B:196:0x03f0, B:198:0x03fa, B:200:0x0400, B:204:0x0410, B:206:0x041a, B:211:0x0426, B:213:0x042c, B:215:0x0434, B:217:0x043a, B:219:0x0441, B:220:0x0446, B:222:0x044a, B:224:0x045e, B:229:0x046a, B:231:0x0471, B:160:0x0357, B:162:0x035d, B:164:0x0363, B:167:0x0376, B:168:0x037b, B:52:0x0100), top: B:313:0x007b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:250:0x04e3 A[Catch: NoCustomContextException -> 0x009f, TryCatch #1 {NoCustomContextException -> 0x009f, blocks: (B:19:0x007b, B:21:0x007f, B:22:0x008c, B:24:0x0092, B:29:0x00a7, B:31:0x00ac, B:33:0x00b2, B:35:0x00be, B:37:0x00c3, B:39:0x00c9, B:41:0x00d5, B:42:0x00d8, B:48:0x00f0, B:51:0x00f7, B:53:0x0108, B:55:0x011e, B:56:0x012f, B:57:0x0142, B:59:0x0148, B:61:0x015c, B:63:0x016a, B:64:0x016f, B:65:0x019b, B:67:0x01a1, B:68:0x01b9, B:70:0x01bf, B:72:0x01cd, B:74:0x01d1, B:75:0x01dc, B:77:0x01e7, B:80:0x01ed, B:81:0x01f4, B:83:0x0202, B:84:0x0215, B:87:0x021b, B:89:0x0225, B:91:0x022a, B:95:0x0231, B:97:0x0239, B:100:0x024b, B:102:0x0253, B:104:0x0259, B:106:0x0269, B:131:0x02b0, B:110:0x0271, B:112:0x0279, B:114:0x027f, B:125:0x029e, B:127:0x02a4, B:128:0x02a7, B:130:0x02ad, B:134:0x02b9, B:136:0x02c3, B:137:0x02de, B:138:0x02e1, B:147:0x0312, B:150:0x031e, B:152:0x0342, B:173:0x039a, B:175:0x03a2, B:179:0x03ab, B:234:0x047d, B:235:0x048b, B:237:0x04a2, B:239:0x04ab, B:241:0x04bb, B:242:0x04c0, B:244:0x04c6, B:247:0x04d8, B:248:0x04dd, B:250:0x04e3, B:252:0x04ef, B:253:0x04f3, B:255:0x04f9, B:257:0x0503, B:259:0x050d, B:261:0x051a, B:262:0x052d, B:264:0x0535, B:265:0x053c, B:260:0x0516, B:267:0x055e, B:268:0x0569, B:273:0x0573, B:275:0x057c, B:277:0x058c, B:279:0x059a, B:281:0x05a2, B:284:0x05c1, B:286:0x05c7, B:287:0x05d6, B:289:0x05e1, B:290:0x05ed, B:292:0x05f9, B:294:0x0603, B:295:0x0610, B:297:0x061e, B:299:0x0626, B:300:0x062f, B:301:0x0638, B:304:0x063d, B:186:0x03c4, B:187:0x03cd, B:191:0x03da, B:193:0x03e1, B:195:0x03eb, B:201:0x0409, B:196:0x03f0, B:198:0x03fa, B:200:0x0400, B:204:0x0410, B:206:0x041a, B:211:0x0426, B:213:0x042c, B:215:0x0434, B:217:0x043a, B:219:0x0441, B:220:0x0446, B:222:0x044a, B:224:0x045e, B:229:0x046a, B:231:0x0471, B:160:0x0357, B:162:0x035d, B:164:0x0363, B:167:0x0376, B:168:0x037b, B:52:0x0100), top: B:313:0x007b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:252:0x04ef A[Catch: NoCustomContextException -> 0x009f, TryCatch #1 {NoCustomContextException -> 0x009f, blocks: (B:19:0x007b, B:21:0x007f, B:22:0x008c, B:24:0x0092, B:29:0x00a7, B:31:0x00ac, B:33:0x00b2, B:35:0x00be, B:37:0x00c3, B:39:0x00c9, B:41:0x00d5, B:42:0x00d8, B:48:0x00f0, B:51:0x00f7, B:53:0x0108, B:55:0x011e, B:56:0x012f, B:57:0x0142, B:59:0x0148, B:61:0x015c, B:63:0x016a, B:64:0x016f, B:65:0x019b, B:67:0x01a1, B:68:0x01b9, B:70:0x01bf, B:72:0x01cd, B:74:0x01d1, B:75:0x01dc, B:77:0x01e7, B:80:0x01ed, B:81:0x01f4, B:83:0x0202, B:84:0x0215, B:87:0x021b, B:89:0x0225, B:91:0x022a, B:95:0x0231, B:97:0x0239, B:100:0x024b, B:102:0x0253, B:104:0x0259, B:106:0x0269, B:131:0x02b0, B:110:0x0271, B:112:0x0279, B:114:0x027f, B:125:0x029e, B:127:0x02a4, B:128:0x02a7, B:130:0x02ad, B:134:0x02b9, B:136:0x02c3, B:137:0x02de, B:138:0x02e1, B:147:0x0312, B:150:0x031e, B:152:0x0342, B:173:0x039a, B:175:0x03a2, B:179:0x03ab, B:234:0x047d, B:235:0x048b, B:237:0x04a2, B:239:0x04ab, B:241:0x04bb, B:242:0x04c0, B:244:0x04c6, B:247:0x04d8, B:248:0x04dd, B:250:0x04e3, B:252:0x04ef, B:253:0x04f3, B:255:0x04f9, B:257:0x0503, B:259:0x050d, B:261:0x051a, B:262:0x052d, B:264:0x0535, B:265:0x053c, B:260:0x0516, B:267:0x055e, B:268:0x0569, B:273:0x0573, B:275:0x057c, B:277:0x058c, B:279:0x059a, B:281:0x05a2, B:284:0x05c1, B:286:0x05c7, B:287:0x05d6, B:289:0x05e1, B:290:0x05ed, B:292:0x05f9, B:294:0x0603, B:295:0x0610, B:297:0x061e, B:299:0x0626, B:300:0x062f, B:301:0x0638, B:304:0x063d, B:186:0x03c4, B:187:0x03cd, B:191:0x03da, B:193:0x03e1, B:195:0x03eb, B:201:0x0409, B:196:0x03f0, B:198:0x03fa, B:200:0x0400, B:204:0x0410, B:206:0x041a, B:211:0x0426, B:213:0x042c, B:215:0x0434, B:217:0x043a, B:219:0x0441, B:220:0x0446, B:222:0x044a, B:224:0x045e, B:229:0x046a, B:231:0x0471, B:160:0x0357, B:162:0x035d, B:164:0x0363, B:167:0x0376, B:168:0x037b, B:52:0x0100), top: B:313:0x007b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:255:0x04f9 A[Catch: NoCustomContextException -> 0x009f, TryCatch #1 {NoCustomContextException -> 0x009f, blocks: (B:19:0x007b, B:21:0x007f, B:22:0x008c, B:24:0x0092, B:29:0x00a7, B:31:0x00ac, B:33:0x00b2, B:35:0x00be, B:37:0x00c3, B:39:0x00c9, B:41:0x00d5, B:42:0x00d8, B:48:0x00f0, B:51:0x00f7, B:53:0x0108, B:55:0x011e, B:56:0x012f, B:57:0x0142, B:59:0x0148, B:61:0x015c, B:63:0x016a, B:64:0x016f, B:65:0x019b, B:67:0x01a1, B:68:0x01b9, B:70:0x01bf, B:72:0x01cd, B:74:0x01d1, B:75:0x01dc, B:77:0x01e7, B:80:0x01ed, B:81:0x01f4, B:83:0x0202, B:84:0x0215, B:87:0x021b, B:89:0x0225, B:91:0x022a, B:95:0x0231, B:97:0x0239, B:100:0x024b, B:102:0x0253, B:104:0x0259, B:106:0x0269, B:131:0x02b0, B:110:0x0271, B:112:0x0279, B:114:0x027f, B:125:0x029e, B:127:0x02a4, B:128:0x02a7, B:130:0x02ad, B:134:0x02b9, B:136:0x02c3, B:137:0x02de, B:138:0x02e1, B:147:0x0312, B:150:0x031e, B:152:0x0342, B:173:0x039a, B:175:0x03a2, B:179:0x03ab, B:234:0x047d, B:235:0x048b, B:237:0x04a2, B:239:0x04ab, B:241:0x04bb, B:242:0x04c0, B:244:0x04c6, B:247:0x04d8, B:248:0x04dd, B:250:0x04e3, B:252:0x04ef, B:253:0x04f3, B:255:0x04f9, B:257:0x0503, B:259:0x050d, B:261:0x051a, B:262:0x052d, B:264:0x0535, B:265:0x053c, B:260:0x0516, B:267:0x055e, B:268:0x0569, B:273:0x0573, B:275:0x057c, B:277:0x058c, B:279:0x059a, B:281:0x05a2, B:284:0x05c1, B:286:0x05c7, B:287:0x05d6, B:289:0x05e1, B:290:0x05ed, B:292:0x05f9, B:294:0x0603, B:295:0x0610, B:297:0x061e, B:299:0x0626, B:300:0x062f, B:301:0x0638, B:304:0x063d, B:186:0x03c4, B:187:0x03cd, B:191:0x03da, B:193:0x03e1, B:195:0x03eb, B:201:0x0409, B:196:0x03f0, B:198:0x03fa, B:200:0x0400, B:204:0x0410, B:206:0x041a, B:211:0x0426, B:213:0x042c, B:215:0x0434, B:217:0x043a, B:219:0x0441, B:220:0x0446, B:222:0x044a, B:224:0x045e, B:229:0x046a, B:231:0x0471, B:160:0x0357, B:162:0x035d, B:164:0x0363, B:167:0x0376, B:168:0x037b, B:52:0x0100), top: B:313:0x007b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:257:0x0503 A[Catch: NoCustomContextException -> 0x009f, TryCatch #1 {NoCustomContextException -> 0x009f, blocks: (B:19:0x007b, B:21:0x007f, B:22:0x008c, B:24:0x0092, B:29:0x00a7, B:31:0x00ac, B:33:0x00b2, B:35:0x00be, B:37:0x00c3, B:39:0x00c9, B:41:0x00d5, B:42:0x00d8, B:48:0x00f0, B:51:0x00f7, B:53:0x0108, B:55:0x011e, B:56:0x012f, B:57:0x0142, B:59:0x0148, B:61:0x015c, B:63:0x016a, B:64:0x016f, B:65:0x019b, B:67:0x01a1, B:68:0x01b9, B:70:0x01bf, B:72:0x01cd, B:74:0x01d1, B:75:0x01dc, B:77:0x01e7, B:80:0x01ed, B:81:0x01f4, B:83:0x0202, B:84:0x0215, B:87:0x021b, B:89:0x0225, B:91:0x022a, B:95:0x0231, B:97:0x0239, B:100:0x024b, B:102:0x0253, B:104:0x0259, B:106:0x0269, B:131:0x02b0, B:110:0x0271, B:112:0x0279, B:114:0x027f, B:125:0x029e, B:127:0x02a4, B:128:0x02a7, B:130:0x02ad, B:134:0x02b9, B:136:0x02c3, B:137:0x02de, B:138:0x02e1, B:147:0x0312, B:150:0x031e, B:152:0x0342, B:173:0x039a, B:175:0x03a2, B:179:0x03ab, B:234:0x047d, B:235:0x048b, B:237:0x04a2, B:239:0x04ab, B:241:0x04bb, B:242:0x04c0, B:244:0x04c6, B:247:0x04d8, B:248:0x04dd, B:250:0x04e3, B:252:0x04ef, B:253:0x04f3, B:255:0x04f9, B:257:0x0503, B:259:0x050d, B:261:0x051a, B:262:0x052d, B:264:0x0535, B:265:0x053c, B:260:0x0516, B:267:0x055e, B:268:0x0569, B:273:0x0573, B:275:0x057c, B:277:0x058c, B:279:0x059a, B:281:0x05a2, B:284:0x05c1, B:286:0x05c7, B:287:0x05d6, B:289:0x05e1, B:290:0x05ed, B:292:0x05f9, B:294:0x0603, B:295:0x0610, B:297:0x061e, B:299:0x0626, B:300:0x062f, B:301:0x0638, B:304:0x063d, B:186:0x03c4, B:187:0x03cd, B:191:0x03da, B:193:0x03e1, B:195:0x03eb, B:201:0x0409, B:196:0x03f0, B:198:0x03fa, B:200:0x0400, B:204:0x0410, B:206:0x041a, B:211:0x0426, B:213:0x042c, B:215:0x0434, B:217:0x043a, B:219:0x0441, B:220:0x0446, B:222:0x044a, B:224:0x045e, B:229:0x046a, B:231:0x0471, B:160:0x0357, B:162:0x035d, B:164:0x0363, B:167:0x0376, B:168:0x037b, B:52:0x0100), top: B:313:0x007b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:259:0x050d A[Catch: NoCustomContextException -> 0x009f, TryCatch #1 {NoCustomContextException -> 0x009f, blocks: (B:19:0x007b, B:21:0x007f, B:22:0x008c, B:24:0x0092, B:29:0x00a7, B:31:0x00ac, B:33:0x00b2, B:35:0x00be, B:37:0x00c3, B:39:0x00c9, B:41:0x00d5, B:42:0x00d8, B:48:0x00f0, B:51:0x00f7, B:53:0x0108, B:55:0x011e, B:56:0x012f, B:57:0x0142, B:59:0x0148, B:61:0x015c, B:63:0x016a, B:64:0x016f, B:65:0x019b, B:67:0x01a1, B:68:0x01b9, B:70:0x01bf, B:72:0x01cd, B:74:0x01d1, B:75:0x01dc, B:77:0x01e7, B:80:0x01ed, B:81:0x01f4, B:83:0x0202, B:84:0x0215, B:87:0x021b, B:89:0x0225, B:91:0x022a, B:95:0x0231, B:97:0x0239, B:100:0x024b, B:102:0x0253, B:104:0x0259, B:106:0x0269, B:131:0x02b0, B:110:0x0271, B:112:0x0279, B:114:0x027f, B:125:0x029e, B:127:0x02a4, B:128:0x02a7, B:130:0x02ad, B:134:0x02b9, B:136:0x02c3, B:137:0x02de, B:138:0x02e1, B:147:0x0312, B:150:0x031e, B:152:0x0342, B:173:0x039a, B:175:0x03a2, B:179:0x03ab, B:234:0x047d, B:235:0x048b, B:237:0x04a2, B:239:0x04ab, B:241:0x04bb, B:242:0x04c0, B:244:0x04c6, B:247:0x04d8, B:248:0x04dd, B:250:0x04e3, B:252:0x04ef, B:253:0x04f3, B:255:0x04f9, B:257:0x0503, B:259:0x050d, B:261:0x051a, B:262:0x052d, B:264:0x0535, B:265:0x053c, B:260:0x0516, B:267:0x055e, B:268:0x0569, B:273:0x0573, B:275:0x057c, B:277:0x058c, B:279:0x059a, B:281:0x05a2, B:284:0x05c1, B:286:0x05c7, B:287:0x05d6, B:289:0x05e1, B:290:0x05ed, B:292:0x05f9, B:294:0x0603, B:295:0x0610, B:297:0x061e, B:299:0x0626, B:300:0x062f, B:301:0x0638, B:304:0x063d, B:186:0x03c4, B:187:0x03cd, B:191:0x03da, B:193:0x03e1, B:195:0x03eb, B:201:0x0409, B:196:0x03f0, B:198:0x03fa, B:200:0x0400, B:204:0x0410, B:206:0x041a, B:211:0x0426, B:213:0x042c, B:215:0x0434, B:217:0x043a, B:219:0x0441, B:220:0x0446, B:222:0x044a, B:224:0x045e, B:229:0x046a, B:231:0x0471, B:160:0x0357, B:162:0x035d, B:164:0x0363, B:167:0x0376, B:168:0x037b, B:52:0x0100), top: B:313:0x007b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:260:0x0516 A[Catch: NoCustomContextException -> 0x009f, TryCatch #1 {NoCustomContextException -> 0x009f, blocks: (B:19:0x007b, B:21:0x007f, B:22:0x008c, B:24:0x0092, B:29:0x00a7, B:31:0x00ac, B:33:0x00b2, B:35:0x00be, B:37:0x00c3, B:39:0x00c9, B:41:0x00d5, B:42:0x00d8, B:48:0x00f0, B:51:0x00f7, B:53:0x0108, B:55:0x011e, B:56:0x012f, B:57:0x0142, B:59:0x0148, B:61:0x015c, B:63:0x016a, B:64:0x016f, B:65:0x019b, B:67:0x01a1, B:68:0x01b9, B:70:0x01bf, B:72:0x01cd, B:74:0x01d1, B:75:0x01dc, B:77:0x01e7, B:80:0x01ed, B:81:0x01f4, B:83:0x0202, B:84:0x0215, B:87:0x021b, B:89:0x0225, B:91:0x022a, B:95:0x0231, B:97:0x0239, B:100:0x024b, B:102:0x0253, B:104:0x0259, B:106:0x0269, B:131:0x02b0, B:110:0x0271, B:112:0x0279, B:114:0x027f, B:125:0x029e, B:127:0x02a4, B:128:0x02a7, B:130:0x02ad, B:134:0x02b9, B:136:0x02c3, B:137:0x02de, B:138:0x02e1, B:147:0x0312, B:150:0x031e, B:152:0x0342, B:173:0x039a, B:175:0x03a2, B:179:0x03ab, B:234:0x047d, B:235:0x048b, B:237:0x04a2, B:239:0x04ab, B:241:0x04bb, B:242:0x04c0, B:244:0x04c6, B:247:0x04d8, B:248:0x04dd, B:250:0x04e3, B:252:0x04ef, B:253:0x04f3, B:255:0x04f9, B:257:0x0503, B:259:0x050d, B:261:0x051a, B:262:0x052d, B:264:0x0535, B:265:0x053c, B:260:0x0516, B:267:0x055e, B:268:0x0569, B:273:0x0573, B:275:0x057c, B:277:0x058c, B:279:0x059a, B:281:0x05a2, B:284:0x05c1, B:286:0x05c7, B:287:0x05d6, B:289:0x05e1, B:290:0x05ed, B:292:0x05f9, B:294:0x0603, B:295:0x0610, B:297:0x061e, B:299:0x0626, B:300:0x062f, B:301:0x0638, B:304:0x063d, B:186:0x03c4, B:187:0x03cd, B:191:0x03da, B:193:0x03e1, B:195:0x03eb, B:201:0x0409, B:196:0x03f0, B:198:0x03fa, B:200:0x0400, B:204:0x0410, B:206:0x041a, B:211:0x0426, B:213:0x042c, B:215:0x0434, B:217:0x043a, B:219:0x0441, B:220:0x0446, B:222:0x044a, B:224:0x045e, B:229:0x046a, B:231:0x0471, B:160:0x0357, B:162:0x035d, B:164:0x0363, B:167:0x0376, B:168:0x037b, B:52:0x0100), top: B:313:0x007b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:264:0x0535 A[Catch: NoCustomContextException -> 0x009f, LOOP:14: B:262:0x052d->B:264:0x0535, LOOP_END, TryCatch #1 {NoCustomContextException -> 0x009f, blocks: (B:19:0x007b, B:21:0x007f, B:22:0x008c, B:24:0x0092, B:29:0x00a7, B:31:0x00ac, B:33:0x00b2, B:35:0x00be, B:37:0x00c3, B:39:0x00c9, B:41:0x00d5, B:42:0x00d8, B:48:0x00f0, B:51:0x00f7, B:53:0x0108, B:55:0x011e, B:56:0x012f, B:57:0x0142, B:59:0x0148, B:61:0x015c, B:63:0x016a, B:64:0x016f, B:65:0x019b, B:67:0x01a1, B:68:0x01b9, B:70:0x01bf, B:72:0x01cd, B:74:0x01d1, B:75:0x01dc, B:77:0x01e7, B:80:0x01ed, B:81:0x01f4, B:83:0x0202, B:84:0x0215, B:87:0x021b, B:89:0x0225, B:91:0x022a, B:95:0x0231, B:97:0x0239, B:100:0x024b, B:102:0x0253, B:104:0x0259, B:106:0x0269, B:131:0x02b0, B:110:0x0271, B:112:0x0279, B:114:0x027f, B:125:0x029e, B:127:0x02a4, B:128:0x02a7, B:130:0x02ad, B:134:0x02b9, B:136:0x02c3, B:137:0x02de, B:138:0x02e1, B:147:0x0312, B:150:0x031e, B:152:0x0342, B:173:0x039a, B:175:0x03a2, B:179:0x03ab, B:234:0x047d, B:235:0x048b, B:237:0x04a2, B:239:0x04ab, B:241:0x04bb, B:242:0x04c0, B:244:0x04c6, B:247:0x04d8, B:248:0x04dd, B:250:0x04e3, B:252:0x04ef, B:253:0x04f3, B:255:0x04f9, B:257:0x0503, B:259:0x050d, B:261:0x051a, B:262:0x052d, B:264:0x0535, B:265:0x053c, B:260:0x0516, B:267:0x055e, B:268:0x0569, B:273:0x0573, B:275:0x057c, B:277:0x058c, B:279:0x059a, B:281:0x05a2, B:284:0x05c1, B:286:0x05c7, B:287:0x05d6, B:289:0x05e1, B:290:0x05ed, B:292:0x05f9, B:294:0x0603, B:295:0x0610, B:297:0x061e, B:299:0x0626, B:300:0x062f, B:301:0x0638, B:304:0x063d, B:186:0x03c4, B:187:0x03cd, B:191:0x03da, B:193:0x03e1, B:195:0x03eb, B:201:0x0409, B:196:0x03f0, B:198:0x03fa, B:200:0x0400, B:204:0x0410, B:206:0x041a, B:211:0x0426, B:213:0x042c, B:215:0x0434, B:217:0x043a, B:219:0x0441, B:220:0x0446, B:222:0x044a, B:224:0x045e, B:229:0x046a, B:231:0x0471, B:160:0x0357, B:162:0x035d, B:164:0x0363, B:167:0x0376, B:168:0x037b, B:52:0x0100), top: B:313:0x007b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:270:0x056e  */
    /* JADX WARN: Code duplicated, block: B:271:0x0570  */
    /* JADX WARN: Code duplicated, block: B:277:0x058c A[Catch: NoCustomContextException -> 0x009f, TryCatch #1 {NoCustomContextException -> 0x009f, blocks: (B:19:0x007b, B:21:0x007f, B:22:0x008c, B:24:0x0092, B:29:0x00a7, B:31:0x00ac, B:33:0x00b2, B:35:0x00be, B:37:0x00c3, B:39:0x00c9, B:41:0x00d5, B:42:0x00d8, B:48:0x00f0, B:51:0x00f7, B:53:0x0108, B:55:0x011e, B:56:0x012f, B:57:0x0142, B:59:0x0148, B:61:0x015c, B:63:0x016a, B:64:0x016f, B:65:0x019b, B:67:0x01a1, B:68:0x01b9, B:70:0x01bf, B:72:0x01cd, B:74:0x01d1, B:75:0x01dc, B:77:0x01e7, B:80:0x01ed, B:81:0x01f4, B:83:0x0202, B:84:0x0215, B:87:0x021b, B:89:0x0225, B:91:0x022a, B:95:0x0231, B:97:0x0239, B:100:0x024b, B:102:0x0253, B:104:0x0259, B:106:0x0269, B:131:0x02b0, B:110:0x0271, B:112:0x0279, B:114:0x027f, B:125:0x029e, B:127:0x02a4, B:128:0x02a7, B:130:0x02ad, B:134:0x02b9, B:136:0x02c3, B:137:0x02de, B:138:0x02e1, B:147:0x0312, B:150:0x031e, B:152:0x0342, B:173:0x039a, B:175:0x03a2, B:179:0x03ab, B:234:0x047d, B:235:0x048b, B:237:0x04a2, B:239:0x04ab, B:241:0x04bb, B:242:0x04c0, B:244:0x04c6, B:247:0x04d8, B:248:0x04dd, B:250:0x04e3, B:252:0x04ef, B:253:0x04f3, B:255:0x04f9, B:257:0x0503, B:259:0x050d, B:261:0x051a, B:262:0x052d, B:264:0x0535, B:265:0x053c, B:260:0x0516, B:267:0x055e, B:268:0x0569, B:273:0x0573, B:275:0x057c, B:277:0x058c, B:279:0x059a, B:281:0x05a2, B:284:0x05c1, B:286:0x05c7, B:287:0x05d6, B:289:0x05e1, B:290:0x05ed, B:292:0x05f9, B:294:0x0603, B:295:0x0610, B:297:0x061e, B:299:0x0626, B:300:0x062f, B:301:0x0638, B:304:0x063d, B:186:0x03c4, B:187:0x03cd, B:191:0x03da, B:193:0x03e1, B:195:0x03eb, B:201:0x0409, B:196:0x03f0, B:198:0x03fa, B:200:0x0400, B:204:0x0410, B:206:0x041a, B:211:0x0426, B:213:0x042c, B:215:0x0434, B:217:0x043a, B:219:0x0441, B:220:0x0446, B:222:0x044a, B:224:0x045e, B:229:0x046a, B:231:0x0471, B:160:0x0357, B:162:0x035d, B:164:0x0363, B:167:0x0376, B:168:0x037b, B:52:0x0100), top: B:313:0x007b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:278:0x0598  */
    /* JADX WARN: Code duplicated, block: B:286:0x05c7 A[Catch: NoCustomContextException -> 0x009f, TryCatch #1 {NoCustomContextException -> 0x009f, blocks: (B:19:0x007b, B:21:0x007f, B:22:0x008c, B:24:0x0092, B:29:0x00a7, B:31:0x00ac, B:33:0x00b2, B:35:0x00be, B:37:0x00c3, B:39:0x00c9, B:41:0x00d5, B:42:0x00d8, B:48:0x00f0, B:51:0x00f7, B:53:0x0108, B:55:0x011e, B:56:0x012f, B:57:0x0142, B:59:0x0148, B:61:0x015c, B:63:0x016a, B:64:0x016f, B:65:0x019b, B:67:0x01a1, B:68:0x01b9, B:70:0x01bf, B:72:0x01cd, B:74:0x01d1, B:75:0x01dc, B:77:0x01e7, B:80:0x01ed, B:81:0x01f4, B:83:0x0202, B:84:0x0215, B:87:0x021b, B:89:0x0225, B:91:0x022a, B:95:0x0231, B:97:0x0239, B:100:0x024b, B:102:0x0253, B:104:0x0259, B:106:0x0269, B:131:0x02b0, B:110:0x0271, B:112:0x0279, B:114:0x027f, B:125:0x029e, B:127:0x02a4, B:128:0x02a7, B:130:0x02ad, B:134:0x02b9, B:136:0x02c3, B:137:0x02de, B:138:0x02e1, B:147:0x0312, B:150:0x031e, B:152:0x0342, B:173:0x039a, B:175:0x03a2, B:179:0x03ab, B:234:0x047d, B:235:0x048b, B:237:0x04a2, B:239:0x04ab, B:241:0x04bb, B:242:0x04c0, B:244:0x04c6, B:247:0x04d8, B:248:0x04dd, B:250:0x04e3, B:252:0x04ef, B:253:0x04f3, B:255:0x04f9, B:257:0x0503, B:259:0x050d, B:261:0x051a, B:262:0x052d, B:264:0x0535, B:265:0x053c, B:260:0x0516, B:267:0x055e, B:268:0x0569, B:273:0x0573, B:275:0x057c, B:277:0x058c, B:279:0x059a, B:281:0x05a2, B:284:0x05c1, B:286:0x05c7, B:287:0x05d6, B:289:0x05e1, B:290:0x05ed, B:292:0x05f9, B:294:0x0603, B:295:0x0610, B:297:0x061e, B:299:0x0626, B:300:0x062f, B:301:0x0638, B:304:0x063d, B:186:0x03c4, B:187:0x03cd, B:191:0x03da, B:193:0x03e1, B:195:0x03eb, B:201:0x0409, B:196:0x03f0, B:198:0x03fa, B:200:0x0400, B:204:0x0410, B:206:0x041a, B:211:0x0426, B:213:0x042c, B:215:0x0434, B:217:0x043a, B:219:0x0441, B:220:0x0446, B:222:0x044a, B:224:0x045e, B:229:0x046a, B:231:0x0471, B:160:0x0357, B:162:0x035d, B:164:0x0363, B:167:0x0376, B:168:0x037b, B:52:0x0100), top: B:313:0x007b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:289:0x05e1 A[Catch: NoCustomContextException -> 0x009f, TryCatch #1 {NoCustomContextException -> 0x009f, blocks: (B:19:0x007b, B:21:0x007f, B:22:0x008c, B:24:0x0092, B:29:0x00a7, B:31:0x00ac, B:33:0x00b2, B:35:0x00be, B:37:0x00c3, B:39:0x00c9, B:41:0x00d5, B:42:0x00d8, B:48:0x00f0, B:51:0x00f7, B:53:0x0108, B:55:0x011e, B:56:0x012f, B:57:0x0142, B:59:0x0148, B:61:0x015c, B:63:0x016a, B:64:0x016f, B:65:0x019b, B:67:0x01a1, B:68:0x01b9, B:70:0x01bf, B:72:0x01cd, B:74:0x01d1, B:75:0x01dc, B:77:0x01e7, B:80:0x01ed, B:81:0x01f4, B:83:0x0202, B:84:0x0215, B:87:0x021b, B:89:0x0225, B:91:0x022a, B:95:0x0231, B:97:0x0239, B:100:0x024b, B:102:0x0253, B:104:0x0259, B:106:0x0269, B:131:0x02b0, B:110:0x0271, B:112:0x0279, B:114:0x027f, B:125:0x029e, B:127:0x02a4, B:128:0x02a7, B:130:0x02ad, B:134:0x02b9, B:136:0x02c3, B:137:0x02de, B:138:0x02e1, B:147:0x0312, B:150:0x031e, B:152:0x0342, B:173:0x039a, B:175:0x03a2, B:179:0x03ab, B:234:0x047d, B:235:0x048b, B:237:0x04a2, B:239:0x04ab, B:241:0x04bb, B:242:0x04c0, B:244:0x04c6, B:247:0x04d8, B:248:0x04dd, B:250:0x04e3, B:252:0x04ef, B:253:0x04f3, B:255:0x04f9, B:257:0x0503, B:259:0x050d, B:261:0x051a, B:262:0x052d, B:264:0x0535, B:265:0x053c, B:260:0x0516, B:267:0x055e, B:268:0x0569, B:273:0x0573, B:275:0x057c, B:277:0x058c, B:279:0x059a, B:281:0x05a2, B:284:0x05c1, B:286:0x05c7, B:287:0x05d6, B:289:0x05e1, B:290:0x05ed, B:292:0x05f9, B:294:0x0603, B:295:0x0610, B:297:0x061e, B:299:0x0626, B:300:0x062f, B:301:0x0638, B:304:0x063d, B:186:0x03c4, B:187:0x03cd, B:191:0x03da, B:193:0x03e1, B:195:0x03eb, B:201:0x0409, B:196:0x03f0, B:198:0x03fa, B:200:0x0400, B:204:0x0410, B:206:0x041a, B:211:0x0426, B:213:0x042c, B:215:0x0434, B:217:0x043a, B:219:0x0441, B:220:0x0446, B:222:0x044a, B:224:0x045e, B:229:0x046a, B:231:0x0471, B:160:0x0357, B:162:0x035d, B:164:0x0363, B:167:0x0376, B:168:0x037b, B:52:0x0100), top: B:313:0x007b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:300:0x062f A[Catch: NoCustomContextException -> 0x009f, TryCatch #1 {NoCustomContextException -> 0x009f, blocks: (B:19:0x007b, B:21:0x007f, B:22:0x008c, B:24:0x0092, B:29:0x00a7, B:31:0x00ac, B:33:0x00b2, B:35:0x00be, B:37:0x00c3, B:39:0x00c9, B:41:0x00d5, B:42:0x00d8, B:48:0x00f0, B:51:0x00f7, B:53:0x0108, B:55:0x011e, B:56:0x012f, B:57:0x0142, B:59:0x0148, B:61:0x015c, B:63:0x016a, B:64:0x016f, B:65:0x019b, B:67:0x01a1, B:68:0x01b9, B:70:0x01bf, B:72:0x01cd, B:74:0x01d1, B:75:0x01dc, B:77:0x01e7, B:80:0x01ed, B:81:0x01f4, B:83:0x0202, B:84:0x0215, B:87:0x021b, B:89:0x0225, B:91:0x022a, B:95:0x0231, B:97:0x0239, B:100:0x024b, B:102:0x0253, B:104:0x0259, B:106:0x0269, B:131:0x02b0, B:110:0x0271, B:112:0x0279, B:114:0x027f, B:125:0x029e, B:127:0x02a4, B:128:0x02a7, B:130:0x02ad, B:134:0x02b9, B:136:0x02c3, B:137:0x02de, B:138:0x02e1, B:147:0x0312, B:150:0x031e, B:152:0x0342, B:173:0x039a, B:175:0x03a2, B:179:0x03ab, B:234:0x047d, B:235:0x048b, B:237:0x04a2, B:239:0x04ab, B:241:0x04bb, B:242:0x04c0, B:244:0x04c6, B:247:0x04d8, B:248:0x04dd, B:250:0x04e3, B:252:0x04ef, B:253:0x04f3, B:255:0x04f9, B:257:0x0503, B:259:0x050d, B:261:0x051a, B:262:0x052d, B:264:0x0535, B:265:0x053c, B:260:0x0516, B:267:0x055e, B:268:0x0569, B:273:0x0573, B:275:0x057c, B:277:0x058c, B:279:0x059a, B:281:0x05a2, B:284:0x05c1, B:286:0x05c7, B:287:0x05d6, B:289:0x05e1, B:290:0x05ed, B:292:0x05f9, B:294:0x0603, B:295:0x0610, B:297:0x061e, B:299:0x0626, B:300:0x062f, B:301:0x0638, B:304:0x063d, B:186:0x03c4, B:187:0x03cd, B:191:0x03da, B:193:0x03e1, B:195:0x03eb, B:201:0x0409, B:196:0x03f0, B:198:0x03fa, B:200:0x0400, B:204:0x0410, B:206:0x041a, B:211:0x0426, B:213:0x042c, B:215:0x0434, B:217:0x043a, B:219:0x0441, B:220:0x0446, B:222:0x044a, B:224:0x045e, B:229:0x046a, B:231:0x0471, B:160:0x0357, B:162:0x035d, B:164:0x0363, B:167:0x0376, B:168:0x037b, B:52:0x0100), top: B:313:0x007b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:301:0x0638 A[Catch: NoCustomContextException -> 0x009f, TryCatch #1 {NoCustomContextException -> 0x009f, blocks: (B:19:0x007b, B:21:0x007f, B:22:0x008c, B:24:0x0092, B:29:0x00a7, B:31:0x00ac, B:33:0x00b2, B:35:0x00be, B:37:0x00c3, B:39:0x00c9, B:41:0x00d5, B:42:0x00d8, B:48:0x00f0, B:51:0x00f7, B:53:0x0108, B:55:0x011e, B:56:0x012f, B:57:0x0142, B:59:0x0148, B:61:0x015c, B:63:0x016a, B:64:0x016f, B:65:0x019b, B:67:0x01a1, B:68:0x01b9, B:70:0x01bf, B:72:0x01cd, B:74:0x01d1, B:75:0x01dc, B:77:0x01e7, B:80:0x01ed, B:81:0x01f4, B:83:0x0202, B:84:0x0215, B:87:0x021b, B:89:0x0225, B:91:0x022a, B:95:0x0231, B:97:0x0239, B:100:0x024b, B:102:0x0253, B:104:0x0259, B:106:0x0269, B:131:0x02b0, B:110:0x0271, B:112:0x0279, B:114:0x027f, B:125:0x029e, B:127:0x02a4, B:128:0x02a7, B:130:0x02ad, B:134:0x02b9, B:136:0x02c3, B:137:0x02de, B:138:0x02e1, B:147:0x0312, B:150:0x031e, B:152:0x0342, B:173:0x039a, B:175:0x03a2, B:179:0x03ab, B:234:0x047d, B:235:0x048b, B:237:0x04a2, B:239:0x04ab, B:241:0x04bb, B:242:0x04c0, B:244:0x04c6, B:247:0x04d8, B:248:0x04dd, B:250:0x04e3, B:252:0x04ef, B:253:0x04f3, B:255:0x04f9, B:257:0x0503, B:259:0x050d, B:261:0x051a, B:262:0x052d, B:264:0x0535, B:265:0x053c, B:260:0x0516, B:267:0x055e, B:268:0x0569, B:273:0x0573, B:275:0x057c, B:277:0x058c, B:279:0x059a, B:281:0x05a2, B:284:0x05c1, B:286:0x05c7, B:287:0x05d6, B:289:0x05e1, B:290:0x05ed, B:292:0x05f9, B:294:0x0603, B:295:0x0610, B:297:0x061e, B:299:0x0626, B:300:0x062f, B:301:0x0638, B:304:0x063d, B:186:0x03c4, B:187:0x03cd, B:191:0x03da, B:193:0x03e1, B:195:0x03eb, B:201:0x0409, B:196:0x03f0, B:198:0x03fa, B:200:0x0400, B:204:0x0410, B:206:0x041a, B:211:0x0426, B:213:0x042c, B:215:0x0434, B:217:0x043a, B:219:0x0441, B:220:0x0446, B:222:0x044a, B:224:0x045e, B:229:0x046a, B:231:0x0471, B:160:0x0357, B:162:0x035d, B:164:0x0363, B:167:0x0376, B:168:0x037b, B:52:0x0100), top: B:313:0x007b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:350:0x04d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:351:0x04d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:356:0x055e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:359:0x055c A[SYNTHETIC] */
    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor
    public List<Element> end(WorkerContext workerContext, Tag tag, List<Element> list) {
        String str;
        String str2;
        int i;
        boolean z;
        boolean z2;
        int i2;
        Float height;
        Float fValueOf;
        Iterator<TableRowElement> it;
        int i3;
        ArrayList arrayList;
        Tag tag2;
        int i4;
        String str3;
        List<HtmlCell> content;
        int colspan;
        Float f;
        float maxHeights;
        List<Element> compositeElements;
        TableStyleValues cellValues;
        float horBorderSpacing;
        int i5;
        float f2;
        PdfPTable pdfPTable;
        int[] iArr;
        float[] fArr;
        int i6;
        int i7;
        String str4;
        String str5 = LocaleMessages.NO_CUSTOM_CONTEXT;
        try {
            String str6 = tag.getCSS().get("width");
            if (str6 == null) {
                str6 = tag.getAttributes().get("width");
            }
            boolean z3 = str6 != null && str6.trim().endsWith(CSS.Value.PERCENTAGE);
            ArrayList arrayList2 = new ArrayList(list.size());
            ArrayList arrayList3 = new ArrayList(1);
            String str7 = tag.getCSS().get(CSS.Property.REPEAT_HEADER);
            String str8 = tag.getCSS().get(CSS.Property.REPEAT_FOOTER);
            Iterator<Element> it2 = list.iterator();
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (it2.hasNext()) {
                try {
                    Iterator<Element> it3 = it2;
                    Element next = it2.next();
                    str2 = str5;
                    try {
                        if (next instanceof TableRowElement) {
                            TableRowElement tableRowElement = (TableRowElement) next;
                            Iterator<HtmlCell> it4 = tableRowElement.getContent().iterator();
                            str4 = str6;
                            int colspan2 = 0;
                            while (it4.hasNext()) {
                                colspan2 += it4.next().getColspan();
                            }
                            if (colspan2 > i9) {
                                i9 = colspan2;
                            }
                            arrayList2.add(tableRowElement);
                            if (str7 != null && str7.equalsIgnoreCase("yes") && tableRowElement.getPlace().equals(TableRowElement.Place.HEADER)) {
                                i10++;
                            }
                            if (str8 != null && str8.equalsIgnoreCase("yes") && tableRowElement.getPlace().equals(TableRowElement.Place.FOOTER)) {
                                i8++;
                            }
                        } else {
                            str4 = str6;
                            arrayList3.add(next);
                        }
                        it2 = it3;
                        str5 = str2;
                        str6 = str4;
                    } catch (NoCustomContextException e) {
                        e = e;
                        str = str2;
                        throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(str), e);
                    }
                } catch (NoCustomContextException e2) {
                    e = e2;
                    str2 = str5;
                    str = str2;
                    throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(str), e);
                }
            }
            str2 = str5;
            String str9 = str6;
            if (str8 == null || !str8.equalsIgnoreCase("yes")) {
                Collections.sort(arrayList2, new NormalRowComparator());
            } else {
                Collections.sort(arrayList2, new RepeatedRowComparator());
            }
            PdfPTable pdfPTableIntPdfPTable = intPdfPTable(i9);
            pdfPTableIntPdfPTable.setHeaderRows(i10 + i8);
            pdfPTableIntPdfPTable.setFooterRows(i8);
            if (tag.getAttributes().containsKey("align")) {
                pdfPTableIntPdfPTable.setHorizontalAlignment(CSS.getElementAlignment(tag.getAttributes().get("align")));
            }
            pdfPTableIntPdfPTable.setRunDirection(getRunDirection(tag));
            for (Map.Entry<String, String> entry : tag.getCSS().entrySet()) {
                if (entry.getKey().equalsIgnoreCase(CSS.Property.PAGE_BREAK_INSIDE) && entry.getValue().equalsIgnoreCase(CSS.Value.AVOID)) {
                    pdfPTableIntPdfPTable.setKeepTogether(true);
                }
            }
            TableStyleValues styleValues = setStyleValues(tag);
            pdfPTableIntPdfPTable.setTableEvent(new TableBorderEvent(styleValues));
            setVerticalMargin(pdfPTableIntPdfPTable, tag, styleValues, workerContext);
            widenLastCell(arrayList2, styleValues.getHorBorderSpacing());
            float[] fArr2 = new float[i9];
            float[] fArr3 = new float[i9];
            float[] fArr4 = new float[i9];
            float[] fArr5 = new float[i9];
            int[] iArr2 = new int[i9];
            Iterator<TableRowElement> it5 = arrayList2.iterator();
            int i11 = -1;
            int i12 = -1;
            float f3 = 0.0f;
            float f4 = 0.0f;
            while (it5.hasNext()) {
                float f5 = f4;
                float f6 = f3;
                int i13 = i12;
                int i14 = i11;
                int i15 = 0;
                for (HtmlCell htmlCell : it5.next().getContent()) {
                    ArrayList arrayList4 = arrayList3;
                    int i16 = i15;
                    while (i16 < i9) {
                        int i17 = iArr2[i16];
                        if (i17 <= 0) {
                            break;
                        }
                        iArr2[i16] = i17 - 1;
                        i16++;
                        z3 = z3;
                    }
                    boolean z4 = z3;
                    ArrayList arrayList5 = arrayList2;
                    if (htmlCell.getRowspan() > 1 && i16 != i9 - 1 && i16 < i9) {
                        iArr2[i16] = htmlCell.getRowspan() - 1;
                    }
                    int colspan3 = htmlCell.getColspan();
                    if (htmlCell.getFixedWidth() != 0.0f) {
                        float fixedWidth = htmlCell.getFixedWidth() + getCellStartWidth(htmlCell);
                        pdfPTable = pdfPTableIntPdfPTable;
                        iArr = iArr2;
                        int i18 = 0;
                        float f7 = 0.0f;
                        int i19 = i16;
                        while (true) {
                            i6 = i16 + colspan3;
                            if (i19 >= i6 || i19 >= i9) {
                                break;
                            }
                            float f8 = fArr4[i19];
                            f7 += f8;
                            if (f8 != 0.0f) {
                                i7 = 1;
                                i18++;
                            } else {
                                i7 = 1;
                            }
                            i19 += i7;
                        }
                        int i20 = i16;
                        while (i20 < i6 && i20 < i9) {
                            if (fArr4[i20] == 0.0f) {
                                float f9 = (fixedWidth - f7) / (colspan3 - i18);
                                fArr4[i20] = f9;
                                fArr2[i20] = f9;
                            }
                            i20++;
                            i6 = i6;
                        }
                    } else {
                        pdfPTable = pdfPTableIntPdfPTable;
                        iArr = iArr2;
                    }
                    if (htmlCell.getCompositeElements() != null) {
                        float[] cellWidthAndWidestWord = setCellWidthAndWidestWord(htmlCell);
                        float f10 = colspan3;
                        float f11 = cellWidthAndWidestWord[0] / f10;
                        float f12 = cellWidthAndWidestWord[1] / f10;
                        int i21 = 0;
                        while (i21 < colspan3) {
                            int i22 = i16 + i21;
                            if (i22 >= i9) {
                                fArr = fArr4;
                            } else {
                                if (fArr4[i22] != 0.0f || f11 <= fArr2[i22]) {
                                    fArr = fArr4;
                                } else {
                                    fArr2[i22] = f11;
                                    fArr = fArr4;
                                    if (colspan3 == 1) {
                                        if (f11 > f5) {
                                            f5 = f11;
                                            i13 = i22;
                                        }
                                    } else if (f11 > f6) {
                                        f6 = f11;
                                        i14 = i22;
                                    }
                                }
                                if (colspan3 == 1) {
                                    if (f12 > fArr3[i22]) {
                                        fArr3[i22] = f12;
                                    }
                                } else if (f12 > fArr5[i22]) {
                                    fArr5[i22] = f12;
                                }
                            }
                            i21++;
                            fArr4 = fArr;
                        }
                    }
                    float[] fArr6 = fArr4;
                    if (colspan3 > 1) {
                        Logger logger = LOG;
                        if (logger.isLogging(Level.TRACE)) {
                            logger.trace(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.COLSPAN), Integer.valueOf(colspan3)));
                        }
                        i16 += colspan3 - 1;
                    }
                    i15 = i16 + 1;
                    arrayList3 = arrayList4;
                    z3 = z4;
                    arrayList2 = arrayList5;
                    fArr4 = fArr6;
                    iArr2 = iArr;
                    pdfPTableIntPdfPTable = pdfPTable;
                }
                i11 = i14;
                i12 = i13;
                f3 = f6;
                f4 = f5;
            }
            PdfPTable pdfPTable2 = pdfPTableIntPdfPTable;
            boolean z5 = z3;
            ArrayList arrayList6 = arrayList2;
            ArrayList arrayList7 = arrayList3;
            float[] fArr7 = fArr4;
            int i23 = i12;
            if (i23 == -1) {
                int i24 = i11;
                if (i24 == -1) {
                    i24 = 0;
                }
                for (int i25 = 0; i25 < i9; i25++) {
                    fArr3[i25] = fArr5[i25];
                }
                i = i24;
            } else {
                i = i23;
            }
            float tableOuterWidth = getTableOuterWidth(tag, styleValues.getHorBorderSpacing(), workerContext);
            float tableWidth = getTableWidth(fArr2, 0.0f);
            HtmlPipelineContext htmlPipelineContext = getHtmlPipelineContext(workerContext);
            float width = htmlPipelineContext.getPageSize().getWidth() - tableOuterWidth;
            if (tag.getAttributes().get("width") == null && tag.getCSS().get("width") == null) {
                if (tableWidth <= width) {
                    width = tableWidth;
                } else if (tag.getParent() != null && (tag.getParent() == null || !htmlPipelineContext.getRootTags().contains(tag.getParent().getName()))) {
                    width = getTableWidth(fArr2, tableOuterWidth);
                }
                z = false;
            } else {
                float width2 = new WidthCalculator().getWidth(tag, htmlPipelineContext.getRootTags(), htmlPipelineContext.getPageSize().getWidth(), tableWidth);
                if (width2 <= width) {
                    width = width2;
                }
                z = true;
            }
            float tableWidth2 = getTableWidth(fArr7, 0.0f);
            try {
                if (tableWidth2 != tableWidth) {
                    float f13 = (width - tableWidth2) / (tableWidth - tableWidth2);
                    if (tableWidth > width) {
                        float f14 = 0.0f;
                        for (int i26 = 0; i26 < i9; i26++) {
                            float f15 = fArr7[i26];
                            if (f15 == 0.0f) {
                                float f16 = fArr3[i26];
                                float f17 = fArr2[i26];
                                if (f16 <= f17 * f13) {
                                    fArr2[i26] = f17 * f13;
                                } else {
                                    fArr2[i26] = f16;
                                    f14 += fArr3[i26] - (f16 * f13);
                                }
                            } else {
                                float f18 = fArr3[i26];
                                if (f15 < f18) {
                                    fArr2[i26] = f18;
                                    f14 += fArr3[i26] - fArr7[i26];
                                }
                            }
                        }
                        if (f14 != 0.0f) {
                            float f19 = fArr3[i];
                            float f20 = fArr2[i];
                            if (f19 <= f20 - f14) {
                                fArr2[i] = f20 - f14;
                            } else {
                                int i27 = 0;
                                while (f14 != 0.0f && i27 < i9) {
                                    if (fArr7[i27] == 0.0f) {
                                        float f21 = fArr2[i27];
                                        float f22 = fArr3[i27];
                                        if (f21 > f22) {
                                            float f23 = f21 - f22;
                                            if (f23 <= f14) {
                                                fArr2[i27] = f22;
                                                f14 -= f23;
                                                i2 = 1;
                                            } else {
                                                fArr2[i27] = f21 - f14;
                                                i2 = 1;
                                                f14 = 0.0f;
                                            }
                                        } else {
                                            i2 = 1;
                                        }
                                    } else {
                                        i2 = 1;
                                    }
                                    i27 += i2;
                                }
                                if (f14 != 0.0f && getTableWidth(fArr3, tableOuterWidth) < getHtmlPipelineContext(workerContext).getPageSize().getWidth()) {
                                    getTableWidth(fArr3, tableOuterWidth);
                                }
                            }
                        }
                    } else {
                        if (tableWidth < width) {
                            for (int i28 = 0; i28 < i9; i28++) {
                                if (fArr7[i28] == 0.0f) {
                                    fArr2[i28] = fArr2[i28] * f13;
                                }
                            }
                        }
                        z2 = true;
                    }
                    pdfPTable2.setTotalWidth(fArr2);
                    pdfPTable2.setLockedWidth(z2);
                    pdfPTable2.getDefaultCell().setBorder(0);
                    height = new HeightCalculator().getHeight(tag, getHtmlPipelineContext(workerContext).getPageSize().getHeight());
                    if (height != null || height.floatValue() <= 0.0f) {
                        fValueOf = null;
                    } else {
                        fValueOf = Float.valueOf(height.floatValue() / arrayList6.size());
                    }
                    it = arrayList6.iterator();
                    i3 = 0;
                    while (it.hasNext()) {
                        content = it.next().getContent();
                        if (content.size() < 1) {
                            colspan = -1;
                            for (HtmlCell htmlCell2 : content) {
                                compositeElements = htmlCell2.getCompositeElements();
                                if (compositeElements != null) {
                                    for (Element element : compositeElements) {
                                        if (element instanceof PdfPTable) {
                                            cellValues = htmlCell2.getCellValues();
                                            if (cellValues.isLastInRow()) {
                                                horBorderSpacing = styleValues.getHorBorderSpacing() * 2.0f;
                                            } else {
                                                horBorderSpacing = styleValues.getHorBorderSpacing();
                                            }
                                            float borderWidthLeft = horBorderSpacing + cellValues.getBorderWidthLeft() + cellValues.getBorderWidthRight();
                                            f2 = 0.0f;
                                            for (i5 = colspan + 1; i5 <= colspan + htmlCell2.getColspan(); i5++) {
                                                f2 += fArr2[i5];
                                            }
                                            TableStyleValues tableStyleValues = ((TableBorderEvent) ((PdfPTable) element).getTableEvent()).getTableStyleValues();
                                            ((PdfPTable) element).setTotalWidth(f2 - ((borderWidthLeft + tableStyleValues.getBorderWidthLeft()) + tableStyleValues.getBorderWidthRight()));
                                        }
                                    }
                                }
                                colspan += htmlCell2.getColspan();
                                pdfPTable2.addCell(htmlCell2);
                            }
                            pdfPTable2.completeRow();
                            if (fValueOf != null) {
                                f = fValueOf;
                            } else {
                                f = null;
                            }
                            if (f != null && f.floatValue() > 0.0f) {
                                maxHeights = pdfPTable2.getRow(i3).getMaxHeights();
                                if (maxHeights < f.floatValue()) {
                                    pdfPTable2.getRow(i3).setMaxHeights(f.floatValue());
                                } else if (fValueOf != null && fValueOf.floatValue() < maxHeights) {
                                    fValueOf = Float.valueOf(((height.floatValue() - maxHeights) - (i3 * fValueOf.floatValue())) / ((arrayList6.size() - i3) - 1));
                                }
                            }
                            i3++;
                        }
                    }
                    if (z5) {
                        pdfPTable2.setWidthPercentage(utils.parsePxInCmMmPcToPt(str9));
                        pdfPTable2.setLockedWidth(false);
                    }
                    arrayList = new ArrayList();
                    if (arrayList7.size() > 0) {
                        tag2 = tag.getChildren().get(0);
                        for (i4 = 1; !tag2.getName().equalsIgnoreCase(HTML.Tag.CAPTION) && i4 < tag.getChildren().size(); i4++) {
                            tag2 = tag.getChildren().get(i4);
                        }
                        str3 = tag2.getCSS().get(CSS.Property.CAPTION_SIDE);
                        if (str3 == null && str3.equalsIgnoreCase("bottom")) {
                            arrayList.add(pdfPTable2);
                            arrayList.addAll(arrayList7);
                        } else {
                            arrayList.addAll(arrayList7);
                            arrayList.add(pdfPTable2);
                        }
                    } else {
                        arrayList.add(pdfPTable2);
                    }
                    return arrayList;
                }
                float f24 = width / tableWidth;
                if (tableWidth > width) {
                    for (int i29 = 0; i29 < i9; i29++) {
                        fArr2[i29] = fArr2[i29] * f24;
                    }
                } else if (z && f24 != 1.0f) {
                    for (int i30 = 0; i30 < i9; i30++) {
                        fArr2[i30] = fArr2[i30] * f24;
                    }
                }
                pdfPTable2.setTotalWidth(fArr2);
                pdfPTable2.setLockedWidth(z2);
                pdfPTable2.getDefaultCell().setBorder(0);
                height = new HeightCalculator().getHeight(tag, getHtmlPipelineContext(workerContext).getPageSize().getHeight());
                if (height != null) {
                    fValueOf = null;
                } else {
                    fValueOf = null;
                }
                it = arrayList6.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    content = it.next().getContent();
                    if (content.size() < 1) {
                        colspan = -1;
                        while (r10.hasNext()) {
                            compositeElements = htmlCell2.getCompositeElements();
                            if (compositeElements != null) {
                                while (r13.hasNext()) {
                                    if (element instanceof PdfPTable) {
                                        cellValues = htmlCell2.getCellValues();
                                        if (cellValues.isLastInRow()) {
                                            horBorderSpacing = styleValues.getHorBorderSpacing() * 2.0f;
                                        } else {
                                            horBorderSpacing = styleValues.getHorBorderSpacing();
                                        }
                                        float borderWidthLeft2 = horBorderSpacing + cellValues.getBorderWidthLeft() + cellValues.getBorderWidthRight();
                                        f2 = 0.0f;
                                        while (i5 <= colspan + htmlCell2.getColspan()) {
                                            f2 += fArr2[i5];
                                        }
                                        TableStyleValues tableStyleValues2 = ((TableBorderEvent) ((PdfPTable) element).getTableEvent()).getTableStyleValues();
                                        ((PdfPTable) element).setTotalWidth(f2 - ((borderWidthLeft2 + tableStyleValues2.getBorderWidthLeft()) + tableStyleValues2.getBorderWidthRight()));
                                    }
                                }
                            }
                            colspan += htmlCell2.getColspan();
                            pdfPTable2.addCell(htmlCell2);
                        }
                        pdfPTable2.completeRow();
                        if (fValueOf != null) {
                            f = fValueOf;
                        } else {
                            f = null;
                        }
                        if (f != null) {
                            maxHeights = pdfPTable2.getRow(i3).getMaxHeights();
                            if (maxHeights < f.floatValue()) {
                                pdfPTable2.getRow(i3).setMaxHeights(f.floatValue());
                            } else if (fValueOf != null) {
                                fValueOf = Float.valueOf(((height.floatValue() - maxHeights) - (i3 * fValueOf.floatValue())) / ((arrayList6.size() - i3) - 1));
                            }
                        }
                        i3++;
                    }
                }
                if (z5) {
                    pdfPTable2.setWidthPercentage(utils.parsePxInCmMmPcToPt(str9));
                    pdfPTable2.setLockedWidth(false);
                }
                arrayList = new ArrayList();
                if (arrayList7.size() > 0) {
                    tag2 = tag.getChildren().get(0);
                    while (!tag2.getName().equalsIgnoreCase(HTML.Tag.CAPTION)) {
                        tag2 = tag.getChildren().get(i4);
                    }
                    str3 = tag2.getCSS().get(CSS.Property.CAPTION_SIDE);
                    if (str3 == null) {
                        arrayList.addAll(arrayList7);
                        arrayList.add(pdfPTable2);
                    } else {
                        arrayList.addAll(arrayList7);
                        arrayList.add(pdfPTable2);
                    }
                } else {
                    arrayList.add(pdfPTable2);
                }
                return arrayList;
            } catch (DocumentException e3) {
                str = str2;
                try {
                    throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(str), e3);
                } catch (NoCustomContextException e4) {
                    e = e4;
                    throw new RuntimeWorkerException(LocaleMessages.getInstance().getMessage(str), e);
                }
            }
            z2 = true;
        } catch (NoCustomContextException e5) {
            e = e5;
            str = str5;
        }
    }

    public PdfPTable intPdfPTable(int i) {
        PdfPTable pdfPTable = new PdfPTable(i);
        pdfPTable.setHorizontalAlignment(0);
        pdfPTable.setSplitLate(false);
        return pdfPTable;
    }

    @Override // com.itextpdf.tool.xml.html.AbstractTagProcessor, com.itextpdf.tool.xml.html.TagProcessor
    public boolean isStackOwner() {
        return true;
    }
}
