import com.aaa.project.util.MD5Util;
import com.aaa.project.util.MD5UtilTest;
import org.junit.Test;

/**
 * @Author:江Sir
 * @Date:25 2022/08/25 08:22
 * @description: Exercise
 * @Version 1.0.0
 */
public class jdbctast {
    @Test
    public void test(){
        System.out.println(MD5UtilTest.encode("123").equals(MD5Util.encode("123")));
//        System.out.println();
    }
}
