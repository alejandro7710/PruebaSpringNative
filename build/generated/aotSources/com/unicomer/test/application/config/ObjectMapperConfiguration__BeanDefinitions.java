package com.unicomer.test.application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Bean definitions for {@link ObjectMapperConfiguration}.
 */
@Generated
public class ObjectMapperConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'objectMapperConfiguration'.
   */
  public static BeanDefinition getObjectMapperConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ObjectMapperConfiguration.class);
    beanDefinition.setTargetType(ObjectMapperConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(ObjectMapperConfiguration.class);
    beanDefinition.setInstanceSupplier(ObjectMapperConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'objectMapper'.
   */
  private static BeanInstanceSupplier<ObjectMapper> getObjectMapperInstanceSupplier() {
    return BeanInstanceSupplier.<ObjectMapper>forFactoryMethod(ObjectMapperConfiguration.class, "objectMapper", Jackson2ObjectMapperBuilder.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ObjectMapperConfiguration.class).objectMapper(args.get(0)));
  }

  /**
   * Get the bean definition for 'objectMapper'.
   */
  public static BeanDefinition getObjectMapperBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ObjectMapper.class);
    beanDefinition.setInstanceSupplier(getObjectMapperInstanceSupplier());
    return beanDefinition;
  }
}
