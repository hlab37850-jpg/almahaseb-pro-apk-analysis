package com.zebra.sdk.comm.snmp.internal;

import java.util.Observer;
import uk.co.westhawk.snmp.stack.AsnObject;
import uk.co.westhawk.snmp.stack.SetPdu;

/* JADX INFO: loaded from: classes3.dex */
public class SnmpSet extends SnmpV1 implements Observer {
    private int timeout;

    public SnmpSet(String str) {
        super(str);
    }

    public void init(String str, Object obj) {
        if (SnmpV1.isWellFormedOid(str)) {
            setPduInFlight(false);
            SetPdu setPdu = new SetPdu(getContext());
            setPdu.setRetryIntervals(SnmpV1.formTimeOut(this.timeout, this.maxRetries));
            setPdu.addOid(str, (AsnObject) obj);
            setPdu(setPdu);
        }
    }

    public SnmpSet(String str, SnmpPreferences snmpPreferences) {
        super(str, snmpPreferences.getCommunityNameSet(), snmpPreferences.getMaxRetries());
        this.timeout = snmpPreferences.getTimeoutSet();
    }
}
