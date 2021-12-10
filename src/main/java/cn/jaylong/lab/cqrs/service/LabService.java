package cn.jaylong.lab.cqrs.service;

import cn.jaylong.lab.cqrs.cmd.SaveLabCmd;
import cn.jaylong.lab.cqrs.po.Lab;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/12/4
 * Url: jaylong.cn
 */
@Service
@AllArgsConstructor
public class LabService {

    private final Repository<Lab> labRepository;

    @SneakyThrows
    @CommandHandler
    public void save(SaveLabCmd cmd) {
        labRepository.newInstance(() -> new Lab(cmd));
    }

}
