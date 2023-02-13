package com.nttdata.orderstore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.lang.reflect.Type;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
public class ConsultarPedidoStepsDefs {

    @Steps
    ConsultarPedido consultarPedido;
    @Given("Estoy logueado con las credenciales correctas2")
    public void estoy_logueado_con_las_credenciales_correctas2() {
        System.out.println("Logueado con exito !!!");
    }
    @When("consulto el pedido por id {int}")
    public void consulto_el_pedido_por_id(Integer id) {
        consultarPedido.consultarPedido(id);
        System.out.println("Consulta realizada con exito");
    }
    @Then("el código de respuesta ess {int}")
    public void el_código_de_respuesta(int statusCode) {
        //restAssuredThat(response1 -> response1.statusCode(statusCode));
        restAssuredThat(response -> response.statusCode(statusCode));
        System.out.println("Código de estado con exito: "+statusCode);
    }
    @And("ningúna cantidad de pedido es nulo {int}")
    public void la_cantidad_del_pedido_no_es_nulo(Integer int1) {

        restAssuredThat(response -> response.body("quantity", Matchers.not(equals(int1))));
        System.out.println("Ninguna cantidad de pedido es 0.");
    }


}
