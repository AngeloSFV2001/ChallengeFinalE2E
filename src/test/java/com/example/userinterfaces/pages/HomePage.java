package com.example.userinterfaces.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target PRODUCTNAME_INPUT = Target.the("Titulo producto").locatedBy("(//img[@class=\"card-img-top img-fluid\"])[1]");
    public static final Target PRODUCTNAME2_INPUT = Target.the("Titulo producto").locatedBy("(//img[@class=\"card-img-top img-fluid\"])[2]");
    public static final Target CART_BUTTON = Target.the("Boton de carrito").located(By.id("cartur"));
}
