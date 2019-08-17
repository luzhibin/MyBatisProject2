package test;


import domain.Customer;
import mapper.CustomerMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtils;

import java.util.HashMap;

public class MyTest {

    @Test
    public void test1(){
        //单个参数传值
        // public Customer getCustomerWithID(Integer id);
/*            <select id="getCustomerWithID" parameterType="Integer" resultType="domain.Customer">
                select * from `customer` where cust_id=#{id}    //也可以 cust_id=#{value}
              </select>*/
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.getCustomerWithID(1);
        System.out.println(customer);
        sqlSession.close();
    }

    @Test
    public void test2(){
        //MyBatis-Mapper传参多个普通类型
        // public Customer getCustomerWithID(Integer id,String name);
        /*    <select id="getCustomerWithID" resultType="domain.Customer">
                 select * from `customer` where cust_id=#{param1} and cust_name=#{param2}
              或 select * from `customer` where cust_id=#{arg0} and cust_name=#{arg1}
              </select>*/
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.getCustomerWithID(2,"李白");
        System.out.println(customer);
        sqlSession.close();
    }

    @Test
    public void test3(){
        //MyBatis-Mapper传参多个普通类型—@param命名参数
        // public Customer getCustomerWithID(@Param("id") Integer id,@Param("name") String name);
        /*    <select id="getCustomerWithID" resultType="domain.Customer">
        select * from `customer` where cust_id =#{id} and cust_name =#{name}   // Available parameters are [name, id, param1, param2]
    </select>*/
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.getCustomerWithID(3,"阿轲");
        System.out.println(customer);
        sqlSession.close();
    }

    @Test
    public void test4(){
        //MyBatis-Mapper——封装多个参数为map，直接传递
        //  public Customer getCustomerWithID(Map<String,Object> map);
        /*    <select id="getCustomerWithID" resultType="domain.Customer">
        select * from `customer` where cust_id =#{id} and cust_name =#{name}   //不能传param1、param2，值会为null
    </select>*/
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        HashMap<String, Object> hashMap= new HashMap<>();
        hashMap.put("id",4);
        hashMap.put("name","德玛西亚");
        Customer customer = mapper.getCustomerWithID(hashMap);
        System.out.println(customer);
        sqlSession.close();
    }

    @Test
    public void test5(){
        //MyBatis-Mapper——POJO类
        //    public Customer getCustomerWithID(Customer customer);
        /*    <select id="getCustomerWithID" resultType="domain.Customer">
        select * from `customer` where cust_id =#{cust_id} and cust_name =#{cust_name}  //传POJO类时参数必须和类的字段一致
    </select>*/
        SqlSession sqlSession = MybatisUtils.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer = new Customer();
        customer.setCust_id(5);
        customer.setCust_name("亚索");
        Customer customer1 = mapper.getCustomerWithID(customer);

        System.out.println(customer1);
        sqlSession.close();
    }
}
