package com.unicomer.test.application.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ExceptionHandleInterceptor}.
 */
@Generated
public class ExceptionHandleInterceptor__BeanDefinitions {
  /**
   * Get the bean definition for 'exceptionHandleInterceptor'.
   */
  public static BeanDefinition getExceptionHandleInterceptorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ExceptionHandleInterceptor.class);
    beanDefinition.setInstanceSupplier(ExceptionHandleInterceptor::new);
    return beanDefinition;
  }
}
