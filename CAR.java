package CodeForces;

import java.io.*;
import java.util.*;

public class CAR {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder out = new StringBuilder();
        int n = reader.nextInt();
        ArrayList<Cars> cars = new ArrayList<>();
        ArrayList<Integer> order = new ArrayList<>();

        for (int i = 0; i < n * 2; i++) {
            int temp = reader.nextInt();
            if (i < n) {
                Cars temp0 = new Cars(temp, i + 1);
                cars.add(temp0);
            } else {
                cars.get(i - n).day = temp;
                cars.get(i - n).difference = cars.get(i - n).money * 1.0 / cars.get(i - n).day;
            }
        }

        cars.sort((s1, s2) -> Double.compare(s2.difference, s1.difference));

        long count = 0;
        long total = 0;
        for (int i = 0; i < cars.size(); i++) {
            count += cars.get(i).day;
            total += count * cars.get(i).money;
            order.add(cars.get(i).order);
        }

        out.append(total).append("\n");
        for (int i = 0; i < order.size(); i++) {
            out.append(order.get(i)).append(" ");
        }

        System.out.println(out);
    }

    static class Cars {
        public int money;
        public int day;
        public int order;
        public double difference;

        public Cars(int money, int order) {
            this.money = money;
            this.order = order;
        }
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
