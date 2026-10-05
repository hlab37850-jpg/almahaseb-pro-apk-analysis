package com.zebra.sdk.util.internal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ZipUtil {
    private final String pathToZipFile;
    private FileInputStream fis = null;
    private ZipInputStream zin = null;
    private BufferedInputStream bis = null;

    public class EntryData {
        byte[] extraData;
        String name;
        byte[] srcData;
        File srcFile;

        public EntryData(String str) {
            this.srcFile = null;
            this.srcData = null;
            this.name = str;
        }

        public boolean equals(Object obj) {
            return ((EntryData) obj).name.equals(this.name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public EntryData(String str, File file) {
            this.srcData = null;
            this.name = str;
            this.srcFile = file;
        }

        public EntryData(String str, File file, byte[] bArr) {
            this.srcData = null;
            this.name = str;
            this.srcFile = file;
            this.extraData = bArr;
        }

        public EntryData(String str, byte[] bArr) {
            this.srcFile = null;
            this.name = str;
            this.srcData = bArr;
        }

        public EntryData(String str, byte[] bArr, byte[] bArr2) {
            this.srcFile = null;
            this.name = str;
            this.srcData = bArr;
            this.extraData = bArr2;
        }
    }

    public ZipUtil(String str) {
        this.pathToZipFile = str;
    }

    private void openStreams() throws IOException {
        closeStreams();
        this.fis = new FileInputStream(this.pathToZipFile);
        this.bis = new BufferedInputStream(this.fis);
        this.zin = new ZipInputStream(this.bis);
    }

    private Set<EntryData> readEntries() {
        List<String> entryNames = getEntryNames();
        HashSet hashSet = new HashSet();
        for (String str : entryNames) {
            try {
                hashSet.add(new EntryData(str, extractEntry(str)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hashSet;
    }

    private void writeEntries(Set<EntryData> set) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(this.pathToZipFile);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
        for (EntryData entryData : set) {
            ZipEntry zipEntry = new ZipEntry(entryData.name);
            byte[] bArr = entryData.extraData;
            if (bArr != null) {
                zipEntry.setExtra(bArr);
            }
            zipOutputStream.putNextEntry(zipEntry);
            byte[] bArr2 = entryData.srcData;
            if (bArr2 != null) {
                zipOutputStream.write(bArr2);
            } else if (entryData.srcFile != null) {
                FileInputStream fileInputStream = new FileInputStream(entryData.srcFile);
                byte[] bArr3 = new byte[16384];
                while (fileInputStream.available() > 0) {
                    zipOutputStream.write(bArr3, 0, fileInputStream.read(bArr3));
                }
                fileInputStream.close();
            }
            zipOutputStream.closeEntry();
        }
        zipOutputStream.close();
        fileOutputStream.close();
    }

    public void addEntry(String str, File file) throws IOException {
        addEntry(str, file, (byte[]) null);
    }

    public void closeStreams() throws IOException {
        ZipInputStream zipInputStream = this.zin;
        if (zipInputStream != null) {
            zipInputStream.close();
            this.zin = null;
        }
        BufferedInputStream bufferedInputStream = this.bis;
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
            this.bis = null;
        }
        FileInputStream fileInputStream = this.fis;
        if (fileInputStream != null) {
            fileInputStream.close();
            this.fis = null;
        }
    }

    public boolean containsEntry(String str) {
        boolean z = false;
        try {
            openStreams();
            while (true) {
                ZipEntry nextEntry = this.zin.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                if (nextEntry.getName().equals(str)) {
                    z = true;
                }
            }
            closeStreams();
        } catch (FileNotFoundException | IOException unused) {
        }
        return z;
    }

    public void extractEntry(String str, String str2) throws IOException {
        openStreams();
        while (true) {
            ZipEntry nextEntry = this.zin.getNextEntry();
            if (nextEntry == null) {
                closeStreams();
                return;
            }
            if (nextEntry.getName().equals(str2)) {
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i = this.zin.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, i);
                    }
                }
                fileOutputStream.close();
            }
        }
    }

    public byte[] extractExtraFromEntry(String str) throws IOException {
        ZipEntry nextEntry;
        openStreams();
        do {
            nextEntry = this.zin.getNextEntry();
            if (nextEntry == null) {
                closeStreams();
                return null;
            }
        } while (!nextEntry.getName().equals(str));
        return nextEntry.getExtra();
    }

    public String getEntryContents(String str) {
        return new String(extractEntry(str), "utf8");
    }

    public String getEntryExtraContent(String str) throws IOException {
        byte[] bArrExtractExtraFromEntry = extractExtraFromEntry(str);
        return bArrExtractExtraFromEntry == null ? "" : new String(bArrExtractExtraFromEntry, "utf8");
    }

    public List<String> getEntryNames() {
        ArrayList arrayList = new ArrayList();
        try {
            openStreams();
            while (true) {
                ZipEntry nextEntry = this.zin.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                arrayList.add(nextEntry.getName());
            }
            closeStreams();
        } catch (FileNotFoundException | IOException unused) {
        }
        return arrayList;
    }

    public InputStream getInputStreamToEntry(String str) throws IOException {
        ZipEntry nextEntry;
        openStreams();
        do {
            nextEntry = this.zin.getNextEntry();
            if (nextEntry == null) {
                closeStreams();
                return null;
            }
        } while (!nextEntry.getName().equals(str));
        return this.zin;
    }

    public void removeEntry(String str) throws IOException {
        String str2 = this.pathToZipFile;
        if (str2 == null || str2.isEmpty() || str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Set<EntryData> entries = readEntries();
        entries.remove(new EntryData(str));
        writeEntries(entries);
    }

    public void addEntry(String str, File file, byte[] bArr) throws IOException {
        String str2 = this.pathToZipFile;
        if (str2 == null || str2.isEmpty() || str == null || str.isEmpty() || file == null) {
            throw new IllegalArgumentException();
        }
        removeEntry(str);
        Set<EntryData> entries = readEntries();
        entries.add(new EntryData(str, file, bArr));
        writeEntries(entries);
    }

    public byte[] extractEntry(String str) throws IOException {
        InputStream inputStreamToEntry = getInputStreamToEntry(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        while (inputStreamToEntry != null) {
            int i = inputStreamToEntry.read(bArr);
            if (i == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        closeStreams();
        return byteArray;
    }

    public void addEntry(String str, byte[] bArr) throws IOException {
        addEntry(str, bArr, (byte[]) null);
    }

    public void addEntry(String str, byte[] bArr, byte[] bArr2) throws IOException {
        String str2 = this.pathToZipFile;
        if (str2 == null || str2.isEmpty() || str == null || str.isEmpty() || bArr == null) {
            throw new IllegalArgumentException();
        }
        removeEntry(str);
        Set<EntryData> entries = readEntries();
        entries.add(new EntryData(str, bArr, bArr2));
        writeEntries(entries);
    }
}
