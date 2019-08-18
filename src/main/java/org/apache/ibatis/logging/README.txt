核心接口：

将三方日志适配成接口
org.apache.ibatis.logging.Log

在LogFactory中
依次尝试获取具体日志类（如slf4j，CommonsLogging，log4j）的适配器，使用第一次获取构造器成功的日志适配器

---
jdbc包
将Connection，PreparedStatement，ResultSet使用动态代理打印日志

亮点：
不只日志代理本身，当原始对象方法返回将要打印日志的对象时，则使用日志代理包装返回
如：Connection.prepareStatement返回PrepareStatement，
Connection的代理对象打印日志，并且将返回的PrepareStatement代理起来，从而在调用PrepareStatement方法的时候也能打印日志




