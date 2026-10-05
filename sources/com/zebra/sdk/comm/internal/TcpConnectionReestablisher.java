package com.zebra.sdk.comm.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.ConnectionReestablisher;
import com.zebra.sdk.comm.MultichannelTcpConnection;
import com.zebra.sdk.comm.TcpConnection;
import com.zebra.sdk.comm.TcpStatusConnection;
import com.zebra.sdk.printer.PrinterReconnectionHandler;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.discovery.DiscoveredPrinter;
import com.zebra.sdk.printer.discovery.DiscoveryException;
import com.zebra.sdk.printer.discovery.DiscoveryHandler;
import com.zebra.sdk.printer.discovery.NetworkDiscoverer;
import com.zebra.sdk.util.internal.NetworkUtil;
import com.zebra.sdk.util.internal.SGDUtilities;
import com.zebra.sdk.util.internal.Sleeper;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes3.dex */
public class TcpConnectionReestablisher extends ConnectionReestablisherBase implements ConnectionReestablisher {
    public static final int INITIAL_DISCOVERY_TIMEOUT = 62;
    private String macAddr;

    public final class FullSubnetDiscoveryHandler implements DiscoveryHandler {
        public String address;
        public boolean isFinished = false;
        private String macAddress;

        public FullSubnetDiscoveryHandler(String str) {
            this.macAddress = str;
        }

        @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
        public void discoveryError(String str) {
            this.isFinished = true;
        }

        @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
        public void discoveryFinished() {
            this.isFinished = true;
        }

        @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
        public void foundPrinter(DiscoveredPrinter discoveredPrinter) {
            if (this.macAddress == null || !discoveredPrinter.getDiscoveryDataMap().get("HARDWARE_ADDRESS").equals(this.macAddress)) {
                return;
            }
            this.address = discoveredPrinter.address;
            this.isFinished = true;
        }
    }

    public final class SinglePrinterDiscoveryHandler implements DiscoveryHandler {
        public boolean isFinished;
        public DiscoveredPrinter printer;

        private SinglePrinterDiscoveryHandler() {
            this.isFinished = false;
        }

        @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
        public void discoveryError(String str) {
            this.isFinished = true;
        }

        @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
        public void discoveryFinished() {
            this.isFinished = true;
        }

        @Override // com.zebra.sdk.printer.discovery.DiscoveryHandler
        public void foundPrinter(DiscoveredPrinter discoveredPrinter) {
            this.printer = discoveredPrinter;
            this.isFinished = true;
        }
    }

    public TcpConnectionReestablisher(Connection connection, long j) {
        super(connection, j);
        try {
            this.macAddr = getPrinterMacAddressViaDiscovery();
        } catch (Exception unused) {
        }
    }

    public String getConnectionAddress() {
        Connection printingChannel = this.zebraPrinterConnection;
        if (!(printingChannel instanceof TcpConnection)) {
            if (!(printingChannel instanceof MultichannelTcpConnection)) {
                return "";
            }
            printingChannel = ((MultichannelTcpConnection) printingChannel).getPrintingChannel();
        }
        return ((TcpConnection) printingChannel).getAddress();
    }

    public String getConnectionPortNumber() {
        return ((TcpConnection) this.zebraPrinterConnection).getPortNumber();
    }

    public Connection getNewConnection(String str) {
        String connectionPortNumber = getConnectionPortNumber();
        return this.zebraPrinterConnection instanceof TcpStatusConnection ? new TcpStatusConnection(str, Integer.parseInt(connectionPortNumber)) : new TcpConnection(str, Integer.parseInt(connectionPortNumber));
    }

    public String getPrinterMacAddressViaDiscovery() {
        String connectionAddress = getConnectionAddress();
        SinglePrinterDiscoveryHandler singlePrinterDiscoveryHandler = new SinglePrinterDiscoveryHandler();
        NetworkUtil.startSinglePrinterDiscovery(connectionAddress, singlePrinterDiscoveryHandler);
        for (int i = 0; i < 62 && !singlePrinterDiscoveryHandler.isFinished; i++) {
            Sleeper.sleep(100L);
        }
        DiscoveredPrinter discoveredPrinter = singlePrinterDiscoveryHandler.printer;
        return discoveredPrinter != null ? discoveredPrinter.getDiscoveryDataMap().get("HARDWARE_ADDRESS") : "";
    }

