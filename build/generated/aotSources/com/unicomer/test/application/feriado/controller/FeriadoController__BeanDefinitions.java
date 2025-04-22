package com.unicomer.test.application.feriado.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FeriadoController}.
 */
@Generated
public class FeriadoController__BeanDefinitions {
  /**
   * Get the bean definition for 'feriadoController'.
   */
  public static BeanDefinition getFeriadoControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FeriadoController.class);
    InstanceSupplier<FeriadoController> instanceSupplier = InstanceSupplier.using(FeriadoController::new);
    instanceSupplier = instanceSupplier.andThen(FeriadoController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
