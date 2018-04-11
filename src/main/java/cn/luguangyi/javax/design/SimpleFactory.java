package cn.luguangyi.javax.design;

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
 * 设计原则：不符合开闭原则，即对扩展开发，对修改关闭。
 *
 * java 示例：Cipher.getInstance(String s)
 *
 */
public class SimpleFactory {

    public static Product createProduct(String productName) {
        Product product;
        if ("A".equals(productName)) {
            product = new ConcreteProductA();

        } else if ("B".equals(productName)) {
            product = new ConcreteProductB();

        } else {
            product = null;
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println(SimpleFactory.createProduct("A"));
        System.out.println(SimpleFactory.createProduct("B"));
        System.out.println(SimpleFactory.createProduct("C"));
        System.out.println(SimpleFactory.createProduct(null));
    }
}


interface Product {}

class ConcreteProductA implements Product {}

class ConcreteProductB implements Product {}