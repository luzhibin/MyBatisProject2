package mapper;

import domain.Customer;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    public void insertCustomer(@Param("name") String name, @Param("age") String age);
}
