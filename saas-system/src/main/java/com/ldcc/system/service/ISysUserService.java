package com.ldcc.system.service;

import com.ldcc.common.domain.entity.system.SysUser;
import com.ldcc.common.page.TableDataInfo;
import com.ldcc.system.dto.UserParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "saas-order", url = "http://localhost:8081/system/user")
public interface ISysUserService {
    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @GetMapping("/selectUserByUserName")
    public SysUser selectUserByUserName(@RequestParam("userName") String userName);

    @GetMapping("/list")
    TableDataInfo selectUserList(@RequestParam("userParam") UserParam userParam);
}
