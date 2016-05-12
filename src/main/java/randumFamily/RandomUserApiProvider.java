package randumFamily;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

public class RandomUserApiProvider {
  private static final String BASE_URL = "http://api.randomuser.me/";

  public static RandomUserApi get() {
    return new Retrofit.Builder()
        .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(RandomUserApi.class);
  }
}
