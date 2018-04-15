package cn.luguangyi.javax.design.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luguangyi on 2018/4/13.
 *
 * 行为模式：观察者模式
 *
 * 适用场景：存在一对多关系时，例如一个对象修改后自动通知它的依赖对象。
 *
 * 三类角色：
 *      1. 被观察对象：Subject
 *      2. 观测者接口：Observer
 *      3. 具体观测者：ConcreteObserverA、ConcreteObserverB
 *
 * 优点：暂无
 * 缺点：无法注销某个观察者
 *
 * 设计原则：符合六大设计原则。
 *
 * java 示例：java.util.Observable
 *
 */
public class ObserverPattern {

    public static void main(String[] args) {
        Subject subject = new Subject(10);
        new ConcreteObserverA(subject);
        new ConcreteObserverA(subject);
        new ConcreteObserverB(subject);
        subject.changeNum(20);
        subject.changeNum(21);
    }

    // ------------------------- 辅助类 -------------------------
    static abstract class Observer {
        private Subject subject;
        public abstract void doSomething();
    }

    static class ConcreteObserverA extends Observer {

        public ConcreteObserverA(Subject subject){
            super.subject = subject;
            super.subject.addObserver(this); // 此处不太好
        }

        @Override
        public void doSomething() {
            System.out.println("here is in ConcreteObserverA. ---> " + this);
        }
    }

    static class ConcreteObserverB extends Observer {

        public ConcreteObserverB(Subject subject){
            super.subject = subject;
            super.subject.addObserver(this);
        }

        @Override
        public void doSomething() {
            System.out.println("here is in ConcreteObserverB. ---> " + this);
        }
    }

    static class Subject {
        private int n;
        private List<Observer> observers;

        public Subject(int n) {
            this.n = n;
            this.observers = new ArrayList<>();
        }

        public void addObserver(Observer observer) {
            this.observers.add(observer);
        }

        public void changeNum(int n) {
            this.n = n;
            noticeAllObserver();
        }

        private void noticeAllObserver() {
            for(Observer observer : observers) {
                observer.doSomething();
            }
        }
    }
}
