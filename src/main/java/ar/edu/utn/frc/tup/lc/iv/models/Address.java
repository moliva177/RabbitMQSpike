package ar.edu.utn.frc.tup.lc.iv.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String streetAddress;

    private Integer number;

    private Integer floor;

    private String apartment;

    private String city;

    private String province;

    private Integer postalCode;
}
