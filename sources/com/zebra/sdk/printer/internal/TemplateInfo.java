package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.internal.ConnectionBuilderInternal;
import com.zebra.sdk.printer.FieldDescriptionData;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.util.internal.FileReader;

/* JADX INFO: loaded from: classes3.dex */
public class TemplateInfo {
    public String contents;
    public boolean isLocalToComputer = false;
    public String pathOnPrinter;
    public FieldDescriptionData[] variableFields;

    private FieldDescriptionData[] extractVariableFieldsFromZpl() {
        return FormatUtilZpl.getVariableFieldsS(this.contents);
    }

    private void getTemplateFromPrinter(String str, String str2) {
        if (str != null) {
            Connection connectionBuild = null;
            try {
                try {
                    connectionBuild = ConnectionBuilderInternal.build(str);
                    connectionBuild.open();
                    this.contents = new String(ZebraPrinterFactory.getInstance(connectionBuild).retrieveFormatFromPrinter(str2));
                    this.isLocalToComputer = false;
                    try {
                        connectionBuild.close();
                    } catch (ConnectionException unused) {
                    }
                } catch (Throwable th) {
                    if (connectionBuild != null) {
                        try {
                            connectionBuild.close();
                        } catch (ConnectionException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getLocalizedMessage());
            }
        }
    }

    private void readTemplate(String str, String str2) {
        this.isLocalToComputer = true;
        String string = FileReader.toString(str2);
        this.contents = string;
        if (string.equals("")) {
            getTemplateFromPrinter(str, str2);
        }
        if (this.contents.equals("")) {
            throw new RuntimeException("Template file (" + str2 + ") does not exist or is empty.");
        }
    }

    public void acquire(String str, String str2) {
        readTemplate(str, str2);
        this.pathOnPrinter = FormatUtilZpl.extractDFName(this.contents);
        this.variableFields = extractVariableFieldsFromZpl();
    }
}
