package optional;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

public class OptionalTest
{
   public static void main(String[] args) throws IOException
   {
      String contents = new String(Files.readAllBytes(
            Paths.get("../gutenberg/alice30.txt")), StandardCharsets.UTF_8);
      List<String> wordList = Arrays.asList(contents.split("\\PL+"));

      Optional<String> optionalValue = wordList.stream()
         .filter(s -> s.contains("fred"))
         .findFirst();
      System.out.print(optionalValue.orElse("No word") + " contains fred");

      Optional<String> optionalString = Optional.empty();
      String result = optionalString.orElse("N/A");
      System.out.println("result: " + result);
      result = optionalString.orElseGet(() -> System.getProperty("user.dir"));
      System.out.println("result: " + result);
      try
      {
         result = optionalString.orElseThrow(IllegalStateException::new);
         System.out.println("result: " + result);
      }
      catch (Throwable t)
      {
         t.printStackTrace();
      }

      optionalValue = wordList.stream()
         .filter(s -> s.contains("red"))
         .findFirst();
      optionalValue.ifPresent(s -> System.out.println(s + " contains red"));

      Set<String> results = new HashSet<>();
      optionalValue.ifPresent(results::add);
      Optional<Boolean> added = optionalValue.map(results::add);
      System.out.println(added);

      System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
      System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
      System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));
      Optional<Double> result2 = Optional.of(-4.0)
         .flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
      System.out.println(result2);
   }

   public static Optional<Double> inverse(Double x)
   {
      return x == 0 ? Optional.empty() : Optional.of(1 / x);
   }

   public static Optional<Double> squareRoot(Double x)
   {
      return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
   }
}
