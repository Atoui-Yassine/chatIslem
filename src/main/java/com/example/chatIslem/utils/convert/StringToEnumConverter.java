package com.example.chatIslem.utils.convert;

import com.example.chatIslem.models.user.ERole;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

@ReadingConverter
public class StringToEnumConverter implements Converter<String, ERole> {

    @Override
    public ERole convert(String source) {
        return ERole.valueOf(source.toUpperCase());
    }
}