package com.hoho.test.validation;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class StringToEnumConverterFactory implements ConverterFactory<String, Enum> {

  @Override
  public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
    // TODO Auto-generated method stub
    return new StringToEnumConverter(targetType);
  }

  private final class StringToEnumConverter<T extends Enum> implements Converter<String, T> {
    private Class<T> enumType;

    public StringToEnumConverter(Class<T> enumType) {
      this.enumType = enumType;
    }

    @Override
    public T convert(String source) {
      return (T) Enum.valueOf(this.enumType, source);
    }
  }

  public static void main(String[] args) {
    StringToEnumConverterFactory stringToEnumConverterFactory = new StringToEnumConverterFactory();
    StringToEnumConverter stringToEnumConverter =
        (StringToEnumConverter) stringToEnumConverterFactory.getConverter(StatusEnum.class);
    StatusEnum enuma = (StatusEnum) stringToEnumConverter.convert("Y");
    System.out.println(enuma.name);
  }
}
