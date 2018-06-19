package cn.luguangyi.javax.rx;

import io.reactivex.Flowable;

public class ReactivexTest {
    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);
    }
}
