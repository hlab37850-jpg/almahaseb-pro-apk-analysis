package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.IpAddressable;
import com.zebra.sdk.comm.internal.ConnectionAttributeProvider;
import com.zebra.sdk.comm.internal.ConnectionAttributes;
import com.zebra.sdk.comm.snmp.internal.OidNotFoundException;
import com.zebra.sdk.comm.snmp.internal.SnmpGetNext;
import com.zebra.sdk.comm.snmp.internal.SnmpPreferences;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.TcpPortStatus;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class PortStatus {
    private static final String PORT_STATUS_OID = "1.3.6.1.2.1.6.13.1.1";

    private PortStatus() {
    }

    public static List<TcpPortStatus> getPortStatus(Connection connection, String str) {
        try {
            return getPortStatusViaSnmp(connection, str);
        } catch (ConnectionException unused) {
            return getPortStatusViaSGD(connection);
        }
    }

    private static ArrayList<TcpPortStatus> getPortStatusViaSGD(Connection connection) throws ConnectionException {
        ArrayList<TcpPortStatus> arrayList = new ArrayList<>();
        String[] strArrSplit = SGD.GET("ip.netstat", connection).split(StringUtilities.CRLF);
        if (strArrSplit.length <= 2) {
            throw new ConnectionException("Port status could not be obtained.");
        }
        for (int i = 2; i < strArrSplit.length; i++) {
            String[] strArrSplit2 = strArrSplit[i].split("\\s+");
            if (strArrSplit2.length > 4 && strArrSplit2[0].equals("tcp")) {
                String str = strArrSplit2.length > 5 ? strArrSplit2[5] : "";
                String str2 = strArrSplit2[3];
                String strSubstring = str2.substring(str2.lastIndexOf(46) + 1);
                String str3 = strArrSplit2[4];
                String strSubstring2 = str3.substring(0, str3.lastIndexOf(46));
                if (strSubstring2.equals("*")) {
                    strSubstring2 = "0.0.0.0";
                }
                String str4 = strSubstring2;
                String str5 = strArrSplit2[4];
                String strSubstring3 = str5.substring(str5.lastIndexOf(46) + 1);
                if (strSubstring3.equals("*")) {
                    strSubstring3 = "0";
                }
                arrayList.add(new TcpPortStatus(strSubstring, lookupType(strSubstring), str4, strSubstring3, str));
            }
        }
        Collections.sort(arrayList, new Comparator<TcpPortStatus>() { // from class: com.zebra.sdk.printer.internal.PortStatus.1
            @Override // java.util.Comparator
            public int compare(TcpPortStatus tcpPortStatus, TcpPortStatus tcpPortStatus2) {
                int i2 = Integer.parseInt(tcpPortStatus.getPrinterPort());
                int i3 = Integer.parseInt(tcpPortStatus2.getPrinterPort());
                if (i2 < i3) {
                    return -1;
                }
                if (i2 > i3) {
                    return 1;
                }
                int i4 = Integer.parseInt(tcpPortStatus.getRemotePort());
                int i5 = Integer.parseInt(tcpPortStatus2.getRemotePort());
                if (i4 < i5) {
                    return -1;
                }
                return i4 > i5 ? 1 : 0;
            }
        });
        return arrayList;
    }

    private static ArrayList<TcpPortStatus> getPortStatusViaSnmp(Connection connection, String str) throws Throwable {
        ArrayList<TcpPortStatus> arrayList = new ArrayList<>();
        if (!(connection instanceof IpAddressable)) {
            throw new ConnectionException("Connection does not support SNMP");
        }
        Pattern patternCompile = Pattern.compile("1.3.6.1.2.1.6.13.1.1.([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}).([0-9]{1,5}).([0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}).([0-9]{1,5})");
        ConnectionAttributes attributes = new ConnectionAttributeProvider().getAttributes(connection);
        attributes.snmpGetCommunityName = str;
        SnmpGetNext snmpGetNext = null;
        try {
            try {
                SnmpGetNext snmpGetNext2 = new SnmpGetNext(((IpAddressable) connection).getAddress(), new SnmpPreferences(attributes));
                String str2 = PORT_STATUS_OID;
                String str3 = "KNOWN";
                while (!str3.equals("UNKNOWN")) {
                    try {
                        snmpGetNext2.init(str2);
                        snmpGetNext2.sendRequest();
                        snmpGetNext2.getPdu().waitForSelf();
                        str2 = (String) snmpGetNext2.getReturnOid();
                        Matcher matcher = patternCompile.matcher(str2);
                        String strLookupStatus = lookupStatus(snmpGetNext2.getReturnValue().toString());
                        if (matcher.find()) {
                            String strGroup = matcher.group(2);
                            arrayList.add(new TcpPortStatus(strGroup, lookupType(strGroup), matcher.group(3), matcher.group(4), strLookupStatus));
                        }
                        str3 = strLookupStatus;
                    } catch (OidNotFoundException e) {
                        e = e;
                        throw new ConnectionException(e.getMessage());
                    } catch (IOException e2) {
                        e = e2;
                        throw new ConnectionException(e.getMessage());
                    } catch (Throwable th) {
                        th = th;
                        snmpGetNext = snmpGetNext2;
                        if (snmpGetNext != null) {
                            snmpGetNext.destroy();
                        }
                        throw th;
                    }
                }
                snmpGetNext2.destroy();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (OidNotFoundException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
    }

    private static String lookupStatus(String str) {
        try {
            switch (Integer.parseInt(str)) {
                case 1:
                    return "CLOSED";
                case 2:
                    return "LISTEN";
                case 3:
                    return "SYN_SENT";
                case 4:
                    return "SYN_RCVD";
                case 5:
                    return "ESTABLISHED";
                case 6:
                    return "FIN_WAIT_1";
                case 7:
                    return "FIN_WAIT_2";
                case 8:
                    return "CLOSED_WAIT";
                case 9:
                    return "CLOSING";
                case 10:
                    return "LAST_ACK";
                case 11:
                    return "TIME_WAIT";
                default:
                    return "UNKNOWN";
            }
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    private static String lookupType(String str) {
        StringBuilder sb;
        String str2;
        String string = "";
        try {
            int i = Integer.parseInt(str);
            String str3 = "FTP";
            if (i == 20) {
                sb = new StringBuilder();
                sb.append("");
            } else {
                if (i != 21) {
                    if (i == 23) {
                        sb = new StringBuilder();
                        sb.append("");
                        str2 = "Telnet";
                    } else if (i == 25) {
                        sb = new StringBuilder();
                        sb.append("");
                        str2 = "SMTP";
                    } else if (i == 80) {
                        sb = new StringBuilder();
                        sb.append("");
                        str2 = "HTTP";
                    } else if (i == 110) {
                        sb = new StringBuilder();
                        sb.append("");
                        str2 = "POP3";
                    } else if (i == 515) {
                        sb = new StringBuilder();
                        sb.append("");
                        str2 = "LPD";
                    } else if (i != 631) {
                        str3 = "RAW";
                        if (i == 6101) {
                            string = "RAW";
                        }
                        if (i < 9100 || i > 9112) {
                            return string;
                        }
                        sb = new StringBuilder();
                        sb.append(string);
                    } else {
                        sb = new StringBuilder();
                        sb.append("");
                        str2 = "IPP";
                    }
                    sb.append(str2);
                    string = sb.toString();
                    return string;
                }
                sb = new StringBuilder();
                sb.append("");
            }
            sb.append(str3);
            string = sb.toString();
            return string;
        } catch (Exception unused) {
            return string;
        }
    }
}
