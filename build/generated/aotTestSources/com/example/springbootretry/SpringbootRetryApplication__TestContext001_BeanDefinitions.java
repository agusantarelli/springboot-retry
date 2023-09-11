package com.example.springbootretry;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link SpringbootRetryApplication}.
 */
public class SpringbootRetryApplication__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'springbootRetryApplication'.
   */
  public static BeanDefinition getSpringbootRetryApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringbootRetryApplication.class);
    beanDefinition.setTargetType(SpringbootRetryApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(SpringbootRetryApplication.class);
    beanDefinition.setInstanceSupplier(SpringbootRetryApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
