package com.example.demo.web.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PromocaoController}.
 */
@Generated
public class PromocaoController__BeanDefinitions {
  /**
   * Get the bean definition for 'promocaoController'.
   */
  public static BeanDefinition getPromocaoControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PromocaoController.class);
    InstanceSupplier<PromocaoController> instanceSupplier = InstanceSupplier.using(PromocaoController::new);
    instanceSupplier = instanceSupplier.andThen(PromocaoController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
