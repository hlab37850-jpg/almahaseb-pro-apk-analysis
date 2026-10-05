package com.zebra.sdk.printer;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.IpAddressable;
import com.zebra.sdk.comm.TcpConnection;
import com.zebra.sdk.comm.internal.ConnectionAttributeProvider;
import com.zebra.sdk.comm.internal.ConnectionAttributes;
import com.zebra.sdk.comm.snmp.internal.OidNotFoundException;
import com.zebra.sdk.comm.snmp.internal.Snmp;
import com.zebra.sdk.comm.snmp.internal.SnmpTimeoutException;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.settings.internal.SettingType;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.poi.hpsf.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class SnmpPrinter {
    private Connection connection;
    private String getCommunityName;
    private String setCommunityName;

    public SnmpPrinter(String str) {
        this(str, "public", "public");
    }

    private void init(String str) {
        this.connection = getConnection(str);
        initConnectionAttributes();
    }

    private void initConnectionAttributes() {
        ConnectionAttributes attributes = new ConnectionAttributeProvider().getAttributes(this.connection);
        attributes.snmpGetCommunityName = getGetCommunityName();
        attributes.snmpSetCommunityName = getSetCommunityName();
    }

    public Connection getConnection(String str) {
        return new TcpConnection(InetAddress.getByName(str).getHostAddress(), 0);
    }

    public int getDiscoTimeoutInMSec() {
        return Constants.CP_MAC_ROMAN;
    }

    public String getGetCommunityName() {
        return this.getCommunityName;
    }

    public String getOidValue(String str) throws SnmpException {
        try {
            return getSnmpImpl(getGetCommunityName(), getSetCommunityName(), SettingType.STRING).get(((IpAddressable) this.connection).getAddress(), str);
        } catch (OidNotFoundException unused) {
            throw new SnmpException("oid " + str + " not found.");
        } catch (SnmpTimeoutException unused2) {
            throw new SnmpException("Timed out retrieving " + str);
        }
    }

    public String getSetCommunityName() {
        return this.setCommunityName;
    }

    public Snmp getSnmpImpl(String str, String str2, SettingType settingType) {
        return new Snmp(getGetCommunityName(), getSetCommunityName(), settingType);
    }

    public void setOidValue(String str, int i) throws Throwable {
        try {
            getSnmpImpl(getGetCommunityName(), getSetCommunityName(), SettingType.INTEGER).set(((IpAddressable) this.connection).getAddress(), str, String.valueOf(i));
        } catch (OidNotFoundException unused) {
            throw new SnmpException("oid " + str + " not found.");
        } catch (SnmpTimeoutException unused2) {
            throw new SnmpException("Timed out setting " + str);
        } catch (ZebraIllegalArgumentException e) {
            throw new SnmpException(e.getLocalizedMessage());
        }
    }

    public SnmpPrinter(String str, String str2, String str3) throws SnmpException {
        this.getCommunityName = str2;
        this.setCommunityName = str3;
        try {
            init(str);
        } catch (ZebraIllegalArgumentException e) {
            throw new SnmpException(e.getLocalizedMessage());
        } catch (UnknownHostException unused) {
            throw new SnmpException("Could not resolve DNS name to IP Address.");
        }
    }

    public void setOidValue(String str, String str2) throws Throwable {
        try {
            getSnmpImpl(getGetCommunityName(), getSetCommunityName(), SettingType.STRING).set(((IpAddressable) this.connection).getAddress(), str, str2);
        } catch (OidNotFoundException unused) {
            throw new SnmpException("oid " + str + " not found.");
        } catch (SnmpTimeoutException unused2) {
            throw new SnmpException("Timed out setting " + str);
        } catch (ZebraIllegalArgumentException e) {
            throw new SnmpException(e.getLocalizedMessage());
        }
    }
}
