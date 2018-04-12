package cn.luguangyi.javax.design.behavior;

/**
 * Created by luguangyi on 2018/4/12.
 *
 * 行为模式：策略模式
 *
 * 三类角色：
 *      1. 封装类：Context
 *      2. 策略接口：Strategy
 *      3. 具体策略：ConcreteStrategyA、ConcreteStrategyB
 *
 * 优点：策略模式提供了对“开闭原则”的完美支持；
 *      避免了重复的 if-else 判断。
 * 缺点：客户端必须知道所有的策略类，并自行决定使用哪一个策略类；
 *      将产生很多的策略类，可使用享元模式来避免产生过多的类。
 *
 * 适用场景：完成一项任务，往往可以有多种不同的方式；
 *          可以由客户端来控制选择不同的策略。
 *
 * 设计原则：符合六大设计原则。
 *
 * java 示例：Arrays.sort() 中的 comparator 参数。
 *
 */
public class StrategyMode {

    public static void main(String[] args) {
//        Strategy strategy = new ConcreteStrategyA();
        Strategy strategy = new ConcreteStrategyB();
        Context context = new Context(strategy);
        context.want();
    }


    // ------------------------- 辅助类 -------------------------
    interface Strategy {
        void doing();
    }

    static class ConcreteStrategyA implements Strategy {

        @Override
        public void doing() {
            System.out.println("I am ConcreteStrategyA.");
        }
    }

    static class ConcreteStrategyB implements Strategy {

        @Override
        public void doing() {
            System.out.println("I am ConcreteStrategyB.");
        }
    }

    static class Context {
        private Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public void want() {
            strategy.doing();
        }
    }
}
