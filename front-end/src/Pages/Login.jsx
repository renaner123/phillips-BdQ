import {  useState } from "react";
import { useNavigate } from 'react-router-dom';
import { Container, Row } from "react-bootstrap";
import axios from "axios";


function Login() {
   
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();


    async function login(event) {
        event.preventDefault();
        try {
          await axios.post("http://127.0.0.1:8080/auth/authenticate", {
            username: username,
            password: password,
            }).then((res) => 
            {
             if(res.status === 200)
             {                 
               navigate('/download');
             } 
              else 
             { 
                alert("Tratar erro");
             }
          }, fail => {
           console.error(fail); // Error!
  });
        } 
         catch (err) {
          alert(err);
        }
      
      } 
   
    return (
      <Container>
      <Row className="pt-3 justify-content-center">
          <div className="col-md-6 offset-mf-3 border rouded p-4 mt-2 shadow align-self-center">
              <h2 className="text-center m-4">Tela de Login</h2>
              {/* Form que precisa ser inserido para enviar informações ao Backend para efetuar o Login */}
              <div className="mb-3">
                  <label htmlFor="email" className="form-label">
                      E-mail
                  </label>
                  <input type={"username"} className="form-control" id="username" placeholder="Informe o seu e-mail"
                      name="email" 
                  value={username}
                  onChange={(event) => {
                    setUsername(event.target.value);
                  }}   
                      
                      />
              </div>
              <div className="mb-3">
                  <label htmlFor="password" className="form-label" >
                      Senha
                  </label>
                  <input type={"password"} className="form-control" id="password" placeholder="Informe a sua senha" name="password" 
                  value={password}
                  onChange={(event) => {
                    setPassword(event.target.value);
                  }} 
                  />
  
              </div>
              <button type="submit" className="btn btn-primary" onClick={login}>LOGIN</button>
  
              <h2 className="criesuaconta-login pt-3"><a href="#">Crie sua conta</a></h2>  
          </div>
      </Row>
  </Container>
    );


  }
  
  export default Login;