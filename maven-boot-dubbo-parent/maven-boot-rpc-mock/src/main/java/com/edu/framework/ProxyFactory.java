package com.edu.framework;

import com.edu.framework.protocol.http.HttpClient;
import com.edu.framework.register.RemoteRegister;
import com.edu.provider.api.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory {
    //生成代理对象----代码写活了
    public static <T> T getProxy(Class interfaceClass) {
        /*
        * classLoader ---->就获取一个加载器  ProxyFactory.class.getClassLoader()
        * 代理的接口 new Class[]{interfaceClass}
        * new InvocationHandler
        */
        Object proxyInstance = Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(),
                new Class[]{interfaceClass}, new InvocationHandler() {
                    /**
                     *
                     * @param proxy
                     * @param method  当前要代理的方法---可以获取方法名，参数类型
                     * @param args    你所传的参数
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(),
                                method.getParameterTypes(), args);
                        HttpClient httpClient = new HttpClient();
                        List<URL> urls = RemoteRegister.get(interfaceClass.getName());
                        //负载均衡策略
                        URL url = LoadBalance.random(urls);
                        String res = httpClient.send(url.getHostname(), url.getPort(), invocation);
                        return res;
                    }
                });
        return (T) proxyInstance;
    }
}
