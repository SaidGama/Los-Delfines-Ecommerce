const idUsuario = localStorage.getItem("idUsuario");
let nombre; 
let correo;
const URL_MAIN = `http://127.0.0.1:8080/api/usuarios/${idUsuario}`;

window.addEventListener("load", function (event) {
    getUsuario().then( (resultado) => {
        if (resultado) {
            
        }else{
            console.log("error");
        }
    }).catch((error) => {
        console.log(error);
    });
});

function addItem(item) {
    const itemHTML = `
    <div class = "cajitas container">
    <div class="card h-100">
        <img src="${item.imagen}" class="card-img-top" alt="imagen">
        <div class="card-body">
            <h5 class="card-title">${item.nombre}</h5>
                <p class="card-text text-justify">${item.descripcion}</p>
                <p class="card-text text-justify">Stock: ${item.stock}</p>
                <div style="display: flex; align-items: center; justify-content: space-around;">
                <a href="#" class="btn btn-primary" id="botonAgregarCarrito">Agregar<br> al carrito</a>
                <h5 class="card-title" style = "padding-left: 15px; padding-top: 8px;">$${item.precio}</h5>
                </div>
        </div>
    </div>
    </div>`;
    const productosDiv = document.getElementById("productosDiv");
    productosDiv.innerHTML += itemHTML;
}

async function getUsuario( ) {
    try {
      const response = await fetch(URL_MAIN, { method: 'get' });
      const json = await response.json();
      nombre = json.nombre;
      correo = json.correo;
      return false;
  
    } catch (err) {
      console.log(err);
      return false;
    }
} 