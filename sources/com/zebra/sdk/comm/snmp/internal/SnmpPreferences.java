package com.zebra.sdk.comm.snmp.internal;

import com.zebra.sdk.comm.internal.ConnectionAttributes;

/* JADX INFO: loaded from: classes3.dex */
public class SnmpPreferences {
    private static final int MAXRETRIES = 4;
    private static final int TIMEOUTGET = 5;
    private static final int TIMEOUTSET = 5;
    private String communityNameGet;
    private String communityNameSet;
    private int maxRetries;
    private int timeoutGet;
    private int timeoutSet;

    public SnmpPreferences() {
        this.communityNameGet = "public";
        this.communityNameSet = "public";
        this.maxRetries = 4;
        this.timeoutGet = 5;
        this.timeoutSet = 5;
    }

    public String getCommunityNameGet() {
        return this.communityNameGet;
    }

    public String getCommunityNameSet() {
        return this.communityNameSet;
    }

    public int getMaxRetries() {
        return this.maxRetries;
    }

    public int getTimeoutGet() {
        return this.timeoutGet;
    }

    public int getTimeoutSet() {
        return this.timeoutSet;
    }

    public void setCommunityNameGet(String str) {
        this.communityNameGet = str;
    }

    public void setCommunityNameSet(String str) {
        this.communityNameSet = str;
    }

    public SnmpPreferences(ConnectionAttributes connectionAttributes) {
        this.communityNameGet = "public";
        this.communityNameSet = "public";
        this.maxRetries = 4;
        this.timeoutGet = 5;
        this.timeoutSet = 5;
        this.communityNameGet = connectionAttributes.snmpGetCommunityName;
        this.communityNameSet = connectionAttributes.snmpSetCommunityName;
        this.timeoutGet = connectionAttributes.snmpTimeoutGet;
        this.timeoutSet = connectionAttributes.snmpTimeoutSet;
        this.maxRetries = connectionAttributes.snmpMaxRetries;
    }

    public SnmpPreferences(String str, String str2) {
        this.maxRetries = 4;
        this.timeoutGet = 5;
        this.timeoutSet = 5;
        this.communityNameGet = str;
        this.communityNameSet = str2;
    }
}
