package part2.chapter7.parallel;

import org.junit.Test;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelTest {

    @Test
    public void testSum() {
        /* 传统for循环 4*/
//        System.out.println("Sequential sum done in:" +
//                measureSumPerf(ParallelTest::sequentialSum, 10_000_000) + " msecs");

        /* 并行 308*/
//        System.out.println("Parallel sum done in:" +
//                measureSumPerf(ParallelTest::parallelSum, 10_000_000) + " msecs");


        /* 并行 1*/
        System.out.println("Parallel sum done in:" +
                measureSumPerf(ParallelTest::parallelSumWithLongStream, 10_000_000) + " msecs");
    }

    private static Long sequentialSum(Long n) {
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += n;
        }
        return ans;
    }

    // 测试执行时间
    public long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public static long parallelSum(long n) {
        return Stream.iterate(0L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);

    }

    public static long parallelSumWithLongStream(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);

    }
}
