package com.example.springbootretry.shared.config.model;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DataSourceConfigurationProperties}.
 */
public class DataSourceConfigurationProperties__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DataSourceConfigurationProperties apply(RegisteredBean registeredBean,
      DataSourceConfigurationProperties instance) {
    AutowiredFieldValueResolver.forRequiredField("driver").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
