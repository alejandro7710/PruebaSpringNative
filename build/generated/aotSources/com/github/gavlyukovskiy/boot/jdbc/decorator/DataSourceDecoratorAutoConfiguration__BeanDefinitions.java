package com.github.gavlyukovskiy.boot.jdbc.decorator;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;

/**
 * Bean definitions for {@link DataSourceDecoratorAutoConfiguration}.
 */
@Generated
public class DataSourceDecoratorAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'dataSourceDecoratorAutoConfiguration'.
   */
  public static BeanDefinition getDataSourceDecoratorAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceDecoratorAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(DataSourceDecoratorAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'dataSourceDecoratorBeanPostProcessor'.
   */
  public static BeanDefinition getDataSourceDecoratorBeanPostProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceDecoratorAutoConfiguration.class);
    beanDefinition.setTargetType(DataSourceDecoratorBeanPostProcessor.class);
    beanDefinition.setInstanceSupplier(BeanInstanceSupplier.<DataSourceDecoratorBeanPostProcessor>forFactoryMethod(DataSourceDecoratorAutoConfiguration.class, "dataSourceDecoratorBeanPostProcessor").withGenerator((registeredBean) -> DataSourceDecoratorAutoConfiguration.dataSourceDecoratorBeanPostProcessor()));
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dataSourceNameResolver'.
   */
  private static BeanInstanceSupplier<DataSourceNameResolver> getDataSourceNameResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DataSourceNameResolver>forFactoryMethod(DataSourceDecoratorAutoConfiguration.class, "dataSourceNameResolver", ApplicationContext.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(DataSourceDecoratorAutoConfiguration.class).dataSourceNameResolver(args.get(0)));
  }

  /**
   * Get the bean definition for 'dataSourceNameResolver'.
   */
  public static BeanDefinition getDataSourceNameResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DataSourceNameResolver.class);
    beanDefinition.setInstanceSupplier(getDataSourceNameResolverInstanceSupplier());
    return beanDefinition;
  }
}
