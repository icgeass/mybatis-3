使用装饰器模式，提供Cache接口和简单实现PerpetualCache，而扩展功能通过在简单实现上添加职责完成



如先入先出FIFO，内部维护了加入的key列表，当put超过最大值就移除最先加入的缓存（LRU类似，只是在get时同时get了下keyMap，这样对应的key就是最新而不会删除）



