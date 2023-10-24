package com.farzadafi.springbase.service;

import com.farzadafi.springbase.message.MessageService;
import com.farzadafi.springbase.model.common.CommonStudent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
@RequiredArgsConstructor
public class LogEnabledStudentService implements StudentService {
    private final StudentService service;
    private final MessageService messageService;

    @Value("${application.configs.language}")
    private String language;

    @Override
    public void register(CommonStudent student) {
        log.info(messageService.getMessage("register.successful", language)+ " {}", student);
        service.register(student);
    }
}