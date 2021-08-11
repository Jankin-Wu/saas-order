package com.ldcc.system.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/**
 * @author ：wwg
 * @description ：角色业务层
 * @date ：2021/8/1 17:16
 */
@FeignClient(name = "saas-order", url = "http://localhost:8081/system/role")
public interface ISysRoleService {

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    @GetMapping("/selectRolePermissionByUserId/{userId}")
    public Set<String> selectRolePermissionByUserId(@PathVariable("userId") String userId);
}
