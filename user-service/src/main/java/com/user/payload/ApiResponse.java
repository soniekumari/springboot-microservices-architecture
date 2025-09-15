package com.user.payload;

import lombok.*;
import org.springframework.http.HttpStatus;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
	
	private String message;
	private boolean success;
	private HttpStatus status;
	
}
