const botonDepo = document.getElementById("buttonDeposit");
const botonSend = document.getElementById("buttonSend");
const botonTran = document.getElementById("buttonTransactions");

botonDepo.addEventListener("click", (event) => {
        event.preventDefault();
        location.href = "deposit.html";
 })

 botonSend.addEventListener("click", (event) => {
    event.preventDefault();
    location.href = "sendmoney.html";
})

botonTran.addEventListener("click", (event) => {
    event.preventDefault();
    location.href = "transactions.html";
})