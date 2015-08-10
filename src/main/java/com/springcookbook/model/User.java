package com.springcookbook.model;

import java.sql.Timestamp;

import lombok.Data;

public @Data class User {
	private String name;
	private String gender;
	private Timestamp dob;
}
