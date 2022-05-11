package org.xinghe.algorithm.ext;

import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.codec.Base64Encoder;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/11 19:51
 * @see [相关类/方法]
 * @since [版本号]
 */
public class PasswordUtil {

    /**
     * 解码加密的字符串
     * 加密过程：12位的字符串在index%3==1的位置上插入4位随机字符串，然后用BASE64加密
     *
     * @param str str
     * @return {@link String}
     */
    public static String decode(String str) throws IOException {
        byte[] bytes = new BASE64Decoder().decodeBuffer(str);
        String string = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(string);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            if (i % 3 == 1) {
                list.add(i);
            }
        }
        for (Integer index : list) {
            String t = string.substring(index, index + 4);
            string = string.replace(t, "");
        }

        System.out.println(string);

        return string;
    }

    public static String encode() {
        RandomGenerator generator = new RandomGenerator(12);
        String str = generator.generate();
        System.out.println(str);

        RandomGenerator fourNums = new RandomGenerator(4);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (i % 3 == 1) {
                list.add(i);
            }
        }
        String s = "";
        for (Integer index : list) {
            if (index > 3) {
                s = s.concat(str.substring(index - 3, index)).concat(fourNums.generate());
            } else {
                s = s.concat(str.substring(0, index)).concat(fourNums.generate());
            }
            System.out.println(s);
        }
        s = s.concat(str.substring(list.get(list.size()-1)));

        System.out.println(s);

        String encode = new BASE64Encoder().encode(s.getBytes(StandardCharsets.UTF_8));

        return encode;

    }

    public static void main(String[] args) throws IOException {
//        String encode = encode();
//        System.out.println(encode);
        String decode = decode("ODZjdDM5dHd3NTIwMmxuN3d6bGhmdHl6cnM0cg==");
        System.out.println(decode);
        System.out.println(decode.equals("89tw2lnhft4r"));
    }
}
