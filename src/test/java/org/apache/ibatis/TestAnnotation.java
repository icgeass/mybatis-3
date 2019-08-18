package org.apache.ibatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.MappedTypes;

import java.util.List;

public class TestAnnotation {

    public static void main(String[] args) throws Exception {
        MappedTypes mappedTypes = TestType.class.getAnnotation(MappedTypes.class);
        System.out.println(mappedTypes.value()[0].getName());
        Mapper mapper = TestType.class.getDeclaredField("richField").getAnnotation(Mapper.class);
        System.out.println(mapper instanceof Mapper);

        Param param = ((Param) TestType.class.getDeclaredMethod("testMethod", TestType.class).getParameterAnnotations()[0][0]);
        System.out.println(param.value());




    }
}



@MappedTypes(value = {List.class, TestType.class})
class TestType {

    @Mapper
    String richField;


    public void testMethod(@Param(value = "this is testMethod's Param annotation value") TestType testType) {

    }

}
