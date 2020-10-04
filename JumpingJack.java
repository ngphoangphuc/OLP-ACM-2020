package CodeForces;

import java.io.*;
import java.util.*;

public class JumpingJack {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int x = Math.abs(reader.nextInt());
        long sum = 0, temp;
        int count = 0;

        for (int i = 1; ; i++) {
            if (x == 0) {
                break;
            }
            if (sum + i > x) {
                temp = i - (x - sum);
                if (temp % 2 == 0) {
                    count++;
                    break;
                } else {
                    if (i % 2 == 0) {
                        count += 2;
                        break;
                    } else {
                        count += 3;
                        break;
                    }
                }

            } else {
                sum += i;
                count++;
            }

            if (sum == x)
                break;
        }
        System.out.println(count);
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
