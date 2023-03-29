import './App.css';
import { BrowserRouter, BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import NavSideBarComponent from './components/NavSidebar';
import NavBarLogin from './components/NavbarLogin';

import Register from './pages/Register';
import Login from './pages/Login';
import FileList from './pages/FileList';
import 'bootstrap/dist/css/bootstrap.min.css';
import './styleSheet/index.scss';
import Home from './pages/Home';
import QuestionsCount from "./services/QuestionsCount";
import { useState } from 'react';
import Institutional from './pages/Institutional';

// FIXME para buscar a performance do STUDENT logado, é necessário pegar o ID do usuário que está logado pra passar no studentId

// NOTE a disposição dos menus está assim apenas para facilitar os testes. Será adicionado os devidos campos na área de cada ROLE


function App() {
  const [countQuestions, setCountQuestions] = useState<any>(null);
  const [countMaterials, setCountMaterials] = useState<any>(null);
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Institutional />}/>
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />

          <Route path='/index' element={<NavSideBarComponent />}>
            <Route path="/index/home" element={<Home numQuestions={countQuestions} numMaterials={countMaterials} />} />
            <Route path="/index/download" element={<FileList />} />
            <Route path="/index/upload" element={<UploadFiles />} />
            <Route path="/index/performance" element={<StudentTestResultTable studentId={1} />} />
          </Route>

        </Routes>
      </BrowserRouter>
    </>

  );
}

export default App


/*          <BrowserRouter>

        <Routes>
          <Route path='/' element={<NavSideBarComponent />}>
            <Route path="/home" element={<Home numQuestions={countQuestions} numMaterials={countMaterials} />} />
            <Route path="/download" element={<FileList />} />
            <Route path="/upload" element={<UploadFiles />} />
            <Route path="/register" element={<Register />} />
            <Route path="/login" element={<Login />} />
            <Route path="/performance" element={<StudentTestResultTable studentId={1} />} />
            <Route path="/institucional" element={ <Institutional/> } />
          </Route>


        </Routes>
      </BrowserRouter> */
