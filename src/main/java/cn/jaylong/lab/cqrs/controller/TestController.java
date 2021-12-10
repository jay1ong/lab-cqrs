package cn.jaylong.lab.cqrs.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/9/22
 */
@RestController
@ApiModel("test")
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {

    @Value("${app.name}")
    public String appName;

    @ApiOperation("value")
    @GetMapping("value")
    public String value() {
        return appName;
    }


}
