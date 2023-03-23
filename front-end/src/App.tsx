import './App.css';
import { BrowserRouter, BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import NavbarComponent from './components/Navbar';

import Register from './pages/Register';
import Login from './pages/Login';
import FileList from './pages/FileList';
import 'bootstrap/dist/css/bootstrap.min.css';
import './styleSheet/index.scss';
import Home from './pages/Home';

// Inserir no banco de dados um recurso para retornar a quantidade de questões que o banco de dados possui para mostrar aqui

const numQuestions = 100; 

function App() {
  return (
    <div>
      <NavbarComponent/>
      <BrowserRouter>
            <Routes>            
              <Route path="/register" element= { <Register/>} />
              <Route path="/home" element= { <Home numQuestions={numQuestions}/>} />
              <Route path="/login" element= { <Login/>} />
              <Route path="/download" element= { <FileList/>} />
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
