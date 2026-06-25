package com.example.demo.web.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SocialMetaTagController}.
 */
@Generated
public class SocialMetaTagController__BeanDefinitions {
  /**
   * Get the bean definition for 'socialMetaTagController'.
   */
  public static BeanDefinition getSocialMetaTagControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SocialMetaTagController.class);
    InstanceSupplier<SocialMetaTagController> instanceSupplier = InstanceSupplier.using(SocialMetaTagController::new);
    instanceSupplier = instanceSupplier.andThen(SocialMetaTagController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
