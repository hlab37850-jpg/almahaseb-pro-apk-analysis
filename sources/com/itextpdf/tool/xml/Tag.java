package com.itextpdf.tool.xml;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Tag implements Iterable<Tag> {
    private final Map<String, String> attributes;
    private final List<Tag> children;
    private Map<String, String> css;
    private Object lastMarginBottom;
    private final String ns;
    private Tag parent;
    private final String tag;

    public Tag(String str, Map<String, String> map) {
        this(str, map, new LinkedHashMap(0), "");
    }

    private Tag recursiveGetChild(Tag tag, String str, String str2, boolean z) {
        Tag tagRecursiveGetChild;
        for (Tag tag2 : tag) {
            if (tag2.tag.equals(str) && tag2.ns.equals(str2)) {
                return tag2;
            }
            if (z && (tagRecursiveGetChild = recursiveGetChild(tag2, str, str2, z)) != null) {
                return tagRecursiveGetChild;
            }
        }
        return null;
    }

    private boolean recursiveHasChild(Tag tag, String str, String str2, boolean z) {
        for (Tag tag2 : tag) {
            if (tag2.tag.equals(str) && tag2.ns.equals(str2)) {
                return true;
            }
            if (z && recursiveHasChild(tag2, str, str2, z)) {
                return true;
            }
        }
        return false;
    }

    public void addChild(Tag tag) {
        tag.setParent(this);
        this.children.add(tag);
    }

    public boolean compareTag(Tag tag) {
        if (this == tag) {
            return true;
        }
        if (tag == null) {
            return false;
        }
        String str = this.ns;
        if (str == null) {
            if (tag.ns != null) {
                return false;
            }
        } else if (!str.equals(tag.ns)) {
            return false;
        }
        String str2 = this.tag;
        if (str2 == null) {
            if (tag.tag != null) {
                return false;
            }
        } else if (!str2.equals(tag.tag)) {
            return false;
        }
        return true;
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    public Map<String, String> getCSS() {
        return this.css;
    }

    public Tag getChild(String str, String str2) {
        return getChild(str, str2, false);
    }

    public List<Tag> getChildren() {
        return this.children;
    }

    public Object getLastMarginBottom() {
        return this.lastMarginBottom;
    }

    public String getName() {
        return this.tag;
    }

    public String getNameSpace() {
        return this.ns;
    }

    public Tag getParent() {
        return this.parent;
    }

    @Deprecated
    public String getTag() {
        return this.tag;
    }

    public boolean hasChild(String str, String str2) {
        return hasChild(str, str2, false);
    }

    public boolean hasChildren() {
        return getChildren().size() != 0;
    }

    public boolean hasParent() {
        return getParent() != null;
    }

    @Override // java.lang.Iterable
    public Iterator<Tag> iterator() {
        return this.children.iterator();
    }

    public void setCSS(Map<String, String> map) {
        if (map != null) {
            this.css = map;
        } else {
            this.css.clear();
        }
    }

    public void setLastMarginBottom(Object obj) {
        this.lastMarginBottom = obj;
    }

    public void setParent(Tag tag) {
        this.parent = tag;
    }

    public String toString() {
        return "".equalsIgnoreCase(this.ns) ? String.format("%s", this.tag) : String.format("%s:%s", this.ns, this.tag);
    }

    public Tag(String str) {
        this(str, new LinkedHashMap(0), new LinkedHashMap(0), "");
    }

    public Tag getChild(String str, String str2, boolean z) {
        return recursiveGetChild(this, str, str2, z);
    }

    public List<Tag> getChildren(String str) {
        LinkedList linkedList = new LinkedList();
        for (Tag tag : this.children) {
            if (tag.getName().equals(str)) {
                linkedList.add(tag);
            }
        }
        return linkedList;
    }

    public boolean hasChild(String str, String str2, boolean z) {
        return z ? recursiveHasChild(this, str, str2, true) : recursiveHasChild(this, str, str2, false);
    }

    public Tag(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        this.lastMarginBottom = null;
        this.tag = str;
        this.attributes = map;
        this.css = map2;
        this.children = new LinkedList();
        if (str2 != null) {
            this.ns = str2;
            return;
        }
        throw new NullPointerException("NS cannot be null");
    }

    public Tag(String str, Map<String, String> map, String str2) {
        this(str, map, new LinkedHashMap(0), str2);
    }

    public Tag(String str, String str2) {
        this(str, new LinkedHashMap(0), new LinkedHashMap(0), str2);
    }
}
