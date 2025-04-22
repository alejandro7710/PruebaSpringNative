package com.github.gavlyukovskiy.boot.jdbc.decorator.p6spy;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link P6SpyConfiguration}.
 */
@Generated
public class P6SpyConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static P6SpyConfiguration apply(RegisteredBean registeredBean,
      P6SpyConfiguration instance) {
    AutowiredFieldValueResolver.forRequiredField("dataSourceDecoratorProperties").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forField("listeners").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
