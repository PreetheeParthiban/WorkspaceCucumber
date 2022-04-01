Feature: Undostress recharge successful


  Scenario Outline: Select the Operator
    Given I launch "<browser>"
    When I open "<url>"
    Then I select operator as Telcel from Operador field
    Then Enter "<mobileNumber>" under Numero de celular
    Then Select recharge under Monto de Recarga
    And Click on siguiente
    Then Verify if payment screen is reached
    Then Select Tarjeta payment method
    And Select Usar nueva tarjeta payment option
    Then Enter the "<cardNumber>"
    And Enter "<month>", "<date>","<cvv>"
    And Enter "<email>" under correo electronico
    Then Click on Pagar con Tarjeta
    And Enter the "<useremail>" and "<password>"
    Then Verify if user gets success message and recharge is successful
   # And Close the browser
    Examples:
      | browser | url |  mobileNumber | cardNumber|month|date|cvv|email|useremail|password|
     |chrome   |http://sanbox.undostres.com.mx |8465433546   |4111111111111111|11|25|111|test@test.com|automationUDT1@gmail.com|automationUDT123|
     |edge   |http://sanbox.undostres.com.mx |8465433546   |4111111111111111|11|25|111|test@test.com|automationUDT1@gmail.com|automationUDT123|


