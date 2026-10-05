package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.net.FileRetrieve;
import com.itextpdf.tool.xml.net.FileRetrieveImpl;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public class StyleAttrCSSResolver implements CSSResolver {
    public static final String STYLE = "style";
    private final CssFiles cssFiles;
    private CssInheritanceRules inherit;
    private FileRetrieve retrieve;
    private final CssUtils utils;

    public StyleAttrCSSResolver() {
        this(new CssFilesImpl(), CssUtils.getInstance());
    }

    private boolean canInherite(Tag tag, String str) {
        CssInheritanceRules cssInheritanceRules = this.inherit;
        if (cssInheritanceRules != null) {
            return cssInheritanceRules.inheritCssSelector(tag, str);
        }
        return true;
    }

    private String mergeTextDecorationRules(String str, String str2) {
        if ("none".equals(str2)) {
            return str2;
        }
        TreeSet<String> treeSet = new TreeSet();
        if (str != null) {
            Collections.addAll(treeSet, str.split("\\s+"));
        }
        if (str2 != null) {
            Collections.addAll(treeSet, str2.split("\\s+"));
        }
        StringBuilder sb = new StringBuilder();
        for (String str3 : treeSet) {
            if (!str3.equals("none") && !str3.equals(CSS.Value.INHERIT)) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(str3);
            }
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    private boolean mustInherit(String str) {
        CssInheritanceRules cssInheritanceRules = this.inherit;
        if (cssInheritanceRules != null) {
            return cssInheritanceRules.inheritCssTag(str);
        }
        return true;
    }

    private void splitRules(Map<String, String> map, String str, String str2) {
        if ("border".equalsIgnoreCase(str)) {
            map.putAll(this.utils.parseBorder(str2));
            return;
        }
        if (CSS.Property.BORDER_TOP.equalsIgnoreCase(str)) {
            map.putAll(this.utils.parseBorder(str2, CSS.Property.BORDER_TOP));
            return;
        }
        if (CSS.Property.BORDER_BOTTOM.equalsIgnoreCase(str)) {
            map.putAll(this.utils.parseBorder(str2, CSS.Property.BORDER_BOTTOM));
            return;
        }
        if (CSS.Property.BORDER_LEFT.equalsIgnoreCase(str)) {
            map.putAll(this.utils.parseBorder(str2, CSS.Property.BORDER_LEFT));
            return;
        }
        if (CSS.Property.BORDER_RIGHT.equalsIgnoreCase(str)) {
            map.putAll(this.utils.parseBorder(str2, CSS.Property.BORDER_RIGHT));
            return;
        }
        if (CSS.Property.MARGIN.equalsIgnoreCase(str)) {
            map.putAll(this.utils.parseBoxValues(str2, "margin-", ""));
            return;
        }
        if (CSS.Property.BORDER_WIDTH.equalsIgnoreCase(str)) {
            map.putAll(this.utils.parseBoxValues(str2, "border-", "-width"));
            return;
        }
        if (CSS.Property.BORDER_STYLE.equalsIgnoreCase(str)) {
            map.putAll(this.utils.parseBoxValues(str2, "border-", "-style"));
            return;
        }
        if (CSS.Property.BORDER_COLOR.equalsIgnoreCase(str)) {
            map.putAll(this.utils.parseBoxValues(str2, "border-", "-color"));
            return;
        }
        if (CSS.Property.PADDING.equalsIgnoreCase(str)) {
            map.putAll(this.utils.parseBoxValues(str2, "padding-", ""));
            return;
        }
        if ("font".equalsIgnoreCase(str)) {
            map.putAll(this.utils.processFont(str2));
            return;
        }
        if (CSS.Property.LIST_STYLE.equalsIgnoreCase(str)) {
            map.putAll(this.utils.processListStyle(str2));
            return;
        }
        if (!str.toLowerCase().contains(CSS.Property.BACKGROUND)) {
            map.put(str, str2);
            return;
        }
        Map<String, String> mapProcessBackground = this.utils.processBackground(str2);
        for (String str3 : mapProcessBackground.keySet()) {
            if (!map.containsKey(str3)) {
                map.put(str3, mapProcessBackground.get(str3));
            }
        }
    }

    @Override // com.itextpdf.tool.xml.pipeline.css.CSSResolver
    public void addCss(String str, String str2, boolean z) throws CssResolverException {
        CssFileProcessor cssFileProcessor = new CssFileProcessor();
        try {
            this.retrieve.processFromStream(new ByteArrayInputStream(str.getBytes(str2)), cssFileProcessor);
            CssFile css = cssFileProcessor.getCss();
            css.isPersistent(z);
            this.cssFiles.add(css);
        } catch (UnsupportedEncodingException e) {
            throw new CssResolverException(e);
        } catch (IOException e2) {
            throw new CssResolverException(e2);
        }
    }

    @Override // com.itextpdf.tool.xml.pipeline.css.CSSResolver
    public void addCssFile(String str, boolean z) throws CssResolverException {
        CssFileProcessor cssFileProcessor = new CssFileProcessor();
        try {
            this.retrieve.processFromHref(str, cssFileProcessor);
            CssFile css = cssFileProcessor.getCss();
            css.isPersistent(z);
            this.cssFiles.add(css);
        } catch (IOException e) {
            throw new CssResolverException(e);
        }
    }

    @Override // com.itextpdf.tool.xml.pipeline.css.CSSResolver
    public CSSResolver clear() {
        this.cssFiles.clear();
        return this;
    }

    @Override // com.itextpdf.tool.xml.pipeline.css.CSSResolver
    public void resolveStyles(Tag tag) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        CssFiles cssFiles = this.cssFiles;
        Map<String, String> css = null;
        if (cssFiles != null && cssFiles.hasFiles()) {
            linkedHashMap = this.cssFiles.getCSS(tag);
            if (tag.getName().equalsIgnoreCase("p") || tag.getName().equalsIgnoreCase("td")) {
                css = this.cssFiles.getCSS(new Tag("ul"));
            }
        }
        if (tag.getAttributes() != null && !tag.getAttributes().isEmpty()) {
            if (tag.getAttributes().get("cellpadding") != null) {
                linkedHashMap.putAll(this.utils.parseBoxValues(tag.getAttributes().get("cellpadding"), "cellpadding-", ""));
            }
            if (tag.getAttributes().get(HTML.Attribute.CELLSPACING) != null) {
                linkedHashMap.putAll(this.utils.parseBoxValues(tag.getAttributes().get(HTML.Attribute.CELLSPACING), "cellspacing-", ""));
            }
            String str = tag.getAttributes().get("style");
            if (str != null && str.length() > 0) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (String str2 : str.split(";")) {
                    String[] strArrSplit = str2.split(":", 2);
                    if (strArrSplit.length == 2) {
                        splitRules(linkedHashMap2, this.utils.stripDoubleSpacesTrimAndToLowerCase(strArrSplit[0]), this.utils.stripDoubleSpacesAndTrim(strArrSplit[1]));
                    }
                }
                for (Map.Entry<String, String> entry : linkedHashMap2.entrySet()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        Map<String, String> css2 = tag.getCSS();
        if (tag.getName() != null) {
            if (tag.getName().equalsIgnoreCase("i") || tag.getName().equalsIgnoreCase(HTML.Tag.CITE) || tag.getName().equalsIgnoreCase("em") || tag.getName().equalsIgnoreCase(HTML.Tag.VAR) || tag.getName().equalsIgnoreCase(HTML.Tag.DFN) || tag.getName().equalsIgnoreCase(HTML.Tag.ADDRESS)) {
                linkedHashMap.put("font-style", "italic");
            } else if (tag.getName().equalsIgnoreCase("b") || tag.getName().equalsIgnoreCase("strong")) {
                linkedHashMap.put("font-weight", "bold");
            } else if (tag.getName().equalsIgnoreCase("u") || tag.getName().equalsIgnoreCase(HTML.Tag.INS)) {
                linkedHashMap.put("text-decoration", "underline");
            } else if (tag.getName().equalsIgnoreCase("s") || tag.getName().equalsIgnoreCase("strike") || tag.getName().equalsIgnoreCase(HTML.Tag.DEL)) {
                linkedHashMap.put("text-decoration", "line-through");
            } else if (tag.getName().equalsIgnoreCase(HTML.Tag.BIG)) {
                linkedHashMap.put("font-size", CSS.Value.LARGER);
            } else if (tag.getName().equalsIgnoreCase("small")) {
                linkedHashMap.put("font-size", CSS.Value.SMALLER);
            }
        }
        if (css != null && css.containsKey(CSS.Property.LIST_STYLE_TYPE)) {
            css2.put(CSS.Property.LIST_STYLE_TYPE, css.get(CSS.Property.LIST_STYLE_TYPE));
        }
        if (mustInherit(tag.getName()) && tag.getParent() != null && tag.getParent().getCSS() != null) {
            if (this.inherit != null) {
                for (Map.Entry<String, String> entry2 : tag.getParent().getCSS().entrySet()) {
                    String key = entry2.getKey();
                    if ((linkedHashMap.containsKey(key) && CSS.Value.INHERIT.equals(linkedHashMap.get(key))) || canInherite(tag, key)) {
                        if (key.contains("cellpadding") && ("td".equals(tag.getName()) || "th".equals(tag.getName()))) {
                            linkedHashMap.put(key.replace("cellpadding", CSS.Property.PADDING), entry2.getValue());
                        } else {
                            css2.put(key, entry2.getValue());
                        }
                    }
                }
            } else {
                css2.putAll(tag.getParent().getCSS());
            }
        }
        if (tag.getName() != null) {
            if (tag.getName().equals("font")) {
                String str3 = tag.getAttributes().get("face");
                if (str3 != null) {
                    css2.put("font-family", str3);
                }
                String str4 = tag.getAttributes().get("color");
                if (str4 != null) {
                    css2.put("color", str4);
                }
                String str5 = tag.getAttributes().get("size");
                if (str5 != null) {
                    if (str5.equals("1")) {
                        css2.put("font-size", CSS.Value.XX_SMALL);
                    } else if (str5.equals("2")) {
                        css2.put("font-size", CSS.Value.X_SMALL);
                    } else if (str5.equals("3")) {
                        css2.put("font-size", "small");
                    } else if (str5.equals("4")) {
                        css2.put("font-size", CSS.Value.MEDIUM);
                    } else if (str5.equals("5")) {
                        css2.put("font-size", CSS.Value.LARGE);
                    } else if (str5.equals("6")) {
                        css2.put("font-size", CSS.Value.X_LARGE);
                    } else if (str5.equals("7")) {
                        css2.put("font-size", CSS.Value.XX_LARGE);
                    }
                }
            } else if (tag.getName().equals("a")) {
                css2.put("text-decoration", "underline");
                css2.put("color", "blue");
            }
        }
        for (Map.Entry<String, String> entry3 : linkedHashMap.entrySet()) {
            if (!CSS.Value.INHERIT.equalsIgnoreCase(entry3.getValue())) {
                if (entry3.getKey().equals("text-decoration")) {
                    css2.put(entry3.getKey(), mergeTextDecorationRules(css2.get(entry3.getKey()), entry3.getValue()));
                } else {
                    css2.put(entry3.getKey(), entry3.getValue());
                }
            }
        }
    }

    public void setCssInheritance(CssInheritanceRules cssInheritanceRules) {
        this.inherit = cssInheritanceRules;
    }

    public void setCssInheritanceRules(CssInheritanceRules cssInheritanceRules) {
        this.inherit = cssInheritanceRules;
    }

    @Override // com.itextpdf.tool.xml.pipeline.css.CSSResolver
    public void setFileRetrieve(FileRetrieve fileRetrieve) {
        this.retrieve = fileRetrieve;
    }

    public StyleAttrCSSResolver(CssFiles cssFiles) {
        this(cssFiles, CssUtils.getInstance());
    }

    public StyleAttrCSSResolver(CssFiles cssFiles, CssUtils cssUtils) {
        this(new DefaultCssInheritanceRules(), cssFiles, cssUtils);
    }

    public StyleAttrCSSResolver(CssInheritanceRules cssInheritanceRules, CssFiles cssFiles, CssUtils cssUtils) {
        this(cssInheritanceRules, cssFiles, cssUtils, new FileRetrieveImpl());
    }

    public StyleAttrCSSResolver(CssInheritanceRules cssInheritanceRules, CssFiles cssFiles, CssUtils cssUtils, FileRetrieve fileRetrieve) {
        this.utils = cssUtils;
        this.cssFiles = cssFiles;
        this.inherit = cssInheritanceRules;
        this.retrieve = fileRetrieve;
    }

    @Override // com.itextpdf.tool.xml.pipeline.css.CSSResolver
    public void addCss(CssFile cssFile) {
        this.cssFiles.add(cssFile);
    }

    @Override // com.itextpdf.tool.xml.pipeline.css.CSSResolver
    public void addCss(String str, boolean z) throws CssResolverException {
        CssFileProcessor cssFileProcessor = new CssFileProcessor();
        try {
            new FileRetrieveImpl().processFromStream(new ByteArrayInputStream(str.getBytes()), cssFileProcessor);
            CssFile css = cssFileProcessor.getCss();
            css.isPersistent(z);
            this.cssFiles.add(css);
        } catch (UnsupportedEncodingException e) {
            throw new CssResolverException(e);
        } catch (IOException e2) {
            throw new CssResolverException(e2);
        }
    }

    public StyleAttrCSSResolver(CssFiles cssFiles, FileRetrieve fileRetrieve) {
        this(new DefaultCssInheritanceRules(), cssFiles, CssUtils.getInstance(), fileRetrieve);
    }
}
