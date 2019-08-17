package mapper;

import domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface CustomerMapper {
    public Customer getCustomerWithID(Integer id,String name);
    public Customer getCustomerWithID(Map<String,Object> map);//方法重载
    public Customer getCustomerWithID(Customer customer);
}
