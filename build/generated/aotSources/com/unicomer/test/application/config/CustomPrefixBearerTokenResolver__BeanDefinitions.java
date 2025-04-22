package com.unicomer.test.application.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CustomPrefixBearerTokenResolver}.
 */
@Generated
public class CustomPrefixBearerTokenResolver__BeanDefinitions {
  /**
   * Get the bean definition for 'customPrefixBearerTokenResolver'.
   */
  public static BeanDefinition getCustomPrefixBearerTokenResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CustomPrefixBearerTokenResolver.class);
    beanDefinition.setInstanceSupplier(CustomPrefixBearerTokenResolver::new);
    return beanDefinition;
  }
}
