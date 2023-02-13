package com.nttdata.orderstore;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

public class CrearPedido {

    private static String CREATE_PEDIDO = "https://petstore.swagger.io/v2/store/order";
    @Step("Crear pedido {0} en store")
    public void crearPedido(Integer id,Integer petId, Integer quantity){

        JSONObject data = new JSONObject();
        data.put("id", id);
        data.put("petId", petId);
        data.put("quantity", quantity);
        data.put("shipDate", "2023-02-13T04:37:58.885+0000");
        data.put("status", "placed");
        data.put("complete", true);

        SerenityRest.given()
                .contentType("application/json")
                .body(data.toString())
                .post(CREATE_PEDIDO);

    }
}
