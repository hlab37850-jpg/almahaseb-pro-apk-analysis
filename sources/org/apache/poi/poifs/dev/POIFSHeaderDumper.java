package org.apache.poi.poifs.dev;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.property.PropertyTable;
import org.apache.poi.poifs.storage.BlockAllocationTableReader;
import org.apache.poi.poifs.storage.HeaderBlockReader;
import org.apache.poi.poifs.storage.ListManagedBlock;
import org.apache.poi.poifs.storage.RawDataBlockList;
import org.apache.poi.poifs.storage.SmallBlockTableReader;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IntList;

/* JADX INFO: loaded from: classes4.dex */
public class POIFSHeaderDumper {
    public static void displayBATReader(BlockAllocationTableReader blockAllocationTableReader) throws NoSuchFieldException {
        System.out.println("Sectors, as referenced from the FAT:");
        Field declaredField = blockAllocationTableReader.getClass().getDeclaredField("_entries");
        declaredField.setAccessible(true);
        IntList intList = (IntList) declaredField.get(blockAllocationTableReader);
        for (int i = 0; i < intList.size(); i++) {
            int i2 = intList.get(i);
            String string = Integer.toString(i2);
            if (i2 == -2) {
                string = "End Of Chain";
            } else if (i2 == -4) {
                string = "DI Fat Block";
            } else if (i2 == -3) {
                string = "Normal Fat Block";
            } else if (i2 == -1) {
                string = "Block Not Used (Free)";
            }
            System.out.println("  Block  # " + i + " -> " + string);
        }
        System.out.println("");
    }

    public static void displayHeader(HeaderBlockReader headerBlockReader) {
        PrintStream printStream = System.out;
        printStream.println("Header Details:");
        printStream.println(" Block size: " + headerBlockReader.getBigBlockSize());
        printStream.println(" BAT (FAT) header blocks: " + headerBlockReader.getBATArray().length);
        printStream.println(" BAT (FAT) block count: " + headerBlockReader.getBATCount());
        printStream.println(" XBAT (FAT) block count: " + headerBlockReader.getXBATCount());
        printStream.println(" XBAT (FAT) block 1 at: " + headerBlockReader.getXBATIndex());
        printStream.println(" SBAT (MiniFAT) block count: " + headerBlockReader.getSBATCount());
        printStream.println(" SBAT (MiniFAT) block 1 at: " + headerBlockReader.getSBATStart());
        printStream.println(" Property table at: " + headerBlockReader.getPropertyStart());
        printStream.println("");
    }

    public static void displayRawBlocksSummary(RawDataBlockList rawDataBlockList) throws NoSuchMethodException {
        PrintStream printStream = System.out;
        printStream.println("Raw Blocks Details:");
        printStream.println(" Number of blocks: " + rawDataBlockList.blockCount());
        Method declaredMethod = rawDataBlockList.getClass().getSuperclass().getDeclaredMethod("get", Integer.TYPE);
        declaredMethod.setAccessible(true);
        for (int i = 0; i < Math.min(16, rawDataBlockList.blockCount()); i++) {
            ListManagedBlock listManagedBlock = (ListManagedBlock) declaredMethod.invoke(rawDataBlockList, new Integer(i));
            int iMin = Math.min(48, listManagedBlock.getData().length);
            byte[] bArr = new byte[iMin];
            System.arraycopy(listManagedBlock.getData(), 0, bArr, 0, iMin);
            PrintStream printStream2 = System.out;
            printStream2.println(" Block #" + i + ":");
            printStream2.println(HexDump.dump(bArr, 0L, 0));
        }
        System.out.println("");
    }

    public static void main(String[] strArr) throws NoSuchFieldException, NoSuchMethodException {
        if (strArr.length == 0) {
            System.err.println("Must specify at least one file to view");
            System.exit(1);
        }
        for (String str : strArr) {
            viewFile(str);
        }
    }

    public static void viewFile(String str) throws NoSuchFieldException, NoSuchMethodException {
        FileInputStream fileInputStream = new FileInputStream(str);
        HeaderBlockReader headerBlockReader = new HeaderBlockReader(fileInputStream);
        displayHeader(headerBlockReader);
        POIFSBigBlockSize bigBlockSize = headerBlockReader.getBigBlockSize();
        RawDataBlockList rawDataBlockList = new RawDataBlockList(fileInputStream, bigBlockSize);
        displayRawBlocksSummary(rawDataBlockList);
        displayBATReader(new BlockAllocationTableReader(headerBlockReader.getBigBlockSize(), headerBlockReader.getBATCount(), headerBlockReader.getBATArray(), headerBlockReader.getXBATCount(), headerBlockReader.getXBATIndex(), rawDataBlockList));
        SmallBlockTableReader.getSmallDocumentBlocks(bigBlockSize, rawDataBlockList, new PropertyTable(headerBlockReader.getBigBlockSize(), headerBlockReader.getPropertyStart(), rawDataBlockList).getRoot(), headerBlockReader.getSBATStart());
    }
}
