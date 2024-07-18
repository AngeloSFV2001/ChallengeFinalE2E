package com.example.tasks.web;

import com.example.userinterfaces.pages.CartPage;
import com.example.utils.JsonDataReader;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.module.ModuleDescriptor.read;

public class CompleteForm implements Task {

    public static final String DATA = "src/test/resources/templates/users.json";

    private String userName;
    private String country;
    private String city;
    private String card;
    private String month;
    private String year;


    @Override
    public <T extends Actor> void performAs(T actor) {
        obtenerDatosjson();
        actor.attemptsTo(
                Click.on(CartPage.PLACE_ORDER_BUTTON),
                Enter.theValue(userName).into(CartPage.USERNAME_INPUT),
                Enter.theValue(country).into(CartPage.COUNTRY_INPUT),
                Enter.theValue(city).into(CartPage.CITY_INPUT),
                Enter.theValue(card).into(CartPage.CARDCREDIT_INPUT),
                Enter.theValue(month).into(CartPage.MONTH_INPUT),
                Enter.theValue(year).into(CartPage.YEAR_INPUT),
                Click.on(CartPage.PURCHASE_BUTTON)
        );
    }

    private void obtenerDatosjson() {
        this.userName = JsonDataReader.getDataFromJson(DATA).getString("name");
        this.country = JsonDataReader.getDataFromJson(DATA).getString("country");
        this.card = JsonDataReader.getDataFromJson(DATA).getString("card");
        this.city = JsonDataReader.getDataFromJson(DATA).getString("city");
        this.month = JsonDataReader.getDataFromJson(DATA).getString("month");
        this.year = JsonDataReader.getDataFromJson(DATA).getString("year");
    }

}
