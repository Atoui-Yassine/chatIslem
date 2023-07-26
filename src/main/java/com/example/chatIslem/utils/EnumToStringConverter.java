package com.example.chatIslem.utils;

import com.example.chatIslem.models.user.ERole;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class EnumToStringConverter implements Converter<ERole, String> {

    @Override
    public String convert(ERole source) {
        return source.name().toLowerCase();
    }
}