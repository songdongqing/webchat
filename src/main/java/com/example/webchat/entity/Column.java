package com.example.webchat.entity;

import lombok.Data;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Data
public class Column {
    String name ;
    String newName;
    String type ;
    String length;
    String tableName;
}