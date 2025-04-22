package com.unicomer.test.application.config;

import io.micrometer.observation.ObservationTextPublisher;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link ObservationLogsConfiguration}.
 */
@Generated
public class ObservationLogsConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'observationLogsConfiguration'.
   */
  public static BeanDefinition getObservationLogsConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ObservationLogsConfiguration.class);
    beanDefinition.setTargetType(ObservationLogsConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(ObservationLogsConfiguration.class);
    beanDefinition.setInstanceSupplier(ObservationLogsConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'observationTextPublisher'.
   */
  private static BeanInstanceSupplier<ObservationTextPublisher> getObservationTextPublisherInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ObservationTextPublisher>forFactoryMethod(ObservationLogsConfiguration.class, "observationTextPublisher")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(ObservationLogsConfiguration.class).observationTextPublisher());
  }

  /**
   * Get the bean definition for 'observationTextPublisher'.
   */
  public static BeanDefinition getObservationTextPublisherBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ObservationTextPublisher.class);
    beanDefinition.setInstanceSupplier(getObservationTextPublisherInstanceSupplier());
    return beanDefinition;
  }
}
