import { func } from 'prop-types';
import react, { useContext } from 'react';
import { Nav, NavDropdown } from 'react-bootstrap';
import Container from 'react-bootstrap/esm/Container';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';
import { AuthContext } from '../context/authContext';

type LinksData = {
  text: string
  path_link: string
}

type LoginInfoScreen = {
  text_name: string
  role: string
}

export type MenuNavBarData = {
  links: LinksData[]
  userScreen: LoginInfoScreen[]

}


export default function NavbarComponent({ links, userScreen }: MenuNavBarData) {
  const auth = useContext(AuthContext);

  function signOut() {
    if (auth.updateUser) auth.updateUser(undefined)
  }
  /** ROLE_TEACHER,
      ROLE_STUDENT,
      ROLE_CERTIFIER */
  return (
    // Está tudo no navbar apenas para facilitar os testes, precisa inserir a lógica de autenticação e quais páginas o usuário pode ver
    <Navbar bg="light" expand="lg">
      {userScreen.map((Roles, index1) => {
        let roleOption;
        if (Roles.role === "ROLE_TEACHER") {
          roleOption = "Professor";
        }
        if (Roles.role === "ROLE_STUDENT") {
          roleOption = "Aluno";
        }
        if (Roles.role === "ROLE_CERTIFIER") {
          roleOption = "Certificador";
        }

        return (
          <Navbar.Brand key={index1 + 1} className='mx-5' href="/">{roleOption}</Navbar.Brand>
        )
      })}

      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
          <>
            {links.map((itensNavBar, index2) => {
              return (
                <Link key={index2 + 1} className="nav-link" to={itensNavBar.path_link}>
                  {itensNavBar.text}
                </Link>
              )
            })}
          </>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  )
}
