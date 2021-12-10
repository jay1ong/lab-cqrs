package cn.jaylong.lab.cqrs.controller;

import cn.hutool.core.util.IdUtil;
import cn.jaylong.lab.cqrs.cmd.SaveLabChildCmd;
import cn.jaylong.lab.cqrs.cmd.SaveLabCmd;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/12/4
 * Url: jaylong.cn
 */
@RestController
@RequestMapping("/lab")
@AllArgsConstructor
public class LabController {

    private final CommandGateway commandGateway;

    @PostMapping
    public void save(@RequestBody SaveLabCmd cmd) {
        cmd.setId(IdUtil.getSnowflake(0, 0).nextIdStr());
        commandGateway.send(cmd);
    }

    @PostMapping("/child/one")
    public void saveLabChildOne(@RequestBody SaveLabChildCmd cmd) {
        cmd.setId(IdUtil.getSnowflake(0, 0).nextIdStr());
        commandGateway.send(cmd);
    }


}
