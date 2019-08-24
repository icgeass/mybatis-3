动态sql中，#占位符使用Ognl解析，$占位符使用TokenHandler解析


OgnlCache
缓存解析表达式


OgnlClassResolver
缓存classForName，供ognl使用


DynamicContext
记录动态sql结果，提供appendSql（追加sql节点），getSql（获取最终sql）


sqlNode接口
对应不同类型动态SQL的解析，如if,foreach,choose等


SqlSourceBuilder
SqlSourceBuilder主要完成了两
方面的操作，一方面是解析SQL语句中的“#{}”占位符中定义的属性，
格式类似于#{__frc_item_0, javaType=int, jdbcType=NUMERIC,
typeHandler=MyTypeHandler}，另一方面是将SQL语句中的“#{}”占位符
替换成“？”占位符。



BoundSql

MappedStatement

Executor

SqlSessionFactory

SqlSessionFactoryBuilder

SqlSession

Executor

MappedStatement



