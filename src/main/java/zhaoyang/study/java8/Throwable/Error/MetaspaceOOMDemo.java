package zhaoyang.study.java8.Throwable.Error;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhaoyang
 * @Date 2020/7/8 - 14:34
 *
 * 模拟元空间溢出：
 *   JVM参数: -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 *  不断生成类往元空间加载
 *  使用Spring的动态字节码技术循环创建代理类，由于内部类是静态的，所以一直加载
 */
public class MetaspaceOOMDemo {
    static class OOMTest{}

    public static void main(String[] args) {
        int i = 0;  //计数器

        try {
            while (true){
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        }catch (Throwable t){
            System.out.println(i + "次后元空间溢出");
            t.printStackTrace();
        }
    }
}
