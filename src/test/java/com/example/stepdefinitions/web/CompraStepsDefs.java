package com.example.stepdefinitions.web;

import com.example.questions.web.ProductQuestion;
import com.example.tasks.web.*;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CompraStepsDefs {

    private Scenario scenario;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order = 1)
    public void setScenario (Scenario scenario){
        this.scenario = scenario;
    }

    @Given("^que el (.*) se encuentre en la pagina de demoblaze$")
    public void queElUsuarioSeEncuentreEnLaPaginaDeDemoblaze(String actor) {
        theActorCalled(actor).attemptsTo(
                NavigateTo.demoblazePage()
        );
    }

    @When("agrego dos productos {int} al carrito")
    public void agregoDosProductosAlCarrito(int idProducto) {
        theActorInTheSpotlight().attemptsTo(
                new SelectProduct(idProducto)
        );
    }

    @Then("visualizo que los productos esten en el carrito")
    public void visualizoLosProductosEnElCarrito() {
        theActorInTheSpotlight().attemptsTo(new BuyProducts());
    }
    @And("verifico que sean {string}, precio {string}, y precio total de la compra es {string}")
    public void precioTotalDeLaCompraEs(String nombreProducto, String precioProducto, String Preciototal) {
        theActorInTheSpotlight().should(
                seeThat("El producto a comprar es", ProductQuestion.tituloProduct(), CoreMatchers.equalTo(nombreProducto)),
                seeThat("El producto 2 a comprar es", ProductQuestion.tituloProduct2(), CoreMatchers.equalTo(nombreProducto)),
                seeThat("El precio del primer producto es:", ProductQuestion.priceProduct1(), CoreMatchers.equalTo(precioProducto)),
                seeThat("El precio del segundo producto es:", ProductQuestion.priceProduct2(), CoreMatchers.equalTo(precioProducto)),
                seeThat("El precio total de la compra es: ",ProductQuestion.totalPriceProducts(),CoreMatchers.equalTo(Preciototal))
        );
    }

    @Then("completo el formulario con la informacion:")
    public void completoElFormularioConLaInformacion() {
        theActorInTheSpotlight().attemptsTo(
                new CompleteForm()
        );
    }
/*
    @And("ingreso nombre:{string}, pais: {string}, ciudad: {string}, tarjeta: {string}, mes: {string}, anio: {string}")
    public void ingresoNombrePaisCiudadTarjetaMesAnio(String nombre, String pais, String ciudad, String tarjeta, String mes, String anio) {
        theActorInTheSpotlight().attemptsTo(
                CompleteForm.withDates(nombre, pais, ciudad, tarjeta, mes, anio)
        );
    }
*/
    @And("finalizo la compra")
    public void finalizoLaCompra() {
        theActorInTheSpotlight().attemptsTo(
                new CompleteBuy()
        );
    }



}
