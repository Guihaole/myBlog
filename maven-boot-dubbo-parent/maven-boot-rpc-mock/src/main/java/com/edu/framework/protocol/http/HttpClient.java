package com.edu.framework.protocol.http;

import com.edu.framework.Invocation;
import org.apache.commons.io.IOUtils;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    public String send(String hostname, Integer port, Invocation invocation) {
        try {
            URL url = new URL("http", hostname, port, "/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(invocation);
            oos.flush();
            oos.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            String s = IOUtils.toString(inputStream);
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
