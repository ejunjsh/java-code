package com.sky.code.oom;

/**
 * JDK 1.6 VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class JavaMethodAreaOOM{
    public static void main(String[] args)
    {
        while(true){
            Enhancer enhancer=new Enhancer();

            enhancer.setSuperclass(OOMOjbect.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor(){
                public Object intercept(Object obj,Method method,Object[] args,MethodProxy proxy) throws Throwable{
                    return proxy.invokeSuper(obj,args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMOjbect{

    }
}