package com.zebra.sdk.printer;

import com.zebra.sdk.device.Device;
import com.zebra.sdk.device.FileUtilLinkOs;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ZebraPrinterLinkOs extends ZebraPrinter, Device, ProfileUtil, FontUtil, AlertProvider, FileUtilLinkOs, FormatUtilLinkOs, ToolsUtilLinkOs, FirmwareUpdaterLinkOs {
    String getGetCommunityName();

    LinkOsInformation getLinkOsInformation();

    List<TcpPortStatus> getPortStatus();

    void setGetCommunityName(String str);
}
