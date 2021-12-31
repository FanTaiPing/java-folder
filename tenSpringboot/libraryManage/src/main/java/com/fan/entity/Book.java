package com.fan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Book {
    private int id;
    private String name;
    private String author;
    private String publish;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date publishDate;
    private int page;
    private Double price;
    private String content;
}
