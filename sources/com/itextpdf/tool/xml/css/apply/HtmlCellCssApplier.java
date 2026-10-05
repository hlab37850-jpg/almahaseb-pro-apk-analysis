package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.HeightCalculator;
import com.itextpdf.tool.xml.css.WidthCalculator;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.html.pdfelement.HtmlCell;
import com.itextpdf.tool.xml.html.table.CellSpacingEvent;
import com.itextpdf.tool.xml.html.table.Table;
import com.itextpdf.tool.xml.html.table.TableStyleValues;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class HtmlCellCssApplier implements CssApplier<HtmlCell> {
    private final CssUtils utils = CssUtils.getInstance();

    private void setBottomOfBorder(HtmlCell htmlCell, String str, String str2, TableStyleValues tableStyleValues) {
        if (str.contains("width")) {
            tableStyleValues.setBorderWidthBottom(this.utils.parsePxInCmMmPcToPt(str2));
        }
        if (str.contains("color")) {
            tableStyleValues.setBorderColorBottom(HtmlUtilities.decodeColor(str2));
        } else if (tableStyleValues.getBorderColorBottom() == null) {
            tableStyleValues.setBorderColorBottom(BaseColor.BLACK);
        }
        if (str.contains("style") && tableStyleValues.getBorderWidthBottom(false) == null) {
            tableStyleValues.setBorderWidthBottom(2.25f);
        }
    }

    private void setLeftOfBorder(HtmlCell htmlCell, String str, String str2, TableStyleValues tableStyleValues) {
        if (str.contains("width")) {
            tableStyleValues.setBorderWidthLeft(this.utils.parsePxInCmMmPcToPt(str2));
        }
        if (str.contains("color")) {
            tableStyleValues.setBorderColorLeft(HtmlUtilities.decodeColor(str2));
        } else if (tableStyleValues.getBorderColorLeft() == null) {
            tableStyleValues.setBorderColorLeft(BaseColor.BLACK);
        }
        if (str.contains("style") && tableStyleValues.getBorderWidthLeft(false) == null) {
            tableStyleValues.setBorderWidthLeft(2.25f);
        }
    }

    private void setRightOfBorder(HtmlCell htmlCell, String str, String str2, TableStyleValues tableStyleValues) {
        if (str.contains("width")) {
            tableStyleValues.setBorderWidthRight(this.utils.parsePxInCmMmPcToPt(str2));
        }
        if (str.contains("color")) {
            tableStyleValues.setBorderColorRight(HtmlUtilities.decodeColor(str2));
        } else if (tableStyleValues.getBorderColorRight() == null) {
            tableStyleValues.setBorderColorRight(BaseColor.BLACK);
        }
        if (str.contains("style") && tableStyleValues.getBorderWidthRight(false) == null) {
            tableStyleValues.setBorderWidthRight(2.25f);
        }
    }

    private void setTopOfBorder(HtmlCell htmlCell, String str, String str2, TableStyleValues tableStyleValues) {
        if (str.contains("width")) {
            tableStyleValues.setBorderWidthTop(this.utils.parsePxInCmMmPcToPt(str2));
        }
        if (str.contains("color")) {
            tableStyleValues.setBorderColorTop(HtmlUtilities.decodeColor(str2));
        } else if (tableStyleValues.getBorderColorTop() == null) {
            tableStyleValues.setBorderColorTop(BaseColor.BLACK);
        }
        if (str.contains("style") && tableStyleValues.getBorderWidthTop(false) == null) {
            tableStyleValues.setBorderWidthTop(2.25f);
        }
    }

    public HtmlCell apply(HtmlCell htmlCell, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable) {
        return apply(htmlCell, tag, marginMemory, pageSizeContainable, (HtmlPipelineContext) null);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00b0  */
    @Override // com.itextpdf.tool.xml.html.CssApplier
    public HtmlCell apply(HtmlCell htmlCell, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext) {
        String str;
        Tag parent = tag.getParent();
        while (parent != null && !parent.getName().equals("tr")) {
            parent = parent.getParent();
        }
        Tag parent2 = tag.getParent();
        while (parent2 != null && !parent2.getName().equals("table")) {
            parent2 = parent2.getParent();
        }
        TableStyleValues borderAttributeForCell = Table.setBorderAttributeForCell(parent2);
        Map<String, String> css = tag.getCSS();
        String str2 = css.get(CSS.Property.EMPTY_CELLS);
        if (str2 != null && CSS.Value.HIDE.equalsIgnoreCase(str2) && htmlCell.getCompositeElements() == null) {
            htmlCell.setBorder(0);
        } else {
            htmlCell.setVerticalAlignment(5);
            String str3 = null;
            if (tag.getAttributes().containsKey("valign")) {
                str = tag.getAttributes().get("valign");
            } else if (css.containsKey("valign")) {
                str = css.get("valign");
            } else if (parent == null) {
                str = null;
            } else if (parent.getAttributes().containsKey("valign")) {
                str = parent.getAttributes().get("valign");
            } else if (parent.getCSS().containsKey("valign")) {
                str = parent.getCSS().get("valign");
            } else {
                str = null;
            }
            if (str != null) {
                if (str.equalsIgnoreCase("top")) {
                    htmlCell.setVerticalAlignment(4);
                } else if (str.equalsIgnoreCase("bottom")) {
                    htmlCell.setVerticalAlignment(6);
                }
            }
            if (tag.getAttributes().containsKey("align")) {
                str3 = tag.getAttributes().get("align");
            } else if (css.containsKey("text-align")) {
                str3 = css.get("text-align");
            }
            if (str3 != null) {
                if (str3.equalsIgnoreCase("center")) {
                    htmlCell.setHorizontalAlignment(1);
                } else if (str3.equalsIgnoreCase("right")) {
                    htmlCell.setHorizontalAlignment(2);
                } else if (str3.equalsIgnoreCase("justify")) {
                    htmlCell.setHorizontalAlignment(3);
                }
            }
            if (tag.getAttributes().get("width") != null || css.get("width") != null) {
                htmlCell.setFixedWidth(new WidthCalculator().getWidth(tag, marginMemory.getRootTags(), pageSizeContainable.getPageSize().getWidth()));
            }
            HeightCalculator heightCalculator = new HeightCalculator();
            Float height = heightCalculator.getHeight(tag, pageSizeContainable.getPageSize().getHeight());
            if (height == null && parent != null) {
                height = heightCalculator.getHeight(parent, pageSizeContainable.getPageSize().getHeight());
            }
            if (height != null) {
                htmlCell.setMinimumHeight(height.floatValue());
            }
            String str4 = tag.getAttributes().get("colspan");
            if (str4 != null) {
                htmlCell.setColspan(Integer.parseInt(str4));
            }
            String str5 = tag.getAttributes().get("rowspan");
            if (str5 != null) {
                htmlCell.setRowspan(Integer.parseInt(str5));
            }
            for (Map.Entry<String, String> entry : css.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                htmlCell.setUseBorderPadding(true);
                if (key.equalsIgnoreCase(CSS.Property.BACKGROUND_COLOR)) {
                    borderAttributeForCell.setBackground(HtmlUtilities.decodeColor(value));
                } else if (key.equalsIgnoreCase("vertical-align")) {
                    if (value.equalsIgnoreCase("top")) {
                        htmlCell.setVerticalAlignment(4);
                        htmlCell.setPaddingTop(htmlCell.getPaddingTop() + 6.0f);
                    } else if (value.equalsIgnoreCase("bottom")) {
                        htmlCell.setVerticalAlignment(6);
                        htmlCell.setPaddingBottom(htmlCell.getPaddingBottom() + 6.0f);
                    }
                } else if (key.contains("border")) {
                    if (key.contains("top")) {
                        setTopOfBorder(htmlCell, key, value, borderAttributeForCell);
                    } else if (key.contains("bottom")) {
                        setBottomOfBorder(htmlCell, key, value, borderAttributeForCell);
                    } else if (key.contains("left")) {
                        setLeftOfBorder(htmlCell, key, value, borderAttributeForCell);
                    } else if (key.contains("right")) {
                        setRightOfBorder(htmlCell, key, value, borderAttributeForCell);
                    }
                } else if (!key.contains("cellpadding") && !key.contains(CSS.Property.PADDING)) {
                    if (key.contains("text-align")) {
                        htmlCell.setHorizontalAlignment(CSS.getElementAlignment(value));
                    }
                } else if (key.contains("top")) {
                    htmlCell.setPaddingTop(htmlCell.getPaddingTop() + this.utils.parsePxInCmMmPcToPt(value));
                } else if (key.contains("bottom")) {
                    htmlCell.setPaddingBottom(htmlCell.getPaddingBottom() + this.utils.parsePxInCmMmPcToPt(value));
                } else if (key.contains("left")) {
                    htmlCell.setPaddingLeft(htmlCell.getPaddingLeft() + this.utils.parsePxInCmMmPcToPt(value));
                } else if (key.contains("right")) {
                    htmlCell.setPaddingRight(htmlCell.getPaddingRight() + this.utils.parsePxInCmMmPcToPt(value));
                }
            }
            htmlCell.setPaddingLeft(htmlCell.getPaddingLeft() + borderAttributeForCell.getHorBorderSpacing() + borderAttributeForCell.getBorderWidthLeft());
            htmlCell.setPaddingRight(htmlCell.getPaddingRight() + borderAttributeForCell.getBorderWidthRight());
            htmlCell.setPaddingTop(htmlCell.getPaddingTop() + borderAttributeForCell.getVerBorderSpacing() + borderAttributeForCell.getBorderWidthTop());
            htmlCell.setPaddingBottom(htmlCell.getPaddingBottom() + borderAttributeForCell.getBorderWidthBottom());
        }
        htmlCell.setBorder(0);
        htmlCell.setCellEvent(new CellSpacingEvent(borderAttributeForCell));
        htmlCell.setCellValues(borderAttributeForCell);
        return htmlCell;
    }
}
