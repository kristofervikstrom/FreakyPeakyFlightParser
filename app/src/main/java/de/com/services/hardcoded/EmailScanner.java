package com.services.hardcoded;

import com.models.Flight;

import java.util.Timer;

public class EmailScanner extends Thread {

    public EmailScannerListener listener;
    Timer timer = new Timer();

    public EmailScanner(EmailScannerListener listener){
        this.listener = listener;
    }

    public void run(){

    }


}

