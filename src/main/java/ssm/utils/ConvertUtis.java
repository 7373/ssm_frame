package ssm.utils;

/**
 * @ClassName ConvertUtis
 * @Description 根据传入的属性和类名，将属性名强转为类名的属性
 * @Data 2018/12/6
 * @Author Yien
 */
public class ConvertUtis {


    public static Object convert(String className, String parameter) {
        if(StringUtils.isBlank(className)){
            return null;
        }
        switch (className) {
            case "String":
                return parameter;
            case "Integer":
                return Integer.valueOf(parameter);
            case "int":
                return Integer.parseInt(parameter);
            case "Float":
                return Float.valueOf(parameter);
            case "Double":
                return Double.valueOf(parameter);
            case "Long":
                return Long.valueOf(parameter);
            case "Short":
                return Short.valueOf(parameter);
            case "Byte":
                return Byte.valueOf(parameter);
            case "Boolean":
                return Boolean.valueOf(parameter);
            default:
                return null;
        }
//        if (className.equals("String")){
//            return parameter;
//        }
//        else if (className.equals("Integer")){
//            return Integer.valueOf(parameter);
//        }
//        else if (className.equals("int")){
//            return Integer.valueOf(parameter);
//        }
//        else if (className.equals("Float")){
//            return Float.valueOf(parameter);
//        }
//        else if (className.equals("Double")){
//            return Double.valueOf(parameter);
//        }
//
//        else if (className.equals("Long")){
//            return Long.valueOf(parameter);
//        }
//        else if (className.equals("Short")){
//            return Short.valueOf(parameter);
//        }
//        else if (className.equals("Byte")){
//            return Byte.valueOf(parameter);
//        }
//        else if (className.equals("Boolean")){
//            return Boolean.valueOf(parameter);
//        }
//        return null;

    }
}
