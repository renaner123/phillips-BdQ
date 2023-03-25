import './App.css';
import { BrowserRouter, BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import NavSideBarComponent from './components/NavSidebar';

import Register from './pages/Register';
import Login from './pages/Login';
import FileList from './pages/FileList';
import 'bootstrap/dist/css/bootstrap.min.css';
import './styleSheet/index.scss';
import Home from './pages/Home';
import QuestionsCount from "./services/QuestionsCount";
import { useState } from 'react';
import MaterialsCount from './services/MaterialsCount';
import StudentTestResultTable from './pages/PerfomanceStudent';

// FIXME para buscar a performance do STUDENT logado, é necessário pegar o ID do usuário que está logado pra passar no studentId

function App() {
  const [countQuestions, setCountQuestions] = useState<any>(null);
  const [countMaterials, setCountMaterials] = useState<any>(null);
  return (
    <>
      <QuestionsCount setData={setCountQuestions} />
      <MaterialsCount setData={setCountMaterials} />
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<NavSideBarComponent />}>
            <Route path="/home" element={<Home numQuestions={countQuestions} numMaterials={countMaterials} />} />
            <Route path="/download" element={<FileList />} />
            <Route path="/register" element={<Register />} />
            <Route path="/login" element={<Login />} />
            <Route path="/performance" element={<StudentTestResultTable studentId={1} />} />
          </Route>


        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App


/*     <div>
                  <NavbarComponent/>
    <SidebarComponent/>

      <SidebarComponent/>
      <QuestionsCount setData={setData} />

      <BrowserRouter>
        
            <Routes>            
              <Route path="/register" element= { <Register/>} />
              <Route path="/home" element= { <Home numQuestions={data}/>} />
              <Route path="/login" element= { <Login/>} />
              <Route path="/download" element= { <FileList/>} />
            </Routes>
        </BrowserRouter>
    </div>  */