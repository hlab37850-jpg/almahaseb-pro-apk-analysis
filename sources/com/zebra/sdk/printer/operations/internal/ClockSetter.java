package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.settings.internal.JsonValidator;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class ClockSetter extends PrinterOperationBase<Void> {
    private static final long serialVersionUID = -8919634753534371273L;
    private String dateTime;
    DateTime formattedDateTime;

    public class DateTime {
        public String date;
        public String time;

        public DateTime(String str, String str2) {
            this.date = str;
            this.time = str2;
        }
    }

    public ClockSetter(String str, Connection connection, PrinterLanguage printerLanguage) {
        super(connection, printerLanguage);
        this.dateTime = str;
    }

    private DateTime formatDateTime(String str) throws ZebraIllegalArgumentException {
        String str2 = null;
        String str3 = null;
        for (String str4 : splitDateTimeFormat(str)) {
            if (str4.contains("-")) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yy");
                simpleDateFormat.setLenient(false);
                ParsePosition parsePosition = new ParsePosition(0);
                Date date = simpleDateFormat.parse(str4, parsePosition);
                if (parsePosition.getIndex() != str4.length()) {
                    throw new ZebraIllegalArgumentException("Invalid Date: \"" + str4 + "\"");
                }
                str2 = new SimpleDateFormat("MM-dd-yyyy").format(date);
            } else if (str4.contains(":")) {
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss");
                simpleDateFormat2.setLenient(false);
                ParsePosition parsePosition2 = new ParsePosition(0);
                simpleDateFormat2.parse(str4, parsePosition2);
                if (parsePosition2.getIndex() != str4.length()) {
                    throw new ZebraIllegalArgumentException("Invalid Time: \"" + str4 + "\"");
                }
                str3 = str4;
            } else {
                continue;
            }
        }
        return new DateTime(str2, str3);
    }

    private Date get100YearStartDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, 1998);
        calendar.set(2, 1);
        calendar.set(5, 1);
        return calendar.getTime();
    }

    private void setClock() {
        if (!shouldUseJson(this.connection, this.printerLanguage)) {
            String str = this.formattedDateTime.date;
            if (str != null) {
                SGD.SET("rtc.date", str, this.connection);
            }
            String str2 = this.formattedDateTime.time;
            if (str2 != null) {
                SGD.SET("rtc.time", str2, this.connection);
                return;
            }
            return;
        }
        if (this.formattedDateTime.date != null) {
            this.connection.sendAndWaitForValidResponse(("{}{\"rtc.date\":\"" + this.formattedDateTime.date + "\"}").getBytes(), this.connection.getMaxTimeoutForRead(), this.connection.getTimeToWaitForMoreData(), new JsonValidator());
        }
        if (this.formattedDateTime.time != null) {
            this.connection.sendAndWaitForValidResponse(("{}{\"rtc.time\":\"" + this.formattedDateTime.time + "\"}").getBytes(), this.connection.getMaxTimeoutForRead(), this.connection.getTimeToWaitForMoreData(), new JsonValidator());
        }
    }

    private boolean shouldUseJson(Connection connection, PrinterLanguage printerLanguage) {
        boolean z = connection instanceof StatusConnection;
        return z || !(z || (printerLanguage == PrinterLanguage.LINE_PRINT));
    }

    private String[] splitDateTimeFormat(String str) throws ZebraIllegalArgumentException {
        String[] strArrSplit = str.split(" ");
        if (str.contains("-") || str.contains(":")) {
            return strArrSplit;
        }
        throw new ZebraIllegalArgumentException("Invalid Date/Time: \"" + str + "\"");
    }

    @Override // com.zebra.sdk.printer.operations.internal.PrinterOperation
    public Void execute() {
        this.formattedDateTime = formatDateTime(this.dateTime);
        selectStatusChannelIfOpen();
        setClock();
        return null;
    }
}
