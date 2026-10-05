package org.apache.poi.util;

import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: classes4.dex */
public class DrawingDump {
    public static void main(String[] strArr) {
        HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(strArr[0])));
        System.out.println("Drawing group:");
        hSSFWorkbook.dumpDrawingGroupRecords(true);
        for (int i = 1; i <= hSSFWorkbook.getNumberOfSheets(); i++) {
            System.out.println("Sheet " + i + ":");
            hSSFWorkbook.getSheetAt(i + (-1)).dumpDrawingRecords(true);
        }
    }
}
