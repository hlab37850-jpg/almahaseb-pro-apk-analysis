package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public class LongHashtable implements Cloneable {
    private transient int count;
    private float loadFactor;
    private transient Entry[] table;
    private int threshold;

    public static class Entry {
        int hash;
        long key;
        Entry next;
        long value;

        public Entry(int i, long j, long j2, Entry entry) {
            this.hash = i;
            this.key = j;
            this.value = j2;
            this.next = entry;
        }

        public Object clone() {
            int i = this.hash;
            long j = this.key;
            long j2 = this.value;
            Entry entry = this.next;
            return new Entry(i, j, j2, entry != null ? (Entry) entry.clone() : null);
        }

        public long getKey() {
            return this.key;
        }

        public long getValue() {
            return this.value;
        }
    }

    public static class LongHashtableIterator implements Iterator<Entry> {
        Entry entry;
        int index;
        Entry[] table;

        public LongHashtableIterator(Entry[] entryArr) {
            this.table = entryArr;
            this.index = entryArr.length;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Entry entry;
            if (this.entry != null) {
                return true;
            }
            do {
                int i = this.index;
                int i2 = i - 1;
                this.index = i2;
                if (i <= 0) {
                    return false;
                }
                entry = this.table[i2];
                this.entry = entry;
            } while (entry == null);
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("remove.not.supported", new Object[0]));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Entry next() {
            Entry entry;
            if (this.entry == null) {
                do {
                    int i = this.index;
                    int i2 = i - 1;
                    this.index = i2;
                    if (i <= 0) {
                        break;
                    }
                    entry = this.table[i2];
                    this.entry = entry;
                } while (entry == null);
            }
            Entry entry2 = this.entry;
            if (entry2 == null) {
                throw new NoSuchElementException(MessageLocalization.getComposedMessage("inthashtableiterator", new Object[0]));
            }
            this.entry = entry2.next;
            return entry2;
        }
    }

    public LongHashtable() {
        this(150, 0.75f);
    }

    public void clear() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        while (true) {
            length--;
            if (length < 0) {
                this.count = 0;
                return;
            }
            entryArr[length] = null;
        }
    }

    public Object clone() {
        try {
            LongHashtable longHashtable = (LongHashtable) super.clone();
            longHashtable.table = new Entry[this.table.length];
            int length = this.table.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return longHashtable;
                }
                Entry[] entryArr = longHashtable.table;
                Entry entry = this.table[i];
                entryArr[i] = entry != null ? (Entry) entry.clone() : null;
                length = i;
            }
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean contains(long j) {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            for (Entry entry = entryArr[i]; entry != null; entry = entry.next) {
                if (entry.value == j) {
                    return true;
                }
            }
            length = i;
        }
    }

    public boolean containsKey(long j) {
        Entry[] entryArr = this.table;
        int i = (int) ((j >>> 32) ^ j);
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i && entry.key == j) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(long j) {
        return contains(j);
    }

    public long get(long j) {
        Entry[] entryArr = this.table;
        int i = (int) ((j >>> 32) ^ j);
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i && entry.key == j) {
                return entry.value;
            }
        }
        return 0L;
    }

    public Iterator<Entry> getEntryIterator() {
        return new LongHashtableIterator(this.table);
    }

    public long[] getKeys() {
        int i;
        long[] jArr = new long[this.count];
        int length = this.table.length;
        int i2 = 0;
        Entry entry = null;
        while (true) {
            if (entry == null) {
                while (true) {
                    i = length - 1;
                    if (length <= 0 || (entry = this.table[i]) != null) {
                        break;
                    }
                    length = i;
                }
                length = i;
            }
            if (entry == null) {
                return jArr;
            }
            Entry entry2 = entry.next;
            jArr[i2] = entry.key;
            entry = entry2;
            i2++;
        }
    }

    public long getOneKey() {
        if (this.count == 0) {
            return 0L;
        }
        int length = this.table.length;
        Entry entry = null;
        while (true) {
            int i = length - 1;
            if (length <= 0 || (entry = this.table[i]) != null) {
                break;
            }
            length = i;
        }
        if (entry == null) {
            return 0L;
        }
        return entry.key;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public long put(long j, long j2) {
        Entry[] entryArr = this.table;
        int i = (int) ((j >>> 32) ^ j);
        int i2 = Integer.MAX_VALUE & i;
        int length = i2 % entryArr.length;
        for (Entry entry = entryArr[length]; entry != null; entry = entry.next) {
            if (entry.hash == i && entry.key == j) {
                long j3 = entry.value;
                entry.value = j2;
                return j3;
            }
        }
        if (this.count >= this.threshold) {
            rehash();
            entryArr = this.table;
            length = i2 % entryArr.length;
        }
        entryArr[length] = new Entry(i, j, j2, entryArr[length]);
        this.count++;
        return 0L;
    }

    public void rehash() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        int i = (length * 2) + 1;
        Entry[] entryArr2 = new Entry[i];
        this.threshold = (int) (i * this.loadFactor);
        this.table = entryArr2;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            Entry entry = entryArr[i2];
            while (entry != null) {
                Entry entry2 = entry.next;
                int i3 = (entry.hash & Integer.MAX_VALUE) % i;
                entry.next = entryArr2[i3];
                entryArr2[i3] = entry;
                entry = entry2;
            }
            length = i2;
        }
    }

    public long remove(long j) {
        Entry[] entryArr = this.table;
        int i = (int) ((j >>> 32) ^ j);
        int length = (Integer.MAX_VALUE & i) % entryArr.length;
        Entry entry = null;
        for (Entry entry2 = entryArr[length]; entry2 != null; entry2 = entry2.next) {
            if (entry2.hash == i && entry2.key == j) {
                if (entry != null) {
                    entry.next = entry2.next;
                } else {
                    entryArr[length] = entry2.next;
                }
                this.count--;
                long j2 = entry2.value;
                entry2.value = 0L;
                return j2;
            }
            entry = entry2;
        }
        return 0L;
    }

    public int size() {
        return this.count;
    }

    public long[] toOrderedKeys() {
        long[] keys = getKeys();
        Arrays.sort(keys);
        return keys;
    }

    public LongHashtable(int i) {
        this(i, 0.75f);
    }

    public LongHashtable(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("illegal.capacity.1", i));
        }
        if (f > 0.0f) {
            i = i == 0 ? 1 : i;
            this.loadFactor = f;
            this.table = new Entry[i];
            this.threshold = (int) (i * f);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("illegal.load.1", String.valueOf(f)));
    }
}
