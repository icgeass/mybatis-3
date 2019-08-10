1，xml的解析（使用xpath）

XPathParser，XNode

封装XPath，提供evalString，evalLong等方法


2，变量替换

PropertyParser

入口：org.apache.ibatis.parsing.PropertyParser.parse

内部类VariableTokenHandler（继承自TokenHandler）提供占位表达式的替换。$(key:default_value)--->value

最终调用org.apache.ibatis.parsing.GenericTokenParser.parse，解析整个长文本（可能包含多个占位表达式）

