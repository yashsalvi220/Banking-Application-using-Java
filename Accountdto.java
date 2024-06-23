package net.javaguides.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Accountdto {
    private Long Id;
    private String Accountholdername;
    private double Balance;

}
