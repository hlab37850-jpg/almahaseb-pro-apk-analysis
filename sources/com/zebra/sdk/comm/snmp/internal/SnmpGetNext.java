package com.zebra.sdk.comm.snmp.internal;

import java.util.Observer;
import uk.co.westhawk.snmp.pdu.OneGetNextPdu;

/* JADX INFO: loaded from: classes3.dex */
public class SnmpGetNext extends SnmpV1 implements Observer {
    private int timeout;

    public SnmpGetNext(String str, SnmpPreferences snmpPreferences) {
        super(str, snmpPreferences.getCommunityNameGet(), snmpPreferences.getMaxRetries());
        this.timeout = snmpPreferences.getTimeoutGet();
    }

    public void init(String str) {
        if (SnmpV1.isWellFormedOid(str)) {
            setPduInFlight(false);
            OneGetNextPdu oneGetNextPdu = new OneGetNextPdu(getContext());
            oneGetNextPdu.setRetryIntervals(SnmpV1.formTimeOut(this.timeout, this.maxRetries));
            oneGetNextPdu.addOid(str);
            setPdu(oneGetNextPdu);
        }
    }
}
