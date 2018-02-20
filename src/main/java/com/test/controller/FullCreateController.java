package com.test.controller;

import com.test.service.CreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/create")
public class FullCreateController {

    private final CreateService createService;

    @Autowired
    public FullCreateController(CreateService createService) {
        this.createService = createService;
    }

    @RequestMapping(value = "/new/all", method = RequestMethod.GET)
    Boolean createFullData() {
        return createService.createFullData();
    }

}
