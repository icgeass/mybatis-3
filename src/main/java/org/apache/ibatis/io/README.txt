核心类


用于查找单个资源

ClassLoaderWrapper：传入String类型resource，根据持有的ClassLoader并返回URL，用于查找资源。内部调用ClassLoader的getResource或者getResourceAsStream


Resources：封装了lassLoaderWrapper，内部调用ClassLoaderWrapper，提供URL的转换，如getResourceAsProperties

----
用于查找类
ResolverUtil：检测指定包下面的类是否满足要求（父类或者注解），并加入集合。用于查找指定包下面的类。依赖VFS


----
DefaultVFS，用于查找路径下所有资源，查找ClassLoader下path对应的URL，然后遍历读取URL匹配path，获得路径列表，内部调用ClassLoader的getResources











