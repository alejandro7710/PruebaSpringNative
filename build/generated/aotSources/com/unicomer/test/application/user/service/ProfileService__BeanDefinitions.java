package com.unicomer.test.application.user.service;

import com.unicomer.test.domain.user.UserRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ProfileService}.
 */
@Generated
public class ProfileService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'profileService'.
   */
  private static BeanInstanceSupplier<ProfileService> getProfileServiceInstanceSupplier() {
    return BeanInstanceSupplier.<ProfileService>forConstructor(UserRepository.class)
            .withGenerator((registeredBean, args) -> new ProfileService(args.get(0)));
  }

  /**
   * Get the bean definition for 'profileService'.
   */
  public static BeanDefinition getProfileServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProfileService.class);
    beanDefinition.setInstanceSupplier(getProfileServiceInstanceSupplier());
    return beanDefinition;
  }
}
