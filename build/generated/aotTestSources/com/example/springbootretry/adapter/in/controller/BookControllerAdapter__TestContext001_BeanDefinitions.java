package com.example.springbootretry.adapter.in.controller;

import com.example.springbootretry.application.port.in.GetBookByIdQuery;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BookControllerAdapter}.
 */
public class BookControllerAdapter__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'bookControllerAdapter'.
   */
  private static BeanInstanceSupplier<BookControllerAdapter> getBookControllerAdapterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<BookControllerAdapter>forConstructor(GetBookByIdQuery.class)
            .withGenerator((registeredBean, args) -> new BookControllerAdapter(args.get(0)));
  }

  /**
   * Get the bean definition for 'bookControllerAdapter'.
   */
  public static BeanDefinition getBookControllerAdapterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BookControllerAdapter.class);
    beanDefinition.setInstanceSupplier(getBookControllerAdapterInstanceSupplier());
    return beanDefinition;
  }
}
