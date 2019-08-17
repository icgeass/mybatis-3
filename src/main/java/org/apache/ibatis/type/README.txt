TypeHandler模块

核心接口TypeHandler，定义从java类型到数据库类型的setParameter和从数据库类型到java类型的getResult

---
TypeAliasRegistry

一个JdbcType对应一个Handler
一个JavaType对应多个JdbcType-Handler的映射


1，注册JdbcType和handler，往JDBC_TYPE_HANDLER_MAP放key-value即可
2，注册JavaType，TypeHandler，没有指定JdbcType，注册之后该JavaType对应的Jdbc-Handler的key为null
3，同2，注册指定JdbcType，对应key为传入值
4，也可直接通过TypeHandler的注解注册


对于没有注册的类型使用UnknownTypeHandler，使用对象setObject，所以sqlMap中最好指定JdbcType


---
TypeAliasRegistry

注册别名
key-类简单名或者Alias对应值


