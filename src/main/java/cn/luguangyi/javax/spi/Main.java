package cn.luguangyi.javax.spi;

import cn.luguangyi.javax.spi.support.Student;
import cn.luguangyi.javax.spi.support.Worker;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        // 正常调用
        Operator operatorStudent = new Student();
        Operator operatorWorker = new Worker();
        operatorStudent.doing("hello world.");
        operatorWorker.doing("hello world.");

        // SPI 调用
        ServiceLoader<Operator> operations = ServiceLoader.load(Operator.class);
        Iterator<Operator> operationIterator = operations.iterator();
        System.out.println("classPath: " + System.getProperty("java.class.path"));
        while (operationIterator.hasNext()) {
            Operator operation = operationIterator.next();
            operation.doing("hello wrold.");
        }
    }
}
