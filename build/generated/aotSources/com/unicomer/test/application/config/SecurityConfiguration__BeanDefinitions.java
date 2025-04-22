package com.unicomer.test.application.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

/**
 * Bean definitions for {@link SecurityConfiguration}.
 */
@Generated
public class SecurityConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'securityConfiguration'.
   */
  public static BeanDefinition getSecurityConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityConfiguration.class);
    beanDefinition.setTargetType(SecurityConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(SecurityConfiguration.class);
    beanDefinition.setInstanceSupplier(SecurityConfiguration$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'securityFilterChain'.
   */
  private static BeanInstanceSupplier<SecurityFilterChain> getSecurityFilterChainInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SecurityFilterChain>forFactoryMethod(SecurityConfiguration.class, "securityFilterChain", HttpSecurity.class, ExceptionHandleFilter.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).securityFilterChain(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'securityFilterChain'.
   */
  public static BeanDefinition getSecurityFilterChainBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityFilterChain.class);
    beanDefinition.setInstanceSupplier(getSecurityFilterChainInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'corsConfigurationSource'.
   */
  private static BeanInstanceSupplier<CorsConfigurationSource> getCorsConfigurationSourceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CorsConfigurationSource>forFactoryMethod(SecurityConfiguration.class, "corsConfigurationSource")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).corsConfigurationSource());
  }

  /**
   * Get the bean definition for 'corsConfigurationSource'.
   */
  public static BeanDefinition getCorsConfigurationSourceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CorsConfigurationSource.class);
    beanDefinition.setInstanceSupplier(getCorsConfigurationSourceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'passwordEncoder'.
   */
  private static BeanInstanceSupplier<PasswordEncoder> getPasswordEncoderInstanceSupplier() {
    return BeanInstanceSupplier.<PasswordEncoder>forFactoryMethod(SecurityConfiguration.class, "passwordEncoder")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).passwordEncoder());
  }

  /**
   * Get the bean definition for 'passwordEncoder'.
   */
  public static BeanDefinition getPasswordEncoderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PasswordEncoder.class);
    beanDefinition.setInstanceSupplier(getPasswordEncoderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jwtDecoder'.
   */
  private static BeanInstanceSupplier<JwtDecoder> getJwtDecoderInstanceSupplier() {
    return BeanInstanceSupplier.<JwtDecoder>forFactoryMethod(SecurityConfiguration.class, "jwtDecoder", RSAPublicKey.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).jwtDecoder(args.get(0)));
  }

  /**
   * Get the bean definition for 'jwtDecoder'.
   */
  public static BeanDefinition getJwtDecoderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JwtDecoder.class);
    beanDefinition.setInstanceSupplier(getJwtDecoderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jwtEncoder'.
   */
  private static BeanInstanceSupplier<JwtEncoder> getJwtEncoderInstanceSupplier() {
    return BeanInstanceSupplier.<JwtEncoder>forFactoryMethod(SecurityConfiguration.class, "jwtEncoder", RSAPublicKey.class, RSAPrivateKey.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).jwtEncoder(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'jwtEncoder'.
   */
  public static BeanDefinition getJwtEncoderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JwtEncoder.class);
    beanDefinition.setInstanceSupplier(getJwtEncoderInstanceSupplier());
    return beanDefinition;
  }
}
