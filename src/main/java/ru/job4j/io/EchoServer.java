package ru.job4j.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String string = input.readLine(); string != null && !string.isEmpty(); string = input.readLine()) {
                        System.out.println(string);
                        if (string.contains("msg=Exit")) {
                            System.out.println("Завершить работу сервера.");
                            output.write("Завершить работу сервера.\r\n\r\n".getBytes());
                            output.flush();
                            server.close();
                        }
                        if (string.contains("msg=Hello")) {
                            System.out.println("Hello");
                            output.write("Hello, dear friend.\r\n\r\n".getBytes());

                        }
                        if (string.contains("msg=What")) {
                            System.out.println("What");
                            output.write("What\r\n\r\n".getBytes());
                        }
                    }
                    output.flush();
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log", e);
        }
    }
}