package com.unicomer.test.application.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link QueryFormattingConfiguration}.
 */
@Generated
public class QueryFormattingConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'queryFormattingConfiguration'.
   */
  public static BeanDefinition getQueryFormattingConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(QueryFormattingConfiguration.class);
    beanDefinition.setTargetType(QueryFormattingConfiguration.class);
    beanDefinition.setInitMethodNames("setLogMessageFormat");
    ConfigurationClassUtils.initializeConfigurationClass(QueryFormattingConfiguration.class);
    beanDefinition.setInstanceSupplier(QueryFormattingConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
