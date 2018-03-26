package com.hoho.test.validation;

import java.beans.PropertyEditorSupport;

/**
 * 自定义属性转换器
 * 
 * @author Linx
 *
 */
public class BaseTypeEditor extends PropertyEditorSupport {

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    setValue(new BaseType(text));
  }

}
