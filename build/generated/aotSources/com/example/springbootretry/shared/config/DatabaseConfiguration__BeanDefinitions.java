package com.example.springbootretry.shared.config;

import com.example.springbootretry.shared.config.model.DataSourceConfigurationProperties;
import javax.sql.DataSource;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Bean definitions for {@link DatabaseConfiguration}.
 */
public class DatabaseConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'databaseConfiguration'.
   */
  private static BeanInstanceSupplier<DatabaseConfiguration> getDatabaseConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DatabaseConfiguration>forConstructor(DataSourceConfigurationProperties.class)
            .withGenerator((registeredBean, args) -> new DatabaseConfiguration$$SpringCGLIB$$0(args.get(0)));
  }

  /**
   * Get the bean definition for 'databaseConfiguration'.
   */
  public static BeanDefinition getDatabaseConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DatabaseConfiguration.class);
    beanDefinition.setTargetType(DatabaseConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(DatabaseConfiguration.class);
    beanDefinition.setInstanceSupplier(getDatabaseConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'datasource'.
   */
  private static BeanInstanceSupplier<DataSource> getDatasourceInstanceSupplier() {
    return BeanInstanceSupplier.<DataSource>forFactoryMethod(DatabaseConfiguration.class, "dataSource")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(DatabaseConfiguration.class).dataSource());
  }

  /**
   * Get the bean definition for 'datasource'.
   */
  public static BeanDefinition getDatasourceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(DataSource.class);
    beanDefinition.setInstanceSupplier(getDatasourceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'namedParameterJdbcTemplate'.
   */
  private static BeanInstanceSupplier<NamedParameterJdbcTemplate> getNamedParameterJdbcTemplateInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<NamedParameterJdbcTemplate>forFactoryMethod(DatabaseConfiguration.class, "namedParameterJdbcTemplate", DataSource.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DatabaseConfiguration.class).namedParameterJdbcTemplate(args.get(0)));
  }

  /**
   * Get the bean definition for 'namedParameterJdbcTemplate'.
   */
  public static BeanDefinition getNamedParameterJdbcTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(NamedParameterJdbcTemplate.class);
    beanDefinition.setDependsOn("dataSourceScriptDatabaseInitializer");
    beanDefinition.setInstanceSupplier(getNamedParameterJdbcTemplateInstanceSupplier());
    return beanDefinition;
  }
}
