package com.itextpdf.text.pdf.codec;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.InvalidImageException;
import com.itextpdf.text.pdf.ByteBuffer;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.hssf.record.CodepageRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.InterfaceEndRecord;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.hssf.record.formula.Area3DPtg;
import org.apache.poi.hssf.record.formula.AreaErrPtg;
import org.apache.poi.hssf.record.formula.MemFuncPtg;
import org.apache.poi.hssf.record.formula.Ref3DPtg;
import org.apache.poi.hssf.record.formula.RefErrorPtg;
import org.apache.poi.hssf.record.formula.RefNPtg;
import org.apache.poi.hssf.record.formula.RefPtg;
import org.apache.poi.ss.usermodel.ShapeTypes;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: loaded from: classes3.dex */
public class TIFFFaxDecoder {
    private int[] currChangingElems;
    private byte[] data;
    private long fillOrder;
    private int h;
    private int oneD;
    private int[] prevChangingElems;
    private boolean recoverFromImageError;
    private int w;
    static int[] table1 = {0, 1, 3, 7, 15, 31, 63, ShapeTypes.VERTICAL_SCROLL, 255};
    static int[] table2 = {0, 128, 192, 224, 240, 248, 252, TIFFConstants.TIFFTAG_SUBFILETYPE, 255};
    static byte[] flipTable = {0, UnsignedBytes.MAX_POWER_OF_TWO, 64, -64, 32, -96, 96, -32, 16, -112, 80, -48, ByteBuffer.ZERO, -80, 112, -16, 8, -120, 72, -56, 40, -88, 104, -24, Ascii.CAN, -104, 88, -40, PaletteRecord.STANDARD_PALETTE_SIZE, -72, 120, -8, 4, -124, 68, -60, RefPtg.sid, -92, 100, -28, 20, -108, 84, -44, 52, -76, 116, -12, 12, -116, 76, -52, RefNPtg.sid, -84, 108, -20, Ascii.FS, -100, 92, -36, 60, -68, 124, -4, 2, -126, 66, -62, 34, -94, 98, -30, 18, -110, 82, -46, 50, -78, 114, -14, 10, -118, 74, -54, RefErrorPtg.sid, -86, 106, -22, Ascii.SUB, -102, 90, -38, Ref3DPtg.sid, -70, 122, -6, 6, -122, 70, -58, 38, -90, 102, -26, 22, -106, 86, -42, 54, -74, 118, -10, 14, -114, 78, -50, 46, -82, 110, -18, 30, -98, 94, -34, DocWriter.GT, -66, 126, -2, 1, -127, 65, -63, 33, -95, 97, -31, 17, -111, 81, -47, 49, -79, 113, -15, 9, -119, 73, -55, MemFuncPtg.sid, -87, 105, -23, 25, -103, 89, -39, 57, -71, 121, -7, 5, -123, 69, -59, 37, -91, 101, -27, 21, -107, 85, -43, 53, -75, 117, -11, 13, -115, 77, -51, 45, -83, 109, -19, 29, -99, 93, -35, 61, -67, 125, -3, 3, -125, 67, -61, 35, -93, 99, -29, 19, -109, 83, -45, 51, -77, 115, -13, 11, -117, 75, -53, AreaErrPtg.sid, -85, 107, -21, Ascii.ESC, -101, 91, -37, Area3DPtg.sid, -69, 123, -5, 7, -121, 71, -57, 39, -89, 103, -25, 23, -105, 87, -41, 55, -73, 119, -9, 15, -113, 79, -49, DocWriter.FORWARD, -81, 111, -17, 31, -97, 95, -33, 63, -65, Ascii.DEL, -1};
    static short[] white = {6430, 6400, 6400, 6400, 3225, 3225, 3225, 3225, 944, 944, 944, 944, 976, 976, 976, 976, 1456, 1456, 1456, 1456, 1488, 1488, 1488, 1488, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, 750, 750, 750, 750, 750, 750, 750, 750, 1520, 1520, 1520, 1520, 1552, 1552, 1552, 1552, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 654, 654, 654, 654, 654, 654, 654, 654, 1072, 1072, 1072, 1072, 1104, 1104, 1104, 1104, 1136, 1136, 1136, 1136, 1168, 1168, 1168, 1168, CodepageRecord.CODEPAGE, CodepageRecord.CODEPAGE, CodepageRecord.CODEPAGE, CodepageRecord.CODEPAGE, 1232, 1232, 1232, 1232, 622, 622, 622, 622, 622, 622, 622, 622, 1008, 1008, 1008, 1008, 1040, 1040, 1040, 1040, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, 1712, 1712, 1712, 1712, 1744, 1744, 1744, 1744, 846, 846, 846, 846, 846, 846, 846, 846, 1264, 1264, 1264, 1264, 1296, 1296, 1296, 1296, 1328, 1328, 1328, 1328, 1360, 1360, 1360, 1360, 1392, 1392, 1392, 1392, 1424, 1424, 1424, 1424, 686, 686, 686, 686, 686, 686, 686, 686, 910, 910, 910, 910, 910, 910, 910, 910, 1968, 1968, 1968, 1968, 2000, 2000, 2000, 2000, 2032, 2032, 2032, 2032, 16, 16, 16, 16, 10257, 10257, 10257, 10257, 12305, 12305, 12305, 12305, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 878, 878, 878, 878, 878, 878, 878, 878, 1904, 1904, 1904, 1904, 1936, 1936, 1936, 1936, -18413, -18413, -16365, -16365, -14317, -14317, -10221, -10221, 590, 590, 590, 590, 590, 590, 590, 590, 782, 782, 782, 782, 782, 782, 782, 782, 1584, 1584, 1584, 1584, 1616, 1616, 1616, 1616, 1648, 1648, 1648, 1648, 1680, 1680, 1680, 1680, 814, 814, 814, 814, 814, 814, 814, 814, 1776, 1776, 1776, 1776, 1808, 1808, 1808, 1808, 1840, 1840, 1840, 1840, 1872, 1872, 1872, 1872, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, 14353, 14353, 14353, 14353, 16401, 16401, 16401, 16401, 22547, 22547, 24595, 24595, 20497, 20497, 20497, 20497, 18449, 18449, 18449, 18449, 26643, 26643, 28691, 28691, 30739, 30739, -32749, -32749, -30701, -30701, -28653, -28653, -26605, -26605, -24557, -24557, -22509, -22509, -20461, -20461, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 
    232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232};
    static short[] additionalMakeup = {28679, 28679, 31752, -32759, -31735, -30711, -29687, -28663, 29703, 29703, 30727, 30727, -27639, -26615, -25591, -24567};
    static short[] initBlack = {3226, 6412, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_TEXTFADERIGHT, 38, 38, 134, 134, 100, 100, 100, 100, 68, 68, 68, 68};
    static short[] twoBitBlack = {292, EscherProperties.BLIP__BLIPTODISPLAY, InterfaceEndRecord.sid, InterfaceEndRecord.sid};
    static short[] black = {62, 62, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 588, 588, 588, 588, 588, 588, 588, 588, 1680, 1680, 20499, 22547, 24595, 26643, 1776, 1776, 1808, 1808, -24557, -22509, -20461, -18413, 1904, 1904, 1936, 1936, -16365, -14317, 782, 782, 782, 782, 814, 814, 814, 814, -12269, -10221, 10257, 10257, 12305, 12305, 14353, 14353, 16403, 18451, 1712, 1712, 1744, 1744, 28691, 30739, -32749, -30701, -28653, -26605, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 750, 750, 750, 750, 1616, 1616, 1648, 1648, 1424, 1424, 1456, 1456, 1488, 1488, 1520, 1520, 1840, 1840, 1872, 1872, 1968, 1968, 8209, 8209, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, 556, 556, 556, 556, 556, 556, 556, 556, 1552, 1552, 1584, 1584, 2000, 2000, 2032, 2032, 976, 976, 1008, 1008, 1040, 1040, 1072, 1072, 1296, 1296, 1328, 1328, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 4113, 4113, 6161, 6161, 848, 848, 880, 880, 912, 912, 944, 944, 622, 622, 622, 622, 654, 654, 654, 654, 1104, 1104, 1136, 1136, 1168, 1168, CodepageRecord.CODEPAGE, CodepageRecord.CODEPAGE, 1232, 1232, 1264, 1264, 686, 686, 686, 686, 1360, 1360, 1392, 1392, 12, 12, 12, 12, 12, 12, 12, 12, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE};
    static byte[] twoDCodes = {80, 88, 23, 71, 30, 30, DocWriter.GT, DocWriter.GT, 4, 4, 4, 4, 4, 4, 4, 4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid};
    private int changingElemSize = 0;
    private int lastChangingElement = 0;
    private int compression = 2;
    private int uncompressedMode = 0;
    private int fillBits = 0;
    private int bitPointer = 0;
    private int bytePointer = 0;

