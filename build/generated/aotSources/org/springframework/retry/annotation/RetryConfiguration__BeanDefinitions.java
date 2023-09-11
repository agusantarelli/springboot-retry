package org.springframework.retry.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link RetryConfiguration}.
 */
public class RetryConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'retryConfiguration'.
   */
  public static BeanDefinition getRetryConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RetryConfiguration.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(RetryConfiguration::new);
    return beanDefinition;
  }
}
