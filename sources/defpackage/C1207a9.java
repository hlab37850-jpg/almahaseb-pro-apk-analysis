package defpackage;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.codec.TIFFConstants;
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

/* JADX INFO: renamed from: a9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1207a9 {
    public static int[] l = {0, 1, 3, 7, 15, 31, 63, ShapeTypes.VERTICAL_SCROLL, 255};
    public static int[] m = {0, 128, 192, 224, 240, 248, 252, TIFFConstants.TIFFTAG_SUBFILETYPE, 255};
    public static byte[] n = {0, UnsignedBytes.MAX_POWER_OF_TWO, 64, -64, 32, -96, 96, -32, 16, -112, 80, -48, ByteBuffer.ZERO, -80, 112, -16, 8, -120, 72, -56, 40, -88, 104, -24, Ascii.CAN, -104, 88, -40, PaletteRecord.STANDARD_PALETTE_SIZE, -72, 120, -8, 4, -124, 68, -60, RefPtg.sid, -92, 100, -28, 20, -108, 84, -44, 52, -76, 116, -12, 12, -116, 76, -52, RefNPtg.sid, -84, 108, -20, Ascii.FS, -100, 92, -36, 60, -68, 124, -4, 2, -126, 66, -62, 34, -94, 98, -30, 18, -110, 82, -46, 50, -78, 114, -14, 10, -118, 74, -54, RefErrorPtg.sid, -86, 106, -22, Ascii.SUB, -102, 90, -38, Ref3DPtg.sid, -70, 122, -6, 6, -122, 70, -58, 38, -90, 102, -26, 22, -106, 86, -42, 54, -74, 118, -10, 14, -114, 78, -50, 46, -82, 110, -18, 30, -98, 94, -34, DocWriter.GT, -66, 126, -2, 1, -127, 65, -63, 33, -95, 97, -31, 17, -111, 81, -47, 49, -79, 113, -15, 9, -119, 73, -55, MemFuncPtg.sid, -87, 105, -23, 25, -103, 89, -39, 57, -71, 121, -7, 5, -123, 69, -59, 37, -91, 101, -27, 21, -107, 85, -43, 53, -75, 117, -11, 13, -115, 77, -51, 45, -83, 109, -19, 29, -99, 93, -35, 61, -67, 125, -3, 3, -125, 67, -61, 35, -93, 99, -29, 19, -109, 83, -45, 51, -77, 115, -13, 11, -117, 75, -53, AreaErrPtg.sid, -85, 107, -21, Ascii.ESC, -101, 91, -37, Area3DPtg.sid, -69, 123, -5, 7, -121, 71, -57, 39, -89, 103, -25, 23, -105, 87, -41, 55, -73, 119, -9, 15, -113, 79, -49, DocWriter.FORWARD, -81, 111, -17, 31, -97, 95, -33, 63, -65, Ascii.DEL, -1};
    public static short[] o = {6430, 6400, 6400, 6400, 3225, 3225, 3225, 3225, 944, 944, 944, 944, 976, 976, 976, 976, 1456, 1456, 1456, 1456, 1488, 1488, 1488, 1488, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, 750, 750, 750, 750, 750, 750, 750, 750, 1520, 1520, 1520, 1520, 1552, 1552, 1552, 1552, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 654, 654, 654, 654, 654, 654, 654, 654, 1072, 1072, 1072, 1072, 1104, 1104, 1104, 1104, 1136, 1136, 1136, 1136, 1168, 1168, 1168, 1168, CodepageRecord.CODEPAGE, CodepageRecord.CODEPAGE, CodepageRecord.CODEPAGE, CodepageRecord.CODEPAGE, 1232, 1232, 1232, 1232, 622, 622, 622, 622, 622, 622, 622, 622, 1008, 1008, 1008, 1008, 1040, 1040, 1040, 1040, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, EscherProperties.FILL__FOCUS, 1712, 1712, 1712, 1712, 1744, 1744, 1744, 1744, 846, 846, 846, 846, 846, 846, 846, 846, 1264, 1264, 1264, 1264, 1296, 1296, 1296, 1296, 1328, 1328, 1328, 1328, 1360, 1360, 1360, 1360, 1392, 1392, 1392, 1392, 1424, 1424, 1424, 1424, 686, 686, 686, 686, 686, 686, 686, 686, 910, 910, 910, 910, 910, 910, 910, 910, 1968, 1968, 1968, 1968, 2000, 2000, 2000, 2000, 2032, 2032, 2032, 2032, 16, 16, 16, 16, 10257, 10257, 10257, 10257, 12305, 12305, 12305, 12305, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, EscherProperties.GEOMETRY__ADJUST4VALUE, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 878, 878, 878, 878, 878, 878, 878, 878, 1904, 1904, 1904, 1904, 1936, 1936, 1936, 1936, -18413, -18413, -16365, -16365, -14317, -14317, -10221, -10221, 590, 590, 590, 590, 590, 590, 590, 590, 782, 782, 782, 782, 782, 782, 782, 782, 1584, 1584, 1584, 1584, 1616, 1616, 1616, 1616, 1648, 1648, 1648, 1648, 1680, 1680, 1680, 1680, 814, 814, 814, 814, 814, 814, 814, 814, 1776, 1776, 1776, 1776, 1808, 1808, 1808, 1808, 1840, 1840, 1840, 1840, 1872, 1872, 1872, 1872, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, 14353, 14353, 14353, 14353, 16401, 16401, 16401, 16401, 22547, 22547, 24595, 24595, 20497, 20497, 20497, 20497, 18449, 18449, 18449, 18449, 26643, 26643, 28691, 28691, 30739, 30739, -32749, -32749, -30701, -30701, -28653, -28653, -26605, -26605, -24557, -24557, -22509, -22509, -20461, -20461, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, EscherAggregate.ST_CURVEDUPARROW, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, EscherProperties.BLIP__GAMMA, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherAggregate.ST_TEXTFADERIGHT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, EscherProperties.LINESTYLE__LINEMITERLIMIT, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_ACTIONBUTTONMOVIE, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 
    232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232};
    public static short[] p = {28679, 28679, 31752, -32759, -31735, -30711, -29687, -28663, 29703, 29703, 30727, 30727, -27639, -26615, -25591, -24567};
    public static short[] q = {3226, 6412, EscherAggregate.ST_ACTIONBUTTONMOVIE, EscherAggregate.ST_TEXTFADERIGHT, 38, 38, 134, 134, 100, 100, 100, 100, 68, 68, 68, 68};
    public static short[] r = {292, EscherProperties.BLIP__BLIPTODISPLAY, InterfaceEndRecord.sid, InterfaceEndRecord.sid};
    public static short[] s = {62, 62, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 588, 588, 588, 588, 588, 588, 588, 588, 1680, 1680, 20499, 22547, 24595, 26643, 1776, 1776, 1808, 1808, -24557, -22509, -20461, -18413, 1904, 1904, 1936, 1936, -16365, -14317, 782, 782, 782, 782, 814, 814, 814, 814, -12269, -10221, 10257, 10257, 12305, 12305, 14353, 14353, 16403, 18451, 1712, 1712, 1744, 1744, 28691, 30739, -32749, -30701, -28653, -26605, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 750, 750, 750, 750, 1616, 1616, 1648, 1648, 1424, 1424, 1456, 1456, 1488, 1488, 1520, 1520, 1840, 1840, 1872, 1872, 1968, 1968, 8209, 8209, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, EscherProperties.SHADOWSTYLE__SCALEYTOY, 556, 556, 556, 556, 556, 556, 556, 556, 1552, 1552, 1584, 1584, 2000, 2000, 2032, 2032, 976, 976, 1008, 1008, 1040, 1040, 1072, 1072, 1296, 1296, 1328, 1328, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.THREEDSTYLE__ORIGINX, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.LINESTYLE__FILLWIDTH, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, EscherProperties.GEOMETRY__SEGMENTINFO, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 4113, 4113, 6161, 6161, 848, 848, 880, 880, 912, 912, 944, 944, 622, 622, 622, 622, 654, 654, 654, 654, 1104, 1104, 1136, 1136, 1168, 1168, CodepageRecord.CODEPAGE, CodepageRecord.CODEPAGE, 1232, 1232, 1264, 1264, 686, 686, 686, 686, 1360, 1360, 1392, 1392, 12, 12, 12, 12, 12, 12, 12, 12, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE, EscherProperties.FILL__PATTERNTEXTURE};
    public static byte[] t = {80, 88, 23, 71, 30, 30, DocWriter.GT, DocWriter.GT, 4, 4, 4, 4, 4, 4, 4, 4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid, MemFuncPtg.sid};
    public byte[] c;
    public int d;
    public int f;
    public int[] h;
    public int[] i;
    public boolean e = false;
    public int g = 0;
    public int j = 0;
    public boolean k = false;
    public int a = 0;
    public int b = 0;

    public C1207a9(int i, int i2, int i3) {
        this.f = i;
        this.d = i2;
        this.h = new int[i2];
        this.i = new int[i2];
    }

    public final boolean a() {
        if (!this.e || this.a == 0) {
            return false;
        }
        this.b++;
        this.a = 0;
        return true;
    }

    public boolean b() {
        if (k(12) == 1) {
            return true;
        }
        p(12);
        return false;
    }

    public final int c() {
        boolean z = false;
        int i = 0;
        while (!z) {
            short s2 = q[j(4)];
            int i2 = (s2 >>> 1) & 15;
            int i3 = (s2 >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
            if (i3 == 100) {
                short s3 = s[k(9)];
                int i4 = s3 & 1;
                int i5 = (s3 >>> 1) & 15;
                int i6 = (s3 >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                if (i5 == 12) {
                    p(5);
                    short s4 = p[j(4)];
                    i += (s4 >>> 4) & 4095;
                    p(4 - ((s4 >>> 1) & 7));
                } else {
                    if (i5 == 15) {
                        throw new RuntimeException("EOL code word encountered in Black run.");
                    }
                    i += i6;
                    p(9 - i5);
                    if (i4 == 0) {
                    }
                }
            } else if (i3 == 200) {
                short s5 = r[j(2)];
                i += (s5 >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                p(2 - ((s5 >>> 1) & 15));
            } else {
                i += i3;
                p(4 - i2);
            }
            z = true;
        }
        return i;
    }

    public void d(byte[] bArr, int i, int i2) {
        this.g = 0;
        boolean z = true;
        while (i2 < this.d) {
            while (z) {
                int iK = k(10);
                short s2 = o[iK];
                int i3 = s2 & 1;
                int i4 = (s2 >>> 1) & 15;
                if (i4 == 12) {
                    short s3 = p[(12 & (iK << 2)) | j(2)];
                    i2 += (s3 >>> 4) & 4095;
                    p(4 - ((s3 >>> 1) & 7));
                } else {
                    if (i4 == 0) {
                        throw new RuntimeException("Invalid code encountered.");
                    }
                    if (i4 == 15) {
                        p(10);
                        return;
                    }
                    i2 += (s2 >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                    p(10 - i4);
                    if (i3 == 0) {
                        int[] iArr = this.i;
                        int i5 = this.g;
                        this.g = i5 + 1;
                        iArr[i5] = i2;
                        z = false;
                    }
                }
            }
            if (i2 == this.d) {
                a();
                break;
            }
            while (!z) {
                short s4 = q[j(4)];
                int i6 = (s4 >>> 1) & 15;
                int i7 = (s4 >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                if (i7 == 100) {
                    short s5 = s[k(9)];
                    int i8 = s5 & 1;
                    int i9 = (s5 >>> 1) & 15;
                    int i10 = (s5 >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                    if (i9 == 12) {
                        p(5);
                        short s6 = p[j(4)];
                        int i11 = (s6 >>> 1) & 7;
                        int i12 = (s6 >>> 4) & 4095;
                        o(bArr, i, i2, i12);
                        i2 += i12;
                        p(4 - i11);
                    } else {
                        if (i9 == 15) {
                            p(9);
                            return;
                        }
                        o(bArr, i, i2, i10);
                        i2 += i10;
                        p(9 - i9);
                        if (i8 == 0) {
                            int[] iArr2 = this.i;
                            int i13 = this.g;
                            this.g = i13 + 1;
                            iArr2[i13] = i2;
                        }
                    }
                } else if (i7 == 200) {
                    short s7 = r[j(2)];
                    int i14 = (s7 >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                    o(bArr, i, i2, i14);
                    i2 += i14;
                    p(2 - ((s7 >>> 1) & 15));
                    int[] iArr3 = this.i;
                    int i15 = this.g;
                    this.g = i15 + 1;
                    iArr3[i15] = i2;
                } else {
                    o(bArr, i, i2, i7);
                    i2 += i7;
                    p(4 - i6);
                    int[] iArr4 = this.i;
                    int i16 = this.g;
                    this.g = i16 + 1;
                    iArr4[i16] = i2;
                }
                z = true;
            }
            if (i2 == this.d) {
                a();
                break;
            }
        }
        int[] iArr5 = this.i;
        int i17 = this.g;
        this.g = i17 + 1;
        iArr5[i17] = i2;
    }

    public void e(byte[] bArr, byte[] bArr2, int i, int i2) {
        this.c = bArr2;
        int i3 = (this.d + 7) / 8;
        this.a = 0;
        this.b = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            b();
            d(bArr, i4, i);
            i4 += i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public void f(byte[] bArr, byte[] bArr2, int i, int i2) {
        this.c = bArr2;
        int i3 = (this.d + 7) / 8;
        boolean z = false;
        this.a = 0;
        this.b = 0;
        int[] iArr = new int[2];
        if (l(true) != 1) {
            throw new RuntimeException("First scanline must be 1D encoded.");
        }
        d(bArr, 0, i);
        int i4 = i3;
        int i5 = 1;
        while (i5 < i2) {
            if (l(z) == 0) {
                int[] iArr2 = this.h;
                this.h = this.i;
                this.i = iArr2;
                this.j = z ? 1 : 0;
                int i6 = -1;
                int iH = i;
                boolean z2 = true;
                int i7 = 0;
                ?? r6 = z;
                while (iH < this.d) {
                    i(i6, z2, iArr);
                    int i8 = iArr[r6];
                    i6 = iArr[1];
                    byte b = t[j(7)];
                    int i9 = (b & 120) >>> 3;
                    int i10 = b & 7;
                    if (i9 == 0) {
                        if (!z2) {
                            o(bArr, i4, iH, i6 - iH);
                        }
                        p(7 - i10);
                        iH = i6;
                    } else if (i9 == 1) {
                        p(7 - i10);
                        if (z2) {
                            int iH2 = iH + h();
                            int i11 = i7 + 1;
                            this.i[i7] = iH2;
                            int iC = c();
                            o(bArr, i4, iH2, iC);
                            iH = iH2 + iC;
                            i7 += 2;
                            this.i[i11] = iH;
                        } else {
                            int iC2 = c();
                            o(bArr, i4, iH, iC2);
                            int i12 = iH + iC2;
                            int i13 = i7 + 1;
                            this.i[i7] = i12;
                            iH = i12 + h();
                            i7 += 2;
                            this.i[i13] = iH;
                        }
                        i6 = iH;
                    } else {
                        if (i9 > 8) {
                            throw new RuntimeException("Invalid code encountered while decoding 2D group 3 compressed data.");
                        }
                        int i14 = i8 + (i9 - 5);
                        int i15 = i7 + 1;
                        this.i[i7] = i14;
                        if (!z2) {
                            o(bArr, i4, iH, i14 - iH);
                        }
                        z2 = !z2;
                        p(7 - i10);
                        i6 = i14;
                        iH = i6;
                        i7 = i15;
                    }
                    r6 = 0;
                }
                this.i[i7] = iH;
                this.g = i7 + 1;
            } else {
                d(bArr, i4, i);
            }
            i4 += i3;
            i5++;
            z = false;
        }
    }

    public synchronized void g(byte[] bArr, byte[] bArr2, int i, int i2) {
        boolean z;
        try {
            this.c = bArr2;
            int i3 = this.d;
            int i4 = (i3 + 7) / 8;
            int i5 = 0;
            this.a = 0;
            this.b = 0;
            int[] iArr = new int[2];
            int[] iArr2 = this.i;
            char c = 1;
            this.g = 1;
            iArr2[0] = i3;
            this.g = 1 + 1;
            iArr2[1] = i3;
            i2 = i2;
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                int[] iArr3 = this.h;
                this.h = this.i;
                this.i = iArr3;
                this.j = i5;
                int i8 = -1;
                int iH = i;
                boolean z2 = true;
                int i9 = 0;
                while (iH < this.d) {
                    i(i8, z2, iArr);
                    int i10 = iArr[i5];
                    int i11 = iArr[c];
                    byte b = t[j(7)];
                    int i12 = (b & 120) >>> 3;
                    int i13 = b & 7;
                    if (i12 == 0) {
                        if (!z2) {
                            int i14 = this.d;
                            if (i11 > i14) {
                                i11 = i14;
                            }
                            o(bArr, i6, iH, i11 - iH);
                        }
                        iH = i11;
                        p(7 - i13);
                    } else if (i12 == 1) {
                        p(7 - i13);
                        if (z2) {
                            int iH2 = iH + h();
                            int i15 = i9 + 1;
                            iArr3[i9] = iH2;
                            int iC = c();
                            int i16 = this.d;
                            if (iC > i16 - iH2) {
                                iC = i16 - iH2;
                            }
                            o(bArr, i6, iH2, iC);
                            iH = iH2 + iC;
                            i9 += 2;
                            iArr3[i15] = iH;
                        } else {
                            int iC2 = c();
                            int i17 = this.d;
                            if (iC2 > i17 - iH) {
                                iC2 = i17 - iH;
                            }
                            o(bArr, i6, iH, iC2);
                            int i18 = iH + iC2;
                            int i19 = i9 + 1;
                            iArr3[i9] = i18;
                            iH = i18 + h();
                            i9 += 2;
                            iArr3[i19] = iH;
                        }
                    } else if (i12 <= 8) {
                        int i20 = i10 + (i12 - 5);
                        int i21 = i9 + 1;
                        iArr3[i9] = i20;
                        if (!z2) {
                            int i22 = this.d;
                            if (i20 > i22) {
                                i20 = i22;
                            }
                            o(bArr, i6, iH, i20 - iH);
                        }
                        iH = i20;
                        z2 = !z2;
                        p(7 - i13);
                        i9 = i21;
                        i8 = iH;
                        i5 = 0;
                        c = 1;
                        i2 = i2;
                    } else {
                        if (i12 != 11) {
                            p(7 - i13);
                            iH = this.d;
                        } else {
                            if (j(3) != 7) {
                                throw new RuntimeException("Invalid code encountered while decoding 2D group 4 compressed data.");
                            }
                            boolean z3 = false;
                            int i23 = 0;
                            while (!z3) {
                                while (j(1) != 1) {
                                    i23++;
                                }
                                if (i23 > 5) {
                                    i23 -= 6;
                                    if (!z2 && i23 > 0) {
                                        iArr3[i9] = iH;
                                        i9++;
                                    }
                                    iH += i23;
                                    if (i23 > 0) {
                                        z2 = true;
                                    }
                                    if (j(1) == 0) {
                                        if (!z2) {
                                            iArr3[i9] = iH;
                                            i9++;
                                        }
                                        z = true;
                                    } else {
                                        if (z2) {
                                            iArr3[i9] = iH;
                                            i9++;
                                        }
                                        z = false;
                                    }
                                    z2 = z;
                                    z3 = true;
                                }
                                if (i23 == 5) {
                                    if (!z2) {
                                        iArr3[i9] = iH;
                                        i9++;
                                    }
                                    iH += i23;
                                    z2 = true;
                                } else {
                                    int i24 = iH + i23;
                                    iArr3[i9] = i24;
                                    o(bArr, i6, i24, 1);
                                    iH = i24 + 1;
                                    i9++;
                                    z2 = false;
                                }
                            }
                        }
                        i5 = 0;
                        c = 1;
                    }
                    i8 = iH;
                    i5 = 0;
                    c = 1;
                }
                a();
                if (i9 <= this.d) {
                    iArr3[i9] = iH;
                    i9++;
                }
                this.g = i9;
                i6 += i4;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final int h() {
        boolean z = true;
        int i = 0;
        while (z) {
            int iK = k(10);
            short s2 = o[iK];
            int i2 = s2 & 1;
            int i3 = (s2 >>> 1) & 15;
            if (i3 == 12) {
                short s3 = p[((iK << 2) & 12) | j(2)];
                i += (s3 >>> 4) & 4095;
                p(4 - ((s3 >>> 1) & 7));
            } else {
                if (i3 == 0) {
                    throw new RuntimeException("Invalid code encountered.");
                }
                if (i3 == 15) {
                    throw new RuntimeException("EOL code word encountered in White run.");
                }
                i += (s2 >>> 5) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
                p(10 - i3);
                if (i2 == 0) {
                    z = false;
                }
            }
        }
        return i;
    }

    public final void i(int i, boolean z, int[] iArr) {
        int[] iArr2 = this.h;
        int i2 = this.g;
        int i3 = this.j;
        int i4 = i3 > 0 ? i3 - 1 : 0;
        int i5 = z ? i4 & (-2) : i4 | 1;
        while (i5 < i2) {
            int i6 = iArr2[i5];
            if (i6 > i) {
                this.j = i5;
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

    public final int j(int i) {
        byte b;
        byte b2;
        byte[] bArr = this.c;
        int length = bArr.length - 1;
        int i2 = this.b;
        int i3 = this.f;
        if (i3 == 1) {
            b2 = bArr[i2];
            b = i2 == length ? (byte) 0 : bArr[i2 + 1];
        } else {
            if (i3 != 2) {
                throw new RuntimeException("tag must be either 1 or 2.");
            }
            byte[] bArr2 = n;
            byte b3 = bArr2[bArr[i2] & UnsignedBytes.MAX_VALUE];
            if (i2 == length) {
                b2 = b3;
            } else {
                b = bArr2[bArr[i2 + 1] & UnsignedBytes.MAX_VALUE];
                b2 = b3;
            }
        }
        int i4 = this.a;
        int i5 = 8 - i4;
        int i6 = i - i5;
        int i7 = i5 - i;
        if (i7 < 0) {
            int i8 = ((b & m[i6]) >>> (8 - i6)) | ((l[i5] & b2) << (-i7));
            this.b = i2 + 1;
            this.a = i6;
            return i8;
        }
        int i9 = (l[i5] & b2) >>> i7;
        int i10 = i4 + i;
        this.a = i10;
        if (i10 != 8) {
            return i9;
        }
        this.a = 0;
        this.b = i2 + 1;
        return i9;
    }

    public final int k(int i) {
        byte b;
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        int i2;
        int i3;
        byte[] bArr = this.c;
        int length = bArr.length - 1;
        int i4 = this.b;
        int i5 = this.f;
        if (i5 == 1) {
            b3 = bArr[i4];
            if (i4 == length) {
                b4 = 0;
            } else {
                int i6 = i4 + 1;
                if (i6 == length) {
                    b4 = bArr[i6];
                } else {
                    b = bArr[i6];
                    b2 = bArr[i4 + 2];
                    byte b6 = b;
                    b5 = b2;
                    b4 = b6;
                }
            }
            b5 = 0;
        } else {
            if (i5 != 2) {
                throw new RuntimeException("tag must be either 1 or 2.");
            }
            byte[] bArr2 = n;
            byte b7 = bArr2[bArr[i4] & UnsignedBytes.MAX_VALUE];
            if (i4 == length) {
                b3 = b7;
                b4 = 0;
            } else {
                int i7 = i4 + 1;
                if (i7 == length) {
                    b4 = bArr2[bArr[i7] & UnsignedBytes.MAX_VALUE];
                    b3 = b7;
                } else {
                    b = bArr2[bArr[i7] & UnsignedBytes.MAX_VALUE];
                    b2 = bArr2[bArr[i4 + 2] & UnsignedBytes.MAX_VALUE];
                    b3 = b7;
                    byte b8 = b;
                    b5 = b2;
                    b4 = b8;
                }
            }
            b5 = 0;
        }
        int i8 = 8 - this.a;
        int i9 = i - i8;
        if (i9 > 8) {
            i3 = i9 - 8;
            i2 = 8;
        } else {
            i2 = i9;
            i3 = 0;
        }
        this.b = i4 + 1;
        int i10 = (b3 & l[i8]) << i9;
        int[] iArr = m;
        int i11 = (b4 & iArr[i2]) >>> (8 - i2);
        if (i3 != 0) {
            i11 = (i11 << i3) | ((b5 & iArr[i3]) >>> (8 - i3));
            this.b = i4 + 2;
            this.a = i3;
        } else if (i2 == 8) {
            this.a = 0;
            this.b = i4 + 2;
        } else {
            this.a = i2;
        }
        return i10 | i11;
    }

    public final int l(boolean z) {
        if (!m()) {
            throw new RuntimeException("EOL not found");
        }
        if (this.k) {
            int i = 8 - this.a;
            if (k(i) != 0) {
                throw new RuntimeException("All fill bits preceding EOL code must be 0.");
            }
            if (i < 4 && k(8) != 0) {
                throw new RuntimeException("All fill bits preceding EOL code must be 0.");
            }
            int iK = k(8);
            if (z && (iK & 240) == 16) {
                this.k = false;
                p(4);
            } else {
                while (iK != 1) {
                    if (iK != 0) {
                        throw new RuntimeException("0 bits expected before EOL");
                    }
                    iK = k(8);
                }
            }
        } else {
            int iK2 = k(12);
            if (z && iK2 == 0 && k(4) == 1) {
                this.k = true;
                return 1;
            }
            if (iK2 != 1) {
                throw new RuntimeException("Scanline must begin with EOL code word.");
            }
        }
        return j(1);
    }

    public final boolean m() {
        int length = this.c.length * 8;
        int i = length - 1;
        int i2 = (this.b * 8) + this.a;
        while (i2 <= length - 13) {
            int iK = k(12);
            i2 += 12;
            while (iK != 1 && i2 < i) {
                iK = ((iK & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE) << 1) | (1 & j(1));
                i2++;
            }
            if (iK == 1) {
                p(12);
                return true;
            }
        }
        return false;
    }

    public void n(boolean z) {
        this.e = z;
    }

    public final void o(byte[] bArr, int i, int i2, int i3) {
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
            bArr[i10] = (byte) (bArr[i10] | (1 << (7 - (i4 & 7))));
            i4++;
        }
    }

    public final void p(int i) {
        if (i > 8) {
            this.b -= i / 8;
            i %= 8;
        }
        int i2 = this.a - i;
        if (i2 >= 0) {
            this.a = i2;
        } else {
            this.b--;
            this.a = i2 + 8;
        }
    }
}
