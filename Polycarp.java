package CodeForces;

import java.io.*;
import java.util.*;

public class Polycarp {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder out = new StringBuilder();
        int n = reader.nextInt();
        int length = 0;
        int width = 0;

        for (int i = 0; i < n; i++) {
            String query = reader.next();
            int[] number = {reader.nextInt(), reader.nextInt()};
            Arrays.sort(number);

            if (query.equals("+")) {
                length = Math.max(number[0], length);
                width = Math.max(number[1], width);
            }
            if (query.equals("?")) {
                if ((number[1] >= length && number[0] >= width) || (number[0] >= length && number[1] >= width)) {
                    out.append("YES").append("\n");
                } else {
                    out.append("NO").append("\n");
                }
            }
        }
        System.out.println(out);
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
