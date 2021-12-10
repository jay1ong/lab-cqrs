package cn.jaylong.lab.cqrs.cmd;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/12/4
 * Url: jaylong.cn
 */
@Data
@Builder
public class SaveLabCmd {

    @TargetAggregateIdentifier
    String id;

    private String name;

    private String zone;


}
