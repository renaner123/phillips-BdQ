import React from "react";
import { Container, Row } from "react-bootstrap";

function Login() {
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
                        <input type={"text"} className="form-control" placeholder="Informe o seu e-mail"
                            name="email" />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="password" className="form-label" >
                            Senha
                        </label>
                        <input type={"password"} className="form-control" placeholder="Informe a sua senha" name="password" />

                    </div>
                    <button type="submit" className="btn btn-primary">LOGIN</button>

                    <h2 className="criesuaconta-login pt-3"><a href="#">Crie sua conta</a></h2>

                </div>
            </Row>
        </Container>

    );
}

export default Login;