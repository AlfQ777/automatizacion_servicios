package com.nttdata.orderstore;


import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.equalTo;

public class ConsultarPedido {

    private static String GET_ORDER = "https://petstore.swagger.io/v2/store/order/";
    @Step("Obtener usuario {0} en PetStore")
    public void consultarPedido(Integer id){
        SerenityRest.given()
                .contentType("application/json")
                .get(GET_ORDER + id).then()
                .body("id", equalTo(id)); //validando que es el objeto con el ID solicitado

    }
}
