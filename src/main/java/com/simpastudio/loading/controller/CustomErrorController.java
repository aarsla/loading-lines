package com.simpastudio.loading.controller;

import com.simpastudio.loading.lines.controller.MessageController;
import com.simpastudio.loading.lines.data.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    private static Logger LOG = LoggerFactory.getLogger(MessageController.class);
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    @ResponseBody
    public Message error(HttpServletRequest request) {
        String requestedURI = request.getAttribute("javax.servlet.forward.request_uri").toString();
        LOG.error(requestedURI);
        return new Message("Sorry, the page " + requestedURI + " does not exist... yet!");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
