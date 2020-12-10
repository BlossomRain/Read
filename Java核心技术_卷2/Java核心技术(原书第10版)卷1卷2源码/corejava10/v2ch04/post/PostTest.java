package post;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

/**
 * This program demonstrates how to use the URLConnection class for a POST request.
 * @version 1.30 2012-06-04
 * @author Cay Horstmann
 */
public class PostTest
{
   public static void main(String[] args) throws IOException
   {
      Properties props = new Properties();
      try (InputStream in = Files.newInputStream(Paths.get(args[0])))
      {
         props.load(in);
      }
      String url = props.remove("url").toString();
      String result = doPost(url, props);
      System.out.println(result);
   }   
   
   public static String doPost(String urlString, Map<Object, Object> nameValuePairs)
         throws IOException
   {
      URL url = new URL(urlString);
      URLConnection connection = url.openConnection();
      connection.setDoOutput(true);
      String encoding = connection.getContentEncoding();
      if (encoding == null) encoding = "ISO-8859-1";

      try (PrintWriter out = new PrintWriter(connection.getOutputStream()))
      {
         boolean first = true;
         for (Map.Entry<Object, Object> pair : nameValuePairs.entrySet())
         {
            if (first) first = false;
            else out.print('&');
            String name = pair.getKey().toString();
            String value = pair.getValue().toString();
            out.print(name);
            out.print('=');
            out.print(URLEncoder.encode(value, encoding));
         }
      }      

      StringBuilder response = new StringBuilder();
      try (Scanner in = new Scanner(connection.getInputStream(), encoding))
      {
         while (in.hasNextLine())
         {
            response.append(in.nextLine());
            response.append("\n");
         }         
      }
      catch (IOException e)
      {
         if (!(connection instanceof HttpURLConnection)) throw e;
         InputStream err = ((HttpURLConnection) connection).getErrorStream();
         if (err == null) throw e;
         Scanner in = new Scanner(err);
         response.append(in.nextLine());
         response.append("\n");
      }

      return response.toString();
   }
}
