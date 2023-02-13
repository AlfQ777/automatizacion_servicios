package com.nttdata.orderstore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.sql.SQLOutput;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;


public class CrearPedidoStepsDefs {

    @Steps
    CrearPedido crearPedido;
    @Given("Estoy logueado con las credenciales correctas1")
    public void estoy_logueado_con_las_credenciales_correctas1() {
        System.out.println("Logueado con exito !!!");
    }
    @When("creo el pedido con id {int}, petId {int} y cantidad {int}")
    public void creo_el_pedido_con_id_pet_cantidad(Integer id, Integer idPet, Integer cantidad) {
        // Write code here that turns the phrase above into concrete actions
        crearPedido.crearPedido(id, idPet, cantidad);
        System.out.println("Objeto creado con exito.");
    }
    @Then("el código de respuesta será {int}")
    public void el_código_de_respuesta_resulta_ser(int statusCode) {
        //restAssuredThat(response1 -> response1.statusCode(statusCode));
        restAssuredThat(response -> response.statusCode(statusCode));
        System.out.println("Código de estado con exito: "+statusCode);
    }
    @And("el atributo complete es un boleano")
    public void el_atributo_complete_es_bolean() {
        restAssuredThat(response -> response.body("complete", Matchers.isA(Boolean.class)));
        System.out.println("El atributo complete es un boleano");
    }


}
