package senntyou.sbs.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import senntyou.sbs.admin.dto.AdminMenuNode;
import senntyou.sbs.admin.service.AdminMenuService;
import senntyou.sbs.common.CommonPage;
import senntyou.sbs.common.CommonResult;
import senntyou.sbs.mbg.model.AdminMenu;

/** 后台菜单管理Controller Created by macro on 2020/2/4. */
@Controller
@Api(tags = "AdminMenuController", description = "后台菜单管理")
@RequestMapping("/menu")
public class MenuController {

  @Autowired private AdminMenuService menuService;

  @ApiOperation("添加后台菜单")
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult create(@RequestBody AdminMenu umsMenu) {
    int count = menuService.create(umsMenu);
    if (count > 0) {
      return CommonResult.success(count);
    } else {
      return CommonResult.failed();
    }
  }

  @ApiOperation("修改后台菜单")
  @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult update(@PathVariable Long id, @RequestBody AdminMenu umsMenu) {
    int count = menuService.update(id, umsMenu);
    if (count > 0) {
      return CommonResult.success(count);
    } else {
      return CommonResult.failed();
    }
  }

  @ApiOperation("根据ID获取菜单详情")
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<AdminMenu> getItem(@PathVariable Long id) {
    AdminMenu umsMenu = menuService.getItem(id);
    return CommonResult.success(umsMenu);
  }

  @ApiOperation("根据ID删除后台菜单")
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult delete(@PathVariable Long id) {
    int count = menuService.delete(id);
    if (count > 0) {
      return CommonResult.success(count);
    } else {
      return CommonResult.failed();
    }
  }

  @ApiOperation("分页查询后台菜单")
  @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<CommonPage<AdminMenu>> list(
      @PathVariable Long parentId,
      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
    List<AdminMenu> menuList = menuService.list(parentId, pageSize, pageNum);
    return CommonResult.success(CommonPage.toPage(menuList));
  }

  @ApiOperation("树形结构返回所有菜单列表")
  @RequestMapping(value = "/treeList", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<List<AdminMenuNode>> treeList() {
    List<AdminMenuNode> list = menuService.treeList();
    return CommonResult.success(list);
  }

  @ApiOperation("修改菜单显示状态")
  @RequestMapping(value = "/updateHidden/{id}", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult updateHidden(@PathVariable Long id, @RequestParam("hidden") Integer hidden) {
    int count = menuService.updateHidden(id, hidden);
    if (count > 0) {
      return CommonResult.success(count);
    } else {
      return CommonResult.failed();
    }
  }
}
