package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hpsf.wellknown.SectionIDMap;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes2.dex */
public class PropertySet {
    static final byte[] BYTE_ORDER_ASSERTION = {-2, -1};
    static final byte[] FORMAT_ASSERTION = {0, 0};
    public static final int OS_MACINTOSH = 1;
    public static final int OS_WIN16 = 0;
    public static final int OS_WIN32 = 2;
    protected int byteOrder;
    protected ClassID classID;
    protected int format;
    protected int osVersion;
    protected List sections;

    public PropertySet() {
    }

    private void init(byte[] bArr, int i, int i2) {
        this.byteOrder = LittleEndian.getUShort(bArr, i);
        this.format = LittleEndian.getUShort(bArr, i + 2);
        this.osVersion = (int) LittleEndian.getUInt(bArr, i + 4);
        this.classID = new ClassID(bArr, i + 8);
        int i3 = LittleEndian.getInt(bArr, i + 24);
        int i4 = i + 28;
        if (i3 < 0) {
            throw new HPSFRuntimeException("Section count " + i3 + " is negative.");
        }
        this.sections = new ArrayList(i3);
        for (int i5 = 0; i5 < i3; i5++) {
            Section section = new Section(bArr, i4);
            i4 += 20;
            this.sections.add(section);
        }
    }

    public static boolean isPropertySetStream(InputStream inputStream) throws MarkUnsupportedException, IOException {
        if (!inputStream.markSupported()) {
            throw new MarkUnsupportedException(inputStream.getClass().getName());
        }
        inputStream.mark(50);
        byte[] bArr = new byte[50];
        boolean zIsPropertySetStream = isPropertySetStream(bArr, 0, inputStream.read(bArr, 0, Math.min(50, inputStream.available())));
        inputStream.reset();
        return zIsPropertySetStream;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PropertySet)) {
            PropertySet propertySet = (PropertySet) obj;
            int byteOrder = propertySet.getByteOrder();
            int byteOrder2 = getByteOrder();
            ClassID classID = propertySet.getClassID();
            ClassID classID2 = getClassID();
            int format = propertySet.getFormat();
            int format2 = getFormat();
            int oSVersion = propertySet.getOSVersion();
            int oSVersion2 = getOSVersion();
            int sectionCount = propertySet.getSectionCount();
            int sectionCount2 = getSectionCount();
            if (byteOrder == byteOrder2 && classID.equals(classID2) && format == format2 && oSVersion == oSVersion2 && sectionCount == sectionCount2) {
                return Util.equals(getSections(), propertySet.getSections());
            }
        }
        return false;
    }

    public int getByteOrder() {
        return this.byteOrder;
    }

    public ClassID getClassID() {
        return this.classID;
    }

    public Section getFirstSection() {
        if (getSectionCount() >= 1) {
            return (Section) this.sections.get(0);
        }
        throw new MissingSectionException("Property set does not contain any sections.");
    }

    public int getFormat() {
        return this.format;
    }

    public int getOSVersion() {
        return this.osVersion;
    }

    public Property[] getProperties() {
        return getFirstSection().getProperties();
    }

    public Object getProperty(int i) {
        return getFirstSection().getProperty(i);
    }

    public boolean getPropertyBooleanValue(int i) {
        return getFirstSection().getPropertyBooleanValue(i);
    }

    public int getPropertyIntValue(int i) {
        return getFirstSection().getPropertyIntValue(i);
    }

    public int getSectionCount() {
        return this.sections.size();
    }

    public List getSections() {
        return this.sections;
    }

    public Section getSingleSection() {
        int sectionCount = getSectionCount();
        if (sectionCount == 1) {
            return (Section) this.sections.get(0);
        }
        throw new NoSingleSectionException("Property set contains " + sectionCount + " sections.");
    }

    public int hashCode() {
        throw new UnsupportedOperationException("FIXME: Not yet implemented.");
    }

    public boolean isDocumentSummaryInformation() {
        if (this.sections.size() <= 0) {
            return false;
        }
        return Util.equal(((Section) this.sections.get(0)).getFormatID().getBytes(), SectionIDMap.DOCUMENT_SUMMARY_INFORMATION_ID[0]);
    }

    public boolean isSummaryInformation() {
        if (this.sections.size() <= 0) {
            return false;
        }
        return Util.equal(((Section) this.sections.get(0)).getFormatID().getBytes(), SectionIDMap.SUMMARY_INFORMATION_ID);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int sectionCount = getSectionCount();
        stringBuffer.append(getClass().getName());
        stringBuffer.append('[');
        stringBuffer.append("byteOrder: ");
        stringBuffer.append(getByteOrder());
        stringBuffer.append(", classID: ");
        stringBuffer.append(getClassID());
        stringBuffer.append(", format: ");
        stringBuffer.append(getFormat());
        stringBuffer.append(", OSVersion: ");
        stringBuffer.append(getOSVersion());
        stringBuffer.append(", sectionCount: ");
        stringBuffer.append(sectionCount);
        stringBuffer.append(", sections: [\n");
        List sections = getSections();
        for (int i = 0; i < sectionCount; i++) {
            stringBuffer.append(((Section) sections.get(i)).toString());
        }
        stringBuffer.append(']');
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public boolean wasNull() {
        return getFirstSection().wasNull();
    }

    public PropertySet(InputStream inputStream) throws NoPropertySetStreamException, IOException {
        if (!isPropertySetStream(inputStream)) {
            throw new NoPropertySetStreamException();
        }
        int iAvailable = inputStream.available();
        byte[] bArr = new byte[iAvailable];
        inputStream.read(bArr, 0, iAvailable);
        init(bArr, 0, iAvailable);
    }

    public static boolean isPropertySetStream(byte[] bArr, int i, int i2) {
        int i3 = i + 2;
        byte[] bArr2 = new byte[2];
        LittleEndian.putShort(bArr2, (short) LittleEndian.getUShort(bArr, i));
        if (!Util.equal(bArr2, BYTE_ORDER_ASSERTION)) {
            return false;
        }
        int uShort = LittleEndian.getUShort(bArr, i3);
        byte[] bArr3 = new byte[2];
        LittleEndian.putShort(bArr3, (short) uShort);
        return Util.equal(bArr3, FORMAT_ASSERTION) && LittleEndian.getUInt(bArr, i + 24) >= 0;
    }

    public PropertySet(byte[] bArr, int i, int i2) throws NoPropertySetStreamException {
        if (isPropertySetStream(bArr, i, i2)) {
            init(bArr, i, i2);
            return;
        }
        throw new NoPropertySetStreamException();
    }

    public PropertySet(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }
}
