import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import './StyleSheet/index.scss';
import Login from './Pages/Login';
import NavbarComponent from './Components/Navbar';



function App() {
  return (
    <>
      <NavbarComponent />

      <Login />

    </>

  );
}

export default App;
