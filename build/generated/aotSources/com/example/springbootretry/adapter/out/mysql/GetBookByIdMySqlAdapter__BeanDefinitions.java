package com.example.springbootretry.adapter.out.mysql;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Bean definitions for {@link GetBookByIdMySqlAdapter}.
 */
public class GetBookByIdMySqlAdapter__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'getBookByIdMySqlAdapter'.
   */
  private static BeanInstanceSupplier<GetBookByIdMySqlAdapter> getGetBookByIdMySqlAdapterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<GetBookByIdMySqlAdapter>forConstructor(NamedParameterJdbcTemplate.class)
            .withGenerator((registeredBean, args) -> new GetBookByIdMySqlAdapter(args.get(0)));
  }

  /**
   * Get the bean definition for 'getBookByIdMySqlAdapter'.
   */
  public static BeanDefinition getGetBookByIdMySqlAdapterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetBookByIdMySqlAdapter.class);
    beanDefinition.setInstanceSupplier(getGetBookByIdMySqlAdapterInstanceSupplier());
    return beanDefinition;
  }
}
