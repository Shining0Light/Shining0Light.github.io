package com.shininglight.assistant.aaserver.repository;
import com.shininglight.assistant.aaserver.entity.orm.FdBasicEntity;
import com.shininglight.assistant.aaserver.entity.orm.FdBirthdayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Write the summary in here.
 *
 * @author: Shane Liu
 * @date: Created in 21:04 2018/11/14 0014
 */
@Repository
public interface FdBirthdayRepo extends JpaRepository<FdBirthdayEntity, Integer> {
}
