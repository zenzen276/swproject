package com.dowsoft.swproject.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="Error Message of a specific error/exception occured while processing a request")
public class RestException {
	
	@ApiModelProperty(value="The short message of the Exception")
	@JsonProperty
	private String error;
	
	@ApiModelProperty(value="The description of the Exception")
	@JsonProperty
	private String error_description;
	

	@ApiModelProperty(value="The stack of the Exception")
	@JsonProperty
	private String stack;

	
    public static final String ERROR = "error";
    public static final String ERROR_DESC = "error_description";
    public static final String STACK = "stack";
}