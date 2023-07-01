package cn.edu.xync.mymavenpro.service;

import cn.edu.xync.mymavenpro.entity.Account;
import io.swagger.models.auth.In;

import java.util.List;

public interface AccountService {

    List<Account> findAllAcounts();

    void save(Account account);

    void updateStatusById(Integer status, Integer id );
}
