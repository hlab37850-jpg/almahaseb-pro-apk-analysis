package org.apache.poi.hpsf;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.poifs.filesystem.DirectoryEntry;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SpecialPropertySet extends MutablePropertySet {
    private MutablePropertySet delegate;

    public SpecialPropertySet(PropertySet propertySet) {
        this.delegate = new MutablePropertySet(propertySet);
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void addSection(Section section) {
        this.delegate.addSection(section);
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void clearSections() {
        this.delegate.clearSections();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public boolean equals(Object obj) {
        return this.delegate.equals(obj);
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public int getByteOrder() {
        return this.delegate.getByteOrder();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public ClassID getClassID() {
        return this.delegate.getClassID();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public Section getFirstSection() {
        return this.delegate.getFirstSection();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public int getFormat() {
        return this.delegate.getFormat();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public int getOSVersion() {
        return this.delegate.getOSVersion();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public Property[] getProperties() {
        return this.delegate.getProperties();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public Object getProperty(int i) {
        return this.delegate.getProperty(i);
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public boolean getPropertyBooleanValue(int i) {
        return this.delegate.getPropertyBooleanValue(i);
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public int getPropertyIntValue(int i) {
        return this.delegate.getPropertyIntValue(i);
    }

    public abstract PropertyIDMap getPropertySetIDMap();

    @Override // org.apache.poi.hpsf.PropertySet
    public int getSectionCount() {
        return this.delegate.getSectionCount();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public List getSections() {
        return this.delegate.getSections();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public boolean isDocumentSummaryInformation() {
        return this.delegate.isDocumentSummaryInformation();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public boolean isSummaryInformation() {
        return this.delegate.isSummaryInformation();
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void setByteOrder(int i) {
        this.delegate.setByteOrder(i);
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void setClassID(ClassID classID) {
        this.delegate.setClassID(classID);
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void setFormat(int i) {
        this.delegate.setFormat(i);
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void setOSVersion(int i) {
        this.delegate.setOSVersion(i);
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public InputStream toInputStream() {
        return this.delegate.toInputStream();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public String toString() {
        return this.delegate.toString();
    }

    @Override // org.apache.poi.hpsf.PropertySet
    public boolean wasNull() {
        return this.delegate.wasNull();
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void write(DirectoryEntry directoryEntry, String str) {
        this.delegate.write(directoryEntry, str);
    }

    @Override // org.apache.poi.hpsf.MutablePropertySet
    public void write(OutputStream outputStream) {
        this.delegate.write(outputStream);
    }

    public SpecialPropertySet(MutablePropertySet mutablePropertySet) {
        this.delegate = mutablePropertySet;
    }
}
