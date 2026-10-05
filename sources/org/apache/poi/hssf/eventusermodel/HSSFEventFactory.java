package org.apache.poi.hssf.eventusermodel;

import java.io.InputStream;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactoryInputStream;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: classes4.dex */
public class HSSFEventFactory {
    private short genericProcessEvents(HSSFRequest hSSFRequest, InputStream inputStream) {
        short sProcessRecord = 0;
        RecordFactoryInputStream recordFactoryInputStream = new RecordFactoryInputStream(inputStream, false);
        do {
            Record recordNextRecord = recordFactoryInputStream.nextRecord();
            if (recordNextRecord == null) {
                break;
            }
            sProcessRecord = hSSFRequest.processRecord(recordNextRecord);
        } while (sProcessRecord == 0);
        return sProcessRecord;
    }

    public short abortableProcessEvents(HSSFRequest hSSFRequest, InputStream inputStream) {
        return genericProcessEvents(hSSFRequest, inputStream);
    }

    public short abortableProcessWorkbookEvents(HSSFRequest hSSFRequest, POIFSFileSystem pOIFSFileSystem) {
        return abortableProcessWorkbookEvents(hSSFRequest, pOIFSFileSystem.getRoot());
    }

    public void processEvents(HSSFRequest hSSFRequest, InputStream inputStream) {
        try {
            genericProcessEvents(hSSFRequest, inputStream);
        } catch (HSSFUserException unused) {
        }
    }

    public void processWorkbookEvents(HSSFRequest hSSFRequest, POIFSFileSystem pOIFSFileSystem) {
        processWorkbookEvents(hSSFRequest, pOIFSFileSystem.getRoot());
    }

    public short abortableProcessWorkbookEvents(HSSFRequest hSSFRequest, DirectoryNode directoryNode) {
        return abortableProcessEvents(hSSFRequest, directoryNode.createDocumentInputStream("Workbook"));
    }

    public void processWorkbookEvents(HSSFRequest hSSFRequest, DirectoryNode directoryNode) {
        processEvents(hSSFRequest, directoryNode.createDocumentInputStream("Workbook"));
    }
}
