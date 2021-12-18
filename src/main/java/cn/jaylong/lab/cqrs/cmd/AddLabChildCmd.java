package cn.jaylong.lab.cqrs.cmd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/12/4
 * Url: jaylong.cn
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
public class AddLabChildCmd extends ConfigureLabChildCmd{


}
