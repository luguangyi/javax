package cn.luguangyi.javax.design.create;

/**
 * Created by luguangyi on 2018/4/10.
 *
 * 创建模式：简单工厂
 *
 * 三种角色：
 *      1. 工厂：SimpleFactory
 *      2. 抽象产品：Product
 *      3. 具体产品：ConcreteProduct
 *
 * 优点：实现、使用上都比较简单；将创建对象与使用对象分离开来。
 * 缺点：可扩展性差，若增加 ConcreteProduct 则需要修改相应的创建逻辑；
 *      一旦 createProduct 出现问题，将影响整个系统。
 *
 * 适用场景：
 *      1. 负责创建的对象较少，且创建逻辑简单；
 *      2. 客户端不关心如何创建细节，甚至连类名都不关心。
 *
 * 设计原则：不符合开闭原则，即对扩展开发，对修改关闭；
 *         不符合迪米特法则，处于高耦合状态。
 *
 * java 示例：Cipher.getInstance(String s)
 *
 */
public class SimpleFactory {

    public static void main(String[] args) {
        System.out.println(SimpleFactory.createProduct("A"));
        System.out.println(SimpleFactory.createProduct("B"));
        System.out.println(SimpleFactory.createProduct("C"));
        System.out.println(SimpleFactory.createProduct(null));
    }

    public static Product createProduct(String productName) {
        Product product;
        if ("A".equals(productName)) { // 不利于拓展；当需创建新类型产品时，则需要修改代码逻辑。
            product = new ConcreteProductA(); // 耦合性高；new 出现次数越多，耦合性越强，应当尽量避免。

        } else if ("B".equals(productName)) {
            product = new ConcreteProductB(); // 同上

        } else {
            product = null;
        }
        return product;
    }

    // ------------------------- 辅助类 -------------------------
    interface Product {}

    static class ConcreteProductA implements Product {}

    static class ConcreteProductB implements Product {}
}