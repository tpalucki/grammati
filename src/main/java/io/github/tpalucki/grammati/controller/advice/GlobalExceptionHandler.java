package io.github.tpalucki.grammati.controller.advice;

import io.github.tpalucki.grammati.configuration.AppConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

//@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

    private final AppConfig appConfig;

    // TODO not working - intercepts requiests for /quiz
    @ExceptionHandler({IllegalArgumentException.class})
    public String handleException(IllegalArgumentException e, WebRequest webRequest, Model model) {
        log.info("handleException: " + e.toString());
        model.addAttribute("message", e.getMessage());
        model.addAttribute("title", appConfig.getAppTitle());

        return "message";
    }
}
