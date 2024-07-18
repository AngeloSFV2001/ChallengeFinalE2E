@Comprar
  Feature: Compra de productos en la pagina demoblaze
    Background:
    @TEST_COMPRA01
    Scenario Outline: Compra de 2 productos
      Given que el Usuario se encuentre en la pagina de demoblaze
      When agrego dos productos <NUMPRODUCT> al carrito
      Then visualizo que los productos esten en el carrito
      And verifico que sean "<PRODUCT>", precio "<PRICE>", y precio total de la compra es "<TOTALPRICE>"
      Then completo el formulario con la informacion:
      And finalizo la compra
      Examples:
        |NUMPRODUCT| PRODUCT | PRICE | TOTALPRICE |
        |1 |Samsung galaxy s6| 360 | 720 |
        | 2 |Nokia lumia 1520| 820 |1640 |
