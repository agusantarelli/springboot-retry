package org.springframework.boot.autoconfigure.transaction;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Bean definitions for {@link TransactionAutoConfiguration}.
 */
public class TransactionAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'transactionAutoConfiguration'.
   */
  public static BeanDefinition getTransactionAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(TransactionAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'platformTransactionManagerCustomizers'.
   */
  private static BeanInstanceSupplier<TransactionManagerCustomizers> getPlatformTransactionManagerCustomizersInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<TransactionManagerCustomizers>forFactoryMethod(TransactionAutoConfiguration.class, "platformTransactionManagerCustomizers", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(TransactionAutoConfiguration.class).platformTransactionManagerCustomizers(args.get(0)));
  }

  /**
   * Get the bean definition for 'platformTransactionManagerCustomizers'.
   */
  public static BeanDefinition getPlatformTransactionManagerCustomizersBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(TransactionManagerCustomizers.class);
    beanDefinition.setInstanceSupplier(getPlatformTransactionManagerCustomizersInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link TransactionAutoConfiguration.TransactionTemplateConfiguration}.
   */
  public static class TransactionTemplateConfiguration {
    /**
     * Get the bean definition for 'transactionTemplateConfiguration'.
     */
    public static BeanDefinition getTransactionTemplateConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(TransactionAutoConfiguration.TransactionTemplateConfiguration.class);
      beanDefinition.setInstanceSupplier(TransactionAutoConfiguration.TransactionTemplateConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'transactionTemplate'.
     */
    private static BeanInstanceSupplier<TransactionTemplate> getTransactionTemplateInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<TransactionTemplate>forFactoryMethod(TransactionAutoConfiguration.TransactionTemplateConfiguration.class, "transactionTemplate", PlatformTransactionManager.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(TransactionAutoConfiguration.TransactionTemplateConfiguration.class).transactionTemplate(args.get(0)));
    }

    /**
     * Get the bean definition for 'transactionTemplate'.
     */
    public static BeanDefinition getTransactionTemplateBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition();
      beanDefinition.setTargetType(TransactionTemplate.class);
      beanDefinition.setInstanceSupplier(getTransactionTemplateInstanceSupplier());
      return beanDefinition;
    }
  }
}
