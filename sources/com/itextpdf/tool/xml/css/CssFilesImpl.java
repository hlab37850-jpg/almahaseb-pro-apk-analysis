package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CssFilesImpl implements CssFiles {
    private final List<CssFile> files;
    private final CssUtils utils;

    public CssFilesImpl() {
        this.files = new ArrayList();
        this.utils = CssUtils.getInstance();
    }

    @Override // com.itextpdf.tool.xml.css.CssFiles
    public void add(CssFile cssFile) {
        if (cssFile != null) {
            this.files.add(cssFile);
        }
    }

    @Override // com.itextpdf.tool.xml.css.CssFiles
    public void clear() {
        Iterator<CssFile> it = this.files.iterator();
        while (it.hasNext()) {
            if (!it.next().isPersistent()) {
                it.remove();
            }
        }
    }

    @Override // com.itextpdf.tool.xml.css.CssFiles
    public Map<String, String> getCSS(Tag tag) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        populateCss(tag, linkedHashMap);
        return linkedHashMap;
    }

    @Override // com.itextpdf.tool.xml.css.CssFiles
    public boolean hasFiles() {
        return !this.files.isEmpty();
    }

    public void populateCss(Tag tag, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        Iterator<CssFile> it = this.files.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().get(tag));
        }
        Collections.sort(arrayList);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            populateOneCss(map, ((CssRule) it2.next()).getNormalDeclarations());
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            populateOneCss(map, ((CssRule) it3.next()).getImportantDeclarations());
        }
    }

    public void populateOneCss(Map<String, String> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String strStripDoubleSpacesTrimAndToLowerCase = this.utils.stripDoubleSpacesTrimAndToLowerCase(entry.getKey());
            String strStripDoubleSpacesAndTrim = this.utils.stripDoubleSpacesAndTrim(entry.getValue());
            if ("border".equalsIgnoreCase(strStripDoubleSpacesTrimAndToLowerCase)) {
                linkedHashMap.putAll(this.utils.parseBorder(strStripDoubleSpacesAndTrim));
            } else if (CSS.Property.BORDER_TOP.equalsIgnoreCase(strStripDoubleSpacesTrimAndToLowerCase)) {
                linkedHashMap.putAll(this.utils.parseBorder(strStripDoubleSpacesAndTrim, CSS.Property.BORDER_TOP));
            } else if (CSS.Property.BORDER_BOTTOM.equalsIgnoreCase(strStripDoubleSpacesTrimAndToLowerCase)) {
                linkedHashMap.putAll(this.utils.parseBorder(strStripDoubleSpacesAndTrim, CSS.Property.BORDER_BOTTOM));
            } else if (CSS.Property.BORDER_LEFT.equalsIgnoreCase(strStripDoubleSpacesTrimAndToLowerCase)) {
                linkedHashMap.putAll(this.utils.parseBorder(strStripDoubleSpacesAndTrim, CSS.Property.BORDER_LEFT));
            } else if (CSS.Property.BORDER_RIGHT.equalsIgnoreCase(strStripDoubleSpacesTrimAndToLowerCase)) {
                linkedHashMap.putAll(this.utils.parseBorder(strStripDoubleSpacesAndTrim, CSS.Property.BORDER_RIGHT));
            } else if (CSS.Property.MARGIN.equalsIgnoreCase(strStripDoubleSpacesTrimAndToLowerCase)) {
                Map<String, String> boxValues = this.utils.parseBoxValues(strStripDoubleSpacesAndTrim, "margin-", "");
                for (String str : boxValues.keySet()) {
                    if (!linkedHashMap.containsKey(str)) {
                        linkedHashMap.put(str, boxValues.get(str));
                    }
                }
            } else if (CSS.Property.BORDER_WIDTH.equalsIgnoreCase(strStripDoubleSpacesTrimAndToLowerCase)) {
                linkedHashMap.putAll(this.utils.parseBoxValues(strStripDoubleSpacesAndTrim, "border-", "-width"));
            } else if (CSS.Property.BORDER_STYLE.equalsIgnoreCase(strStripDoubleSpacesTrimAndToLowerCase)) {
                linkedHashMap.putAll(this.utils.parseBoxValues(strStripDoubleSpacesAndTrim, "border-", "-style"));
            } else if (CSS.Property.BORDER_COLOR.equalsIgnoreCase(strStripDoubleSpacesTrimAndToLowerCase)) {
                linkedHashMap.putAll(this.utils.parseBoxValues(strStripDoubleSpacesAndTrim, "border-", "-color"));
            } else if (CSS.Property.PADDING.equalsIgnoreCase(strStripDoubleSpacesTrimAndToLowerCase)) {
                Map<String, String> boxValues2 = this.utils.parseBoxValues(strStripDoubleSpacesAndTrim, "padding-", "");
                for (String str2 : boxValues2.keySet()) {
                    if (!linkedHashMap.containsKey(str2)) {
                        linkedHashMap.put(str2, boxValues2.get(str2));
                    }
                }
            } else if ("font".equalsIgnoreCase(strStripDoubleSpacesTrimAndToLowerCase)) {
                linkedHashMap.putAll(this.utils.processFont(strStripDoubleSpacesAndTrim));
            } else if (CSS.Property.LIST_STYLE.equalsIgnoreCase(strStripDoubleSpacesTrimAndToLowerCase)) {
                linkedHashMap.putAll(this.utils.processListStyle(strStripDoubleSpacesAndTrim));
            } else if (strStripDoubleSpacesTrimAndToLowerCase.toLowerCase().contains(CSS.Property.BACKGROUND)) {
                Map<String, String> mapProcessBackground = this.utils.processBackground(strStripDoubleSpacesAndTrim);
                for (String str3 : mapProcessBackground.keySet()) {
                    if (!linkedHashMap.containsKey(str3)) {
                        linkedHashMap.put(str3, mapProcessBackground.get(str3));
                    }
                }
            } else {
                linkedHashMap.put(strStripDoubleSpacesTrimAndToLowerCase, strStripDoubleSpacesAndTrim);
            }
        }
        map.putAll(linkedHashMap);
    }

    public CssFilesImpl(CssFile cssFile) {
        this();
        add(cssFile);
    }
}
