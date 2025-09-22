
const botones = document.querySelectorAll("button");
let calc = "";
const calculos = document.querySelector(".calcs");

let result = -1;
botones.forEach(boton => {
  boton.addEventListener("click", () => {
    if (boton.dataset.type == "number" || boton.dataset.type == "operation"){
        calc += boton.textContent;
        console.log(calc);
    }else if(boton.dataset.value == "AC"){
        calc = "";
        console.log(calc);
    }else if (boton.dataset.value == "delete"){
        calc = calc.substring(0, calc.length-1);
        console.log(calc);
    }else{
        try{
            result = eval(calc);
            console.log(result);
            calculos!.textContent = result.toString();
        }catch (error){
            console.error(error);
            calculos!.textContent = "Error";
        }finally{
            calc = "";
        }
        
    }
    //Que se Actualice el .calcs
    if(boton.dataset.value != "="){
        calculos!.textContent = calc || "0";
    }
        

  });
});



