package com.unicomer.test.application.user.controller;

import com.unicomer.test.application.user.service.ProfileService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ProfileController}.
 */
@Generated
public class ProfileController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'profileController'.
   */
  private static BeanInstanceSupplier<ProfileController> getProfileControllerInstanceSupplier() {
    return BeanInstanceSupplier.<ProfileController>forConstructor(ProfileService.class)
            .withGenerator((registeredBean, args) -> new ProfileController(args.get(0)));
  }

  /**
   * Get the bean definition for 'profileController'.
   */
  public static BeanDefinition getProfileControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProfileController.class);
    beanDefinition.setInstanceSupplier(getProfileControllerInstanceSupplier());
    return beanDefinition;
  }
}
