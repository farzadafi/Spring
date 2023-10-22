package com.farzadafi.springbase.message;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;

import java.util.Locale;

@RequiredArgsConstructor
public class ResourceBundleMessageService implements MessageService{

    private final MessageSource messageSource;

    @Override
    public String getMessage(String code, String language) {
        return messageSource.getMessage(code, null, Locale.forLanguageTag(language));
    }
}
