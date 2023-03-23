import react from 'react';
import { Nav, NavDropdown } from 'react-bootstrap';
import Container from 'react-bootstrap/esm/Container';
import Navbar from 'react-bootstrap/Navbar';


export default function NavbarComponent() {
    return (
        // Está tudo no navbar apenas para facilitar os testes, precisa inserir a lógica de autenticação e quais páginas o usuário pode ver
        <Navbar bg="light" expand="lg">
        <Navbar.Brand href="/home">Banco de Questões</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="mr-auto">
            <Nav.Link href="/home">Home</Nav.Link>
            <Nav.Link href="/login">Login</Nav.Link>
            <Nav.Link href="/register">Register</Nav.Link>
          </Nav>
          <NavDropdown title="Materials" id="basic-nav-dropdown">
                <NavDropdown.Item href="#action/3.1">
                  Download Material 1
                </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.2">
                  Download Material 2
                </NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="/download">
                  All Materials
                </NavDropdown.Item>
              </NavDropdown>
        </Navbar.Collapse>
        
      </Navbar>
    )
}