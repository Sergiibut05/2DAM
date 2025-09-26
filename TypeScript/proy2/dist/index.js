const botones = document.querySelectorAll("button");
const calculos = document.querySelector(".calcs");
let calc = "";
let memory = "";
let invalidState = false;
let result = -1;
let previusButton = "";
botones.forEach(boton => {
    boton.addEventListener("click", (btn) => {
        if (invalidState == true) {
            calc = "";
            invalidState = false;
        }
        switch (boton.dataset.type) {
            case "number":
            case "operation":
                calc += boton.textContent;
                console.log(calc);
                previusButton = "";
                break;
            case "action":
                if (boton.dataset.value == "AC") {
                    calc = "";
                    console.log(calc);
                    previusButton = "";
                }
                else if (boton.dataset.value == "delete") {
                    calc = calc.substring(0, calc.length - 1);
                    console.log(calc);
                    previusButton = "";
                }
                else if (boton.dataset.value == "M") {
                    if (previusButton == "M") {
                        memory = calc;
                        console.log(memory);
                    }
                    previusButton = "M";
                }
                else {
                    if (previusButton == "M") {
                        calc = memory;
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
                    previusButton = "";
                    console.log(calc);
                }
                break;
        }
        //Que se Actualice el .calcs
        calculos.textContent = calc || "0";
    });
});
export {};
//# sourceMappingURL=index.js.map