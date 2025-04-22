package com.unicomer.test.application.feriado.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link FeriadoController}.
 */
@Generated
public class FeriadoController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static FeriadoController apply(RegisteredBean registeredBean, FeriadoController instance) {
    AutowiredFieldValueResolver.forRequiredField("feriadoService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
