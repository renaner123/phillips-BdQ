import { useContext, useState } from "react";
import { Outlet, useNavigate } from 'react-router-dom';
import { Container, Row } from "react-bootstrap";
import axios, { AxiosResponse } from "axios";
import { config } from "../Constant";
import { AuthContext, User } from "../context/authContext";


type LoginData = {
  username: string,
  password: string
}


function Login() {
  const auth = useContext(AuthContext);
  const [state, setState] = useState<LoginData>({ username: '', password: '' });
  const navigate = useNavigate();

  const onUpdate = (e: React.ChangeEvent<any>, name: 'username' | 'password') => {
    setState((state) => ({ ...state, [name]: e.target.value }))
  }

  async function login(event: { preventDefault: () => void; }) {
    event.preventDefault();
    console.log(state.password + " aloan " + state.username);
    try {
      await axios.get<User>(`${config.url.BASE_URL}/auth/authenticate`,
        {
          headers: {
            'Content-Type': 'application/json',
            Authorization: 'Basic ' + btoa(state.username + ':' + state.password),
            Accept: 'application/json',
          }
          
        }).then(
          (res: AxiosResponse<User, any>) => {
            if (auth.updateUser) auth.updateUser(res.data);
            //console.log(res.data);
            if (res.status === 200) {
              navigate('/index');

            }
            else {
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
              name="username"
              value={state.username}
              onChange={(event) => {
                onUpdate(event, 'username');
              }}

            />
          </div>
          <div className="mb-3">
            <label htmlFor="password" className="form-label" >
              Senha
            </label>
            <input type={"password"} className="form-control" id="password" placeholder="Informe a sua senha" name="password"
              value={state.password}
              onChange={(event) => {
                onUpdate(event, 'password')
              }}
            />

          </div>
          <button type="submit" className="btn btn-primary" onClick={login}>LOGIN</button>

          <h2 className="criesuaconta-login pt-3"><a href="/register">Crie sua conta</a></h2>
        </div>
      </Row>
      <Outlet />
    </Container>

  );


}

export default Login;

/**
[
  {
    "timestamp": 1680210496.714609700,
    "status": 400,
    "error": "username",
    "message": "não deve estar em branco",
    "path": "/auth/authenticate"
  },
  {
    "timestamp": 1680210496.714609700,
    "status": 400,
    "error": "password",
    "message": "não deve estar em branco",
    "path": "/auth/authenticate"
  }]
   */