package senntyou.sbs.security.component;

import java.util.Map;
import org.springframework.security.access.ConfigAttribute;

/** 动态权限相关业务类 Created by macro on 2020/2/7. */
public interface DynamicSecurityService {
  /** 加载资源ANT通配符和资源对应MAP */
  Map<String, ConfigAttribute> loadDataSource();
}
