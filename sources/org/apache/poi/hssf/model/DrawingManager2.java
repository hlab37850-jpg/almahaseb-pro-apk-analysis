package org.apache.poi.hssf.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ddf.EscherDgRecord;
import org.apache.poi.ddf.EscherDggRecord;

/* JADX INFO: loaded from: classes4.dex */
public class DrawingManager2 {
    EscherDggRecord dgg;
    List drawingGroups = new ArrayList();

    public DrawingManager2(EscherDggRecord escherDggRecord) {
        this.dgg = escherDggRecord;
    }

    public int allocateShapeId(short s) {
        return allocateShapeId(s, getDrawingGroup(s));
    }

    public void clearDrawingGroups() {
        this.drawingGroups.clear();
    }

    public EscherDgRecord createDgRecord() {
        EscherDgRecord escherDgRecord = new EscherDgRecord();
        escherDgRecord.setRecordId(EscherDgRecord.RECORD_ID);
        short sFindNewDrawingGroupId = findNewDrawingGroupId();
        escherDgRecord.setOptions((short) (sFindNewDrawingGroupId << 4));
        escherDgRecord.setNumShapes(0);
        escherDgRecord.setLastMSOSPID(-1);
        this.drawingGroups.add(escherDgRecord);
        this.dgg.addCluster(sFindNewDrawingGroupId, 0);
        EscherDggRecord escherDggRecord = this.dgg;
        escherDggRecord.setDrawingsSaved(escherDggRecord.getDrawingsSaved() + 1);
        return escherDgRecord;
    }

    public boolean drawingGroupExists(short s) {
        for (int i = 0; i < this.dgg.getFileIdClusters().length; i++) {
            if (this.dgg.getFileIdClusters()[i].getDrawingGroupId() == s) {
                return true;
            }
        }
        return false;
    }

    public int findFreeSPIDBlock() {
        return ((this.dgg.getShapeIdMax() / 1024) + 1) * 1024;
    }

    public short findNewDrawingGroupId() {
        short s = 1;
        while (drawingGroupExists(s)) {
            s = (short) (s + 1);
        }
        return s;
    }

    public EscherDggRecord getDgg() {
        return this.dgg;
    }

    public EscherDgRecord getDrawingGroup(int i) {
        return (EscherDgRecord) this.drawingGroups.get(i - 1);
    }

    public int allocateShapeId(short s, EscherDgRecord escherDgRecord) {
        EscherDggRecord escherDggRecord = this.dgg;
        escherDggRecord.setNumShapesSaved(escherDggRecord.getNumShapesSaved() + 1);
        for (int i = 0; i < this.dgg.getFileIdClusters().length; i++) {
            EscherDggRecord.FileIdCluster fileIdCluster = this.dgg.getFileIdClusters()[i];
            if (fileIdCluster.getDrawingGroupId() == s && fileIdCluster.getNumShapeIdsUsed() != 1024) {
                int numShapeIdsUsed = fileIdCluster.getNumShapeIdsUsed() + ((i + 1) * 1024);
                fileIdCluster.incrementShapeId();
                escherDgRecord.setNumShapes(escherDgRecord.getNumShapes() + 1);
                escherDgRecord.setLastMSOSPID(numShapeIdsUsed);
                if (numShapeIdsUsed >= this.dgg.getShapeIdMax()) {
                    this.dgg.setShapeIdMax(numShapeIdsUsed + 1);
                }
                return numShapeIdsUsed;
            }
        }
        this.dgg.addCluster(s, 0);
        this.dgg.getFileIdClusters()[this.dgg.getFileIdClusters().length - 1].incrementShapeId();
        escherDgRecord.setNumShapes(escherDgRecord.getNumShapes() + 1);
        int length = this.dgg.getFileIdClusters().length * 1024;
        escherDgRecord.setLastMSOSPID(length);
        if (length >= this.dgg.getShapeIdMax()) {
            this.dgg.setShapeIdMax(length + 1);
        }
        return length;
    }
}
