package org.apache.poi.hssf.model;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ddf.EscherDgRecord;
import org.apache.poi.ddf.EscherDggRecord;

/* JADX INFO: loaded from: classes4.dex */
public class DrawingManager {
    Map dgMap = new HashMap();
    EscherDggRecord dgg;

    public DrawingManager(EscherDggRecord escherDggRecord) {
        this.dgg = escherDggRecord;
    }

    public int allocateShapeId(short s) {
        int iFindFreeSPIDBlock;
        EscherDgRecord escherDgRecord = (EscherDgRecord) this.dgMap.get(Short.valueOf(s));
        if (escherDgRecord.getLastMSOSPID() % 1024 == 1023) {
            iFindFreeSPIDBlock = findFreeSPIDBlock();
            this.dgg.addCluster(s, 1);
        } else {
            int iFindFreeSPIDBlock2 = 0;
            for (int i = 0; i < this.dgg.getFileIdClusters().length; i++) {
                EscherDggRecord.FileIdCluster fileIdCluster = this.dgg.getFileIdClusters()[i];
                if (fileIdCluster.getDrawingGroupId() == s && fileIdCluster.getNumShapeIdsUsed() != 1024) {
                    fileIdCluster.incrementShapeId();
                }
                iFindFreeSPIDBlock2 = escherDgRecord.getLastMSOSPID() == -1 ? findFreeSPIDBlock() : escherDgRecord.getLastMSOSPID() + 1;
            }
            iFindFreeSPIDBlock = iFindFreeSPIDBlock2;
        }
        EscherDggRecord escherDggRecord = this.dgg;
        escherDggRecord.setNumShapesSaved(escherDggRecord.getNumShapesSaved() + 1);
        if (iFindFreeSPIDBlock >= this.dgg.getShapeIdMax()) {
            this.dgg.setShapeIdMax(iFindFreeSPIDBlock + 1);
        }
        escherDgRecord.setLastMSOSPID(iFindFreeSPIDBlock);
        escherDgRecord.incrementShapeCount();
        return iFindFreeSPIDBlock;
    }

    public EscherDgRecord createDgRecord() {
        EscherDgRecord escherDgRecord = new EscherDgRecord();
        escherDgRecord.setRecordId(EscherDgRecord.RECORD_ID);
        short sFindNewDrawingGroupId = findNewDrawingGroupId();
        escherDgRecord.setOptions((short) (sFindNewDrawingGroupId << 4));
        escherDgRecord.setNumShapes(0);
        escherDgRecord.setLastMSOSPID(-1);
        this.dgg.addCluster(sFindNewDrawingGroupId, 0);
        EscherDggRecord escherDggRecord = this.dgg;
        escherDggRecord.setDrawingsSaved(escherDggRecord.getDrawingsSaved() + 1);
        this.dgMap.put(Short.valueOf(sFindNewDrawingGroupId), escherDgRecord);
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
}
