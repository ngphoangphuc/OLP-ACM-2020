package CodeForces;

import java.io.*;
import java.util.*;

public class NextRound {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();
        int k = reader.nextInt();
        int count = 0;
        int finisher = 0;
        for (int i = 0; i < n; i++) {
            int temp = reader.nextInt();
            if (temp < finisher)
                break;
            if (temp != 0)
                count++;
            if (i + 1 == k)
                finisher = temp;
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
