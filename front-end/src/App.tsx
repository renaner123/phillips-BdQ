import './App.css';
import { BrowserRouter, BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import NavbarComponent from './components/Navbar';

import Register from './pages/Register';
import Login from './pages/Login';
import FileList from './pages/FileList';
import 'bootstrap/dist/css/bootstrap.min.css';
import './styleSheet/index.scss';
import Home from './pages/Home';
import QuestionsCount from "./services/QuestionsCount";
import { useState } from 'react';

// Inserir no banco de dados um recurso para retornar a quantidade de questões que o banco de dados possui para mostrar aqui



function App() {
  const [data, setData] = useState<any>(null);
  return (
    <div>
      <QuestionsCount setData={setData} />
      <NavbarComponent/>
      <script>
      console.log(data)
      </script>
      <BrowserRouter>
            <Routes>            
              <Route path="/register" element= { <Register/>} />
              <Route path="/home" element= { <Home numQuestions={data}/>} />
              <Route path="/login" element= { <Login/>} />
              <Route path="/download" element= { <FileList/>} />
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
