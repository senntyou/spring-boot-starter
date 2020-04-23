package senntyou.sbs.admin.service;

import java.util.List;
import senntyou.sbs.mbg.model.AdminResourceCategory;

/** 后台资源分类管理Service */
public interface AdminResourceCategoryService {

  /** 获取所有资源分类 */
  List<AdminResourceCategory> listAll();

  /** 创建资源分类 */
  int create(AdminResourceCategory umsResourceCategory);

  /** 修改资源分类 */
  int update(Long id, AdminResourceCategory umsResourceCategory);

  /** 删除资源分类 */
  int delete(Long id);
}
