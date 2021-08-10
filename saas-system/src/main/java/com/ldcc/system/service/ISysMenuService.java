package com.ldcc.system.service;

import com.ldcc.common.domain.entity.system.SysMenu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;

/**
 * @author wwg
 * @version jdk1.8
 * @description 菜单业务层
 * @create 2021-08-04 09:32
 **/

@FeignClient(name = "baseSapi", url = "http://localhost:8081")
public interface ISysMenuService {
    SysMenu selectMenuById(String menuId);

    @GetMapping("/list/{userId}")
    List<SysMenu> selectMenuList(SysMenu menu, @PathVariable("userId") String userId);

    @GetMapping("/selectMenuPermsByUserId")
    Collection<String> selectMenuPermsByUserId(String userId);

    String checkMenuNameUnique(SysMenu menu);

    int insertMenu(SysMenu menu);

    boolean hasChildByMenuId(String menuId);

    boolean checkMenuExistRole(String menuId);

    int deleteMenuById(String menuId);

    int updateMenu(SysMenu menu);
}
