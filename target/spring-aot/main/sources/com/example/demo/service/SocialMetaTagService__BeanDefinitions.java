package com.example.demo.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SocialMetaTagService}.
 */
@Generated
public class SocialMetaTagService__BeanDefinitions {
  /**
   * Get the bean definition for 'socialMetaTagService'.
   */
  public static BeanDefinition getSocialMetaTagServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SocialMetaTagService.class);
    beanDefinition.setInstanceSupplier(SocialMetaTagService::new);
    return beanDefinition;
  }
}
