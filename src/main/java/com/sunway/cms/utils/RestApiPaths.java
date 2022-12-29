package com.sunway.cms.utils;

public class RestApiPaths {

    public static final String BASE_URL = "/api/v1";

    public static class FoodSection{
        public static final String FOOD_URL = RestApiPaths.BASE_URL + "/food";
        public static final String FOOD_BY_CATEGORY = FOOD_URL + "/get-by-short-name";
    }

}
