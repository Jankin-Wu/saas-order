package com.ldcc.api.controller;

import com.ldcc.common.constant.UserConstants;
import com.ldcc.common.controller.BaseController;
import com.ldcc.common.domain.entity.system.SysRole;
import com.ldcc.common.domain.entity.system.SysUser;
import com.ldcc.common.domain.model.AjaxResult;
import com.ldcc.common.page.TableDataInfo;
import com.ldcc.common.utils.SecurityUtils;
import com.ldcc.common.utils.StringUtils;
import com.ldcc.system.dto.UserParam;
import com.ldcc.system.service.ISysRoleService;
import com.ldcc.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：wwg
 * @description ：用户控制层
 * @date ：2021/8/5 2:00
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/system/user")
public class SysUserController extends BaseController {
    @Autowired
    private ISysUserService userService;


    /**
     * 获取用户列表
     */
    @ApiOperation("用户列表")
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userParam", value = "用户信息", dataType = "com.ldcc.system.dto.UserParam", paramType = "query")
    })
    public TableDataInfo list(UserParam userParam)
    {
        System.out.println(userService.selectUserList(userParam));
        return userService.selectUserList(userParam);
    }

}
