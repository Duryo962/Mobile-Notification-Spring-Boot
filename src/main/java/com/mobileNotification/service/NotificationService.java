package com.mobileNotification.service;

import org.springframework.stereotype.Service;

import com.mobileNotification.entity.SmsPojo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Service

public class NotificationService {
	private final String ACCOUNT_SID ="AC9e810266c467f2f6df7ccc5a111d4d4c";

    private final String AUTH_TOKEN = "20ad074265366595171c0980ac4ba822";

    private final String FROM_NUMBER = "+12182204215";

	public void send(SmsPojo sms) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction
		
	}
	


    

}
