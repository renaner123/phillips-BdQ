import react from 'react';
import { Nav, NavDropdown } from 'react-bootstrap';
import Container from 'react-bootstrap/esm/Container';
import Navbar from 'react-bootstrap/Navbar';


export default function NavbarComponent() {
  return (
    // Está tudo no navbar apenas para facilitar os testes, precisa inserir a lógica de autenticação e quais páginas o usuário pode ver
    <Navbar bg="light" expand="lg">
      <Navbar.Brand className='mx-5' href="/">Ambiente - Teste</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
          <Nav.Link href="/index/home">Home</Nav.Link>
          <Nav.Link href="/index/performance">Performance</Nav.Link>
          <NavDropdown title="Materials" id="basic-nav-dropdown">
            <NavDropdown.Item href="/index/upload">
              Upload Materials
            </NavDropdown.Item>
            <NavDropdown.Divider />
            <NavDropdown.Item href="/index/download">
              All Materials
            </NavDropdown.Item>
          </NavDropdown>
          <Nav.Link href="/">Pagina Principal ou Sair</Nav.Link>
        </Nav>

      </Navbar.Collapse>

    </Navbar>
  )
}