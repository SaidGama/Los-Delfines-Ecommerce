// /* arreglo de productos */
// let produc1 = { "id": 1, "nombre": "Garrafón de Agua - 20lts", "precio": 25.00, "descripcion": {"descripcion1": "Relleno de garrafón con 20 lts de agua purificada", "detallesTec": "Rellenado de garrafón de 20 lts con agua purificada de alta calidad (Servicio en tienda o con entrega a domicilio)."}, "imagen": {"img1": "./productos_ima/garrafones cuadrados 20 litros.jpeg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};
// let produc2 = { "id": 2, "nombre": "Dispensador de agua clásico", "precio": 169.00, "descripcion": {"descripcion1": "Dispensador de agua Clásico de cerámica", "detallesTec": "Dispensador para agua, clásico, hecho de cerámica de alta calidad."}, "imagen": {"img1": "./productos_ima/dispensador de agua blanco se queda.jpeg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};
// let produc3 = { "id": 3, "nombre": "Dispensador de agua eléctrico", "precio": 149.99, "descripcion": {"descripcion1": "Dispensador eléctrico portátil de agua.", "detallesTec": "Dispensador de agua electrico portatil para garrafón, recargable mediante entrada USB, de fácil instalación"}, "imagen": {"img1": "./productos_ima/dispensador de agua para garrafon.jpg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};

// let arrayProductos = [];


// function addItem(item) {
//     const itemHTML = `
//     <div class = "cajitas container">
//     <div class="card h-100">
//         <img src="${item.imagen['img1']}" class="card-img-top" alt="imagen">
//         <div class="card-body">
//             <h5 class="card-title">${item.nombre}</h5>
//                 <p class="card-text text-justify">${item.descripcion['descripcion1']}</p>
//                 <div style=" align-items: center; justify-content: space-around;">
//                 <h5 class="card-title" style = "padding-left: 15px; padding-top: 8px;">$${item.precio}</h5>
//                 </div>
//         </div>
//     </div>
//     </div>`;
//     const productosDiv = document.getElementById("productosDiv");
//     productosDiv.innerHTML += itemHTML;
// }

// addItem(produc1);
// addItem(produc2);
// addItem(produc3);
const URL_MAIN = 'http://localhost:8080/usuarios/';

window.addEventListener('load', function() {
  const idUsuario = localStorage.getItem('idUsuario');

  if (idUsuario) {
    const URL_USUARIO = `${URL_MAIN}${idUsuario}`;
    getUsuario(URL_USUARIO)
      .then((nombre) => {
        if (nombre) {
          view(nombre);
        } else {

        }
      })
      .catch((error) => {
        console.log(error);
      });
  } else {
    const itemHTML = `<p>Inicia sesión para comprar👋</p>`;
    const notification = document.getElementById('notification');
    if (notification) {
      notification.innerHTML += itemHTML;
    }
  }
});

async function getUsuario(url) {
  try {
    const response = await fetch(url, { method: 'GET' });
    const json = await response.json();
    return json.nombre;
  } catch (err) {
    console.log(err);
    return false;
  }
}

function view(nombre) {
  const itemHTML = `<p>Bienvenido, ${nombre}👋 <br> Ya puedes comprar en la sección de Productos.</p>`;
  const notification = document.getElementById('notification');
  if (notification) {
    notification.innerHTML += itemHTML;
  }
}




