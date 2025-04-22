package com.unicomer.test;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link FeriadoApplication}.
 */
@Generated
public class FeriadoApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'feriadoApplication'.
   */
  public static BeanDefinition getFeriadoApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FeriadoApplication.class);
    beanDefinition.setTargetType(FeriadoApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(FeriadoApplication.class);
    beanDefinition.setInstanceSupplier(FeriadoApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
