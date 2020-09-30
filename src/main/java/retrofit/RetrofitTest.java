package retrofit;

import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import retrofit2.*;

import javax.annotation.Nullable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

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
                                return value.string();
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
                                    return Response.success(call.execute());
                                }
                            };
                        }
                        return null;
                    }
                })
                .baseUrl("http://www.baidu.com/")
                .build();

        Test test = build.create(Test.class);
        Response<String> main = test.main();
        System.out.println(main.body());
    }
}
