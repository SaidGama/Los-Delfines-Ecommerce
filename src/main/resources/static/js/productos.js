// let produc1 = { "id": 1, "nombre": "Garrafón de Agua - 20lts", "precio": 25.00, "descripcion": {"descripcion1": "Relleno de garrafón con 20 lts de agua purificada", "detallesTec": "Rellenado de garrafón de 20 lts con agua purificada de alta calidad (Servicio en tienda o con entrega a domicilio)."}, "imagen": {"img1": "./productos_ima/garrafones cuadrados 20 litros.jpeg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};
// let produc2 = { "id": 2, "nombre": "Agua - 5lts", "precio": 27.50, "descripcion": {"descripcion1": "Botellón de 5lts con agua purificada", "detallesTec": "Botellón de 5lts desechable con agua purificada de alta calidad (Venta en tienda o con entrega a domicilio)."}, "imagen": {"img1": "./productos_ima/garrafon azul y rosa cuadricula se queda.jpeg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};
// let produc3 = { "id": 3, "nombre": "Agua - Pack 6pzs 1lt", "precio": 39.99,"descripcion": {"descripcion1": "Paquete con 6 botellas de 1lt (venta en tienda o entrega a domicilio).", "detallesTec": "Cada paquete contiene 6 botellas desechables de 1 lt  cada una.(Solo entrega a domicilio)"}, "imagen": {"img1": "./productos_ima/embotellada 1 litro.jpg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};
// let produc4 = { "id": 4, "nombre": "Agua - Pack 28pzs 500ml", "precio": 75.00, "descripcion": {"descripcion1": "Paquete con 28 botellas de 500 ml", "detallesTec": "Cada paquete contiene 28 botellas desechables de 500 ml cada una.(Solo entrega a domicilio)."}, "imagen": {"img1": "./productos_ima/botella500ml.jpeg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};
// let produc5 = { "id": 5, "nombre": "Agua - Pack 12pzs 330ml", "precio": 39.50, "descripcion": {"descripcion1": "Paquete con 12 botellas de 330 ml.", "detallesTec": "Cada paquete contiene 16 botellas desechables de 330 ml cada una.(Solo entrega a domicilio)."}, "imagen": {"img1": "./productos_ima/botellas300.jpeg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};
// let produc6 = { "id": 6, "nombre": "Filtro de agua", "precio": 109.95, "descripcion": {"descripcion1": "Filtro de agua portátil", "detallesTec": "Filtro plástico de agua. eliminador de sarro, portátil y de  fácil instalación (solo para insumo, no consumo)"}, "imagen": {"img1": "./productos_ima/filtro para hogar cuadrado.jpeg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};
// let produc7 = { "id": 7, "nombre": "Purificador de agua doméstico", "precio": 109.95, "descripcion": {"descripcion1": "Purificador de agua de cerámica", "detallesTec": "Purificador de agua hecho de cerámica. portable y de fácil instalación con capacidad de 1L."}, "imagen": {"img1": "./productos_ima/purificador de agua cuadrado.jpeg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};
// let produc8 = { "id": 8, "nombre": "Dispensador de agua clásico", "precio": 169.00, "descripcion": {"descripcion1": "Dispensador de agua Clásico de cerámica", "detallesTec": "Dispensador para agua, clásico, hecho de cerámica de alta calidad."}, "imagen": {"img1": "./productos_ima/dispensador de agua blanco se queda.jpeg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};
// let produc9 = { "id": 9, "nombre": "Dispensador de agua eléctrico", "precio": 149.99, "descripcion": {"descripcion1": "Dispensador eléctrico portátil de agua.", "detallesTec": "Dispensador de agua electrico portatil para garrafón, recargable mediante entrada USB, de fácil instalación"}, "imagen": {"img1": "./productos_ima/dispensador de agua para garrafon.jpg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};
// let produc10 = { "id": 10, "nombre": "Enfriador", "precio": 1190.00, "descripcion": {"descripcion1": "Enfriador de agua.", "detallesTec": "Base para garrafón dispensadora de agua, almacena y enfría el agua, dispensador en columna."}, "imagen": {"img1": "./imagenesProductos/enfriador.jpg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};
// let produc11 = { "id": 11, "nombre": "Botellón pet plástico 20lts", "precio": 110.00, "descripcion": {"descripcion1": "Botellón PET con 20 lts de capacidad.", "detallesTec": "Botellón Plástico PET desechable con 20 lts de capacidad."}, "imagen": {"img1": "./productos_ima/garrafon tamaño cuadricula se queda.jpeg", "img2": "#", "img3": "#" , "img4": "#"}, "stock": 1};



window.addEventListener("load", function (event) {
    addItems();
});

const URL_MAIN ='https://losdelfinesbackend-production.up.railway.app/productos/';
function addItems() {

   

    fetch(URL_MAIN, { method: 'get' }).then(function(response) {
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
     console.log(document.getElementById("div_Productos"));
   
}// addItems


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

