package com.poc.demo.converter;

import org.owasp.esapi.ESAPI;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class CustomMessageConverter extends MessageConverter {
	
	@Override
	public String convert(ILoggingEvent event) {
		return cleanMessage(super.convert(event));
    }
	
	private final String cleanMessage(String message) {
        // ensure no CRLF injection into logs for forging records
        String clean = message.replace( '\n' ,  '_' ).replace( '\r' , '_' ).replace( '\t' , '_' );
        clean = ESAPI.encoder().encodeForHTML(message);
        if (!message.equals(clean))
           clean += " (Encoded)";
        return clean;
    }
}
