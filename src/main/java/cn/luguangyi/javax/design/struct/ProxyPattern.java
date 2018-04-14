package cn.luguangyi.javax.design.struct;

/**
 * Created by luguangyi on 2018/4/14.
 *
 * 结构模式：代理模式
 *
 * 三类角色：
 *      1. 抽象对象接口：Subject
 *      2. 实际对象：RealSubject
 *      3. 代理类：Proxy
 *
 * 优点：创建流程及逻辑比较清晰。
 * 缺点：暂无。
 *
 * 适用场景：为其他对象提供一种代理以控制对这个对象的访问，起到中介的作用。
 *
 * 设计原则：较符合六大设计原则。
 *
 * java 示例：
 *
 */
public class ProxyPattern {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Proxy proxy = new Proxy(subject);
        proxy.doSomething();
    }

    // ------------------------- 辅助类 -------------------------
    interface Subject {
        void doSomething();
    }

    static class RealSubject implements Subject {

        @Override
        public void doSomething() {
            System.out.println("do something in RealSubject.");
        }
    }

    static class Proxy implements Subject {
        private Subject subject;

        public Proxy(Subject subject) {
            this.subject = subject;
        }

        @Override
        public void doSomething() {
            before();
            subject.doSomething();
            after();
        }

        private void before() {
            System.out.println("here is before in Proxy.");
        }

        private void after() {
            System.out.println("here is after in Proxy.");
        }
    }
}
