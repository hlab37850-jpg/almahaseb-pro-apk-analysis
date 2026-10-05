package org.apache.poi.hpsf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes2.dex */
public class MutablePropertySet extends PropertySet {
    private final int OFFSET_HEADER;

    public MutablePropertySet() {
        byte[] bArr = PropertySet.BYTE_ORDER_ASSERTION;
        int length = bArr.length;
        byte[] bArr2 = PropertySet.FORMAT_ASSERTION;
        this.OFFSET_HEADER = length + bArr2.length + 24;
        this.byteOrder = LittleEndian.getUShort(bArr);
        this.format = LittleEndian.getUShort(bArr2);
        this.osVersion = 133636;
        this.classID = new ClassID();
        LinkedList linkedList = new LinkedList();
        this.sections = linkedList;
        linkedList.add(new MutableSection());
    }

    public void addSection(Section section) {
        if (this.sections == null) {
            this.sections = new LinkedList();
        }
        this.sections.add(section);
    }

    public void clearSections() {
        this.sections = null;
    }

    public void setByteOrder(int i) {
        this.byteOrder = i;
    }

    public void setClassID(ClassID classID) {
        this.classID = classID;
    }

    public void setFormat(int i) {
        this.format = i;
    }

    public void setOSVersion(int i) {
        this.osVersion = i;
    }

    public InputStream toInputStream() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(byteArrayOutputStream);
        byteArrayOutputStream.close();
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public void write(OutputStream outputStream) {
        int size = this.sections.size();
        TypeWriter.writeToStream(outputStream, (short) getByteOrder());
        TypeWriter.writeToStream(outputStream, (short) getFormat());
        TypeWriter.writeToStream(outputStream, getOSVersion());
        TypeWriter.writeToStream(outputStream, getClassID());
        TypeWriter.writeToStream(outputStream, size);
        int size2 = this.OFFSET_HEADER + (size * 20);
        ListIterator listIterator = this.sections.listIterator();
        while (listIterator.hasNext()) {
            MutableSection mutableSection = (MutableSection) listIterator.next();
            if (mutableSection.getFormatID() == null) {
                throw new NoFormatIDException();
            }
            TypeWriter.writeToStream(outputStream, mutableSection.getFormatID());
            TypeWriter.writeUIntToStream(outputStream, size2);
            try {
                size2 += mutableSection.getSize();
            } catch (HPSFRuntimeException e) {
                Throwable reason = e.getReason();
                if (!(reason instanceof UnsupportedEncodingException)) {
                    throw e;
                }
                throw new IllegalPropertySetDataException(reason);
            }
        }
        ListIterator listIterator2 = this.sections.listIterator();
        while (listIterator2.hasNext()) {
            ((MutableSection) listIterator2.next()).write(outputStream);
        }
    }

    public MutablePropertySet(PropertySet propertySet) {
        this.OFFSET_HEADER = PropertySet.BYTE_ORDER_ASSERTION.length + PropertySet.FORMAT_ASSERTION.length + 24;
        this.byteOrder = propertySet.getByteOrder();
        this.format = propertySet.getFormat();
        this.osVersion = propertySet.getOSVersion();
        setClassID(propertySet.getClassID());
        clearSections();
        if (this.sections == null) {
            this.sections = new LinkedList();
        }
        Iterator it = propertySet.getSections().iterator();
        while (it.hasNext()) {
            addSection(new MutableSection((Section) it.next()));
        }
    }

    public void write(DirectoryEntry directoryEntry, String str) {
        try {
            directoryEntry.getEntry(str).delete();
        } catch (FileNotFoundException unused) {
        }
        directoryEntry.createDocument(str, toInputStream());
    }
}
