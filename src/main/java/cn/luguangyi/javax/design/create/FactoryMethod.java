package cn.luguangyi.javax.design.create;

/**
 * Created by luguangyi on 2018/4/11.
 *
 * 创建模式：工厂方法
 *
 * 四类角色：
 *      1. 抽象产品：Product
 *      2. 具体产品：ProductA
 *      3. 抽象工厂：Factory
 *      4. 具体工厂：ProductAFactory
 *
 * 优点：客户端仅需关心创建的工厂，并不关心创建细节；
 *      进一步抽象出 Product 和 Factory；
 *      符合开闭原则。
 * 缺点：引入新的产品是需要创建对应的 Factory。
 *
 * 适用场景：创建对象
 *
 * 设计原则：基本符合六大设计原则；
 *          弥补了简单工厂在开闭原则方面的不足。
 *
 * java 示例：java.util.concurrent.ThreadFactory
 *
 */
public class FactoryMethod {

    public static void main(String[] args) {
        Factory factory = new ProductAFactory();
        System.out.println(factory.createProduct());
    }

    // ------------------------- 辅助类 -------------------------
    interface Product {}

    interface Factory {
        Product createProduct();
    }

    static class ProductAFactory implements Factory {

        @Override
        public Product createProduct() {
            return new ProductA();
        }
    }

    static class ProductA implements Product {}
}