package com.example.demo.web.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SocialMetaTagController}.
 */
@Generated
public class SocialMetaTagController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SocialMetaTagController apply(RegisteredBean registeredBean,
      SocialMetaTagController instance) {
    AutowiredFieldValueResolver.forRequiredField("service").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
