package com.example.springbootretry.shared.config.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DataSourceConfigurationProperties}.
 */
public class DataSourceConfigurationProperties__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'dataSourceConfigurationProperties'.
   */
  public static BeanDefinition getDataSourceConfigurationPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceConfigurationProperties.class);
    InstanceSupplier<DataSourceConfigurationProperties> instanceSupplier = InstanceSupplier.using(DataSourceConfigurationProperties::new);
    instanceSupplier = instanceSupplier.andThen(DataSourceConfigurationProperties__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
