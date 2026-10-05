package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class Jpeg2000 extends Image {
    public static final int JP2_BPCC = 1651532643;
    public static final int JP2_COLR = 1668246642;
    public static final int JP2_DBTL = 1685348972;
    public static final int JP2_FTYP = 1718909296;
    public static final int JP2_IHDR = 1768449138;
    public static final int JP2_JP = 1783636000;
    public static final int JP2_JP2 = 1785737760;
    public static final int JP2_JP2C = 1785737827;
    public static final int JP2_JP2H = 1785737832;
    public static final int JP2_URL = 1970433056;
    public static final int JPIP_JPIP = 1785751920;
    int boxLength;
    int boxType;
    byte[] bpcBoxData;
    ArrayList<ColorSpecBox> colorSpecBoxes;
    InputStream inp;
    boolean isJp2;
    int numOfComps;

    public static class ColorSpecBox extends ArrayList<Integer> {
        private byte[] colorProfile;

        public int getApprox() {
            return get(2).intValue();
        }

        public byte[] getColorProfile() {
            return this.colorProfile;
        }

        public int getEnumCs() {
            return get(3).intValue();
        }

        public int getMeth() {
            return get(0).intValue();
        }

        public int getPrec() {
            return get(1).intValue();
        }

        public void setColorProfile(byte[] bArr) {
            this.colorProfile = bArr;
        }
    }

    public Jpeg2000(Image image) {
        super(image);
        this.colorSpecBoxes = null;
        this.isJp2 = false;
        if (image instanceof Jpeg2000) {
            Jpeg2000 jpeg2000 = (Jpeg2000) image;
            this.numOfComps = jpeg2000.numOfComps;
            this.isJp2 = jpeg2000.isJp2;
            if (this.bpcBoxData != null) {
                this.bpcBoxData = (byte[]) jpeg2000.bpcBoxData.clone();
            }
        }
    }

    private int cio_read(int i) {
        int i2 = 0;
        for (int i3 = i - 1; i3 >= 0; i3--) {
            i2 += this.inp.read() << (i3 << 3);
        }
        return i2;
    }

    private ColorSpecBox jp2_read_colr() throws IOException {
        ColorSpecBox colorSpecBox = new ColorSpecBox();
        int i = 8;
        for (int i2 = 0; i2 < 3; i2++) {
            colorSpecBox.add(Integer.valueOf(cio_read(1)));
            i++;
        }
        if (colorSpecBox.getMeth() == 1) {
            colorSpecBox.add(Integer.valueOf(cio_read(4)));
            i += 4;
        } else {
            colorSpecBox.add(0);
        }
        int i3 = this.boxLength;
        if (i3 - i > 0) {
            byte[] bArr = new byte[i3 - i];
            this.inp.read(bArr, 0, i3 - i);
            colorSpecBox.setColorProfile(bArr);
        }
        return colorSpecBox;
    }

    private void processParameters() {
        this.type = 33;
        this.originalType = 8;
        this.inp = null;
        try {
            if (this.rawData == null) {
                this.inp = this.url.openStream();
            } else {
                this.inp = new ByteArrayInputStream(this.rawData);
            }
            int iCio_read = cio_read(4);
            this.boxLength = iCio_read;
            if (iCio_read == 12) {
                this.isJp2 = true;
                int iCio_read2 = cio_read(4);
                this.boxType = iCio_read2;
                if (1783636000 != iCio_read2) {
                    throw new IOException(MessageLocalization.getComposedMessage("expected.jp.marker", new Object[0]));
                }
                if (218793738 != cio_read(4)) {
                    throw new IOException(MessageLocalization.getComposedMessage("error.with.jp.marker", new Object[0]));
                }
                jp2_read_boxhdr();
                if (1718909296 != this.boxType) {
                    throw new IOException(MessageLocalization.getComposedMessage("expected.ftyp.marker", new Object[0]));
                }
                Utilities.skip(this.inp, this.boxLength - 8);
                jp2_read_boxhdr();
                do {
                    int i = this.boxType;
                    if (1785737832 != i) {
                        if (i == 1785737827) {
                            throw new IOException(MessageLocalization.getComposedMessage("expected.jp2h.marker", new Object[0]));
                        }
                        Utilities.skip(this.inp, this.boxLength - 8);
                        jp2_read_boxhdr();
                    }
                } while (1785737832 != this.boxType);
                jp2_read_boxhdr();
                if (1768449138 != this.boxType) {
                    throw new IOException(MessageLocalization.getComposedMessage("expected.ihdr.marker", new Object[0]));
                }
                float fCio_read = cio_read(4);
                this.scaledHeight = fCio_read;
                setTop(fCio_read);
                float fCio_read2 = cio_read(4);
                this.scaledWidth = fCio_read2;
                setRight(fCio_read2);
                this.numOfComps = cio_read(2);
                this.bpc = -1;
                this.bpc = cio_read(1);
                Utilities.skip(this.inp, 3);
                jp2_read_boxhdr();
                int i2 = this.boxType;
                if (i2 == 1651532643) {
                    int i3 = this.boxLength;
                    byte[] bArr = new byte[i3 - 8];
                    this.bpcBoxData = bArr;
                    this.inp.read(bArr, 0, i3 - 8);
                } else if (i2 == 1668246642) {
                    do {
                        if (this.colorSpecBoxes == null) {
                            this.colorSpecBoxes = new ArrayList<>();
                        }
                        this.colorSpecBoxes.add(jp2_read_colr());
                        try {
                            jp2_read_boxhdr();
                        } catch (ZeroBoxSizeException unused) {
                        }
                    } while (1668246642 == this.boxType);
                }
            } else {
                if (iCio_read != -11534511) {
                    throw new IOException(MessageLocalization.getComposedMessage("not.a.valid.jpeg2000.file", new Object[0]));
                }
                Utilities.skip(this.inp, 4);
                int iCio_read3 = cio_read(4);
                int iCio_read4 = cio_read(4);
                int iCio_read5 = cio_read(4);
                int iCio_read6 = cio_read(4);
                Utilities.skip(this.inp, 16);
                this.colorspace = cio_read(2);
                this.bpc = 8;
                float f = iCio_read4 - iCio_read6;
                this.scaledHeight = f;
                setTop(f);
                float f2 = iCio_read3 - iCio_read5;
                this.scaledWidth = f2;
                setRight(f2);
            }
            InputStream inputStream = this.inp;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
                this.inp = null;
            }
            this.plainWidth = getWidth();
            this.plainHeight = getHeight();
        } catch (Throwable th) {
            InputStream inputStream2 = this.inp;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception unused3) {
                }
                this.inp = null;
            }
            throw th;
        }
    }

    public byte[] getBpcBoxData() {
        return this.bpcBoxData;
    }

    public ArrayList<ColorSpecBox> getColorSpecBoxes() {
        return this.colorSpecBoxes;
    }

    public int getNumOfComps() {
        return this.numOfComps;
    }

    public boolean isJp2() {
        return this.isJp2;
    }

    public void jp2_read_boxhdr() throws IOException {
        this.boxLength = cio_read(4);
        this.boxType = cio_read(4);
        int i = this.boxLength;
        if (i != 1) {
            if (i == 0) {
                throw new ZeroBoxSizeException(MessageLocalization.getComposedMessage("unsupported.box.size.eq.eq.0", new Object[0]));
            }
        } else {
            if (cio_read(4) != 0) {
                throw new IOException(MessageLocalization.getComposedMessage("cannot.handle.box.sizes.higher.than.2.32", new Object[0]));
            }
            int iCio_read = cio_read(4);
            this.boxLength = iCio_read;
            if (iCio_read == 0) {
                throw new IOException(MessageLocalization.getComposedMessage("unsupported.box.size.eq.eq.0", new Object[0]));
            }
        }
    }

    public class ZeroBoxSizeException extends IOException {
        public ZeroBoxSizeException() {
        }

        public ZeroBoxSizeException(String str) {
            super(str);
        }
    }

    public Jpeg2000(URL url) {
        super(url);
        this.colorSpecBoxes = null;
        this.isJp2 = false;
        processParameters();
    }

    public Jpeg2000(byte[] bArr) {
        super((URL) null);
        this.colorSpecBoxes = null;
        this.isJp2 = false;
        this.rawData = bArr;
        this.originalData = bArr;
        processParameters();
    }

    public Jpeg2000(byte[] bArr, float f, float f2) {
        this(bArr);
        this.scaledWidth = f;
        this.scaledHeight = f2;
    }
}
