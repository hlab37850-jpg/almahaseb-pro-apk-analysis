package com.zebra.sdk.comm.snmp.internal;

import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.settings.internal.SettingType;
import java.io.IOException;
import uk.co.westhawk.snmp.stack.AsnInteger;
import uk.co.westhawk.snmp.stack.AsnObject;
import uk.co.westhawk.snmp.stack.AsnOctets;
import uk.co.westhawk.snmp.stack.Pdu;

/* JADX INFO: loaded from: classes3.dex */
public class Snmp {
    private SnmpPreferences snmpPreferences;
    private SettingType type;

    public Snmp(String str, String str2, SettingType settingType) {
        SnmpPreferences snmpPreferences = new SnmpPreferences();
        this.snmpPreferences = snmpPreferences;
        snmpPreferences.setCommunityNameGet(str);
        this.snmpPreferences.setCommunityNameSet(str2);
        this.type = settingType;
    }

    public String get(String str, String str2) throws Throwable {
        SnmpGet snmpGet = null;
        try {
            try {
                SnmpGet snmpGet2 = new SnmpGet(str, this.snmpPreferences);
                try {
                    snmpGet2.init(str2);
                    snmpGet2.sendRequest();
                    Pdu pdu = snmpGet2.getPdu();
                    pdu.waitForSelf();
                    if (pdu.isTimedOut()) {
                        throw new SnmpTimeoutException();
                    }
                    String string = ((AsnObject) snmpGet2.getReturnValue()).toString();
                    snmpGet2.destroy();
                    return string;
                } catch (IOException e) {
                    e = e;
                    snmpGet = snmpGet2;
                    throw new OidNotFoundException(e.getLocalizedMessage());
                } catch (Throwable th) {
                    th = th;
                    snmpGet = snmpGet2;
                    if (snmpGet != null) {
                        snmpGet.destroy();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void set(String str, String str2, String str3) throws Throwable {
        AsnOctets asnInteger;
        SnmpSet snmpSet = null;
        try {
            try {
                SnmpSet snmpSet2 = new SnmpSet(str, this.snmpPreferences);
                try {
                    SettingType settingType = this.type;
                    if (settingType == SettingType.STRING) {
                        asnInteger = new AsnOctets(str3);
                    } else {
                        if (settingType != SettingType.ENUM && settingType != SettingType.INTEGER) {
                            throw new ZebraIllegalArgumentException("Invalid setting type");
                        }
                        asnInteger = new AsnInteger(Integer.parseInt(str3));
                    }
                    snmpSet2.init(str2, asnInteger);
                    snmpSet2.sendRequest();
                    Pdu pdu = snmpSet2.getPdu();
                    pdu.waitForSelf();
                    boolean zIsTimedOut = pdu.isTimedOut();
                    snmpSet2.destroy();
                    if (zIsTimedOut) {
                        throw new SnmpTimeoutException();
                    }
                    snmpSet2.destroy();
                } catch (IOException e) {
                    e = e;
                    snmpSet = snmpSet2;
                    throw new OidNotFoundException(e.getLocalizedMessage());
                } catch (Throwable th) {
                    th = th;
                    snmpSet = snmpSet2;
                    if (snmpSet != null) {
                        snmpSet.destroy();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
