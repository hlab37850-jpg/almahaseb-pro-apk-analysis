package com.itextpdf.text.pdf.hyphenation;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public class TernaryTree implements Cloneable, Serializable {
    protected static final int BLOCK_SIZE = 2048;
    private static final long serialVersionUID = 5313366505322983510L;
    protected char[] eq;
    protected char freenode;
    protected char[] hi;
    protected CharVector kv;
    protected int length;
    protected char[] lo;
    protected char root;
    protected char[] sc;

    public class Iterator implements Enumeration<String> {
        String curkey;
        int cur = -1;
        Stack<Item> ns = new Stack<>();
        StringBuffer ks = new StringBuffer();

        public class Item implements Cloneable {
            char child;
            char parent;

            public Item() {
                this.parent = (char) 0;
                this.child = (char) 0;
            }

            /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
            public Item m5456clone() {
                return Iterator.this.new Item(this.parent, this.child);
            }

            public Item(char c, char c2) {
                this.parent = c;
                this.child = c2;
            }
        }

        public Iterator() {
            rewind();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private int run() {
            if (this.cur == -1) {
                return -1;
            }
            boolean z = false;
            while (true) {
                int i = this.cur;
                if (i != 0) {
                    if (TernaryTree.this.sc[i] != 65535) {
                        this.ns.push(new Item((char) i, (char) 0));
                        TernaryTree ternaryTree = TernaryTree.this;
                        char[] cArr = ternaryTree.sc;
                        int i2 = this.cur;
                        if (cArr[i2] != 0) {
                            this.cur = ternaryTree.lo[i2];
                        }
                    }
                    z = true;
                }
                if (z) {
                    StringBuffer stringBuffer = new StringBuffer(this.ks.toString());
                    TernaryTree ternaryTree2 = TernaryTree.this;
                    char[] cArr2 = ternaryTree2.sc;
                    int i3 = this.cur;
                    if (cArr2[i3] == 65535) {
                        for (int i4 = ternaryTree2.lo[i3]; TernaryTree.this.kv.get(i4) != 0; i4++) {
                            stringBuffer.append(TernaryTree.this.kv.get(i4));
                        }
                    }
                    this.curkey = stringBuffer.toString();
                    return 0;
                }
                int iUp = up();
                this.cur = iUp;
                if (iUp == -1) {
                    return -1;
                }
            }
        }

        private int up() {
            new Item();
            if (this.ns.empty()) {
                return -1;
            }
            int i = this.cur;
            if (i != 0) {
                TernaryTree ternaryTree = TernaryTree.this;
                if (ternaryTree.sc[i] == 0) {
                    return ternaryTree.lo[i];
                }
            }
            boolean z = true;
            char c = 0;
            while (z) {
                Item itemPop = this.ns.pop();
                char c2 = (char) (itemPop.child + 1);
                itemPop.child = c2;
                if (c2 == 1) {
                    TernaryTree ternaryTree2 = TernaryTree.this;
                    char[] cArr = ternaryTree2.sc;
                    char c3 = itemPop.parent;
                    if (cArr[c3] != 0) {
                        c = ternaryTree2.eq[c3];
                        this.ns.push(itemPop.m5456clone());
                        this.ks.append(TernaryTree.this.sc[itemPop.parent]);
                    } else {
                        itemPop.child = (char) (c2 + 1);
                        this.ns.push(itemPop.m5456clone());
                        c = TernaryTree.this.hi[itemPop.parent];
                    }
                } else if (c2 == 2) {
                    c = TernaryTree.this.hi[itemPop.parent];
                    this.ns.push(itemPop.m5456clone());
                    if (this.ks.length() > 0) {
                        StringBuffer stringBuffer = this.ks;
                        stringBuffer.setLength(stringBuffer.length() - 1);
                    }
                } else {
                    if (this.ns.empty()) {
                        return -1;
                    }
                    z = true;
                }
                z = false;
            }
            return c;
        }

        public char getValue() {
            int i = this.cur;
            if (i >= 0) {
                return TernaryTree.this.eq[i];
            }
            return (char) 0;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.cur != -1;
        }

        public void rewind() {
            this.ns.removeAllElements();
            this.ks.setLength(0);
            this.cur = TernaryTree.this.root;
            run();
        }

        @Override // java.util.Enumeration
        public String nextElement() {
            String str = this.curkey;
            this.cur = up();
            run();
            return str;
        }
    }

    public TernaryTree() {
        init();
    }

    private void compact(CharVector charVector, TernaryTree ternaryTree, char c) {
        if (c == 0) {
            return;
        }
        if (this.sc[c] != 65535) {
            compact(charVector, ternaryTree, this.lo[c]);
            if (this.sc[c] != 0) {
                compact(charVector, ternaryTree, this.eq[c]);
            }
            compact(charVector, ternaryTree, this.hi[c]);
            return;
        }
        int iFind = ternaryTree.find(this.kv.getArray(), this.lo[c]);
        if (iFind < 0) {
            iFind = charVector.alloc(strlen(this.kv.getArray(), this.lo[c]) + 1);
            strcpy(charVector.getArray(), iFind, this.kv.getArray(), this.lo[c]);
            ternaryTree.insert(charVector.getArray(), iFind, (char) iFind);
        }
        this.lo[c] = (char) iFind;
    }

    private void redimNodeArrays(int i) {
        char[] cArr = this.lo;
        int length = i < cArr.length ? i : cArr.length;
        char[] cArr2 = new char[i];
        System.arraycopy(cArr, 0, cArr2, 0, length);
        this.lo = cArr2;
        char[] cArr3 = new char[i];
        System.arraycopy(this.hi, 0, cArr3, 0, length);
        this.hi = cArr3;
        char[] cArr4 = new char[i];
        System.arraycopy(this.eq, 0, cArr4, 0, length);
        this.eq = cArr4;
        char[] cArr5 = new char[i];
        System.arraycopy(this.sc, 0, cArr5, 0, length);
        this.sc = cArr5;
    }

    public static int strcmp(char[] cArr, int i, char[] cArr2, int i2) {
        while (true) {
            char c = cArr[i];
            char c2 = cArr2[i2];
            if (c != c2) {
                return c - c2;
            }
            if (c == 0) {
                return 0;
            }
            i++;
            i2++;
        }
    }

    public static void strcpy(char[] cArr, int i, char[] cArr2, int i2) {
        while (true) {
            char c = cArr2[i2];
            if (c == 0) {
                cArr[i] = 0;
                return;
            } else {
                i2++;
                cArr[i] = c;
                i++;
            }
        }
    }

    public static int strlen(char[] cArr, int i) {
        int i2 = 0;
        while (i < cArr.length && cArr[i] != 0) {
            i2++;
            i++;
        }
        return i2;
    }

    public void balance() {
        int i = this.length;
        String[] strArr = new String[i];
        char[] cArr = new char[i];
        Iterator iterator = new Iterator();
        int i2 = 0;
        while (iterator.hasMoreElements()) {
            cArr[i2] = iterator.getValue();
            strArr[i2] = iterator.nextElement();
            i2++;
        }
        init();
        insertBalanced(strArr, cArr, 0, i);
    }

    public Object clone() {
        TernaryTree ternaryTree = new TernaryTree();
        ternaryTree.lo = (char[]) this.lo.clone();
        ternaryTree.hi = (char[]) this.hi.clone();
        ternaryTree.eq = (char[]) this.eq.clone();
        ternaryTree.sc = (char[]) this.sc.clone();
        ternaryTree.kv = (CharVector) this.kv.clone();
        ternaryTree.root = this.root;
        ternaryTree.freenode = this.freenode;
        ternaryTree.length = this.length;
        return ternaryTree;
    }

    public int find(String str) {
        int length = str.length();
        char[] cArr = new char[length + 1];
        str.getChars(0, length, cArr, 0);
        cArr[length] = 0;
        return find(cArr, 0);
    }

    public void init() {
        this.root = (char) 0;
        this.freenode = (char) 1;
        this.length = 0;
        this.lo = new char[2048];
        this.hi = new char[2048];
        this.eq = new char[2048];
        this.sc = new char[2048];
        this.kv = new CharVector();
    }

    public void insert(String str, char c) {
        int length = str.length();
        int i = length + 1;
        int i2 = this.freenode + i;
        char[] cArr = this.eq;
        if (i2 > cArr.length) {
            redimNodeArrays(cArr.length + 2048);
        }
        char[] cArr2 = new char[i];
        str.getChars(0, length, cArr2, 0);
        cArr2[length] = 0;
        this.root = insert(this.root, cArr2, 0, c);
    }

    public void insertBalanced(String[] strArr, char[] cArr, int i, int i2) {
        if (i2 < 1) {
            return;
        }
        int i3 = i2 >> 1;
        int i4 = i3 + i;
        insert(strArr[i4], cArr[i4]);
        insertBalanced(strArr, cArr, i, i3);
        insertBalanced(strArr, cArr, i4 + 1, (i2 - i3) - 1);
    }

    public Enumeration<String> keys() {
        return new Iterator();
    }

    public boolean knows(String str) {
        return find(str) >= 0;
    }

    public void printStats() {
        PrintStream printStream = System.out;
        printStream.println("Number of keys = " + Integer.toString(this.length));
        printStream.println("Node count = " + Integer.toString(this.freenode));
        printStream.println("Key Array length = " + Integer.toString(this.kv.length()));
    }

    public int size() {
        return this.length;
    }

    public void trimToSize() {
        balance();
        redimNodeArrays(this.freenode);
        CharVector charVector = new CharVector();
        charVector.alloc(1);
        compact(charVector, new TernaryTree(), this.root);
        this.kv = charVector;
        charVector.trimToSize();
    }

    public static int strcmp(String str, char[] cArr, int i) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            char c = cArr[i + i2];
            int i3 = cCharAt - c;
            if (i3 != 0 || c == 0) {
                return i3;
            }
            i2++;
        }
        char c2 = cArr[i + i2];
        if (c2 != 0) {
            return -c2;
        }
        return 0;
    }

    public static int strlen(char[] cArr) {
        return strlen(cArr, 0);
    }

    public int find(char[] cArr, int i) {
        char c = this.root;
        while (c != 0) {
            char c2 = this.sc[c];
            if (c2 == 65535) {
                if (strcmp(cArr, i, this.kv.getArray(), this.lo[c]) == 0) {
                    return this.eq[c];
                }
                return -1;
            }
            char c3 = cArr[i];
            int i2 = c3 - c2;
            if (i2 == 0) {
                if (c3 == 0) {
                    return this.eq[c];
                }
                i++;
                c = this.eq[c];
            } else if (i2 < 0) {
                c = this.lo[c];
            } else {
                c = this.hi[c];
            }
        }
        return -1;
    }

    public void insert(char[] cArr, int i, char c) {
        int iStrlen = this.freenode + strlen(cArr) + 1;
        char[] cArr2 = this.eq;
        if (iStrlen > cArr2.length) {
            redimNodeArrays(cArr2.length + 2048);
        }
        this.root = insert(this.root, cArr, i, c);
    }

    private char insert(char c, char[] cArr, int i, char c2) {
        int iStrlen = strlen(cArr, i);
        if (c == 0) {
            char c3 = this.freenode;
            this.freenode = (char) (c3 + 1);
            this.eq[c3] = c2;
            this.length++;
            this.hi[c3] = 0;
            if (iStrlen > 0) {
                this.sc[c3] = 65535;
                this.lo[c3] = (char) this.kv.alloc(iStrlen + 1);
                strcpy(this.kv.getArray(), this.lo[c3], cArr, i);
            } else {
                this.sc[c3] = 0;
                this.lo[c3] = 0;
            }
            return c3;
        }
        char[] cArr2 = this.sc;
        if (cArr2[c] == 65535) {
            char c4 = this.freenode;
            this.freenode = (char) (c4 + 1);
            char[] cArr3 = this.lo;
            cArr3[c4] = cArr3[c];
            char[] cArr4 = this.eq;
            cArr4[c4] = cArr4[c];
            cArr3[c] = 0;
            if (iStrlen > 0) {
                cArr2[c] = this.kv.get(cArr3[c4]);
                this.eq[c] = c4;
                char[] cArr5 = this.lo;
                char c5 = (char) (cArr5[c4] + 1);
                cArr5[c4] = c5;
                if (this.kv.get(c5) == 0) {
                    this.lo[c4] = 0;
                    this.sc[c4] = 0;
                    this.hi[c4] = 0;
                } else {
                    this.sc[c4] = 65535;
                }
            } else {
                cArr2[c4] = 65535;
                this.hi[c] = c4;
                cArr2[c] = 0;
                cArr4[c] = c2;
                this.length++;
                return c;
            }
        }
        char c6 = cArr[i];
        char c7 = this.sc[c];
        if (c6 < c7) {
            char[] cArr6 = this.lo;
            cArr6[c] = insert(cArr6[c], cArr, i, c2);
        } else if (c6 != c7) {
            char[] cArr7 = this.hi;
            cArr7[c] = insert(cArr7[c], cArr, i, c2);
        } else if (c6 != 0) {
            char[] cArr8 = this.eq;
            cArr8[c] = insert(cArr8[c], cArr, i + 1, c2);
        } else {
            this.eq[c] = c2;
        }
        return c;
    }
}
