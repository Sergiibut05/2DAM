const botones = document.querySelectorAll("button");
let calc = "";
const calculos = document.querySelector(".calcs");
let invalidState = false;
let result = -1;
botones.forEach(boton => {
    boton.addEventListener("click", () => {
        if (invalidState == true) {
            calc = "";
            invalidState = false;
        }
        if (boton.dataset.type == "number" || boton.dataset.type == "operation") {
            calc += boton.textContent;
            console.log(calc);
        }
        else if (boton.dataset.value == "AC") {
            calc = "";
            console.log(calc);
        }
        else if (boton.dataset.value == "delete") {
            calc = calc.substring(0, calc.length - 1);
            console.log(calc);
        }
        else {
            try {
                result = eval(calc);
                if (isFinite(result) && !isNaN(result)) {
                    console.log(result);
                    calc = result.toString();
                }
                else {
                    calc = "Error";
                    invalidState = true;
                }
            }
            catch (error) {
                console.error(error);
                calculos.textContent = "Error";
            }
        }
        //Que se Actualice el .calcs
        calculos.textContent = calc || "0";
    });
});
export {};
//# sourceMappingURL=index.js.map