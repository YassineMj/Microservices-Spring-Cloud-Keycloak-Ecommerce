package com.yassine.ecommerce.customer.response;

import com.yassine.ecommerce.customer.model.Address;

public record CustomerResponse(
    String id,
    String firstname,
    String lastname,
    String email,
    Address address
) {

}
