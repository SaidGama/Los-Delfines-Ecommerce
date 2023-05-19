const idUsuario = localStorage.getItem("idUsuario");
let nombre;
let correo;
const URL_MAIN = `https://losdelfinesbackend-production.up.railway.app/api/usuarios/${idUsuario}`;

window.addEventListener("load", function (event) {
    getUsuario().then((resultado) => {
        if (resultado) {
          view();
        } else {
            console.log("error");
        }
    }).catch((error) => {
        console.log(error);
    });
});


async function getUsuario() {
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
} 


function view() {
    const itemHTML = `
        <div class = "micuenta">
            <h1>Has iniciado sesion como ${nombre}</h1>
            <h2>Correo electronico: ${correo}</h2>
        </div>`;
    const infocuenta = document.getElementById("infocuenta");
    infocuenta.innerHTML += itemHTML;
}