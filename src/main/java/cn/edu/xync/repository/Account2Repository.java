package cn.edu.xync.repository;

import cn.edu.xync.mymavenpro.entity.Account;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * Repository是Spring Data JPA里面的顶层接口，是一个空接口，里面什么方法都没有
 * 该接口知识起一个标记的作用，作用就是继承自该接口的接口会被纳入到Spring IOC容器中进行管理，并且该接口的实现类的对象有Spring通过动态代理自动生成。
 * （2）Java中目前我们所接触到的空接口有哪些 :1.Serializable(序列化标记接口）
 *   2.Clonable(克隆接口） 3.Repository接口（Spring Data JPA）
 * （3）继承了Repository接口的接口中就可以按照Spring Data JPA的命名规范去定义相关的持久化方法
 *  (4)也可以不通过继承Repository接口，而是通过在接口上方添加@RepositoryDefinition注解来表明该接口被纳入Spring IOC容器中进行管理
 *
 *  反射 + 注解+ 泛型，因为现在的框架中大量的用到了 ，所以要深入学习。
 */

@RepositoryDefinition(domainClass = Account.class,idClass = Integer.class)
public interface Account2Repository //extends Repository<Account,Integer> {
{

    Account getById(Integer id);
}
