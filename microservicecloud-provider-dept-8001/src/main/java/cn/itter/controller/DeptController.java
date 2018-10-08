package cn.itter.controller;

import cn.itter.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: TODO
 * @Author: Mario.Song
 * @Date: Create in 2018/10/8 15:37
 */
@RestController
public class DeptController {
    @Autowired
    private DiscoveryClient client;
    @Value("${server.port}")
    private String SERVER_PORT;

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list()
    {
        Dept d1 = new Dept();
        d1.setDeptno(1L);
        d1.setDname("市场部");
        d1.setDb_source(SERVER_PORT);
        Dept d2 = new Dept();
        d2.setDeptno(2L);
        d2.setDname("研发部");
        d2.setDb_source(SERVER_PORT);
        return Arrays.asList(d1,d2);
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }
}
