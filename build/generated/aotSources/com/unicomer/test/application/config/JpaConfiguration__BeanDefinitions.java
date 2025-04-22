package com.unicomer.test.application.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link JpaConfiguration}.
 */
@Generated
public class JpaConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'jpaConfiguration'.
   */
  public static BeanDefinition getJpaConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JpaConfiguration.class);
    beanDefinition.setTargetType(JpaConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(JpaConfiguration.class);
    beanDefinition.setInstanceSupplier(JpaConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
