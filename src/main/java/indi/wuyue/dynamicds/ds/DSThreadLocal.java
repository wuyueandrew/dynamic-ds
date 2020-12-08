package indi.wuyue.dynamicds.ds;

import java.util.LinkedList;

public class DSThreadLocal {

    private final static ThreadLocal<LinkedList<String>> DS_MASTER = ThreadLocal.withInitial(LinkedList::new);

    public static String getCur() {
        return DS_MASTER.get().peek();
    }

    public static void setCur(String ds) {
        DS_MASTER.get().push(ds);
    }

    public static void clearCur() {
        DS_MASTER.get().pop();
    }

}
