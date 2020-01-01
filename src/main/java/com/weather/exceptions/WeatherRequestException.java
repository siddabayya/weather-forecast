package com.weather.exceptions;

public class WeatherRequestException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WeatherRequestException() {
		super();
	}

	public WeatherRequestException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WeatherRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeatherRequestException(String message) {
		super(message);
	}

	public WeatherRequestException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
