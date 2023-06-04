let idUsuario;
idUsuario = localStorage.getItem("idUsuario");
let mensaje = document.getElementById("mensaje");
let nombre;
let correo;
const URL_MAIN = `http://127.0.0.1:8080/usuarios/${idUsuario}`;
let botonCerrar = document.getElementById("botonCerrarSesion");




botonCerrar.addEventListener("click", function (event) {
    event.preventDefault();
    // Borrar el local storage
    localStorage.removeItem("idUsuario");

    // Recargar la página actual
    location.reload();
});

if (localStorage.getItem('idUsuario')) {
    window.addEventListener("load", function (event) {

        getUsuario().then((resultado) => {
            if (resultado) {
                view();
            } else {
              
            }
        }).catch((error) => {
            console.log(error);
        });
    });
} else {
    // La clave "idUsuario" no existe en el local storage
    
}


async function getUsuario() {
    /*  if(idUsuario!==null){ */
    try {
        const response = await fetch(URL_MAIN, { method: 'get' });
        const json = await response.json();
        nombre = json.nombre;
        correo = json.correo;
        return true;
    } catch (err) {
        console.log(err);
        return false;
    }
    /* } */
}


function view() {
    mensaje.style.display = "none";
    botonCerrar.style.display = "block";
    const itemHTML = `
        <div class = "micuenta">
            <h1>Has iniciado sesion como ${nombre}</h1>
            <h2>Correo electronico: ${correo}</h2>
            
        </div>`;
    const infocuenta = document.getElementById("infocuenta");
    infocuenta.innerHTML += itemHTML;
}