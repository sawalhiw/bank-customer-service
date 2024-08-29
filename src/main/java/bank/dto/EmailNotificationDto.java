package bank.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class EmailNotificationDto {
    private String customerId;
    private String subject;
    private String body;
}
