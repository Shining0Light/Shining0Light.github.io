package com.shininglight.fitness.regsys.dao;

import com.shininglight.fitness.regsys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 系统操作.
 *
 * @author: Shane Liu
 * @date: Created in 15:49 2018/2/3
 */
public interface SysRepository extends JpaRepository<User, Integer> {

}
