package org.apache.poi.hssf.dev;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.List;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;
import org.apache.poi.hssf.record.formula.ExpPtg;
import org.apache.poi.hssf.record.formula.FuncPtg;
import org.apache.poi.hssf.record.formula.OperationPtg;
import org.apache.poi.hssf.record.formula.Ptg;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: classes4.dex */
public class FormulaViewer {
    private String file;
    private boolean list = false;

    private static String composeFormula(FormulaRecord formulaRecord) {
        return HSSFFormulaParser.toFormulaString(null, formulaRecord.getParsedExpression());
    }

    private String formulaString(FormulaRecord formulaRecord) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Ptg ptg : formulaRecord.getParsedExpression()) {
            stringBuffer.append(ptg.toFormulaString());
            byte ptgClass = ptg.getPtgClass();
            if (ptgClass == 0) {
                stringBuffer.append("(R)");
            } else if (ptgClass == 32) {
                stringBuffer.append("(V)");
            } else if (ptgClass == 64) {
                stringBuffer.append("(A)");
            }
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    private void listFormula(FormulaRecord formulaRecord) {
        Ptg[] parsedExpression = formulaRecord.getParsedExpression();
        int length = parsedExpression.length;
        int i = length - 1;
        Ptg ptg = parsedExpression[i];
        String strValueOf = ptg instanceof FuncPtg ? String.valueOf(i) : String.valueOf(-1);
        StringBuffer stringBuffer = new StringBuffer();
        if (ptg instanceof ExpPtg) {
            return;
        }
        stringBuffer.append(((OperationPtg) ptg).toFormulaString());
        stringBuffer.append("~");
        byte ptgClass = ptg.getPtgClass();
        if (ptgClass == 0) {
            stringBuffer.append("REF");
        } else if (ptgClass == 32) {
            stringBuffer.append("VALUE");
        } else if (ptgClass == 64) {
            stringBuffer.append("ARRAY");
        }
        stringBuffer.append("~");
        if (length > 1) {
            byte ptgClass2 = parsedExpression[length - 2].getPtgClass();
            if (ptgClass2 == 0) {
                stringBuffer.append("REF");
            } else if (ptgClass2 == 32) {
                stringBuffer.append("VALUE");
            } else if (ptgClass2 == 64) {
                stringBuffer.append("ARRAY");
            }
        } else {
            stringBuffer.append("VALUE");
        }
        stringBuffer.append("~");
        stringBuffer.append(strValueOf);
        System.out.println(stringBuffer.toString());
    }

    public static void main(String[] strArr) {
        if (strArr == null || strArr.length > 2 || strArr[0].equals("--help")) {
            PrintStream printStream = System.out;
            printStream.println("FormulaViewer .8 proof that the devil lies in the details (or just in BIFF8 files in general)");
            printStream.println("usage: Give me a big fat file name");
            return;
        }
        if (!strArr[0].equals("--listFunctions")) {
            try {
                FormulaViewer formulaViewer = new FormulaViewer();
                formulaViewer.setFile(strArr[0]);
                formulaViewer.run();
                return;
            } catch (Exception e) {
                System.out.println("Whoops!");
                e.printStackTrace();
                return;
            }
        }
        try {
            FormulaViewer formulaViewer2 = new FormulaViewer();
            formulaViewer2.setFile(strArr[1]);
            formulaViewer2.setList(true);
            formulaViewer2.run();
        } catch (Exception e2) {
            System.out.println("Whoops!");
            e2.printStackTrace();
        }
    }

    public void parseFormulaRecord(FormulaRecord formulaRecord) {
        PrintStream printStream = System.out;
        printStream.println("==============================");
        printStream.print("row = " + formulaRecord.getRow());
        printStream.println(", col = " + ((int) formulaRecord.getColumn()));
        printStream.println("value = " + formulaRecord.getValue());
        printStream.print("xf = " + ((int) formulaRecord.getXFIndex()));
        printStream.print(", number of ptgs = " + formulaRecord.getParsedExpression().length);
        printStream.println(", options = " + ((int) formulaRecord.getOptions()));
        printStream.println("RPN List = " + formulaString(formulaRecord));
        printStream.println("Formula text = " + composeFormula(formulaRecord));
    }

    public void run() {
        List<Record> listCreateRecords = RecordFactory.createRecords(new POIFSFileSystem(new FileInputStream(this.file)).createDocumentInputStream("Workbook"));
        for (int i = 0; i < listCreateRecords.size(); i++) {
            Record record = listCreateRecords.get(i);
            if (record.getSid() == 6) {
                if (this.list) {
                    listFormula((FormulaRecord) record);
                } else {
                    parseFormulaRecord((FormulaRecord) record);
                }
            }
        }
    }

    public void setFile(String str) {
        this.file = str;
    }

    public void setList(boolean z) {
        this.list = z;
    }
}
