package com.example.springbootretry.application.usecase;

import com.example.springbootretry.application.port.out.GetBookByIdRepository;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GetBookByIdUseCase}.
 */
public class GetBookByIdUseCase__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'getBookByIdUseCase'.
   */
  private static BeanInstanceSupplier<GetBookByIdUseCase> getGetBookByIdUseCaseInstanceSupplier() {
    return BeanInstanceSupplier.<GetBookByIdUseCase>forConstructor(GetBookByIdRepository.class)
            .withGenerator((registeredBean, args) -> new GetBookByIdUseCase(args.get(0)));
  }

  /**
   * Get the bean definition for 'getBookByIdUseCase'.
   */
  public static BeanDefinition getGetBookByIdUseCaseBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GetBookByIdUseCase.class);
    beanDefinition.setInstanceSupplier(getGetBookByIdUseCaseInstanceSupplier());
    return beanDefinition;
  }
}
