package com.linx.test.validation;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * 自定义的属性注册器
 * 
 * @author Linx
 *
 */
public class CustomerPropertyEditorRegisterars implements PropertyEditorRegistrar {

  @Override
  public void registerCustomEditors(PropertyEditorRegistry registry) {
    registry.registerCustomEditor(BaseType.class, new BaseTypeEditor());

  }

}
