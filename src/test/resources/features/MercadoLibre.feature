Feature: MercadoLibre
@busquedaProducto
  Scenario: Busqueda de Productos
    Given estoy en la página de MercadoLibre
    When busco un producto "Televisores Led 40 pulgadas"
    Then una lista de resultados
    And valido el primer titulo del resultado
