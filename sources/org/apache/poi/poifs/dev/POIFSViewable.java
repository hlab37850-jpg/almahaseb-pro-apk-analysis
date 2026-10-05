package org.apache.poi.poifs.dev;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public interface POIFSViewable {
    String getShortDescription();

    Object[] getViewableArray();

    Iterator getViewableIterator();

    boolean preferArray();
}
