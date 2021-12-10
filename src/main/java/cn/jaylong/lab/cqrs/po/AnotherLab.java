package cn.jaylong.lab.cqrs.po;

import cn.jaylong.lab.cqrs.cmd.SaveLabCmd;
import lombok.*;
import lombok.experimental.Accessors;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
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
@Accessors(chain = true)
@Builder
@Aggregate
@Table(name = "lab_another",
        schema = "cqrs")
@EntityListeners(AuditingEntityListener.class)
@NamedEntityGraph(name = AnotherLab.EG_DEFAULT)
@AllArgsConstructor
@NoArgsConstructor
public class AnotherLab {

    public static final String EG_DEFAULT = "AnotherLab.default";

    @Id
    @Column(nullable = false)
    @AggregateIdentifier
    private String id;

    @Column
    private String name;

    @Column
    private String zone;

    public AnotherLab(SaveLabCmd cmd) {
        this.id = cmd.getId();
        this.name = cmd.getName();
        this.zone = cmd.getZone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AnotherLab lab = (AnotherLab) o;
        return id != null && Objects.equals(id, lab.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
