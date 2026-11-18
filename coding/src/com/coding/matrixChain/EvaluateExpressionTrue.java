package com.coding.matrixChain;

public class EvaluateExpressionTrue {

    public static void main(String[] args) {
        String s = "T|T&F^T";

        int evaluate = evaluate(s, 0, s.length() - 1, true);
        System.out.println(evaluate);
    }

    public static int evaluate(String s, int i, int j, boolean isTrue) {

        if (i > j) {
            return 0;
        }
        if (i == j) {
            return (isTrue == (s.charAt(i) == 'T')) ? 1 : 0;
        }
        int ans = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {

            int lt = evaluate(s, i, k - 1, true);
            int lf = evaluate(s, i, k - 1, false);
            int rt = evaluate(s, k + 1, j, true);
            int rf = evaluate(s, k + 1, j, false);
            if (s.charAt(k) == '&') {
                if (isTrue) {
                    ans += lt * rt;
                } else {
                    ans += lf * rf + lf * rf + lt * rf;
                }
            }
            if (s.charAt(k) == '|') {
                if (isTrue) {
                    ans += lt * rt + lf * rt + lt * rf;
                } else {
                    ans += lf * rf;
                }
            }

                if (s.charAt(k) == '^') {
                    if (isTrue) {
                        ans += lt * rf + lf * rt;
                    } else {
                        ans += lt * rt + lf * rf;
                    }
                }

            }
        return ans;
        }

}
