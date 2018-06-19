package cn.luguangyi.javax.jvm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 用于jvm参数调优测试
 */
public class JVMTest {
    private static final int MB = 1 * 1024 * 1024;

    /**
     * jstat -gc 41529 2000 1000000
     */
    public static void main(String[] args) {
//        byte[] b1, b2, b3, b4;
//        b1 = new byte[2 * MB];
//        b2 = new byte[2 * MB];
//        b3 = new byte[2 * MB];
//        b4 = new byte[4 * MB];
        List<Obj> objs = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            Obj obj = new Obj();
            obj.i = i;
            objs.add(obj);
        }

        objs.sort(Comparator.comparingInt(Obj::getI));
        System.out.println(objs);
    }

    static class Obj {
        int i;

        public int getI() {
            return i;
        }
    }
}
