package cn.luguangyi.javax.design.create;

/**
 * Created by luguangyi on 2018/4/11.
 *
 * 创建模式：单例模式
 *
 * 一类角色：
 *      1. 实例：Instance
 *      2. 工具类：Singleton
 *
 * 备注：可用 枚举 来实现单例，也是最有效的
 */
public class Singleton {

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
    }

    // ------------------------- 辅助类 -------------------------
    private static Instance INSTANCE;

    public synchronized static Instance getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Instance();
        }
        return INSTANCE;
    }

    static class Instance {}
}
