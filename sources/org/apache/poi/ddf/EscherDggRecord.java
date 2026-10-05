package org.apache.poi.ddf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes2.dex */
public final class EscherDggRecord extends EscherRecord {
    private static final Comparator<FileIdCluster> MY_COMP = new Comparator<FileIdCluster>() { // from class: org.apache.poi.ddf.EscherDggRecord.1
        @Override // java.util.Comparator
        public int compare(FileIdCluster fileIdCluster, FileIdCluster fileIdCluster2) {
            if (fileIdCluster.getDrawingGroupId() == fileIdCluster2.getDrawingGroupId()) {
                return 0;
            }
            return fileIdCluster.getDrawingGroupId() < fileIdCluster2.getDrawingGroupId() ? -1 : 1;
        }
    };
    public static final String RECORD_DESCRIPTION = "MsofbtDgg";
    public static final short RECORD_ID = -4090;
    private int field_1_shapeIdMax;
    private int field_3_numShapesSaved;
    private int field_4_drawingsSaved;
    private FileIdCluster[] field_5_fileIdClusters;
    private int maxDgId;

    public static class FileIdCluster {
        private int field_1_drawingGroupId;
        private int field_2_numShapeIdsUsed;

        public FileIdCluster(int i, int i2) {
            this.field_1_drawingGroupId = i;
            this.field_2_numShapeIdsUsed = i2;
        }

        public int getDrawingGroupId() {
            return this.field_1_drawingGroupId;
        }

        public int getNumShapeIdsUsed() {
            return this.field_2_numShapeIdsUsed;
        }

        public void incrementShapeId() {
            this.field_2_numShapeIdsUsed++;
        }
    }

    public void addCluster(int i, int i2) {
        addCluster(i, i2, true);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        int i2 = i + 8;
        this.field_1_shapeIdMax = LittleEndian.getInt(bArr, i2);
        LittleEndian.getInt(bArr, i + 12);
        this.field_3_numShapesSaved = LittleEndian.getInt(bArr, i + 16);
        this.field_4_drawingsSaved = LittleEndian.getInt(bArr, i + 20);
        this.field_5_fileIdClusters = new FileIdCluster[(header - 16) / 8];
        int i3 = 16;
        int i4 = 0;
        while (true) {
            FileIdCluster[] fileIdClusterArr = this.field_5_fileIdClusters;
            if (i4 >= fileIdClusterArr.length) {
                break;
            }
            int i5 = i2 + i3;
            fileIdClusterArr[i4] = new FileIdCluster(LittleEndian.getInt(bArr, i5), LittleEndian.getInt(bArr, i5 + 4));
            this.maxDgId = Math.max(this.maxDgId, this.field_5_fileIdClusters[i4].getDrawingGroupId());
            i3 += 8;
            i4++;
        }
        int i6 = header - i3;
        if (i6 == 0) {
            return i3 + 8 + i6;
        }
        throw new RecordFormatException("Expecting no remaining data but got " + i6 + " byte(s).");
    }

    public int getDrawingsSaved() {
        return this.field_4_drawingsSaved;
    }

    public FileIdCluster[] getFileIdClusters() {
        return this.field_5_fileIdClusters;
    }

    public int getMaxDrawingGroupId() {
        return this.maxDgId;
    }

    public int getNumIdClusters() {
        FileIdCluster[] fileIdClusterArr = this.field_5_fileIdClusters;
        if (fileIdClusterArr == null) {
            return 0;
        }
        return fileIdClusterArr.length + 1;
    }

    public int getNumShapesSaved() {
        return this.field_3_numShapesSaved;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Dgg";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return (this.field_5_fileIdClusters.length * 8) + 24;
    }

    public int getShapeIdMax() {
        return this.field_1_shapeIdMax;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, getRecordSize() - 8);
        LittleEndian.putInt(bArr, i + 8, this.field_1_shapeIdMax);
        LittleEndian.putInt(bArr, i + 12, getNumIdClusters());
        LittleEndian.putInt(bArr, i + 16, this.field_3_numShapesSaved);
        LittleEndian.putInt(bArr, i + 20, this.field_4_drawingsSaved);
        int i2 = i + 24;
        int i3 = 0;
        while (true) {
            FileIdCluster[] fileIdClusterArr = this.field_5_fileIdClusters;
            if (i3 >= fileIdClusterArr.length) {
                escherSerializationListener.afterRecordSerialize(i2, getRecordId(), getRecordSize(), this);
                return getRecordSize();
            }
            LittleEndian.putInt(bArr, i2, fileIdClusterArr[i3].field_1_drawingGroupId);
            LittleEndian.putInt(bArr, i2 + 4, this.field_5_fileIdClusters[i3].field_2_numShapeIdsUsed);
            i2 += 8;
            i3++;
        }
    }

    public void setDrawingsSaved(int i) {
        this.field_4_drawingsSaved = i;
    }

    public void setFileIdClusters(FileIdCluster[] fileIdClusterArr) {
        this.field_5_fileIdClusters = fileIdClusterArr;
    }

    public void setMaxDrawingGroupId(int i) {
        this.maxDgId = i;
    }

    public void setNumShapesSaved(int i) {
        this.field_3_numShapesSaved = i;
    }

    public void setShapeIdMax(int i) {
        this.field_1_shapeIdMax = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.field_5_fileIdClusters != null) {
            int i = 0;
            while (i < this.field_5_fileIdClusters.length) {
                stringBuffer.append("  DrawingGroupId");
                int i2 = i + 1;
                stringBuffer.append(i2);
                stringBuffer.append(": ");
                stringBuffer.append(this.field_5_fileIdClusters[i].field_1_drawingGroupId);
                stringBuffer.append('\n');
                stringBuffer.append("  NumShapeIdsUsed");
                stringBuffer.append(i2);
                stringBuffer.append(": ");
                stringBuffer.append(this.field_5_fileIdClusters[i].field_2_numShapeIdsUsed);
                stringBuffer.append('\n');
                i = i2;
            }
        }
        return EscherDggRecord.class.getName() + ":\n  RecordId: 0x" + HexDump.toHex(RECORD_ID) + "\n  Options: 0x" + HexDump.toHex(getOptions()) + "\n  ShapeIdMax: " + this.field_1_shapeIdMax + "\n  NumIdClusters: " + getNumIdClusters() + "\n  NumShapesSaved: " + this.field_3_numShapesSaved + "\n  DrawingsSaved: " + this.field_4_drawingsSaved + "\n" + stringBuffer.toString();
    }

    public void addCluster(int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList(Arrays.asList(this.field_5_fileIdClusters));
        arrayList.add(new FileIdCluster(i, i2));
        if (z) {
            Collections.sort(arrayList, MY_COMP);
        }
        this.maxDgId = Math.min(this.maxDgId, i);
        this.field_5_fileIdClusters = (FileIdCluster[]) arrayList.toArray(new FileIdCluster[arrayList.size()]);
    }
}
