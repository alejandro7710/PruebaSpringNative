package com.github.gavlyukovskiy.boot.jdbc.decorator.p6spy;

import com.p6spy.engine.spy.JdbcEventListenerFactory;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link P6SpyConfiguration}.
 */
@Generated
public class P6SpyConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'p6SpyConfiguration'.
   */
  public static BeanDefinition getPSpyConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(P6SpyConfiguration.class);
    beanDefinition.setInitMethodNames("init");
    beanDefinition.setDestroyMethodNames("destroy");
    InstanceSupplier<P6SpyConfiguration> instanceSupplier = InstanceSupplier.using(P6SpyConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(P6SpyConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jdbcEventListenerFactory'.
   */
  private static BeanInstanceSupplier<JdbcEventListenerFactory> getJdbcEventListenerFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<JdbcEventListenerFactory>forFactoryMethod(P6SpyConfiguration.class, "jdbcEventListenerFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(P6SpyConfiguration.class).jdbcEventListenerFactory());
  }

  /**
   * Get the bean definition for 'jdbcEventListenerFactory'.
   */
  public static BeanDefinition getJdbcEventListenerFactoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JdbcEventListenerFactory.class);
    beanDefinition.setInstanceSupplier(getJdbcEventListenerFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'p6SpyDataSourceDecorator'.
   */
  private static BeanInstanceSupplier<P6SpyDataSourceDecorator> getPSpyDataSourceDecoratorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<P6SpyDataSourceDecorator>forFactoryMethod(P6SpyConfiguration.class, "p6SpyDataSourceDecorator", JdbcEventListenerFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(P6SpyConfiguration.class).p6SpyDataSourceDecorator(args.get(0)));
  }

  /**
   * Get the bean definition for 'p6SpyDataSourceDecorator'.
   */
  public static BeanDefinition getPSpyDataSourceDecoratorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(P6SpyDataSourceDecorator.class);
    beanDefinition.setInstanceSupplier(getPSpyDataSourceDecoratorInstanceSupplier());
    return beanDefinition;
  }
}
