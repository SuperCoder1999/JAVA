package chapter19IO.my_io_utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/4/1 18:15
 * Description 模仿Scanner方法
 * 1.StringTokenizer类不会用,所以不清楚其原理,也不清楚其用法
 */
public class Read {
    public static void main(String[] args) throws IOException {
        Read read = new Read();
        for (int i = 0; i < 3; i++) {
            System.out.println(read.next());
        }
    }
    private BufferedReader bf;
    private StringTokenizer st;

    public Read() {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
    }

    public String nextLine() throws IOException {
        return bf.readLine();
    }

    public String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

}
