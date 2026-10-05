package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.SGD;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FileRemover extends PrinterOperationBase<Void> {
    private static final long serialVersionUID = 4698239072491759650L;
    private List<String> fullPathsToFiles;

    public FileRemover(List<String> list, Connection connection, PrinterLanguage printerLanguage) {
        super(connection, printerLanguage);
        this.fullPathsToFiles = list;
    }

    private void deleteFiles() {
        for (String str : this.fullPathsToFiles) {
            if (isPrintingChannelInLineMode()) {
                SGD.SET("file.delete", str, this.connection);
            } else {
                new PrinterCommandImpl("{}{\"file.delete\" : \"" + str + "\"}").sendAndWaitForValidJsonResponse(this.connection);
            }
        }
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public Void execute() {
        selectStatusChannelIfOpen();
        deleteFiles();
        return null;
    }
}
