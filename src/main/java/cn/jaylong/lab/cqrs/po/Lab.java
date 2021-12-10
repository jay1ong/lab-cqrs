package cn.jaylong.lab.cqrs.po;

import cn.jaylong.lab.cqrs.cmd.SaveLabChildCmd;
import cn.jaylong.lab.cqrs.cmd.SaveLabCmd;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.Accessors;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
@Table(name = "lab",
        schema = "cqrs")
@EntityListeners(AuditingEntityListener.class)
@NamedEntityGraph(name = Lab.EG_DEFAULT)
@AllArgsConstructor
@NoArgsConstructor
public class Lab {

    public static final String EG_DEFAULT = "Lab.default";

    @Id
    @Column(nullable = false)
    @AggregateIdentifier
    private String id;

    @Column
    private String name;

    @Column
    private String zone;

    @AggregateMember
    @Builder.Default
    @OneToMany(mappedBy = "lab",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    @org.hibernate.annotations.ForeignKey(name = "none")
    @JsonManagedReference("lab_child_one")
    private Set<LabChildOne> labChildOneSet = new HashSet<>();

    public Lab(SaveLabCmd cmd) {
        this.id = cmd.getId();
        this.name = cmd.getName();
        this.zone = cmd.getZone();
    }

    @SneakyThrows
    @CommandHandler
    public void saveLabChildOne(SaveLabChildCmd cmd) {
        labChildOneSet.add(new LabChildOne(cmd));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Lab lab = (Lab) o;
        return id != null && Objects.equals(id, lab.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
