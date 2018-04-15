package cn.luguangyi.javax.design.behavior;

/**
 * Created by luguangyi on 2018/4/15.
 *
 * 行为模式：状态模式
 *
 * 适用场景：允许一个对象在其内部状态改变时改变它的行为。
 *
 * 三类角色：
 *      1. 上下文对象：Context
 *      2. 抽象状态接口：State
 *      3. 具体状态对象：ConcreteStateA, ConcreteStateB...
 *
 * 优点：暂无
 * 缺点：暂无
 *
 * 设计原则：符合六大设计原则。
 *
 * java 示例：
 *
 */
public class StatePattern {

    public static void main(String[] args) {
        Context context = new Context(new ConcreteStateA());
        context.request();
        context.setState(new ConcreteStateB());
        context.request();

    }

    // ------------------------- 辅助类 -------------------------

    static class Context {

        public Context(State state) {
            this.state = state;
        }

        private State state;

        public void setState(State state) {
            this.state = state;
        }

        public void request() {
            state.handle();
        }
    }

    interface State {
        void handle();
    }

    static class ConcreteStateA implements State {

        @Override
        public void handle() {
            System.out.println("here is in ConcreteStateA.");
        }
    }

    static class ConcreteStateB implements State {

        @Override
        public void handle() {
            System.out.println("here is in ConcreteStateB.");
        }
    }

}
