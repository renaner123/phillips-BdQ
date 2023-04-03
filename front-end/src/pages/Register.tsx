import axios from 'axios';
import React, { useState } from 'react';
import { Button, Container, Row } from 'react-bootstrap';
import { config } from '../Constant';
import configHeader from '../services/ConfigHeader';

const Register = () => {
  const [tipoCadastro, setTipoCadastro] = useState('');

  const [name, setNome] = useState("");
  const [cpf, setCpf] = useState("");
  const [login, setLogin] = useState("");
  const [password, setPassword] = useState("");
  const [password2, setPassword2] = useState("");
  const [idDiscipline, setIdDiscipline] = useState("");

  const handleTipoCadastroChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    setTipoCadastro(event.target.value);
  };

  async function save(event: any) {

    const data = {
      name: name,
      cpf: cpf,
      login: login,
      password: password,
      repeated_password: password2
    };

    const dataTeacher = {
      name: name,
      cpf: cpf,
      login: login,
      password: password,
      repeated_password: password2,
      idDiscipline: idDiscipline
    };

    event.preventDefault();

    if (tipoCadastro === "certificador") {

      try {
        axios.post(`${config.url.BASE_URL}/certifiers`, dataTeacher, configHeader)
          .then((response) => {
            alert("Conta criada com sucesso");
            console.log(response.data);
          })
          .catch((error) => {
            if(error.response.status===409){
              alert(error.response.data['message'])
            }else if(error.response.status===400){
              alert(error.response.data[0]['message'])
            }
            console.log(error);    
          });


      } catch (err) {
        alert(err);
      }
    }

    if (tipoCadastro === "professor") {

      try {
        axios.post(`${config.url.BASE_URL}/teachers`, dataTeacher, configHeader)
          .then((response) => {
            alert("Conta criada com sucesso");
            console.log(response.data);
          })
          .catch((error) => {
            if(error.response.status===409){
              alert(error.response.data['message'])
            }else if(error.response.status===400){
              alert(error.response.data[0]['message'])
            }
            console.log(error);    
          });


      } catch (err) {
        alert(err);
      }
    }

    if (tipoCadastro === "estudante") {
      try {
        axios.post(`${config.url.BASE_URL}/students`, data, configHeader)
          .then((response) => {
            alert("Conta criada com sucesso");
            console.log(response.data);
          })
          .catch((error) => {       
            if(error.response.status===409){
              alert(error.response.data['message'])
            }else if(error.response.status===400){
              alert(error.response.data[0]['message'])
            }
            console.log(error);    
          });

      } catch (err) {
        alert(err);
      }
    }
  }

  // FIXME ver como reaproveitar o código. Está repetindo muito. Usar mesmo formulário e só adicionar o que falta

  const renderCamposCadastro = () => {

    switch (tipoCadastro) {
      case 'estudante':
        return (
          <Container>
            <Row className="pt-3 justify-content-center">
              <div>
                <div className="mb-3">
                  <label htmlFor="name" className="form-label">
                    Nome
                  </label>
                  <input type="text" id="name" className="form-control" placeholder="Digite seu e-mail" name="name" value={name}
                    onChange={(event) => {
                      setNome(event.target.value);
                    }} />
                </div>

                <div className="mb-3">
                  <label htmlFor="cpf" className="form-label">
                    CPF
                  </label>
                  <input type="cpf" id="cpf" className="form-control" placeholder="Informe o seu CPF" name="cpf" value={cpf}
                    onChange={(e) => {
                      setCpf(e.target.value);
                    }}
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="email" className="form-label">
                    E-mail
                  </label>
                  <input type="email" className="form-control" placeholder="Informe o seu e-mail" name="email" value={login}
                    onChange={(e) => {
                      setLogin(e.target.value);
                    }}
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="password" className="form-label">Senha</label>
                  <input type="password" className="form-control" placeholder="Informe a sua senha" value={password}
                    onChange={(e) => {
                      setPassword(e.target.value);
                    }}
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="password2" className="form-label">Repita a Senha</label>
                  <input type="password" className="form-control" placeholder="Informe novamente a sua senha - revisar" value={password2}
                    onChange={(e) => {
                      setPassword2(e.target.value);
                    }} />
                </div>
                <Row>
                  <div className="col-4">

                    <button type="submit" className="mt-3 btn btn-primary" onClick={save}>Criar a conta!</button>
                  </div>
                  <div className="col-4">
                    <Button type="submit" className="mt-3 btn btn-success" href='/login'>Login</Button>
                  </div>
                  <div className="col-4">

                    <Button type="submit" className="mt-3 btn btn-secondary" href='/'>Voltar</Button>
                  </div>
                </Row>
              </div>
            </Row>

          </Container>
        );
      case 'professor':
        return (
          <Container>
            <Row className="pt-3 justify-content-center">
              <div>
                <div className="mb-3">
                  <label htmlFor="name" className="form-label">
                    Nome
                  </label>
                  <input type="text" id="name" className="form-control" placeholder="Digite seu e-mail" name="name" value={name}
                    onChange={(event) => {
                      setNome(event.target.value);
                    }} />
                </div>

                <div className="mb-3">
                  <label htmlFor="cpf" className="form-label">
                    CPF
                  </label>
                  <input type="cpf" id="cpf" className="form-control" placeholder="Informe o seu CPF" name="cpf" value={cpf}
                    onChange={(e) => {
                      setCpf(e.target.value);
                    }}
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="email" className="form-label">
                    E-mail
                  </label>
                  <input type="email" className="form-control" placeholder="Informe o seu e-mail" name="email" value={login}
                    onChange={(e) => {
                      setLogin(e.target.value);
                    }}
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="password" className="form-label">Senha</label>
                  <input type="password" className="form-control" placeholder="Informe a sua senha" value={password}
                    onChange={(e) => {
                      setPassword(e.target.value);
                    }}
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="password2" className="form-label">Repita a Senha</label>
                  <input type="password" className="form-control" placeholder="Informe novamente a sua senha - revisar" value={password2}
                    onChange={(e) => {
                      setPassword2(e.target.value);
                    }} />
                </div>

                <div className="mb-3">
                  <label htmlFor="idDiscipline" className="form-label">ID da Disciplina</label>
                  <input type="number" className="form-control" placeholder="Digite o ID da disciplina ministrada" value={idDiscipline}
                    onChange={(e) => {
                      setIdDiscipline(e.target.value);
                    }} />
                </div>
                <Row>
                  <div className="col-4">

                    <button type="submit" className="mt-3 btn btn-primary" onClick={save}>Criar a conta!</button>
                  </div>
                  <div className="col-4">
                    <Button type="submit" className="mt-3 btn btn-success" href='/'>Login</Button>
                  </div>
                  <div className="col-4">
                    <Button type="submit" className="mt-3 btn btn-secondary" href='/'>Voltar</Button>
                  </div>
                </Row>
              </div>
            </Row>
          </Container>
        );
      case 'certificador':
        return (
          <Container>
            <Row className="pt-3 justify-content-center">
              <div>
                <div className="mb-3">
                  <label htmlFor="name" className="form-label">
                    Nome
                  </label>
                  <input type="text" id="name" className="form-control" placeholder="Digite seu e-mail" name="name" value={name}
                    onChange={(event) => {
                      setNome(event.target.value);
                    }} />
                </div>

                <div className="mb-3">
                  <label htmlFor="cpf" className="form-label">
                    CPF
                  </label>
                  <input type="cpf" id="cpf" className="form-control" placeholder="Informe o seu CPF" name="cpf" value={cpf}
                    onChange={(e) => {
                      setCpf(e.target.value);
                    }}
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="email" className="form-label">
                    E-mail
                  </label>
                  <input type="email" className="form-control" placeholder="Informe o seu e-mail" name="email" value={login}
                    onChange={(e) => {
                      setLogin(e.target.value);
                    }}
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="password" className="form-label">Senha</label>
                  <input type="password" className="form-control" placeholder="Informe a sua senha" value={password}
                    onChange={(e) => {
                      setPassword(e.target.value);
                    }}
                  />
                </div>

                <div className="mb-3">
                  <label htmlFor="password2" className="form-label">Repita a Senha</label>
                  <input type="password" className="form-control" placeholder="Informe novamente a sua senha - revisar" value={password2}
                    onChange={(e) => {
                      setPassword2(e.target.value);
                    }} />
                </div>

                <div className="mb-3">
                  <label htmlFor="idDiscipline" className="form-label">ID da Disciplina</label>
                  <input type="number" className="form-control" placeholder="Digite o ID da disciplina ministrada" value={idDiscipline}
                    onChange={(e) => {
                      setIdDiscipline(e.target.value);
                    }} />
                </div>
                <Row>
                  <div className="col-4">
                    <button type="submit" className="mt-3 btn btn-primary" onClick={save}>Criar a conta!</button>
                  </div>
                  <div className="col-4">
                    <Button type="submit" className="mt-3 btn btn-success" href='/login'>Login</Button>
                  </div>
                  <div className="col-4">
                    <Button type="submit" className="mt-3 btn btn-secondary" href='/'>Voltar</Button>
                  </div>
                </Row>
              </div>
            </Row>
          </Container>
        );
      default:
        // TODO inserir lógica para limpar o formulário
        return null;
    }
  };

  return (
    <Container>
      <Row className="pt-3 justify-content-center">
        <div className="col-md-6 offset-mf-3 rouded p-4 mt-2 shadow align-self-center">
          <form>
            <label htmlFor="tipoCadastro">Tipo de cadastro:  </label>
            <select className="form-select" id="tipoCadastro" value={tipoCadastro} onChange={handleTipoCadastroChange}>
              <option value="">Selecione</option>
              <option value="estudante">Estudante</option>
              <option value="professor">Professor</option>
              <option value="certificador">Certificador</option>
            </select>
            {renderCamposCadastro()}
          </form>
        </div>
      </Row>
    </Container>
  );
};

export default Register;
