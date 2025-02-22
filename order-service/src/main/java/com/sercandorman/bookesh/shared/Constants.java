package com.sercandorman.bookesh.shared;

public class Constants {

    //RabbitMQ
    public static final String RMQ_ORDER_QUEUE = "orderQueue";
    public static final String EXCHANGE_NAME = "orderExchange";
    public static final String ROUTING_KEY = "order.routing.key";

    //Punctuation
    public static final String COLON_WITH_SPACES = " : ";

    //Errors
    public static final String NOT_FOUND = "Record not found!";
    public static final String UNEXPECTED_ERROR = "An unexpected error occurred";
    public static final String ERROR_CREATE_ORDER = "An error occurred while creating the order";
    public static final String ERROR_UPDATE_ORDER = "An error occurred while updating the order";
    public static final String PROBLEM_ON_REQUEST = "A problem occurred while processing your request";

    //Others

    public static final String RECEIVED_ORDER = "Received order: ";


}
