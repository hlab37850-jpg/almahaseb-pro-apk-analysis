package com.zebra.sdk.printer.discovery.internal;

import com.itextpdf.text.pdf.PdfBoolean;
import com.zebra.sdk.printer.discovery.DiscoveredPrinterNetwork;
import com.zebra.sdk.printer.discovery.DiscoveryPacketDecodeException;
import com.zebra.sdk.util.internal.PacketParsingUtil;
import com.zebra.sdk.util.internal.StringUtilities;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class DiscoveryPacketDecoderLegacy {
    private static final int COMPANY_ABBREVIATION_OFFSET = 49;
    private static final int COMPANY_ABBREVIATION_SIZE = 5;
    private static final int DATE_CODE_OFFSET = 32;
    private static final int DATE_CODE_SIZE = 7;
    private static final int DEFAULT_GATEWAY_OFFSET = 80;
    private static final int DEFAULT_GATEWAY_SIZE = 4;
    private static final int DISCOVERY_VERSION_OFFSET = 3;
    private static final int FW_VERSION_OFFSET = 39;
    private static final int FW_VERSION_SIZE = 10;
    private static final int GET_COMMUNITY_NAME_OFFSET = 212;
    private static final int GET_COMMUNITY_NAME_SIZE = 32;
    private static final int HW_ADDRESS_OFFSET = 54;
    private static final int HW_ADDRESS_SIZE = 6;
    private static final int IP_ADDRESS_OFFSET = 72;
    private static final int IP_ADDRESS_SIZE = 4;
    private static final int MIN_PACKET_SIZE = 375;
    private static final int PORT_NAME_OFFSET = 359;
    private static final int PORT_NAME_SIZE = 16;
    private static final int PORT_STATUS_OFFSET = 358;
    private static final int PORT_STATUS_SIZE = 1;
    private static final int PRODUCT_NAME_OFFSET = 12;
    private static final int PRODUCT_NAME_SIZE = 20;
    private static final int PRODUCT_NUMBER_OFFSET = 4;
    private static final int PRODUCT_NUMBER_SIZE = 8;
    private static final int SERIAL_NUM_OFFSET = 60;
    private static final int SERIAL_NUM_SIZE = 10;
    private static final int SET_COMMUNITY_NAME_OFFSET = 244;
    private static final int SET_COMMUNITY_NAME_SIZE = 32;
    private static final int SUBNET_MASK_OFFSET = 76;
    private static final int SUBNET_MASK_SIZE = 4;
    private static final int SYSTEM_NAME_OFFSET = 84;
    private static final int SYSTEM_NAME_SIZE = 25;
    private static final int USING_NET_PROTOCOL_OFFSET = 70;
    private static final int USING_NET_PROTOCOL_SIZE = 2;
    private byte[] rawDiscoveryPacket;

    public DiscoveryPacketDecoderLegacy(byte[] bArr) {
        this.rawDiscoveryPacket = bArr;
    }

    private byte[] copyOfRange(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(i2 - i) + 1];
        for (int i3 = i; i3 <= i2; i3++) {
            bArr2[i3 - i] = bArr[i3];
        }
        return bArr2;
    }

    private String getCompanyAbbreviation() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, 49, 5);
    }

    private String getDateCode() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, 32, 7);
    }

    private HashMap<String, String> getDiscoveryDataMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("PORT_NUMBER", String.valueOf(getPrinterPort()));
        map.put("DNS_NAME", getDnsName());
        map.put("ADDRESS", getIpAddress());
        map.put("COMPANY_ABBREVIATION", getCompanyAbbreviation());
        map.put("DISCOVERY_VER", String.valueOf(getDiscoveryVersion()));
        map.put("PRODUCT_NUMBER", getProductNumber());
        map.put("PRODUCT_NAME", getProductName());
        map.put("DATE_CODE", getDateCode());
        map.put("FIRMWARE_VER", getFirmwareVersion());
        map.put("HARDWARE_ADDRESS", getHardwareAddress());
        map.put("SERIAL_NUMBER", getSerialNumber());
        map.put("USING_NET_PROTOCOL", getUsingNetProtocol() ? PdfBoolean.TRUE : PdfBoolean.FALSE);
        map.put("SUBNET_MASK", getSubnetmask());
        map.put("GATEWAY", getGateway());
        map.put("SYSTEM_NAME", getSystemName());
        map.put("PORT_NAME", getPortName());
        map.put("PORT_STATUS", getPortStatus().toString());
        map.put("ENCRYPTED_GET_COMMUNITY_NAME", getGetCommunityNameAsHexString());
        map.put("ENCRYPTED_SET_COMMUNITY_NAME", getSetCommunityNameAsHexString());
        return map;
    }

    private int getDiscoveryVersion() {
        return PacketParsingUtil.byte2int(this.rawDiscoveryPacket[3]);
    }

    private String getDnsName() {
        return getSystemName();
    }

    private String getFirmwareVersion() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, 39, 10);
    }

    private String getGateway() {
        return PacketParsingUtil.parseAddress(this.rawDiscoveryPacket, 80, 4);
    }

    private String getGetCommunityNameAsHexString() {
        return StringUtilities.byteArrayToHexString(copyOfRange(this.rawDiscoveryPacket, GET_COMMUNITY_NAME_OFFSET, SET_COMMUNITY_NAME_OFFSET));
    }

    private String getHardwareAddress() {
        return PacketParsingUtil.parseGeneralByte(this.rawDiscoveryPacket, 54, 6);
    }

    private String getIpAddress() {
        return PacketParsingUtil.parseAddress(this.rawDiscoveryPacket, 72, 4);
    }

    private String getPortName() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, PORT_NAME_OFFSET, 16);
    }

    private PrinterPortStatus getPortStatus() {
        return parseStatus(this.rawDiscoveryPacket, PORT_STATUS_OFFSET, 1);
    }

    private int getPrinterPort() {
        String productName = getProductName();
        return (productName.startsWith("QL") || productName.startsWith("RW") || productName.startsWith("MZ") || productName.startsWith("P4T") || productName.startsWith("MQ") || productName.startsWith("MU")) ? 6101 : 9100;
    }

    private String getProductName() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, 12, 20);
    }

    private String getProductNumber() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, 4, 8);
    }

    private String getSerialNumber() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, 60, 10);
    }

    private String getSetCommunityNameAsHexString() {
        return StringUtilities.byteArrayToHexString(copyOfRange(this.rawDiscoveryPacket, SET_COMMUNITY_NAME_OFFSET, 276));
    }

    private String getSubnetmask() {
        return PacketParsingUtil.parseAddress(this.rawDiscoveryPacket, 76, 4);
    }

    private String getSystemName() {
        return PacketParsingUtil.parseGeneralString(this.rawDiscoveryPacket, 84, 25);
    }

    private boolean getUsingNetProtocol() {
        return PacketParsingUtil.parseBoolean(this.rawDiscoveryPacket, 70, 2);
    }

    private static PrinterPortStatus parseStatus(byte[] bArr, int i, int i2) {
        return PrinterPortStatus.intToEnum(PacketParsingUtil.byte2int(bArr[i]));
    }

    public DiscoveredPrinterNetwork getDiscoveredPrinterNetwork() throws DiscoveryPacketDecodeException {
        if (this.rawDiscoveryPacket.length >= MIN_PACKET_SIZE) {
            return new DiscoveredPrinterNetwork(getDiscoveryDataMap());
        }
        throw new DiscoveryPacketDecodeException("Unable to parse the supplied discovery packet due to an invalid discovery packet length");
    }
}
