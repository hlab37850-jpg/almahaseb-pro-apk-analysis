package com.itextpdf.tool.xml;

import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.NoSiblingException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TagUtils {
    private static final TagUtils myself = new TagUtils();

    public static TagUtils getInstance() {
        return myself;
    }

    public Tag getSibling(Tag tag, int i) throws NoSiblingException {
        try {
            List<Tag> children = tag.getParent().getChildren();
            return children.get(children.indexOf(tag) + i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSiblingException(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_SIBLING), tag.getName(), Integer.valueOf(i)), e);
        }
    }
}
