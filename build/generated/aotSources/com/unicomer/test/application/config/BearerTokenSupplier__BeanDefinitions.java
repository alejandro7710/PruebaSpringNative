package com.unicomer.test.application.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.oauth2.jwt.JwtEncoder;

/**
 * Bean definitions for {@link BearerTokenSupplier}.
 */
@Generated
public class BearerTokenSupplier__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'bearerTokenSupplier'.
   */
  private static BeanInstanceSupplier<BearerTokenSupplier> getBearerTokenSupplierInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<BearerTokenSupplier>forConstructor(JwtEncoder.class)
            .withGenerator((registeredBean, args) -> new BearerTokenSupplier(args.get(0)));
  }

  /**
   * Get the bean definition for 'bearerTokenSupplier'.
   */
  public static BeanDefinition getBearerTokenSupplierBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BearerTokenSupplier.class);
    beanDefinition.setInstanceSupplier(getBearerTokenSupplierInstanceSupplier());
    return beanDefinition;
  }
}
