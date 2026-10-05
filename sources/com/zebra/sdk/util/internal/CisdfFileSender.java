package com.zebra.sdk.util.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CisdfFileSender {
    private Connection connection;
    private List<PrinterFileDescriptor> fileDescriptors;

    public CisdfFileSender(Connection connection, List<PrinterFileDescriptor> list) {
        this.connection = connection;
        this.fileDescriptors = list;
    }

    private void send() throws ConnectionException {
        List<PrinterFileDescriptor> list = this.fileDescriptors;
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("No files to send");
        }
        Iterator<PrinterFileDescriptor> it = this.fileDescriptors.iterator();
        while (it.hasNext()) {
            sendToPrinter(it.next());
        }
    }

    private void sendToPrinter(PrinterFileDescriptor printerFileDescriptor) throws ConnectionException {
        this.connection.write(FileWrapper.createCisdfHeader(printerFileDescriptor).getBytes());
        FileUtilities.sendFileContentsInChunks(this.connection, printerFileDescriptor.getSourceStream());
        this.connection.write(FileWrapper.getCisdfTrailer());
    }

    public static void send(Connection connection, PrinterFileDescriptor printerFileDescriptor) throws ConnectionException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(printerFileDescriptor);
        send(connection, arrayList);
    }

    public static void send(Connection connection, List<PrinterFileDescriptor> list) throws ConnectionException {
        new CisdfFileSender(connection, list).send();
    }
}
