package com.unicomer.test.application.feriado.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link FeriadoService}.
 */
@Generated
public class FeriadoService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static FeriadoService apply(RegisteredBean registeredBean, FeriadoService instance) {
    AutowiredFieldValueResolver.forRequiredField("feriadoRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
