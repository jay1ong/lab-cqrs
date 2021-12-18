package cn.jaylong.lab.cqrs.cmd;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/12/17
 * Url: jaylong.cn
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ConfigureLabChildCmd {

    @TargetAggregateIdentifier
    @ApiModelProperty(value = "labId", hidden = true)
    String labId;

    @ApiModelProperty(value = "id", hidden = true)
    private String id;

    @NotBlank
    private String name;

    private String zone;
}
