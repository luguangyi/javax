package cn.luguangyi.javax.design.behavior;


/**
 * Created by luguangyi on 2018/4/17.
 *
 * 行为模式：中介者模式
 *
 * 适用场景：降低多个对象和类之间的通信复杂性。
 *
 * 三类角色：
 *      1. 中介者：Mediator
 *      2. 租房者：RentIner
 *      3. 出租者：RentOutor
 *
 * 优点：1. 降低了类的复杂度，将一对多转化成了一对一；
 *      2. 各个类之间的解耦；
 *      3. 符合迪米特原则。
 * 缺点：中介者会庞大，变得复杂难以维护。
 *
 * 设计原则：符合六大设计原则。
 *
 * java 示例：
 *
 */
public class MediatorPattern {

    public static void main(String[] args) {
        RentOutor rentOutor = new RentOutor();
        RentIner rentIner = new RentIner();
        Mediator.rentIn(rentIner);
        Mediator.rentOut(rentOutor);
        Mediator.trade(rentOutor, rentIner);
    }

    // ------------------------- 辅助类 -------------------------
    static class Mediator {
        public static void rentIn(RentIner rentIner) {
            System.out.println("the rentor want a house. ==> " + rentIner);
        }

        public static void rentOut(RentOutor rentOutor) {
            System.out.println("the rentor out a house. ==> " + rentOutor);
        }

        public static void trade(RentOutor rentOutor, RentIner rentIner) {
            System.out.println("trade a house. ==> " + rentOutor + " ==> " + rentIner);
        }
    }

    static class RentIner {}

    static class RentOutor {}
}
