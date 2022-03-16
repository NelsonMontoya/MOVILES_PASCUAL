let words = ['Enero','Febrero','Marzo','Abril'];
//words.splice(2,0,'Diciembre','Agosto');
//console.log(words);
// retirar del arreglo

//words.splice(2,3);
//console.log(words);

const esPar = (numero) => numero%2 == 0;

let imprimirResultado =(funcionPar, num) =>{
    const esParNumero = funcionPar(num);
    console.log(`El número ${num} es par: ${esParNumero}`);
}

imprimirResultado(esPar,8);


const numeros = [1,2,3,4,6,7,10,13];

const arregloAplicadoMetodo = numeros.filter((numero) => numero%2 == 0);
console.log(arregloAplicadoMetodo);

const meses = words.filter((mes)=>mes ==='Abril');
console.log(meses);

//

const Libros ={
    libroUno: {
        titulo : 'Javascript',
        autor : 'Pascual Bravo',
        añoPublicación: 2021,
        descripcion : 'Problemas JavaScript'
    },

    libroDos:{
        titulo : 'Python',
        autor : 'Pascual Bravo',
        añoPublicación: 2020,
        descripcion : 'Problemas Python'
    }
    
}

const libros = [Libros.libroUno,Libros.libroDos];
console.log(libros);

const libros20021 = libros.filter((libro)=>libro.añoPublicación===2021);
console.log(libros20021); 
