Feature: MercadoLibre
@busquedaProducto
  Scenario: Busqueda de Productos
    Given estoy en la página de MercadoLibre
    When busco un producto "Televisores"
    Then una lista de resultados
    And valido el primer titulo del resultado
