package com.zebra.sdk.comm.snmp.internal;

import java.util.Observer;
import uk.co.westhawk.snmp.pdu.OneGetPdu;

/* JADX INFO: loaded from: classes3.dex */
public class SnmpGet extends SnmpV1 implements Observer {
    private int timeout;

    public SnmpGet(String str, SnmpPreferences snmpPreferences) {
        super(str, snmpPreferences.getCommunityNameGet(), snmpPreferences.getMaxRetries());
        this.timeout = snmpPreferences.getTimeoutGet();
    }

    public void init(String str) {
        if (SnmpV1.isWellFormedOid(str)) {
            setPduInFlight(false);
            OneGetPdu oneGetPdu = new OneGetPdu(getContext());
            oneGetPdu.setRetryIntervals(SnmpV1.formTimeOut(this.timeout, this.maxRetries));
            oneGetPdu.addOid(str);
            setPdu(oneGetPdu);
        }
    }
}
