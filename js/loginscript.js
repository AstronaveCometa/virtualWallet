// $(document).ready(function() {
//     $("#login-form").submit(function(event) {
//       event.preventDefault(); // Evita que el formulario se envíe por defecto
  
//       // Capturar valores de login y password
//       var email = $("#userSend").val();
//       var password = $("#passSend").val();
  
//       // validar login y password
//         if(email=="cesar@gmail.com" && password=="c"){
//             location.href="menu.html";
//         }else{
//             alert("error");
//             console.log("error");
// }
//     });
//   });



const boton = document.getElementById("sendLogin");
const usuario = document.getElementById("userSend");
const contrasena = document.getElementById("passSend");

boton.addEventListener("click",function(event){
   event.preventDefault();

console.log(boton);
console.log(usuario);
console.log(contrasena);

   if (usuario === "sebastian@correo.com" && contrasena === "1234") {
       window.location.href = "/html/menu.html";
   }
   else{
      return;
   }
})