package org.apache.poi.poifs.filesystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.poifs.property.Property;

/* JADX INFO: loaded from: classes4.dex */
public class DirectoryNode extends EntryNode implements DirectoryEntry, POIFSViewable, Iterable<Entry> {
    private Map<String, Entry> _byname;
    private ArrayList<Entry> _entries;
    private POIFSFileSystem _filesystem;
    private POIFSDocumentPath _path;

    public DirectoryNode(DirectoryProperty directoryProperty, POIFSFileSystem pOIFSFileSystem, DirectoryNode directoryNode) {
        super(directoryProperty, directoryNode);
        if (directoryNode == null) {
            this._path = new POIFSDocumentPath();
        } else {
            this._path = new POIFSDocumentPath(directoryNode._path, new String[]{directoryProperty.getName()});
        }
        this._filesystem = pOIFSFileSystem;
        this._byname = new HashMap();
        this._entries = new ArrayList<>();
        Iterator<Property> children = directoryProperty.getChildren();
        while (children.hasNext()) {
            Property next = children.next();
            Entry directoryNode2 = next.isDirectory() ? new DirectoryNode((DirectoryProperty) next, this._filesystem, this) : new DocumentNode((DocumentProperty) next, this);
            this._entries.add(directoryNode2);
            this._byname.put(directoryNode2.getName(), directoryNode2);
        }
    }

    public boolean changeName(String str, String str2) {
        EntryNode entryNode = (EntryNode) this._byname.get(str);
        if (entryNode == null) {
            return false;
        }
        boolean zChangeName = ((DirectoryProperty) getProperty()).changeName(entryNode.getProperty(), str2);
        if (!zChangeName) {
            return zChangeName;
        }
        this._byname.remove(str);
        this._byname.put(entryNode.getProperty().getName(), entryNode);
        return zChangeName;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DirectoryEntry createDirectory(String str) throws IOException {
        DirectoryProperty directoryProperty = new DirectoryProperty(str);
        DirectoryNode directoryNode = new DirectoryNode(directoryProperty, this._filesystem, this);
        ((DirectoryProperty) getProperty()).addChild(directoryProperty);
        this._filesystem.addDirectory(directoryProperty);
        this._entries.add(directoryNode);
        this._byname.put(str, directoryNode);
        return directoryNode;
    }

    public DocumentEntry createDocument(POIFSDocument pOIFSDocument) throws IOException {
        DocumentProperty documentProperty = pOIFSDocument.getDocumentProperty();
        DocumentNode documentNode = new DocumentNode(documentProperty, this);
        ((DirectoryProperty) getProperty()).addChild(documentProperty);
        this._filesystem.addDocument(pOIFSDocument);
        this._entries.add(documentNode);
        this._byname.put(documentProperty.getName(), documentNode);
        return documentNode;
    }

    public DocumentInputStream createDocumentInputStream(String str) throws IOException {
        Entry entry = getEntry(str);
        if (entry.isDocumentEntry()) {
            return new DocumentInputStream((DocumentEntry) entry);
        }
        throw new IOException("Entry '" + str + "' is not a DocumentEntry");
    }

    public boolean deleteEntry(EntryNode entryNode) {
        boolean zDeleteChild = ((DirectoryProperty) getProperty()).deleteChild(entryNode.getProperty());
        if (zDeleteChild) {
            this._entries.remove(entryNode);
            this._byname.remove(entryNode.getName());
            this._filesystem.remove(entryNode);
        }
        return zDeleteChild;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Iterator<Entry> getEntries() {
        return this._entries.iterator();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public Entry getEntry(String str) throws FileNotFoundException {
        Entry entry = str != null ? this._byname.get(str) : null;
        if (entry != null) {
            return entry;
        }
        throw new FileNotFoundException("no such entry: \"" + str + "\"");
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public int getEntryCount() {
        return this._entries.size();
    }

    public POIFSFileSystem getFileSystem() {
        return this._filesystem;
    }

    public POIFSDocumentPath getPath() {
        return this._path;
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public String getShortDescription() {
        return getName();
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public ClassID getStorageClsid() {
        return getProperty().getStorageClsid();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Object[] getViewableArray() {
        return new Object[0];
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Iterator getViewableIterator() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getProperty());
        Iterator<Entry> it = this._entries.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList.iterator();
    }

    @Override // org.apache.poi.poifs.filesystem.EntryNode
    public boolean isDeleteOK() {
        return isEmpty();
    }

    @Override // org.apache.poi.poifs.filesystem.EntryNode, org.apache.poi.poifs.filesystem.Entry
    public boolean isDirectoryEntry() {
        return true;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public boolean isEmpty() {
        return this._entries.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Entry> iterator() {
        return getEntries();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public boolean preferArray() {
        return false;
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public void setStorageClsid(ClassID classID) {
        getProperty().setStorageClsid(classID);
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DocumentEntry createDocument(String str, InputStream inputStream) {
        return createDocument(new POIFSDocument(str, inputStream));
    }

    @Override // org.apache.poi.poifs.filesystem.DirectoryEntry
    public DocumentEntry createDocument(String str, int i, POIFSWriterListener pOIFSWriterListener) {
        return createDocument(new POIFSDocument(str, i, this._path, pOIFSWriterListener));
    }
}
