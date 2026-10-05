package org.apache.poi.hpsf.extractor;

import com.zebra.sdk.util.internal.StringUtilities;
import java.io.FileInputStream;
import java.io.OutputStream;
import org.apache.poi.POIDocument;
import org.apache.poi.POITextExtractor;
import org.apache.poi.hpsf.CustomProperties;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.Property;
import org.apache.poi.hpsf.SpecialPropertySet;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes2.dex */
public class HPSFPropertiesExtractor extends POITextExtractor {

    public static final class PropertiesOnlyDocument extends POIDocument {
        public PropertiesOnlyDocument(POIFSFileSystem pOIFSFileSystem) {
            super(pOIFSFileSystem);
        }

        @Override // org.apache.poi.POIDocument
        public void write(OutputStream outputStream) {
            throw new IllegalStateException("Unable to write, only for properties!");
        }
    }

    public HPSFPropertiesExtractor(POITextExtractor pOITextExtractor) {
        super(pOITextExtractor);
    }

    private static String getPropertiesText(SpecialPropertySet specialPropertySet) {
        if (specialPropertySet == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        PropertyIDMap propertySetIDMap = specialPropertySet.getPropertySetIDMap();
        Property[] properties = specialPropertySet.getProperties();
        for (int i = 0; i < properties.length; i++) {
            String string = Long.toString(properties[i].getID());
            Object obj = propertySetIDMap.get(properties[i].getID());
            if (obj != null) {
                string = obj.toString();
            }
            stringBuffer.append(string + " = " + getPropertyValueText(properties[i].getValue()) + StringUtilities.LF);
        }
        return stringBuffer.toString();
    }

    private static String getPropertyValueText(Object obj) {
        if (obj == null) {
            return "(not set)";
        }
        if (!(obj instanceof byte[])) {
            return obj.toString();
        }
        byte[] bArr = (byte[]) obj;
        if (bArr.length == 0) {
            return "";
        }
        if (bArr.length == 1) {
            return Byte.toString(bArr[0]);
        }
        if (bArr.length == 2) {
            return Integer.toString(LittleEndian.getUShort(bArr));
        }
        return bArr.length == 4 ? Long.toString(LittleEndian.getUInt(bArr)) : new String(bArr);
    }

    public static void main(String[] strArr) {
        for (String str : strArr) {
            System.out.println(new HPSFPropertiesExtractor(new POIFSFileSystem(new FileInputStream(str))).getText());
        }
    }

    public String getDocumentSummaryInformationText() {
        DocumentSummaryInformation documentSummaryInformation = this.document.getDocumentSummaryInformation();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getPropertiesText(documentSummaryInformation));
        CustomProperties customProperties = documentSummaryInformation == null ? null : documentSummaryInformation.getCustomProperties();
        if (customProperties != null) {
            for (String str : customProperties.nameSet()) {
                stringBuffer.append(str + " = " + getPropertyValueText(customProperties.get(str)) + StringUtilities.LF);
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.POITextExtractor
    public POITextExtractor getMetadataTextExtractor() {
        throw new IllegalStateException("You already have the Metadata Text Extractor, not recursing!");
    }

    public String getSummaryInformationText() {
        return getPropertiesText(this.document.getSummaryInformation());
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        return getSummaryInformationText() + getDocumentSummaryInformationText();
    }

    public HPSFPropertiesExtractor(POIDocument pOIDocument) {
        super(pOIDocument);
    }

    public HPSFPropertiesExtractor(POIFSFileSystem pOIFSFileSystem) {
        super(new PropertiesOnlyDocument(pOIFSFileSystem));
    }
}
