使用工厂模式
接口TransactionFactory,Transaction


Transaction封装DataSource获取连接,然后提供事务支持


JdbcTransaction管理了事务
而ManagedTransaction没有,由容器实现


一个连接就是一个事务

