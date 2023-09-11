package org.springframework.boot.autoconfigure.jdbc;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DataSourceAutoConfiguration}.
 */
public class DataSourceAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'dataSourceAutoConfiguration'.
   */
  public static BeanDefinition getDataSourceAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(DataSourceAutoConfiguration::new);
    return beanDefinition;
  }
}
