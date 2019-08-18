# MybatisProject2
### 所需jar包存放在lib目录下
### MyBatis-Mapper动态代理
  * 1.要求
    * namespace必须和Mapper接口类路径一致 
    * id必须和Mapper接口方法名一致
    * parameterType必须和接口方法参数类型一致
    * resultType必须和接口方法返回值类型一致
  * 2.selectOne和selectList
    * 动态代理对象调用sqlSession.selectOne()和sqlSession.selectList()是根据mapper接口方法的返回值决定
    * 如果返回list则调用selectList方法，如果返回单个对象则调用selectOne方法。
  
### MyBatis-Mapper参数传递
  * 单个参数
    * 可以接受基本类型，对象类型，集合类型的值。
    * MyBatis可直接使用这个参数，不需要经过任何处理。
    * 任意多个参数，都会被MyBatis重新包装成一个Map传入。
  * 多个参数
    * Map的key是param1，param2…，值就是参数的值。
  * @param命名参数
    * 为参数使用@Param起一个名字，
    * MyBatis就会将这些参数封装进map中，key就是我们自己指定的名字
  * POJO
    * 当这些参数属于我们业务POJO时，我们直接传递POJO
  * Map
    * 我们也可以封装多个参数为map，直接传递
    
### MaBatis核心配置文件
  * properties
    * [定义属性及读取属性文件](http://www.mybatis.org/mybatis-3/zh/configuration.html#properties)
  * settings
    * 这是 MyBatis 中极为重要的调整设置，它们会改变 MyBatis 的运行时行为
    * http://www.mybatis.org/mybatis-3/zh/configuration.html#properties
  * typeAliases
    * 类型别名是为 Java 类型设置一个短的名字
    * 定义单个别名
    * 批量别名定义
  * typeHandlers
    * 无论是 MyBatis 在预处理语句（PreparedStatement）中设置一个参数时，
    * 还是从结果集中取出一个值时， 都会用类型处理器将获取的值以合适的方式转换成 Java 类型。
    * JDK1.8之后实现全部的JSR310规范
    * 日期时间处理上，我们可以使用MyBatis基于JSR310（Date and Time API）
    * 编写的各种日期时间类型处理器。
    * MyBatis3.4以前的版本需要我们手动注册这些处理器，以后的版本都是自动注册的
  * Plugins
    * 插件是MyBatis提供的一个非常强大的机制，
    * MyBatis 允许你在已映射语句执行过程中的某一点进行拦截调用。
    * 通过插件来修改MyBatis的一些核心行为。
  * Environments
    * MyBatis可以配置多种环境，比如开发、测试和生产环境需要有不同的配置。
    * 每种环境使用一个environment标签进行配置并指定唯一标识符
    * 可以通过environments标签中的default属性指定一个环境的标识符来快速的切换环境
  * databaseIDProvider
    * MyBatis 可以根据不同的数据库厂商执行不同的语句。
    * 可以能过databaseIDProvider标签来进行设置
      ```xml
        <databaseIdProvider type="DB_VENDOR">
        <property name="MYSQL" value="mysql"/>
        <property name="DB2" value="db2"/>
        <property name="Oracle" value="oracle" />
        <property name="SQL Server" value="sqlserver"/>
    </databaseIdProvider>
  * mappers
    ```xml
    <mapper resource=" "/>  /*使用相对于类路径的资源*/
    <mapper class=" " />   /*使用mapper接口类路径,此种方法要求mapper接口名称和mapper映射文件名称相同，且放在同一个目录中*/
    <package name=""/>     /*此种方法要求mapper接口名称和mapper映射文件名称相同，且放在同一个目录中*/
