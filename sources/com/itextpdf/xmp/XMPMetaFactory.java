package com.itextpdf.xmp;

import com.itextpdf.xmp.impl.XMPMetaImpl;
import com.itextpdf.xmp.impl.XMPMetaParser;
import com.itextpdf.xmp.impl.XMPSchemaRegistryImpl;
import com.itextpdf.xmp.impl.XMPSerializerHelper;
import com.itextpdf.xmp.options.ParseOptions;
import com.itextpdf.xmp.options.SerializeOptions;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class XMPMetaFactory {
    private static XMPSchemaRegistry schema = new XMPSchemaRegistryImpl();
    private static XMPVersionInfo versionInfo = null;

    private XMPMetaFactory() {
    }

    private static void assertImplementation(XMPMeta xMPMeta) {
        if (!(xMPMeta instanceof XMPMetaImpl)) {
            throw new UnsupportedOperationException("The serializing service works onlywith the XMPMeta implementation of this library");
        }
    }

    public static XMPMeta create() {
        return new XMPMetaImpl();
    }

    public static XMPSchemaRegistry getSchemaRegistry() {
        return schema;
    }

    public static synchronized XMPVersionInfo getVersionInfo() {
        try {
            if (versionInfo == null) {
                try {
                    versionInfo = new XMPVersionInfo() { // from class: com.itextpdf.xmp.XMPMetaFactory.1
                        @Override // com.itextpdf.xmp.XMPVersionInfo
                        public int getBuild() {
                            return 3;
                        }

                        @Override // com.itextpdf.xmp.XMPVersionInfo
                        public int getMajor() {
                            return 5;
                        }

                        @Override // com.itextpdf.xmp.XMPVersionInfo
                        public String getMessage() {
                            return "Adobe XMP Core 5.1.0-jc003";
                        }

                        @Override // com.itextpdf.xmp.XMPVersionInfo
                        public int getMicro() {
                            return 0;
                        }

                        @Override // com.itextpdf.xmp.XMPVersionInfo
                        public int getMinor() {
                            return 1;
                        }

                        @Override // com.itextpdf.xmp.XMPVersionInfo
                        public boolean isDebug() {
                            return false;
                        }

                        public String toString() {
                            return "Adobe XMP Core 5.1.0-jc003";
                        }
                    };
                } catch (Throwable th) {
                    System.out.println(th);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return versionInfo;
    }

    public static XMPMeta parse(InputStream inputStream) {
        return parse(inputStream, null);
    }

    public static XMPMeta parseFromBuffer(byte[] bArr) {
        return parseFromBuffer(bArr, null);
    }

    public static XMPMeta parseFromString(String str) {
        return parseFromString(str, null);
    }

    public static void reset() {
        schema = new XMPSchemaRegistryImpl();
    }

    public static void serialize(XMPMeta xMPMeta, OutputStream outputStream) {
        serialize(xMPMeta, outputStream, null);
    }

    public static byte[] serializeToBuffer(XMPMeta xMPMeta, SerializeOptions serializeOptions) {
        assertImplementation(xMPMeta);
        return XMPSerializerHelper.serializeToBuffer((XMPMetaImpl) xMPMeta, serializeOptions);
    }

    public static String serializeToString(XMPMeta xMPMeta, SerializeOptions serializeOptions) {
        assertImplementation(xMPMeta);
        return XMPSerializerHelper.serializeToString((XMPMetaImpl) xMPMeta, serializeOptions);
    }

    public static XMPMeta parse(InputStream inputStream, ParseOptions parseOptions) {
        return XMPMetaParser.parse(inputStream, parseOptions);
    }

    public static XMPMeta parseFromBuffer(byte[] bArr, ParseOptions parseOptions) {
        return XMPMetaParser.parse(bArr, parseOptions);
    }

    public static XMPMeta parseFromString(String str, ParseOptions parseOptions) {
        return XMPMetaParser.parse(str, parseOptions);
    }

    public static void serialize(XMPMeta xMPMeta, OutputStream outputStream, SerializeOptions serializeOptions) {
        assertImplementation(xMPMeta);
        XMPSerializerHelper.serialize((XMPMetaImpl) xMPMeta, outputStream, serializeOptions);
    }
}
