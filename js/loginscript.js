const form = document.getElementById('loginSubmit');

form.addEventListener("submit", (event) => {
   event.preventDefault();

const usuario = document.getElementById("userSend").value;
const contrasena = document.getElementById("passSend").value;

   if (usuario === "sebastian@correo.com" && contrasena === "12345") {
      alert("Inicio de sesión exitoso");
      location.href = "menu.html";
   }
   else{
      alert("Usuario o contraseña no corresponde");
   }
})