package com.mobica.dev.training.lernica.form;

import com.google.common.collect.ImmutableList;

import java.util.Date;
import java.util.List;

/**
 * A simple Java object (POJO) representing a Conference form sent from the client.
 */
public class DataForm {

    private String name;
    private String id;
    private String value;




    private DataForm() {}


    public DataForm(String name, String id, String value) {
        this.name = name;
        this.id = id;
        this.value = value;
    }

    public String getName() {
        return name;
    }

  }
