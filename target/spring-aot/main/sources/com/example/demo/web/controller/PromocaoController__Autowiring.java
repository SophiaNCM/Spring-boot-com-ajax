package com.example.demo.web.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link PromocaoController}.
 */
@Generated
public class PromocaoController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static PromocaoController apply(RegisteredBean registeredBean,
      PromocaoController instance) {
    AutowiredFieldValueResolver.forRequiredField("promocaoRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("categoriaRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
