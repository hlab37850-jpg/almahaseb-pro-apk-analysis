package org.apache.poi.poifs.eventfilesystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSDocument;
import org.apache.poi.poifs.filesystem.POIFSDocumentPath;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.Property;
import org.apache.poi.poifs.property.PropertyTable;
import org.apache.poi.poifs.storage.BlockAllocationTableReader;
import org.apache.poi.poifs.storage.BlockList;
import org.apache.poi.poifs.storage.HeaderBlockReader;
import org.apache.poi.poifs.storage.RawDataBlockList;
import org.apache.poi.poifs.storage.SmallBlockTableReader;

/* JADX INFO: loaded from: classes4.dex */
public class POIFSReader {
    private POIFSReaderRegistry registry = new POIFSReaderRegistry();
    private boolean registryClosed = false;

    public static class SampleListener implements POIFSReaderListener {
        @Override // org.apache.poi.poifs.eventfilesystem.POIFSReaderListener
        public void processPOIFSReaderEvent(POIFSReaderEvent pOIFSReaderEvent) {
            DocumentInputStream stream = pOIFSReaderEvent.getStream();
            POIFSDocumentPath path = pOIFSReaderEvent.getPath();
            String name = pOIFSReaderEvent.getName();
            try {
                int iAvailable = stream.available();
                stream.read(new byte[iAvailable]);
                int length = path.length();
                for (int i = 0; i < length; i++) {
                    System.out.print("/" + path.getComponent(i));
                }
                System.out.println("/" + name + ": " + iAvailable + " bytes read");
            } catch (IOException unused) {
            }
        }
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length == 0) {
            System.err.println("at least one argument required: input filename(s)");
            System.exit(1);
        }
        for (int i = 0; i < strArr.length; i++) {
            POIFSReader pOIFSReader = new POIFSReader();
            pOIFSReader.registerListener(new SampleListener());
            System.out.println("reading " + strArr[i]);
            FileInputStream fileInputStream = new FileInputStream(strArr[i]);
            pOIFSReader.read(fileInputStream);
            fileInputStream.close();
        }
    }

    private void processProperties(BlockList blockList, BlockList blockList2, Iterator it, POIFSDocumentPath pOIFSDocumentPath) {
        while (it.hasNext()) {
            Property property = (Property) it.next();
            String name = property.getName();
            if (property.isDirectory()) {
                processProperties(blockList, blockList2, ((DirectoryProperty) property).getChildren(), new POIFSDocumentPath(pOIFSDocumentPath, new String[]{name}));
            } else {
                int startBlock = property.getStartBlock();
                Iterator listeners = this.registry.getListeners(pOIFSDocumentPath, name);
                if (listeners.hasNext()) {
                    int size = property.getSize();
                    POIFSDocument pOIFSDocument = property.shouldUseSmallBlocks() ? new POIFSDocument(name, blockList.fetchBlocks(startBlock, -1), size) : new POIFSDocument(name, blockList2.fetchBlocks(startBlock, -1), size);
                    while (listeners.hasNext()) {
                        ((POIFSReaderListener) listeners.next()).processPOIFSReaderEvent(new POIFSReaderEvent(new DocumentInputStream(pOIFSDocument), pOIFSDocumentPath, name));
                    }
                } else if (property.shouldUseSmallBlocks()) {
                    blockList.fetchBlocks(startBlock, -1);
                } else {
                    blockList2.fetchBlocks(startBlock, -1);
                }
            }
        }
    }

    public void read(InputStream inputStream) {
        this.registryClosed = true;
        HeaderBlockReader headerBlockReader = new HeaderBlockReader(inputStream);
        RawDataBlockList rawDataBlockList = new RawDataBlockList(inputStream, headerBlockReader.getBigBlockSize());
        new BlockAllocationTableReader(headerBlockReader.getBigBlockSize(), headerBlockReader.getBATCount(), headerBlockReader.getBATArray(), headerBlockReader.getXBATCount(), headerBlockReader.getXBATIndex(), rawDataBlockList);
        PropertyTable propertyTable = new PropertyTable(headerBlockReader.getBigBlockSize(), headerBlockReader.getPropertyStart(), rawDataBlockList);
        processProperties(SmallBlockTableReader.getSmallDocumentBlocks(headerBlockReader.getBigBlockSize(), rawDataBlockList, propertyTable.getRoot(), headerBlockReader.getSBATStart()), rawDataBlockList, propertyTable.getRoot().getChildren(), new POIFSDocumentPath());
    }

    public void registerListener(POIFSReaderListener pOIFSReaderListener) {
        pOIFSReaderListener.getClass();
        if (this.registryClosed) {
            throw new IllegalStateException();
        }
        this.registry.registerListener(pOIFSReaderListener);
    }

    public void registerListener(POIFSReaderListener pOIFSReaderListener, String str) {
        registerListener(pOIFSReaderListener, null, str);
    }

    public void registerListener(POIFSReaderListener pOIFSReaderListener, POIFSDocumentPath pOIFSDocumentPath, String str) {
        if (pOIFSReaderListener != null && str != null && str.length() != 0) {
            if (!this.registryClosed) {
                POIFSReaderRegistry pOIFSReaderRegistry = this.registry;
                if (pOIFSDocumentPath == null) {
                    pOIFSDocumentPath = new POIFSDocumentPath();
                }
                pOIFSReaderRegistry.registerListener(pOIFSReaderListener, pOIFSDocumentPath, str);
                return;
            }
            throw new IllegalStateException();
        }
        throw null;
    }
}
