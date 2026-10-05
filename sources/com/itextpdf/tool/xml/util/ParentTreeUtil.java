package com.itextpdf.tool.xml.util;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ParentTreeUtil {
    public List<Tag> getParentTagTree(Tag tag, List<Tag> list) {
        ArrayList arrayList = new ArrayList();
        for (Tag parent = tag.getParent(); parent != null && !parent.getName().equals(HTML.Tag.HTML); parent = parent.getParent()) {
            arrayList.add(parent);
        }
        return arrayList;
    }

    public List<String> getParentTree(Tag tag) {
        ArrayList arrayList = new ArrayList();
        for (Tag parent = tag.getParent(); parent != null && !parent.getName().equals("body"); parent = parent.getParent()) {
            arrayList.add(parent.getName());
        }
        return arrayList;
    }
}
