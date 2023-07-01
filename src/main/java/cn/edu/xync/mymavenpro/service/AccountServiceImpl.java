package cn.edu.xync.mymavenpro.service;

import cn.edu.xync.mymavenpro.dao.AccountMapper;
import cn.edu.xync.mymavenpro.entity.Account;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public List<Account> findAllAcounts() {
        //TODO Auto-generated method stub
        return accountMapper.findAll();
    }
    @Override
    @Transactional //该方法需要事务的支持
    public void updateStatusById(Integer status, Integer id ){
        accountRepository.updateStatusById(status,id);
    }

}