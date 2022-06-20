package com.edu.timeout;

import com.edu.service.SiteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("timeout")
@ResponseBody
public class TimeOutTestController {
    //version: 是当服务接口提供者有多个以上我们可以指定固定版本名
    //interfaceName: 当服务接口提供者实现了多个，会生成多个SiteService类型的代理对象，指定具体的代理对象
    //timeout: 服务超时，如果在提供者或者消费者端配置一个，默认都是配置一样的超时时间，
    //         代表的是消费着调用你的接口只需6秒，6秒内你给我响应，不响应我就报错
    //mock: 做服务降级用的 可以返回抛出的异常类，可以是字符串 可以是接口的拖低数据
    //------ mock参考这个博客：https://blog.csdn.net/cnm10050/article/details/109709478
    //loadbalance: 代表负载均衡的策略：随机，轮询，权重，最少活跃调用，一致性hash
    //最少活跃调用：dubbo的服务消费者，都会在消费端的缓存记录每个服务提供者的活跃数 用active,如果发送一次请求，active+1,响应回来 active-1
    //----------根据这个过程推算可知，active越高你的响应越慢，所以叫最少活跃调用
    //一致性hash: 什么是一致性hash，一致性hash应用与redis,dubbo，我们在一个hash环上有16384个hash槽，
    //---------- 服务提供者的IP有三个，对ip进行hash运算得到三个hash槽,这三个hash就在hash环上，每当来一个请求，
    //---------- redis对key做运算，dubbo对ip运算,得到的hash值%16384得到0~16383个中的一个值，这个hash槽到那个ip近就去访问那个
    //---------- 当然服务提供者的三个iphash也是随机的如何保证均匀的分再hash环上，可以采用虚拟结点，将三个hash映射出多个虚拟ip,分散在环上
    //---------- 这样就能够相对平等分布
    @Reference(version = "timeout",
            interfaceName = "timeOutSiteServiceImpl",
            timeout = 1000,
            mock = "fail:return HaHa")
    private SiteService siteService;

    //http://localhost:8080/timeout/out/guihaole
    @GetMapping("/out/{name}")
    public String timeOutVersion(@PathVariable("name") String name) {
        return siteService.getSiteById(name);
    }
}
