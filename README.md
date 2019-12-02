# Wallet Service

The exercise consists of building a proof of concept for a purse bond service.
The purse bond works like a "real" purse:
Stores a balance in euros, which the user can use to pay for other services.
The user can top up money from a third party payment gateway (stripe, paypal, redsys...).
There is no possibility to return this money to the original means of payment.

The basic structure of the purse is its identifier and its current balance. If you think you need more fields,
add them without problems and we'll discuss them at the interview.

The exercise consists of you programming endpoints for:
Consult a voucher for its identifier.
Discount the balance of the purse (a charge).
Return the balance to the wallet (a refund).
Reload money in that bonus through a third party payment service.

So that you can get to the point, we give you a maven project with a Spring Boot application, with the basic dependencies and a
H2 database. You have developer and test profiles.

You also have a service implementation that would implement the real payment gateway (ThirdPartyPaymentService).
That part you don't have to program, assume that the service makes the remote call given an amount of money.
It is intended to return error under certain conditions.


El ejercicio consiste en construir una prueba de concepto para un servicio de fianza.
El bono monedero funciona como un monedero "real":
Almacena un saldo en euros, que el usuario puede utilizar para pagar otros servicios.
El usuario puede recargar dinero desde una pasarela de pago de terceros (stripe, paypal, redsys ...).
No hay posibilidad de devolver este dinero al medio de pago original.

La estructura básica del bolso es su identificador y su saldo actual. Si crees que necesitas más campos,
agréguelos sin problemas y los discutiremos en la entrevista.

El ejercicio consiste en programar puntos finales para:
Consulte un comprobante para su identificador.
Descuento el saldo de la cartera (un cargo).
Devuelva el saldo a la billetera (un reembolso).
Recargue dinero en ese bono a través de un servicio de pago de terceros.

Para que pueda llegar al punto, le damos un proyecto maven con una aplicación Spring Boot, con las dependencias básicas y un
Base de datos H2. Tienes perfiles de desarrollador y prueba.

También tiene una implementación de servicio que implementaría la pasarela de pago real (ThirdPartyPaymentService).
Esa parte que no tiene que programar, suponga que el servicio realiza la llamada remota dada una cantidad de dinero.
Está destinado a devolver el error bajo ciertas condiciones.

# technical-vector-test-backend
