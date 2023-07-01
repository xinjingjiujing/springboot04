package cn.edu.xync.mymavenpro.dao;
import cn.edu.xync.mymavenpro.entity.Account;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface AccountMapper{

    @Select("select * from t_account")
    List<Account> findAll();

}
