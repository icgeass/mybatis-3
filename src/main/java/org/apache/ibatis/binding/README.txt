一个接口对应多个MapperMethod，对应一个MapperProxy，对应一个MapperProxyFactory

MapperRegistry管理了多个MapperProxyFactory

------
核心类：

MapperMethod：真正执行Mapper接口的实现

MapperProxy：持有MapperMethod，实现InvocationHandler，为接口生成代理类，调用MapperMethod具体实现

MapperRegistry：管理所有Mapper的MapperProxyFactory


次要类：MapperProxyFactory：构造MapperProxy，并缓存Map<Method, MapperMethod> methodCache





