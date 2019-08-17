package test;


import domain.Customer;
import mapper.CustomerMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtils;

import java.util.HashMap;

public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);

/*        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id",1);
        hashMap.put("name","鲁班");
        Customer customer = mapper.getCustomerWithID(hashMap);*/

        Customer customer = new Customer();
        customer.setCust_name("鲁班1");
        customer.setCust_id(1);
        Customer customer1 = mapper.getCustomerWithID(customer);
        System.out.println(customer1);
        sqlSession.close();
    }

}
