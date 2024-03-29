import { useContext, useState } from "react";
import { Outlet, useNavigate } from 'react-router-dom';
import { Button, Container, Row } from "react-bootstrap";
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
    const basicAuth = 'Basic ' + btoa(state.username + ':' + state.password)
    event.preventDefault();
    try {
      await axios.get<User>(`${config.url.BASE_URL}/auth/authenticate`,
        {
          headers: {
            'Content-Type': 'application/json',
            Authorization: basicAuth,
            Accept: 'application/json',
          }

        }).then(
          (res: AxiosResponse<User, any>) => {
            res.data.basicAuth = basicAuth
            if (auth.updateUser) auth.updateUser(res.data);
            if (res.status === 200) {
              navigate('/index/home');

            }
          }
        ).catch((error) => {

          alert("E-mail or password incorrect!")

          console.log(error);
        });;


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
          <div className="row">
            <div className="col-auto">
              <button type="submit" className="btn btn-primary" onClick={login}>Login</button>
            </div>
            <div className="col-auto">
              <Button type="submit" className="btn btn-secondary" href='/'>Home</Button>
            </div>
          </div>



          <h2 className="criesuaconta-login pt-3"><a href="/register">Crie sua conta</a></h2>
        </div>
      </Row>
      <Outlet />
    </Container>

  );


}

export default Login;

