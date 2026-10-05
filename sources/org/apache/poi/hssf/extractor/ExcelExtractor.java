package org.apache.poi.hssf.extractor;

import com.zebra.sdk.util.internal.StringUtilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import org.apache.poi.POIOLE2TextExtractor;
import org.apache.poi.hssf.record.formula.eval.ErrorEval;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.HeaderFooter;
import org.apache.poi.ss.usermodel.Row;

/* JADX INFO: loaded from: classes4.dex */
public class ExcelExtractor extends POIOLE2TextExtractor implements org.apache.poi.ss.extractor.ExcelExtractor {
    private HSSFDataFormatter _formatter;
    private boolean _includeBlankCells;
    private boolean _includeCellComments;
    private boolean _includeHeadersFooters;
    private boolean _includeSheetNames;
    private boolean _shouldEvaluateFormulas;
    private HSSFWorkbook _wb;

    public static final class CommandArgs {
        private final boolean _evaluateFormulas;
        private final boolean _headersFooters;
        private final File _inputFile;
        private final boolean _requestHelp;
        private final boolean _showBlankCells;
        private final boolean _showCellComments;
        private final boolean _showSheetNames;

        public CommandArgs(String[] strArr) throws CommandParseException {
            int i;
            int length = strArr.length;
            File file = null;
            boolean z = false;
            int i2 = 0;
            boolean boolArg = true;
            boolean boolArg2 = true;
            boolean boolArg3 = false;
            boolean boolArg4 = false;
            boolean boolArg5 = true;
            while (i2 < length) {
                String str = strArr[i2];
                if ("-help".equalsIgnoreCase(str)) {
                    z = true;
                    break;
                }
                if ("-i".equals(str)) {
                    i = i2 + 1;
                    if (i >= length) {
                        throw new CommandParseException("Expected filename after '-i'");
                    }
                    String str2 = strArr[i];
                    if (file != null) {
                        throw new CommandParseException("Only one input file can be supplied");
                    }
                    file = new File(str2);
                    if (!file.exists()) {
                        throw new CommandParseException("Specified input file '" + str2 + "' does not exist");
                    }
                    if (file.isDirectory()) {
                        throw new CommandParseException("Specified input file '" + str2 + "' is a directory");
                    }
                } else if ("--show-sheet-names".equals(str)) {
                    i = i2 + 1;
                    boolArg = parseBoolArg(strArr, i);
                } else if ("--evaluate-formulas".equals(str)) {
                    i = i2 + 1;
                    boolArg2 = parseBoolArg(strArr, i);
                } else if ("--show-comments".equals(str)) {
                    i = i2 + 1;
                    boolArg3 = parseBoolArg(strArr, i);
                } else if ("--show-blanks".equals(str)) {
                    i = i2 + 1;
                    boolArg4 = parseBoolArg(strArr, i);
                } else {
                    if (!"--headers-footers".equals(str)) {
                        throw new CommandParseException("Invalid argument '" + str + "'");
                    }
                    i = i2 + 1;
                    boolArg5 = parseBoolArg(strArr, i);
                }
                i2 = i + 1;
            }
            this._requestHelp = z;
            this._inputFile = file;
            this._showSheetNames = boolArg;
            this._evaluateFormulas = boolArg2;
            this._showCellComments = boolArg3;
            this._showBlankCells = boolArg4;
            this._headersFooters = boolArg5;
        }

        private static boolean parseBoolArg(String[] strArr, int i) throws CommandParseException {
            if (i >= strArr.length) {
                throw new CommandParseException("Expected value after '" + strArr[i - 1] + "'");
            }
            String upperCase = strArr[i].toUpperCase();
            if ("Y".equals(upperCase) || "YES".equals(upperCase) || "ON".equals(upperCase) || "TRUE".equals(upperCase)) {
                return true;
            }
            if ("N".equals(upperCase) || "NO".equals(upperCase) || "OFF".equals(upperCase) || "FALSE".equals(upperCase)) {
                return false;
            }
            throw new CommandParseException("Invalid value '" + strArr[i] + "' for '" + strArr[i - 1] + "'. Expected 'Y' or 'N'");
        }

