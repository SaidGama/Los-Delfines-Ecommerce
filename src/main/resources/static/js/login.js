//variables
let campNumber = document.getElementById("campNumber");
let contraseña = document.getElementById("Contraseña");
let ConfiContraseña = document.getElementById("ConfiContraseña");
let botonIngresar = document.getElementById("botonIngresar");
let correo = document.getElementById("Correo");
let IdNombre = document.getElementById("IdNombre");
let correoValido = true;
let nombreValido = true;
let botonCrear = document.getElementById("botonCrear");
let alertErrorTextoLogin = document.getElementById("alertErrorTextoLogin");
let alertErrorLogin = document.getElementById("alertErrorLogin");
let alertExito = document.getElementById("alertExito");
let errorLogin = document.getElementById("errorLogin");
let errorLoginTexto = document.getElementById("errorLoginTexto");
let idTimeout;
let arrayUsuarios = [];
let correoLogin = document.getElementById("correoLogin");
let contraseñaLogin = document.getElementById("contraseñaLogin");
let alertInicioSesion = document.getElementById("alertInicioSesion");
let inicioSesionTexto = document.getElementById("inicioSesionTexto");
const URL_MAIN ='http://127.0.0.1:8080/api/usuarios/';

botonCrear.addEventListener("click", function (event) {
    event.preventDefault();
    clearTimeout(idTimeout);
    alertExito.style.display = "none";
    alertErrorTextoLogin.innerHTML = "";
    alertErrorLogin.style.display = "none";
    let NombreErrores = "Los siguientes campos deben ser llenados correctamente:<ul>";

    if (!validarNombre()) {
        NombreErrores += "<li>Escribe un nombre válido.</li>";
        alertErrorLogin.style.display = "block";
    } else {
        IdNombre.style.border = "solid thin green";
    }// if validarNombre



    if (!validarCorreo()) {
        NombreErrores += "<li>Escribe un correo válido.</li>";
        alertErrorLogin.style.display = "block";
    } else {
        correo.style.border = "solid thin green";
    }//if validarCorreo


    if (!validarNumero()) {
        NombreErrores += "<li>Escribe un número válido.</li>";
        alertErrorLogin.style.display = "block";
    } else {
        campNumber.style.border = "solid thin green";
    }//if validarCorreo


    if (!validarContrasena()) {
        NombreErrores += "<li>Escribe una contraseña válida.</li>";
        alertErrorLogin.style.display = "block";
    } else {
        contraseña.style.border = "solid thin green";
    }//if validarCorreo

    NombreErrores += "</ul>";
    alertErrorTextoLogin.insertAdjacentHTML("beforeend", NombreErrores);
    idTimeout = setTimeout(function () {
        alertErrorLogin.style.display = "none";
    }, 10000);

    if (validarNombre() == true && validarCorreo() == true && validarNumero() == true && validarContrasena() == true) {
        let usuario = {
            nombre: IdNombre.value, 
            domicilio: "desconocido",
            correo: correo.value, 
            contrasena: contraseña.value, 
            telefono: campNumber.value};
        
        if (validarUsuarioRegistrado(correo.value)) {
                fetch(URL_MAIN, {
                method: 'POST', // or 'PUT'
                headers: {
                    'Content-Type': 'application/json',
                },body: JSON.stringify(usuario)}).then(response => response.json()).then(usuario => {
                    console.log('Success:', usuario);
                }).catch((error) => {
                    console.error('Error:', error);
                });
                alertExito.style.display = "block";//Se muestra alerta de éxito
                IdNombre.value = "";//Se limpian campos...
                correo.value = "";
                campNumber.value = "";
                contraseña.value = "";
                ConfiContraseña.value = "";
                correoLogin.focus();//se agrega focus al campo del correo del login
                idTimeout = setTimeout(function () {
                    alertExito.style.display = "none";
                }, 10000);
        } else {
            NombreErrores = "<li>Este correo ya está registrado.</li>";
            alertErrorLogin.style.display = "block";
            alertErrorTextoLogin.insertAdjacentHTML("beforeend", NombreErrores);
            correo.style.border = "solid thin red";
        }
       
    }//mandar datos de registro
});
function validarNombre() {
    nombreValido = true;
    if (/^[a-zA-Z ]+$/.test(IdNombre.value) == false) {
        IdNombre.style.border = "solid thin red";
        nombreValido = false;
    } else {
        IdNombre.style.border = "solid thin green";
        return true;
    }
}
function validarCorreo() {
    correoValido = true;
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(correo.value) == false) {
        correo.style.border = "solid thin red";
        correoValido = false;
    } else {
        correo.style.border = "solid thin green";
        return true;
    }
}
function validarNumero() {
    if (/^(?!.*(.)\1{4})\d{10}$/.test(campNumber.value) == false) {
        campNumber.style.border = "solid thin red";
    } else {
        campNumber.style.border = "solid thin green";
        return true;
    }// if else
}// validarNumero
function validarContrasena() {
    if (/^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[a-z]).{8,}$/.test(contraseña.value) == false) {
        contraseña.style.border = "solid thin red";
        ConfiContraseña.style.border = "solid thin red";
    } else {
        contraseña.style.border = "solid thin green";
        if ((contraseña.value !== ConfiContraseña.value)) {
            ConfiContraseña.style.border = "solid thin red";
        } else {
            ConfiContraseña.style.border = "solid thin green";
            return true;//Se cambia posición del return para que no regrese tru hasta que ConfiContraseña este correcta
        }
    }//if else
}//validarContrasena

