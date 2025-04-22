package com.unicomer.test.application.config;

import com.unicomer.test.domain.user.UserRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link WebMvcConfiguration}.
 */
@Generated
public class WebMvcConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'webMvcConfiguration'.
   */
  private static BeanInstanceSupplier<WebMvcConfiguration> getWebMvcConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebMvcConfiguration>forConstructor(UserRepository.class)
            .withGenerator((registeredBean, args) -> new WebMvcConfiguration$$SpringCGLIB$$0(args.get(0)));
  }

  /**
   * Get the bean definition for 'webMvcConfiguration'.
   */
  public static BeanDefinition getWebMvcConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebMvcConfiguration.class);
    beanDefinition.setTargetType(WebMvcConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(WebMvcConfiguration.class);
    beanDefinition.setInstanceSupplier(getWebMvcConfigurationInstanceSupplier());
    return beanDefinition;
  }
}
