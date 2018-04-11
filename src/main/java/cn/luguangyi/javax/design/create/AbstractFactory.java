package cn.luguangyi.javax.design.create;

/**
 * Created by luguangyi on 2018/4/11.
 *
 * 创建模式：抽象工厂
 *
 * 四类角色：
 *
 * 优点：属于工厂方法的升级版，即将工厂抽象化。
 * 缺点：
 *
 * 适用场景：当需要创建一系列的产品时，例如需要创建 发动机、车轮、座椅等。
 *
 * 设计原则：符合六大设计原则。
 *
 * java 示例：
 *
 */
public class AbstractFactory {

    public static void main(String[] args) {
        Factory factory = new ConcreteFactory();
        System.out.println(factory.createProductA());
        System.out.println(factory.createProductB());
    }

    // ------------------------- 辅助类 -------------------------
    interface Product {}

    static class ProductA implements Product {}

    static class ProductB implements Product {}

    interface Factory {
        ProductA createProductA();
        ProductB createProductB();
    }

    static class ConcreteFactory implements Factory {

        @Override
        public ProductA createProductA() {
            return new ProductA();
        }

        @Override
        public ProductB createProductB() {
            return new ProductB();
        }
    }

}
