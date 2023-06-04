//variables
let campNumber = document.getElementById("campNumber");
let contraseña = document.getElementById("Contraseña");
let ConfiContraseña = document.getElementById("ConfiContraseña");
let botonIngresar = document.getElementById("botonIngresar");
let correo = document.getElementById("Correo");
let IdNombre = document.getElementById("IdNombre");
let direccion = document.getElementById("direccion");
let correoValido = true;
let nombreValido = true;
let direccionValida = true;
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
const URL_MAIN = 'http://127.0.0.1:8080/usuarios/';
let arrayValidarRegistro = [];



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

  if (!validarDireccion()) {
    NombreErrores += "<li>Escribe una dirección valida.</li>";
    alertErrorLogin.style.display = "block";
  } else {
    direccion.style.border = "solid thin green";
  }//if validarCorreo

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

  if (validarNombre() == true && validarCorreo() == true && validarNumero() == true && validarContrasena() == true && validarDireccion() == true) {
    let usuario = {
      nombre: IdNombre.value,
      domicilio: direccion.value,
      correo: correo.value,
      contrasena: contraseña.value,
      telefono: campNumber.value
    };

    async function obtenerDatos() {
      try {
        const response = await fetch(URL_MAIN, { method: 'get' });
        const json = await response.json();

        Array.from(json).forEach((item) => {
          arrayValidarRegistro.push(item);
        });

        return arrayValidarRegistro;

      } catch (err) {
        console.log(err);
      }
    }

    obtenerDatos().then((arrayValidarRegistro) => {
    

      if (validarUsuarioRegistrado(arrayValidarRegistro, usuario)) {
        fetch(URL_MAIN, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(usuario)
        }).then(response => response.json()).then(usuario => {
          
        }).catch((error) => {
          console.error('Error:', error);
        });

        alertExito.style.display = "block";
        IdNombre.value = "";
        correo.value = "";
        campNumber.value = "";
        contraseña.value = "";
        ConfiContraseña.value = "";
        correoLogin.focus();
        idTimeout = setTimeout(function () {
          alertExito.style.display = "none";
        }, 10000);
        arrayValidarRegistro = [];
      } else {
        NombreErrores = "<li>Este correo ya está registrado.</li>";
        alertErrorLogin.style.display = "block";
        alertErrorTextoLogin.insertAdjacentHTML("beforeend", NombreErrores);
        correo.style.border = "solid thin red";
        arrayValidarRegistro = [];
      }
    });

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

function validarDireccion() {
  direccionValida = true;
  if (direccion.value < 8) {
    direccion.style.border = "solid thin red";
    direccionValida = false;
  } else {
    direccion.style.border = "solid thin green";
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
  if (/^(?!.*(.)\1{5})\d{10}$/.test(campNumber.value) == false) {
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

function validarUsuarioRegistrado(arrayValidarRegistro, usuario) {
  for (let i = 0; i < arrayValidarRegistro.length; i++) {
    if (arrayValidarRegistro[i].correo === usuario.correo) {
      return false;
    }
  }
  return true;
}

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

  validarUsuarioLogin(correoLogin.value, contraseñaLogin.value)
    .then((resultado) => {
      if (resultado) {
        
        window.location.replace("./loading.html");
      } else {
        mensajeError += "<li>Correo y/o contraseña incorrectos.</li>";
        errorLogin.style.display = "block";
        console.log("Correo ya registrado");

        correoLogin.style.border = "solid thin red";
        contraseñaLogin.style.border = "solid thin red";

        mensajeError += "</ul>";
        errorLoginTexto.insertAdjacentHTML("beforeend", mensajeError);
      }
    }).catch((error) => {
      console.log(error);
      // Manejar el error aquí
    });

});
async function validarUsuarioLogin(correo, contra) {
  try {
    const response = await fetch(URL_MAIN, { method: 'get' });
    const json = await response.json();

    for (let i = 0; i < json.length; i++) {
      if (json[i].correo === correo && json[i].contrasena === contra) {
        const idUsuario = json[i].id;
        localStorage.setItem("idUsuario", idUsuario);
        return true;
      }
    }
    return false;

  } catch (err) {
    console.log(err);
    return false;
  }
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

function mensajeInicio(nombreUsuario) {
  const mensaje = `¡Bienvenido, ${nombreUsuario}!`;
  return mensaje;
}//aquí se pone el mensaje mas el nombre del usuario