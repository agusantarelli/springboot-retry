package com.example.springbootretry.shared;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ExceptionHandler}.
 */
public class ExceptionHandler__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'exceptionHandler'.
   */
  private static BeanInstanceSupplier<ExceptionHandler> getExceptionHandlerInstanceSupplier() {
    return BeanInstanceSupplier.<ExceptionHandler>forConstructor(HttpServletRequest.class)
            .withGenerator((registeredBean, args) -> new ExceptionHandler(args.get(0)));
  }

  /**
   * Get the bean definition for 'exceptionHandler'.
   */
  public static BeanDefinition getExceptionHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ExceptionHandler.class);
    beanDefinition.setInstanceSupplier(getExceptionHandlerInstanceSupplier());
    return beanDefinition;
  }
}
