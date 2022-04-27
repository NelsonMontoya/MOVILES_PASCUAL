
import './App.css';

const Persona =(props) =>{
  return(
  <>
    <h1>Nombre: {props.name}</h1>
    <h1>Apellido: {props.lastName}</h1>
    <h1>Edad: {props.age}</h1>
  </>
  )
}

const App = () => {
  return (
    <div className="App">
      <Persona name = "Juan" lastName = "Porras" age = "24"/>
      <Persona name = "Camilo" lastName= "Lopez" age = "24"/>
    </div>
  );
}

export default App;
