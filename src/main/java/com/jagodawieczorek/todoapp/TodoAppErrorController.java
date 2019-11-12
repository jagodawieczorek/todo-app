package com.jagodawieczorek.todoapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Slf4j
@Controller
public class TodoAppErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        int[] errorCodes = new int[]{HttpStatus.NOT_FOUND.value(), HttpStatus.FORBIDDEN.value()};

        Integer statusCode = Integer.valueOf(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString());
        log.error("An error occurs, HTTP code: " + statusCode);

        if (Arrays.stream(errorCodes).anyMatch(statusCode::equals)) {
            return "error/" + statusCode;
        }

        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
