package com.dev.weather.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Devaraj
 *Sep 26, 2020
 * 
 */

@Controller
public class ErrorHandleController implements ErrorController  {
 
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
    	 Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    	    
    	    if (status != null) {
    	        Integer statusCode = Integer.valueOf(status.toString());
    	    
    	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
    	            return "errorPage";
    	        }else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
    	            return "errorPage";
    	        }else if(statusCode == HttpStatus.BAD_REQUEST.value()) {
    	            return "errorPage";
    	        }
    	    }
        return "errorPage";
    }
 
    @Override
    public String getErrorPath() {
        return null;
    }
}
