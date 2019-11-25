##testRedis1项目使用：
    1.springboot
    2.mybatis
    3.redis
    4.druid
    5.mysql
    6.fastjson
    
    简单地对mysql做CURD，增加缓存和事务操作。
    

###创建pojo&数据库表
    @Data
    public class User {
        private Integer uid;
        private String username;
        private Integer age;
        private String address;
        private Integer salary;
    }
    
###编写application.properties
    server.port=8081
    
    spring.datasource.url=jdbc:mysql://localhost:3306/testRedis1?characterEncoding=utf-8
    spring.datasource.username=root
    spring.datasource.password=cyx19980905
    spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
    
    # Redis数据库索引（默认为0）
    spring.redis.database=0
    spring.redis.host=localhost
    spring.redis.port=6379
    #spring.redis.password=
    #连接池最大连接数（使用负值表示没有限制）
    spring.redis.jedis.pool.max-active=8
    # 连接池最大阻塞等待时间（使用负值表示没有限制）
    spring.redis.jedis.pool.max-wait=-1
    # 连接池中的最大空闲连接
    spring.redis.jedis.pool.max-idle=8
    # 连接池中的最小空闲连接
    spring.redis.jedis.pool.min-idle=0
    # 连接超时时间（毫秒）
    spring.redis.timeout=300
    
    #指定mapper.xml的路径
    mybatis.mapper-locations=classpath:mappers/*.xml
    #该配置项就是指将带有下划线的表字段映射为驼峰格式的实体类属性
    mybatis.configuration.map-underscore-to-camel-case=true
    #控制台打印sql
    mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
    
###r
    