    public String getUpdatedFwVersion(String str) {
        SinglePrinterDiscoveryHandler singlePrinterDiscoveryHandler = new SinglePrinterDiscoveryHandler();
        while (true) {
            NetworkUtil.startSinglePrinterDiscovery(str, singlePrinterDiscoveryHandler);
            while (!singlePrinterDiscoveryHandler.isFinished) {
                timeoutCheck();
                Sleeper.sleep(100L);
                if (singlePrinterDiscoveryHandler.isFinished && singlePrinterDiscoveryHandler.printer == null) {
                    singlePrinterDiscoveryHandler = new SinglePrinterDiscoveryHandler();
                }
            }
            return singlePrinterDiscoveryHandler.printer.getDiscoveryDataMap().get("FIRMWARE_VER");
        }
    }

    @Override // com.zebra.sdk.comm.ConnectionReestablisher
    public void reestablishConnection(PrinterReconnectionHandler printerReconnectionHandler) throws DiscoveryException {
        String strWaitForPrinterToComeOnlineViaSnmpAndSubnetDiscovery = waitForPrinterToComeOnlineViaSnmpAndSubnetDiscovery(this.macAddr);
        Sleeper.sleep(2500L);
        waitForConnectionToSucceed(strWaitForPrinterToComeOnlineViaSnmpAndSubnetDiscovery);
        Connection newConnection = getNewConnection(strWaitForPrinterToComeOnlineViaSnmpAndSubnetDiscovery);
        newConnection.open();
        printerReconnectionHandler.printerOnline(ZebraPrinterFactory.createLinkOsPrinter(ZebraPrinterFactory.getInstance(newConnection)), SGD.GET(SGDUtilities.APPL_NAME, newConnection));
    }

    public void waitForConnectionToSucceed(String str) {
        boolean z = true;
        while (z) {
            Connection newConnection = getNewConnection(str);
            try {
                try {
                    newConnection.open();
                    try {
                        newConnection.close();
                    } catch (ConnectionException unused) {
                    }
                    z = false;
                } catch (ConnectionException unused2) {
                    timeoutCheck();
                    try {
                        newConnection.close();
                    } catch (ConnectionException unused3) {
                    }
                }
            } catch (Throwable th) {
                try {
                    newConnection.close();
                } catch (ConnectionException unused4) {
                }
                throw th;
            }
        }
    }

    public String waitForPrinterToComeOnlineViaSnmpAndSubnetDiscovery(String str) throws DiscoveryException {
        DiscoveredPrinter discoveredPrinter;
        String str2;
        this.startTime = System.currentTimeMillis();
        FullSubnetDiscoveryHandler fullSubnetDiscoveryHandler = new FullSubnetDiscoveryHandler(str);
        SinglePrinterDiscoveryHandler singlePrinterDiscoveryHandler = new SinglePrinterDiscoveryHandler();
        while (true) {
            timeoutCheck();
            fullSubnetDiscoveryHandler.isFinished = false;
            singlePrinterDiscoveryHandler.isFinished = false;
            NetworkDiscoverer.findPrinters(fullSubnetDiscoveryHandler);
            try {
                NetworkDiscoverer.subnetSearch(singlePrinterDiscoveryHandler, InetAddress.getByName(this.zebraPrinterConnection.getSimpleConnectionName()).getHostAddress());
                while (true) {
                    if (!fullSubnetDiscoveryHandler.isFinished || !singlePrinterDiscoveryHandler.isFinished) {
                        Sleeper.sleep(100L);
                        if (fullSubnetDiscoveryHandler.isFinished && (str2 = fullSubnetDiscoveryHandler.address) != null) {
                            return str2;
                        }
                        if (singlePrinterDiscoveryHandler.isFinished && (discoveredPrinter = singlePrinterDiscoveryHandler.printer) != null) {
                            return discoveredPrinter.address;
                        }
                    }
                }
            } catch (UnknownHostException e) {
                throw new DiscoveryException("Unkown Host: " + e.getLocalizedMessage());
            }
        }
    }
}
