package bank.dto;

import bank.entity.Address;
import bank.exception.ValidationException;
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

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name should contain only letters and spaces.")
    private String name;

    @NotBlank
    @Pattern(regexp = "^(male|female)$", message = "Gender should be either 'male' or 'female'.")
    private String gender;

    @NotNull(message = "Type shouldn't be null.")
    private Type type;

    private Address address;

    @NotBlank
    @Pattern(regexp = "^\\+?\\d{10,15}$", message = "Phone number should be valid and can contain country code with a total length between 10 and 15 digits.")
    private String phoneNumber;

    @NotBlank
    @Email(message = "Email should be valid.")
    private String email;

    @Past(message = "Date of birth should be in the past.")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Override
    public void setId(final String id) {
        if (id.length() != 7) {
            throw new ValidationException("Customer ID should be 7 digits.");
        }
        super.setId(id);
    }
}
