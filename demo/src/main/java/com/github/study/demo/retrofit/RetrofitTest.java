package com.github.study.demo.retrofit;

import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import okio.ByteString;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

import javax.annotation.Nullable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * CreatedDate: 2020/9/30
 * Author: songjialin
 */
public class RetrofitTest {
    public static void main(String[] args) {
        Retrofit build = new Retrofit.Builder()
                .addConverterFactory(new Converter.Factory() {
                    @Nullable
                    @Override
                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                        return new Converter<ResponseBody, Object>() {
                            @Nullable
                            @Override
                            public Object convert(ResponseBody value) throws IOException {
                                return ByteString.of(value.bytes()).string(StandardCharsets.UTF_8);
                            }
                        };
                    }
                })
                .addCallAdapterFactory(new CallAdapter.Factory() {
                    @Nullable
                    @Override
                    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
                        if (returnType != Class.class) {
                            return new CallAdapter<Object, Object>() {
                                @Override
                                public Type responseType() {
                                    return String.class;
                                }

                                @SneakyThrows
                                @Override
                                public Object adapt(Call<Object> call) {
                                    Response<Object> execute = call.execute();
                                    return execute.body();
                                }
                            };
                        }
                        return null;
                    }
                })
                .baseUrl("http://www.baidu.com/")
                .build();

        Test test = build.create(Test.class);
        System.out.println(test.main());
    }
}
