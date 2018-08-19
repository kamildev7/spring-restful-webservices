package spring5test.springrestfulwebservices.api.v1.model;

import lombok.Data;

/**
 * @author kamildev7 on 2018-08-19.
 */
@Data
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String customerUrl;
}
