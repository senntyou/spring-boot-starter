package senntyou.sbs.admin.service;

import java.util.List;
import senntyou.sbs.admin.dto.AdminMenuNode;
import senntyou.sbs.mbg.model.AdminMenu;

/** 后台菜单管理Service */
public interface AdminMenuService {
  /** 创建后台菜单 */
  int create(AdminMenu umsMenu);

  /** 修改后台菜单 */
  int update(Long id, AdminMenu umsMenu);

  /** 根据ID获取菜单详情 */
  AdminMenu getItem(Long id);

  /** 根据ID删除菜单 */
  int delete(Long id);

  /** 分页查询后台菜单 */
  List<AdminMenu> list(Long parentId, Integer pageSize, Integer pageNum);

  /** 树形结构返回所有菜单列表 */
  List<AdminMenuNode> treeList();

  /** 修改菜单显示状态 */
  int updateHidden(Long id, Integer hidden);
}