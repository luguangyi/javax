package cn.luguangyi.javax.design.behavior;

/**
 * Created by luguangyi on 2018/4/16.
 *
 * 行为模式：命令模式
 *
 * 适用场景：发送命令与接收命令的情况下可使用
 *
 * 四类角色：
 *      1. 命令接受者：Recevicer
 *      2. 抽象命令：Command
 *      3. 具体命令：ConcreteCommandA
 *      4. 命令请求者：Invoker
 *
 * 优点：发送者和接收者完全解耦
 * 缺点：暂无
 *
 * 设计原则：符合六大设计原则。
 *
 * java 示例：
 *
 */
public class CommandPattern {

    public static void main(String[] args) {
        Recevicer recevicer = new Recevicer();
        Command command = new ConcreteCommandA(recevicer);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }

    // ------------------------- 辅助类 -------------------------
    /**
     * 命令实际执行者
     */
    static class Recevicer {

        public void action() {
            System.out.println("here is action method in Recevicer.");
        }

    }

    /**
     * 抽象命令
     */
    interface Command {
        void execute();
    }

    /**
     * 具体命令
     */
    static class ConcreteCommandA implements Command {
        private Recevicer recevicer;

        public ConcreteCommandA(Recevicer recevicer) {
            this.recevicer = recevicer;
        }

        @Override
        public void execute() {
            recevicer.action();
        }
    }

    /**
     * 请求者
     */
    static class Invoker {
        private Command command;

        public Invoker(Command command) {
            this.command = command;
        }

        public void action() {
            command.execute();
        }
    }

}
