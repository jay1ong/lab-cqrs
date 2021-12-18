package cn.jaylong.lab.cqrs.controller;

import cn.jaylong.lab.cqrs.cmd.AddLabChildCmd;
import cn.jaylong.lab.cqrs.cmd.DeleteLabChildCmd;
import cn.jaylong.lab.cqrs.cmd.SaveLabCmd;
import cn.jaylong.lab.cqrs.cmd.UpdateLabChildCmd;
import cn.jaylong.snowflake.Snowflake;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    private final Snowflake snowflake;

    @PostMapping
    public void save(@RequestBody SaveLabCmd cmd) {
        cmd.setId(snowflake.nextIdStr());
        commandGateway.sendAndWait(cmd);
    }

    @PostMapping("/{labId}/child/one")
    public void addLabChildOne(@PathVariable String labId, @Validated @RequestBody AddLabChildCmd cmd) {
        cmd.setId(snowflake.nextIdStr());
        cmd.setLabId(labId);
        commandGateway.sendAndWait(cmd);
    }

    @PatchMapping("/{labId}/{id}/child/one")
    public void updateLabChildOne(@PathVariable String labId,
                                  @PathVariable String id,
                                  @RequestBody UpdateLabChildCmd cmd) {
        cmd.setId(id);
        cmd.setLabId(labId);
        commandGateway.sendAndWait(cmd);
    }

    @DeleteMapping("/{labId}/{id}/child/one")
    public void deleteLabChildOne(@PathVariable String labId,
                                  @PathVariable String id,
                                  @RequestBody DeleteLabChildCmd cmd) {
        cmd.setId(id);
        cmd.setLabId(labId);
        commandGateway.sendAndWait(cmd);
    }


}
