Feature: Product - Store

  @testStore
  Scenario Outline: Validación del precio de un producto
    Given estoy en la página de la tienda
    And me logueo con mi usuario "<usuario>" y clave "<password>"
    When navego a la categoria "<Categoria>" y subcategoria "<Subcategoria>"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

    Examples:
      | usuario                   | password       | Categoria | Subcategoria |
      | bernaolavaleria@gmail.com | ValeriaBernaola| Clothes   | Men          |
      | valeria@gmail.com         | ValeriaB       | Clothes   | Men          |
      |bernaolavaleria@gmail.com  | ValeriaBernaola| Autos     | Men          |