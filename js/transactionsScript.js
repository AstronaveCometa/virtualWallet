let transactions = [{
    senderID: 123456,
    receiverID: 654321,
    monto: 10000,
    fecha: "15/04/2023"
},{
    senderID: 123456,
    receiverID: 444321,
    monto: 40000,
    fecha: "10/04/2023"
},{
    senderID: 123456,
    receiverID: 214353,
    monto: 15000,
    fecha: "15/01/2023"
},{
    senderID: 123456,
    receiverID: 221422,
    monto: 100000,
    fecha: "10/02/2023"
},{
    senderID: 543212,
    receiverID: 123456,
    monto: 105000,
    fecha: "15/04/2023"
},{
    senderID: 335353,
    receiverID: 123456,
    monto: 155000,
    fecha: "01/02/2023"
},{
    senderID: 335353,
    receiverID: 123456,
    monto: 150000,
    fecha: "02/03/2023"
}];

console.log(transactions);

let population = transactions.length;
console.log(population);

const tabla = document.getElementById("tabla");

for (i = 0; population > i; i++){
    let fila = document.createElement('tr');
    fila.innerHTML = '<td class="textoBlanco col">' + transactions[i].senderID +'</td>' +
    '<td class="textoBlanco col">' + transactions[i].receiverID +'</td>' + 
    '<td class="textoBlanco col">' + transactions[i].monto + '</td>' + 
    '<td class="textoBlanco col">' + transactions[i].fecha + '</td>';   
    tabla.appendChild(fila);
}

