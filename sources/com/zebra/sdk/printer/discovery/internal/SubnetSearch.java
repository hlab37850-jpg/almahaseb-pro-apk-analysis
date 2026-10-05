package com.zebra.sdk.printer.discovery.internal;

import com.zebra.sdk.printer.discovery.DiscoveryException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class SubnetSearch extends BroadcastA {
    private static final String EXCEPTION_STRING = "Malformed subnet search address";
    private static final int IP_SEARCH_RANGE_HIGH = 254;
    private static final int IP_SEARCH_RANGE_LOW = 1;

    public SubnetSearch(String str) {
        this(str, 6000);
    }

    private static InetAddress[] createSearchList(Matcher matcher) throws DiscoveryException {
        int highValue;
        int lowValue;
        String strGroup = matcher.group(2);
        if (strGroup == null) {
            throw new DiscoveryException(EXCEPTION_STRING);
        }
        if (strGroup.equals("*")) {
            highValue = 254;
            lowValue = 1;
        } else {
            lowValue = setLowValue(matcher.group(4));
            highValue = setHighValue(matcher.group(6), lowValue);
            if (!isRangeValid(lowValue, highValue)) {
                throw new DiscoveryException(EXCEPTION_STRING);
            }
        }
        ArrayList arrayList = new ArrayList();
        while (lowValue <= highValue) {
            try {
                arrayList.add(InetAddress.getByName(matcher.group(1) + "." + lowValue));
                lowValue++;
            } catch (UnknownHostException unused) {
                throw new DiscoveryException(EXCEPTION_STRING);
            }
        }
        return (InetAddress[]) arrayList.toArray(new InetAddress[0]);
    }

    private static InetAddress[] getAddressesToSearch(String str) throws DiscoveryException {
        if (str == null) {
            throw new DiscoveryException(EXCEPTION_STRING);
        }
        Matcher matcher = Pattern.compile("^([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})\\.?((([0-9]{1,3})(\\-([0-9]{1,3}|\\*))?)|\\*)?$").matcher(str);
        if (matcher.find()) {
            return createSearchList(matcher);
        }
        throw new DiscoveryException(EXCEPTION_STRING);
    }

    private static boolean isHighValueIsPresent(String str) {
        return str != null && str.length() > 0;
    }

    private static boolean isRangeValid(int i, int i2) {
        return i >= 1 && i <= 254 && i2 >= 1 && i2 <= 254 && i <= i2;
    }

    private static int setHighValue(String str, int i) {
        return isHighValueIsPresent(str) ? setHighValueWhichIsPresent(str) : i;
    }

    private static int setHighValueWhichIsPresent(String str) {
        if (str.equals("*")) {
            return 254;
        }
        return Integer.valueOf(str).intValue();
    }

    private static int setLowValue(String str) throws DiscoveryException {
        if (str != null) {
            return Integer.valueOf(str).intValue();
        }
        throw new DiscoveryException(EXCEPTION_STRING);
    }

    @Override // com.zebra.sdk.printer.discovery.internal.BroadcastA
    public void setSocketOptions(ZebraDiscoSocket zebraDiscoSocket) {
    }

    public SubnetSearch(String str, int i) {
        super(i);
        this.broadcastIpAddresses = getAddressesToSearch(str);
    }
}
