package com.github.gavlyukovskiy.boot.jdbc.decorator;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DataSourceDecoratorProperties}.
 */
@Generated
public class DataSourceDecoratorProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'dataSourceDecoratorProperties'.
   */
  public static BeanDefinition getDataSourceDecoratorPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceDecoratorProperties.class);
    beanDefinition.setInstanceSupplier(DataSourceDecoratorProperties::new);
    return beanDefinition;
  }
}
