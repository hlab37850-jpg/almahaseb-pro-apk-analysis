package com.zebra.sdk.comm.snmp.internal;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import uk.co.westhawk.snmp.stack.AsnObjectId;
import uk.co.westhawk.snmp.stack.Pdu;
import uk.co.westhawk.snmp.stack.PduException;
import uk.co.westhawk.snmp.stack.SnmpContext;
import uk.co.westhawk.snmp.stack.varbind;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SnmpV1 implements Observer {
    public static final int[] default_retry_interval = {500, 1000, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, 5000, 5000};
    public static int port = 161;
    private SnmpContext context;
    private String host;
    protected int maxRetries;
    private Pdu pdu;
    private boolean pduInFlight;
    private String socketType;
    private varbind var;

    public SnmpV1(String str) {
        this(str, "public", 5);
    }

    public static int[] formTimeOut(int i, int i2) {
        if (i2 <= 0 || i <= 0) {
            return default_retry_interval;
        }
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            iArr[i3] = ((i * 1000) / i2) * i4;
            i3 = i4;
        }
        return iArr;
    }

    public static boolean isWellFormedOid(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Null oid");
        }
        try {
            new AsnObjectId(str);
            return true;
        } catch (Exception unused) {
            throw new IllegalArgumentException("Bad oid: [" + str + "]");
        }
    }

    public void destroy() {
        getContext().destroy();
    }

    public SnmpContext getContext() {
        return this.context;
    }

    public Pdu getPdu() {
        return this.pdu;
    }

    public Object getReturnOid() throws OidNotFoundException {
        varbind varbindVar = this.var;
        if (varbindVar != null) {
            return varbindVar.getOid().getValue();
        }
        throw new OidNotFoundException();
    }

    public Object getReturnValue() throws OidNotFoundException {
        varbind varbindVar = this.var;
        if (varbindVar != null) {
            return varbindVar.getValue();
        }
        throw new OidNotFoundException();
    }

    public void sendRequest() {
        if (this.pduInFlight) {
            return;
        }
        this.pduInFlight = true;
        this.pdu.addObserver(this);
        try {
            this.pdu.send();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PduException e2) {
            e2.printStackTrace();
        }
    }

    public void setContext(SnmpContext snmpContext) {
        this.context = snmpContext;
    }

    public void setPdu(Pdu pdu) {
        this.pdu = pdu;
    }

    public void setPduInFlight(boolean z) {
        this.pduInFlight = z;
    }

    public void setupSnmpContext(String str) {
        SnmpContext snmpContext = new SnmpContext(this.host, port, this.socketType);
        this.context = snmpContext;
        snmpContext.setCommunity(str);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (((Pdu) observable).getErrorStatus() == 0) {
            this.var = (varbind) obj;
        } else {
            this.var = null;
        }
    }

    public SnmpV1(String str, String str2, int i) {
        this.socketType = "Standard";
        this.host = str;
        this.maxRetries = i;
        setupSnmpContext(str2);
    }
}
