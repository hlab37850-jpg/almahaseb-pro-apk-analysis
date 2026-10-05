package com.zebra.sdk.printer.discovery.internal;

import com.zebra.sdk.printer.discovery.DiscoveryException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class DirectedBroadcast extends BroadcastA {
    public DirectedBroadcast(String str) {
        this(str, 6000);
    }

    private static String getDirectedBroadcastAddress(String str) throws DiscoveryException {
        if (str == null) {
            throw new DiscoveryException("Malformed directed broadcast address");
        }
        Matcher matcher = Pattern.compile("^((\\d|[1-9]\\d|1\\d\\d|2([0-4]\\d|5[0-5]))\\.(\\d|[1-9]\\d|1\\d\\d|2([0-4]\\d|5[0-5]))\\.(\\d|[1-9]\\d|1\\d\\d|2([0-4]\\d|5[0-5])))(\\.?|\\.(\\d|[1-9]\\d|1\\d\\d|2([0-4]\\d|5[0-5])))?$").matcher(str);
        if (!matcher.find() || matcher.groupCount() <= 1) {
            throw new DiscoveryException("Malformed directed broadcast address");
        }
        return matcher.group(1) + ".255";
    }

    @Override // com.zebra.sdk.printer.discovery.internal.BroadcastA
    public void setSocketOptions(ZebraDiscoSocket zebraDiscoSocket) {
    }

    public String toString() {
        return this.broadcastIpAddresses[0].toString().substring(1);
    }

    public DirectedBroadcast(String str, int i) throws DiscoveryException {
        super(i);
        try {
            this.broadcastIpAddresses = InetAddress.getAllByName(getDirectedBroadcastAddress(str));
        } catch (UnknownHostException unused) {
            throw new DiscoveryException("Malformed directed broadcast address");
        }
    }
}
