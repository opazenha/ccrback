package net.ddns.opazenha.ccrback.prayers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PrayerNotFoundException extends RuntimeException {

    public PrayerNotFoundException(String message) {
        super(message);
    }
}