package mapper;

import domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface CustomerMapper {
    public Customer getCustomerWithID(@Param("id") Integer id,@Param("name") String name);
    public Customer getCustomerWithID(Map<String,Object> map);//方法重载
    public Customer getCustomerWithID(Customer customer);
    public Customer getCustomerWithID(int customer);
}