    public TIFFFaxDecoder(long j, int i, int i2) {
        this.fillOrder = j;
        this.w = i;
        this.h = i2;
        int i3 = i * 2;
        this.prevChangingElems = new int[i3];
        this.currChangingElems = new int[i3];
    }

    private boolean advancePointer() {
        if (this.bitPointer != 0) {
            this.bytePointer++;
            this.bitPointer = 0;
        }
        return true;
    }

    private int decodeBlackCodeWord() {
        boolean z = false;
        int i = 0;
        while (!z) {
            short s = initBlack[nextLesserThan8Bits(4)];
            int i2 = (s >>> 1) & 15;
            int i3 = (s >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
            if (i3 == 100) {
                short s2 = black[nextNBits(9)];
                int i4 = s2 & 1;
                int i5 = (s2 >>> 1) & 15;
                int i6 = (s2 >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                if (i5 == 12) {
                    updatePointer(5);
                    short s3 = additionalMakeup[nextLesserThan8Bits(4)];
                    i += (s3 >>> 4) & 4095;
                    updatePointer(4 - ((s3 >>> 1) & 7));
                } else {
                    if (i5 == 15) {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("eol.code.word.encountered.in.black.run", new Object[0]));
                    }
                    i += i6;
                    updatePointer(9 - i5);
                    if (i4 == 0) {
                    }
                }
            } else if (i3 == 200) {
                short s4 = twoBitBlack[nextLesserThan8Bits(2)];
                i += (s4 >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                updatePointer(2 - ((s4 >>> 1) & 15));
            } else {
                i += i3;
                updatePointer(4 - i2);
            }
            z = true;
        }
        return i;
    }

    private int decodeWhiteCodeWord() {
        boolean z = true;
        int i = 0;
        while (z) {
            int iNextNBits = nextNBits(10);
            short s = white[iNextNBits];
            int i2 = s & 1;
            int i3 = (s >>> 1) & 15;
            if (i3 == 12) {
                short s2 = additionalMakeup[((iNextNBits << 2) & 12) | nextLesserThan8Bits(2)];
                i += (s2 >>> 4) & 4095;
                updatePointer(4 - ((s2 >>> 1) & 7));
            } else {
                if (i3 == 0) {
                    throw new InvalidImageException(MessageLocalization.getComposedMessage("invalid.code.encountered", new Object[0]));
                }
                if (i3 != 15) {
                    i += (s >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                    updatePointer(10 - i3);
                    if (i2 == 0) {
                    }
                } else if (i != 0) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("eol.code.word.encountered.in.white.run", new Object[0]));
                }
                z = false;
            }
        }
        return i;
    }

    private void getNextChangingElement(int i, boolean z, int[] iArr) {
        int[] iArr2 = this.prevChangingElems;
        int i2 = this.changingElemSize;
        int i3 = this.lastChangingElement;
        int i4 = i3 > 0 ? i3 - 1 : 0;
        int i5 = z ? i4 & (-2) : i4 | 1;
        while (i5 < i2) {
            int i6 = iArr2[i5];
            if (i6 > i) {
                this.lastChangingElement = i5;
                iArr[0] = i6;
                break;
            }
            i5 += 2;
        }
        int i7 = i5 + 1;
        if (i7 < i2) {
            iArr[1] = iArr2[i7];
        }
    }

    private int nextLesserThan8Bits(int i) {
        byte b;
        byte b2;
        byte[] bArr = this.data;
        int length = bArr.length - 1;
        int i2 = this.bytePointer;
        long j = this.fillOrder;
        if (j == 1) {
            b2 = bArr[i2];
            b = i2 == length ? (byte) 0 : bArr[i2 + 1];
        } else {
            if (j != 2) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("tiff.fill.order.tag.must.be.either.1.or.2", new Object[0]));
            }
            if (!this.recoverFromImageError || i2 < bArr.length) {
                byte[] bArr2 = flipTable;
                byte b3 = bArr2[bArr[i2] & UnsignedBytes.MAX_VALUE];
                if (i2 == length) {
                    b2 = b3;
                } else {
                    b = bArr2[bArr[i2 + 1] & UnsignedBytes.MAX_VALUE];
                    b2 = b3;
                }
            } else {
                b = 0;
                b2 = 0;
            }
        }
        int i3 = this.bitPointer;
        int i4 = 8 - i3;
        int i5 = i - i4;
        int i6 = i4 - i;
        if (i6 < 0) {
            int i7 = ((b & table2[i5]) >>> (8 - i5)) | ((table1[i4] & b2) << (-i6));
            this.bytePointer = i2 + 1;
            this.bitPointer = i5;
            return i7;
        }
        int i8 = (table1[i4] & b2) >>> i6;
        int i9 = i3 + i;
        this.bitPointer = i9;
        if (i9 != 8) {
            return i8;
        }
        this.bitPointer = 0;
        this.bytePointer = i2 + 1;
        return i8;
    }

    private int nextNBits(int i) {
        byte b;
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        int i2;
        int i3;
        byte[] bArr = this.data;
        int length = bArr.length - 1;
        int i4 = this.bytePointer;
        long j = this.fillOrder;
        if (j == 1) {
            b3 = bArr[i4];
            if (i4 == length) {
                b4 = 0;
            } else {
                int i5 = i4 + 1;
                if (i5 == length) {
                    b4 = bArr[i5];
                } else {
                    b = bArr[i5];
                    b2 = bArr[i4 + 2];
                    byte b6 = b;
                    b5 = b2;
                    b4 = b6;
                }
            }
            b5 = 0;
        } else {
            if (j != 2) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("tiff.fill.order.tag.must.be.either.1.or.2", new Object[0]));
            }
            byte[] bArr2 = flipTable;
            byte b7 = bArr2[bArr[i4] & UnsignedBytes.MAX_VALUE];
            if (i4 == length) {
                b3 = b7;
                b4 = 0;
            } else {
                int i6 = i4 + 1;
                if (i6 == length) {
                    b4 = bArr2[bArr[i6] & UnsignedBytes.MAX_VALUE];
                    b3 = b7;
                } else {
                    b = bArr2[bArr[i6] & UnsignedBytes.MAX_VALUE];
                    b2 = bArr2[bArr[i4 + 2] & UnsignedBytes.MAX_VALUE];
                    b3 = b7;
                    byte b8 = b;
                    b5 = b2;
                    b4 = b8;
                }
            }
            b5 = 0;
        }
        int i7 = 8 - this.bitPointer;
        int i8 = i - i7;
        if (i8 > 8) {
            i3 = i8 - 8;
            i2 = 8;
        } else {
            i2 = i8;
            i3 = 0;
        }
        this.bytePointer = i4 + 1;
        int i9 = (b3 & table1[i7]) << i8;
        int[] iArr = table2;
        int i10 = (b4 & iArr[i2]) >>> (8 - i2);
        if (i3 != 0) {
            i10 = (i10 << i3) | ((b5 & iArr[i3]) >>> (8 - i3));
            this.bytePointer = i4 + 2;
            this.bitPointer = i3;
        } else if (i2 == 8) {
            this.bitPointer = 0;
            this.bytePointer = i4 + 2;
        } else {
            this.bitPointer = i2;
        }
        return i9 | i10;
    }

    private int readEOL(boolean z) {
        int i = this.fillBits;
        if (i == 0) {
            int iNextNBits = nextNBits(12);
            if (z && iNextNBits == 0 && nextNBits(4) == 1) {
                this.fillBits = 1;
                return 1;
            }
            if (iNextNBits != 1) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("scanline.must.begin.with.eol.code.word", new Object[0]));
            }
        } else if (i == 1) {
            int i2 = 8 - this.bitPointer;
            if (nextNBits(i2) != 0) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
            }
            if (i2 < 4 && nextNBits(8) != 0) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
            }
            while (true) {
                int iNextNBits2 = nextNBits(8);
                if (iNextNBits2 == 1) {
                    break;
                }
                if (iNextNBits2 != 0) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
                }
            }
        }
        if (this.oneD == 0) {
            return 1;
        }
        return nextLesserThan8Bits(1);
    }

    public static void reverseBits(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = flipTable[bArr[i] & UnsignedBytes.MAX_VALUE];
        }
    }

    private void setToBlack(byte[] bArr, int i, int i2, int i3) {
        int i4 = (i * 8) + i2;
        int i5 = i3 + i4;
        int i6 = i4 >> 3;
        int i7 = i4 & 7;
        if (i7 > 0) {
            int i8 = 1 << (7 - i7);
            byte b = bArr[i6];
            while (i8 > 0 && i4 < i5) {
                b = (byte) (b | i8);
                i8 >>= 1;
                i4++;
            }
            bArr[i6] = b;
        }
        int i9 = i4 >> 3;
        while (i4 < i5 - 7) {
            bArr[i9] = -1;
            i4 += 8;
            i9++;
        }
        while (i4 < i5) {
            int i10 = i4 >> 3;
            if (!this.recoverFromImageError || i10 < bArr.length) {
                bArr[i10] = (byte) (bArr[i10] | (1 << (7 - (i4 & 7))));
            }
            i4++;
        }
    }

    private void updatePointer(int i) {
        int i2 = this.bitPointer - i;
        if (i2 >= 0) {
            this.bitPointer = i2;
        } else {
            this.bytePointer--;
            this.bitPointer = i2 + 8;
        }
    }

    public void decode1D(byte[] bArr, byte[] bArr2, int i, int i2) {
        this.data = bArr2;
        int i3 = (this.w + 7) / 8;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            decodeNextScanline(bArr, i4, i);
            i4 += i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v3 */
    public void decode2D(byte[] bArr, byte[] bArr2, int i, int i2, long j) {
        this.data = bArr2;
        this.compression = 3;
        boolean z = false;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i3 = (this.w + 7) / 8;
        int[] iArr = new int[2];
        this.oneD = (int) (j & 1);
        this.uncompressedMode = (int) ((j & 2) >> 1);
        this.fillBits = (int) ((j & 4) >> 2);
        if (readEOL(true) != 1) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("first.scanline.must.be.1d.encoded", new Object[0]));
        }
        decodeNextScanline(bArr, 0, i);
        int i4 = i3;
        int i5 = 1;
        while (i5 < i2) {
            if (readEOL(z) == 0) {
                int[] iArr2 = this.prevChangingElems;
                this.prevChangingElems = this.currChangingElems;
                this.currChangingElems = iArr2;
                this.lastChangingElement = z ? 1 : 0;
                int i6 = -1;
                int iDecodeWhiteCodeWord = i;
                boolean z2 = true;
                int i7 = 0;
                ?? r4 = z;
                while (iDecodeWhiteCodeWord < this.w) {
                    getNextChangingElement(i6, z2, iArr);
                    int i8 = iArr[r4];
                    i6 = iArr[1];
                    byte b = twoDCodes[nextLesserThan8Bits(7)];
                    int i9 = (b & 120) >>> 3;
                    int i10 = b & 7;
                    if (i9 == 0) {
                        if (!z2) {
                            setToBlack(bArr, i4, iDecodeWhiteCodeWord, i6 - iDecodeWhiteCodeWord);
                        }
                        updatePointer(7 - i10);
                        iDecodeWhiteCodeWord = i6;
                    } else if (i9 == 1) {
                        updatePointer(7 - i10);
                        if (z2) {
                            int iDecodeWhiteCodeWord2 = iDecodeWhiteCodeWord + decodeWhiteCodeWord();
                            int i11 = i7 + 1;
                            this.currChangingElems[i7] = iDecodeWhiteCodeWord2;
                            int iDecodeBlackCodeWord = decodeBlackCodeWord();
                            setToBlack(bArr, i4, iDecodeWhiteCodeWord2, iDecodeBlackCodeWord);
                            iDecodeWhiteCodeWord = iDecodeWhiteCodeWord2 + iDecodeBlackCodeWord;
                            i7 += 2;
                            this.currChangingElems[i11] = iDecodeWhiteCodeWord;
                        } else {
                            int iDecodeBlackCodeWord2 = decodeBlackCodeWord();
                            setToBlack(bArr, i4, iDecodeWhiteCodeWord, iDecodeBlackCodeWord2);
                            int i12 = iDecodeWhiteCodeWord + iDecodeBlackCodeWord2;
                            int i13 = i7 + 1;
                            this.currChangingElems[i7] = i12;
                            iDecodeWhiteCodeWord = i12 + decodeWhiteCodeWord();
                            i7 += 2;
                            this.currChangingElems[i13] = iDecodeWhiteCodeWord;
                        }
                        i6 = iDecodeWhiteCodeWord;
                    } else {
                        if (i9 > 8) {
                            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.code.encountered.while.decoding.2d.group.3.compressed.data", new Object[0]));
                        }
                        int i14 = i8 + (i9 - 5);
                        int i15 = i7 + 1;
                        this.currChangingElems[i7] = i14;
                        if (!z2) {
                            setToBlack(bArr, i4, iDecodeWhiteCodeWord, i14 - iDecodeWhiteCodeWord);
                        }
                        z2 = !z2;
                        updatePointer(7 - i10);
                        i6 = i14;
                        iDecodeWhiteCodeWord = i6;
                        i7 = i15;
                    }
                    r4 = 0;
                }
                this.currChangingElems[i7] = iDecodeWhiteCodeWord;
                this.changingElemSize = i7 + 1;
            } else {
                decodeNextScanline(bArr, i4, i);
            }
            i4 += i3;
            i5++;
            z = false;
        }
    }

    public void decodeNextScanline(byte[] bArr, int i, int i2) {
        this.changingElemSize = 0;
        boolean z = true;
        while (i2 < this.w) {
            while (z) {
                int iNextNBits = nextNBits(10);
                short s = white[iNextNBits];
                int i3 = s & 1;
                int i4 = (s >>> 1) & 15;
                if (i4 == 12) {
                    short s2 = additionalMakeup[(12 & (iNextNBits << 2)) | nextLesserThan8Bits(2)];
                    i2 += (s2 >>> 4) & 4095;
                    updatePointer(4 - ((s2 >>> 1) & 7));
                } else {
                    if (i4 == 0) {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.code.encountered", new Object[0]));
                    }
                    if (i4 == 15) {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("eol.code.word.encountered.in.white.run", new Object[0]));
                    }
                    i2 += (s >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                    updatePointer(10 - i4);
                    if (i3 == 0) {
                        int[] iArr = this.currChangingElems;
                        int i5 = this.changingElemSize;
                        this.changingElemSize = i5 + 1;
                        iArr[i5] = i2;
                        z = false;
                    }
                }
            }
            if (i2 == this.w) {
                if (this.compression != 2) {
                    break;
                }
                advancePointer();
                break;
            }
            while (!z) {
                short s3 = initBlack[nextLesserThan8Bits(4)];
                int i6 = (s3 >>> 1) & 15;
                int i7 = (s3 >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                if (i7 == 100) {
                    short s4 = black[nextNBits(9)];
                    int i8 = s4 & 1;
                    int i9 = (s4 >>> 1) & 15;
                    int i10 = (s4 >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                    if (i9 == 12) {
                        updatePointer(5);
                        short s5 = additionalMakeup[nextLesserThan8Bits(4)];
                        int i11 = (s5 >>> 1) & 7;
                        int i12 = (s5 >>> 4) & 4095;
                        setToBlack(bArr, i, i2, i12);
                        i2 += i12;
                        updatePointer(4 - i11);
                    } else {
                        if (i9 == 15) {
                            throw new RuntimeException(MessageLocalization.getComposedMessage("eol.code.word.encountered.in.black.run", new Object[0]));
                        }
                        setToBlack(bArr, i, i2, i10);
                        i2 += i10;
                        updatePointer(9 - i9);
                        if (i8 == 0) {
                            int[] iArr2 = this.currChangingElems;
                            int i13 = this.changingElemSize;
                            this.changingElemSize = i13 + 1;
                            iArr2[i13] = i2;
                        }
                    }
                } else if (i7 == 200) {
                    short s6 = twoBitBlack[nextLesserThan8Bits(2)];
                    int i14 = (s6 >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                    setToBlack(bArr, i, i2, i14);
                    i2 += i14;
                    updatePointer(2 - ((s6 >>> 1) & 15));
                    int[] iArr3 = this.currChangingElems;
                    int i15 = this.changingElemSize;
                    this.changingElemSize = i15 + 1;
                    iArr3[i15] = i2;
                } else {
                    setToBlack(bArr, i, i2, i7);
                    i2 += i7;
                    updatePointer(4 - i6);
                    int[] iArr4 = this.currChangingElems;
                    int i16 = this.changingElemSize;
                    this.changingElemSize = i16 + 1;
                    iArr4[i16] = i2;
                }
                z = true;
            }
            if (i2 == this.w) {
                if (this.compression != 2) {
                    break;
                }
                advancePointer();
                break;
            }
        }
        int[] iArr5 = this.currChangingElems;
        int i17 = this.changingElemSize;
        this.changingElemSize = i17 + 1;
        iArr5[i17] = i2;
    }

    public void decodeT6(byte[] bArr, byte[] bArr2, int i, int i2, long j) {
        boolean z;
        this.data = bArr2;
        this.compression = 4;
        int i3 = 0;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i4 = this.w;
        int i5 = (i4 + 7) / 8;
        int[] iArr = new int[2];
        char c = 1;
        this.uncompressedMode = (int) ((j & 2) >> 1);
        int[] iArr2 = this.currChangingElems;
        this.changingElemSize = 1;
        iArr2[0] = i4;
        this.changingElemSize = 1 + 1;
        iArr2[1] = i4;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i2) {
            int[] iArr3 = this.prevChangingElems;
            this.prevChangingElems = this.currChangingElems;
            this.currChangingElems = iArr3;
            this.lastChangingElement = i3;
            int i8 = -1;
            int iDecodeWhiteCodeWord = i;
            int i9 = 0;
            boolean z2 = true;
            while (iDecodeWhiteCodeWord < this.w && this.bytePointer < this.data.length) {
                getNextChangingElement(i8, z2, iArr);
                int i10 = iArr[i3];
                int i11 = iArr[c];
                byte b = twoDCodes[nextLesserThan8Bits(7)];
                int i12 = (b & 120) >>> 3;
                int i13 = b & 7;
                if (i12 == 0) {
                    if (!z2) {
                        setToBlack(bArr, i7, iDecodeWhiteCodeWord, i11 - iDecodeWhiteCodeWord);
                    }
                    updatePointer(7 - i13);
                    i8 = i11;
                } else {
                    if (i12 == 1) {
                        updatePointer(7 - i13);
                        if (z2) {
                            int iDecodeWhiteCodeWord2 = iDecodeWhiteCodeWord + decodeWhiteCodeWord();
                            int i14 = i9 + 1;
                            iArr3[i9] = iDecodeWhiteCodeWord2;
                            int iDecodeBlackCodeWord = decodeBlackCodeWord();
                            setToBlack(bArr, i7, iDecodeWhiteCodeWord2, iDecodeBlackCodeWord);
                            iDecodeWhiteCodeWord = iDecodeWhiteCodeWord2 + iDecodeBlackCodeWord;
                            i9 += 2;
                            iArr3[i14] = iDecodeWhiteCodeWord;
                        } else {
                            int iDecodeBlackCodeWord2 = decodeBlackCodeWord();
                            setToBlack(bArr, i7, iDecodeWhiteCodeWord, iDecodeBlackCodeWord2);
                            int i15 = iDecodeWhiteCodeWord + iDecodeBlackCodeWord2;
                            int i16 = i9 + 1;
                            iArr3[i9] = i15;
                            iDecodeWhiteCodeWord = i15 + decodeWhiteCodeWord();
                            i9 += 2;
                            iArr3[i16] = iDecodeWhiteCodeWord;
                        }
                        i8 = iDecodeWhiteCodeWord;
                    } else if (i12 <= 8) {
                        i8 = i10 + (i12 - 5);
                        int i17 = i9 + 1;
                        iArr3[i9] = i8;
                        if (!z2) {
                            setToBlack(bArr, i7, iDecodeWhiteCodeWord, i8 - iDecodeWhiteCodeWord);
                        }
                        z2 = !z2;
                        updatePointer(7 - i13);
                        i9 = i17;
                    } else if (i12 != 11) {
                        c = 1;
                        iDecodeWhiteCodeWord = this.w;
                        updatePointer(7 - i13);
                        i3 = 0;
                    } else {
                        if (nextLesserThan8Bits(3) != 7) {
                            throw new InvalidImageException(MessageLocalization.getComposedMessage("invalid.code.encountered.while.decoding.2d.group.4.compressed.data", new Object[0]));
                        }
                        boolean z3 = false;
                        int i18 = 0;
                        while (!z3) {
                            while (nextLesserThan8Bits(1) != 1) {
                                i18++;
                            }
                            if (i18 > 5) {
                                i18 -= 6;
                                if (!z2 && i18 > 0) {
                                    iArr3[i9] = iDecodeWhiteCodeWord;
                                    i9++;
                                }
                                iDecodeWhiteCodeWord += i18;
                                if (i18 > 0) {
                                    z2 = true;
                                }
                                if (nextLesserThan8Bits(1) == 0) {
                                    if (!z2) {
                                        iArr3[i9] = iDecodeWhiteCodeWord;
                                        i9++;
                                    }
                                    z = true;
                                } else {
                                    if (z2) {
                                        iArr3[i9] = iDecodeWhiteCodeWord;
                                        i9++;
                                    }
                                    z = false;
                                }
                                z2 = z;
                                z3 = true;
                            }
                            if (i18 == 5) {
                                if (!z2) {
                                    iArr3[i9] = iDecodeWhiteCodeWord;
                                    i9++;
                                }
                                iDecodeWhiteCodeWord += i18;
                                z2 = true;
                            } else {
                                int i19 = iDecodeWhiteCodeWord + i18;
                                iArr3[i9] = i19;
                                setToBlack(bArr, i7, i19, 1);
                                iDecodeWhiteCodeWord = i19 + 1;
                                i9++;
                                z2 = false;
                            }
                        }
                    }
                    i3 = 0;
                    c = 1;
                }
                iDecodeWhiteCodeWord = i8;
                i3 = 0;
                c = 1;
            }
            if (i9 < iArr3.length) {
                iArr3[i9] = iDecodeWhiteCodeWord;
                i9++;
            }
            this.changingElemSize = i9;
            i7 += i5;
            i6++;
            i3 = 0;
        }
    }

    public void setRecoverFromImageError(boolean z) {
        this.recoverFromImageError = z;
    }
}
