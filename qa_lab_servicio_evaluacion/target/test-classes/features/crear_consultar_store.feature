Feature: Crear Consultar pedido Tienda

  @test1
  Scenario Outline: Crear pedido

    Given Estoy logueado con las credenciales correctas1
    When creo el pedido con id <id>, petId <petId> y cantidad <cantidadPedido>
    Then el código de respuesta será <statuscode>
    And el atributo complete es un boleano
    Examples:
      |id| petId | cantidadPedido | statuscode |
      |66| 3     |   15           |      200   |
      |77| 4     |   5            |      200   |
      |88| 5     |   10           |      200   |
      |99| 6     |   12           |      200   |

  @test2
  Scenario Outline: Consultar pedido por id

    Given Estoy logueado con las credenciales correctas2
    When consulto el pedido por id <idPedido>
    Then el código de respuesta ess <statuscode>
    And ningúna cantidad de pedido es nulo <int>
    Examples:
      | idPedido | statuscode | int |
      | 77        | 200       | 0 |
      | 88        | 200       | 0 |
      | 4         | 200       | 0 |
      | 66        | 200       | 0 |
