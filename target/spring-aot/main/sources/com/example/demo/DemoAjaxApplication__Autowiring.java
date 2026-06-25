package com.example.demo;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DemoAjaxApplication}.
 */
@Generated
public class DemoAjaxApplication__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DemoAjaxApplication apply(RegisteredBean registeredBean,
      DemoAjaxApplication instance) {
    instance.service = AutowiredFieldValueResolver.forRequiredField("service").resolve(registeredBean);
    return instance;
  }
}
