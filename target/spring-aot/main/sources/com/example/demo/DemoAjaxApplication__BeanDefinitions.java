package com.example.demo;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DemoAjaxApplication}.
 */
@Generated
public class DemoAjaxApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'demoAjaxApplication'.
   */
  public static BeanDefinition getDemoAjaxApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DemoAjaxApplication.class);
    InstanceSupplier<DemoAjaxApplication> instanceSupplier = InstanceSupplier.using(DemoAjaxApplication::new);
    instanceSupplier = instanceSupplier.andThen(DemoAjaxApplication__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
