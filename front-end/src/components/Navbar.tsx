import { func } from 'prop-types';
import react, { useContext } from 'react';
import { Nav, NavDropdown } from 'react-bootstrap';
import Container from 'react-bootstrap/esm/Container';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';
import { AuthContext } from '../context/authContext';

type LinksData = {
  text: string
  path: string
}
type DropDownData = {
  text: string
  path: string
}

type LoginInfoScreen = {
  text_name: string
  role: string
}

export type MenuNavBarData = {
  links: LinksData[]
  userScreen: LoginInfoScreen[]
  dropDown: DropDownData[]
}


export default function NavbarComponent({ links, userScreen, dropDown }: MenuNavBarData) {
  const auth = useContext(AuthContext);

  function signOut() {
    if (auth.updateUser) auth.updateUser(undefined)
  }

  return (
    // Está tudo no navbar apenas para facilitar os testes, precisa inserir a lógica de autenticação e quais páginas o usuário pode ver
    <Navbar bg="light" expand="lg">
      {userScreen.map((Roles) => {
        return (
          <Navbar.Brand className='mx-5' href="/">{Roles.role}</Navbar.Brand>
        )
      })}

      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
          <>

            {links.map((itensNavBar) => {
              return (
                <>
                  <Nav.Link href={itensNavBar.path}>{itensNavBar.text}</Nav.Link>
                  <NavDropdown title="Materiais" id="basic-nav-dropdown">
                    <NavDropdown.Item href="/index/upload">
                      {itensNavBar.text}
                    </NavDropdown.Item>
                    <NavDropdown.Divider />
                    <NavDropdown.Item href={itensNavBar.path}>
                      {itensNavBar.text}
                    </NavDropdown.Item>
                  </NavDropdown>
                </>

              )

            })}



            {console.log("itensnavbar" + userScreen.length)}



            <Nav.Link href="/">Pagina Principal ou Sair</Nav.Link>
          </>
        </Nav>

      </Navbar.Collapse>

    </Navbar>
  )
}

/**    <Navbar bg="light" expand="lg">
      <Navbar.Brand className='mx-5' href="/">Ambiente - Teste</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
          <Nav.Link href="/index/home">Home</Nav.Link>
          <Nav.Link href="/index/performance">Performance</Nav.Link>
          <Nav.Link href="/index/questions">Questions</Nav.Link>
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

    </Navbar> */