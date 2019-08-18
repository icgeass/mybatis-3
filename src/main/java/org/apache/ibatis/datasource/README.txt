核心

1，工厂模式


2，数据源，内部实际调用的是DriverManager.getConnection(url, properties)


3，连接池如何维护

实现：使用空闲，活跃队列维护连接

获取连接方法：从可用连接获取（若没有则新创建，若超过最大则移除超时连接创建-根据realConnection创建新的连接对象，原有的连接对象失效，若没有超时连接则等待），最后加入活跃队列

代理Connection.close方法，将连接放入空闲列表，如果连接无效则回滚关闭


使用PoolState实现同步


