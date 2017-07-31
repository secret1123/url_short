package url.util;

import static url.util.Constant.CHARSET;

/**
 * Created by AnLu on
 * 2017/7/29 10:45.
 * ssm
 */
public class GenCreation {
    /**
     * 8位，包含数字0-9，字母 a-z A-Z
     *
     * @return 短链，系统时间纳秒数的62进制字符串，唯一
     */
    public static String getCreation() {
        long nano = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        int j = (int) Math.ceil(Math.log(nano) / Math.log(CHARSET.length()));
        for (int i = 0; i < j; i++) {
            stringBuilder.append(CHARSET.charAt((int) (nano % CHARSET.length())));
            nano /= CHARSET.length();
        }
        return stringBuilder.reverse().toString();
    }

      /*
        String s = "1C"; // 100=1*62^1+C*62^0 1C
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num += CHARSET.indexOf(s.charAt(i)) * Math.pow(62, s.length() - i - 1);
        }
        System.out.println(num);
    */
}
