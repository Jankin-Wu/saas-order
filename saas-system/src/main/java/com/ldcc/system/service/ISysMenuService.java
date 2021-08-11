package com.ldcc.system.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @author wwg
 * @version jdk1.8
 * @description 菜单业务层
 * @create 2021-08-04 09:32
 **/

@FeignClient(name = "saas-order", url = "http://localhost:8081/system/menu")
public interface ISysMenuService {

    @GetMapping("/selectMenuPermsByUserId")
    Collection<String> selectMenuPermsByUserId(String userId);
}
