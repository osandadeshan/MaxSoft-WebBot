package com.maxsoft.webbot;

import com.maxsoft.webbot.util.email.Email;
import com.maxsoft.webbot.util.email.JsonReportReader;

/**
 * Project Name : MaxSoft-WebBot
 * Developer    : Osanda Deshan
 * Version      : 1.0.0
 * Date         : 24/03/2019
 * Time         : 17:37
 * Description  :
 **/


public class EmailSender {

    public static void main(String[] args) {
        Email.send(JsonReportReader.getExecutionResults());
    }


}
