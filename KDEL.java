package CodeForces;

import java.io.*;
import java.util.*;

public class KDEL {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder out = new StringBuilder();
        StringBuilder primeStr = new StringBuilder();
        int n = reader.nextInt();
        int k = reader.nextInt();
        int count = 0;
        String result = "";
        createPrimeNumbersString(count, primeStr, n);
        result = removeKDigits(primeStr, k);

        System.out.println(result);
    }

    static void createPrimeNumbersString(int c, StringBuilder p, int n) {
        for (int i = 2; ; i++) {
            if (checkPrimeNumber(i)) {
                p.append(i);
                c++;
            }
            if (c == n)
                break;
        }
    }

    static String removeKDigits(StringBuilder num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (stack.size() != 0 && stack.getLast() < c && count++ < k) {
                stack.removeLast();
            }

            stack.addLast(c);
        }

        while (count++ < k) stack.removeLast();
        while (stack.size() != 0 && stack.getFirst() == '0') stack.removeFirst();
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);

        return sb.length() == 0 ? "0" : sb.toString();
    }

    static boolean checkPrimeNumber(int number) {
        if (number < 2)
            return false;
        int temp = (int) Math.sqrt(number);
        for (int i = 2; i <= temp; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            String str;
            try {
                str = reader.readLine();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return str;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}
