import cn.edu.xync.mymavenpro.entity.Account;
import cn.edu.xync.mymavenpro.service.AccountService;
import cn.edu.xync.repository.Account2Repository;
import cn.edu.xync.repository.AccountRepository;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sun.plugin.util.ProgressMonitor.get;

public class JPATest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private Account2Repository account2Repository;
    @Test
    public void saveTest() throws Exception
    {
        Account accout = new Account();
        accout.setName("XXX");
        accout.setBankName("中国建设银行咸阳渭城区分行");
        accout.setStatus(1);
        accout.setStartDate(new Timestamp(System.currentTimeMillis()));
        accout.setBalance(200.0f);

        accountRepository.save(accout);
    }

    @Test
    public void findTest() throws Exception
    {
        Optional<Account> op=accountRepository.findById(1);
        if(op.isPresent())
        {
            Account op.get();
            System.out.println(account);
        }
    }
    @Test
    public void updateTest() throws Exception
    {
        Optional<Account> op=accountRepository.findById(1);
        if(op.isPresent())
        {
            Account account = op.get();
            account.setBalance(0.50f);
            account.setBankName("中国农业银行");
            accountRepository.saveAndFlush(account);

        }
    }
    @Test
    public void deleteTest() throws Exception
    {
        Optional<Account> op=accountRepository.findById(1);
        if(op.isPresent())
        {
            Account account = op.get();
            accountRepository.delete(account);

        }
    }
    @Test
    public void deleteTest() throws Exception
    {
        accountRepository.deleteById(2);
    }

    @Test
    public void saveAllTest() throws Exception{
        List<Account> lists=new ArrayList<Account>();
        Account account = null;
        for (int i=0;i<100;i++){
            account=new Account();
            account.setName("张三"+i);
            account.setBankName("中国建设银行咸阳渭城区分行");
            account.setStatus(1);
            account.setStartDate(new Timestamp(System.currentTimeMillis()));
            account.setBalance(200.0f);

            lists.add(account);
        }
        //accountRepository.saveAll(lists);

        List<Account> list1 = new ArrayList<Account>();

        for(int i = 0;i<9;i++)
        {
            list1.add(list1.get(i));
        }
        accountRepository.deleteAll(list1);
    }

    public void getByMaxId() throws Exception{
       Account account = accountRepository.getByMaxId();
        System.out.println(account);
    }

    public void method1() throws Exception{
        Account account = accountRepository.method1("张三7",0);
        System.out.println(account);
    }

    public void method2() throws Exception{
        Account account = accountRepository.method2(0,"张三7");
        System.out.println(account);
    }
    public void likeMethodTest() throws Exception{
        List<Account> lists=accountRepository.likeMethod1("%张%");
        for(Account acc:lists)
            System.out.println(acc);
    }

    public void likeMethodTest() throws Exception{
        List<Account> lists=accountRepository.likeMethod2("张");
        for(Account acc:lists)
            System.out.println(acc);
    }
    public void getCountTest() throws Exception{
        int count=accountRepository.getCount();
            System.out.println("表中记录的总数是"+count);
    }

    public void updateStatusByIdTest() throws Exception{
        accountRepository.updateStatusById(1,110);
    }

    public void updateStatusByIdTest() throws Exception{
        accountService.updateStatusById(1,110);
    }

    @Test
    public void getByIdTest() throws Exception
    {
        Account account=account2Repository.getById(110);
        System.out.println(account);
    }

}
