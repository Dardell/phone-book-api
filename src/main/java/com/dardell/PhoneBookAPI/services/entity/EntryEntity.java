package com.dardell.PhoneBookAPI.services.entity;

import lombok.Data;
import net.bytebuddy.utility.nullability.NeverNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Entries", schema = "public")
public class EntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phoneNumber;
    private String date;
    private String asyncString;
}
