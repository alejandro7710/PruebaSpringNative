package com.unicomer.test.application.feriado.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FeriadoService}.
 */
@Generated
public class FeriadoService__BeanDefinitions {
  /**
   * Get the bean definition for 'feriadoService'.
   */
  public static BeanDefinition getFeriadoServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FeriadoService.class);
    InstanceSupplier<FeriadoService> instanceSupplier = InstanceSupplier.using(FeriadoService::new);
    instanceSupplier = instanceSupplier.andThen(FeriadoService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