        public File getInputFile() {
            return this._inputFile;
        }

        public boolean isRequestHelp() {
            return this._requestHelp;
        }

        public boolean shouldEvaluateFormulas() {
            return this._evaluateFormulas;
        }

        public boolean shouldIncludeHeadersFooters() {
            return this._headersFooters;
        }

        public boolean shouldShowBlankCells() {
            return this._showBlankCells;
        }

        public boolean shouldShowCellComments() {
            return this._showCellComments;
        }

        public boolean shouldShowSheetNames() {
            return this._showSheetNames;
        }
    }

    public static final class CommandParseException extends Exception {
        public CommandParseException(String str) {
            super(str);
        }
    }

    public ExcelExtractor(HSSFWorkbook hSSFWorkbook) {
        super(hSSFWorkbook);
        this._includeSheetNames = true;
        this._shouldEvaluateFormulas = true;
        this._includeCellComments = false;
        this._includeBlankCells = false;
        this._includeHeadersFooters = true;
        this._wb = hSSFWorkbook;
        this._formatter = new HSSFDataFormatter();
    }

    public static String _extractHeaderFooter(HeaderFooter headerFooter) {
        StringBuffer stringBuffer = new StringBuffer();
        if (headerFooter.getLeft() != null) {
            stringBuffer.append(headerFooter.getLeft());
        }
        if (headerFooter.getCenter() != null) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append("\t");
            }
            stringBuffer.append(headerFooter.getCenter());
        }
        if (headerFooter.getRight() != null) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append("\t");
            }
            stringBuffer.append(headerFooter.getRight());
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.append(StringUtilities.LF);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] strArr) {
        try {
            CommandArgs commandArgs = new CommandArgs(strArr);
            if (commandArgs.isRequestHelp()) {
                printUsageMessage(System.out);
                return;
            }
            try {
                ExcelExtractor excelExtractor = new ExcelExtractor(new HSSFWorkbook(commandArgs.getInputFile() == null ? System.in : new FileInputStream(commandArgs.getInputFile())));
                excelExtractor.setIncludeSheetNames(commandArgs.shouldShowSheetNames());
                excelExtractor.setFormulasNotResults(!commandArgs.shouldEvaluateFormulas());
                excelExtractor.setIncludeCellComments(commandArgs.shouldShowCellComments());
                excelExtractor.setIncludeBlankCells(commandArgs.shouldShowBlankCells());
                excelExtractor.setIncludeHeadersFooters(commandArgs.shouldIncludeHeadersFooters());
                System.out.println(excelExtractor.getText());
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        } catch (CommandParseException e2) {
            PrintStream printStream = System.err;
            printStream.println(e2.getMessage());
            printUsageMessage(printStream);
            System.exit(1);
        }
    }

    private static void printUsageMessage(PrintStream printStream) {
        printStream.println("Use:");
        printStream.println("    " + ExcelExtractor.class.getName() + " [<flag> <value> [<flag> <value> [...]]] [-i <filename.xls>]");
        printStream.println("       -i <filename.xls> specifies input file (default is to use stdin)");
        printStream.println("       Flags can be set on or off by using the values 'Y' or 'N'.");
        printStream.println("       Following are available flags and their default values:");
        printStream.println("       --show-sheet-names  Y");
        printStream.println("       --evaluate-formulas Y");
        printStream.println("       --show-comments     N");
        printStream.println("       --show-blanks       Y");
        printStream.println("       --headers-footers   Y");
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        boolean z;
        String sheetName;
        StringBuffer stringBuffer = new StringBuffer();
        this._wb.setMissingCellPolicy(Row.RETURN_BLANK_AS_NULL);
        for (int i = 0; i < this._wb.getNumberOfSheets(); i++) {
            HSSFSheet sheetAt = this._wb.getSheetAt(i);
            if (sheetAt != null) {
                if (this._includeSheetNames && (sheetName = this._wb.getSheetName(i)) != null) {
                    stringBuffer.append(sheetName);
                    stringBuffer.append(StringUtilities.LF);
                }
                if (this._includeHeadersFooters) {
                    stringBuffer.append(_extractHeaderFooter(sheetAt.getHeader()));
                }
                int lastRowNum = sheetAt.getLastRowNum();
                for (int firstRowNum = sheetAt.getFirstRowNum(); firstRowNum <= lastRowNum; firstRowNum++) {
                    HSSFRow row = sheetAt.getRow(firstRowNum);
                    if (row != null) {
                        int firstCellNum = row.getFirstCellNum();
                        short lastCellNum = row.getLastCellNum();
                        if (this._includeBlankCells) {
                            firstCellNum = 0;
                        }
                        while (firstCellNum < lastCellNum) {
                            HSSFCell cell = row.getCell(firstCellNum);
                            if (cell == null) {
                                z = this._includeBlankCells;
                            } else {
                                int cellType = cell.getCellType();
                                if (cellType == 0) {
                                    stringBuffer.append(this._formatter.formatCellValue(cell));
                                } else if (cellType == 1) {
                                    stringBuffer.append(cell.getRichStringCellValue().getString());
                                } else if (cellType != 2) {
                                    if (cellType == 4) {
                                        stringBuffer.append(cell.getBooleanCellValue());
                                    } else {
                                        if (cellType != 5) {
                                            throw new RuntimeException("Unexpected cell type (" + cell.getCellType() + ")");
                                        }
                                        stringBuffer.append(ErrorEval.getText(cell.getErrorCellValue()));
                                    }
                                } else if (this._shouldEvaluateFormulas) {
                                    int cachedFormulaResultType = cell.getCachedFormulaResultType();
                                    if (cachedFormulaResultType == 0) {
                                        HSSFCellStyle cellStyle = cell.getCellStyle();
                                        if (cellStyle == null) {
                                            stringBuffer.append(cell.getNumericCellValue());
                                        } else {
                                            stringBuffer.append(this._formatter.formatRawCellContents(cell.getNumericCellValue(), cellStyle.getDataFormat(), cellStyle.getDataFormatString()));
                                        }
                                    } else if (cachedFormulaResultType == 1) {
                                        HSSFRichTextString richStringCellValue = cell.getRichStringCellValue();
                                        if (richStringCellValue != null && richStringCellValue.length() > 0) {
                                            stringBuffer.append(richStringCellValue.toString());
                                        }
                                    } else if (cachedFormulaResultType == 4) {
                                        stringBuffer.append(cell.getBooleanCellValue());
                                    } else if (cachedFormulaResultType == 5) {
                                        stringBuffer.append(ErrorEval.getText(cell.getErrorCellValue()));
                                    }
                                } else {
                                    stringBuffer.append(cell.getCellFormula());
                                }
                                HSSFComment cellComment = cell.getCellComment();
                                if (this._includeCellComments && cellComment != null) {
                                    stringBuffer.append(" Comment by " + cellComment.getAuthor() + ": " + cellComment.getString().getString().replace('\n', ' '));
                                }
                                z = true;
                            }
                            if (z && firstCellNum < lastCellNum - 1) {
                                stringBuffer.append("\t");
                            }
                            firstCellNum++;
                        }
                        stringBuffer.append(StringUtilities.LF);
                    }
                }
                if (this._includeHeadersFooters) {
                    stringBuffer.append(_extractHeaderFooter(sheetAt.getFooter()));
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setFormulasNotResults(boolean z) {
        this._shouldEvaluateFormulas = !z;
    }

    public void setIncludeBlankCells(boolean z) {
        this._includeBlankCells = z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeCellComments(boolean z) {
        this._includeCellComments = z;
    }

    public void setIncludeHeadersFooters(boolean z) {
        this._includeHeadersFooters = z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeSheetNames(boolean z) {
        this._includeSheetNames = z;
    }

    public ExcelExtractor(POIFSFileSystem pOIFSFileSystem) {
        this(pOIFSFileSystem.getRoot(), pOIFSFileSystem);
    }

    public ExcelExtractor(DirectoryNode directoryNode, POIFSFileSystem pOIFSFileSystem) {
        this(new HSSFWorkbook(directoryNode, pOIFSFileSystem, true));
    }
}
