package part1.chapter3;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
    /**
     * 出现一些不好的地方,只能读一行
     *
     * @return
     * @throws Exception
     */
    public static String processFile() throws Exception {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("data.txt"))) {
            return bufferedReader.readLine();
        }

    }

    /**
     * 改进方案
     */
    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("data.txt"))) {
            return p.process(bufferedReader);
        }
    }

    // 希望可以自定义读取方式
    @Test
    public void test() throws IOException {
        String file = processFile(br ->
                br.readLine() + br.readLine());
        System.out.println(file);
    }
}
