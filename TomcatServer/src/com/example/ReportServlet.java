package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReportServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String deviceId = request.getParameter("device_id");

        PrintWriter out = response.getWriter();

        out.write("Your log contents are following:\n");
        List<DeviceLogEntry> entries = LogStorage.STORAGE.getRecentLogDevice(deviceId);
        out.write(entries.toString());

        out.flush();
        out.close();

//        try {
//            serverSocket = new ServerSocket(443);
//            System.out.println("Listening :443");
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        while (true) {
//            try {
//                socket = serverSocket.accept();
//                dataInputStream = new DataInputStream(socket.getInputStream());
//                dataOutputStream = new DataOutputStream(socket.getOutputStream());
//
//                System.out.println("ip: " + socket.getInetAddress());
//                String data = dataInputStream.readUTF();
//                while (!data.equals("end of log from client")) {
//                    System.out.println("message: " + data);
//                    out.println(data);
//                    out.println("<br/>");
//                    data = dataInputStream.readUTF();
//                }
//
////                dataOutputStream.writeUTF("Hello!");
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } finally {
//                if (socket != null) {
//                    try {
//                        socket.close();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//
//                if (dataInputStream != null) {
//                    try {
//                        dataInputStream.close();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//
//                if (dataOutputStream != null) {
//                    try {
//                        dataOutputStream.close();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }

    }
}
