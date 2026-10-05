package com.itextpdf.testutils;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ITextTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ITextTest.class.getName());

    public void assertPdf(String str) {
    }

    public void comparePdf(String str, String str2) {
    }

    public void deleteDirectory(File file) {
        if (file != null && file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    deleteDirectory(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
            file.delete();
        }
    }

    public void deleteFiles(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        for (File file2 : file.listFiles()) {
            file2.delete();
        }
    }

    public String getCmpPdf() {
        return "";
    }

    public abstract String getOutPdf();

    public abstract void makePdf(String str);

    public void runTest() throws IOException {
        Logger logger = LOGGER;
        logger.info("Starting test.");
        String outPdf = getOutPdf();
        if (outPdf == null || outPdf.length() == 0) {
            throw new IOException("outPdf cannot be empty!");
        }
        makePdf(outPdf);
        assertPdf(outPdf);
        comparePdf(outPdf, getCmpPdf());
        logger.info("Test complete.");
    }
}
