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
import StudentTestResultTable from './pages/PerfomanceStudent';
import UploadFiles from './pages/UploadFiles';
import Questions from './pages/Questions';

// FIXME para buscar a performance do STUDENT logado, é necessário pegar o ID do usuário que está logado pra passar no studentId
import Institutional from './pages/Institutional';
import MaterialsCount from './services/MaterialsCount';
import { AuthContext, User } from './context/authContext';
import TestListQuestion from './pages/TestListQuestion';

// NOTE a disposição dos menus está assim apenas para facilitar os testes. Será adicionado os devidos campos na área de cada ROLE

function App() {
  const [countQuestions, setCountQuestions] = useState<any>(null);
  const [countMaterials, setCountMaterials] = useState<any>(null);
  const [user, setUser] = useState<User>();
  return (
    <>
      <AuthContext.Provider value={{user, updateUser: setUser}}>

        <QuestionsCount setData={setCountQuestions} />
        <MaterialsCount setData={setCountMaterials} />
        <BrowserRouter>
          <Routes>
            <Route path='/' element={<Institutional />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path='/index' element={<NavSideBarComponent />}>
              <Route path="/index/home" element={<Home numQuestions={countQuestions} numMaterials={countMaterials} />} />
              <Route path="/index/questions" element={<Questions />} />
              <Route path="/index/download" element={<FileList />} />
              <Route path="/index/upload" element={<UploadFiles />} />
              <Route path="/index/list-questions" element={<TestListQuestion id={0} />} />
              <Route path="/index/performance" element={<StudentTestResultTable studentId={1} />} />
            </Route>
          </Routes>

        </BrowserRouter>
      </AuthContext.Provider>
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