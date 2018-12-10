package com.shininglight.assistant.aaserver.repository;
import com.shininglight.assistant.aaserver.entity.orm.FdBasicEntity;
import com.shininglight.assistant.aaserver.entity.orm.UserCoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Write the summary in here.
 *
 * @author: Shane Liu
 * @date: Created in 21:04 2018/11/14 0014
 */
@Repository
public interface UserCoreRepo extends JpaRepository<UserCoreEntity, Integer> {
    @Query(value = "SELECT * FROM user_core WHERE acct = ?1", nativeQuery = true)
    public UserCoreEntity getUserInfoByAcct(String Acct);

    @Query(value = "SELECT * FROM user_core WHERE id = ?1", nativeQuery = true)
    public UserCoreEntity getUserInfoById(int id);
}
