package defpackage;

import android.util.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: Ah, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0340Ah {
    public List a;

    /* JADX INFO: renamed from: Ah$a */
    public class a implements Comparator {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i;
            int i2;
            int i3 = this.a;
            if (i3 == 2) {
                int iCompareTo = c4145vh2.n().compareTo(String.valueOf(c4145vh.n()));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                i = Integer.parseInt(c4145vh2.v());
                i2 = Integer.parseInt(c4145vh.v());
            } else if (i3 == 3) {
                int iCompareTo2 = c4145vh2.o().compareTo(String.valueOf(c4145vh.o()));
                if (iCompareTo2 != 0) {
                    return iCompareTo2;
                }
                i = Integer.parseInt(c4145vh2.v());
                i2 = Integer.parseInt(c4145vh.v());
            } else if (i3 == 6) {
                int iCompareTo3 = c4145vh2.r().compareTo(String.valueOf(c4145vh.r()));
                if (iCompareTo3 != 0) {
                    return iCompareTo3;
                }
                i = Integer.parseInt(c4145vh2.v());
                i2 = Integer.parseInt(c4145vh.v());
            } else {
                int iCompareTo4 = c4145vh2.p().compareTo(String.valueOf(c4145vh.p()));
                if (iCompareTo4 != 0) {
                    return iCompareTo4;
                }
                i = Integer.parseInt(c4145vh2.v());
                i2 = Integer.parseInt(c4145vh.v());
            }
            return i - i2;
        }
    }

    /* JADX INFO: renamed from: Ah$b */
    public class b implements Comparator {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            int i = this.a;
            if (i == 2) {
                try {
                    iCompareTo = simpleDateFormat.parse(c4145vh.n()).compareTo(simpleDateFormat.parse(c4145vh2.n()));
                } catch (ParseException unused) {
                    iCompareTo = 0;
                }
            } else if (i == 3) {
                iCompareTo = c4145vh2.o().compareTo(String.valueOf(c4145vh.o()));
            } else if (i == 5) {
                iCompareTo = c4145vh2.q().compareTo(String.valueOf(c4145vh.q()));
            } else if (i == 6) {
                iCompareTo = c4145vh2.r().compareTo(String.valueOf(c4145vh.r()));
            } else {
                iCompareTo = c4145vh2.p().compareTo(String.valueOf(c4145vh.p()));
                if (iCompareTo == 0) {
                    iCompareTo = Integer.parseInt(c4145vh2.v()) - Integer.parseInt(c4145vh.v());
                }
            }
            return iCompareTo == 0 ? Integer.parseInt(c4145vh2.v()) - Integer.parseInt(c4145vh.v()) : iCompareTo;
        }
    }

    /* JADX INFO: renamed from: Ah$c */
    public class c implements Comparator {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i;
            int i2;
            int i3 = this.a;
            if (i3 == 2) {
                int iCompareTo = c4145vh.n().compareTo(String.valueOf(c4145vh2.n()));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                i = Integer.parseInt(c4145vh.v());
                i2 = Integer.parseInt(c4145vh2.v());
            } else if (i3 == 3) {
                int iCompareTo2 = c4145vh.o().compareTo(String.valueOf(c4145vh2.o()));
                if (iCompareTo2 != 0) {
                    return iCompareTo2;
                }
                i = Integer.parseInt(c4145vh.v());
                i2 = Integer.parseInt(c4145vh2.v());
            } else if (i3 == 6) {
                int iCompareTo3 = c4145vh.r().compareTo(String.valueOf(c4145vh2.r()));
                if (iCompareTo3 != 0) {
                    return iCompareTo3;
                }
                i = Integer.parseInt(c4145vh.v());
                i2 = Integer.parseInt(c4145vh2.v());
            } else {
                int iCompareTo4 = c4145vh.p().compareTo(String.valueOf(c4145vh2.p()));
                if (iCompareTo4 != 0) {
                    return iCompareTo4;
                }
                i = Integer.parseInt(c4145vh.v());
                i2 = Integer.parseInt(c4145vh2.v());
            }
            return i - i2;
        }
    }

    /* JADX INFO: renamed from: Ah$d */
    public class d implements Comparator {
        public final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int iCompareTo;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            int i = this.a;
            if (i == 2) {
                try {
                    iCompareTo = simpleDateFormat.parse(c4145vh2.n()).compareTo(simpleDateFormat.parse(c4145vh.n()));
                } catch (ParseException unused) {
                    iCompareTo = 0;
                }
            } else if (i == 3) {
                iCompareTo = c4145vh.o().compareTo(String.valueOf(c4145vh2.o()));
            } else if (i == 5) {
                iCompareTo = c4145vh.q().compareTo(String.valueOf(c4145vh2.q()));
            } else if (i == 6) {
                iCompareTo = c4145vh.r().compareTo(String.valueOf(c4145vh2.o()));
            } else {
                iCompareTo = c4145vh2.p().compareTo(String.valueOf(c4145vh.p()));
                if (iCompareTo == 0) {
                    iCompareTo = Integer.parseInt(c4145vh2.v()) - Integer.parseInt(c4145vh.v());
                }
            }
            return iCompareTo == 0 ? Integer.parseInt(c4145vh2.v()) - Integer.parseInt(c4145vh.v()) : iCompareTo;
        }
    }

    /* JADX INFO: renamed from: Ah$e */
    public class e implements Comparator {
        public int a;

        public e(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i = this.a;
            if (i == 1) {
                return Double.valueOf(c4145vh.a().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.a().replaceAll(",", "")));
            }
            return i == 3 ? Double.valueOf(c4145vh.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.o().replaceAll(",", ""))) : Double.valueOf(c4145vh.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh2.q().replaceAll(",", "")));
        }
    }

    /* JADX INFO: renamed from: Ah$f */
    public class f implements Comparator {
        public int a;

        public f(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4145vh c4145vh, C4145vh c4145vh2) {
            int i = this.a;
            if (i == 1) {
                return Double.valueOf(c4145vh2.a().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.a().replaceAll(",", "")));
            }
            return i == 3 ? Double.valueOf(c4145vh2.o().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.o().replaceAll(",", ""))) : Double.valueOf(c4145vh2.q().replaceAll(",", "")).compareTo(Double.valueOf(c4145vh.q().replaceAll(",", "")));
        }
    }

    public final void a(List list, int i) {
        Collections.sort(list, Collections.reverseOrder(new c(i)));
    }

    public final void b(List list, int i) {
        Collections.sort(list, Collections.reverseOrder(new d(i)));
    }

    public final void c(int i) {
        Collections.sort(this.a, new f(i));
    }

    public final void d(int i) {
        Collections.sort(this.a, new e(i));
    }

    public final void e(List list, int i) {
        Collections.sort(list, Collections.reverseOrder(new a(i)));
    }

    public final void f(List list, int i) {
        Collections.sort(list, Collections.reverseOrder(new b(i)));
    }

    public List g(List list, int i, int i2) {
        Log.d("trace_2Sort=", "Start:" + i + ":" + i2);
        this.a = list;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            if (i2 == 0) {
                                d(5);
                            } else {
                                c(5);
                            }
                        }
                    } else if (i2 == 0) {
                        e(list, 4);
                    } else {
                        a(list, 4);
                    }
                } else if (i2 == 0) {
                    e(list, 3);
                } else {
                    a(list, 3);
                }
            } else if (i2 == 0) {
                e(list, 2);
            } else {
                a(list, 2);
            }
        } else if (i2 == 0) {
            d(1);
        } else {
            c(1);
        }
        Log.d("trace_2Sort=", "End:" + i + ":" + i2);
        this.a.size();
        return this.a;
    }

    public List h(List list, int i, int i2) {
        Log.d("trace_2Sort=", "Start:" + i + ":" + i2);
        this.a = list;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            if (i2 == 0) {
                                f(list, 4);
                            } else {
                                b(list, 4);
                            }
                        }
                    } else if (i2 == 0) {
                        f(list, 4);
                    } else {
                        b(list, 4);
                    }
                } else if (i2 == 0) {
                    f(list, 3);
                } else {
                    b(list, 3);
                }
            } else if (i2 == 0) {
                f(list, 2);
            } else {
                b(list, 2);
            }
        } else if (i2 == 0) {
            d(1);
        } else {
            c(1);
        }
        Log.d("trace_2Sort=", "End:" + i + ":" + i2);
        this.a.size();
        return this.a;
    }
}
