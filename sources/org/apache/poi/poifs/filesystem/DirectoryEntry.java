package org.apache.poi.poifs.filesystem;

import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.hpsf.ClassID;

/* JADX INFO: loaded from: classes4.dex */
public interface DirectoryEntry extends Entry, Iterable<Entry> {
    DirectoryEntry createDirectory(String str);

    DocumentEntry createDocument(String str, int i, POIFSWriterListener pOIFSWriterListener);

    DocumentEntry createDocument(String str, InputStream inputStream);

    Iterator<Entry> getEntries();

    Entry getEntry(String str);

    int getEntryCount();

    ClassID getStorageClsid();

    boolean isEmpty();

    void setStorageClsid(ClassID classID);
}
