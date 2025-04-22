package com.unicomer.test.application.user.config;

import com.unicomer.test.application.config.BearerTokenSupplier;
import com.unicomer.test.application.user.service.UserApplicationService;
import com.unicomer.test.application.user.service.UserService;
import com.unicomer.test.domain.user.UserRepository;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Bean definitions for {@link UserServiceConfiguration}.
 */
@Generated
public class UserServiceConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'userServiceConfiguration'.
   */
  public static BeanDefinition getUserServiceConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserServiceConfiguration.class);
    beanDefinition.setTargetType(UserServiceConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(UserServiceConfiguration.class);
    beanDefinition.setInstanceSupplier(UserServiceConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'userService'.
   */
  private static BeanInstanceSupplier<UserService> getUserServiceInstanceSupplier() {
    return BeanInstanceSupplier.<UserService>forFactoryMethod(UserServiceConfiguration.class, "userService", UserApplicationService.class, ObservationRegistry.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(UserServiceConfiguration.class).userService(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'userService'.
   */
  public static BeanDefinition getUserServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserService.class);
    beanDefinition.setInstanceSupplier(getUserServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'userApplicationService'.
   */
  private static BeanInstanceSupplier<UserApplicationService> getUserApplicationServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<UserApplicationService>forFactoryMethod(UserServiceConfiguration.class, "userApplicationService", UserRepository.class, PasswordEncoder.class, BearerTokenSupplier.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(UserServiceConfiguration.class).userApplicationService(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'userApplicationService'.
   */
  public static BeanDefinition getUserApplicationServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(UserApplicationService.class);
    beanDefinition.setInstanceSupplier(getUserApplicationServiceInstanceSupplier());
    return beanDefinition;
  }
}
