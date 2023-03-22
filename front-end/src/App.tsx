import './App.css';
import { BrowserRouter, BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import NavbarComponent from './Components/Navbar';
import Home from './Pages/Home';
import Register from './Pages/Register';
import Login from './Pages/Login';
import FileList from './Pages/FileList';
import 'bootstrap/dist/css/bootstrap.min.css';
import './StyleSheet/index.scss';



function App() {
  return (
    <div>
      <NavbarComponent/>
      <BrowserRouter>
            <Routes>
              <Route path="/home" element= { <Home/>} />
              <Route path="/register" element= { <Register/>} />
              <Route path="/" element= { <Login/>} />
              <Route path="/download" element= { <FileList/>} />
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
