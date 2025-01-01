package com.test.rippling.api;

import java.util.List;

public class ListingResponse<T> extends ApiResponse {
    List<T> items;

    public ListingResponse(List<T> items) {
        super("Success : "+items, 200);
        this.items = items;
    }
}
