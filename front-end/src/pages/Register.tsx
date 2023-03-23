import axios from "axios";
import React, { useState } from "react";
import { Container, Row } from "react-bootstrap";

function Register() {

  const [name, setNome] = useState("");
  const [cpf, setCpf] = useState("");
  const [login, setLogin] = useState("");
  const [password, setPassword] = useState("");
  const [password2, setPassword2] = useState("");
  const [jobtype, setJobType] = useState("");

  async function save(event: any) {

    const data = {
      name: name,
      cpf: cpf,
      login: login,
      password: password,
      repeated_password: password2
    };

    const config = {
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Basic ${btoa(`${'renan'}:${'123'}`)}`,
        Accept: 'application/json',
      }
    };

    event.preventDefault();

    if (jobtype === "Certificador") {
      /* NOT WORKING preciso verificar como irei adc esse item               */
    }
    if (jobtype === "Professor") {
      try {
        axios.post('http://localhost:8080/teachers', data, config)
          .then((response) => {
            alert("Conta criada com sucesso");
            console.log(response.data);
          })
          .catch((error) => {
            console.log(error);
          });


      } catch (err) {
        alert(err);
      }
    }
    if (jobtype === "Estudante/Aluno") {
      try {
        axios.post('http://localhost:8080/students', data, config)
          .then((response) => {
            alert("Conta criada com sucesso");
            console.log(response.data);
          })
          .catch((error) => {
            console.log(error);
          });


      } catch (err) {
        alert(err);
      }
    }


  }


  return (
    <>
      <Container>
        <Row className="pt-3 justify-content-center">
          <div className="col-md-6 offset-mf-3 border rouded p-4 mt-2 shadow align-self-center">
            <h2 className="text-center m-4">Tela de Registro</h2>
            <div className="mb-3">
              <label htmlFor="name" className="form-label">
                Nome
              </label>
              {/* VERIFICAR AQUI OS sets,onchanges entre outros   */}
              <input type="text" id="name" className="form-control" placeholder="Digite seu e-mail" name="name" value={name}
                onChange={(event) => {
                  setNome(event.target.value);
                }} />
            </div>

            <div className="mb-3">
              <label htmlFor="cpf" className="form-label">
                CPF
              </label>
              {/* VERIFICAR AQUI OS sets,onchanges entre outros   */}
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
              {/* VERIFICAR AQUI OS sets,onchanges entre outros   */}
              <input type="email" className="form-control" placeholder="Informe o seu e-mail" name="email" value={login}
                onChange={(e) => {
                  setLogin(e.target.value);
                }}
              />
            </div>

            <div className="mb-3">
              {/* VERIFICAR AQUI OS sets,onchanges entre outros   */}
              <label htmlFor="password" className="form-label">Senha</label>
              <input type="password" className="form-control" placeholder="Informe a sua senha" value={password}
                onChange={(e) => {
                  setPassword(e.target.value);
                }}
              />
            </div>

            <div className="mb-3">
              {/* REVISAR*/}
              <label htmlFor="password2" className="form-label">Repita a Senha</label>
              <input type="password" className="form-control" placeholder="Informe novamente a sua senha - revisar" value={password2}
                onChange={(e) => {
                  setPassword2(e.target.value);
                }} />
            </div>
            {/* VERIFICAR AQUI OS sets,onchanges entre outros   */}
            <div className="form-floating">
              <select className="form-select" id="floatingSelect" aria-label="Floating label select example" value={jobtype}
                onChange={(e) => {
                  setJobType(e.target.value);
                }
                }>
                <option selected>Selecione! </option>
                <option value="Professor">Professor</option>
                <option value="Certificador">Certificador</option>
                <option value="Estudante/Aluno">Estudante/Aluno</option>
              </select>
              <label htmlFor="floatingSelect" >Qual tipo de conta você deseja criar?</label>
            </div>
            {/* VERIFICAR AQUI OS sets,onchanges entre outros   */}
            <button type="submit" className="mt-3 btn btn-primary" onClick={save}>Criar a conta!</button>

          </div>
        </Row>
      </Container>

    </>



  );
}

export default Register;

/*  function MySelect() {
  const [selectedValue, setSelectedValue] = useState('');

  const handleSelectChange = (event) => {
    setSelectedValue(event.target.value);
  };

  return (
    <div>
      <select value={selectedValue} onChange={handleSelectChange}>
        <option value="option1">Option 1</option>
        <option value="option2">Option 2</option>
        <option value="option3">Option 3</option>
      </select>
      <p>Selected value: {selectedValue}</p>
    </div>
  );
}  */