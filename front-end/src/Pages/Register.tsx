import axios from "axios";
import { useState } from "react";
import { Container, Row } from "react-bootstrap";

function Register() {

  const [name, setNome] = useState("");
  const [cpf, setCpf] = useState("");
  const [login, setLogin] = useState("");
  const [password, setPassword] = useState("");
  const [password2, setPassword2] = useState("");
  const [jobtype, setJobType] = useState("");

  /*     Não mexi nesse, usar como base para fazer o cadastro */
  /* 
  name:string
  cpf: string
  login: string
  password: string
  repeated_password
  opção-teacher, student, certifier
  
  */
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
    try {
      axios.post('http://localhost:8080/students', data, config)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });


    } catch (err) {
      alert(err);
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
              onChange={(event) =>{
                setNome(event.target.value);
              }}/>
            </div>

            <div className="mb-3">
              <label htmlFor="cpf" className="form-label">
                CPF
              </label>
              {/* VERIFICAR AQUI OS sets,onchanges entre outros   */}
              <input type="cpf" id="cpf" className="form-control" placeholder="Informe o seu CPF" name="cpf" value={cpf}
                onChange={(e) =>{
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
                onChange={(e)=>{
                  setLogin(e.target.value);
                }}
              />
            </div>

            <div className="mb-3">
              {/* VERIFICAR AQUI OS sets,onchanges entre outros   */}
              <label htmlFor="password" className="form-label">Senha</label>
              <input type="password" className="form-control" placeholder="Informe a sua senha" value={password}
                onChange={ (e) =>{
                  setPassword(e.target.value);
                }}
              />
            </div>

            <div className="mb-3">
              {/* REVISAR*/}
              <label htmlFor="password2" className="form-label">Repita a Senha</label>
              <input type="password2" className="form-control" placeholder="Informe novamente a sua senha - revisar" value={password2}
              onChange={ (e) =>{
                setPassword2(e.target.value);
              }}/>
            </div>
            {/* VERIFICAR AQUI OS sets,onchanges entre outros   */}
            <div className="form-floating">
              <select className="form-select" id="floatingSelect" aria-label="Floating label select example">
                <option selected>Selecione! </option>
                <option value="1">Professor</option>
                <option value="2">Certificador</option>
                <option value="3">Estudante/Aluno</option>
              </select>
              <label htmlFor="floatingSelect">Qual tipo de conta você deseja criar?</label>
            </div>
            {/* VERIFICAR AQUI OS sets,onchanges entre outros   */}
            <button type="submit" className="mt-3 btn btn-primary" onClick={save}>Criar a conta!</button>

          </div>
        </Row>
      </Container>

    </>


    /*

   <div>
     <div className="container mt-4" >
       <div className="card">
         <h1>Student Registation</h1>

         <form>
           <div className="form-group">
             <label>Employee name</label>
             <input type="text" className="form-control" id="employeename" placeholder="Enter Name"

               value={employeename}
               onChange={(event) => {
                 setEmployeename(event.target.value);
               }}
             />

           </div>

           <div className="form-group">
             <label>email</label>
             <input type="email" className="form-control" id="email" placeholder="Enter Email"

               value={email}
               onChange={(event) => {
                 setEmail(event.target.value);
               }}

             />

           </div>

           <div className="form-group">
             <label>password</label>
             <input type="password" className="form-control" id="password" placeholder="Enter password"

               value={password}
               onChange={(event) => {
                 setPassword(event.target.value);
               }}

             />
           </div>

           <button type="submit" className="btn btn-primary mt-4" onClick={save} >Save</button>

         </form>
       </div>
     </div>
   </div>


   */
  );
}

export default Register;


/*       <Container>
      <Row className="pt-3 justify-content-center">
        <div className="col-md-6 offset-mf-3 border rouded p-4 mt-2 shadow align-self-center">
          <h2 className="text-center m-4">Tela de Login</h2>
          {/* Form que precisa ser inserido para enviar informações ao Backend para efetuar o Login 
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
    
    */
