package part2.chapter2;

import java.lang.reflect.Method;

/**
 * VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M
 * Enhancer是 CGLib 的,这里就没运行了,
 * 大概思路是利用动态创建大量代理类填满方法区,产生OOM
 * @author zzm
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
//            enhancer.setCallback(new MethodInterceptor() {
//                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//                    return proxy.invokeSuper(obj, args);
//                }
//            });
            enhancer.create();
        }
    }

    static class OOMObject {
    }

    private static class Enhancer {
        public void setSuperclass(Class<OOMObject> oomObjectClass) {
        }

        public void setUseCache(boolean b) {
        }

        public void create() {

        }
    }
}