package com.nlbg.store.service;

import com.nlbg.store.domain.Order.PaypalOrderForm;
import com.nlbg.store.domain.Order.SellOrderForm;
import org.cloudinary.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class ShippingInformationService {

    public String getShippingLabelFromURL(PaypalOrderForm paypalOrderForm) throws IOException {
        // Create URL and request connection
        URL url = new URL("https://api.shipengine.com/v1/labels");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Content-Type", "application/json");
        // TODO: reset key
        con.setRequestProperty("API-KEY", "TEST_+3Nqn8jLNnDVkUfjRbxn1xTeJ2iLmXq44BT2vY1SmPo");
        con.setRequestMethod("POST");
        con.setDoOutput(true);

        String jsonInputString =
                String.format("{\"shipment\":{\"service_code\":\"ups_ground\",\"ship_to\":{\"name\":\"%s\",\"address_line1\":\"%s\",\"city_locality\":\"%s\",\"state_province\":\"%s\",\"postal_code\":\"%s\",\"country_code\":\"US\",\"address_residential_indicator\":\"yes\"},\"ship_from\":{\"name\":\"Vincent Parsons\",\"company_name\":\"BilliardGear.TV\",\"phone\":\"812-205-3838\",\"address_line1\":\"3608 Quarry Ridge Dr.\",\"city_locality\":\"Evansville\",\"state_province\":\"IN\",\"postal_code\":\"47720\",\"country_code\":\"US\",\"address_residential_indicator\":\"no\"},\"packages\":[{\"weight\":{\"value\":20,\"unit\":\"ounce\"},\"dimensions\":{\"height\":6,\"width\":12,\"length\":24,\"unit\":\"inch\"}}]}}",
                        paypalOrderForm.getFirstName() + " " + paypalOrderForm.getLastName(),
                        paypalOrderForm.getShippingAddress(),
                        paypalOrderForm.getShippingCity(),
                        paypalOrderForm.getShippingState(),
                        paypalOrderForm.getShippingZip()
                );
        System.out.println(jsonInputString);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Read response
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content);

        // Parse to JSON
        JSONObject jsonObject = new JSONObject(content.toString());
        JSONObject labelJSON = jsonObject.getJSONObject("label_download");
        String pdfURL = labelJSON.getString("pdf");
        con.disconnect();

        return pdfURL;
    }

    public String getShippingLabelToURL(SellOrderForm sellOrderForm) throws IOException {
        // Create URL and request connection
        URL url = new URL("https://api.shipengine.com/v1/labels");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Content-Type", "application/json");
        // TODO: reset key
        con.setRequestProperty("API-KEY", "TEST_+3Nqn8jLNnDVkUfjRbxn1xTeJ2iLmXq44BT2vY1SmPo");
        con.setRequestMethod("POST");
        con.setDoOutput(true);

        String jsonInputString = String.format(
                "{\"shipment\":{\"service_code\":\"ups_ground\",\"ship_to\":{\"name\":\"Vince Parsons\",\"address_line1\":\"3608 Quarry Ridge Dr\",\"city_locality\":\"Evansville\",\"state_province\":\"IN\",\"postal_code\":\"47720\",\"country_code\":\"US\",\"address_residential_indicator\":\"yes\"},\"ship_from\":{\"name\":\"%s\",\"company_name\":\"%s\",\"phone\":\"%s\",\"address_line1\":\"%s\",\"city_locality\":\"%s\",\"state_province\":\"%s\",\"postal_code\":\"%s\",\"country_code\":\"US\",\"address_residential_indicator\":\"no\"},\"packages\":[{\"weight\":{\"value\":20,\"unit\":\"ounce\"},\"dimensions\":{\"height\":6,\"width\":12,\"length\":24,\"unit\":\"inch\"}}]}}",
                sellOrderForm.getFirstName() + " " + sellOrderForm.getLastName(),
                sellOrderForm.getFirstName() + " " + sellOrderForm.getLastName(),
                sellOrderForm.getPhoneNumber(),
                sellOrderForm.getShippingAddress(),
                sellOrderForm.getShippingCity(),
                sellOrderForm.getShippingState(),
                sellOrderForm.getShippingZip()
        );
        System.out.println(jsonInputString);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Read response
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        // Parse to JSON
        JSONObject jsonObject = new JSONObject(content.toString());
        JSONObject labelJSON = jsonObject.getJSONObject("label_download");
        String pdfURL = labelJSON.getString("pdf");
        con.disconnect();

        return pdfURL;
    }
}
