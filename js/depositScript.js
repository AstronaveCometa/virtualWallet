var resultado = 1000000;



$("#resultado").text(resultado);

$(document).ready(function() {
    $("#boton").click(function(event) {
        event.preventDefault();

        var abono = parseFloat($("#abono").val());

if (!isNaN(abono) && !isNaN(resultado) && abono > 0) {
            resultado = abono + resultado;
            $("#resultado").text(resultado);
            console.log("ahora el saldo es " + resultado);
            alert("Depósito realizado exitosamente.")
        } else{
            $("#resultado").text("Por favor, ingrese números válidos.");
        }
    });
});