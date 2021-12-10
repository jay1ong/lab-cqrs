package cn.jaylong.lab.cqrs.repository;

import cn.jaylong.data.jpa.BaseEntityGraphRepository;
import cn.jaylong.lab.cqrs.po.Lab;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/9/23
 */
@Repository
public interface LabJpaRepository extends BaseEntityGraphRepository<Lab, String> {

}