//Al menos una letra mayuscula, una minuscula, un número y que sea minimo de 8 digitos
/*/function confirmarContra () {
    console.log(contraseña.value);
    console.log(ConfiContraseña.value);
    if ((contraseña.value !== ConfiContraseña.value)) {
        ConfiContraseña.style.border = "solid thin red";
    } else {
        ConfiContraseña.style.border = "solid thin green";
        return true;
    }//if else
}// confirmarContra*/

function validarUsuarioRegistrado(correo) {
    fetch(URL_MAIN, { method: 'get' }).then(function(response) {
        response.json().then(function (json) {
           console.log(json);
           console.log(json.length);
            Array.from(json).forEach( (item) => {
                if (item.correo.includes(correo)) {
                    return false; // Se encontró el correo, por lo tanto no es válido
                 }
            }); // foreach
            
       });//then
    }).catch(function(err) {
       console.log(err);
    });
}
  



/* fetch(URL_MAIN, { method: 'get' }).then(function(response) {
    response.json().then(function (json) {
       console.log(json);
       console.log(json.length);
      Array.from(json).forEach( (item) => {
          addItem(item);
       }); // foreach
   });//then
}).catch(function(err) {
   console.log(err);
});


if (localStorage.getItem("arrayUsuarios") != null) {
    arrayUsuarios = JSON.parse(localStorage.getItem("arrayUsuarios"));
    for (let i = 0; i < arrayUsuarios.length; i++) {
        console.log(arrayUsuarios[i]);
        if (arrayUsuarios[i]["correo"].includes(correo)) {
            return false;
        }
    }
}
return true; */

function validarCorreoLogin() {
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(correoLogin.value) == false) {
        correoLogin.style.border = "solid thin red";
    } else {
        correoLogin.style.border = "solid thin green";
        return true;
    }
}
function validarContrasenaLogin() {
    if (/^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[a-z]).{8,}$/.test(contraseñaLogin.value) == false) {
        contraseñaLogin.style.border = "solid thin red";
    } else {
        contraseñaLogin.style.border = "solid thin green";
        return true;
    }//if else
}

botonIngresar.addEventListener("click", function (event) {
    event.preventDefault();
    errorLoginTexto.innerHTML = "";
    errorLogin.style.display = "none";
    let mensajeError = "Los siguientes campos deben ser llenados correctamente:<ul>";
    clearTimeout(idTimeout);
    if (validarUsuarioLogin(correoLogin.value, contraseñaLogin.value)) {
        console.log("INICIO DE SESION EXITOSO");
        window.location.replace("./loading.html");
    }else {
        mensajeError += "<li>Correo y/o contraseña incorrectos.</li>";
        errorLogin.style.display = "block";
        console.log("correo ya registrado");

        correoLogin.style.border = "solid thin red";
        contraseñaLogin.style.border = "solid thin red";
    }
    mensajeError += "</ul>";
    errorLoginTexto.insertAdjacentHTML("beforeend", mensajeError);

});//mandar datos de logeo

function validarUsuarioLogin(correo, contra) {
    let arrayUsuarios = [];
    fetch(URL_MAIN, { method: 'get' }).then(function(response) { response.json().then(function (json) {
           console.log(json);
           console.log(json.length);
           arrayUsuarios = json;
           for (let i = 0; i < arrayUsuarios.length; i++) {
            console.log(arrayUsuarios[i]);
            if ((arrayUsuarios[i].correo === (correo)) && (arrayUsuarios[i].contrasena === contra)) {
                return true;
            }
        }
        });//then
    }).catch(function(err) {
       console.log(err);
    });   
}

function obtenerUsuario(correo) {
    if (localStorage.getItem("arrayUsuarios") != null) {
      arrayUsuarios = JSON.parse(localStorage.getItem("arrayUsuarios"));
      for (let i = 0; i < arrayUsuarios.length; i++) {
        if (arrayUsuarios[i].correo === correo) {
          return arrayUsuarios[i];
        }
      }
    }
    return null;
  }//obtener usuario especifico con el correo

function mensajeInicio(nombreUsuario){
    const mensaje = `¡Bienvenido, ${nombreUsuario}!`;
    return mensaje;
}//aquí se pone el mensaje mas el nombre del usuario