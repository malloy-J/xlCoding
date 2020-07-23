package com.jxl.xlCoding.dataStructure;

public class BigNumberSubtraction {

    private static String solution(String line) {

        String[] s = line.split("-");
        char[] a = new StringBuilder(s[0]).reverse().toString().toCharArray();
        char[] b = new StringBuilder(s[1]).reverse().toString().toCharArray();
        //判断a是否大于b
        boolean isBiger = true;
        //如果 a < b ，则交换a、b，结果加负号
        if (a.length < b.length || (a.length == b.length && Integer.parseInt(s[0].substring(0, 1)) < Integer.parseInt(s[1].substring(0, 1)))) {
            char[] c = a;
            a = b;
            b = c;
            isBiger = false;
        }
        //保存逐位相减的结果
        int[] minus = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            int A = a[i] - '0';
            int B;
            if (i < b.length) {
                B = b[i] - '0';
            } else {
                B = 0;
            }
            minus[i] = A - B;
        }
        StringBuilder re = new StringBuilder();
        //负数向前借位，结果存入re
        for (int i = 0; i < minus.length; i++) {
            if (minus[i] < 0) {
                minus[i + 1]--;
                minus[i] += 10;
            }
            re.append(minus[i]);
        }

        return isBiger ? re.reverse().toString().replaceAll("^(0+)", "") : "-" + re.reverse().toString().replaceAll("^(0+)", "");

    }

    public static void main(String[] args) {
        String line = "1231231237-89509801";
        String in = "1141721436";
        String result = solution(line);
        System.out.println(result);
    }
}
