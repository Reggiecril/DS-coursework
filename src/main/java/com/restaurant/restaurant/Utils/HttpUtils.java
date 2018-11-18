package com.restaurant.restaurant.Utils;

import java.io.IOException;
import java.net.*;
import java.io.*;

public class HttpUtils {
    /**
     * get zomato api json
     * @param url_path
     * @return
     */
    public static String getJsonContent(String url_path) {

        String jsonString = "";
        try {
            //get connect
            URL url = new URL(url_path);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setConnectTimeout(3000);

            //get data by GET Method
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("user-key", "09488ed47de695066d9a6701717e724f");
            //get data from server
            connection.setDoInput(true);

            int responseCode = connection.getResponseCode();

            if (200 == responseCode) {
                //get json
                jsonString = changeInputStream(connection.getInputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    /**
     * get google api json
     *
     * @param address1
     * @param address2
     * @return
     */
    public static String getGoogleJsonContent(String address1, String address2) {

        String jsonString = "";
        try {
            // url link
            String urlString = "https://maps.googleapis.com/maps/api/directions/json?origin="
                    + address1
                    + "&destination="
                    + address2
                    + "&key=AIzaSyBXSO9vl8_bKbRMM3G5tskbPXvJbVSjhYI";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);
            //get data by GET Method
            connection.setRequestMethod("GET");
            //get data from server
            connection.setDoInput(true);

            int responseCode = connection.getResponseCode();

            if (200 == responseCode) {
                jsonString = changeInputStream(connection.getInputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    /**
     * convert json to String
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    private static String changeInputStream(InputStream inputStream) throws IOException {
        String jsonString = null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(data)) != -1) {
            outputStream.write(data, 0, len);
        }

        jsonString = new String(outputStream.toByteArray());
        inputStream.close();

        return jsonString;
    }


}
