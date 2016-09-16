package Elixer_download_manager;

import javax.swing.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Controller {

    @FXML
    TextField url;
    @FXML
    Button download;

        public void downloadBtn(ActionEvent ae){



                Runnable r = new Runnable() {
                    @Override
                    public void run() {

                        try {

                            String val = url.getText().substring( url.getText().lastIndexOf('/')+1, url.getText().length() );
                            System.out.println("Downloading: "+val);

                            URL urlObj = new URL(url.getText());
                            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();

                            conn.setRequestMethod("GET");
                            conn.setDoOutput(true);

                            int requestInfo = conn.getResponseCode();
                            System.out.println("requestInfo: "+requestInfo);
                            BufferedInputStream buffInput = new BufferedInputStream(conn.getInputStream());
                            //writing the data  to the stream
                            FileOutputStream fileOutput = new FileOutputStream(val);
                            int len = 0;
                            byte[] buff = new byte[1024];
                            len = buffInput.read(buff);

                            while (len != -1){

                                fileOutput.write(buff,0,len);
                                len = buffInput.read(buff);
                            }

                            fileOutput.flush();
                            fileOutput.close();
                            buffInput.close();

                            download.setDisable(false);
                            System.out.println("");
                            System.out.println("Download completed...");

                        } catch (MalformedURLException e) {
                            e.printStackTrace();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread subThread = new Thread(r);
                subThread.start();
                download.setDisable(true);
            }
}


