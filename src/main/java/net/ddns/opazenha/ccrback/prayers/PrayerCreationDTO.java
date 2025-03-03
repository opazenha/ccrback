package net.ddns.opazenha.ccrback.prayers;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PrayerCreationDTO {
    @JsonProperty("user_id")
    private Long userId;
    
    @JsonProperty("name")
    private String userName;
    
    @JsonProperty("email")
    private String userEmail;
    
    @JsonProperty("prayer_request")
    private String prayerRequest;
}
