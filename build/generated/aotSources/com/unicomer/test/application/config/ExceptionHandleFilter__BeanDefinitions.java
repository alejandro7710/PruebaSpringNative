package com.unicomer.test.application.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ExceptionHandleFilter}.
 */
@Generated
public class ExceptionHandleFilter__BeanDefinitions {
  /**
   * Get the bean definition for 'exceptionHandleFilter'.
   */
  public static BeanDefinition getExceptionHandleFilterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ExceptionHandleFilter.class);
    beanDefinition.setInstanceSupplier(ExceptionHandleFilter::new);
    return beanDefinition;
  }
}
