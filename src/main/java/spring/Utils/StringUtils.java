package spring.Utils;

/**
 *  @Author Yien
 *  判断字符串是否为空
 */
public class StringUtils {
    public static boolean isEmpty(String string) {
        if ((string == null) || "".equals(string)) {
            return true;
        }
        return false;
    }
}

