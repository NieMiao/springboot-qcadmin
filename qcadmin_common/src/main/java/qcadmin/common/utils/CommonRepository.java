package qcadmin.common.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.Date;
import java.util.List;

/**
 * @program: qcadmin_server
 * @description: 通用repository
 * @author: NieMiao
 * @create: 2019-03-29 11:16
 **/
@NoRepositoryBean
public interface CommonRepository<T> extends JpaRepository<T,String>, JpaSpecificationExecutor<T> {

    //根据id查询（过滤deleteid）
    T findByIdAndDeleteFlag(String id,int deleteFlag);

    //根据id删除
    @Modifying
    @Query(value = "update #{#entityName} set deleteFlag = 1,updatorId=?2,updatorName=?3,updateTime=?4 where id=?1")
    int deleteById(String id, String updatorId, String updatorName, Date updateTime);


    List<T> findByDeleteFlag(int deleteFlag);
}
