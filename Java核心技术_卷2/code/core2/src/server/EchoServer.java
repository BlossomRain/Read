package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket s = new ServerSocket(8189)) {
            try (Socket incoming = s.accept()) {
                InputStream in = incoming.getInputStream();
                OutputStream out = incoming.getOutputStream();

                try (Scanner scanner = new Scanner(in, "UTF-8")) {
                    PrintWriter writer = new PrintWriter(
                            new OutputStreamWriter(out, "UTF-8"),
                            true
                    );
                    writer.println("Hello! Enter BYE to exit!");
                    boolean done = false;
                    while (!done && scanner.hasNextLine()){
                        String line = scanner.nextLine();
                        writer.println("Echo: " + line);
                        if (line.trim().equalsIgnoreCase("bye"))
                            done = true;
                    }
                }
            }
        }
    }
}
