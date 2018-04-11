package cn.luguangyi.javax.design.create;

/**
 * Created by luguangyi on 2018/4/11.
 *
 * 创建模式：建造者模式
 *
 * 四类角色：
 *      1. 指挥者：Director
 *      2. 抽象建造者：Builder
 *      3. 具体建造者：ConcreteBuilder
 *      4. 具体产品：ProductA、ProductB、ProductC
 *
 * 优点：创建流程及逻辑比较清晰。
 * 缺点：暂无。
 *
 * 适用场景：更加复杂的创建流程。
 *
 * 设计原则：较符合六大设计原则。
 *
 * java 示例：java.lang.StringBuilder
 *
 */
public class BuilderMode {

    public static void main(String[] args) {
        Director director = new Director();
        director.create(new ConcreteBuilder());
    }

    // ------------------------- 辅助类 -------------------------

    static class Director {
        public void create(Builder builder) {
            builder.initProductA();
            builder.initProductB();
            builder.initProductC();
        }
    }

    interface Builder {
        void initProductA();
        void initProductB();
        void initProductC();
    }

    static class ConcreteBuilder implements Builder {

        @Override
        public void initProductA() {
            System.out.println("here is init productA");
        }

        @Override
        public void initProductB() {
            System.out.println("here is init productB");
        }

        @Override
        public void initProductC() {
            System.out.println("here is init productC");
        }
    }

    interface Product {}
    static class ProductA implements Product {}
    static class ProductB implements Product {}
    static class ProductC implements Product {}

}
