package com.itextpdf.text.pdf.fonts.cmaps;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class CMapCache {
    private static final HashMap<String, CMapUniCid> cacheUniCid = new HashMap<>();
    private static final HashMap<String, CMapCidUni> cacheCidUni = new HashMap<>();
    private static final HashMap<String, CMapCidByte> cacheCidByte = new HashMap<>();
    private static final HashMap<String, CMapByteCid> cacheByteCid = new HashMap<>();

    public static CMapByteCid getCachedCMapByteCid(String str) {
        CMapByteCid cMapByteCid;
        HashMap<String, CMapByteCid> map = cacheByteCid;
        synchronized (map) {
            cMapByteCid = map.get(str);
        }
        if (cMapByteCid == null) {
            cMapByteCid = new CMapByteCid();
            CMapParserEx.parseCid(str, cMapByteCid, new CidResource());
            synchronized (map) {
                map.put(str, cMapByteCid);
            }
        }
        return cMapByteCid;
    }

    public static CMapCidByte getCachedCMapCidByte(String str) {
        CMapCidByte cMapCidByte;
        HashMap<String, CMapCidByte> map = cacheCidByte;
        synchronized (map) {
            cMapCidByte = map.get(str);
        }
        if (cMapCidByte == null) {
            cMapCidByte = new CMapCidByte();
            CMapParserEx.parseCid(str, cMapCidByte, new CidResource());
            synchronized (map) {
                map.put(str, cMapCidByte);
            }
        }
        return cMapCidByte;
    }

    public static CMapCidUni getCachedCMapCidUni(String str) {
        CMapCidUni cMapCidUni;
        HashMap<String, CMapCidUni> map = cacheCidUni;
        synchronized (map) {
            cMapCidUni = map.get(str);
        }
        if (cMapCidUni == null) {
            cMapCidUni = new CMapCidUni();
            CMapParserEx.parseCid(str, cMapCidUni, new CidResource());
            synchronized (map) {
                map.put(str, cMapCidUni);
            }
        }
        return cMapCidUni;
    }

    public static CMapUniCid getCachedCMapUniCid(String str) {
        CMapUniCid cMapUniCid;
        HashMap<String, CMapUniCid> map = cacheUniCid;
        synchronized (map) {
            cMapUniCid = map.get(str);
        }
        if (cMapUniCid == null) {
            cMapUniCid = new CMapUniCid();
            CMapParserEx.parseCid(str, cMapUniCid, new CidResource());
            synchronized (map) {
                map.put(str, cMapUniCid);
            }
        }
        return cMapUniCid;
    }
}
