package com.example.demo.web.controller;

import com.example.demo.service.auth.AuthUserService;
import com.example.demo.service.auth.model.User;
import com.example.demo.web.response.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Collection;

/**
 * HelloController
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
@Controller
@RequestMapping("/")
public class HelloController {

    /**
     * The Auth user service.
     */
    @Inject
    private AuthUserService authUserService;

    /**
     * Print welcome response entity.
     *
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<SimpleResponse> printWelcome() {

        return new ResponseEntity<>(SimpleResponse.ok("Hello world!"), HttpStatus.OK);
    }

    /**
     * Users response entity.
     *
     * @return the response entity
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Collection<User>> users() {

        return new ResponseEntity<>(authUserService.getRegisteredUsers(), HttpStatus.OK);
    }
}