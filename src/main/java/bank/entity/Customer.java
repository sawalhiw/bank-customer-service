package bank.entity;

import bank.dto.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Date;


@Entity
@Table(name = "customer")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Customer extends BaseEntity {
    @Column(name = "associated_legal_id")
    private String associatedLegalId;
    private String name;
    private String gender;
    @Enumerated(EnumType.STRING)
    private Type type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
}
