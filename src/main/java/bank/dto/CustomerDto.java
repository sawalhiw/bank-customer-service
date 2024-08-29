package bank.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class CustomerDto extends BaseDto {
    @NotBlank(message = "associatedLegalId shouldn't be null or empty.")
    @Size(min = 7, max = 8, message = "associatedLegalId should be 7 digits.")
    private String associatedLegalId;

    @NotBlank(message = "'name' shouldn't be null or empty.")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name should contain only letters and spaces.")
    private String name;

    @NotBlank(message = "gender shouldn't be null or emtpy.")
    @Pattern(regexp = "^(male|female)$", message = "Gender should be either 'male' or 'female'.")
    private String gender;

    @NotNull(message = "Type shouldn't be null.")
    private Type type;

    @NotNull(message = "address should be not null.")
    private AddressDto address;

    @NotBlank(message = "phoneNumber shouldn't be null or empty.")
    @Pattern(regexp = "^\\+?\\d{10,15}$", message = "Phone number should be valid and can contain country code with a total length between 10 and 15 digits.")
    private String phoneNumber;

    @NotBlank(message = "email shouldn't be null or empty.")
    @Email(message = "Email should be valid.")
    private String email;

    @Past(message = "Date of birth should be in the past.")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
}
