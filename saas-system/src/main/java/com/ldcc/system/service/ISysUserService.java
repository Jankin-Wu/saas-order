package com.ldcc.system.service;

import com.ldcc.common.domain.entity.system.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "baseSapi", url = "http://localhost:8081")
public interface ISysUserService {
    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @GetMapping("/system/user/list")
    public List<SysUser> selectUserList(SysUser user);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @PostMapping("/checkUserNameUnique")
    public SysUser selectUserByUserName(String userName);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    @GetMapping("/{userId}")
    public SysUser selectUserById(@PathVariable(value = "userId", required = false) String userId);

    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    @PostMapping("/checkUserNameUnique")
    public String checkUserNameUnique(String userName);


    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    @PostMapping("/checkEmailUnique")
    public String checkPhoneUnique(SysUser user);

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    @PostMapping("/checkEmailUnique")
    public String checkEmailUnique(SysUser user);

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @PostMapping("/add")
    public int insertUser(SysUser user);

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @PutMapping("/update")
    public int updateUser(SysUser user);


    /**
     * 修改用户基本信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @PutMapping("/update")
    public int updateUserProfile(SysUser user);


    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
    @DeleteMapping("/delete/{userId}")
    public int deleteUserById(@PathVariable(value = "userId", required = false)String userId);

}
