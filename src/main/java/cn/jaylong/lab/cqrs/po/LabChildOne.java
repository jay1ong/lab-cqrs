package cn.jaylong.lab.cqrs.po;

import cn.hutool.core.util.StrUtil;
import cn.jaylong.lab.cqrs.cmd.AddLabChildCmd;
import cn.jaylong.lab.cqrs.cmd.ConfigureLabChildCmd;
import cn.jaylong.lab.cqrs.cmd.DeleteLabChildCmd;
import cn.jaylong.lab.cqrs.cmd.UpdateLabChildCmd;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.Accessors;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.EntityId;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/12/3
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Accessors(chain = true)
@Builder
@Table(name = "lab_child_one",
        schema = "cqrs")
@EntityListeners(AuditingEntityListener.class)
@NamedEntityGraph(name = LabChildOne.EG_DEFAULT)
@AllArgsConstructor
public class LabChildOne {

    public static final String EG_DEFAULT = "LabChildOne.default";

    @Id
    @Column(nullable = false)
    @EntityId
    private String id;

    @Column
    private String name;

    @Column
    private String zone;

    @Column(name = "lab_id", nullable = false)
    private String labId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    @JsonBackReference("lab_child_one")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Lab lab;

    public LabChildOne(ConfigureLabChildCmd cmd){
        configure(cmd);
    }

    @SneakyThrows
    @CommandHandler
    public void updateLabChildOne(UpdateLabChildCmd cmd) {
        configure(cmd);
    }

    private void configure(ConfigureLabChildCmd cmd){
        labId = cmd.getLabId();
        if (StrUtil.isNotBlank(cmd.getId())) {
            id = cmd.getId();
        }
        if (StrUtil.isNotBlank(cmd.getName())) {
            name = cmd.getName();
        }
        if (StrUtil.isNotBlank(cmd.getZone())) {
            zone = cmd.getZone();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LabChildOne that = (LabChildOne) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
