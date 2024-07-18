package com.example.tasks.web;

import com.example.userinterfaces.pages.HomePage;
import com.example.userinterfaces.pages.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class SelectProduct implements Task {
    private static Target VARIABLE = null;
    private final int numProduct;

    public SelectProduct(int numProduct) {this.numProduct = numProduct;}

    @Override
    @Step("{0} selecciona producto")
    public <T extends Actor> void performAs(T actor) {

        switch (numProduct){
            case 1:{
                VARIABLE=HomePage.PRODUCTNAME_INPUT;
            break;
            }
            case 2:{
                VARIABLE=HomePage.PRODUCTNAME2_INPUT;
            break;
            }
        }
        actor.attemptsTo(
                Click.on(VARIABLE),
                Click.on(ProductPage.ADD_BUTTON),
                NavigateTo.demoblazePage(),
                Click.on(VARIABLE),
                Click.on(ProductPage.ADD_BUTTON),
                NavigateTo.demoblazePage()
        );


    }
}
