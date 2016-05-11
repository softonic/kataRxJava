import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample01 {
  public static void main(String... args) throws InterruptedException {
    Observable<Collection<Integer>> observable = Observable.fromCallable((Callable<List<Integer>>) () -> {
      System.out.println("call: " + Thread.currentThread().getName());
      return IntStream
          .range(0, 50)
          .boxed()
          .collect(Collectors.toList());
    });

    observable
        .subscribeOn(Schedulers.computation())
        .observeOn(Schedulers.io())
        .subscribe(new Subscriber<Collection<Integer>>() {
          @Override
          public void onCompleted() {
            System.out.println("onCompleted: " + Thread.currentThread().getName());
          }

          @Override
          public void onError(Throwable throwable) {
            System.out.println("onError: " + Thread.currentThread().getName());
            System.out.println("onError");
          }

          @Override
          public void onNext(Collection<Integer> value) {
            System.out.println("onNext: " + Thread.currentThread().getName());
            System.out.println("onNext: " + value + " " + Thread.currentThread().getName());
          }
        });

    Thread.sleep(1000);
  }
}
