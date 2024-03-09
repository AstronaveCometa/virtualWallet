var resultado = 1000000;

let mostrarResultado = document.getElementById("resultado");
mostrarResultado.innerText = resultado;

const formularioNuevo = document.getElementById("nuevoContacto");
const formularioEnvio = document.getElementById("envioDinero");

function mostrarRegistroContacto (){
    $('#registroBloque').fadeIn();
}

formularioEnvio.addEventListener("submit", (event) => {
    event.preventDefault();

    let contactoNombre = document.getElementById("nombreContacto").value;
    let montoEnvio = document.getElementById('montoTransferencia').value;

if(montoEnvio > resultado){
    alert("Saldo insuficiente para la transferencia de fondos.")
} else {
    resultado = resultado - parseFloat(montoEnvio);

    alert(contactoNombre + " ha recibido el dinero exitosamente.");
    mostrarResultado.innerText = resultado;
}
})

formularioNuevo.addEventListener("submit", (event) => {
    event.preventDefault();

    let nuevoNombre = document.getElementById("nameContact").value;
    let nuevaCuenta = document.getElementById('numberContact').value;
    let nuevoBanco = document.getElementById("bankContact").value;

    alert("Nuevo contacto agregado exitosamente. Nombre: " + nuevoNombre + ". Cuenta: " + nuevaCuenta + " del banco " + nuevoBanco);
    formularioNuevo.reset();
    $('#registroBloque').fadeOut();
    return;
})

