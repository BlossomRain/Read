package ch02;

import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.time.Instant;

/**
 * 优先考虑静态工厂方法而不是公共构造函数
 * 一些惯用名称
 */
public class StaticFactoryMethod {
    public static void main(String[] args) throws Exception {
        Date from = Date.from(Instant.EPOCH);
        EnumSet<Rank> faceCards = EnumSet.of(Rank.JACK, Rank.QUEEN, Rank.KING);
        BigInteger valueOf = BigInteger.valueOf(Integer.MAX_VALUE);
        StaticFactoryMethod newInstance = StaticFactoryMethod.class.getConstructor().newInstance();
        FileStore fileStore = Files.getFileStore(Paths.get("test.txt"));
    }



    public StaticFactoryMethod(){

    }
    enum Rank {
        JACK, QUEEN, KING
    }
}
