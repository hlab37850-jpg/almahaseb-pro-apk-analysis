package org.apache.poi.hpsf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.hpsf.wellknown.SectionIDMap;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes2.dex */
public class Section {
    protected Map<Long, String> dictionary;
    protected ClassID formatID;
    protected long offset;
    protected Property[] properties;
    protected int size;
    private boolean wasNull;

    public class PropertyListEntry implements Comparable<PropertyListEntry> {
        int id;
        int length;
        int offset;

        public PropertyListEntry() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(getClass().getName());
            stringBuffer.append("[id=");
            stringBuffer.append(this.id);
            stringBuffer.append(", offset=");
            stringBuffer.append(this.offset);
            stringBuffer.append(", length=");
            stringBuffer.append(this.length);
            stringBuffer.append(']');
            return stringBuffer.toString();
        }

        @Override // java.lang.Comparable
        public int compareTo(PropertyListEntry propertyListEntry) {
            int i = propertyListEntry.offset;
            int i2 = this.offset;
            if (i2 < i) {
                return -1;
            }
            return i2 == i ? 0 : 1;
        }
    }

    public Section() {
    }

    private Property[] remove(Property[] propertyArr, int i) {
        int length = propertyArr.length - 1;
        Property[] propertyArr2 = new Property[length];
        if (i > 0) {
            System.arraycopy(propertyArr, 0, propertyArr2, 0, i);
        }
        System.arraycopy(propertyArr, i + 1, propertyArr2, i, length - i);
        return propertyArr2;
    }

    public boolean equals(Object obj) {
        boolean zEquals;
        if (obj != null && (obj instanceof Section)) {
            Section section = (Section) obj;
            if (!section.getFormatID().equals(getFormatID())) {
                return false;
            }
            int length = getProperties().length;
            Property[] propertyArrRemove = new Property[length];
            int length2 = section.getProperties().length;
            Property[] propertyArrRemove2 = new Property[length2];
            System.arraycopy(getProperties(), 0, propertyArrRemove, 0, length);
            System.arraycopy(section.getProperties(), 0, propertyArrRemove2, 0, length2);
            Property property = null;
            Property property2 = null;
            int i = 0;
            while (true) {
                zEquals = true;
                if (i >= propertyArrRemove.length) {
                    break;
                }
                long id = propertyArrRemove[i].getID();
                if (id == 0) {
                    property2 = propertyArrRemove[i];
                    propertyArrRemove = remove(propertyArrRemove, i);
                    i--;
                }
                if (id == 1) {
                    propertyArrRemove = remove(propertyArrRemove, i);
                    i--;
                }
                i++;
            }
            int i2 = 0;
            while (i2 < propertyArrRemove2.length) {
                long id2 = propertyArrRemove2[i2].getID();
                if (id2 == 0) {
                    property = propertyArrRemove2[i2];
                    propertyArrRemove2 = remove(propertyArrRemove2, i2);
                    i2--;
                }
                if (id2 == 1) {
                    propertyArrRemove2 = remove(propertyArrRemove2, i2);
                    i2--;
                }
                i2++;
            }
            if (propertyArrRemove.length != propertyArrRemove2.length) {
                return false;
            }
            if (property2 != null && property != null) {
                zEquals = property2.getValue().equals(property.getValue());
            } else if (property2 != null || property != null) {
                zEquals = false;
            }
            if (zEquals) {
                return Util.equals(propertyArrRemove, propertyArrRemove2);
            }
        }
        return false;
    }

    public int getCodepage() {
        Integer num = (Integer) getProperty(1L);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public Map<Long, String> getDictionary() {
        return this.dictionary;
    }

    public ClassID getFormatID() {
        return this.formatID;
    }

    public long getOffset() {
        return this.offset;
    }

    public String getPIDString(long j) {
        Map<Long, String> map = this.dictionary;
        String pIDString = map != null ? map.get(Long.valueOf(j)) : null;
        if (pIDString == null) {
            pIDString = SectionIDMap.getPIDString(getFormatID().getBytes(), j);
        }
        return pIDString == null ? SectionIDMap.UNDEFINED : pIDString;
    }

    public Property[] getProperties() {
        return this.properties;
    }

    public Object getProperty(long j) {
        int i = 0;
        this.wasNull = false;
        while (true) {
            Property[] propertyArr = this.properties;
            if (i >= propertyArr.length) {
                this.wasNull = true;
                return null;
            }
            if (j == propertyArr[i].getID()) {
                return this.properties[i].getValue();
            }
            i++;
        }
    }

    public boolean getPropertyBooleanValue(int i) {
        Boolean bool = (Boolean) getProperty(i);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public int getPropertyCount() {
        return this.properties.length;
    }

    public int getPropertyIntValue(long j) {
        Object property = getProperty(j);
        if (property == null) {
            return 0;
        }
        if ((property instanceof Long) || (property instanceof Integer)) {
            return ((Number) property).intValue();
        }
        throw new HPSFRuntimeException("This property is not an integer type, but " + property.getClass().getName() + ".");
    }

    public int getSize() {
        return this.size;
    }

    public int hashCode() {
        long jHashCode = getFormatID().hashCode();
        for (Property property : getProperties()) {
            jHashCode += (long) property.hashCode();
        }
        return (int) (jHashCode & 4294967295L);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Property[] properties = getProperties();
        stringBuffer.append(getClass().getName());
        stringBuffer.append('[');
        stringBuffer.append("formatID: ");
        stringBuffer.append(getFormatID());
        stringBuffer.append(", offset: ");
        stringBuffer.append(getOffset());
        stringBuffer.append(", propertyCount: ");
        stringBuffer.append(getPropertyCount());
        stringBuffer.append(", size: ");
        stringBuffer.append(getSize());
        stringBuffer.append(", properties: [\n");
        for (Property property : properties) {
            stringBuffer.append(property.toString());
            stringBuffer.append(",\n");
        }
        stringBuffer.append(']');
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public boolean wasNull() {
        return this.wasNull;
    }

    public Section(byte[] bArr, int i) {
        int i2;
        this.formatID = new ClassID(bArr, i);
        long uInt = LittleEndian.getUInt(bArr, i + 16);
        this.offset = uInt;
        int i3 = (int) uInt;
        this.size = (int) LittleEndian.getUInt(bArr, i3);
        int uInt2 = (int) LittleEndian.getUInt(bArr, i3 + 4);
        int i4 = i3 + 8;
        this.properties = new Property[uInt2];
        ArrayList<PropertyListEntry> arrayList = new ArrayList(uInt2);
        int i5 = 0;
        for (int i6 = 0; i6 < this.properties.length; i6++) {
            PropertyListEntry propertyListEntry = new PropertyListEntry();
            propertyListEntry.id = (int) LittleEndian.getUInt(bArr, i4);
            propertyListEntry.offset = (int) LittleEndian.getUInt(bArr, i4 + 4);
            i4 += 8;
            arrayList.add(propertyListEntry);
        }
        Collections.sort(arrayList);
        int i7 = 0;
        while (true) {
            i2 = uInt2 - 1;
            if (i7 >= i2) {
                break;
            }
            PropertyListEntry propertyListEntry2 = (PropertyListEntry) arrayList.get(i7);
            i7++;
            propertyListEntry2.length = ((PropertyListEntry) arrayList.get(i7)).offset - propertyListEntry2.offset;
        }
        if (uInt2 > 0) {
            PropertyListEntry propertyListEntry3 = (PropertyListEntry) arrayList.get(i2);
            propertyListEntry3.length = this.size - propertyListEntry3.offset;
        }
        Iterator it = arrayList.iterator();
        int uShort = -1;
        while (uShort == -1 && it.hasNext()) {
            PropertyListEntry propertyListEntry4 = (PropertyListEntry) it.next();
            if (propertyListEntry4.id == 1) {
                int i8 = (int) (this.offset + ((long) propertyListEntry4.offset));
                long uInt3 = LittleEndian.getUInt(bArr, i8);
                int i9 = i8 + 4;
                if (uInt3 != 2) {
                    throw new HPSFRuntimeException("Value type of property ID 1 is not VT_I2 but " + uInt3 + ".");
                }
                uShort = LittleEndian.getUShort(bArr, i9);
            }
        }
        for (PropertyListEntry propertyListEntry5 : arrayList) {
            Property property = new Property(propertyListEntry5.id, bArr, this.offset + ((long) propertyListEntry5.offset), propertyListEntry5.length, uShort);
            if (property.getID() == 1) {
                property = new Property(property.getID(), property.getType(), Integer.valueOf(uShort));
            }
            this.properties[i5] = property;
            i5++;
        }
        this.dictionary = (Map) getProperty(0L);
    }
}
