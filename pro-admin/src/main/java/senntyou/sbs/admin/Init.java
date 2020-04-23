package senntyou.sbs.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import senntyou.sbs.common.util.UuidUtil;

@Component
public class Init implements ApplicationRunner {
  @Value("${app.workerId}")
  private long workerId;

  @Value("${app.dataCenterId}")
  private long dataCenterId;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // Init UuidUtil
    UuidUtil.init(workerId, dataCenterId);
  }
}
