http://www.mybatis.org/mybatis-3/configuration.html
http://www.mybatis.org/mybatis-3/sqlmap-xml.html

SqlSessionFactoryBuilder



解析主配置文件
XMLConfigBuilder


MapperAnnotationBuilder
按注解解析Mapper，比较重要的的是loadXmlResource，会解析Mapper接口路径对应的Mapper.xml

XMLMapperBuilder
按照xml解析，绑定Mapper接口bindMapperForNamespace


XMLStatementBuilder
解析语句


XMLConfigBuilder--->XMLMapperBuilder（MapperAnnotationBuilder）--->XMLStatementBuilder


----------------------------
如何按包配置mapper.xml，如何按包配置别名，配置插件


<!-- Using classpath relative resources -->
<mappers>
  <mapper resource="org/mybatis/builder/AuthorMapper.xml"/>
  <mapper resource="org/mybatis/builder/BlogMapper.xml"/>
  <mapper resource="org/mybatis/builder/PostMapper.xml"/>
</mappers>
<!-- Using url fully qualified paths -->
<mappers>
  <mapper url="file:///var/mappers/AuthorMapper.xml"/>
  <mapper url="file:///var/mappers/BlogMapper.xml"/>
  <mapper url="file:///var/mappers/PostMapper.xml"/>
</mappers>
<!-- Using mapper interface classes -->
<mappers>
  <mapper class="org.mybatis.builder.AuthorMapper"/>
  <mapper class="org.mybatis.builder.BlogMapper"/>
  <mapper class="org.mybatis.builder.PostMapper"/>
</mappers>
<!-- Register all interfaces in a package as mappers -->
<!-- 会自动查找包路径对应的Mapper.xml -->
<mappers>
  <package name="org.mybatis.builder"/>
</mappers>


====
<typeAliases>
  <typeAlias alias="Author" type="domain.blog.Author"/>
</typeAliases>

<typeAliases>
  <package name="domain.blog"/>
</typeAliases>

@Alias("author")
public class Author {
    ...
}

====
<!-- mybatis-config.xml -->
<plugins>
  <plugin interceptor="org.mybatis.example.ExamplePlugin">
    <property name="someProperty" value="100"/>
  </plugin>
</plugins>


----------------------------
Mybatis如何确定数据源，如何确定使用哪个sql_id对应的sql语句

加载environments标签default对应的数据源，从数据源元数据中得到产品名，
匹配databaseIdProvider属性中的name，从而拿到value即sqlid。
在解析sql时解析没有sqlid或者与该sqlid相同的sql

<environments default="development">
  <environment id="development">
    <transactionManager type="JDBC">
      <property name="..." value="..."/>
    </transactionManager>
    <dataSource type="POOLED">
      <property name="driver" value="${driver}"/>
      <property name="url" value="${url}"/>
      <property name="username" value="${username}"/>
      <property name="password" value="${password}"/>
    </dataSource>
  </environment>
</environments>

<databaseIdProvider type="DB_VENDOR">
  <property name="SQL Server" value="sqlserver"/>
  <property name="DB2" value="db2"/>
  <property name="Oracle" value="oracle" />
</databaseIdProvider>


----------------------------
mybatis一级缓存和二级缓存

一级缓存默认开启，sqlSession级别，在执行提交，新增删除修改时清空
二级缓存是Mapper级别，在执行提交，新增删除修改时清空需要在主配置文件加入
<setting name="cacheEnabled" value="true"/>

注意在事务中获取的是同一个sqlSession，一级缓存有效；如果不开启事务每次获取的是不同缓存，一级缓存无效

https://blog.csdn.net/u012373815/article/details/47069223
https://blog.csdn.net/u013887008/article/details/80379938






