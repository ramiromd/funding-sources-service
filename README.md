# API REST: Herencia y polimorfismo

## Objeto
El objeto de este proyecto es demostrar cómo gestionar recursos, de una misma familia, en una API REST.

## Caso de uso

### Funding source service

Se desea desarrollar un servicio que, administre distintos medios de financiación (**funding sources**); para usuarios
de aplicaciones de terceros.

En un principio, se busca modelar los siguientes medios: *tarjetas de crédito* (**credit_cards**) y *cuentas bancarias*
(**bank_accounts**). 

De una **tarjeta de crédito**, se deben conocer los siguientes datos; un identificador univoco del recurso, el identificador
del usuario propietario del recurso, un nombre descriptivo del recurso,  el nombre que figura en la tarjeta, 
su número de identificación bancaria (**BIN**), sus últimos 4 dígitos, su fecha de caducidad, la fecha de creación del 
recurso y la fecha de baja del recurso.

Mientras que, de una **cuenta bancaria** se deben conocer los siguientes datos; un identificador univoco del recurso, el 
identificador del usuario propietario del recurso, un nombre descriptivo del recurso, número de cuenta bancaria, nombre
del titular, nombre de la entidad bancaria, la fecha de creación del recurso y la fecha de baja del recurso.

No obstante, se espera que la solución pueda ser extensible a otros medios; como pueden ser:
*tarjetas de débito* (**debit_cards**), *tarjetas prepagas* (**prepaid_cards**), *cuentas digitales* (**digital_accounts**),
*cheques* (**checks**), *efectivo* (**cash**).

El servicio deberá facilitar las siguientes operaciones, a los usuarios finales: *crear un nuevo medio de pago*,
*deshabilitar un medio de pago*, *listar los medios de pagos* y *obtener el detalle de un medio de pago*.

## :-1: Solución #1

## :+1: Solución #2
