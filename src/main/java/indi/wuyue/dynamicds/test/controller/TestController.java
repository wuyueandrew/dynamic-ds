package indi.wuyue.dynamicds.test.controller;

import indi.wuyue.dynamicds.test.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping(value = "/test")
    public String testMaster() {
        testService.testNested();
        return "";
    }
}
