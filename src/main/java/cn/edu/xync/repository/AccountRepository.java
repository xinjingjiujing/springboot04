package cn.edu.xync.repository;

import cn.edu.xync.mymavenpro.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findByBalanceGreaterThan(float a);//where balance > ?

    @Query("select acc from Account acc where acc.id=(select max(a.id) from Account a)")

    Account getByMaxId();

    //1:通过占位符的方式传递参数
    @Query("select acc from Account acc where acc.name=?1 and acc.status=?2")
    Account method1(String name,Integer status);

    //2.通过命名参数的方式传递参数
    @Query("select acc from Account acc where acc.name=:aaa and acc.status=:bbb")
    Account method2(@Param("bbb") Integer status, @Param("aaa") String name);

    //模糊查询
    @Query("select acc from Account acc where acc.name like ?1")
    List<Account> likeMethod1(String name);

    @Query("select acc from Account acc where acc.name like %?1%")
    List<Account> likeMethod2(String name);

    //使用原生的SQL语句
    @Query(value="select count(*) from t_account",nativeQuery=true)
    int getCount();

    //JPQL语句也支持update和delete操作，但是不支持insert操作
    //如果JPQL要执行修改和更新操作，还需要给对应的方法上添加@Modifying注解
    //执行update或者delete需要是事务的支持，一般情况下我们都是在Service层添加事务
    @Modifying
    @Query("update Account acc set acc.status=:status where acc.id=:id")
    void updateStatusById(@Param("status") Integer status, @Param("id") Integer id );

}
