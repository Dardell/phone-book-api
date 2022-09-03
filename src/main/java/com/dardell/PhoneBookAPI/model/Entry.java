package com.dardell.PhoneBookAPI.model;

import com.dardell.PhoneBookAPI.utility.DateFormatter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry {
    private long id;
    private String name;
    private String phoneNumber;
    private String date = DateFormatter.getFormattedDate();
    private String asyncString;

}
